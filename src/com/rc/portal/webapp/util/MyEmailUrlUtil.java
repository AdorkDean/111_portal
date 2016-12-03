package com.rc.portal.webapp.util;

public class MyEmailUrlUtil {
	public static String getemailURL(String domainsuffix){
		String url="";
		/*腾讯邮箱*/
		if(domainsuffix.equals("qq.com")||domainsuffix.equals("vip.qq.com")||domainsuffix.equals("foxmail.com")){
			url = "http://mail.qq.com";
		}
		/*网易邮箱*/
		else if(domainsuffix.equals("163.com")||domainsuffix.equals("126.com")||domainsuffix.equals("yeah.net")){
			url = "http://email.163.com/";
		}
		/*雅虎邮箱*/
		else if(domainsuffix.equals("yahoo.com.cn")||domainsuffix.equals("yahoo.cn")){
			url = "http://mail.cn.yahoo.com/";
		}
		/*新浪邮箱*/
		else if(domainsuffix.equals("vip.sina.com")||domainsuffix.equals("sina.com")){
			url = "http://mail.sina.com.cn/";
		}
		/*搜狐邮箱*/
		else if(domainsuffix.equals("sohu.com")){
			url="http://mail.sohu.com/";
		}
		/*139邮箱*/
		else if(domainsuffix.equals("139.com")){
			url="http://mail.10086.cn/";
		}
		/*189邮箱*/
		else if(domainsuffix.equals("189.cn")){
			url="http://webmail1.189.cn";
		}
		/*hotmail邮箱*/
		else if(domainsuffix.equals("example.com")){
			url="http://www.hotmail.com";
		}
		/*outlook邮箱*/
		else if(domainsuffix.equals("outlook.com")){
			url="http://www.outlook.com/";
		}
		/*返回360邮箱导航*/
		else{
			url="http://hao.360.cn/mianfeiziyuan.html";
		}
		
		return url;
	}
}
