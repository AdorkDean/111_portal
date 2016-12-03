package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TGoodsPrice {
    private Long id;

    private Long goodsId;

    private String platformType;

    private String priceType;

    private Integer status;

    private Integer stock;

    private BigDecimal price;

    private Date createDt;

    private Integer isShow;

    private Integer isTop;

    private String promotionWord;

    private Date upDt;

    private Date downDt;

    private String remarks;

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

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getPromotionWord() {
        return promotionWord;
    }

    public void setPromotionWord(String promotionWord) {
        this.promotionWord = promotionWord;
    }

    public Date getUpDt() {
        return upDt;
    }

    public void setUpDt(Date upDt) {
        this.upDt = upDt;
    }

    public Date getDownDt() {
        return downDt;
    }

    public void setDownDt(Date downDt) {
        this.downDt = downDt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}