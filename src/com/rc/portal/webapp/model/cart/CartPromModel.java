package com.rc.portal.webapp.model.cart;

import java.math.BigDecimal;

public class CartPromModel {

	private Long goods_id;
	private Integer quantity;
	private Long promotion_id;
	private Integer type;
	private BigDecimal pc_price;
	private Long categoryid;
	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(Long promotion_id) {
		this.promotion_id = promotion_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getPc_price() {
		return pc_price;
	}

	public void setPc_price(BigDecimal pc_price) {
		this.pc_price = pc_price;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

}
