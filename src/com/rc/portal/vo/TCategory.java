package com.rc.portal.vo;

import java.util.Date;

public class TCategory {
    private Long id;

    private String categoryName;

    private String categoryDescribe;

    private Integer categoryLevel;

    private String allParentId;

    private Long parentId;

    private Integer isWap;

    private Integer isApp;

    private Integer isPc;

    private Date createTime;

    private String remarks;

    private String seoTitle;

    private String seoKeyword;

    private String seoDescribe;

    private Integer weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescribe() {
        return categoryDescribe;
    }

    public void setCategoryDescribe(String categoryDescribe) {
        this.categoryDescribe = categoryDescribe;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getAllParentId() {
        return allParentId;
    }

    public void setAllParentId(String allParentId) {
        this.allParentId = allParentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsWap() {
        return isWap;
    }

    public void setIsWap(Integer isWap) {
        this.isWap = isWap;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }

    public Integer getIsPc() {
        return isPc;
    }

    public void setIsPc(Integer isPc) {
        this.isPc = isPc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public String getSeoDescribe() {
        return seoDescribe;
    }

    public void setSeoDescribe(String seoDescribe) {
        this.seoDescribe = seoDescribe;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}