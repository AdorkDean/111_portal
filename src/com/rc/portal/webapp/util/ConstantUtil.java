package com.rc.portal.webapp.util;
/**
 * @author 作者 尹滨  E-mail:yinbinhome@163.com
 * @version 创建时间：2010-4-9 下午04:13:18
 * 类说明
 */
public class ConstantUtil {
	public final static int MOBLIE_AUTHCODE_NUMUBER=100000;//每天可发送的手机短信次数
	public final static int MOBLIE_AUTHCODE_TIME=5*60*1000;//验证码 缓存时间5分钟
	public final static int MOBLIE_AUTHCODE_TIME1=30*60*1000;//新的验证码为30分钟
	public final static int MOBLIE_AUTHCODE_NUMBER_TIME=24*60*60*1000;//每天次数纪录时间 缓存时间24小时
	public final static int MAIL_AUTHCODE_TIME=24*60*60*1000;//邮箱绑定 缓存时间24小时
	public final static String MOBLIE_AUTHCODE_PREFIX="MOBLIE_AUTHCODE_";//缓存 KEY 前缀 ：+UID 验证码 ：+UID+DAY 次数 
	public static String DOCTYPE="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";
	public final static int COOKIE_TIME = 24*60*60; //购物车COOKIE的时间 1天
	public final static String COOKIE_NAME = "smallcart"; //购物车中信息的名称
	public final static String COOKIE_KEY = "guoyao";
	public final static String AJAXUCSTR="_AJAX_UC_SYNCHRO_";
	
	public final static String EMAIL_URL="/userCenter/userCenter!emailBinding.action"; //出错后跳转路径
	public final static String EMAIL_URL_LOGIN="/login/login!userLogin.action"; // 登录地址
	public final static String SESSION_USERNAME="_USERINFO_MODEL_";//session里的登录信息，对象
	public final static String SSOMODEL = "_SSO_MODEL_";//sso在session对象的名字
	public final static String PASSWORD_SRC="jkr99.com"; //用户密码盐值
	
	
	public final static String COOKIE_NAME_SMALLCART = "smallcart"; //小购物车
	public final static String COOKIE_NAME_AGAINSMALLCART = "againsmallcart"; //再次加入小购物车	
	public final static int SMALLCART_NUM = 10; //购物车上线
	
	public final static String PWD_KEY="jkr99.com";
	
	public final static String CHARACTER = "\u1234";   //收货地址分隔符
	
}
