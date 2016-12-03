package com.rc.portal.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import sun.io.ByteToCharConverter;
import sun.io.CharToByteConverter;

import com.rc.portal.webapp.util.StringArrayUtil;

/**
 * <p>公共方法类</p>
 * <p>提供字符串处理的实用方法集</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * @author Weiwenqi
 * @version 1.0
 *
 */

public class StringUtil
{
	public StringUtil()
	{
	}
	public static final String escapeForIntro(String string)
	{
		//			 String str = escapeHTMLTags(string);
		String str = string;
		str = replace(str, "\r\n", "<br>");
		str = replace(str, "\n", "<br>");
		str = replace(str, "'", "\\'");
		return replace(str, "\r", "");

	}
	/**
	 * 得到非空的字符串，若字符串对象为null，则返回""。
	 * @param objValue Object待转换的原字符串对象
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(Object objValue)
	{
		return (objValue == null ? "" : objValue.toString());
	}
	/**
	 * 得到非空的字符串，若字符串为null，则返回""。
	 * @param strValue String待转换的原字符串
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(String strValue)
	{
		return (strValue == null ? "" : strValue.trim());
	}
	/**
	 * 将中文转化成AscII码以便存入数据库
	 * @param s  中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToAscii(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("GBK");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}
	/**
	 * 将UTF-8转化成AscII码以便存入数据库
	 * @param s 中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToUTF(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("UTF-8");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}

	/**
	 * 将AscII字符转换成汉字
	 * @param s -  ASCII字符串
	 * @return 汉字
	 */
	public static String AsciiToChineseString(String s)
	{
		char[] orig = s.toCharArray();
		byte[] dest = new byte[orig.length];
		for (int i = 0; i < orig.length; i++)
			dest[i] = (byte) (orig[i] & 0xFF);
		try
		{
			ByteToCharConverter toChar = ByteToCharConverter.getConverter("GBK");
			return new String(toChar.convertAll(dest));
		}
		catch (Exception e)
		{
			System.out.println(e);
			return s;
		}
	}


	/**
	 * 用"0"补足一个字符串到指定长度
	 * @param str -  源字符串
	 * @param size - 补足后应达到的长度
	 * @return - 补零后的结果
	 */
	public static String fillZero(String str, int size)
	{
		String result;
		if (str.length() < size){
			char[] s = new char[size - str.length()];
			for (int i = 0; i < (size - str.length()); i++)
			{
				s[i] = '0';
			}
			result = new String(s) + str;
		}else{
			result = str;
		}
		return result;
	}

