package com.rc.portal.webapp.model.cart;

import java.math.BigDecimal;

public class GoodsPrice {

	private BigDecimal pc_price;
	private BigDecimal wap_price;
	private BigDecimal app_price;
	private int stock;
	
	
	public BigDecimal getPc_price() {
		return pc_price;
	}
	public void setPc_price(BigDecimal pc_price) {
		this.pc_price = pc_price;
	}
	public BigDecimal getWap_price() {
		return wap_price;
	}
	public void setWap_price(BigDecimal wap_price) {
		this.wap_price = wap_price;
	}
	public BigDecimal getApp_price() {
		return app_price;
	}
	public void setApp_price(BigDecimal app_price) {
		this.app_price = app_price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
