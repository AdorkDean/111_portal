package com.rc.portal.webapp.model.cart;

import java.math.BigDecimal;

public class CartItem {

	private long goodsid;
	private int is_selected;
	private String goods_name;
	private String goodsno;
	private BigDecimal price;
	private BigDecimal pc_price;
	private BigDecimal wap_price;
	private BigDecimal app_price;
	private String image_url;
	private int quantity;

	private int ykt_flag;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(long goodsid) {
		this.goodsid = goodsid;
	}

	public int getIs_selected() {
		return is_selected;
	}

	public void setIs_selected(int is_selected) {
		this.is_selected = is_selected;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoodsno() {
		return goodsno;
	}

	public void setGoodsno(String goodsno) {
		this.goodsno = goodsno;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getYkt_flag() {
		return ykt_flag;
	}

	public void setYkt_flag(int ykt_flag) {
		this.ykt_flag = ykt_flag;
	}

}
