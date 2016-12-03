package com.rc.portal.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;
import com.opensymphony.xwork.util.OgnlValueStack;




/**
 * 会员登录验证
 * @author 刘天灵
 *
 */
public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 56589424541L;

	/** "重定向URL"参数名称 */
	private static final String REDIRECT_URL_PARAMETER_NAME = "redirectUrl";

	/** "会员"属性名称 */
	private static final String MEMBER_ATTRIBUTE_NAME = "member";
	
	public void destroy() {}

	public void init() {}
	

	/**
	 * 验证会员是否登录,否则跳转登录页
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
//		
//		TMemberManager tmembermanager = (TMemberManager)context.getBean("tmembermanager", TMemberManagerImpl.class);
//		
//		TMember selectByPrimaryKey = tmembermanager.selectByPrimaryKey(8L);
//		
//		ServletActionContext.getRequest().getSession().setAttribute(MEMBER_ATTRIBUTE_NAME,selectByPrimaryKey);
		
		Object loginUser = ServletActionContext.getRequest().getSession().getAttribute(MEMBER_ATTRIBUTE_NAME);
		
		if (loginUser == null) {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			//String redirectUrl = request.getRequestURL().toString();
			String redirectUrl = request.getQueryString() != null ? request.getRequestURI() + "?" + request.getQueryString() : request.getRequestURI();
			
			if(redirectUrl != null){
				OgnlValueStack stack = invocation.getStack();
				stack.getContext().put(REDIRECT_URL_PARAMETER_NAME, URLEncoder.encode(redirectUrl, "utf-8"));
			}
			
			return "login_page";
		}	
			
		return invocation.invoke();
	}
	

}
