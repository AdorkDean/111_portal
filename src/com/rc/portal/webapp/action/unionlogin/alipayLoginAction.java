package com.rc.portal.webapp.action.unionlogin;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.rc.app.framework.webapp.action.BaseAction;
import com.rc.portal.alipay.config.AlipayConfig;
import com.rc.portal.alipay.util.AlipaySubmit;

public class alipayLoginAction extends BaseAction {

	private static final long serialVersionUID = 1448778296932625000L;
	// 目标服务地址 //必填
	private static String target_service = "user.auth.quick.login";
	// 防钓鱼时间戳 //若要使用请调用类文件submit中的query_timestamp函数
	private static String anti_phishing_key = "";
	// 客户端的IP地址 //非局域网的外网IP地址，如：221.0.0.1
	private static String exter_invoke_ip = "106.2.186.210";
	private static String action = "https://mapi.alipay.com/gateway.do?_input_charset=utf-8";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void index() throws Exception {
		// 把请求参数打包成数组
		PrintWriter out = this.getResponse().getWriter();
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.auth.authorize");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("target_service", target_service);
		sParaTemp.put("return_url",AlipayConfig.return_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

		// 建立请求
		Map<String, String> buildRequestNew = AlipaySubmit.buildRequestNew(sParaTemp, "get", "确认");
		buildRequestNew.put("action", action);
		JSONObject json = JSONObject.fromObject(buildRequestNew);
		result = json.toString();
		String alipayRedirectUrl = this.getRequest().getParameter("alipayRedirectUrl");
		if (alipayRedirectUrl != null) {
			this.getSession().setAttribute("LoginRedirect",alipayRedirectUrl);
		} else {
			this.getSession().removeAttribute("LoginRedirect");
		}
		out.print(result);
		out.close();
	}

	/*
	 * test
	 */
	public String returnAli() {

		return "test";
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
