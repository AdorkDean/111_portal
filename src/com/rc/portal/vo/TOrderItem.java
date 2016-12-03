package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TOrderItem {
    private Long id;

    private Long goodsId;

    private Integer ifPremiums;

    private Integer quantity;

    private BigDecimal price;

    private Integer ifReviews;

    private Date createTime;

    private Long orderId;

    private Long brokerage;

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

    public Integer getIfPremiums() {
        return ifPremiums;
    }

    public void setIfPremiums(Integer ifPremiums) {
        this.ifPremiums = ifPremiums;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIfReviews() {
        return ifReviews;
    }

    public void setIfReviews(Integer ifReviews) {
        this.ifReviews = ifReviews;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Long brokerage) {
        this.brokerage = brokerage;
    }
}