package com.rc.portal.webapp.action.unionlogin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.payplugin.payYkt.PlusUtils;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
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

public class yktAfterLoginAction extends BaseAction{
	//private static final String salt="1a46710ba50b073ac2f6e00efe3899b5";//测试
	private static final String salt="688f7c8825a6a3d0ad2f6ecb705a496e";//正式
	private static final long serialVersionUID = 860314629835986505L;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
	private OpenSqlManage opensqlmanage;
	private ICartManager cartmanager;
	private TMember tmember;
	private TCouponCardManager tcouponcardmanager;
	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}

	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String yktlogin() {
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		String code = this.getRequest().getParameter("code");
		String cardNo=null;
	    String timestamp=null;
	    String homeToken=null;
		String token = this.getRequest().getParameter("token");
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();//解码code获取cardNo和timestamp
		try {  
	            byte[] b = decoder.decodeBuffer(code); 
	           String dcode= new String(b);
	           System.out.println(dcode); 
	           String a[] = dcode.split("\\+");  
		       cardNo=a[0];
		       timestamp=a[1];
		       String md5Token = new StringBuffer(cardNo).append(salt).append(timestamp).toString();
		       homeToken=PlusUtils.getMD5Str(md5Token);
		       getRequest().getSession().setAttribute("demo_openid", cardNo);
	           System.out.println("cardNo:"+cardNo);
	           System.out.println("timestamp:"+timestamp);
	        } catch (Exception e) {  
	        	e.getStackTrace();
	        } 
		System.out.println("code:"+code);
		try {
			if (homeToken.equals(token)&& (Math.abs(Long.valueOf(timestamp)-(System.currentTimeMillis()/1000))<600000)) {
				Map map=new HashMap();
				map.put("binding_uuid", cardNo);
				// 根据openid判断用户信息是否已经存在
				memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map, "t_member_three_binding.ibatorgenerated_selectByBindingUuid");
				if (memberThreeBinding == null) {
					memberThreeBinding=new TMemberThreeBinding();
					tmember = new TMember();
					TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
					TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
					TMemberBaseMessageExt tmemberBaseMessageext=new TMemberBaseMessageExt();
					tmemberBaseMessageext.setNickName("ykt"+cardNo);
					tmember.setAreaId(0l);
					if(memberGrade1!=null){
						tmember.setMemberGradeId(memberGrade1.getId());
					}else{
						tmember.setMemberGradeId(memberGrade2.getId());
					}
					tmember.setUserName("ykt"+cardNo);
					tmember.setPassword(MD5.MD5("111"+code+"yao"));
					tmember.setStatus(0);
					tmember.setEnterpriseDiscount(new BigDecimal(0));
					tmember.setIsLeader(0);
					tmember.setIntegral(0);
					tmember.setSource(4);//4表示医卡通
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
					memberThreeBinding.setSource(4);//医卡通
					memberThreeBinding.setCreateDate(new Date());
					memberThreeBinding.setBindingUuid(cardNo);
					tmembermanager.saveMemberThreeBinding(memberThreeBinding);
					if(key!=null){
						cartmanager.synCart(tmember.getId(), key);
					}
					//this.getSession().setAttribute("member", tmember);
					this.getRequest().setAttribute("otherNickName", "ykt"+cardNo);//存nickname
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
					CookieUtil.addCookie(getRequest(), getResponse(), "username", tmember.getUserName(), 7*24*60*60, "/", ".111yao.com", false);
					String attribute = (String) this.getSession()
							.getAttribute("LoginRedirect");
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
				} else {
					Map openmap=new HashMap();
					openmap.put("binding_uuid", cardNo);
					TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					this.getRequest().setAttribute("otherNickName", member.getNickName());//存nickname
					//this.getSession().setAttribute("member", member);
					CookieUtil.addCookie(getRequest(), getResponse(), "username", member.getUserName(), 7*24*60*60, "/", ".111yao.com", false);
					System.out.println(member);
					String attribute = (String) this.getSession().getAttribute("LoginRedirect");
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
				}
			}else{
				System.out.println("返回错误   没有获取到openid");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
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
	public static void main(String[] args) {
		String code = "0109551815029674+1441792721";
		String cardNo="0109551815029674";
		String timestamp="1441794553";
		String salt="688f7c8825a6a3d0ad2f6ecb705a496e";
		String token="=c98b3f60b3fa479ca919c7434ebf0c51";
		/*String encode = new sun.misc.BASE64Encoder().encode(code.getBytes());
		System.out.println(encode);
		 sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		 try {  
	            byte[] b = decoder.decodeBuffer(encode); 
	           String dcode= new String(b);
	           String a[] = dcode.split("\\+");  
	           String cardNo=a[0];
	           String timestamp=a[1];
	           System.out.println("cardNo:"+cardNo);
	           System.out.println("timestamp:"+timestamp);
	        } catch (Exception e) {  
	        	e.getStackTrace();
	        } 
		System.out.println(System.currentTimeMillis()/1000);*/
		String md5Token = new StringBuffer(cardNo).append(salt).append(timestamp).toString();
	       //PlusUtils.getMD5Str(md5Token);
	     System.out.println("1:--"+PlusUtils.getMD5Str(md5Token));
		System.out.println("2:--"+PlusUtils.getMD5Str(cardNo+salt+timestamp));
	}
}
