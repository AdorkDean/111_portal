package com.rc.portal.vo;

import java.util.Date;

public class TLxRedShare {
    private Long id;

    private String shareTitle;

    private String shareImageUrl;

    private Integer weight;

    private Integer shareType;

    private Integer status;

    private Date createDt;

    private Integer isDelete;

    private Date sendDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareImageUrl() {
        return shareImageUrl;
    }

    public void setShareImageUrl(String shareImageUrl) {
        this.shareImageUrl = shareImageUrl;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getSendDt() {
        return sendDt;
    }

    public void setSendDt(Date sendDt) {
        this.sendDt = sendDt;
    }
}