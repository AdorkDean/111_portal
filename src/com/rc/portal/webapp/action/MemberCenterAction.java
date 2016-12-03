package com.rc.portal.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.commons.mail.Mail;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.CLocationCityManager;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TMemberBaseMessageExtManager;
import com.rc.portal.service.TMemberHobbyManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CustomDigestUtils;
import com.rc.portal.util.SmsMessagesConfig;
import com.rc.portal.vo.CLocationCity;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberBaseMessageExt;
import com.rc.portal.vo.TMemberBaseMessageExtExample;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.vo.TMemberHobby;
import com.rc.portal.vo.TMemberHobbyExample;
import com.rc.portal.webapp.util.MD5;

public class MemberCenterAction extends BaseAction{

	private TMemberBaseMessageExtManager tmemberbasemessageextmanager;
	private TMemberManager tmembermanager;
	private TLeaderManager tleadermanager;
	private TMemberHobbyManager tmemberhobbymanager;
	private CLocationCityManager clocationcitymanager;
	
	private TMemberBaseMessageExt tMemberBaseMessageExt;
	private TMemberHobby tMemberHobby;
	private TMember memberForm;
	
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
	public TMember getMemberForm() {
		return memberForm;
	}
	public void setMemberForm(TMember memberForm) {
		this.memberForm = memberForm;
	}
	public CLocationCityManager getClocationcitymanager() {
		return clocationcitymanager;
	}
	public void setClocationcitymanager(CLocationCityManager clocationcitymanager) {
		this.clocationcitymanager = clocationcitymanager;
	}
	public TMemberHobby gettMemberHobby() {
		return tMemberHobby;
	}
	public void settMemberHobby(TMemberHobby tMemberHobby) {
		this.tMemberHobby = tMemberHobby;
	}
	public TMemberBaseMessageExt gettMemberBaseMessageExt() {
		return tMemberBaseMessageExt;
	}
	public void settMemberBaseMessageExt(TMemberBaseMessageExt tMemberBaseMessageExt) {
		this.tMemberBaseMessageExt = tMemberBaseMessageExt;
	}
	public TMemberHobbyManager getTmemberhobbymanager() {
		return tmemberhobbymanager;
	}
	public void setTmemberhobbymanager(TMemberHobbyManager tmemberhobbymanager) {
		this.tmemberhobbymanager = tmemberhobbymanager;
	}
	public TMemberBaseMessageExtManager getTmemberbasemessageextmanager() {
		return tmemberbasemessageextmanager;
	}
	public void setTmemberbasemessageextmanager(
			TMemberBaseMessageExtManager tmemberbasemessageextmanager) {
		this.tmemberbasemessageextmanager = tmemberbasemessageextmanager;
	}
	
	public TMemberManager getTmembermanager() {
		return tmembermanager;
	}
	public void setTmembermanager(TMemberManager tmembermanager) {
		this.tmembermanager = tmembermanager;
	}
	public String toEditBaseMemberCenter() throws IOException, SQLException{
		TMember member = (TMember) this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return null;
		}
		
		TMemberBaseMessageExt tMemberBaseMessageExt = tmemberbasemessageextmanager.selectByPrimaryKey(member.getId());
		TMemberHobby tMemberHobby = tmemberhobbymanager.selectByPrimaryKey(member.getId());
		
		member = tmembermanager.selectByPrimaryKey(member.getId());
		
