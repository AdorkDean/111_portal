package com.rc.portal.webapp.model.cart;

public class CartGift {
	
	private long goodsid;
	private long promid;
	private String image_url;
	private int cnt;
	public long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(long goodsid) {
		this.goodsid = goodsid;
	}
	public long getPromid() {
		return promid;
	}
	public void setPromid(long promid) {
		this.promid = promid;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
