package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.ICartManager;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TCouponCardManager;
import com.rc.portal.service.TCouponManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.ucenter.Client;
import com.rc.portal.ucenter.XMLHelper;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.util.cookieManager;
import com.rc.portal.vo.TCoupon;
import com.rc.portal.vo.TLeader;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.vo.TMemberGrade;
import com.rc.portal.webapp.util.MD5;

public class LoginAction extends BaseAction {
	private TMemberManager tmembermanager;
	private TMember tmember;
	private String redirectUrl;
	private ICartManager cartmanager;
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

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	private OpenSqlManage opensqlmanage;

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}

	private static final long serialVersionUID = 2123141313L;
	/**
	 * 用户名登录
	 */
	public void emailLogin() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String emailCode = this.getRequest().getParameter("emailCode");
		String rand = (String) this.getSession().getAttribute("rand");
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		map.put("user_name", username);
		mobileMap.put("mobile", username);
		int flag = -1;
		String $ucsynlogin ="";
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		if(member!=null){
			if (member.getStatus() == 0) {
				if (!emailCode.equalsIgnoreCase(rand)) {
					flag = 4;// 验证码不正确
				} else if (!CustomDigestUtils.md5Hex(password, member).equals(
						member.getPassword())) {
					flag = 3;// 输入的密码不正确
				} else if (username.equalsIgnoreCase(member.getUserName())) {
					member.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
					member.setLastDate(new Date());
					tmembermanager.updateByPrimaryKey(member);
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					this.getSession().setAttribute("member", member);
					//uccenter登录
					try {
						Client uc = new Client();
						String result = uc.uc_user_login(member.getUserName(),password);
						LinkedList<String> rs = XMLHelper.uc_unserialize(result); 
					if(rs.size()>0){  
					   int $uid = Integer.parseInt(rs.get(0)); 
						if($uid > 0) { 
						//同步Cookie信息
						this.getResponse().setCharacterEncoding("UTF-8");
						this.getResponse().addHeader("P3P"," CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
						Cookie auth = new Cookie("auth", uc.uc_authcode(password+"\t"+$uid , "ENCODE"));
						this.getResponse().addCookie(auth);
						auth.setDomain("localhost");
						Cookie user = new Cookie("Discuz_loginuser", member.getUserName());
						this.getResponse().addCookie(user);
						
						System.out.println("登录成功"); 
						$ucsynlogin = uc.uc_user_synlogin($uid); 
						System.out.println("登录成功"+$ucsynlogin);
						param.put("login", $ucsynlogin);
						flag=5;
						} else if($uid == -1) {   
						System.out.println("用户不存在,或者被删除");   
						} else if($uid == -2) {   
						System.out.println("密码错");   
						} else {   
						System.out.println("未定义");   
						}
						}else{   
						System.out.println("Login failed"); System.out.println(result);   
						}  
					} catch (Exception e) {
						e.printStackTrace();
					}
					String nickname = member.getNickName();
					if(nickname != null && !nickname.trim().equals(""))
					{
						CookieUtil.addCookie(getRequest(), getResponse(), "nickname", java.net.URLEncoder.encode(nickname, "utf-8"), 7*24*60*60, "/", "", false);
					}
					else
					{
						CookieUtil.addCookie(getRequest(), getResponse(), "username",  java.net.URLEncoder.encode(member.getUserName(), "utf-8"), 7*24*60*60, "/", "", false);
					}
				}
			}else{
				flag = 2;// 该帐户被停用
			}
		}else if(username != null && pattern.matcher(username).matches() && mobileMember!=null && mobileMember.getStatus() == 0){
			if (!emailCode.equalsIgnoreCase(rand)) {
				flag = 4;// 验证码不正确
			} else if (!CustomDigestUtils.md5Hex(password, mobileMember).equals(
					mobileMember.getPassword())) {
				flag = 3;// 输入的密码不正确
			}else{
				mobileMember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
				mobileMember.setLastDate(new Date());
				tmembermanager.updateByPrimaryKey(mobileMember);
				if(key!=null){
					cartmanager.synCart(mobileMember.getId(), key);
				}
				this.getSession().setAttribute("member", mobileMember);
				//uccenter登录
				try {
					Client uc = new Client();
					String result = uc.uc_user_login(mobileMember.getUserName(),password);
					LinkedList<String> rs = XMLHelper.uc_unserialize(result); 
				if(rs.size()>0){  
				   int $uid = Integer.parseInt(rs.get(0)); 
					if($uid > 0) { 
					//同步Cookie信息
					this.getResponse().setCharacterEncoding("UTF-8");
					this.getResponse().addHeader("P3P"," CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
					Cookie auth = new Cookie("auth", uc.uc_authcode(password+"\t"+$uid , "ENCODE"));
					this.getResponse().addCookie(auth);
					auth.setDomain("localhost");
					Cookie user = new Cookie("Discuz_loginuser", mobileMember.getUserName());
					this.getResponse().addCookie(user);
					System.out.println("登录成功"); 
					$ucsynlogin = uc.uc_user_synlogin($uid); 
					System.out.println("登录成功"+$ucsynlogin);
					param.put("login", $ucsynlogin);
					flag=5;
					} else if($uid == -1) {   
					System.out.println("用户不存在,或者被删除");   
					} else if($uid == -2) {   
					System.out.println("密码错");   
					} else {   
					System.out.println("未定义");   
					}
					}else{   
					System.out.println("Login failed"); System.out.println(result);   
					}  
				} catch (Exception e) {
					e.printStackTrace();
				}
				String nickname = mobileMember.getNickName();
				if(nickname != null && !nickname.trim().equals(""))
				{
					CookieUtil.addCookie(getRequest(), getResponse(), "nickname", java.net.URLEncoder.encode(nickname, "utf-8"), 7*24*60*60, "/", "", false);
				}
				else
				{
					CookieUtil.addCookie(getRequest(), getResponse(), "username",  java.net.URLEncoder.encode(mobileMember.getUserName(), "utf-8"), 7*24*60*60, "/", "", false);
				}
			}
		}else{
			flag = 1;// 用户不存在
		}
		param.put("flag", flag);
		System.out.println("flag-------->"+flag);
		this.writeObjectToResponse(param, ContentType.application_json);
	}

	/**
	 * 手机用户登录
	 */
	public void mobileLogin() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = this.getRequest().getParameter("username");
		String phoneCode = this.getRequest().getParameter("phoneCode");
		String smsCode = this.getRequest().getParameter("smsCode");
		String amoblieCode = (String) MemCached.getmcc().get(username);
		String rand = (String) this.getSession().getAttribute("rand");
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		Map<String,Object> param = new HashMap<String,Object>();
		map.put("mobile", username);
		int flag = -1;
		String $ucsynlogin ="";
		PrintWriter out = this.getResponse().getWriter();
		TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectMemberByMobile");
		TMemberGrade memberGrade1 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectDefaultGrade");
		TMemberGrade memberGrade2 = (TMemberGrade) opensqlmanage.selectObjectByObject(null, "t_member_grade.selectlowGrade");
		if (member == null) {
			tmember=new TMember();
			if(!phoneCode.equalsIgnoreCase(rand)){
				flag=2;//验证码不正确
			}else if(!smsCode.equalsIgnoreCase(amoblieCode)){//amoblieCode
				flag=3;//手机验证码
			}else{
			tmember.setUserName("p_"+username);
			tmember.setMobile(username);
			tmember.setPassword(CustomDigestUtils.md5Hex("dst111yao", tmember));
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
			Map couponMap=new HashMap();
			if(cp!=null&&!cp.equals("")){
				String c[] = cp.split(",");
				for (int i = 0; i < c.length; i++) {
					regCouponId=c[i];
					map.put("regCouponId", regCouponId);
					TCoupon coupon = (TCoupon) opensqlmanage.selectObjectByObject(couponMap, "t_coupon.selectCouponByid");
					regCouponMap.add(coupon);
				}
				tcouponcardmanager.bindingCoupon(regCouponMap,tmember.getId(), 1);
			}
			CookieUtil.addCookie(getRequest(), getResponse(), "username", username, 7*24*60*60, "/", "", false);
			flag=5;
			}
		} else {
			if (member.getStatus() == 0) {
				if (!phoneCode.equalsIgnoreCase(rand)) {
					flag = 4;// 验证码不正确
				} else if (!smsCode.equalsIgnoreCase(amoblieCode)) {//amoblieCode
					flag = 3;// 短信验证码不正确
				} else {
					member.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
					member.setLastDate(new Date());
					tmembermanager.updateByPrimaryKey(member);
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					String nickname = member.getNickName();
					this.getSession().setAttribute("member", member);
					//uccenter登录
					try {
						Client uc = new Client();
						String result = uc.uc_user_login(member.getUserName(),"dst123456");
						LinkedList<String> rs = XMLHelper.uc_unserialize(result); 
					if(rs.size()>0){  
					   int $uid = Integer.parseInt(rs.get(0)); 
						if($uid > 0) {   
						System.out.println("登录成功"); 
						$ucsynlogin = uc.uc_user_synlogin($uid);
						param.put("login", $ucsynlogin);
						flag=5;
						} else if($uid == -1) {   
						System.out.println("用户不存在,或者被删除");   
						} else if($uid == -2) {   
						System.out.println("密码错");   
						} else {   
						System.out.println("未定义");   
						}
						}else{   
						System.out.println("Login failed"); System.out.println(result);   
						}  
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(nickname != null && !nickname.trim().equals(""))
					{
						CookieUtil.addCookie(getRequest(), getResponse(), "nickname",java.net.URLEncoder.encode(nickname, "utf-8"), 7*24*60*60, "/", "", false);
					}
					else
					{
						CookieUtil.addCookie(getRequest(), getResponse(), "username",java.net.URLEncoder.encode(member.getUserName(), "utf-8"), 7*24*60*60, "/", "", false);
					}
				
				}
			}else{
				flag = 2;// 该帐户被停用
			}
		}
		param.put("flag", flag);
		System.out.println("flag-------->"+flag);
		this.writeObjectToResponse(param, ContentType.application_json);
	}

	/*
	 * 发送验证码
	 */
	public void validateMobileCode() throws Exception {
		String captcha = CodeUtil.getVcode(4);
		String username = this.getRequest().getParameter("username");
		String phoneCode = this.getRequest().getParameter("phoneCode");
		String rand = (String) this.getSession().getAttribute("rand");
		 MemCached.getmcc().set(username,captcha,new Date(1000*300));
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		if (username != null && pattern.matcher(username).matches()) {
			if(phoneCode.equalsIgnoreCase(rand)){
				try {
					Map<String, String> map = new HashMap<String, String>();
					map.put("mobiles", username);
					map.put("smsContent", "您的手机验证码是:"+captcha+"。要健康 要美丽 要时尚@111医药馆！");
					String YAO_GATEWAY_URL =tsysparametermanager.getKeys("sms");
					String buildRequestBySMS = ClientSubmit.buildRequestBySMS(map,YAO_GATEWAY_URL);
					System.out.println(buildRequestBySMS);
					flag = 0;
				} catch (Exception e) {
					flag = 1;
					e.printStackTrace();
				}
			}else{
				flag=2;
			}
		}else{
			flag=3;
		}
		out.print(flag);
		out.close();
	}
	public int checkUserNameIsExist() throws Exception{
		int flag=1;
		String username = this.getRequest().getParameter("username");
		TMemberExample e = new TMemberExample();
		e.createCriteria().andMobileEqualTo(username);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			flag=0;
		}
		return flag;
	}
