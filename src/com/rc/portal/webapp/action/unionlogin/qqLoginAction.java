package com.rc.portal.webapp.action.unionlogin;


import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import com.rc.app.framework.webapp.action.BaseAction;

public class qqLoginAction extends BaseAction{
	
	private static final long serialVersionUID = 132434324l;

	public void index() throws Exception {
		String qqredirectUrl=getRequest().getParameter("qqLoginRedirect");
		getResponse().setContentType("text/html;charset=utf-8");
		try {
        	String authorizeURL = new Oauth().getAuthorizeURL(this.getRequest());
    		
        	if(qqredirectUrl != null){
        		this.getRequest().getSession().setAttribute("LoginRedirect", qqredirectUrl);
        	}
        this.getResponse().sendRedirect(authorizeURL);
        } catch (QQConnectException e) {
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
