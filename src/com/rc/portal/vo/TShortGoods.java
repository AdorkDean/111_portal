package com.rc.portal.vo;

import java.math.BigDecimal;

public class TShortGoods {
    private Long id;

    private Long goodsId;

    private BigDecimal price;

    private Integer limitCount;

    private Integer totalCount;

    private Long shortBuyId;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Long getShortBuyId() {
        return shortBuyId;
    }

    public void setShortBuyId(Long shortBuyId) {
        this.shortBuyId = shortBuyId;
    }
}