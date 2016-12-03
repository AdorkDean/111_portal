package com.rc.portal.util;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 
 * @author BABY
 * cookie管理、搜索关键字管理、自动登录
 */
public abstract class cookieManager {

	/**
	 * 设置 cookie
	 * @author BABY  
	 * @param request
	 * @param response
	 * @param name 
	 * @param value 
	 * @param maxAge
	 */
	public static void addCookie(HttpServletRequest request,HttpServletResponse response,String name,String value,int maxAge){
		try {
	
		value = URLEncoder.encode(value,"UTF-8");
		Cookie cookie=new Cookie(name,value);
		cookie.setPath("/");
		if(maxAge>0) cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 * @param domain
	 *       主域
	 */
	public static void addCookie(HttpServletRequest request,HttpServletResponse response,String name,String value,int maxAge,String domain){
		try {
	
		value = URLEncoder.encode(value,"UTF-8");
		Cookie cookie=new Cookie(name,value);
		cookie.setPath("/");
		cookie.setDomain(domain);
		if(maxAge>0) cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除 cookie
	 * @param request
	 * @param response
	 * @param name
	 */
	public static void delCookie(HttpServletRequest request,HttpServletResponse response,String name){
		Cookie cookie=new Cookie(name,null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	/**
	 * 根据 cookiename 获得值
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookieValueByName(HttpServletRequest request,String name){
		Map<String,Cookie> ReadCookieMap=ReadCookieMap(request);
		try {
			if(ReadCookieMap.containsKey(name)){
				Cookie cookie=(Cookie)ReadCookieMap.get(name);
				String value;
				value = URLDecoder.decode(cookie.getValue(),"UTF-8");
				return value;
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 * 将 cookie 封装到 MAP里
	 * @param request
	 * @return Map<String,Cookie> 
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();  
		Cookie[] cookies = request.getCookies();  
			if(null!=cookies){  
			for(Cookie cookie : cookies){  
				cookieMap.put(cookie.getName(), cookie);  
			}  
		}  
		return cookieMap;  
	} 
	/**
	 * 判断 cookie 是否存在
	 * @param request
	 * @param name
	 * @return true:存在  false:不存在
	 */
	public static boolean isCookieByName(HttpServletRequest request,String name){
		Map<String,Cookie> ReadCookieMap=ReadCookieMap(request);
		if(ReadCookieMap.containsKey(name)){
			return true;
		}
		return false;
	}
   /**
    * 获得 YYYYMMDDHHmmss + 8 随机数
    * @return YYYYMMDDHHmmss + 8 随机数
    */
	public static String getRandom(){
		StringBuffer strRandom = new StringBuffer(""); 
		SimpleDateFormat simple=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr=simple.format(new Date());
		strRandom.append(dateStr);
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Random r = new Random();   
		for(int i=0;i<8;i++){
			int n=Math.abs(r.nextInt(10)); 
				if(n>=0 && n<str.length){
					strRandom.append(str[n]);
				}
		}
		return strRandom.toString();
	}
}
