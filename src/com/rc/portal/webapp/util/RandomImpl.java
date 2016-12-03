package com.rc.portal.webapp.util;

import java.util.Random;

public class RandomImpl {

	
	public static String getNumber(int n){
		Random random = new Random();
		String sRand = "";
		for(int i = 0; i<n;i++){
			String rand = String.valueOf(random.nextInt(10));
			sRand+=rand;
		}
		return sRand.trim();
	}
	public static void main(String args[]){
		String s=RandomImpl.getNumber(6);
		System.out.print(":"+s);
	}
}
