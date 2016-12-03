package com.rc.portal.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Transient;

/**
 * 商品评论实体
 * 
 * @author user00
 * @modifyTime 2015-8-11 下午5:10:57
 */
public class TGoodsComment {

	private Long id;

	/**
	 * 总评分
	 */
	private Integer sumFraction;

	/**
	 * 类型 1 好评 2 中评 3 差评
	 */
	private Integer type;

	/**
	 * 卖家好评
	 */
	private Integer seller;

	/**
	 * 快递好评
	 */
	private Integer fastMail;

	/**
	 * 商品好评
	 */
	private Integer goods;

	/**
	 * 快递员好评
	 */
	private Integer fastMailPeople;

	/**
	 * 是否显示 (0:不显示,1:显示)
	 */
	private Integer isShow;

	/**
	 * 评论内容
	 */
	private String comment;

	/**
	 * 会员id
	 */
	private Long memberId;

	/**
	 * 商品id
	 */
	private Long goodsId;

	/**
	 * 订单Id
	 */
	private Long orderId;

	/**
	 * 评论时间
	 */
	private Date createTime;

	/**
	 * 商品名称(非数据库字段)
	 */
	private String goodsName;

	/**
	 * 商品规格(非数据库字段)
	 */
	private String spec;

	/**
	 * 用户名(非该表字段)
	 */
	private String userName;

	/**
	 * 头像(非该表字段)
	 */
	private String headPortrait;

	/**
	 * 創建時間(非该表字段)
	 */
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取总评分
	 * 
	 * @return
	 */
	public Integer getSumFraction() {
		return sumFraction;
	}

	/**
	 * 设置总评分
	 * 
	 * @param sumFraction
	 */
	public void setSumFraction(Integer sumFraction) {
		this.sumFraction = sumFraction;
	}

	/**
	 * 获取类型 1 好评 2 中评 3 差评
	 * 
	 * @return
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置类型 1 好评 2 中评 3 差评
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取卖家好评
	 * 
	 * @return
	 */
	public Integer getSeller() {
		return seller;
	}

	/**
	 * 设置卖家好评
	 * 
	 * @param seller
	 */
	public void setSeller(Integer seller) {
		this.seller = seller;
	}

	/**
	 * 获取快递好评
	 * 
	 * @return
	 */
	public Integer getFastMail() {
		return fastMail;
	}

	/**
	 * 设置快递好评
	 * 
	 * @param fastMail
	 */
	public void setFastMail(Integer fastMail) {
		this.fastMail = fastMail;
	}

	/**
	 * 获取商品好评
	 * 
	 * @return
	 */
	public Integer getGoods() {
		return goods;
	}

	/**
	 * 设置商品好评
	 * 
	 * @param goods
	 */
	public void setGoods(Integer goods) {
		this.goods = goods;
	}

	/**
	 * 获取快递员好评
	 * 
	 * @return
	 */
	public Integer getFastMailPeople() {
		return fastMailPeople;
	}

	/**
	 * 设置快递员好评
	 * 
	 * @param fastMailPeople
	 */
	public void setFastMailPeople(Integer fastMailPeople) {
		this.fastMailPeople = fastMailPeople;
	}

	/**
	 * 获取是否显示
	 * 
	 * @return
	 */
	public Integer getIsShow() {
		return isShow;
	}

	/**
	 * 设置是否显示
	 * 
	 * @param isShow
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	/**
	 * 获取评论内容
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 设置评论内容
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 获取会员id
	 * 
	 * @return
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 设置会员id
	 * 
	 * @param memberId
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取商品ID
	 * 
	 * @return
	 */
	public Long getGoodsId() {
		return goodsId;
	}

	/**
	 * 设置商品ID
	 * 
	 * @param goodsId
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * 获取订单ID
	 * 
	 * @return
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 设置订单ID
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取评论时间
	 * 
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置评论时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取商品名称
	 * 
	 * @return
	 */
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 获取商品规格
	 * 
	 * @return
	 */
	@Transient
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Transient
	public String getUserName() {
		if (userName != null && userName.length() > 2) {
			userName = userName.substring(0, 1) + "***" + userName.substring(userName.length() - 1, userName.length());
		}
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Transient
	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	@Transient
	public String getCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (getCreateTime() != null) {
			createDate = sdf.format(getCreateTime());
		}
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}