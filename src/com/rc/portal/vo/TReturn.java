package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;

/**
 * 退换货实体
 * 
 * @author user00
 * @modifyTime 2015-8-11 下午6:37:07
 */
public class TReturn {

	private Long id;

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 服务类型退货 Refunds(0), 换货 exchange(1) ,2:退款(无需退货)
	 */
	private Integer serviceType;

	/**
	 * 快递单号
	 */
	private String expressDelivery;

	/**
	 * 快递公司
	 */
	private String expressCompany;

	/**
	 * 发货人电话
	 */
	private String shipperPhone;

	/**
	 * 会员id
	 */
	private Long memberId;

	/**
	 * 退款金额
	 */
	private BigDecimal refundAmount;

	/**
	 * 退款描述
	 */
	private String refundDescribe;

	/**
	 * 订单状态
	 */
	private Integer orderStatus;

	/**
	 * 退款账号
	 */
	private String refundAccount;

	/**
	 * 退款银行
	 */
	private String refundBank;

	/**
	 * 退款备注
	 */
	private String refundRemark;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 原订单id
	 */
	private Long oldOrderId;

	/**
	 * 原订单号(非表字段)
	 */
	private String oldOrderSn;
	/**
	 * 商品名称(非表字段)
	 */
	private String goodsName;

	/**
	 * 用户名(非该表字段)
	 */
	private String userName;

	/**
	 * 完成时间
	 */
	private Date finishDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getExpressDelivery() {
		return expressDelivery;
	}

	public void setExpressDelivery(String expressDelivery) {
		this.expressDelivery = expressDelivery;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}

	public String getShipperPhone() {
		return shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundDescribe() {
		return refundDescribe;
	}

	public void setRefundDescribe(String refundDescribe) {
		this.refundDescribe = refundDescribe;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getOldOrderId() {
		return oldOrderId;
	}

	public void setOldOrderId(Long oldOrderId) {
		this.oldOrderId = oldOrderId;
	}

	/**
	 * 退换货状态枚举
	 * 
	 * @author user00
	 * @createTime 2015-8-11 下午6:57:19
	 */
	public enum ReturnStatus {
		/** 未处理 */
		untreated,
		/** 已通过 */
		passed,
		/** 未通过 */
		noPass,
		/** 验货通过 */
		passInspection,
		/** 验货未通过 */
		noPassInspection,
		/** 退款中 */
		refund,
		/** 处理中 */
		processing,
		/** 验货中 */
		inspectionGoods,
		/** 换货中 */
		replaceGoods,
		/** 结束 */
		end
	}

	/**
	 * 获取原订单编号
	 * 
	 * @return
	 */
	@Transient
	public String getOldOrderSn() {
		return oldOrderSn;
	}

	public void setOldOrderSn(String oldOrderSn) {
		this.oldOrderSn = oldOrderSn;
	}

	/**
	 * 商品名称
	 * 
	 * @return
	 */
	@Transient
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取完成时间
	 * 
	 * @return
	 */
	public Date getFinishDt() {
		return finishDt;
	}

	/**
	 * 设置完成时间
	 */
	public void setFinishDt(Date finishDt) {
		this.finishDt = finishDt;
	}

}