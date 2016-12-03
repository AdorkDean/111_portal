package com.rc.portal.vo;

public class TGoodsPremiums {
    private Long id;

    private Long goodsId;

    private Long premiumsId;

    private Integer goodsum;

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

    public Long getPremiumsId() {
        return premiumsId;
    }

    public void setPremiumsId(Long premiumsId) {
        this.premiumsId = premiumsId;
    }

    public Integer getGoodsum() {
        return goodsum;
    }

    public void setGoodsum(Integer goodsum) {
        this.goodsum = goodsum;
    }
}