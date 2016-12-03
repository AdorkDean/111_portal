package com.rc.portal.payplugin.payWzf.util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 '============================================================================
 'api说明：
 'createSHA1Sign创建签名SHA1
 'getSha1()Sha1签名
 '============================================================================
 '*/
public class Sha1Util {

	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util
				.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	// 创建签名SHA1
	public static String createSHA1Sign(Map<String, String> signParams)
			throws Exception {

		/** 排序 **/
		List<String> keys = new ArrayList<String>(signParams.keySet());
		Collections.sort(keys);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = signParams.get(key);
			sb.append(key + "=" + value.trim() + "&");

		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
		return getSha1(params);
	}

	/**
	 * 排序拼成&字符串
	 * 
	 * @param signParams
	 * @return
	 * @throws Exception
	 */
	public static String createSHA1Signfore(Map<String, Object> signParams)
			throws Exception {

		/** 排序 **/
		List<String> keys = new ArrayList<String>(signParams.keySet());
		Collections.sort(keys);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = (String) signParams.get(key);
			if (value == null || value.equals("")) {
				continue;
			}
			sb.append(key + "=" + value.trim() + "&");

		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
		return params;
	}

	/**
	 * 排序拼成&字符串 value urlencode
	 * 
	 * @param signParams
	 * @return
	 * @throws Exception
	 */
	public static String createSignEncode(Map<String, Object> signParams)
			throws Exception {

		/** 排序 **/
		List<String> keys = new ArrayList<String>(signParams.keySet());
		Collections.sort(keys);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = (String) signParams.get(key);
			sb.append(key + "=" + URLEncoder.encode(value.trim()) + "&");

		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
		return params;
	}

	// Sha1签名
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("GBK"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
