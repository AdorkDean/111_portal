package com.rc.portal.vo;

import java.util.Date;

public class TLxAnnouncement {
    private Long id;

    private String centent;

    private Integer weight;

    private Integer announcementType;

    private Date createDt;

    private Integer status;

    private Integer isDelete;

    private Date sendDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCentent() {
        return centent;
    }

    public void setCentent(String centent) {
        this.centent = centent;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(Integer announcementType) {
        this.announcementType = announcementType;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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