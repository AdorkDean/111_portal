package com.rc.portal.vo;

import java.util.Date;

public class TLxGoodsArticle {
    private Long id;

    private String title;

    private String shareImageUrl;

    private String shareTitle;

    private Date createDt;

    private Date updateDt;

    private Integer status;

    private Integer weight;

    private Integer isDelete;

    private Date sendDt;

    private Integer formatType;

    private byte[] content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShareImageUrl() {
        return shareImageUrl;
    }

    public void setShareImageUrl(String shareImageUrl) {
        this.shareImageUrl = shareImageUrl;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public Integer getFormatType() {
        return formatType;
    }

    public void setFormatType(Integer formatType) {
        this.formatType = formatType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}