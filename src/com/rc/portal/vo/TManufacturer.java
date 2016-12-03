package com.rc.portal.vo;

import java.util.Date;

public class TManufacturer {
    private Long id;

    private String manuName;

    private String manuLogo;

    private String manuDescribe;

    private String slogan;

    private String remarks;

    private Integer status;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getManuLogo() {
        return manuLogo;
    }

    public void setManuLogo(String manuLogo) {
        this.manuLogo = manuLogo;
    }

    public String getManuDescribe() {
        return manuDescribe;
    }

    public void setManuDescribe(String manuDescribe) {
        this.manuDescribe = manuDescribe;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}