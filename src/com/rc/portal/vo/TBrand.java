package com.rc.portal.vo;

import java.util.Date;

public class TBrand {
    private Long id;

    private String brandName;

    private Integer brandType;

    private String logo;

    private String brandUrl;

    private String brandInfo;

    private String pinyin;

    private Integer isWap;

    private Integer isApp;

    private Integer isPc;

    private Date createTime;

    private String remark;

    private String seoTitle;

    private String seoKeyword;

    private String seoDescribe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}