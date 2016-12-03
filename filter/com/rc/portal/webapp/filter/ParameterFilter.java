package com.rc.portal.webapp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @author luoweifeng
 * 
 */
public class ParameterFilter implements Filter {
	protected final Logger log = Logger.getLogger(getClass());
	private static Pattern p = Pattern.compile("[a-zA-Z0-9\\.\\]\\[_'\\s]+");
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		request.setCharacterEncoding("utf-8");
		HttpServletResponse response = (HttpServletResponse) res;
		Enumeration<?> pStr = request.getParameterNames();

		HttpServletRequest st=(HttpServletRequest)req;
		String url=st.getServerName()+":"+st.getServerPort()+st.getRequestURI()+"?"+st.getQueryString();
		log.info("[请求]url="+url);
		String temp=st.getRequestURI()+st.getServletPath();
		if(temp.equals("/catesearch/category!firstsearch.action")){
			while (pStr.hasMoreElements()) {
				Object pv = pStr.nextElement();
				if (pv != null) {
					if (chkword(pv.toString())) {
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
						out.println("<HTML>");
						out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
						out.println("  <BODY>");
						out.println("  request is denied!!!");
						out.println("  </BODY>");
						out.println("</HTML>");
						out.flush();
						out.close();
						return;
					}else{
						continue;
					}
				}
			}
		}
		while (pStr.hasMoreElements()) {
			Object pv = pStr.nextElement();
			if (pv != null) {
				Matcher m = p.matcher(pv.toString());
				if(m.matches()) {
					continue;
				} else {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
					out.println("<HTML>");
					out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
					out.println("  <BODY>");
					out.println("  request is denied!!!");
					out.println("  </BODY>");
					out.println("</HTML>");
					out.flush();
					out.close();
					return;
				}
			}
		}

		chain.doFilter(req, res);
	}
	/**
	 * 说明:验证敏感词汇
	 * @param word
	 * @return
	 */
	public boolean chkword(String word){
		
		if (word != null && word.equals("")) {
			word=word.trim();
			String keyw = word.toLowerCase();
			if (keyw.indexOf("select") > 0 || keyw.indexOf("update") > 0 || keyw.indexOf("insert") > 0 || keyw.indexOf("delete") > 0 || keyw.indexOf("script") > 0) {
				System.out.println("[含有敏感关键字] " + keyw);
				return true;
			}
			String regEx = "[\u4e00-\u9fa5\\w]+";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(word);
			boolean b = matcher.matches();
			if(!b){
				System.out.println("[含有敏感关键字] " + keyw);
				return true;
			}
			
		}
		return false;
	}	
	
	/**
	 * 判断数据特殊命令
	 * @param str
	 * @return
	 */
	public boolean judge(String str){
		str=str.toLowerCase();
		if(str.indexOf("select")>-1||str.indexOf("update")>-1 ||str.indexOf("delete")>-1||str.indexOf("truncate")>-1 || str.indexOf("create")>-1){
			return true;
		}
		return false;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public static void main(String[] args) {
		System.out.println(Pattern.matches("[a-zA-Z0-9\\.\\]\\[_'\\s]+", "cv@"));
	}

}