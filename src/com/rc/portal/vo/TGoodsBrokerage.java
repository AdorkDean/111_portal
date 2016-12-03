package com.rc.portal.vo;

import java.math.BigDecimal;

public class TGoodsBrokerage {
    private Long id;

    private Long goodsId;

    private Long brokerage;

    private Integer weight;

    private BigDecimal rebateAmount;

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

    public Long getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Long brokerage) {
        this.brokerage = brokerage;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }
}