package com.rc.portal.memcache;

import org.objectweb.perseus.cache.lib.BasicCacheManager;

/**
 * 
 * @author luoweifeng
 *
 */

public class CacheManagerUtil {
	public BasicCacheManager creatCacheManager() {
		BasicCacheManager cm = null;
		try {
			cm = CacheManagerFactory.newCacheManager(5000,
					CacheManagerFactory.LRU_POLICY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cm;
	}
	
	public BasicCacheManager creatCacheManager(int cacheSize) {
		if (cacheSize > 0) {
			BasicCacheManager cm = null;
			try {
				cm = CacheManagerFactory.newCacheManager(cacheSize,
						CacheManagerFactory.LRU_POLICY);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cm;
		} else {
			return null;
		}
	}
	
	public BasicCacheManager creatCacheManager(int cacheSize, String managerPolicy) {
		if (cacheSize > 0) {
			BasicCacheManager cm = null;
			
			if (CacheManagerFactory.LRU_POLICY.equals(managerPolicy)) {
				try {
					cm = CacheManagerFactory.newCacheManager(cacheSize,
							CacheManagerFactory.LRU_POLICY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (CacheManagerFactory.MRU_POLICY.equals(managerPolicy)) {
				try {
					cm = CacheManagerFactory.newCacheManager(cacheSize,
							CacheManagerFactory.MRU_POLICY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (CacheManagerFactory.FIFO_POLICY.equals(managerPolicy)) {
				try {
					cm = CacheManagerFactory.newCacheManager(cacheSize,
							CacheManagerFactory.FIFO_POLICY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					cm = CacheManagerFactory.newCacheManager(cacheSize,
							CacheManagerFactory.LRU_POLICY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return cm;
		} else {
			return null;
		}
	}
}