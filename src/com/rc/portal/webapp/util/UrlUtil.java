/**
 * Copyright 2009-2010 wozhongla.com, Inc. All rights reserved.
*  @author zgwu
*  @version 3.0
*  @refine 
**/
package com.rc.portal.webapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public final class UrlUtil {
	private UrlUtil(){}
	
	/**
	 * 获取基本的域名
	 * @param request = HttpServletRequest
	 * **/
	public static String getBaseDomain(HttpServletRequest request){
//		String url=request.getParameter("domain");
//		if(StringUtils.isEmpty(url)){
//			url=getBaseDomain_str(request);
//		}
//		return url;
//	}	
//	
//	public static String getBaseDomain_str(HttpServletRequest request){
		String url = request.getRequestURL().toString();
		
		//去掉请求头
		url = url.replaceAll("http://","");
		
		//获取请求地址中第一个“/”的位置
		int index = url.indexOf("/");
		
		//如果有“/”,那么将“/”和“/”后面的字符串省略掉。
		if(index != -1)
			url = url.substring(0,index);
		return url;
	}
	
	/***************************************************************************
	 * 获取来访地址的域名
	 * 
	 * @param request=HttpServletRequest
	 * @return 返回解析出的域名
	 **************************************************************************/
	public static String getDomain(HttpServletRequest request) {
		try {

			String url = request.getHeader("Referer");
			// 去掉请求头
			url = url.replaceAll("http://", "");

			// 获取请求地址中第一个“/”的位置
			int index = url.indexOf("/");

			// 如果有“/”,那么将“/”和“/”后面的字符串省略掉。
			if (index != -1)
				url = url.substring(0, index);
			return url;
		} catch (Exception e) {
			return null;
		}
	}
	public static String convertToHref(String Str)

	{

	       if (Str==null||Str.equals("")) return Str;

	       Matcher matcher=null;

	       Pattern pattern=null;

	       String str2="";

	       pattern = Pattern.compile("(http://[A-Za-z0-9\\./=\\?%\\-&_~`@':+!]+)|(www\\.[A-Za-z0-9\\./=\\?%\\-&_~`@':+!]+)",Pattern.CASE_INSENSITIVE);

	       matcher = pattern.matcher(Str);

	       StringBuffer stringbuffer = new StringBuffer();

	       for(; matcher.find(); matcher.appendReplacement(stringbuffer, str2))

	      {

	              if(matcher.group(2)!=null)

	                     str2 = "<a href=\"http://" + matcher.group(2) + "\" target=\"_blank\"><font color=\"#3333FF\">"+matcher.group(2)+"</font></a>";

	             else

	                      str2 = "<a href=\"" + matcher.group(1) + "\" target=\"_blank\"><font color=\"#3333FF\">"+matcher.group(1)+"</font></a>";

	      }

	      matcher.appendTail(stringbuffer);

	      return stringbuffer.toString();

	}

	public static void main(String[] args){
		String url = "http://www.6688.com:8080/lottory/Shop/kqshow.aspx?msg=success!&span_Message=%e6%94%af%e4%bb%98%e6%88%90%e5%8a%9f%ef%bc%81&fee=1&bankDealId=0805011839&bankId=ABC&ext1=&payAmount=1&dealId=84441983&orderTime=20090805141738&signMsg=AE1CB50A172047DF983C9D56F3285738&payType=10&language=1&errCode=&version=v2.0&ext2=&signType=1&orderAmount=1&orderId=0908050023&dealTime=20090805141743&merchantAcctId=1001692154601&payResult=10";
		// 去掉请求头
		url = url.replaceAll("http://", "");

		// 获取请求地址中第一个“/”的位置
		int index = url.indexOf("/");

		// 如果有“/”,那么将“/”和“/”后面的字符串省略掉。
		if (index != -1)
			url = url.substring(0, index);
		
		if(url.indexOf("6688.com")!=-1)
			System.out.println(" true ");
		System.out.println(url);
	}
}