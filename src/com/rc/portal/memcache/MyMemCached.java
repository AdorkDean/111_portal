package com.rc.portal.memcache;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;

public abstract class MyMemCached {
	private static MemCachedClient memClient = MemCached.getmcc();
	//设置对象缓存
	public  static void set(String key,Object value){
		if(key==null || key.equals("")) return;
		memClient.set(key, value);
	}
	public  static void set(String key,Object value,int times){
		if(key==null || key.equals("")) return;
		memClient.set(key, value, new Date(times) );
		
	}
	
	//获得对象缓存
	public  static Object get(String key){
		return memClient.get(key);
	}
	//判断是否存在缓存
	public static boolean hasCache(String key) {
	        return memClient.keyExists(key);
	}
	//删除 指定缓存
	public static void remove(String key){
		memClient.delete(key);
	}
}
