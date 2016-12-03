package com.rc.portal.memcache;


public class BasicModifyTimeCacheEntry implements IModifyTimeCacheEntry {
	private long modifyTime;
	private final Object o;
	private final Object id;
	
	public BasicModifyTimeCacheEntry(Object id, Object o, long l) {
		this.o = o;
		this.id = id;
		this.modifyTime = l;
	}
	

	public long getCeObjectModifyTime() {
		return this.modifyTime;
	}
	

	public Object getCeIdentifier() {
		return this.id;
	}
	

	public Object getCeObject() {
		return this.o;
	}
}