package com.rc.portal.webapp.action;

import java.io.File;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.mail.Mail;
import com.rc.commons.util.InfoUtil;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.jms.MessageSender;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberIntegralManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TMemberReceiverManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberBaseMessageExtExample;
import com.rc.portal.vo.TMemberIntegral;
import com.rc.portal.vo.TMemberIntegralExample;
import com.rc.portal.webapp.util.JsonUtil;

/**
 * 会员中心
 * @author 刘天灵
 *
 */
public class MemberProfileAction extends BaseAction{

	private static final long serialVersionUID = 35345345341L;
	
	private OpenSqlManage  opensqlmanage;
	
	private TMemberManager tmembermanager;
	
	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	
	private TMemberIntegralManager tmemberintegralmanager;
	
	private TMemberReceiverManager tmemberreceivermanager;
	
	private TSysParameterManager tsysparametermanager;
	
	private MessageSender topicMessageSender;
	
	
	
	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}

	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}

	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}

	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
	}

	public TMemberReceiverManager getTmemberreceivermanager() {
		return tmemberreceivermanager;
	}

	public void setTmemberreceivermanager(
			TMemberReceiverManager tmemberreceivermanager) {
		this.tmemberreceivermanager = tmemberreceivermanager;
	}

	public TMemberIntegralManager getTmemberintegralmanager() {
		return tmemberintegralmanager;
	}

	public void setTmemberintegralmanager(
			TMemberIntegralManager tmemberintegralmanager) {
		this.tmemberintegralmanager = tmemberintegralmanager;
	}

	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}

	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}

	private TMember tmember = new TMember();
	
	public TMember getTmember() {
		return tmember;
	}

	public void setTmember(TMember tmember) {
		this.tmember = tmember;
	}

	public OpenSqlManage getOpensqlmanage() {
		return opensqlmanage;
	}

	public void setOpensqlmanage(OpenSqlManage opensqlmanage) {
		this.opensqlmanage = opensqlmanage;
	}

	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {
		
	}
	
	public MessageSender getTopicMessageSender() {
		return topicMessageSender;
	}

	public void setTopicMessageSender(MessageSender topicMessageSender) {
		this.topicMessageSender = topicMessageSender;
	}

	/**
	 * 
	 * 个人资料(会员中心首页)
	 * @return
	 */
	public String index(){		
		//获取用户消费总额
		this.getRequest().setAttribute("monetary",opensqlmanage.selectObjectByObject(this.getSession().getAttribute("member"), "t_order.select_member_consume"));
		return "index";
	}

	
	/**
	 * 完善资料
	 * @return
	 */
	public String perfect() {
		System.out.println("-----------------------");		
		
		return "perfect";
	}

	/**
	 * 
	 * 完善个人资料(异步处理)
	 * @return
	 */
	public void editPerfect() throws Exception{		
		String [] fileNames = {"nickName","realName","sex","bloodType","drug","history","allergy"};
		
		Map<String,Object> result = new HashMap<String,Object>();	
		//完善所得积分
		int point = 0;
		
		//TODO 有时间个改到service层
		if(isValid(tmember, fileNames)){
			TMember sessionMember = (TMember)this.getSession().getAttribute("member");
			
			this.tmember.setId(sessionMember.getId());
			
			//更新完成,重新设置回话对象
			this.getSession().setAttribute("member",tmembermanager.selectByPrimaryKey(sessionMember.getId()));
			
			//2完善用户名 (5积分)
			if(StringUtils.isNotEmpty(tmember.getNickName())){
				TMemberIntegralExample Example = new TMemberIntegralExample();
				Example.createCriteria().andSourceEqualTo(2).andMemberIdEqualTo(sessionMember.getId());
				int count = tmemberintegralmanager.countByExample(Example);
				if(count == 0){
					TMemberIntegral tmemberintegral = new TMemberIntegral();
					tmemberintegral.setCreateDate(new Date());
					tmemberintegral.setIntegral(5);
					tmemberintegral.setMemberId(sessionMember.getId());
					tmemberintegral.setSource(2);
					tmemberintegralmanager.insertSelective(tmemberintegral);
					point += 5 ;
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("memberId", sessionMember.getId().toString());
					map.put("jifen", ""+5);
					map.put("version", "v7");
					topicMessageSender.sendMapMessage(map);
				}
				CookieUtil.addCookie(getRequest(), getResponse(), "nickname", java.net.URLEncoder.encode(tmember.getNickName(), "utf-8"), 7*24*60*60, "/", "", false);
			}else{
				String nickname = CookieUtil.getCookie(getRequest(), "nickname");
				if(nickname != null && !nickname.trim().equals("")){
					CookieUtil.removeCookie(getRequest(), getResponse(), "nickname", "/", "");
				}
			}
			
			
			//3完善真实姓名 (5积分)
			if(StringUtils.isNotEmpty(tmember.getRealName())){
				TMemberIntegralExample Example = new TMemberIntegralExample();
				Example.createCriteria().andSourceEqualTo(3).andMemberIdEqualTo(sessionMember.getId());
				int count = tmemberintegralmanager.countByExample(Example);
				if(count == 0){
					TMemberIntegral tmemberintegral = new TMemberIntegral();
					tmemberintegral.setCreateDate(new Date());
					tmemberintegral.setIntegral(5);
					tmemberintegral.setMemberId(sessionMember.getId());
					tmemberintegral.setSource(3);
					tmemberintegralmanager.insertSelective(tmemberintegral);
					point += 5 ;
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("memberId", sessionMember.getId().toString());
					map.put("jifen", ""+5);
					map.put("version", "v7");
					topicMessageSender.sendMapMessage(map);
				}
			}
			//4完善性别 (5积分)
			if(tmember.getSex()==1||tmember.getSex()==2){
				TMemberIntegralExample Example = new TMemberIntegralExample();
				Example.createCriteria().andSourceEqualTo(4).andMemberIdEqualTo(sessionMember.getId());
				int count = tmemberintegralmanager.countByExample(Example);
				if(count == 0){
					TMemberIntegral tmemberintegral = new TMemberIntegral();
					tmemberintegral.setCreateDate(new Date());
					tmemberintegral.setIntegral(5);
					tmemberintegral.setMemberId(sessionMember.getId());
					tmemberintegral.setSource(4);
					tmemberintegralmanager.insertSelective(tmemberintegral);
					point += 5 ;
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("memberId", sessionMember.getId().toString());
					map.put("jifen", ""+5);
					map.put("version", "v7");
					topicMessageSender.sendMapMessage(map);
				}
			}
			//5完善血型(5积分)
			if(StringUtils.isNotEmpty(tmember.getBloodType())){
				TMemberIntegralExample Example = new TMemberIntegralExample();
				Example.createCriteria().andSourceEqualTo(5).andMemberIdEqualTo(sessionMember.getId());
				int count = tmemberintegralmanager.countByExample(Example);
				if(count == 0){
					TMemberIntegral tmemberintegral = new TMemberIntegral();
					tmemberintegral.setCreateDate(new Date());
					tmemberintegral.setIntegral(5);
					tmemberintegral.setMemberId(sessionMember.getId());
					tmemberintegral.setSource(5);
					tmemberintegralmanager.insertSelective(tmemberintegral);
					point += 5 ;
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("memberId", sessionMember.getId().toString());
					map.put("jifen", ""+5);
					map.put("version", "v7");
					topicMessageSender.sendMapMessage(map);
				}
			}
			//6完善会员病历(常用药、病史、过敏史)(50积分)
			if(StringUtils.isNotEmpty(tmember.getDrug())&&StringUtils.isNotEmpty(tmember.getHistory())&&StringUtils.isNotEmpty(tmember.getAllergy())){
				TMemberIntegralExample Example = new TMemberIntegralExample();
				Example.createCriteria().andSourceEqualTo(6).andMemberIdEqualTo(sessionMember.getId());
				int count = tmemberintegralmanager.countByExample(Example);
				if(count == 0){
					TMemberIntegral tmemberintegral = new TMemberIntegral();
					tmemberintegral.setCreateDate(new Date());
					tmemberintegral.setIntegral(50);
					tmemberintegral.setMemberId(sessionMember.getId());
					tmemberintegral.setSource(6);
					tmemberintegralmanager.insertSelective(tmemberintegral);
					point += 50 ;
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("memberId", sessionMember.getId().toString());
					map.put("jifen", ""+50);
					map.put("version", "v7");
					topicMessageSender.sendMapMessage(map);
				}
			}
			
			this.tmembermanager.updateByPrimaryKeySelective(this.tmember);
			this.getSession().setAttribute("member",tmembermanager.selectByPrimaryKey(sessionMember.getId()));
			result.put("type", true);
			result.put("point", point);
			this.writeObjectToResponse(result, ContentType.application_json);
		}else{
			result.put("type", false);
			result.put("point", point);
			this.writeObjectToResponse(result, ContentType.application_json);
		}
	}
	
	
	/**
	 * 用户头像
	 */
	public String headPortrait(){
		return "upload_head_portrait";
	}
	
	private File head;
	
	private String headFileName;
	
	private String headContentType;
	
	private String diskPath = InfoUtil.getInstance().getInfo("img", "images.public.head.path");
	
	/**
	 * 上传头像 
	 */
	public void uploadHeadPortrait(){
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String fileType= FilenameUtils.getExtension(headFileName);
		try {
			String basePath = this.getRequest().getSession().getServletContext().getRealPath("/");	
			if(checkFileType(fileType) && head.length() < 4*1024*1024){
				String webPath = diskPath+"/"+UUID.randomUUID()+"."+fileType;
				String fullName = basePath + webPath;
				
				File uploadFile = new File(fullName);
				FileUtils.copyFile(head, uploadFile);//上传图片
				sessionMember.setHeadPortrait(webPath);
				
				this.tmembermanager.updateByPrimaryKeySelective(sessionMember);
				
				this.getSession().setAttribute("member", sessionMember);
				
				this.writeObjectToResponse(URLEncoder.encode(webPath, "UTF-8"), ContentType.application_json);
			}else{
				this.writeObjectToResponse(0, ContentType.application_json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.writeObjectToResponse(1, ContentType.application_json);
		}
	}
	
	/**
	 * 上传头像 
	 */
	public void uploadHeadPortrait_2(){
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		String fileType= FilenameUtils.getExtension(headFileName);
		try {
			String basePath = this.getRequest().getSession().getServletContext().getRealPath("/");	
			if(checkFileType(fileType) && head.length() < 4*1024*1024){
				String webPath = diskPath+"/"+UUID.randomUUID()+"."+fileType;
				String fullName = basePath + webPath;
				
				File uploadFile = new File(fullName);
				FileUtils.copyFile(head, uploadFile);//上传图片
				
				
				TMemberBaseMessageExtExample tbmee = new TMemberBaseMessageExtExample();
				tbmee.createCriteria().andMemberIdEqualTo(sessionMember.getId());
				
				if(tmemberbasemessageextmanager.countByExample(tbmee) > 0){
					TMemberBaseMessageExt tMemberBaseMessageExt = new TMemberBaseMessageExt();
					tMemberBaseMessageExt.setMemberId(sessionMember.getId());
					tMemberBaseMessageExt.setHeadPortrait(webPath);
					tmemberbasemessageextmanager.updateByPrimaryKeySelective(tMemberBaseMessageExt);
				}else{
					TMemberBaseMessageExt tMemberBaseMessageExt = new TMemberBaseMessageExt();
					tMemberBaseMessageExt.setMemberId(sessionMember.getId());
					tMemberBaseMessageExt.setHeadPortrait(webPath);
					tmemberbasemessageextmanager.insertSelective(tMemberBaseMessageExt);
				}
				
				this.writeObjectToResponse(URLEncoder.encode(webPath, "UTF-8"), ContentType.application_json);
			}else{
				this.writeObjectToResponse(0, ContentType.application_json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.writeObjectToResponse(1, ContentType.application_json);
		}
	}

	public File getHead() {
		return head;
	}

	public void setHead(File head) {
		this.head = head;
	}

	public String getHeadFileName() {
		return headFileName;
	}

	public void setHeadFileName(String headFileName) {
		this.headFileName = headFileName;
	}

	public String getHeadContentType() {
		return headContentType;
	}

	public void setHeadContentType(String headContentType) {
		this.headContentType = headContentType;
	}
	
	/**
	 * 检查文件类型
	 * @param type
	 * @return
	 */
	public boolean checkFileType(String type){
		boolean flag=false;
		type = type.toLowerCase();
		String[] arrType={"jpg","png","gif","jpeg"};
		for(String s:arrType){
			if(type.equals(s)){
				return true;
			}
		}
		return flag;
	}
	
	/**
	 * 编辑验证邮箱 
	 */
	public String editEmail(){
		
		
		return "edit_email";
	}
	
	
	/**
	 * 保存邮箱 
	 * @throws SQLException 
	 */
	public String saveEmail() throws SQLException{
		
		String email = this.getRequest().getParameter("email");
		String emailCheck = this.getRequest().getParameter("emailCheck");
		String rand = this.getRequest().getParameter("rand");
		
		String sessionRand = (String)this.getSession().getAttribute("rand");
		
		String sessionEmailCheck = "";
		Object memcacheValue = MemCached.getmcc().get("emailCheck");
		if(memcacheValue!=null){
			sessionEmailCheck = memcacheValue.toString();
		}
		
		this.getRequest().setAttribute("email", email);
		
		if(StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(emailCheck) && emailCheck.equals(sessionEmailCheck) && StringUtils.isNotEmpty(rand)&& sessionRand.equalsIgnoreCase(rand)){
			
			TMember member = (TMember)this.getSession().getAttribute("member");
			
			member.setEmail(email);
			
			member.setIsEmailCheck(1);
			
			this.tmembermanager.updateByPrimaryKeySelective(member);
			
			this.getSession().setAttribute("member", member);
			
			this.getRequest().setAttribute("option", true);
			
		}else{
			this.getRequest().setAttribute("option", false);
		}
		
		return "edit_email_success";
	}
	
	private Mail  mailSender;
	
	public Mail getMailSender() {
		return mailSender;
	}

	public void setMailSender(Mail mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 发送邮箱验证码
	 */
	public void sendEmailCheck(){
		
		String email = this.getRequest().getParameter("email");
		
		String randomUUID = CodeUtil.getVcode(6);
		
		MemCached.getmcc().set("emailCheck", randomUUID, 60*1000);
		
		System.out.println("短信验证码 session-key:mobileCheck    value:"+email+"|"+randomUUID);
		
		Map<Object,Object> contentMap = new HashMap<Object,Object>();
		contentMap.put("randomUUID", randomUUID);
		if(mailSender.send(email, "111医药馆-验证邮箱", contentMap, "sendCheckEmail.ftl")){
			this.writeObjectToResponse(1, ContentType.application_json);
		}else{
			this.writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	
	/**
	 * 发送手机验证码
	 * @throws Exception 
	 */
	public void sendMobileCheck() throws Exception{
		
		String mobile = this.getRequest().getParameter("mobile");
		Map<String, String> mobilemap = new HashMap<String, String>();
		mobilemap.put("mobile", mobile);
		Long mobileCount = (Long) this.opensqlmanage.selectObjectByObject(mobilemap, "t_member.ibatorgenerated_selectByMobile");
		if(mobileCount==0){
			String numVcode = CodeUtil.getVcode(4);
			
			//发送手机验证码
			System.out.println("短信验证码 session-key:mobileCheck    value:"+mobile+"|"+numVcode);
			
			MemCached.getmcc().set("mobileCheck", mobile+"|"+numVcode, 60*1000);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("mobiles", mobile);
			String smsContent = "您的手机验证码是:"+numVcode + " 要健康 要美丽 要时尚@111医药馆！";
			map.put("smsContent", smsContent);
			ClientSubmit.buildRequestBySMS(map,tsysparametermanager.getKeys("sms"));
			
			this.writeObjectToResponse(1, ContentType.application_json);
		}else{
			this.writeObjectToResponse(2, ContentType.application_json);
		}
		
	}
	
	/**
	 * 编辑验证手机 
	 */
	public String editMobile(){
		
		return "edit_mobile";
	}
	
	/**
	 * 保存验证手机 
	 * @throws SQLException 
	 */
	public String saveMobile() throws SQLException{
		
		String mobile = this.getRequest().getParameter("mobile");
		String mobileCheck = this.getRequest().getParameter("mobileCheck");
		String rand = this.getRequest().getParameter("rand");
		
		String sessionRand = (String)this.getSession().getAttribute("rand");

		String sessionMobileCheck = "";
		Object memcacheValue = MemCached.getmcc().get("mobileCheck");
		
		if(memcacheValue!=null){
			sessionMobileCheck = memcacheValue.toString();
		}
		
		this.getRequest().setAttribute("mobile", mobile);
		
		if(StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(mobileCheck) && StringUtils.isNotEmpty(sessionMobileCheck) && sessionMobileCheck.equals(mobile+"|"+mobileCheck) && StringUtils.isNotEmpty(rand)&& sessionRand.equalsIgnoreCase(rand)){
			
			
			this.getSession().removeAttribute("mobileCheck");
			
			TMember member = (TMember)this.getSession().getAttribute("member");
			
			member.setMobile(mobile);
			
			member.setIsMobileCheck(1);
			
			this.tmembermanager.updateByPrimaryKeySelective(member);
			
			this.getSession().setAttribute("member", member);
			
			this.getRequest().setAttribute("option", true);
			
		}else{
			this.getRequest().setAttribute("option", false);
		}
		
		return "edit_mobile_success";
	}
	
	
	/**
	 * 检查验证码是否正确
	 */
	public void randCheck(){
	
		String rand = this.getRequest().getParameter("rand");
		String sessionRand =(String) this.getSession().getAttribute("rand");
		
		if(StringUtils.isNotEmpty(rand) && StringUtils.isNotEmpty(sessionRand) && rand.equalsIgnoreCase(sessionRand)){
			this.writeObjectToResponse(1, ContentType.application_json);
		}else{
			this.writeObjectToResponse(0, ContentType.application_json);
		}
	}
	
	/**
	 * 修改用户密码
	 */
	public String editPassword(){
		
		return "edit_password";
	}

	
	/**
	 * 保存用户密码
	 */
	public String savePassword() throws Exception{
		
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		
		String mobileCheck = this.getRequest().getParameter("mobileCheck");
		String password = this.getRequest().getParameter("password");
		String rePassword = this.getRequest().getParameter("rePassword");
		String rand = this.getRequest().getParameter("rand");
		
		String sessionRand = (String)this.getSession().getAttribute("rand");
		
		String sessionMobileCheck = ""; 
		Object memcahedValue = MemCached.getmcc().get("mobileCheck");
		if(memcahedValue!=null){
			sessionMobileCheck = memcahedValue.toString();
		}
		
		if(sessionMobileCheck.equals(sessionMember.getMobile()+"|"+mobileCheck) && password.matches("(?!(?:\\d*$))[A-Za-z0-9]{6,20}")&&password.equals(rePassword)&& StringUtils.isNotEmpty(rand)&& sessionRand.equalsIgnoreCase(rand)){
			sessionMember.setPassword(CustomDigestUtils.md5Hex(password, sessionMember));
			this.tmembermanager.updateByPrimaryKeySelective(sessionMember);
			this.getRequest().setAttribute("option", true);
		}else{
			this.getRequest().setAttribute("option", false);
		}
		
		
		return "edit_password_success";
	}
	
	/**
	 * 异步获取会员信息
	 */
	public void ajaxMemberInfo() throws Exception{
		TMember sessionMember = (TMember)this.getSession().getAttribute("member");
		TMember selectByPrimaryKey = tmembermanager.selectByPrimaryKey(sessionMember.getId());
		this.getSession().setAttribute("member", selectByPrimaryKey);	
		Map<String,Object> param = new HashMap<String,Object>();
		Map map=new HashMap();
		map.put("memberId", sessionMember.getId().toString());
		String homePageConfigId = tsysparametermanager.getKeys("public_service_url");
		Map result = JsonUtil.getData1(map, homePageConfigId+"getJifenOutline");
		if(result.get("jifen")!=null){
			if(selectByPrimaryKey.getIntegral()!=null){
				Integer i=(Integer) selectByPrimaryKey.getIntegral();
				Integer j=(Integer) result.get("jifen");
				selectByPrimaryKey.setIntegral(i+j);
			}
		}
		param.put("integral", selectByPrimaryKey.getIntegral());
		param.put("nickName", selectByPrimaryKey.getNickName());
		param.put("realName", selectByPrimaryKey.getRealName());
		
		this.writeObjectToResponse(param, ContentType.application_json);
	}	
}
