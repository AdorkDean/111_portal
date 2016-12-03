package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.service.TMemberAccountManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.ucenter.Client;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.webapp.util.MD5;


public class RegisterAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private TMemberManager tmembermanager;
	private TMember tmember ;
	private TMemberAccountManager tmemberaccountmanager;
	private OpenSqlManage opensqlmanage;
	private TSysParameterManager tsysparametermanager;
	private TCouponCardManager tcouponcardmanager;
	private TCouponManager tcouponmanager;
	public TCouponManager getTcouponmanager() {
		return tcouponmanager;
	}
	public void setTcouponmanager(TCouponManager tcouponmanager) {
		this.tcouponmanager = tcouponmanager;
	}
	public TCouponCardManager getTcouponcardmanager() {
		return tcouponcardmanager;
	}
	public void setTcouponcardmanager(TCouponCardManager tcouponcardmanager) {
		this.tcouponcardmanager = tcouponcardmanager;
	}
	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}
	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}
	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}
	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}
	public TMemberAccountManager getTmemberaccountmanager() {
		return tmemberaccountmanager;
	}
	public void setTmemberaccountmanager(TMemberAccountManager tmemberaccountmanager) {
		this.tmemberaccountmanager = tmemberaccountmanager;
	}
	public TMember getTmember() {
		return tmember;
	}
	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}
	
	public String rindex(){
		
		return "register";
	}
	/*
	 * 邮箱注册
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void emailRegister() throws Exception{
		this.getResponse().setContentType("text/html; charset=utf-8");
		this.getRequest().setCharacterEncoding("utf-8");
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String captcha = this.getRequest().getParameter("captcha");
		String rand = (String) this.getSession().getAttribute("rand");
		TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		try {
			if(tmember==null){
				tmember=new TMember();
				if(!checkUserName(username)){
					flag=0;//用户已经存在
				}else if(!captcha.equalsIgnoreCase(rand)){
					flag=2;//验证码不正确
				}else{
				tmember.setUserName(username);
				tmember.setPassword(CustomDigestUtils.md5Hex(password, tmember));
				if(memberGrade1!=null){
					tmember.setMemberGradeId(memberGrade1.getId());
				}else{
					tmember.setMemberGradeId(memberGrade2.getId());
				}
				tmember.setAreaId(0l);
				tmember.setEmail(username);
				tmember.setStatus(0);
				tmember.setEnterpriseDiscount(new BigDecimal(0));
				tmember.setIsLeader(0);
				tmember.setIntegral(0);
				tmember.setSource(6);//6表示邮箱注册
				tmember.setPlatform(1);
				tmember.setRegisterIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setRegisterDate(new Date());
				tmember.setLastDate(new Date());
				tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setIsEmailCheck(1);
				tmember.setIsMobileCheck(0);
				tmember.setAgentId(getAgentId());
				tmember.setIsAgent(0);
				TLeader leader = getLeader();
				tmembermanager.insertSelective(tmember,leader);
				this.getSession().setAttribute("member", tmember);
				//uccenter注册
				try {
					Client uc = new Client();
					String $ucsynregister = uc.uc_user_register(username,password,tmember.getEmail());
					System.out.println($ucsynregister);
					int $uid = Integer.parseInt($ucsynregister);   
			        if ($uid <= 0) {   
			            if ($uid == -1) {   
			                System.out.print("用户名不合法");   
			            } else if ($uid == -2) {   
			                System.out.print("包含要允许注册的词语");   
			            } else if ($uid == -3) {   
			                System.out.print("用户名已经存在");   
			            } else if ($uid == -4) {   
			                System.out.print("Email 格式有误");   
			            } else if ($uid == -5) {   
			                System.out.print("Email 不允许注册");   
			            } else if ($uid == -6) {   
			                System.out.print("该 Email 已经被注册");   
			            } else {   
			                System.out.print("未定义");   
			            }   
			        } else {   
			            System.out.println("OK:" + $ucsynregister);   
			            out.print($ucsynregister);
			            out.close();
			        } 
				} catch (Exception e) {
					e.printStackTrace();
				}
				String cp = InfoUtil.getInstance().getInfo("config", "regCouponId");
				List regCouponMap = new ArrayList();
				String regCouponId="";
				Map map=new HashMap();
				if(cp!=null&&!cp.equals("")){
					String c[] = cp.split(",");
					for (int i = 0; i < c.length; i++) {
						regCouponId=c[i];
						map.put("regCouponId", regCouponId);
						TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(map, "t_coupon.selectCouponByid");
						regCouponMap.add(coupon);
					}
					tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
				}
				CookieUtil.addCookie(getRequest(), getResponse(), "username", username, 7*24*60*60, "/", ".111yao.com", false);
				flag=1;
				}
			}
		} catch (Exception e) {
			out.print("3");
			out.close();
			e.printStackTrace();
		}
		out.print(flag);
		out.close();
		System.out.println("===============");
	}
	/*
	 * 手机注册
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void mobileRegister() throws Exception{
		this.getResponse().setContentType("text/html; charset=utf-8");
		this.getRequest().setCharacterEncoding("utf-8");
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String mobile_jym = this.getRequest().getParameter("mobile_jym");
		String mobile_code = this.getRequest().getParameter("mobile_code");
		String amoblieCode = (String) MemCached.getmcc().get(username);
		//String amoblieCode=(String) this.getSession().getAttribute(username);
		String rand = (String) this.getSession().getAttribute("rand");
		TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		try {
			if(tmember==null){
				tmember=new TMember();
				if(!checkMobileUserName(username)){
					flag=0;//用户已经存在
				}else if(!mobile_jym.equalsIgnoreCase(rand)){
					flag=2;//验证码不正确
				}else if(!mobile_code.equalsIgnoreCase(amoblieCode)){//amoblieCode
					flag=3;//手机验证码
				}else{
				tmember.setUserName(username);
				tmember.setMobile(username);
				tmember.setPassword(CustomDigestUtils.md5Hex(password, tmember));
				if(memberGrade1!=null){
					tmember.setMemberGradeId(memberGrade1.getId());
				}else{
					tmember.setMemberGradeId(memberGrade2.getId());
				}
				tmember.setAreaId(0l);
				tmember.setStatus(0);
				tmember.setEnterpriseDiscount(new BigDecimal(0));
				tmember.setIsLeader(0);
				tmember.setIntegral(0);
				tmember.setSource(5);//5表示手机注册
				tmember.setPlatform(1);//1表示PC平台
				tmember.setRegisterIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setRegisterDate(new Date());
				tmember.setLastDate(new Date());
				tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setIsEmailCheck(0);
				tmember.setIsMobileCheck(1);
				tmember.setAgentId(getAgentId());
				tmember.setIsAgent(0);
				TLeader leader = getLeader();
				tmembermanager.insertSelective(tmember,leader);
				this.getSession().setAttribute("member", tmember);
				//uccenter注册
				try {
					Client uc = new Client();
					String $ucsynregister = uc.uc_user_register(username,"dst123456","test@111yao.com");
					System.out.println($ucsynregister);
					int $uid = Integer.parseInt($ucsynregister);   
			        if ($uid <= 0) {   
			            if ($uid == -1) {   
			                System.out.print("用户名不合法");   
			            } else if ($uid == -2) {   
			                System.out.print("包含要允许注册的词语");   
			            } else if ($uid == -3) {   
			                System.out.print("用户名已经存在");   
			            } else if ($uid == -4) {   
			                System.out.print("Email 格式有误");   
			            } else if ($uid == -5) {   
			                System.out.print("Email 不允许注册");   
			            } else if ($uid == -6) {   
			                System.out.print("该 Email 已经被注册");   
			            } else {   
			                System.out.print("未定义");   
			            }   
			        } else {   
			            System.out.println("OK:" + $ucsynregister);   
			            out.print($ucsynregister);
			            out.close();
			        } 
				} catch (Exception e) {
					e.printStackTrace();
				}
				String cp = InfoUtil.getInstance().getInfo("config", "regCouponId");
				List regCouponMap = new ArrayList();
				String regCouponId="";
				Map map=new HashMap();
				if(cp!=null&&!cp.equals("")){
					String c[] = cp.split(",");
					for (int i = 0; i < c.length; i++) {
						regCouponId=c[i];
						map.put("regCouponId", regCouponId);
						TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(map, "t_coupon.selectCouponByid");
						regCouponMap.add(coupon);
					}
					tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
				}
				CookieUtil.addCookie(getRequest(), getResponse(), "username", username, 7*24*60*60, "/", ".111yao.com", false);
				flag=1;
				}
			}
		} catch (Exception e) {
			out.print("0");
			out.close();
			e.printStackTrace();
		}
		out.print(flag);
		out.close();
		System.out.println("===============");
	}
	/*
	 * 新用户注册
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void userRegister() throws Exception{
		this.getResponse().setContentType("text/html; charset=utf-8");
		this.getRequest().setCharacterEncoding("utf-8");
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String mobile = this.getRequest().getParameter("mobile");//手机号
		String mobile_code = this.getRequest().getParameter("mobilecode");
		String amoblieCode = (String) MemCached.getmcc().get(mobile);
		TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		try {
			if(tmember==null){
				tmember=new TMember();
				TMemberBaseMessageExt tmemberBaseMessageext=new TMemberBaseMessageExt();
				if(!checkMobileUserName(mobile)){
					flag=0;//手机号已经存在
				}else if(!checkUserName(username)){
					flag=3;//用户名已经存在
				}else if(!mobile_code.equalsIgnoreCase(amoblieCode)){//amoblieCode
					flag=2;//手机验证码不对
				}else{
				tmemberBaseMessageext.setNickName(username);
				tmember.setUserName(username);
				tmember.setMobile(mobile);
				tmember.setRegisterDate(new Date());
				tmember.setPassword(MD5.MD5("111"+password+"yao"));
				if(memberGrade1!=null){
					tmember.setMemberGradeId(memberGrade1.getId());
				}else{
					tmember.setMemberGradeId(memberGrade2.getId());
				}
				tmember.setAreaId(0l);
				tmember.setStatus(0);
				tmember.setEnterpriseDiscount(new BigDecimal(0));
				tmember.setIsLeader(0);
				tmember.setIntegral(0);
				tmember.setSource(5);//5表示手机注册
				tmember.setPlatform(1);//1表示PC平台
				tmember.setRegisterIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setLastDate(new Date());
				tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmember.setIsEmailCheck(0);
				tmember.setIsMobileCheck(1);
				tmember.setAgentId(getAgentId());
				tmember.setIsAgent(0);
				TLeader leader = getLeader();
				tmembermanager.insertSelective(tmember,leader);
				tmemberBaseMessageext.setMemberId(tmember.getId());
				tmembermanager.savetmemberbasemessageext(tmemberBaseMessageext);
				this.getSession().setAttribute("member", tmember);
				//uccenter注册
				try {
					Client uc = new Client();
					String $ucsynregister = uc.uc_user_register(username,"dst123456","test@111yao.com");
					System.out.println($ucsynregister);
					int $uid = Integer.parseInt($ucsynregister);   
			        if ($uid <= 0) {   
			            if ($uid == -1) {   
			                System.out.print("用户名不合法");   
			            } else if ($uid == -2) {   
			                System.out.print("包含要允许注册的词语");   
			            } else if ($uid == -3) {   
			                System.out.print("用户名已经存在");   
			            } else if ($uid == -4) {   
			                System.out.print("Email 格式有误");   
			            } else if ($uid == -5) {   
			                System.out.print("Email 不允许注册");   
			            } else if ($uid == -6) {   
			                System.out.print("该 Email 已经被注册");   
			            } else {   
			                System.out.print("未定义");   
			            }   
			        } else {   
			            System.out.println("OK:" + $ucsynregister);   
			            out.print($ucsynregister);
			            out.close();
			        } 
				} catch (Exception e) {
					e.printStackTrace();
				}
				String cp = InfoUtil.getInstance().getInfo("config", "regCouponId");
				List regCouponMap = new ArrayList();
				String regCouponId="";
				Map map=new HashMap();
				if(cp!=null&&!cp.equals("")){
					String c[] = cp.split(",");
					for (int i = 0; i < c.length; i++) {
						regCouponId=c[i];
						map.put("regCouponId", regCouponId);
						TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(map, "t_coupon.selectCouponByid");
						regCouponMap.add(coupon);
					}
					tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
				}
				flag=1;
				}
			}
		} catch (Exception e) {
			out.print("0");
			out.close();
			e.printStackTrace();
		}
		out.print(flag);
		out.close();
		System.out.println("===============");
	}
	/*
	 * 发送验证码
	 */
	public void validateMobileCode() throws Exception{
		String captcha = CodeUtil .getVcode(4);
		String mobile = this.getRequest().getParameter("mobile");
		MemCached.getmcc().set(mobile,captcha,new Date(1000*300));
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号 
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		if(mobile!=null &&  pattern.matcher(mobile).matches()){
			Map<String, String> map = new HashMap<String, String>();
			map.put("mobiles", mobile);
			map.put("smsContent", "您的111医药馆验证码:"+captcha+"。影视明星何政军先生推荐的中国好药房@111医药馆！");
			String YAO_GATEWAY_URL =tsysparametermanager.getKeys("sms");
			String buildRequestBySMS = ClientSubmit.buildRequestBySMS(map,YAO_GATEWAY_URL);
			System.out.println(buildRequestBySMS);
			System.out.println("您的手机验证码是:"+captcha);
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	public boolean checkUserName(String username) throws Exception{
		username = this.getRequest().getParameter("username");
		TMemberExample e = new TMemberExample();
		e.createCriteria().andUserNameEqualTo(username);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			return false;
		}
		return true;
	}
	public boolean checkMobileUserName(String username) throws Exception{
		username = this.getRequest().getParameter("mobile");
		TMemberExample e = new TMemberExample();
		e.createCriteria().andMobileEqualTo(username);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			return false;
		}
		return true;
	}
	
	/*
	 * 检查用户名是否存在
	 */
	public void checkUserNameIsExist() throws Exception{
		int flag=-1;
		String username = this.getRequest().getParameter("username");
		PrintWriter out =  this.getResponse().getWriter();
		TMemberExample e = new TMemberExample();
		e.createCriteria().andUserNameEqualTo(username);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 检查手机号是否存在
	 */
	public void checkMobileUserNameIsExist() throws Exception{
		int flag=-1;
		String mobile = this.getRequest().getParameter("mobile");
		PrintWriter out =  this.getResponse().getWriter();
		TMemberExample e = new TMemberExample();
		e.createCriteria().andMobileEqualTo(mobile);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 检查验证码是否正确
	 */
	public void checkCodeIsExist() throws Exception{
		int flag=-1;
		String code = this.getRequest().getParameter("code");
		PrintWriter out =  this.getResponse().getWriter();
		String rand = (String) this.getSession().getAttribute("rand");
		if(!code.equals(rand)){
			flag=0;//验证码不正确
		}
		out.print(flag);
		out.close();
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
	/*
	 * 转到成功页
	 */
	public String success(){
		return "success";
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
	 public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}


}
