package com.rc.portal.commons;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;



public class DataUtil {
	/**
	 * 
	*    
	* 方法描述： 验证是否是数字，包含小数 
	* 创建人：hexiaoliang  
	* 创建时间：2010-3-25 下午05:29:39    
	* @param str
	* @return
	* @version   1.0
	*
	 */
	public static boolean isNumeric(String str){
		String pattern = "[0-9]+(.[0-9]+)?";  
		Pattern p = Pattern.compile(pattern);  
		Matcher m = p.matcher(str);  
		
		boolean flag =true;	
		if(str.indexOf(".")==-1&&"0".equals(String.valueOf(str.charAt(0))))
			flag=false;
		
		return  m.matches()&&flag; 
	} 
	
	/**
	 * 
	*    
	* 方法描述： 验证是否是正整数 
	* 创建人：hexiaoliang  
	* 创建时间：2010-3-26 下午03:51:53    
	* @param str
	* @return
	* @version   1.0
	*
	 */
	public static boolean isInteger(String str){
		String pattern = "[0-9]+?";  
		Pattern p = Pattern.compile(pattern);  
		Matcher m = p.matcher(str);  
		
		boolean flag =true;	
		if(str.indexOf(".")==-1&&"0".equals(String.valueOf(str.charAt(0))))
			flag=false;
		
		return  m.matches()&&flag; 
	}
	
	/**
	 * 
	*    
	* 方法描述：获取集群环境下客户端真实的ip地址  
	* 创建人：hexiaoliang  
	* 创建时间：2010-6-22 上午10:02:55    
	* @param request
	* @return
	* @version   1.0
	*
	 */
	public static String getIpAddr(HttpServletRequest request) {    
	      String ip = request.getHeader("x-forwarded-for");    
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	         ip = request.getHeader("Proxy-Client-IP");    
	     }    
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	         ip = request.getHeader("WL-Proxy-Client-IP");    
	      }    
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	          ip = request.getRemoteAddr();    
	     }    
	     return ip;    
	}    
	
	public static void main(String[] args){
		System.out.println(DataUtil.isInteger("-213"));
	}
	
	
	public static double getDoubleVal(Object data){
		double doubleVal = 0;
		try{
			doubleVal = Double.valueOf((String)data);
		}catch(Exception e){
			return 0;
		}
		
		return doubleVal;
		
	}
	
	public static int getIntVal(Object data){
		int intVal = -1;
		try{
			intVal = Integer.valueOf((String)data);
		}catch(Exception e){
			return -1;
		}
		
		return intVal;
		
	}
	
	public static long getLongVal(Object data){
		long val = 0;
		try{
			val = Long.valueOf((String)data);
		}catch(Exception e){
			return 0;
		}
		
		return val;
		
	}
	
	public static BigDecimal getBigDecimalVal(BigDecimal data){
		long val = 0;
		try{
			if(data == null){
				return new BigDecimal(0);
			}
			return data;
		}catch(Exception e){
			return new BigDecimal(0);
		}
		
		
	}
	
	public static BigDecimal getBigDecimalFromString(String data){
		try{
			if(data == null || data.trim().length() == 0){
				return new BigDecimal(-1);
			}else{
				return new BigDecimal(data);
			}
		}catch(Exception e){
			return new BigDecimal(-1);
		}
		
		
	}
	
	/*
	 * 把以逗号拼接的ids转化为long数组,如果包含非正常参数，返回null
	 * ids 如 1,2,3
	 * return Long[]  [1,2,3]
	 */
	public static Long[] getLongArrayFromString(String ids){
		if(ids == null){
			return null;
		}
		String[] idsStrArray = ids.split(",");
		Long[] idsLongArray = new Long[idsStrArray.length];
		for(int i=0; i<idsStrArray.length; i++){
			String temp = idsStrArray[i].trim();
			Long a = getLongVal(temp);
			if(a == 0){
				return null;
			}else{
				idsLongArray[i] = a;
			}
		}
		
		return idsLongArray;
	}
	
	
	public static String getTrimValue(String str){
		if(str == null){
			return null;
		}
		return str.trim();
	}
	
	public static Date getDateByString(String dateStr){
		if(dateStr == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		
		return date;
		
	}
	
	public static String getDateStrByObject(Object dateObj){
		if(dateObj == null){
			return null;
		}
		String dateStr;
		try {
			dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateObj);
		} catch (Exception e) {
			return null;
		}
		
		return dateStr;
		
	}
	/**
	 * 
	 * @param sex 男  or 女
	 * @return 1 男 2 女
	 */
	public static Integer parseSexFromStringToInt(String sex){
		if(sex == null){
			return null;
		}
		
		if(sex.trim().equals("男")){
			return 1;
		}
		if(sex.trim().equals("女")){
			return 2;
		}
		return null;
	}
	
	public static String getRoundPrice(Object priceObj){
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("0.00");  
		
		try{
			String price = String.valueOf(priceObj);
			BigDecimal   b   =   new   BigDecimal(price);  
			double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
			return df.format(f1);
		} catch (Exception e){
			BigDecimal   b   =   new   BigDecimal("0");  
			double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
			return df.format(f1);
		}
	}
	
	/**
	 * 
	*    
	* 方法描述：验证手机号   
	* 创建人：hexiaoliang  
	* 创建时间：2010-4-9 下午08:41:50    
	* @param str
	* @return
	* @version   1.0
	*
	 */
	public static boolean validateMobile(String str){
		return str.matches("[1]\\d{10}");
	}
}
