package com.rc.portal.webapp.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rc.dst.client.util.ClientSubmitPublic;

public class JsonUtil {

	
	public static Map getData(Map map,String url) throws Exception{
		String data = ClientSubmitPublic.getPublicService(map,url);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("data-->"+data);
		Map reslt = mapper.readValue(data, Map.class);
		return reslt;
	}

	
	
	public static Map getData1(Map map,String url) throws Exception{
		String data = ClientSubmitPublic.getPublicService(map,url);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("data-->"+data);
		Map reslt=new HashMap();
		if(data!=null){
			reslt = mapper.readValue(data, Map.class);
		}else{
			reslt.put("statusCode", "0");
		}
		return reslt;
	}
}
