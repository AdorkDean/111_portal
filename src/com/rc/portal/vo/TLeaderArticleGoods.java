package com.rc.portal.vo;

public class TLeaderArticleGoods {
    private Long id;

    private Long goodsId;

    private Long articleId;

    private String goodImageUrl;

    private Integer weight;

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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getGoodImageUrl() {
        return goodImageUrl;
    }

    public void setGoodImageUrl(String goodImageUrl) {
        this.goodImageUrl = goodImageUrl;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}