		getRequest().setAttribute("tMemberBaseMessageExt", tMemberBaseMessageExt);
		if(tMemberBaseMessageExt != null){
			Date birthday = tMemberBaseMessageExt.getBirthday();
			if(birthday != null){
				Calendar calendar =  GregorianCalendar.getInstance();
				calendar.setTime(birthday);
				
				getRequest().setAttribute("year", calendar.get(Calendar.YEAR));
				getRequest().setAttribute("month", calendar.get(Calendar.MONTH)+1);
				getRequest().setAttribute("day", calendar.get(Calendar.DAY_OF_MONTH));
			}
		}
		if(tMemberBaseMessageExt != null){
			//省市区
			Long areaId = tMemberBaseMessageExt.getAreaId();
			if(areaId != null && areaId > 0){
				CLocationCity cLocationCity = clocationcitymanager.selectByPrimaryKey(areaId.intValue());
				int cityId = cLocationCity.getParentid();
				cLocationCity = clocationcitymanager.selectByPrimaryKey(cityId);
				int provinceId = cLocationCity.getParentid();
				getRequest().setAttribute("province", provinceId);//省
				getRequest().setAttribute("city", cityId);//市
				getRequest().setAttribute("county", areaId);//区
				String area = tMemberBaseMessageExt.getArea();
//				if(area != null && area.trim().length() > 0){
//					String[] areaArray = area.split("-");
//					if(areaArray.length >= 3){
//						String zone = areaArray[2];
//						CLocationCityExample cLocationCityExample = new CLocationCityExample();
//						cLocationCityExample.createCriteria().andParentidEqualTo((int)areaId).andNameEqualTo(zone);
//						List cLocationCityList = clocationcitymanager.selectByExample(cLocationCityExample);
//						if(cLocationCityList != null && cLocationCityList.size() > 0){
//							CLocationCity city = (CLocationCity) cLocationCityList.get(0);
//							int county = city.getId();
//							getRequest().setAttribute("county", county);//区
//						}
//					}
//				}
			}
		}
		if(member.getMobile() != null && member.getMobile().trim().length() > 0 && member.getIsMobileCheck() == 1){
			this.getRequest().setAttribute("isMobileCheck", true);
		}
		if(member.getEmail() != null && member.getEmail().trim().length() > 0 && member.getIsEmailCheck() == 1){
			this.getRequest().setAttribute("isEmailCheck", true);
		}
		
		getRequest().setAttribute("tMemberHobby", tMemberHobby);
		getRequest().setAttribute("member", member);
		
