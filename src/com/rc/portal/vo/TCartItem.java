package com.rc.portal.vo;

import java.util.Date;

public class TCartItem {
    private Long id;

    private Integer quantity;

    private Integer isSelected;

    private Date createTime;

    private Long cartId;

    private Long goodsId;

    private Integer ifPremiums;

    private Integer isYktGood;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

    public Integer getIsYktGood() {
        return isYktGood;
    }

    public void setIsYktGood(Integer isYktGood) {
        this.isYktGood = isYktGood;
    }
}