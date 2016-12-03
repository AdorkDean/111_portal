package com.rc.portal.util;

public class MathRandomUtil {
	/*
	 * n代表生成几位小数，
	 */
	public static String ramdom(int n) {
		int[] a = new int[n];
		String str = "";
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random()*7+1);
			str += a[i];
		}
		return str;
	}
	
	
	
	
	public static void main(String[] args) {
		String qqUserId = ramdom(5)+"_"+ramdom(5);
		System.out.println(qqUserId);
	}

}
