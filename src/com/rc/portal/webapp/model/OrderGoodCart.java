package com.rc.portal.webapp.model;

import java.math.BigDecimal;

/**
 * 跳转订单结算页面 商品列表 model
 * @author user3
 *
 */
public class OrderGoodCart {
	/**
	 * 商品id
	 */
	private Long id;
	/**
	 * 商品pc价格
	 */
	private BigDecimal pcPrice;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品库存
	 */
	private Long stock;
	/**
	 * 购物车数量
	 */
	private Integer quantity;
	/**
	 * 商品缩略图
	 */
	private String abbreviationPicture;
	/**
	 * 规格
	 */
	private String spec;
	/**
	 * 促销活动id
	 */
	private Long promotionId;
	/**
	 * 是否赠品 0 否 1 是
	 */
	private Integer ifPremiums;
	/**
	 * 品牌id
	 */
	private Long brandId;
	/**
	 * 分类id
	 */
	private Long categoryid;
	/**
	 * 重量
	 */
	private BigDecimal weight;
	/**
	 * 剩余库存
	 */
	private Integer stquan;
	/**
	 * 上下架状态pc 1 上架  2 下架
	 */
	private Integer pcStatus;
	/**
	 * 药品类型   1 OTC  2 处方药A(可以加入购物车) 3 处方药B（只可咨询药师下单，不可加入购物车购买） 
	 */
	private Integer type;
	/**
	 * 是否支持医卡通  0 否  1 是
	 */
	private Integer isYktGood;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPcPrice() {
		return pcPrice;
	}
	public void setPcPrice(BigDecimal pcPrice) {
		this.pcPrice = pcPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getAbbreviationPicture() {
		return abbreviationPicture;
	}
	public void setAbbreviationPicture(String abbreviationPicture) {
		this.abbreviationPicture = abbreviationPicture;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	public Integer getIfPremiums() {
		return ifPremiums;
	}
	public void setIfPremiums(Integer ifPremiums) {
		this.ifPremiums = ifPremiums;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Integer getStquan() {
		if(stock==null){
			return -quantity;
		}else{
			return stock.intValue()-quantity;
		}
	}
	public void setStquan(Integer stquan) {
		this.stquan = stquan;
	}
	public Integer getPcStatus() {
		return pcStatus;
	}
	public void setPcStatus(Integer pcStatus) {
		this.pcStatus = pcStatus;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsYktGood() {
		return isYktGood;
	}
	public void setIsYktGood(Integer isYktGood) {
		this.isYktGood = isYktGood;
	}
	
	
	
}