		return "baseMemberCenter";
	}
	
	public void saveMemberCenter() throws IOException, SQLException, ParseException{
		
		TMember member = (TMember) this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}
		
		String year = getRequest().getParameter("year");
		String month = getRequest().getParameter("month");
		String day = getRequest().getParameter("day");
		if(year != null && year.trim().length() > 0
				&& month != null && month.trim().length() > 0
				&& day != null && day.trim().length() > 0
				&& !"0".equals(year)
				&& !"0".equals(month)
				&& !"0".equals(day)){
			month = month.length()>1?month:"0"+month;
			day = day.length()>1?day:"0"+day;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date birth = df.parse(year+"-"+month+"-"+day);
			tMemberBaseMessageExt.setBirthday(birth);
		}
		
		String province = getRequest().getParameter("province");//id
		String city = getRequest().getParameter("city");//id
		String county = getRequest().getParameter("county");//id
		if(	province != null && province.trim().length() > 0
				&& city != null && city.trim().length() > 0
				&& county != null && county.trim().length() > 0
				&&!"0".equals(province) && !"0".equals(city) && !"0".equals(county)){
			String provinceStr = province.split("_")[0];
			String cityStr = city.split("_")[0];
			String countyStr = county.split("_")[0];
			
			long areaId = Integer.valueOf(city.split("_")[1]);
			long countyId = Integer.valueOf(county.split("_")[1]);
			tMemberBaseMessageExt.setArea(provinceStr+"-"+cityStr+"-"+countyStr);
			tMemberBaseMessageExt.setAreaId(countyId);
		}
		
		if(tMemberBaseMessageExt != null){
			//对于checkbox的特殊处理
			if(tMemberBaseMessageExt.getLiveStatus() != null && tMemberBaseMessageExt.getLiveStatus().trim().length() > 0){
				tMemberBaseMessageExt.setLiveStatus(","+tMemberBaseMessageExt.getLiveStatus().replace(" ", "")+",");
			}
			if(tMemberBaseMessageExt.getChildAge() != null && tMemberBaseMessageExt.getChildAge().trim().length() > 0){
				tMemberBaseMessageExt.setChildAge(","+tMemberBaseMessageExt.getChildAge().replace(" ", "")+",");
			}
			//对于input的trim处理
			if(tMemberBaseMessageExt.getNickName() != null){
				tMemberBaseMessageExt.setNickName(tMemberBaseMessageExt.getNickName().trim());
			}
			if(tMemberBaseMessageExt.getRealName() != null){
				tMemberBaseMessageExt.setRealName(tMemberBaseMessageExt.getRealName().trim());
			}
			if(tMemberBaseMessageExt.getAddress() != null){
				tMemberBaseMessageExt.setAddress(tMemberBaseMessageExt.getAddress().trim());
			}
			if(tMemberBaseMessageExt.getCompanyName() != null){
				tMemberBaseMessageExt.setCompanyName(tMemberBaseMessageExt.getCompanyName().trim());
			}
			if(tMemberBaseMessageExt.getPosition() != null){
				tMemberBaseMessageExt.setPosition(tMemberBaseMessageExt.getPosition().trim());
			}
			if(tMemberBaseMessageExt.getGraduationSchool() != null){
				tMemberBaseMessageExt.setGraduationSchool(tMemberBaseMessageExt.getGraduationSchool().trim());
			}
		}
		
		if(tMemberHobby != null){
			if(tMemberHobby.getShoppingLike() != null && tMemberHobby.getShoppingLike().trim().length() > 0){
				tMemberHobby.setShoppingLike(","+tMemberHobby.getShoppingLike().replace(" ", "")+",");
			}
			if(tMemberHobby.getShoppingPreference() != null && tMemberHobby.getShoppingPreference().trim().length() > 0){
				tMemberHobby.setShoppingPreference(","+tMemberHobby.getShoppingPreference().replace(" ", "")+",");
			}
			
			if(tMemberHobby.getLikeFilm() != null){
				tMemberHobby.setLikeFilm(tMemberHobby.getLikeFilm().trim());
			}
			if(tMemberHobby.getLikeCharacter() != null){
				tMemberHobby.setLikeCharacter(tMemberHobby.getLikeCharacter().trim());
			}
			if(tMemberHobby.getLikeStar() != null){
				tMemberHobby.setLikeStar(tMemberHobby.getLikeStar().trim());
			}
			if(tMemberHobby.getLikeBrand() != null){
				tMemberHobby.setLikeBrand(tMemberHobby.getLikeBrand().trim());
			}
		}
		
		TMemberBaseMessageExtExample tbmee = new TMemberBaseMessageExtExample();
		tbmee.createCriteria().andMemberIdEqualTo(member.getId());
		if(tMemberBaseMessageExt != null){
			tMemberBaseMessageExt.setMemberId(member.getId());
			if(tmemberbasemessageextmanager.countByExample(tbmee) > 0){
				tmemberbasemessageextmanager.updateByPrimaryKeySelective(tMemberBaseMessageExt);
			}else{
				tmemberbasemessageextmanager.insertSelective(tMemberBaseMessageExt);
			}
		}
		
		TMemberHobbyExample tMemberHobbyExample = new TMemberHobbyExample();
		tMemberHobbyExample.createCriteria().andMemberIdEqualTo(member.getId());
		if(tMemberHobby != null ){
			tMemberHobby.setMemberId(member.getId());
			if(tmemberhobbymanager.countByExample(tMemberHobbyExample) > 0 ){
				tmemberhobbymanager.updateByPrimaryKeySelective(tMemberHobby);
			}else{
				tmemberhobbymanager.insertSelective(tMemberHobby);
			}
		}
		if(memberForm != null){
			memberForm.setId(member.getId());
			if(memberForm.getEmail() != null){
				memberForm.setEmail(memberForm.getEmail().trim());
			}
			if(memberForm.getPhone() != null){
				memberForm.setPhone(memberForm.getPhone().trim());
			}
			tmembermanager.updateByPrimaryKeySelective(memberForm);
		}
		Map resultMap = new HashMap();
		resultMap.put("status", "1");
		writeObjectToResponse(resultMap, ContentType.application_json);//保存预订单成功
		return ;
	}
	
	public void validateEmail() throws SQLException, IOException{
		TMember member = (TMember) this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}
		
		String email = getRequest().getParameter("email");
		if(email != null && email.trim().length() > 0){//验证邮箱唯一性
			TMemberExample tMemberExample = new TMemberExample();
			tMemberExample.createCriteria().andEmailEqualTo(email.trim()).andIdNotEqualTo(member.getId());
			Map resultMap = new HashMap();
			if(tmembermanager.countByExample(tMemberExample) > 0){
				resultMap.put("status", "0");//已经存在该邮箱
			}else{
				resultMap.put("status", "1");
			}
			writeObjectToResponse(resultMap, ContentType.application_json);//保存预订单成功
		}
	}
	
	public String toEditMoreMemberCenter(){
		
		return "moreMemberCenter";
	}
	public String toEditHobbyMemberCenter(){
		
		return "hobbyMemberCenter";
	}
	
	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public void setModel(Object o) {
		
	}
	
	/**
	 * 检查验证码是否正确
	 */
	public void randCheck(){
	
		String rand = this.getRequest().getParameter("rand");
		String sessionRand =(String) this.getSession().getAttribute("rand");
		String type = getRequest().getParameter("type");
		if(StringUtils.isNotEmpty(rand) && StringUtils.isNotEmpty(sessionRand) && rand.equalsIgnoreCase(sessionRand)){
			String password = this.getRequest().getParameter("password");
			
			TMember member = (TMember)this.getSession().getAttribute("member");
			if(member != null){
				if (!CustomDigestUtils.md5Hex(password, member).equals(
						member.getPassword())  && !MD5.MD5("111"+password+"yao").equals(
								member.getPassword())) {
					this.writeObjectToResponse(1, ContentType.application_json);//密码错误
				}else{
					
					String randomUUID = CodeUtil.getVcode(8);
					if(type != null && type.equals("emailType")){
						MemCached.getmcc().set(member.getUserName()+"_password_validate_pass", randomUUID, new Date(5*60*1000));
					}else if(type != null && type.equals("passwordType")){
						MemCached.getmcc().set(member.getUserName()+"_password_update_key", randomUUID, new Date(5*60*1000));
						this.getSession().setAttribute("password_validate_pass",true);
					}
					this.writeObjectToResponse(randomUUID, ContentType.application_json);//密码验证码都通过
				} 
			}
		}else{
			this.writeObjectToResponse(0, ContentType.application_json);//验证码错误
		}
	}
	
	/**
	 * 检查验证码是否正确
	 * @throws SQLException 
	 */
	public void setNewPassword() throws SQLException{
	
		String newPassword = this.getRequest().getParameter("newPassword");
		System.out.println(newPassword.matches("(?!(?:\\d*$))[A-Za-z0-9]{8,20}"));
		if(StringUtils.isNotEmpty(newPassword) 
				&& this.getSession().getAttribute("password_validate_pass")!=null 
				&& (Boolean)this.getSession().getAttribute("password_validate_pass") == true
				&& newPassword.matches("(?!(?:\\d*$))[A-Za-z0-9]{8,20}")){
			
			TMember member = (TMember)this.getSession().getAttribute("member");
			if(member != null){
				String newPasswordMd5 =  MD5.MD5("111"+newPassword.trim()+"yao");
				member.setPassword(newPasswordMd5);
				int flag = tmembermanager.updateByPrimaryKeySelective(member);
				if(flag > 0){
					this.writeObjectToResponse(1, ContentType.application_json);//密码不能为空
					this.getSession().setAttribute("password_validate_pass",false);
					this.getSession().setAttribute("member",member);
				}else{
					this.writeObjectToResponse(0, ContentType.application_json);//修改密码失败
				}
			}
			
		}else{
			this.writeObjectToResponse(0, ContentType.application_json);//密码不能为空
		}
	}
	
	public String toAccountSecurity() throws SQLException{
		//判断当前用户是否存在已验证的手机号
		TMember member = (TMember)this.getSession().getAttribute("member");
		member = tmembermanager.selectByPrimaryKey(member.getId());
		int grade = 30;//安全级别
		
		if(member.getMobile() != null && member.getMobile().trim().length() > 0 && member.getIsMobileCheck() == 1){
			this.getRequest().setAttribute("isMobileCheck", true);
			this.getRequest().setAttribute("mobile", member.getMobile().substring(0, 3)+"****"+member.getMobile().substring(member.getMobile().length()-4, member.getMobile().length()));
			grade += 35;
		}
		if(member.getEmail() != null && member.getEmail().trim().length() > 0 && member.getIsEmailCheck() == 1){
			this.getRequest().setAttribute("isEmailCheck", true);
			this.getRequest().setAttribute("email", dealEmail(member.getEmail()));
			grade += 35;
		}
		
		TMemberBaseMessageExt tMemberBaseMessageExt = tmemberbasemessageextmanager.selectByPrimaryKey(member.getId());
		if(tMemberBaseMessageExt != null){
			this.getRequest().setAttribute("billEmail",tMemberBaseMessageExt.getBillEmail());
		}
		
		this.getRequest().setAttribute("grade",grade);
		return "toAccountSecurity";
	}
	
	public String toPasswordValidate(){
		return "toPasswordValidate";
	}
	
	public String toPasswordSetnew(){
		if(this.getSession().getAttribute("password_validate_pass")!=null && (Boolean)this.getSession().getAttribute("password_validate_pass") == true){
			return "toPasswordSetnew";
		}else{
			return "toPasswordValidate";
		}
	}
	
	public String toPasswordSetsuccess(){
		return "toPasswordSetsuccess";
	}
	
	
	public String toEmailBindValidate(){
		return "toEmailBindValidate";
	}
	public String toEmailBindInput(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		String randomUUID = getRequest().getParameter("randomUUID");
		String randomUUIDCache = (String) MemCached.getmcc().get(member.getUserName()+"_password_validate_pass");
		if(randomUUID != null && randomUUID.equals(randomUUIDCache)  ){
			return "toEmailBindInput";
		}else{
			return "toEmailBindValidate";
		}
		
	}
	public String toEmailBindSend(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		String email = (String) MemCached.getmcc().get(member.getUserName()+"_email");
		
		if(email != null && email.trim().length() > 0){
			String emailAddress = "http://mail."+email.substring(email.indexOf("@")+1, email.length());
			this.getRequest().setAttribute("emailAddress",emailAddress);
			this.getRequest().setAttribute("email",dealEmail(email));
		}
		return "toEmailBindSend";
	}
	
	public String toEmailLink() throws SQLException{
		String randomUUID = getRequest().getParameter("randomUUID");
		String type = getRequest().getParameter("type");
		if(randomUUID == null || type == null){
			return "toEmailLinkFail";
		}
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		String randomUUIDCached = (String) MemCached.getmcc().get(member.getUserName()+"_emailCheck");
		String email = (String) MemCached.getmcc().get(member.getUserName()+"_email");
		if(randomUUID.equals(randomUUIDCached)){
			TMember memberTemp = new TMember();
			memberTemp.setId(member.getId());
			memberTemp.setEmail(email);
			memberTemp.setIsEmailCheck(1);
			tmembermanager.updateByPrimaryKeySelective(memberTemp);
			
			member.setEmail(email);
			member.setIsEmailCheck(1);
			getSession().setAttribute("member",member);
			
			MemCached.getmcc().delete(member.getUserName()+"_emailCheck");
			MemCached.getmcc().delete(member.getUserName()+"_email");
			
			getRequest().setAttribute("email", dealEmail(member.getEmail()));
			if("2".equals(type)){
				return "toEmailUpdateSuccess";
			}else{
				return "toEmailBindSuccess";
			}
		}else{
			return "toEmailLinkFail";
		}
	}
	public String toEmailLinkFail(){
		return "toEmailLinkFail";
	}
	public String toEmailBindSuccess(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		getRequest().setAttribute("email", dealEmail(member.getEmail()));
		return "toEmailBindSuccess";
	}
	
	public String toEmailUpdateValidate() throws SQLException{
		//判断当前用户是否存在已验证的手机号
		TMember member = (TMember)this.getSession().getAttribute("member");
		member = tmembermanager.selectByPrimaryKey(member.getId());
		if(member.getEmail() != null && member.getEmail().trim().length() > 0 && member.getIsEmailCheck() == 1){
			this.getRequest().setAttribute("email", dealEmail(member.getEmail()));
		}
		
		return "toEmailUpdateValidate";
	}
	public String toEmailUpdateInput(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		String randomUUID = getRequest().getParameter("randomUUID");
		String randomUUIDCache = (String) MemCached.getmcc().get(member.getUserName()+"_password_validate_pass");
		if(randomUUID != null && randomUUID.equals(randomUUIDCache)  ){
			return "toEmailUpdateInput";
		}else{
			this.getRequest().setAttribute("email",member.getEmail());
			return "toEmailUpdateValidate";
		}
	}
	public String toEmailUpdateSend(){
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		String email = (String) MemCached.getmcc().get(member.getUserName()+"_email");
		
		if(email != null && email.trim().length() > 0){
			String emailAddress = "http://mail."+email.substring(email.indexOf("@")+1, email.length());
			this.getRequest().setAttribute("emailAddress",emailAddress);
			this.getRequest().setAttribute("email",dealEmail(email));
		}
		return "toEmailUpdateSend";
	}
	public String toEmailUpdateSuccess(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		getRequest().setAttribute("email", dealEmail(member.getEmail()));
		return "toEmailUpdateSuccess";
	}
	public static void main(String[] args) {
		//MemCached.getmcc().set("test", "mytest", new Date(30*1000));
		//MemCached.getmcc().set
		//MemCached.getmcc().delete("test");
		System.out.println((String)MemCached.getmcc().get("test"));
	}
	public String dealEmail(String email){
		if(email.trim().indexOf("@") < 5){
			return email.trim();
		}
		return email.substring(0, 2)+"****"+email.substring(email.indexOf("@")-2,email.indexOf("@"))+email.substring(email.indexOf("@"), email.length());
	}
	
	public String toMobileUpdateValidate(){
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member != null){
			this.getRequest().setAttribute("mobile", member.getMobile().substring(0, 3)+"****"+member.getMobile().substring(member.getMobile().length()-4, member.getMobile().length()));
		}
		return "toMobileUpdateValidate";
	}
	
	/*
	 * 发送验证码
	 */
	public void validateMobileCode() throws Exception {
		int flag = -1;
		String username = null;
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}else{
			username = member.getMobile();
		}
		
		String captcha = CodeUtil.getVcode(4);
		String phoneCode = this.getRequest().getParameter("phoneCode");
		String rand = (String) this.getSession().getAttribute("rand");
		MemCached.getmcc().set(username+"membercenter",captcha,new Date(1000*300));
		System.out.println("captcha.........."+captcha);
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		PrintWriter out = this.getResponse().getWriter();
		if (username != null && pattern.matcher(username).matches()) {
			if(phoneCode.equalsIgnoreCase(rand)){
				try {
					Map<String, String> map = new HashMap<String, String>();
					map.put("mobiles", username);
					String smsContent = SmsMessagesConfig.getProperties().getProperty("SMSVerificationCode").replace("{SMSVerificationCode}", captcha);
					map.put("smsContent", smsContent);
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
	
	/*
	 * 发送验证码
	 */
	public void validateMobileCodeForUpdate() throws Exception {
		int flag = -1;
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}
		
		String mobile = this.getRequest().getParameter("mobile");
		String captcha = CodeUtil.getVcode(4);
		String randCode = this.getRequest().getParameter("randCode");
		String rand = (String) this.getSession().getAttribute("rand");
		 MemCached.getmcc().set(mobile+"mobileupdate",captcha,new Date(1000*300));
		 System.out.println("captcha.........."+captcha);
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		PrintWriter out = this.getResponse().getWriter();
		if (mobile != null && pattern.matcher(mobile).matches()) {
			if(randCode.equalsIgnoreCase(rand)){
				try {
					Map<String, String> map = new HashMap<String, String>();
					map.put("mobiles", mobile);
					String smsContent = SmsMessagesConfig.getProperties().getProperty("SMSVerificationCode").replace("{SMSVerificationCode}", captcha);
					map.put("smsContent", smsContent);
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
	/*
	 * 发送验证码
	 */
	public void validateSmsCode() throws Exception {
		int flag = -1;
		String username = null;
		
		String smsCode = getRequest().getParameter("smsCode");
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}else{
			username = member.getMobile();
		}
		
		String captcha = (String) MemCached.getmcc().get(username+"membercenter");
		if(captcha == null || captcha.trim().length() <= 0){
			flag = 3;//手机验证码已过期
		}else{
			if(smsCode.trim().equals(captcha)){
				flag = 1;//验证通过
				MemCached.getmcc().delete(username+"membercenter");
				this.getSession().setAttribute("mobile_validate_pass",true);
			}else{
				flag = 2;//验证码不正确
			}
		}
		if(flag != 1){
			this.getSession().setAttribute("mobile_validate_pass",false);
		}
		
		PrintWriter out = this.getResponse().getWriter();
		out.print(flag);
		out.close();
	}
	
	/*
	 * 发送验证码
	 */
	public void validateSmsCodeForUpdate(){
		int flag = -1;
		String mobile = this.getRequest().getParameter("mobile");
		
		String smsCode = getRequest().getParameter("smsCode");
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		try {
			String captcha = (String) MemCached.getmcc().get(mobile+"mobileupdate");
			if(captcha == null || captcha.trim().length() <= 0){
				flag = 3;//手机验证码已过期
			}else{
				if(smsCode.trim().equals(captcha)){
					flag = 1;//验证通过
					//修改手机号
					if(tleadermanager.updateMemberMobileBind(member, mobile)){
						member.setMobile(mobile);
						this.getSession().setAttribute("member", member);
					}else{
						flag = 2;
					}
				}else{
					flag = 2;//验证码不正确
				}
			}
			
			PrintWriter out = this.getResponse().getWriter();
			out.print(flag);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toMobileUpdateCaptcha(){
		if(this.getSession().getAttribute("mobile_validate_pass")!=null && (Boolean)this.getSession().getAttribute("mobile_validate_pass") == true){
			return "toMobileUpdateCaptcha";
		}else{
			TMember member = (TMember)this.getSession().getAttribute("member");
			if(member != null){
				this.getRequest().setAttribute("mobile", member.getMobile().substring(0, 3)+"****"+member.getMobile().substring(member.getMobile().length()-4, member.getMobile().length()));
			}
			return "toMobileUpdateValidate";
		}
	}
	public String toMobileUpdateSuccess() throws IOException{
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return null;
		}else{
			String mobile = member.getMobile();
			this.getRequest().setAttribute("mobile", mobile);
		}
		return "toMobileUpdateSuccess";
	}
	
	public void validateMobileUnique() throws SQLException, IOException{
		String mobile = this.getRequest().getParameter("mobile");
		if(mobile != null && mobile.trim().length() > 0){
			TMemberExample tMemberExample = new TMemberExample();
			tMemberExample.createCriteria().andMobileEqualTo(mobile.trim());
			
			int flag = -1;
			List tmemberList = tmembermanager.selectByExample(tMemberExample);
			if(tmemberList != null && tmemberList.size() > 0){
				flag = 0;
			}else{
				flag = 1;
			}
			PrintWriter out = this.getResponse().getWriter();
			out.print(flag);
			out.close();
		}
	}
	
	public void validatePasswordCode() throws IOException{
		String password = this.getRequest().getParameter("password");
		String randCode = this.getRequest().getParameter("randCode");
		
		int flag = -1;
		
		if(password == null || password.trim().length() == 0){
			flag = 4;//密码不能为空
			writeFlag(flag);
			return;
		}
		if(randCode == null || randCode.trim().length() == 0){
			flag = 5;//验证码不能为空
			writeFlag(flag);
			return;
		}
		
		String rand = (String) this.getSession().getAttribute("rand");
		if(!randCode.equalsIgnoreCase(rand)){
			flag = 2;//验证码不正确
			writeFlag(flag);
			return;
		}
		
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}
		if (!CustomDigestUtils.md5Hex(password, member).equals(
				member.getPassword())  && !MD5.MD5("111"+password+"yao").equals(
						member.getPassword())) {
			flag = 3;//密码不正确
			writeFlag(flag);
			return;
		}else{
			flag = 1;//密码不正确
			writeFlag(flag);
			return;
		}
		
		
	}
	
	public boolean checkEmailIsExist(String email) throws Exception{
		if(email == null || email.trim().length() <= 0){
			return false;
		}
		
		TMemberExample e = new TMemberExample();
		e.createCriteria().andEmailEqualTo(email.trim());
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			return true;
		}
		return false;
	}
	
	public void sendMail() throws Exception{
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			getResponse().sendRedirect("/login/login!index.action");
			return;
		}
		
		String email = this.getRequest().getParameter("email");
		String type = this.getRequest().getParameter("type");//1:绑定邮箱 2:修改邮箱 
		int flag = -1;
		if(email == null || email.trim().length() <= 0){
			flag = 0;
			writeFlag(flag);
			return;
		}
		
		if(checkEmailIsExist(email.trim())){
			flag = 1;//邮箱已经存在
			writeFlag(flag);
			return;
		}
		
		String randomUUID = CodeUtil.getVcode(8);
		
		MemCached.getmcc().set(member.getUserName()+"_emailCheck", randomUUID, new Date(120*60*1000));
		
		System.out.println("邮箱验证码 session-key:emailCheck    value:"+email+"|"+randomUUID);
		
		Map<Object,Object> contentMap = new HashMap<Object,Object>();
		contentMap.put("randomUUID", randomUUID);
		contentMap.put("username", member.getUserName());
		contentMap.put("time", com.rc.commons.util.DateUtil.getCurrDateTime());
		contentMap.put("link", "http://www.111yao.com/member/memberCenter!toEmailLink.action?randomUUID="+randomUUID+"&type="+type);
		if(mailSender.send(email.trim(), "111医药馆-验证邮箱", contentMap, "sendBindEmailLink.ftl")){
			MemCached.getmcc().set(member.getUserName()+"_email", email.trim(), new Date(120*60*1000));
			MemCached.getmcc().delete(member.getUserName()+"_password_validate_pass");
			flag = 2;//邮件发送成功
			writeFlag(flag);
			return;
		}else{
			flag = 3;//邮件发送失败
			writeFlag(flag);
			return;
		}
	}
	
	public void writeFlag(int flag) throws IOException{
		PrintWriter out = this.getResponse().getWriter();
		out.print(flag);
		out.close();
	}
	
	public String toMobileBindValidate(){
		return "toMobileBindValidate";
	}
	public String toMobileBindCaptcha(){
		return "toMobileBindCaptcha";
	}
	public String toMobileBindSuccess() throws IOException{
		TMember member = (TMember)this.getSession().getAttribute("member");
		if(member == null){
			this.getResponse().sendRedirect("/login/login!index.action");
			return null;
		}else{
			String mobile = member.getMobile();
			this.getRequest().setAttribute("mobile", mobile);
		}
		return "toMobileBindSuccess";
	}
	
	public void billEmailSave() throws SQLException, IOException{
		TMember member = (TMember)this.getSession().getAttribute("member");
		
		String billEmail = getRequest().getParameter("billEmail");
		if(billEmail != null && billEmail.trim().length() > 0){
			TMemberBaseMessageExt tMemberBaseMessageExt = tmemberbasemessageextmanager.selectByPrimaryKey(member.getId());
			if(tMemberBaseMessageExt == null){
				tMemberBaseMessageExt = new TMemberBaseMessageExt();
				tMemberBaseMessageExt.setMemberId(member.getId());
				tMemberBaseMessageExt.setBillEmail(billEmail);
				tmemberbasemessageextmanager.insertSelective(tMemberBaseMessageExt);
			}else{
				tMemberBaseMessageExt.setBillEmail(billEmail);
				tmemberbasemessageextmanager.updateByPrimaryKeySelective(tMemberBaseMessageExt);
			}
			writeFlag(1);
			return;
		}else{
			writeFlag(0);
		}
	}
	
	/**
	 * 用户头像
	 */
	public String headPortrait(){
		return "upload_head_portrait_base_message";
	}

	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}

	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}
	
	
}
