package com.rc.portal.webapp.action;

import com.rc.app.framework.webapp.action.BaseAction;

/**
 * 会员登录
 * @author 刘天灵
 *
 */
public class MemberLoginAction extends BaseAction{

	private static final long serialVersionUID = 564664641L;

	public Object getModel() {
		return null;
	}

	public void setModel(Object o) {
		
	}

	private String redirectUrl;
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * 登录
	 */
	public String index(){
		
		System.out.println("---------------------redirectUrl:"+redirectUrl);
		
		//登录完成之后将登录对象放到session
//		this.getSession().setAttribute("member", 对象);
		
		return "login";
		
	}
	
}
