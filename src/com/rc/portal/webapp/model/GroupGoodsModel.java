package com.rc.portal.webapp.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class GroupGoodsModel {
	private Long id;//套餐Id
	private String name;//套餐名字
	private BigDecimal price;//真实价格
	private BigDecimal pcPrice;//显示价格
	private Map phMap;//药师点评 药师信息
	private List<Map> goodsList;//套餐商品信息
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPcPrice() {
		return pcPrice;
	}
	public void setPcPrice(BigDecimal pcPrice) {
		this.pcPrice = pcPrice;
	}
	public Map getPhMap() {
		return phMap;
	}
	public void setPhMap(Map phMap) {
		this.phMap = phMap;
	}
	public List<Map> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Map> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
	
}
