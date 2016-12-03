package com.rc.portal.vo;

import java.math.BigDecimal;

public class RxTOrderGood {
    private Long id;

    private Long reserveOrderId;

    private Long goodid;

    private BigDecimal goodPrice;

    private Integer num;

    private Long memberId;

    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReserveOrderId() {
        return reserveOrderId;
    }

    public void setReserveOrderId(Long reserveOrderId) {
        this.reserveOrderId = reserveOrderId;
    }

    public Long getGoodid() {
        return goodid;
    }

    public void setGoodid(Long goodid) {
        this.goodid = goodid;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}