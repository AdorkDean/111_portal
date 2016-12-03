package com.rc.portal.memcache;

import org.objectweb.perseus.cache.api.CacheEntry;
import org.objectweb.perseus.cache.api.CacheException;
import org.objectweb.perseus.cache.lib.BasicCacheManager;

/**
 * 
 * @author luoweifeng
 * 
 */

public class BaseModifyTimeCachePool {
	private static final BasicCacheManager cm = new CacheManagerUtil()
			.creatCacheManager(10000);
	
	public final static int NO_LIMIT = -1;

	private BaseModifyTimeCachePool() {
	};

	/**
	 * 
	 * @param idV
	 * @return
	 */
	public static ICacheEntry get(Object idV) {
		if (idV != null) {
			return get(idV, NO_LIMIT);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param idV
	 * @param timeV
	 * @return
	 */
	public static ICacheEntry get(Object idV, long timeV) {
		if (idV != null) {
			BasicCacheManager cM = getCm();
			
			if (cM != null) {
				synchronized (cM) {
					CacheEntry cEntry = cM.lookup(idV);
					if (cEntry != null) {
						if (timeV == NO_LIMIT) {
							Object aTcEntry = cEntry.getCeObject();
							if (aTcEntry != null) {
								return (IModifyTimeCacheEntry) aTcEntry;
							}
						} else {
							long tFLmf = timeV;
							
							Object aTcEntry = cEntry.getCeObject();
							
							if (aTcEntry != null) {
								IModifyTimeCacheEntry aEntry = (IModifyTimeCacheEntry) aTcEntry;

								if (aEntry.getCeObjectModifyTime() < tFLmf) {
									return null;
								} else {
									return aEntry;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param idV
	 * @param vObject
	 * @return
	 */

	public static Object put(Object idV, Object vObject) {
		if (idV != null && vObject != null) {
			long curTime = System.currentTimeMillis();
			return put(idV, vObject, curTime);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param idV
	 * @param vObject
	 * @param lastModifyTime
	 * @return
	 */
	public static Object put(Object idV, Object vObject, long lastModifyTime) {
		if (idV != null && vObject != null) {
			BasicCacheManager cM = getCm();
			if (cM != null) {
				synchronized (cM) {
					CacheEntry cEntry = cM.lookup(idV);
					long curTime = lastModifyTime;
					if (cEntry != null) {
						try {
							remove(idV);
						} catch (CacheException e) {
							e.printStackTrace();
						}

						IModifyTimeCacheEntry aNewTcEntry = new BasicModifyTimeCacheEntry(
								idV, vObject, curTime);
						try {
							cM.bind(idV, aNewTcEntry);
							return vObject;
						} catch (CacheException e) {
							e.printStackTrace();
							return null;
						}
					} else {
						IModifyTimeCacheEntry aNewTcEntry = new BasicModifyTimeCacheEntry(
								idV, vObject, curTime);
						try {
							cM.bind(idV, aNewTcEntry);
							return vObject;
						} catch (CacheException e) {
							e.printStackTrace();
							return null;
						}
					}
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param idV
	 * @param vModifyTimeCacheEntryObject
	 * @return
	 */

	public static IModifyTimeCacheEntry put(Object idV,
			IModifyTimeCacheEntry vModifyTimeCacheEntryObject) {
		if (idV != null && vModifyTimeCacheEntryObject != null) {
			BasicCacheManager cM = getCm();
			if (cM != null) {
				CacheEntry cEntry = cM.lookup(idV);
				long curTime = vModifyTimeCacheEntryObject
						.getCeObjectModifyTime();
				if (cEntry != null) {
					try {
						remove(idV);
					} catch (CacheException e) {
						e.printStackTrace();
					}

					IModifyTimeCacheEntry aNewTcEntry = new BasicModifyTimeCacheEntry(
							idV, vModifyTimeCacheEntryObject, curTime);
					try {
						cM.bind(idV, aNewTcEntry);
						return vModifyTimeCacheEntryObject;
					} catch (CacheException e) {
						e.printStackTrace();
						return null;
					}
				} else {
					IModifyTimeCacheEntry aNewTcEntry = new BasicModifyTimeCacheEntry(
							idV, vModifyTimeCacheEntryObject, curTime);
					try {
						cM.bind(idV, aNewTcEntry);
						return vModifyTimeCacheEntryObject;
					} catch (CacheException e) {
						e.printStackTrace();
						return null;
					}
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public static boolean remove(Object idV) throws CacheException {
		return getCm().unbind(idV, true);
	}

	public static void removeAll() throws CacheException {
		getCm().unbindAll(true);
	}

	private static BasicCacheManager getCm() {
		return cm;
	}

	public static int getSize() {
		return getCm().getMaxObjects();
	}

	public static void setSize(int sizeV) {
		try {
			getCm().setMaxObjects(sizeV);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	public static void setAutoCleanSize(String size) {
		getCm().setAutoCleanSize(size);
	}

	public static String getAutoCleanSize() {
		return getCm().getAutoCleanSize();
	}

	public static void setAutoCleanThreshold(String size) {
		getCm().setAutoCleanThreshold(size);
	}

	public static String getAutoCleanThreshold() {
		return getCm().getAutoCleanThreshold();
	}

	public static int getCurrentSize() {
		return getCm().getCurrentSize();
	}
}