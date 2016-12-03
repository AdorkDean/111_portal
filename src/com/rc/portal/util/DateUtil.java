package com.rc.portal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {
	//protected final static Log _log = LogFactory.getLog(DateUtil.class);
	private static SimpleDateFormat dateformater;
	
	static java.text.SimpleDateFormat sdfShort = new java.text.SimpleDateFormat(
	"yyyyMMdd");
	static java.text.SimpleDateFormat sdfLong = new java.text.SimpleDateFormat(
	"yyyy-MM-dd");
	static java.text.SimpleDateFormat sdfLongTime = new java.text.SimpleDateFormat(
	"yyyyMMddHHmmss");
	static java.text.SimpleDateFormat sdfLongTimePlus = new java.text.SimpleDateFormat(
	"yyyy-MM-dd HH:mm:ss");
	static java.text.SimpleDateFormat sdfLongTimePlusMill = new java.text.SimpleDateFormat(
	"yyyyMMddHHmmssSSSS");
	private static long DAY_IN_MILLISECOND = 0x5265c00L;
	 /**
     * @param date   
     * @param format 日期格式
     * @return String
     * @author zhangyong
     * @return String 
     */
	public static String DateToStr(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
    		System.out.println("Date 转 String 类型失败: " + e);
			return null;
		}
	}
	
	
	/**
	 * 把字符型日期表达式转换成java.util.Date
	 * @param strDate 型如 "yyyy-M-dd" 的日期字符串
	 * @return 转换后的java.util.Date对象；转换失败返回null
	 */
	public Date parseDate(String strDate) {
		Date date = null;
		try {
			date = getDateFormater().parse(strDate);
		} catch (Exception ex) {
			//  System.err.println(ex.getMessage());
		}
		return date;
	}
	
	
	
	private DateFormat getDateFormater() {
		if (dateformater == null)
			dateformater = new SimpleDateFormat("yyyy-M-dd");
		return dateformater;
	}
	
	/**
	 * @author zhangyong
	 * @return DATE 型加具体的天数
	 * 
	 * @param Date date, int days*/
	public static Date dateAddDays(Date date, int days) {
		long now = date.getTime() + (long) days * DAY_IN_MILLISECOND;
		return new Date(now);
	}
	
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	
	public static void main(String[] args){
		/*Date dd=new Date();
		String d=DateUtil.dateTypeToString(dd, "yyyy-MM-dd HH:mm:ss");
		System.out.println("tiem "+d);*/
		
		String nowDateString=getStringOfNowDate("yyyy-MM-dd");
		DateUtil d=new DateUtil();
		Date dd=d.parseDate(nowDateString);
		System.out.println("string to date " +dateTypeToString(dd,"yyyy-MM-dd"));
		String s=dateTypeToString(dateAddDays(dd,1),"yyyy-MM-dd");
		System.out.println("string to date +1   " +s);
		
		/*System.out.println("当天:" + nowDateString+"-----"+getDateOfFirstDayInMonth());
		String firstDayInMoth=getStringOfFirstDayInMonth();
		System.out.println("该月第一天:" + firstDayInMoth);*/
		
		
		Date sa = strDateConvertToDate("2010-02-11 19:40:01","yyyy-MM-dd HH:mm:ss");
		System.out.println("aa"+DateToStr(sa,"yyyy-MM-dd HH:mm:ss"));
		
		
		
	}
	
	/**@return 将DATE 转换成字符性日期格式
	 * @author zhangyong
	 * @param Date date,String fFormatStr eg:yyyy-MM-dd HH:mm:ss */
	public static String dateTypeToString(Date date,String fFormatStr){
		//yyyy-MM-dd HH:mm:ss
		SimpleDateFormat dateformat=new SimpleDateFormat(fFormatStr);
		String strDate=dateformat.format(date);
		return strDate;
	}
	
	/**@param yyyy-MM-dd 
	 * @author zhangyong
	 * @获取当前的系统时间，并按照固定的格式初始话*/
	public static String getStringOfNowDate(String fFormatStr){
		String nowDateString=dateTypeToString(new Date(),fFormatStr);
		return nowDateString;
	}
	
	/**@param yyyy-MM-dd 
	 * @author zhangyong
	 * @获取当前的系统时间，并按照固定的格式初始话*/
	public static Date getDateOfNowDate(String fFormatStr){
		String nowDateString=dateTypeToString(new Date(),fFormatStr);
		return new DateUtil().parseDate(nowDateString);
	}
	
	/** 
	 * @ author zhangyong
	 * @ 获取当月的第一天，2009-05-01*/
	public static String getStringOfFirstDayInMonth() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String temp = sdf.format(date);
		String firstDayInMoth = "";
		firstDayInMoth = temp + "-01";
		
		return firstDayInMoth;

	}
	
	/** 
	 * @ author zhangyong
	 * @ 获取当月的第一天，2009-05-01*/
	public static Date getDateOfFirstDayInMonth() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String temp = sdf.format(date);
		String firstDayInMoth = "";
		firstDayInMoth = temp + "-01";
		
		return new DateUtil().parseDate(firstDayInMoth);

	}	/**
	 * Descrption:取得当前日期,格式为:yyyy-MM-dd HH:mm:ss
	 * @return String
	 * @throws java.lang.Exception
	 */
	public static String getPlusTime2(Date date)
	{
		
		if(date == null ) return null;
		try
		{
			String nowDate = sdfLongTimePlus.format(date);
			return nowDate;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	
	/**@return Date 字符串形式日期装换成date类型
	 * @author zhangyong
	 * @param String strDate,String fFormatStr  eg :yyyy-MM-dd HH:mm:ss
	 * */
	public static Date strDateConvertToDate(String strDate,String fFormatStr){
		java.util.Date birthday = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat(fFormatStr);
        try {
			birthday = sdf.parse(strDate);
			return birthday;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}	
}