/*----------------------------用户登录新规则----------------------------------*/	
	/*
	 * 用户登录
	 */
	public void userLogin() throws Exception{
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> emailMap = new HashMap<String, Object>();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String phoneCode =this.getRequest().getParameter("phoneCode");
		String rand = (String) this.getSession().getAttribute("rand");
		String key = cookieManager.getCookieValueByName(this.getRequest(), CartAction.cartKey);
		usermap.put("user_name", username);
		mobileMap.put("mobile", username);
		emailMap.put("email", username);
		int flag = -1;
		String $ucsynlogin ="";
		TMember member=null;
		TMember usermember = (TMember) opensqlmanage.selectObjectByObject(usermap,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		TMember emailMember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
		if(mobileMember==null && usermember!=null){
			member=usermember;
		}else if(mobileMember==null && emailMember!=null){
			member=emailMember;
		}else{
			member=mobileMember;
		}
		if(member!=null){
			String ipAddress = NetworkUtil.getIpAddress(this.getRequest());
			if (member.getStatus() == 0) {
				System.out.println(CustomDigestUtils.md5Hex(password, member));
				System.out.println(member.getPassword());
				System.out.println(MD5.MD5("111"+password+"yao"));
				
				if (!CustomDigestUtils.md5Hex(password, member).equals(member.getPassword()) && !MD5.MD5("111"+password+"yao").equals(member.getPassword())) {
					flag = 1;// 输入的密码不正确
					String object = (String) MemCached.getmcc().get(ipAddress);
					System.out.println(MD5.MD5(password+member.getRegisterDate()));
					if(object==null){
						MemCached.getmcc().set(ipAddress,"1",30);
					}else if(object.length()>=3){
						flag = 4;//密码输错三次弹出验证码
					}else{
						MemCached.getmcc().set(ipAddress,object+"1",30);
					}
				}else if(!phoneCode.equals(rand)&&!"".equals(phoneCode)){
					flag=6;//验证码不正确
				}else {
					MemCached.getmcc().delete(ipAddress);
					member.setPassword(MD5.MD5("111"+password+"yao"));
					member.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
					member.setLastDate(new Date());
					tmembermanager.updateByPrimaryKey(member);
					if(key!=null){
						cartmanager.synCart(member.getId(), key);
					}
					this.getSession().setAttribute("member", member);
				/*	//uccenter登录
					try {
						Client uc = new Client();
						String result = uc.uc_user_login(username,password);
						LinkedList<String> rs = XMLHelper.uc_unserialize(result); 
					if(rs.size()>0){  
					   int $uid = Integer.parseInt(rs.get(0)); 
						if($uid > 0) { 
						//同步Cookie信息
						this.getResponse().setCharacterEncoding("UTF-8");
						this.getResponse().addHeader("P3P"," CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
						Cookie auth = new Cookie("auth", uc.uc_authcode(password+"\t"+$uid , "ENCODE"));
						this.getResponse().addCookie(auth);
						auth.setDomain("localhost");
						Cookie user = new Cookie("Discuz_loginuser", username);
						this.getResponse().addCookie(user);
						
						System.out.println("登录成功"); 
						$ucsynlogin = uc.uc_user_synlogin($uid); 
						System.out.println("登录成功"+$ucsynlogin);
						param.put("login", $ucsynlogin);
						flag=5;
						} else if($uid == -1) {   
						System.out.println("用户不存在,或者被删除");   
						} else if($uid == -2) {   
						System.out.println("密码错");   
						} else {   
						System.out.println("未定义");   
						}
						}else{   
						System.out.println("Login failed"); System.out.println(result);   
						}  
					} catch (Exception e) {
						e.printStackTrace();
					}
						CookieUtil.addCookie(getRequest(), getResponse(), "username",  java.net.URLEncoder.encode(username, "utf-8"), 7*24*60*60, "/", "", false);*/
				}
			}else{
				flag = 2;// 该帐户被停用
			}
		}else{
			flag = 3;//用户不存在
		}
		param.put("flag", flag);
		System.out.println("flag-------->"+flag);
		this.writeObjectToResponse(param, ContentType.application_json);
	}
	
	/*
	 * 保存自动登录的cookie信息
	 */
	public void saveCookie(){
		Map<String, Object> usermap = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> emailMap = new HashMap<String, Object>();
		String username = this.getRequest().getParameter("username");
		usermap.put("user_name", username);
		mobileMap.put("mobile", username);
		emailMap.put("email", username);
		TMember member=null;
		TMember usermember = (TMember) opensqlmanage.selectObjectByObject(usermap,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		TMember emailMember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
		if(mobileMember==null && usermember!=null){
			member=usermember;
		}else if(mobileMember==null && emailMember!=null){
			member=emailMember;
		}else{
			member=mobileMember;
		}
		if(member!=null){
			CookieUtil.addCookie(getRequest(), getResponse(), "pcCookUsername", member.getUserName(), 7*24*60*60, "/", "", false);
			CookieUtil.addCookie(getRequest(), getResponse(), "pcCookPassword", member.getPassword(), 7*24*60*60, "/", "", false);
		}
	}
	
	/*
	 * 自动登录方法
	 */
	public void autoLogin(){
		 String username = CookieUtil.getCookie(this.getRequest(), "pcCookUsername");
	     String cookpassword = CookieUtil.getCookie(this.getRequest(), "pcCookPassword");
	     if(username!=null && !"".equals(username)){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("user_name", username);
				TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
				if(member!=null){
					String	cookpwd=member.getPassword();
					if(cookpassword!=null && cookpassword.equals(cookpwd)){
						this.getSession().setAttribute("member",member); 
					} 
				}
			}
	}
	
	
	/*
	 * 验证登录验证码
	 */
	public void validateCode() throws Exception{
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		Map<String, Object> usermap = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> emailMap = new HashMap<String, Object>();
		String phoneCode =this.getRequest().getParameter("phoneCode");
		String rand = (String) this.getSession().getAttribute("rand");
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		usermap.put("user_name", username);
		mobileMap.put("mobile", username);
		emailMap.put("email", username);
		TMember member=null;
		TMember usermember = (TMember) opensqlmanage.selectObjectByObject(usermap,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		TMember emailMember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
		if(mobileMember==null && usermember!=null){
			member=usermember;
		}else if(mobileMember==null && emailMember!=null){
			member=emailMember;
		}else{
			member=mobileMember;
		}
		if(member!=null){
			if (!CustomDigestUtils.md5Hex(password, member).equals(member.getPassword()) && !MD5.MD5(password+member.getRegisterDate()).equals(member.getPassword())) {
				flag=2;//密码不正确
			}
		}
		if(!phoneCode.equals(rand)){
			flag=1;//验证码不对
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 检查用户是否存在
	 */
	public void checkUserIsExist() throws Exception{
		int flag=1;
		PrintWriter out = this.getResponse().getWriter();
		String username = this.getRequest().getParameter("username");
		TMemberExample e1 = new TMemberExample();
		e1.createCriteria().andUserNameEqualTo(username);
		
		TMemberExample e2 = new TMemberExample();
		e2.createCriteria().andMobileEqualTo(username);
		
		TMemberExample e3 = new TMemberExample();
		e3.createCriteria().andEmailEqualTo(username);
		
		int uname = this.tmembermanager.countByExample(e1);
		int mobile = this.tmembermanager.countByExample(e2);
		int email = this.tmembermanager.countByExample(e3);
		if(uname > 0 || mobile > 0 || email > 0){
			flag=0;//说明用户存在
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
	/**
	 * 退出登录
	 */
	public String logout()
	{
		TMember member = (TMember)getSession().getAttribute("member");
		if(member!=null){
			String nickname = member.getNickName();
			if(nickname != null && !nickname.trim().equals(""))
			{
				CookieUtil.removeCookie(getRequest(), getResponse(), "nickname", "/", "");
			}
			else
			{
				CookieUtil.removeCookie(getRequest(), getResponse(), "username", "/", "");
			}
			CookieUtil.removeCookie(getRequest(), getResponse(), "pcCookUsername", "/", "");
			CookieUtil.removeCookie(getRequest(), getResponse(), "pcCookPassword", "/", "");
			this.getSession().removeAttribute("member");
		}
		return "logout";	
	 }
	
	public void home() throws IOException
	{
		getResponse().sendRedirect("/index.html");
	}
		
	/**
	 * 转到登录页面
	 */
	public String index() {
		String ipAddress = NetworkUtil.getIpAddress(this.getRequest());
		Object loginfailureCount = MemCached.getmcc().get(ipAddress);
		System.out.println(loginfailureCount);
		this.getRequest().setAttribute("loginfailureCount", loginfailureCount);
		return "login";
	}

	/**
	 * 转到登录页面
	 */
	public String oldindex() {
		String ipAddress = NetworkUtil.getIpAddress(this.getRequest());
		Object loginfailureCount = MemCached.getmcc().get(ipAddress);
		System.out.println(loginfailureCount);
		this.getRequest().setAttribute("loginfailureCount", loginfailureCount);
		return "oldlogin";
	}
	
	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	public ICartManager getCartmanager() {
		return cartmanager;
	}

	public void setCartmanager(ICartManager cartmanager) {
		this.cartmanager = cartmanager;
	}

	
}
