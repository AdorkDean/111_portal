package com.rc.portal.webapp.util;




import java.util.Random;

public class MyRandom {
	
	private String ip;
	
	public static void main(String[] args) {
		
		MyRandom ps = new MyRandom();
		System.out.println(ps.getIPTimeStampRand());
	}
	

	public MyRandom() {
	}

	public MyRandom(String ip) {
		this.ip = ip; // ���� ip��ַ
	}

	public String getTimeStamp() {
		
		return System.currentTimeMillis()+"";
	}

	public String getIPTimeStampRand() {
		StringBuffer buf = new StringBuffer();
		if (ip != null) {
			String str[] = this.ip.split("\\.");
			for (int i = 0; i < str.length; i++) {
				buf.append(this.addZero(str[i], 3));
			}
		}
		buf.append(this.getTimeStamp());
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			buf.append(rand.nextInt(10)) ;
		}
		return buf.toString() ;
	}

	private String addZero(String str, int len) {
		StringBuffer s = new StringBuffer();
		s.append(str);
		while (s.length() < len) {
			s.insert(0, "0");
		}
		return s.toString();
	}
}
