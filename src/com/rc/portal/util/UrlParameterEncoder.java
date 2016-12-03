package com.rc.portal.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

import com.rc.commons.util.StringUtil;

//utf-8 gbk
public class UrlParameterEncoder {
	public static String getUrlParameterEncodeStr(String para,String encode) {
		if (StringUtils.isNotEmpty(para)) {
			try {
				String encodePara = java.net.URLEncoder.encode(para, encode);
				encodePara = StringUtil.Replace(encodePara, "%2F", "%252F");
				return encodePara;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "";
			}
		} else {
			return "";
		}
	}

	public String getUrlParameterEncodeStrBak(String para) {
		if (StringUtils.isNotEmpty(para)) {
			try {
				String encodePara = java.net.URLEncoder.encode(para, "utf-8");
				return encodePara;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "";
			}
		} else {
			return "";
		}
	}

	public static String getUrlParameterDecodeStr(String para,String encode) {
		if (StringUtils.isNotEmpty(para)) {
			String decodePara = para;
			try {
				decodePara = java.net.URLDecoder.decode(para, encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return decodePara;
		} else {
			return "";
		}
	}

	public static void main(String[] argv) {
		System.out.println(getUrlParameterEncodeStr("三星/\\","utf-8"));
	}
}