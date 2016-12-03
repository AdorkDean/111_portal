package com.rc.portal.webapp.action.unionlogin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.portal.alipay.util.AlipayNotify;
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

public class alipayReturnLoginAction extends BaseAction {

	private static final long serialVersionUID = 716293088099483404L;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
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

	private OpenSqlManage opensqlmanage;
	private TMember tmember;
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

	public void setTmemberthreebindingmanager(TMemberThreeBindingManager tmemberthreebindingmanager) {
		this.tmemberthreebindingmanager = tmemberthreebindingmanager;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String alipayAction() throws Exception {
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = this.getRequest().getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			System.out.println("-------------"+valueStr);
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			System.out.println("转码之后-------------"+valueStr);
			params.put(name, valueStr);
		}
		
		Map<String,String> paramsss = new HashMap<String,String>();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			System.out.println("-------------"+valueStr);
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			System.out.println("转码之后-------------"+valueStr);
			paramsss.put(name, valueStr);
		}

		for(Map.Entry<String, String > map:paramsss.entrySet()){
			System.out.println( "返回结果的key:"+map.getKey());
			System.out.println("返回结果的value:"+map.getValue());
		}
		
		boolean verify_result = false;
		boolean verify_result2 = false;
		verify_result = AlipayNotify.verify(params);
		System.out.println("verify_result------------"+verify_result);
		verify_result2 = AlipayNotify.verify(paramsss);
		System.out.println("verify_result2------------"+verify_result2);
		System.out.println("params参数------------>"+params);
		//验证成功
		if(verify_result || verify_result2){
			System.out.println("支付宝进入此方法当中-----------》");
			getRequest().getSession().setAttribute("demo_openid", params.get("user_id"));
			Map map=new HashMap();
			map.put("binding_uuid", params.get("user_id"));
			// 根据openid判断用户信息是否已经存在
			memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map, "t_member_three_binding.ibatorgenerated_selectByBindingUuid");
		       if(memberThreeBinding == null){
		    	   TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		   		   TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		    	   	memberThreeBinding=new TMemberThreeBinding();
		    	   	tmember = new TMember();
		    	   	TMemberBaseMessageExt tmemberBaseMessageext=new TMemberBaseMessageExt();
		    	   	tmemberBaseMessageext.setNickName(params.get("real_name"));
		    	   	this.getRequest().setAttribute("otherNickName", params.get("real_name"));
		    	   	tmember.setUserName(params.get("user_id"));
		    	   	tmember.setAreaId(0l);
		    	   	if(memberGrade1!=null){
						tmember.setMemberGradeId(memberGrade1.getId());
					}else{
						tmember.setMemberGradeId(memberGrade2.getId());
					}
					tmember.setPassword(MD5.MD5("111"+params.get("user_id")+"yao"));
					tmember.setNickName(params.get("real_name"));
					tmember.setStatus(0);
					tmember.setEnterpriseDiscount(new BigDecimal(0));
					tmember.setIsLeader(0);
					tmember.setIntegral(0);
					tmember.setSource(2);//支付宝
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
					memberThreeBinding.setSource(2);//支付宝
					memberThreeBinding.setCreateDate(new Date());
					memberThreeBinding.setBindingUuid(params.get("user_id"));
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
		     		 String attribute = (String)this.getSession().getAttribute("LoginRedirect");
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
		       }else{
		    	   System.out.println("进入此方法当中-----------》");
		    	   	Map openmap=new HashMap();
					openmap.put("binding_uuid", params.get("user_id"));
					TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					//this.getSession().setAttribute("member", member);
					System.out.println("用户名----------------》"+member.getUserName());
	           		String attribute = (String)this.getSession().getAttribute("LoginRedirect");
	           		this.getRequest().setAttribute("otherNickName", params.get("real_name"));
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
			System.out.println("验证失败");
			return "index";
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

}
