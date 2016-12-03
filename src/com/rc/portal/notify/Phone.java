package com.rc.portal.notify;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.rc.portal.util.InfoUtil;
import com.rc.portal.webapp.util.MD5;

public class Phone {
	
	
	public static void main(String[] args) throws HttpException, IOException {
		
		String phone = "15910905145";
		String text = InfoUtil.getInstance().getInfo("phone", "message.content");
		text = text.replace("code", randCode());
	    boolean bool = sendMessage(phone,text);
		
	}
	
	public static boolean sendMessage(String phone,String text){
		
		System.out.println("短信文本："+text);
		String user = InfoUtil.getInstance().getInfo("phone", "user");//"zs_jiesai";
		String pwd = MD5.MD5(InfoUtil.getInstance().getInfo("phone", "password"));
		String uri = InfoUtil.getInstance().getInfo("phone", "uri");
		String other = InfoUtil.getInstance().getInfo("phone", "other");
		try {
			String content = java.net.URLEncoder.encode(text,"GBK");
			System.out.println("content="+content);
			String url = uri+"?user="+user+"&password="+pwd+"&tele="+phone+"&msg="+content+"&"+other;
			HttpClient httpClient = new HttpClient();
			HttpMethod  httpMethod = new PostMethod(url);
			httpClient.executeMethod(httpMethod);
			String back = httpMethod.getResponseBodyAsString();
			System.out.println("back="+back);
			boolean isSend = back.startsWith("ok");
			System.out.println("isSend="+isSend);
			if(isSend){
				System.out.println("短信发送成功");
			}else{
				System.out.println("短信发送失败");
			}
			
			return isSend;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String randCode(){
		String sRand = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		System.out.println(sRand);
		return sRand;
	}

}
