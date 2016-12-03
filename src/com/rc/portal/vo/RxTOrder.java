package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class RxTOrder {
    private Long id;

    private String orderSn;

    private Long memberId;

    private String receiver;

    private Long areaId;

    private String areaName;

    private String detailedAddress;

    private String longitude;

    private String latitude;

    private String storeId;

    private String mobile;

    private Long paymentId;

    private Long deliveryId;

    private Integer orderStatus;

    private Date createDt;

    private BigDecimal orderAmount;

    private BigDecimal freight;

    private BigDecimal promotionalDiscount;

    private BigDecimal couponDiscount;

    private BigDecimal integrationDiscount;

    private Integer useIntegration;

    private BigDecimal adjustAmount;

    private Integer rewardIntegration;

    private Integer isPush;

    private Date pushTime;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getPromotionalDiscount() {
        return promotionalDiscount;
    }

    public void setPromotionalDiscount(BigDecimal promotionalDiscount) {
        this.promotionalDiscount = promotionalDiscount;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(BigDecimal couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal getIntegrationDiscount() {
        return integrationDiscount;
    }

    public void setIntegrationDiscount(BigDecimal integrationDiscount) {
        this.integrationDiscount = integrationDiscount;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public BigDecimal getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(BigDecimal adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public Integer getRewardIntegration() {
        return rewardIntegration;
    }

    public void setRewardIntegration(Integer rewardIntegration) {
        this.rewardIntegration = rewardIntegration;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}