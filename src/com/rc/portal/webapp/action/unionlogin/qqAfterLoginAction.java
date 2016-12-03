package com.rc.portal.webapp.action.unionlogin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.Birthday;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TMemberThreeBindingManager;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.vo.TMemberThreeBinding;
import com.rc.portal.webapp.action.CartAction;
import com.rc.portal.webapp.util.MD5;

public class qqAfterLoginAction extends BaseAction {

	private static final long serialVersionUID = 89805656l;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	private OpenSqlManage opensqlmanage;
	private ICartManager cartmanager;
	private TCouponCardManager tcouponcardmanager;
	
	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}

	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}

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

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TMemberThreeBindingManager getTmemberthreebindingmanager() {
		return tmemberthreebindingmanager;
	}

	public void setTmemberthreebindingmanager(
			TMemberThreeBindingManager tmemberthreebindingmanager) {
		this.tmemberthreebindingmanager = tmemberthreebindingmanager;
	}

	public TMemberThreeBinding getMemberThreeBinding() {
		return memberThreeBinding;
	}

	public void setMemberThreeBinding(TMemberThreeBinding memberThreeBinding) {
		this.memberThreeBinding = memberThreeBinding;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	private TMember tmember;

	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String qqlogin() throws IOException {
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "").replace("O", "X").replace("0", "U");
		try {
			String accessToken = getAccessToken();
			// openID是QQ用户在当前App上的唯一标识，类似于QQ平台的QQ号，基本上所有的接口调用都依赖于用户的openID参数
			OpenID openIDObj = new OpenID(accessToken);
			String openID = openIDObj.getUserOpenID();
			getRequest().getSession().setAttribute("demo_openid", openID);
			Map map = new HashMap();
			map.put("binding_uuid", openID);
			// 根据openid判断用户信息是否已经存在
			memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map,"t_member_three_binding.ibatorgenerated_selectByBindingUuid");
			if (memberThreeBinding != null) {
				Map openmap = new HashMap();
				openmap.put("binding_uuid", openID);
				TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
				if(key!=null){
					cartmanager.synCart(member.getId(), key);
				}
				//this.getSession().setAttribute("member", member);
				System.out.println(member);
				String attribute = (String) this.getSession().getAttribute("LoginRedirect");
				this.getRequest().setAttribute("otherNickName", member.getNickName());
				if(member.getMobile()==null || member.getMobile()==""){
					return "popup";
				}else{
					this.getSession().setAttribute("member", member);
					if (attribute == null) {
						this.getResponse().sendRedirect("/index.html");
					} else {
						this.getSession().removeAttribute("LoginRedirect");
						this.getResponse().sendRedirect(attribute);
					}
				}
			} else {
				tmember = new TMember();
				TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
				TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
				TMemberBaseMessageExt tmemberBaseMessageext=new TMemberBaseMessageExt();
				memberThreeBinding = new TMemberThreeBinding();
				// 微博
				com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(accessToken, openID);
				com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo.getUserInfo();
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				tmember.setUserName(openID);
				if(userInfoBean.getRet() == 0){
					String headImg = userInfoBean.getAvatar().getAvatarURL100();
					tmemberBaseMessageext.setHeadPortrait(headImg);
					String nickname = userInfoBean.getNickname();
					tmemberBaseMessageext.setNickName(nickname);
					this.getRequest().setAttribute("otherNickName", nickname);
				}
				if (weiboUserInfoBean.getRet() == 0) {
					Birthday birthday = weiboUserInfoBean.getBirthday();
					int year = birthday.getYear();
					int month = birthday.getMonth();
					int day = birthday.getDay();
					Calendar calendar = Calendar.getInstance();
					calendar.set(year, month + 1, day);
					Date date2 = calendar.getTime();
					tmemberBaseMessageext.setBirthday(date2);
					@SuppressWarnings("unused")
					String countryCode = weiboUserInfoBean.getCountryCode();
					String location = weiboUserInfoBean.getLocation();
					tmemberBaseMessageext.setAddress(location);
				}
				tmember.setAreaId(0l);
				if(memberGrade1!=null){
					tmember.setMemberGradeId(memberGrade1.getId());
				}else{
					tmember.setMemberGradeId(memberGrade2.getId());
				}
				tmember.setPassword(MD5.MD5("111"+uuid+"yao"));
				tmember.setStatus(0);
				tmember.setEnterpriseDiscount(new BigDecimal(0));
				tmember.setIsLeader(0);
				tmember.setIntegral(0);
				tmember.setSource(1);// QQ
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
				tmemberBaseMessageext.setMemberId(tmember.getId());
				tmembermanager.savetmemberbasemessageext(tmemberBaseMessageext);
				if (tmember != null) {
					memberThreeBinding.setMemberId(tmember.getId());
				}
				memberThreeBinding.setSource(1);
				memberThreeBinding.setCreateDate(new Date());
				memberThreeBinding.setBindingUuid(openID);
				tmembermanager.saveMemberThreeBinding(memberThreeBinding);
				if(key!=null){
					cartmanager.synCart(tmember.getId(), key);
				}
				//this.getSession().setAttribute("member", tmember);
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
				String attribute = (String) this.getSession().getAttribute("LoginRedirect");
				if(tmember.getMobile()==null || tmember.getMobile()==""){
					return "popup";
				}else{
					this.getSession().setAttribute("member", tmember);
					if (attribute == null) {
						this.getResponse().sendRedirect("/index.html");
					} else {
						this.getSession().removeAttribute("LoginRedirect");
						this.getResponse().sendRedirect(attribute);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
		return "index";
	}

	/*
	 * 绑定手机号
	 */
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public void bindingMobile() throws Exception {
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		String mobile = this.getRequest().getParameter("moblie");
		String password = this.getRequest().getParameter("password");
		String smsCode = this.getRequest().getParameter("smsCode");
		String code = (String) this.getSession().getAttribute("code");
		RegisterAction rg = new RegisterAction();
		String openId = (String) this.getRequest().getSession().getAttribute("demo_openid");
		Map map = new HashMap();
		map.put("binding_uuid", openId);
		// 根据openid判断用户信息是否已经存在
		memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map,"t_member_three_binding.ibatorgenerated_selectByBindingUuid");
		if(memberThreeBinding!=null){
			Map openmap = new HashMap();
			openmap.put("binding_uuid", openId);
			TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
			if (!rg.checkUserName(mobile)) {
				flag = 0;// 手机号已绑定,可直接登录
			}else if(!smsCode.equalsIgnoreCase(code)){
				flag =1;//验证码不正确
			}else{
				member.setUserName(mobile);
				member.setPassword(CustomDigestUtils.md5Hex(password, member));
				tmembermanager.updateByPrimaryKeySelective(member);
				flag=2;//转到首页
				this.getSession().setAttribute("member", tmember);
			};
		}else {
			flag=3;
		}
		out.print(flag);
		out.close();
	}*/

	/*
	 * getAccessToken
	 */
	public String getAccessToken() throws Exception {
		AccessToken accessTokenObj = (new Oauth())
				.getAccessTokenByRequest(getRequest());
		String accessToken = null;
		long tokenExpireIn = 0L;
		if (accessTokenObj.getAccessToken().equals("")) {
			Thread.sleep(3000);
			this.getResponse().sendRedirect("/index.html");
		} else {
			// 1、用来封装服务器返回的accessToken 等信息，包括accessToken，
			accessToken = accessTokenObj.getAccessToken();
			// 2、 accessToken的有效期，单位为秒
			tokenExpireIn = accessTokenObj.getExpireIn();
			getRequest().getSession().setAttribute("demo_access_token",
					accessToken);
			getRequest().getSession().setAttribute("demo_token_expirein",
					String.valueOf(tokenExpireIn));
			// 利用获取到的accessToken 去获取当前用的openid -------- start
			// 3、此类用来获取用户的openID信息！何为OpenID:
			return accessToken;
		}
		return null;
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
