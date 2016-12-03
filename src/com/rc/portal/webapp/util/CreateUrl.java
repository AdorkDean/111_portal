/**
 * Copyright 2009-2010 wozhongla.com, Inc. All rights reserved.
*  @author zgwu
*  @version 3.0
*  @refine 
**/
package com.rc.portal.webapp.util;

import java.util.HashMap;


public final class CreateUrl {
	private StringBuffer url=new StringBuffer(200);
	private String splip="-";
	private HashMap<String,String> paramUrl=new HashMap<String,String>();
	String[] orderUrl={"keyword","cateid","brandid","price1","price2","isrx","type","islocal","sort","order","page","size"};
	
	
	
	
	private void setUrl(String v){
		if(this.url.length()==0){
			this.url.append(v);
		}else{
			this.url.append(splip);
			if(v==null ){
				this.url.append("0");
			}else{
				this.url.append(v);
			}
		}
	}
	public StringBuffer getUrl() {
		return url;
	}
	
}