package com.rc.portal.webapp.model;

import java.math.BigDecimal;

public class GroupModel {
	private Long goodsid;//商品id
	private Integer main_goods;//是否主商品
	private String short_name;//商品名称
	private String abbreviationPicture;//商品缩略图
	private BigDecimal price;//商品价格
    private BigDecimal pcPrice;
    private BigDecimal wapPrice;
    private BigDecimal appPrice;
    
	public BigDecimal getPcPrice() {
		return pcPrice;
	}
	public void setPcPrice(BigDecimal pcPrice) {
		this.pcPrice = pcPrice;
	}
	public BigDecimal getWapPrice() {
		return wapPrice;
	}
	public void setWapPrice(BigDecimal wapPrice) {
		this.wapPrice = wapPrice;
	}
	public BigDecimal getAppPrice() {
		return appPrice;
	}
	public void setAppPrice(BigDecimal appPrice) {
		this.appPrice = appPrice;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String shortName) {
		short_name = shortName;
	}
	public Integer getMain_goods() {
		return main_goods;
	}
	public void setMain_goods(Integer mainGoods) {
		main_goods = mainGoods;
	}
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAbbreviationPicture() {
		return abbreviationPicture;
	}
	public void setAbbreviationPicture(String abbreviationPicture) {
		this.abbreviationPicture = abbreviationPicture;
	}
}
