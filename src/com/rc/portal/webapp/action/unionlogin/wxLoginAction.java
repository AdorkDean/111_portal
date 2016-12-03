package com.rc.portal.webapp.action.unionlogin;

import java.net.URLEncoder;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.webapp.util.MD5;

public class wxLoginAction extends BaseAction{

	private static final long serialVersionUID = 111111111112L;
	public static String kappid = "wx8e633a8b9bb4bb31";
	public static String State=MD5.MD5(kappid);
	
	/**
	 * 授权回调的redirect_uri
	 */
	
	//String redirect_uri = "http://localhost:8082/111_portal/login/wxAfterlogin!wxlogin.action" ;
	String redirect_uri = "http://www.111yao.com/login/wxAfterlogin!wxlogin.action" ;
	
	/**
	 * 发起授权的url
	 */

	String oauthurl = "https://open.weixin.qq.com/connect/qrconnect?appid="+kappid+"&redirect_uri="+URLEncoder.encode(redirect_uri)+"&response_type=code&scope=snsapi_login&state="+State+"#wechat_redirect";

	public void index() {
		String wxredirectUrl = this.getRequest().getParameter("wxLoginRedirect");
		try {
        	if(wxredirectUrl != null){
        		this.getSession().setAttribute("LoginRedirect", wxredirectUrl);
        	}
        	System.out.println("wxLoginRedirect:"+wxredirectUrl);
        	this.getResponse().sendRedirect(oauthurl);
        } catch (Exception e) {
            e.printStackTrace();
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
