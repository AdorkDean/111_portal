package com.rc.portal.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTextByLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:/test/readtxtbyline/readtxtbyline.txt";
		
		/*List<String> s;
		s = getTextContentList(path);
		System.out.println(s);*/
		
		getTextBaseOnArrayForm(path,",");
	}

	/**@return 获取文本文件内容list
	 * @author zhangyong
	 * @param String path
	 * */
	public static List<String> getTextContentList(String path) {
		List<String> list=new ArrayList<String>();
		try {
			FileReader reader = new FileReader(path);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			while ((s = br.readLine()) != null) {
				list.add(s);
			}
			br.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	/**@return 获取文本文件内容
	 * @author zhangyong
	 * @param String path
	 * */
	public static String getTextContent(String path) {
		StringBuffer sb = new StringBuffer();
		try {
			FileReader reader = new FileReader(path);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s + '\n');
			}
			br.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	/**@return 获取文本文件内容List<String[]>
	 * @author zhangyong
	 * @param String path
	 * */
	public static List<String[]> getTextBaseOnArrayForm(String path ,String split){
		try{
			List<String[]> a=new ArrayList<String[]>();
			List list=getTextContentList(path);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					String str=(String)list.get(i);
					String[] args = str.split(split);
					a.add(args);
				}
				return a;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
