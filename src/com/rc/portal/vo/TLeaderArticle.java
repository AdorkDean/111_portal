package com.rc.portal.vo;

import java.util.Date;

public class TLeaderArticle {
    private Long id;

    private String title;

    private String shareImageUrl;

    private String shareTitle;

    private Integer status;

    private Integer weight;

    private Integer isDelete;

    private Date sendDt;

    private Integer formatType;

    private Integer clickLikeSum;

    private Integer lookSum;

    private Integer commentSum;

    private Long leaderId;

    private Integer auditStatus;

    private Date auditDate;

    private String auditOpinion;

    private Date createDt;

    private Date updateDt;

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

    public Integer getClickLikeSum() {
        return clickLikeSum;
    }

    public void setClickLikeSum(Integer clickLikeSum) {
        this.clickLikeSum = clickLikeSum;
    }

    public Integer getLookSum() {
        return lookSum;
    }

    public void setLookSum(Integer lookSum) {
        this.lookSum = lookSum;
    }

    public Integer getCommentSum() {
        return commentSum;
    }

    public void setCommentSum(Integer commentSum) {
        this.commentSum = commentSum;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}