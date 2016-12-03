package com.rc.portal.webapp.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.mail.Mail;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.util.NetworkUtil;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.webapp.util.MD5;

public class FindPasswordAction extends BaseAction {
	private static final long serialVersionUID = 1654656456546L;
	private TMemberManager tmembermanager;
	private TMember tmember;
	private OpenSqlManage opensqlmanage;
	private TSysParameterManager tsysparametermanager;
	private Mail  mailSender;
	
	public Mail getMailSender() {
		return mailSender;
	}

	public void setMailSender(Mail mailSender) {
		this.mailSender = mailSender;
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

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}

	/*
	 * 发送验证码
	 */
	public void validateMobileCode() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		String captcha = CodeUtil.getVcode(4);
		String username = this.getRequest().getParameter("username");
		String rand = (String) this.getSession().getAttribute("rand");
		String inputCode = this.getRequest().getParameter("inputCode");
		 MemCached.getmcc().set("pc_"+username,captcha,new Date(1000*300));
		map.put("user_name", username);
		mobileMap.put("mobile", username);
		//this.getSession().setAttribute(username, captcha);
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		//TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
//		if (member != null) {
//			if (!inputCode.equalsIgnoreCase(rand)) {
//				flag = 1;// 输入的验证码不正确
//			} else if (member.getIsMobileCheck() != 1) {
//				flag = 2;// 该用户未绑定手机号
//			} else if (!pattern.matcher(member.getMobile()).matches()) {
//				flag = 3;// 手机格式不正确
//			}else{
//				Map<String, String> smsMap = new HashMap<String, String>();
//				smsMap.put("mobiles", member.getMobile());
//				smsMap.put("smsContent", "您的手机验证码是:"+captcha+"。要健康 要美丽 要时尚@111医药馆!");
//				String YAO_GATEWAY_URL = tsysparametermanager.getKeys("sms");
//				String buildRequestBySMS = ClientSubmit.buildRequestBySMS(smsMap,YAO_GATEWAY_URL);
//				System.out.println(buildRequestBySMS);
//				this.getSession().setAttribute("smsSuccess", "smsSuccess");
//				flag=0;
//			}
//		}else 
		if(username != null && pattern.matcher(username).matches() && mobileMember!=null && mobileMember.getStatus() == 0){
			if (!inputCode.equalsIgnoreCase(rand)) {
				flag = 1;// 输入的验证码不正确
			} else if (mobileMember.getIsMobileCheck() != 1) {
				flag = 2;// 该用户未绑定手机号
			} else if (!pattern.matcher(mobileMember.getMobile()).matches()) {
				flag = 3;// 手机格式不正确
			}else{
				Map<String, String> smsMap = new HashMap<String, String>();
				smsMap.put("mobiles", mobileMember.getMobile());
				smsMap.put("smsContent", "您的手机验证码是:"+captcha+"。要健康 要美丽 要时尚@111医药馆!");
				String YAO_GATEWAY_URL = tsysparametermanager.getKeys("sms");
				String buildRequestBySMS = ClientSubmit.buildRequestBySMS(smsMap,YAO_GATEWAY_URL);
				System.out.println(buildRequestBySMS);
				this.getSession().setAttribute("smsSuccess", "smsSuccess");
				flag=0;
			}
		} else {
			flag = 4;
		}
		out.print(flag);
		out.close();
	}

	/*
	 * 跳转到输入短信验证码页面
	 */
	public String nextStep() {
		String username = this.getRequest().getParameter("username");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		mobileMap.put("mobile", username);
		map.put("user_name", username);
		//TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		try {
			if(mobileMember!=null){
				tmember = mobileMember;
			}
//			else{
//				tmember = mobileMember;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nextstep2";
	}

	/*
	 * 校验验证码
	 */
	public void getCode() throws Exception {
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		String inputCode = this.getRequest().getParameter("inputCode");
		String username = this.getRequest().getParameter("username");
		String phoneCode =(String) MemCached.getmcc().get("pc_"+username);
		if (!inputCode.equalsIgnoreCase(phoneCode)) {//phoneCode
			flag = 1;// 短信验证码不对
		}
		out.print(flag);
		out.close();
	}

	/*
	 * 重置密码
	 */
	public void resetPassword() throws Exception {
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		String password = this.getRequest().getParameter("password");
		String username = this.getRequest().getParameter("username");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		map.put("user_name", username);
		mobileMap.put("mobile", username);
		//TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		try {
//			if(member!=null){
//				tmember = member;
//				tmember.setPassword(CustomDigestUtils.md5Hex(password, tmember));
//				tmember.setLastDate(new Date());
//				tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
//				tmembermanager.updateByPrimaryKeySelective(tmember);
//				flag = 0;
//			}else{
				tmember = mobileMember;
				tmember.setPassword(CustomDigestUtils.md5Hex(password, tmember));
				tmember.setLastDate(new Date());
				tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
				tmembermanager.updateByPrimaryKeySelective(tmember);
				flag = 0;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print(flag);
		out.close();
	}

	/*
	 * 跳转到成功页
	 */
	public String success() {

		return "success";
	}

	/*
	 * 跳转到重置密码页
	 */
	public String nextStep2() {
		String username = this.getRequest().getParameter("username");
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", username);
		mobileMap.put("mobile", username);
		//TMember member = (TMember) opensqlmanage.selectObjectByObject(map,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		try {
//			if(member!=null){
//				tmember = member;
//			}else{
				tmember = mobileMember;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nextstep3";
	}
	/*
	 * 重新获取验证码
	 */
	public void againGetMobileCode() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		String captcha = CodeUtil.getVcode(4);
		String username = this.getRequest().getParameter("username");
		 MemCached.getmcc().set("pc_"+username,captcha,new Date(1000*300));
		map.put("user_name", username);
		mobileMap.put("mobile", username);
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
//		TMember member = (TMember) opensqlmanage.selectObjectByObject(map,
//				"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
//		if (member != null) {
//			if (member.getIsMobileCheck() != 1) {
//				flag = 2;// 该用户未绑定手机号
//			} else if (!pattern.matcher(member.getMobile()).matches()) {
//				flag = 3;// 手机格式不正确
//			}else{
//				Map<String, String> smsMap = new HashMap<String, String>();
//				smsMap.put("mobiles", member.getMobile());
//				smsMap.put("smsContent", "您的手机验证码是:"+captcha+"。要健康 要美丽 要时尚@111医药馆!");
//				//String YAO_GATEWAY_URL = tsysparametermanager.getKeys("sms");
//				//String buildRequestBySMS = ClientSubmit.buildRequestBySMS(smsMap,YAO_GATEWAY_URL);
//				//System.out.println(buildRequestBySMS);
//				flag=0;
//			}
//		}else 
		if(username != null && pattern.matcher(username).matches() && mobileMember!=null && mobileMember.getStatus() == 0){
			if (mobileMember.getIsMobileCheck() != 1) {
				flag = 2;// 该用户未绑定手机号
			} else if (!pattern.matcher(mobileMember.getMobile()).matches()) {
				flag = 3;// 手机格式不正确
			}else{
				Map<String, String> smsMap = new HashMap<String, String>();
				smsMap.put("mobiles", mobileMember.getMobile());
				smsMap.put("smsContent", "您的手机验证码是:"+captcha+"。要健康 要美丽 要时尚@111医药馆!");
				String YAO_GATEWAY_URL = tsysparametermanager.getKeys("sms");
				String buildRequestBySMS = ClientSubmit.buildRequestBySMS(smsMap,YAO_GATEWAY_URL);
				System.out.println(buildRequestBySMS);
				flag=0;
			}
		} else {
			flag = 4;
		}
		out.print(flag);
		out.close();
	}
	/*-----------------密码找回新规则------------------*/
	
	
	/*
	 * 邮件点击返回到密码重置页
	 */
	
	public String setEamilPassword()  throws Exception{
		String username = this.getRequest().getParameter("username");
		Map<String, Object> usermap = new HashMap<String, Object>();
		usermap.put("user_name", username);
		String key = this.getRequest().getParameter("key");
		tmember = (TMember) opensqlmanage.selectObjectByObject(usermap,"t_member.ibatorgenerated_selectByUserName");
		String safekey = (String) MemCached.getmcc().get(tmember.getEmail());
		if(key==null || "".equals(key) || !key.equals(safekey)){
			return "errorPage";
		}else{
			return "nextstep3";
		}
	}
	
	/*
	 * 发送邮件
	 */
	
	public void sendEmail() throws Exception{
		
		String email = this.getRequest().getParameter("email");
		String randomUUID = UUID.randomUUID().toString();
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		MemCached.getmcc().set(email, randomUUID, new Date(2*60*60*1000));
		Map<String, Object> emailMap = new HashMap<String, Object>();
		emailMap.put("email", email);
		tmember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
		if(tmember!=null){
			Map<Object,Object> contentMap = new HashMap<Object,Object>();
			contentMap.put("username", tmember.getUserName());
			contentMap.put("randomUUID", randomUUID);
			contentMap.put("currentDate", new Date());
			if(mailSender.send(email, "111医药馆-验证邮箱", contentMap, "findpasswordmail.ftl")){
				flag=0;
			}else{
				flag=1;
			}
		}
		out.print(flag);
		out.close();
	}
	
	
	/*
	 * 重置密码
	 */
	public void reSetPassword() throws Exception{
		String mobile = (String) this.getRequest().getParameter("mobile");
		String email = (String) this.getRequest().getParameter("email");
		String password = this.getRequest().getParameter("password");
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		Map<String, Object> emailMap = new HashMap<String, Object>();
		emailMap.put("email", email);
		if(!"".equals(mobile)&&mobile!=null){
			Map<String, Object> mobileMap = new HashMap<String, Object>();
			mobileMap.put("mobile", mobile);
			tmember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		}
		if(tmember!=null){
			tmember.setPassword(MD5.MD5("111"+password+"yao"));
			tmember.setLastDate(new Date());
			tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
			tmembermanager.updateByPrimaryKeySelective(tmember);
			flag=0;
		}else{
			tmember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
			tmember.setPassword(MD5.MD5("111"+password+"yao"));
			tmember.setLastDate(new Date());
			tmember.setLastIp(NetworkUtil.getIpAddress(this.getRequest()));
			tmembermanager.updateByPrimaryKeySelective(tmember);
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	
	/*
	 * 转到设置密码页
	 */
	public String setPassword()  throws Exception{
		String mobile = this.getRequest().getParameter("mobile");
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		mobileMap.put("mobile", mobile);
		tmember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		return "nextstep3";
	}
	/*
	 * 检查手机验证码是否正确
	 */
	public void checkMobileCode() throws Exception{
		String mobile = (String) this.getRequest().getParameter("mobile");
		String mobilecode = (String) this.getRequest().getParameter("mobilecode");
		String amoblieCode = (String) MemCached.getmcc().get(mobile);
		int flag=-1;
		PrintWriter out = this.getResponse().getWriter();
		if(mobilecode !=null && amoblieCode !=null && mobilecode.equals(amoblieCode)){
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 发送验证码
	 */
	public void getMobileCode() throws Exception{
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
			flag=0;
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 手机验证身份页面
	 */
	public String mobileValidate()  throws Exception{
		String mobile = this.getRequest().getParameter("mobile");
		if(mobile!=null && !"".equals(mobile)){
			this.getRequest().setAttribute("mobile",mobile);
		}
		return "nextstep2";
	}
	
	/*
	 * 选择找回方式
	 */
	public String chooseFindMethod() throws Exception{
		Map<String, Object> usermap = new HashMap<String, Object>();
		Map<String, Object> mobileMap = new HashMap<String, Object>();
		Map<String, Object> emailMap = new HashMap<String, Object>();
		String username = this.getRequest().getParameter("username");
		usermap.put("user_name", username);
		mobileMap.put("mobile", username);
		emailMap.put("email", username);
		TMember usermember = (TMember) opensqlmanage.selectObjectByObject(usermap,"t_member.ibatorgenerated_selectByUserName");
		TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
		TMember emailMember = (TMember) this.opensqlmanage.selectObjectByObject(emailMap, "t_member.ibatorgenerated_selectMemberByEmail");
		if(usermember==null && mobileMember!=null){
			tmember=mobileMember;
		}else if(mobileMember==null && emailMember!=null){
			tmember=emailMember;
		}else{
			tmember=usermember;
		}
		return "nextstep1";
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
	 * 转到找回密码页面
	 */
	public String index() {

		return "findpassword";
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
