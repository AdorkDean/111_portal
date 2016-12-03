package com.rc.portal.webapp.model.cart;


public class CartParam {

	
	private boolean islogin = false;
	
	private long userId;
	
	private String cartkey;
	
	private long goodsId;
	/**
	 * 购物车结算商品类型   0非医卡通商品  1 医卡通商品    为空表示所有
	 */
	private String cartType;
	
	public CartParam(){}
	

	public CartParam(boolean islogin, long userId, String cartkey, long goodsId) {
		this.islogin = islogin;
		this.userId = userId;
		this.cartkey = cartkey;
		this.goodsId = goodsId;
	}


	public CartParam(boolean islogin, long userId, String cartkey) {
		this.islogin = islogin;
		this.userId = userId;
		this.cartkey = cartkey;
	}


	public boolean isIslogin() {
		return islogin;
	}


	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getCartkey() {
		return cartkey;
	}


	public void setCartkey(String cartkey) {
		this.cartkey = cartkey;
	}


	public long getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}


	public String getCartType() {
		return cartType;
	}


	public void setCartType(String cartType) {
		this.cartType = cartType;
	}
	
	

}
