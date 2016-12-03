package com.rc.portal.webapp.action.unionlogin;



import com.rc.app.framework.webapp.action.BaseAction;

public class yktLoginAction extends BaseAction{

	private static final long serialVersionUID = 8139283L;
	//private static final String tradeGroupId="aae00d234eb96d9b014eb9cac1fd0043";//测试
	private static final String tradeGroupId="f9a812584e72f2f9014e9119f9b659f6";//正式
	String returnURL = "http://www.111yao.com/login/yktAfterlogin!yktlogin.action" ;
	/**
	 * 发起授权的url
	 */
	String oauthurl = "http://www.ebaolife.com/oauth?tradeGroupId="+tradeGroupId+"&login=webLogin&returnURL="+returnURL;
	public void index(){
		String yktLoginRedirect = this.getRequest().getParameter("yktLoginRedirect");
		try {
        	if(yktLoginRedirect != null){
        		this.getSession().setAttribute("LoginRedirect", yktLoginRedirect);
        	}
        	System.out.println("yktLoginRedirect:"+yktLoginRedirect);
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
