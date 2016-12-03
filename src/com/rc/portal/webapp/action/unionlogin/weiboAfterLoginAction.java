package com.rc.portal.webapp.action.unionlogin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TMemberThreeBindingManager;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberThreeBinding;
import com.rc.portal.webapp.action.CartAction;

public class weiboAfterLoginAction extends BaseAction{

	private static final long serialVersionUID = 2832104114942689382L;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
	private OpenSqlManage opensqlmanage;
	private TMember tmember;
	private ICartManager cartmanager;
	private TCouponCardManager tcouponcardmanager;
	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}

	public ICartManager getCartmanager() {
		return cartmanager;
	}

	public void setCartmanager(ICartManager cartmanager) {
		this.cartmanager = cartmanager;
	}

	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	public TMemberThreeBinding getMemberThreeBinding() {
		return memberThreeBinding;
	}

	public void setMemberThreeBinding(TMemberThreeBinding memberThreeBinding) {
		this.memberThreeBinding = memberThreeBinding;
	}

	public TMemberThreeBindingManager getTmemberthreebindingmanager() {
		return tmemberthreebindingmanager;
	}

	public void setTmemberthreebindingmanager(
			TMemberThreeBindingManager tmemberthreebindingmanager) {
		this.tmemberthreebindingmanager = tmemberthreebindingmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String weiboLogin() throws Exception{
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		String code = this.getRequest().getParameter("code");
		TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		try {
			if(code != null && !code.equals("")){
				//通过code获得access_token
				AccessToken accessToken = new Oauth().getAccessTokenByCode(code);
				//获取token
				String token = accessToken.getAccessToken();
				//获取access_token的剩余时间，单位是秒
				String expireIn = accessToken.getExpireIn();
				//获得用户的uid
				String uid = accessToken.getUid();
				getRequest().getSession().setAttribute("demo_openid", uid);
				String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "").replace("O", "X").replace("0", "U");
				if(token != null && !token.equals("")){
					Users users = new Users(token);
					Map map=new HashMap();
					map.put("binding_uuid", uid);
					memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map, "t_member_three_binding.ibatorgenerated_selectByBindingUuid");
					//通过uid获得用户信息
					User user = users.showUserById(uid);
					if(memberThreeBinding == null){
						//第一次登陆,设置用户信息
						tmember = new TMember();
						memberThreeBinding=new TMemberThreeBinding();
						String gender = user.getGender();
						if (gender.equals("f")) {
							tmember.setSex(2);
						} else {
							tmember.setSex(1);
						}
						tmember.setUserName(uid);
						tmember.setAreaId(0l);
						if(memberGrade1!=null){
							tmember.setMemberGradeId(memberGrade1.getId());
						}else{
							tmember.setMemberGradeId(memberGrade2.getId());
						}
						tmember.setPassword(CustomDigestUtils.md5Hex(uuid.substring(0, 5),tmember));
						tmember.setNickName(user.getName());
						tmember.setStatus(0);
						tmember.setEnterpriseDiscount(new BigDecimal(0));
						tmember.setIsLeader(0);
						tmember.setIntegral(0);
						tmember.setSource(3);//微博
						tmember.setPlatform(1);//1表示PC平台
						tmember.setRegisterIp(NetworkUtil.getIpAddress(this.getRequest()));
						tmember.setRegisterDate(new Date());
						tmember.setLastDate(new Date());
						tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
						tmember.setIsEmailCheck(0);
						tmember.setIsMobileCheck(0);
						tmember.setAgentId(getAgentId());
						tmember.setIsAgent(0);
						TLeader leader = getLeader();
						tmembermanager.insertSelective(tmember,leader);
						if (tmember != null) {
							memberThreeBinding.setMemberId(tmember.getId());
						}
						memberThreeBinding.setSource(3);
						memberThreeBinding.setCreateDate(new Date());
						memberThreeBinding.setBindingUuid(uid);
						tmembermanager.saveMemberThreeBinding(memberThreeBinding);
						if(key!=null){
							cartmanager.synCart(tmember.getId(), key);
						}
						this.getSession().setAttribute("member", tmember);
						//新用户送优惠券
						String cp = InfoUtil.getInstance().getInfo("config", "regCouponId");
						List regCouponMap = new ArrayList();
						String regCouponId="";
						Map couponMap=new HashMap();
						if(cp!=null&&!cp.equals("")){
							String c[] = cp.split(",");
							for (int i = 0; i < c.length; i++) {
								regCouponId=c[i];
								couponMap.put("regCouponId", regCouponId);
								TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(couponMap, "t_coupon.selectCouponByid");
								regCouponMap.add(coupon);
							}
							tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
						}
						String nickname = tmember.getNickName();
						if(nickname != null && !nickname.trim().equals(""))
						{
							CookieUtil.addCookie(getRequest(), getResponse(), "nickname", java.net.URLEncoder.encode(nickname, "utf-8"), 7*24*60*60, "/", "", false);
						}
						else
						{
							CookieUtil.addCookie(getRequest(), getResponse(), "username",java.net.URLEncoder.encode(tmember.getUserName(), "utf-8"), 7*24*60*60, "/", "", false);
						}
						String attribute = (String) this.getSession()
								.getAttribute("LoginRedirect");
						if (attribute == null) {
							return "popup" ;
						} else {
							this.getSession().removeAttribute("LoginRedirect");
							this.getResponse().sendRedirect(attribute);
						}
					}else{
						Map openmap=new HashMap();
						openmap.put("binding_uuid", uid);
						TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
						if(key!=null){
							cartmanager.synCart(member.getId(), key);
						}
						this.getSession().setAttribute("member", member);
						String nickname = member.getNickName();
						if(nickname != null && !nickname.trim().equals(""))
						{
							CookieUtil.addCookie(getRequest(), getResponse(), "nickname", java.net.URLEncoder.encode(nickname, "utf-8"), 7*24*60*60, "/", "", false);
						}
						else
						{
							CookieUtil.addCookie(getRequest(), getResponse(), "username",java.net.URLEncoder.encode(member.getUserName(), "utf-8"), 7*24*60*60, "/", "", false);
						}
						System.out.println(member);
						String attribute = (String)this.getSession().getAttribute("LoginRedirect");
						if(member.getMobile()==null || member.getMobile()==""){
							return "popup";
						}else{
							if(attribute == null){
								this.getResponse().sendRedirect("/index.html");
							}else{
								this.getSession().removeAttribute("LoginRedirect");
								this.getResponse().sendRedirect(attribute);
							}
						}
					}
				}else{
					return "index";
				}
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return "popup";
	}
	/*
	 * 领袖下线
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TLeader getLeader(){
		String code = CookieUtil.getCookie(this.getRequest(), "leader");//通过code，查找leader 
		Map map=new HashMap();
		map.put("code", code);
		TLeader tleader = (TLeader) opensqlmanage.selectObjectByObject(map, "t_leader.selectLeaderByCode");
		return tleader;
	}
	/*
	 * 获取代理人Id
	 */
	public Long getAgentId(){
		String code = CookieUtil.getCookie(this.getRequest(), "agent");//通过code，获取代理人Id
		if(code!=null){
			return Long.parseLong(code);
		}else{
			return null;
		}
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub
		
	}

}
