package com.rc.portal.webapp.action.unionlogin;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.dst.client.util.ClientSubmit;
import com.rc.dst.client.util.ClientSubmitPublic;
import com.rc.portal.memcache.MemCached;
import com.rc.portal.service.OpenSqlManage;
import com.rc.portal.service.TLeaderManager;
import com.rc.portal.service.TMemberManager;
import com.rc.portal.service.TMemberThreeBindingManager;
import com.rc.portal.service.TSysParameterManager;
import com.rc.portal.util.CodeUtil;
import com.rc.portal.util.CookieUtil;
import com.rc.portal.vo.TMember;
import com.rc.portal.vo.TMemberExample;
import com.rc.portal.vo.TMemberThreeBinding;

public class BindingMobileAction extends BaseAction{

	private static final long serialVersionUID = 3226138682321686280L;
	private TMemberManager tmembermanager;
	private TMemberThreeBinding memberThreeBinding;
	private TMemberThreeBindingManager tmemberthreebindingmanager;
	private OpenSqlManage opensqlmanage;
	private TSysParameterManager tsysparametermanager;
	private TLeaderManager tleadermanager;
	
	public TLeaderManager getTleadermanager() {
		return tleadermanager;
	}
	public void setTleadermanager(TLeaderManager tleadermanager) {
		this.tleadermanager = tleadermanager;
	}
	public TSysParameterManager getTsysparametermanager() {
		return tsysparametermanager;
	}
	public void setTsysparametermanager(TSysParameterManager tsysparametermanager) {
		this.tsysparametermanager = tsysparametermanager;
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
	/*
	 * 绑定手机号
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void bindingMobile() throws Exception {
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		String mobile = this.getRequest().getParameter("mobile");
		String smsCode = this.getRequest().getParameter("phoneCode");
		String code = (String) MemCached.getmcc().get(mobile);
		String openId = (String) this.getRequest().getSession().getAttribute("demo_openid");
		String attribute = (String) this.getSession().getAttribute("LoginRedirect");
		//String openId = this.getRequest().getParameter("openId");
		Map map = new HashMap();
		map.put("binding_uuid", openId);
		// 根据openid判断用户信息是否已经存在
		memberThreeBinding = (TMemberThreeBinding) this.opensqlmanage.selectForObjectByMap(map,"t_member_three_binding.ibatorgenerated_selectByBindingUuid");
		if(memberThreeBinding!=null){
			Map openmap = new HashMap();
			openmap.put("binding_uuid", openId);
			TMember member = (TMember) opensqlmanage.selectObjectByObject(openmap, "t_member.selectmemberByOpenid");
			if(!smsCode.equalsIgnoreCase(code)){//code
				flag =1;//验证码不正确
			}else{
				if (!checkUserName(mobile)) {
					Map<String, Object> mobileMap = new HashMap<String, Object>();
					mobileMap.put("mobile", mobile);
					TMember mobileMember = (TMember) this.opensqlmanage.selectObjectByObject(mobileMap, "t_member.ibatorgenerated_selectMemberByMobile");
					String publicServiceUrl = tsysparametermanager.getKeys("public_service_url");
					Map<String,String> publicMap = new HashMap<String,String>();
					publicMap.put("memberid_old", String.valueOf(member.getId()));//第三方用户id
					publicMap.put("memberid_new", String.valueOf(mobileMember.getId()));//此手机号注册的用户id
					String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, publicServiceUrl+"memberMergeURIService");
					//String resultJsonstr =ClientSubmitPublic.getPublicService(publicMap, "http://192.168.101.136:8080/111_yao_common/sltRouter?method=memberMergeURIService");
					JSONObject resultJson = JSONObject.fromObject(resultJsonstr);
					System.out.println("返回的resultJson:------>："+resultJson);
					if(resultJson.get("code").equals("1")){
						this.getSession().setAttribute("member", mobileMember);
						flag=2;//绑定成功
						System.out.println("绑定成功状态flag---------》："+flag);
					}else{
						flag=3;//账号异常,请联系客服
					}
				}else{
					member.setMobile(mobile);
					member.setIsMobileCheck(1);
					tmembermanager.updateByPrimaryKeySelective(member);
					this.getSession().setAttribute("member", member);
					CookieUtil.addCookie(getRequest(), getResponse(), "username", member.getUserName(), 7*24*60*60, "/", "", false);
					flag=2;//绑定成功
				};
			}
		}else {
			flag=3;//数据异常
		}
		out.print(flag);
		out.close();
	}
	/*
	 * 发送验证码
	 */
	public void validateMobileCode() throws Exception {
		String captcha = CodeUtil.getVcode(4);
		String username = this.getRequest().getParameter("mobile");
		MemCached.getmcc().set(username,captcha,new Date(300));
		Pattern pattern = Pattern.compile("^[1][3,4,7,5,8][0-9]{9}$"); // 验证手机号
		int flag = -1;
		PrintWriter out = this.getResponse().getWriter();
		if (username != null && pattern.matcher(username).matches()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("mobiles", username);
			map.put("smsContent","您的111医药馆验证码:"+captcha+"。影视明星何政军先生推荐的中国好药房@111医药馆！");
			String YAO_GATEWAY_URL = tsysparametermanager.getKeys("sms");
			String buildRequestBySMS = ClientSubmit.buildRequestBySMS(map,YAO_GATEWAY_URL);
			System.out.println(buildRequestBySMS);
			flag=0;
		}
		System.out.println("验证码captcha----------》："+captcha);
		out.print(flag);
		out.close();
	}
	/*
	 * 弹窗
	 */
	public String index(){
		return "popup";
	}
	public boolean checkUserName(String username) throws Exception{
		TMemberExample e = new TMemberExample();
		e.createCriteria().andMobileEqualTo(username);
		int countByExample = this.tmembermanager.countByExample(e);
		if(countByExample > 0){
			return false;
		}
		return true;
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
