package com.rc.portal.vo;

public class TGroupGoods {
    private Long id;

    private Long groupId;

    private Integer goodsNum;

    private Integer mainGoods;

    private Long goodsid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getMainGoods() {
        return mainGoods;
    }

    public void setMainGoods(Integer mainGoods) {
        this.mainGoods = mainGoods;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
}