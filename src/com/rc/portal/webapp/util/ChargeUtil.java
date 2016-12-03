package com.rc.portal.webapp.util;

public class ChargeUtil {
	
	public static final short OPER_TYPE = 101;      //充值方式  网银充值
	
	public static final short CHARGE_SOURCE = 2;  //充值来源 web
	public static final short STATUS_NOT = 0;  //充值状态  未处理
	public static final short STATUS_ERROR = 2;  //充值状态
	
	
	public static final String WARES_DESCRIBE = "国药网充值" ;
	
	public static final String  MARK="#" ; //充值记录备注中的分割符
	
	public static final String CFT = "cft"; //财付通
	
	public static final String ZFBPAY = "zfbpay"; //支付宝即时到账
	
	public static final short CFT_NUMBER = 401; //财付通编号
	
	public static final short ZFBPAY_NUMBER = 101; //支付宝编号	
	
	public static final short CFT_UNIT = 100; //金额单位 分
	
	public static final String CFT_URL = "https://gw.tenpay.com/gateway/verifynotifyid.xml"; //财付通返回路径
	
	public static final int CFT_NOTIFY_OBJECT = 5; //财付通通知对象
	
	
}
