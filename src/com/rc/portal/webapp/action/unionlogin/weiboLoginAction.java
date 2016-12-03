package com.rc.portal.webapp.action.unionlogin;

import weibo4j.Oauth;
import weibo4j.model.WeiboException;

import com.rc.app.framework.webapp.action.BaseAction;

public class weiboLoginAction extends BaseAction{

	private static final long serialVersionUID = -5255397800264735215L;
	public void index() throws Exception{
		String weiboredirectUrl = this.getRequest().getParameter("weiboredirectUrl");
		try {
			String authorize = new Oauth().authorize("code");
        	if(weiboredirectUrl != null){
        		this.getSession().setAttribute("LoginRedirect", weiboredirectUrl);
        	}else{
        		this.getSession().removeAttribute("LoginRedirect");
        	}
			this.getSession().setAttribute("authorize", authorize);
			this.getResponse().sendRedirect(authorize);
		} catch (WeiboException e) {
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
