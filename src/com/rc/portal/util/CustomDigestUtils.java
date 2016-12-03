package com.rc.portal.util;

import org.apache.commons.codec.digest.DigestUtils;

import com.rc.portal.vo.TMember;


/**
 * 自定义MD5加密方法 此方式仅限于前台用户注册登录验证使用
 * @author DreamSea
 *
 */
public class CustomDigestUtils extends DigestUtils{

	
	/**
	 * 密码新逻辑
	 * @param password
	 * @param member
	 * @return
	 */
	public static String md5Hex(String password,TMember member) {
		String date=member.getMd5Data();
		if(member==null||member.getUserName()==null){
			new Exception("请先设置用户名!");
			return "";
		}
		
		return "s"+DigestUtils.md5Hex(DigestUtils.md5Hex(password)+member.getUserName()+date).substring(0, 31);
	}
}