	/**
	 * 根据字符串（文件类型或者多行输入类型）获取字符串数组
	 * @param str1 String 输入字符串
	 * @return String[] 返回结果
	 */
	public static String[] getStrArryByString(String str1)
	{
		if (str1.indexOf("\t") > 0)
		{
			for (int i = 0; i < str1.length(); i++)
			{
				if (str1.substring(i, i + 1).equals("\t"))
				{
					str1 = str1.substring(0, i) + " " + str1.substring(i + 1, str1.length());
				}
			}
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str1, "\r\n");
		String[] strId = new String[stringTokenizer.countTokens()];
		int i = 0;
		while (stringTokenizer.hasMoreTokens())
		{
			strId[i] = stringTokenizer.nextToken();
			i++;
		}
		return strId;
	}
	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */
	public static boolean isValid(String inStr)
	{
		if (inStr == null)
		{
			return false;
		}
		else if (inStr.equals(""))
		{
			return false;
		}
		else if (inStr.equals("null"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param str inStr
	 * @return boolean
	 */	
	public static boolean checkNotNull(String str){
		boolean flag = false;
		
		if(str != null && str.trim().length() != 0)	
			flag = true;
		return flag;
	}
	/**
	 * 获得指定长度的空格
	 * @param spaceNum spaceNum
	 * @return String
	 */
	public static String getStrSpace(int spaceNum)
	{
		return getStrWithSameElement(spaceNum, " ");
	}
	/**
	 * 获得指定长度的字符串
	 * @param num int
	 * @param element String
	 * @return String
	 */
	public static String getStrWithSameElement(int num, String element)
	{
		if (num <= 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++)
		{
			sb.append(element);
		}
		return sb.toString();
	}
	/**
	 * 从右或左加空格
	 * @param strIn String
	 * @param totalLength int
	 * @param isRightAlign boolean
	 * @return String
	 */
	public static String getFillString(String strIn, int totalLength, boolean isRightAlign)
	{
		int spaceLength = 0;
		String spaces = null;
		String strOut = null;

		if (strIn == null)
		{
			strIn = "";
		}

		spaceLength = totalLength - strIn.length();

		if (spaceLength < 0)
		{
			spaceLength = 0;
		}
		spaces = StringUtil.getStrSpace(spaceLength);

		if (isRightAlign)
		{
			strOut = spaces + strIn;
		}
		else
		{
			strOut = strIn + spaces;

		}
		return strOut;
	}
	/**
	 * 以String类型返回错误抛出的堆栈信息
	 * @param t Throwable
	 * @return String
	 */
	public static String getStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		t.printStackTrace(pw);
		return sw.toString();
	}
	/**
	 * 转换字符串第一个字符为大写
	 * @param str String
	 * @return String
	 */
	public static String getStrByUpperFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 转换字符串第一个字符为小写
	 * @param str String
	 * @return String
	 */
	public static String getStrByLowerFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 通过字符串转换成相应的整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return int 转换完成的整型
	 * */
	public static int getStrToInt(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		int iValue = 0;
		try
		{
			iValue = new Integer(strValue.trim()).intValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的DOUBLE，并返回。
	 * @param strValue String 待转换的字符串
	 * @return double 转换完成的DOUBLE
	 * */
	public static double getStrToDouble(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		double dValue = 0;
		try
		{
			dValue = Double.parseDouble(strValue.trim());
		}
		catch (Exception ex)
		{
			dValue = 0;
		}
		return dValue;
	}

	/**
	 * 通过字符串转换成相应的短整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return short 转换完成的短整型
	 * */
	public static short getStrToShort(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		short iValue = 0;
		try
		{
			iValue = new Short(strValue.trim()).shortValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的长整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return long 转换完成的长整型
	 * */
	public static long getStrToLong(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		long lValue = 0;
		try
		{
			lValue = new Long(strValue.trim()).longValue();
		}
		catch (Exception ex)
		{
			lValue = 0;
		}
		return lValue;
	}

	public static String toLengthForEn(String str, int length)
	{
		if (null != str)
		{
			if (str.length() <= length)
			{
				return str;
			}
			else
			{
				str = str.substring(0, length - 2);
				str = str + "..";
				return str;
			}
		}
		else
		{
			return "";
		}
	}

	/**
	  * 降字符串转换成给定长度的字符串，如超出的话截断，并在最后以两个点结尾
	  * @param str String
	  * @param length int
	  * @return String
	  */
	public static String toLengthForIntroduce(String str, int length)
	{
		str = delTag(str);

		byte[] strByte = str.getBytes();
		int byteLength = strByte.length;
		char[] charArray;
		StringBuffer buff = new StringBuffer();
		if (byteLength > (length * 2))
		{
			charArray = str.toCharArray();
			int resultLength = 0;
			for (int i = 0; i < charArray.length; i++)
			{
				resultLength += String.valueOf(charArray[i]).getBytes().length;
				if (resultLength > (length * 2))
				{
					break;
				}
				buff.append(charArray[i]);

			}
			buff.append("..");
			str = buff.toString();
		}

		//		str = replace(str, "'", "\\'");
		str = replace(str, "\"", "\\\"");
		str = replace(str, "，", ",");
		return str;

	}

	public static String delTag(String str)
	{
		str = str + "<>";
		StringBuffer buff = new StringBuffer();
		int start = 0;
		int end = 0;

		while (str.length() > 0)
		{
			start = str.indexOf("<");
			end = str.indexOf(">");
			if (start > 0)
			{
				buff.append(str.substring(0, start));
			}
			if (end > 0 && end <= str.length())
			{
				str = str.substring(end + 1, str.length());
			}
			else
			{
				str = "";
			}

		}
		String result = buff.toString();

		while (result.startsWith(" "))
		{

			result = result.substring(result.indexOf(" ") + 1, result.length());

		}
		return result;

	}

	public static final String replace(String line, String oldString, String newString)
	{
		if (line == null)
		{
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0)
		{
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0)
			{
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;

	}
	//	Replace
	public static String Replace(String source, String oldString, String newString)
	{
		if (source == null)
		{
			return null;
		}
		StringBuffer output = new StringBuffer();
		int lengOfsource = source.length();
		int lengOfold = oldString.length();
		int posStart = 0;
		int pos;
		while ((pos = source.indexOf(oldString, posStart)) >= 0)
		{
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengOfold;
		}
		if (posStart < lengOfsource)
		{
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	//此函数前台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtml(String s)
	{
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		s = Replace(s, "\n", "<br>");
		//s = Replace(s, " ", "&nbsp;");
		s = Replace(s, "'", "&#39;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "%", "％");
		//	s = Replace(s, "&", "&amp;");
		return s;
	}
	//	逆
	public static String unHtml(String s)
	{

		//s = Replace(s, "&lt;", "<");
		//s = Replace(s, "&gt;", ">");
		//		s = Replace(s, "    ", "\t");
		//		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		//		s = Replace(s, "&nbsp;", " ");
		//		s = Replace(s, "&amp;", "&");
		//		s = Replace(s, "&#39;", "'");
		//		s = Replace(s, "&#92;", "\\");
		//		s = Replace(s, "％", "%");
		return s;
	}

	//	此函数后台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtmlBack(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		//		s = Replace(s, "\n", "<br>");
//		s = Replace(s, " ", "&nbsp;");
		//		s = Replace(s, "'", "&#39;");
		//		s = Replace(s, "%", "%");

		return s;
	}
	//	逆
	public static String unHtmlBack(String s)
	{
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s = Replace(s, "&amp;", "&");
		s = Replace(s, "&#39;", "'");
		s = Replace(s, "&#92;", "\\");
		s = Replace(s, "％", "%");
		return s;
	}
	/*
	public static String toHtml(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
	//		s = Replace(s, "\n", "<br>");
		s = Replace(s, " ", "&nbsp;");
	//		s = Replace(s, "'", "&#39;");
	//		s = Replace(s, "%", "%");
		
		return s;
	}
	
	public static String unHtml(String s)
	{
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s = Replace(s, "&amp;", "&");
		s = Replace(s, "&#39;", "'");
		s = Replace(s, "&#92;", "\\");
		s = Replace(s, "％", "%");
		return s;
	}
	*/
	//判断是否含有中文，如果含有中文返回ture
	public static boolean containsChinese(String str) throws UnsupportedEncodingException
	{

		if (str.length() < (str.getBytes()).length)
			return true;

		return false;

		//	  for (int i = 0; i < username.length(); i++) {
		//		String unit=Character.toString(username.charAt(i));
		//		byte[] unitByte=unit.getBytes("GBK");
		////  		((unitByte[0]+256)*256 + (unitByte[1]+256)) <= 0xFEFE)
		//	   if (unitByte.length == 2)
		//		{
		//		  return true;
		//		}
		//	  }
		//	  return false;

	}

	public static boolean isEmpty(String str)
	{
		if (str == null)
			return true;
		return "".equals(str.trim());
	}

	public static String[] split(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.split(str1, str2);
	}

	public static String left(String str, int length)
	{
		return org.apache.commons.lang.StringUtils.left(str, length);
	}

	/**
	 * 根据输入的长度截取字符串，单个单词超过输入长度的强制加<BR>换行
	 * @param str 输入的字符串
	 * @param len 输入的长度
	 * @return 处理过后的字符串
	 */
	public static String truncateStr(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str))
		{

			String strs[] = str.split(" ");
			StringBuffer buff = new StringBuffer();
			if (strs.length > 0)
			{
				for (int i = 0; i < strs.length; i++)
				{
					StringBuffer temp = new StringBuffer();
					while (strs[i].length() > len)
					{
						temp.append(strs[i].substring(0, len) + "<BR>");
						strs[i] = strs[i].substring(len);
					}
					temp.append(strs[i]);
					buff.append(temp.toString() + " ");
				}

			}
			return buff.toString();
		}
		else
		{
			return "";
		}
	}
	
	public static String truncateStr2(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str) && len!=0)
		{
			String strs[] = str.split(" ");
			
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < strs.length; i++)
			{
				StringBuffer temp = new StringBuffer();
				String tempstr = "";
				while (strs[i].length() > len)
				{
					tempstr = strs[i].substring(0, len);
					tempstr = tempstr.replaceAll(" ","&nbsp; ");
					tempstr = tempstr.replaceAll("<","&lt; ");
					tempstr = tempstr.replaceAll("\n","<br> ").replaceAll("\"","&quot; ").replaceAll("'","&#39; ");
					tempstr = tempstr + "<br>";
					temp.append(tempstr);
					
					strs[i] = strs[i].substring(len);
				}
				tempstr = strs[i];
				tempstr = tempstr.replaceAll(" ","&nbsp; ");
				tempstr = tempstr.replaceAll("<","&lt; ");
				tempstr = tempstr.replaceAll("\n","<br> ").replaceAll("\"","&quot; ").replaceAll("'","&#39; ");
								
				temp.append(tempstr);
				buff.append(temp.toString() + " ");
			}
			
			if(buff.length() > 0)
				return buff.toString().substring(0,buff.length()-1);
			else
				return str;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 编码转换，从unicode转换为GBK
	 * @param l_S_Source 输入字符串
	 * @return str编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String unicodeToGB(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("GBK");
			l_S_Desc = new String(l_b_Proc, "ISO8859_1");
		}
		return l_S_Desc;
	}
	/**
	 * 编码转换，从GBK转换为unicode
	 * @param l_S_Source 输入字符串
	 * @return str 编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String GBToUnicode(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("ISO8859_1");
			l_S_Desc = new String(l_b_Proc, "GBK");
		}
		return l_S_Desc;
	}

	/**
	 * Escapes a <code>String</code> according the JavaScript string literal
	 * escaping rules. The resulting string will not be quoted.
	 * 
	 * <p>It escapes both <tt>'</tt> and <tt>"</tt>.
	 * In additional it escapes <tt>></tt> as <tt>\></tt> (to avoid
	 * <tt>&lt;/script></tt>). Furthermore, all characters under UCS code point
	 * 0x20, that has no dedicated escape sequence in JavaScript language, will
	 * be replaced with hexadecimal escape (<tt>\x<i>XX</i></tt>). 
	 */ 
	public static String javaScriptStringEnc(String s) {
		int ln = s.length();
		for (int i = 0; i < ln; i++) {
			char c = s.charAt(i);
			if (c == '"' || c == '\'' || c == '\\' || c == '>' || c < 0x20) {
				StringBuffer b = new StringBuffer(ln + 4);
				b.append(s.substring(0, i));
				while (true) {
					if (c == '"') {
						b.append("\\\"");
					} else if (c == '\'') {
						b.append("\\'");
					} else if (c == '\\') {
						b.append("\\\\");
					} else if (c == '>') {
						b.append("\\>");
					} else if (c < 0x20) {
						if (c == '\n') {
							b.append("\\n");
						} else if (c == '\r') {
							b.append("\\r");
						} else if (c == '\f') {
							b.append("\\f");
						} else if (c == '\b') {
							b.append("\\b");
						} else if (c == '\t') {
							b.append("\\t");
						} else {
							b.append("\\x");
							int x = c / 0x10;
							b.append((char)
									(x < 0xA ? x + '0' : x - 0xA + 'A'));
							x = c & 0xF;
							b.append((char)
									(x < 0xA ? x + '0' : x - 0xA + 'A'));
						}
					} else {
						b.append(c);
					}
					i++;
					if (i >= ln) {
						return b.toString();
					}
					c = s.charAt(i);
				}
			} // if has to be escaped
		} // for each characters
		return s;
	}
	
	
	private static StringUtil instance = null;
	
	public static synchronized StringUtil getInstance()
	{
		if (instance == null)
		{
			instance = new StringUtil();
		}
		return instance;
	}
	/**
	 * 将多个连续空格替换为一个,"a  b"-->"a b"
	 * @param src
	 * @return
	 * @author WilliamLau
	 * @desc
	 */
	public static String trimContinuousSpace(String src){
		return src.replaceAll("\\s+", " ");
	}
	public static String replace(String src, String target, String rWith, int maxCount)
	{
		return org.apache.commons.lang.StringUtils.replace(src, target, rWith, maxCount);
	}

	public static boolean equals(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.equals(str1, str2);
	}

	public static boolean isAlphanumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isAlphanumeric(str);
	}

	public static boolean isNumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isNumeric(str);
	}

	public static String[] stripAll(String[] strs)
	{
		return org.apache.commons.lang.StringUtils.stripAll(strs);
	}
	public static void main(String[] args)
	{
		//		String testStr = "<input > &    \\r\\n    \\n", newStr;
		//		newStr = toHtml(testStr);
		//		System.out.println(testStr);
		//		System.out.println(newStr);
		//		System.out.println(unHtml(newStr));
		//		String aaa = "中文中文中文bcdefghijk";

		//        		String bbb = toLengthForIntroduce(aaa,5);
		//		System.out.println(bbb);
		//		Object aa = null;
		//		String bb = "  aaaa  ";

		try
		{
			String s = "salfa是地方啦多少积分小逸\uD83D\uDC2F\uD83D\uDC2F";
			System.out.println( StringUtil.filterOffUTF8Mb4( s ) );
			//			System.out.println(getNotNullStr(aa));
			//			System.out.println(getNotNullStr(bb));
			//			System.out.println(containsChinese(aaa));
			//			System.out.println(containsChinese(aaa));
			//			System.out.println(containsChinese(bb));
			//String abc = null;
			//System.out.println(toLengthForEn(abc, 3));
			/*String num = "05";
			if(num.indexOf(".")==-1){
				num = num + ".00";
			}*/
//			String str="<p >ksdkks </br> </p>    jkskskeeee <div>  lllll </div>";
//			System.out.println(delTag(str));
			//System.out.println(toFloatNumber("5.2"));
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}
//
	public static String toFloatNumber(String num) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return nf.format(Double.parseDouble(num));
	}

	/**
	 * 
	*    
	* 方法描述：判断字符是否空或大于指定长度  
	* 创建人：hexiaoliang  
	* 创建时间：2010-4-3 上午11:24:21    
	* @param param
	* @param len
	* @return
	* @version   1.0
	*
	 */
	public static boolean isNullOrGreatLen(String param,int len){
		if(StringUtil.isEmpty(param)){
			return true;
		}
		if(param.getBytes().length>len)
			return true;
		
		return false;
	}





//	---------------------------------------------below added by ws ------------------------------------------------
	/** 空格 */
	public static final String spaceStr = " ";
	/** 空串 */
	public static final String emptyStr = "";
	/** 换行符 */
	public static final String lineSeparator = System.getProperty("line.separator", "\n");

	/**
	 * 清空 换行符
	 * @param str 原字符串
	 * @param replaceStr 默认为空串
	 * @return
	 */
	public static String trimLine(String str ,String replaceStr){
		if(null == str || str.length() <= 0 ){
			return str;
		}
		replaceStr = (null == replaceStr ? emptyStr : replaceStr);
		return str.replace(lineSeparator, replaceStr);
	}

	/**
	 * null 处理
	 * @param str
	 * @return 为null时,返回空串
	 */
	public static String NVL(String str) {
		if (str == null || "null".equalsIgnoreCase(str)) {
			return "";
		}
		return str;
	}

	public static boolean isNull( String s )
	{
		return  ( s == null || "".equalsIgnoreCase( s ) || "null".equalsIgnoreCase( s ) || "undefined".equalsIgnoreCase( s ) );

	}

	/**
	 * 把一个object类转换成为string
	 * @param obj
	 * @return
	 */
	public static String transferStr( Object obj )
	{
		if( obj != null )
			return "" + obj;
		else
			return null;
	}

	/**
	 * 把一个 object 对象转换成指定类 clazz 对象
	 * @param obj
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T>T transferObject( Object obj, Class<T> clazz )
	{
		T ret = null;
		try {
			if (obj != null ) {
				ret = (T) obj;
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 把一个 object 对象转换成指定类 long
	 * @param obj
	 * @return
	 */
	public static long transferLong( Object obj)
	{
		long ret = 0l;
		try {
			if (obj != null ) {
				ret = Long.parseLong( "" + obj );
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 把一个 object 对象转换成指定类 double
	 * @param obj
	 * @return
	 */
	public static double transferDouble( Object obj)
	{
		double ret = 0.0;
		try {
			if (obj != null ) {
				ret = Double.parseDouble("" + obj );
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 把一个 object 对象转换成指定类 int
	 * @param obj
	 * @return
	 */
	public static int transferInt( Object obj)
	{
		int ret = 0;
		try {
			if (obj != null ) {
				ret = Integer.parseInt("" + obj);
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return ret;
	}

	public static boolean isEmpty_2(String s)
	{
		if( s == null )
		{
			return true;
		}

		boolean ret = false;
		s = s.trim();
		if( "".equalsIgnoreCase( s ) || "null".equalsIgnoreCase( s ) || "undefined".equalsIgnoreCase( s ) || s.trim().length() <= 0 )
		{
			ret = true;
		}

		return ret;
	}

	public static String getNullIfEmpty( String s )
	{
		if( isEmpty( s ) )
		{
			return "null";
		}

		return s;
	}


	public static boolean isTrue( String s )
	{
		if( s == null )
		{
			return false;
		}

		boolean ret = false;
		if( "true".equalsIgnoreCase( s.trim() ) || "1".equalsIgnoreCase( s.trim() ) || "success".equalsIgnoreCase( s.trim() ) )
		{
			ret = true;
		}

		return ret;
	}

	public static int stringToInt( String s )
	{
		int i = 0;
		try{

			i = Integer.parseInt( s );

		}catch ( Exception e ){
			System.out.println( e.getMessage() );
		}

		return i;
	}

	public static String trim( String s )
	{
		return ( s == null ? null : s.trim() );
	}

	/**
	 * Splits the provided text into a list, using whitespace as the separator.
	 * The separator is not included in the returned String array.
	 *
	 * @param str  the string to parse
	 * @return an array of parsed Strings
	 */
	public static String[] split(String str) {
		return split(str, null, -1);
	}

	/**
	 * Splits the provided text into a list, based on a given separator.
	 * The separator is not included in the returned String array.
	 * The maximum number of splits to perfom can be controlled.
	 * A null separator will cause parsing to be on whitespace.
	 *
	 * <p>This is useful for quickly splitting a string directly into
	 * an array of tokens, instead of an enumeration of tokens (as
	 * <code>StringTokenizer</code> does).
	 *
	 * @param str The string to parse.
	 * @param separator Characters used as the delimiters. If
	 * <code>null</code>, splits on whitespace.
	 * @param max The maximum number of elements to include in the
	 * list.  A zero or negative value implies no limit.
	 * @return an array of parsed Strings
	 */
	public static String[] split(String str, String separator, int max) {
		StringTokenizer tok = null;
		if (separator == null) {
			// Null separator means we're using StringTokenizer's default
			// delimiter, which comprises all whitespace characters.
			tok = new StringTokenizer(str);
		} else {
			tok = new StringTokenizer(str, separator);
		}

		int listSize = tok.countTokens();
		if (max > 0 && listSize > max) {
			listSize = max;
		}

		String[] list = new String[listSize];
		int i = 0;
		int lastTokenBegin = 0;
		int lastTokenEnd = 0;
		while (tok.hasMoreTokens()) {
			if (max > 0 && i == listSize - 1) {
				// In the situation where we hit the max yet have
				// tokens left over in our input, the last list
				// element gets all remaining text.
				String endToken = tok.nextToken();
				lastTokenBegin = str.indexOf(endToken, lastTokenEnd);
				list[i] = str.substring(lastTokenBegin);
				break;
			} else {
				list[i] = tok.nextToken();
				lastTokenBegin = str.indexOf(list[i], lastTokenEnd);
				lastTokenEnd = lastTokenBegin + list[i].length();
			}
			i++;
		}
		return list;
	}


	/**
	 * added by wangsheng 20010-1-7
	 * @param s
	 * @return
	 */
	public static String regexMode( String s )
	{
		StringBuffer sb = new StringBuffer();
		if( s != null )
		{
			String[] specialChars = new String[]{ "$", "(", ")", "*", "+", ".", "[", "?", "\\", "^", "{", "|" };
			int len = s.length();
			for( int i = 0; i < len; i++ )
			{
				String ci = String.valueOf( s.charAt( i ) );
				if( StringArrayUtil.isInArray( ci, specialChars ) )
				{
					ci = "\\" + ci;
				}
				sb.append( "[" );
				sb.append( ci );
				sb.append( "]" );
			}

		}

		return sb.toString();

	}


	/**
	 * Set -- > 合并成String
	 * @param set
	 * @return
	 */
	public static String combineToString( Set<String> set )
	{
		return combineToString(set, ",", true);
	}
	public static String combineToString( Set<String> set, String separate, boolean removeNull )
	{
		if( set == null )
		{
			return "";
		}
		if( isNull( separate ) )
		{
			separate = ",";
		}


		String ret = "";
		Iterator it = set.iterator();
		while ( it.hasNext() )
		{
			String s = ( String )it.next();
			if( !isNull( ret ) )
			{
				if( removeNull && isNull( s ) )
				{
					continue;
				}
				ret += separate;
			}

			ret += s;
		}

		return ret;
	}

	public static int byteToInteger(byte b)
	{
		int value;
		value = b & 0xff;
		return value;
	}

	public static byte integerToByte(int a)
	{
		byte b;
		b = (byte)(a & 0xFF);

		return b;
	}

	public static String toGB2312( String s )
	{
		if( isEmpty( s ) )
		{
			return s;
		}
		return toEncode( s, "GB2312" );
	}

	public static String toEncode( String s, String charset )
	{
		if( isEmpty( s ) )
		{
			return s;
		}
		if( isEmpty( charset ) )
		{
			charset = "GB2312";
		}
		String ret = s;
		try{
			if( "iso-8859-1".equalsIgnoreCase( charset.trim() ) )
			{
				ret = new String( s.getBytes("iso-8859-1"),"gbk");
			}else {
				ret = new String( s.getBytes(), charset );
			}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 字符转换从UTF-8到GBK
	 *
	 * @param s
	 * @return
	 */
	public static String utf8ToGBK(String s) {
		String gbkStr=null;
		int n = s.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = s.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			gbkStr=new String(tmp);
			return gbkStr;
		}
		gbkStr=new String(utfBytes);
		return gbkStr;
	}

	public static String numberFomart(Integer num, String decimalFormat )
	{
		if(num == null)
		{
			num = 0;
		}

		if(isEmpty( decimalFormat ) )
		{
			return num.toString();
		}

		DecimalFormat df = new DecimalFormat( decimalFormat );
		df.setGroupingUsed( false );

		return df.format( num );

	}

	public static String numberFomart(Double num, String decimalFormat )
	{
		if(num == null)
		{
			num = 0d;
		}

		if(isEmpty( decimalFormat ) )
		{
			return num.toString();
		}

		DecimalFormat df = new DecimalFormat( decimalFormat );
		df.setGroupingUsed( false );

		return df.format( num );

	}

	public static String numberFomart(Float num, String decimalFormat )
	{
		if(num == null)
		{
			num = 0f;
		}

		if(isEmpty( decimalFormat ) )
		{
			return num.toString();
		}

		DecimalFormat df = new DecimalFormat( decimalFormat );
		df.setGroupingUsed(false);

		return df.format( num );

	}

	public static String filterOffUTF8Mb4(String text)
	{
		if( text == null )
		{
			return null;
		}
		String ret = "";
		try {

			byte[] bytes = text.getBytes("utf-8");

			ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
			int i = 0;
			while (i < bytes.length) {
				short b = bytes[i];
				if (b > 0) {
					buffer.put(bytes[i++]);
					continue;
				}
				b += 256;
				if ((b ^ 0xC0) >> 4 == 0) {
					buffer.put(bytes, i, 2);
					i += 2;
				} else if ((b ^ 0xE0) >> 4 == 0) {
					buffer.put(bytes, i, 3);
					i += 3;
				} else if ((b ^ 0xF0) >> 4 == 0) {
					i += 4;
				} else {
//					buffer.put(bytes, i, 1);
					i += 1;
				}
			}

			buffer.flip();

			ret = new String(buffer.array(), "utf-8");

		}catch ( UnsupportedEncodingException e ){
			e.printStackTrace();
		}catch ( Exception e ){
			e.printStackTrace();
		}

		return ret;
	}


}
