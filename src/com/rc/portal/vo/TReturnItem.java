package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TReturnItem {
	/**
	 * 主键ID
	 */
	private Long id;

	/**
	 * 商品ID
	 */
	private Long goodsId;

	/**
	 * 数量
	 */
	private Integer quantity;

	/**
	 * 商品金额
	 */
	private BigDecimal productAmount;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 退换货订单ID
	 */
	private Long returnId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(BigDecimal productAmount) {
		this.productAmount = productAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getReturnId() {
		return returnId;
	}

	public void setReturnId(Long returnId) {
		this.returnId = returnId;
	}
}