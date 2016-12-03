package com.rc.portal.vo;

import java.util.Date;

public class TLxSendRed {
    private Long id;

    private String centent;

    private Long relationId;

    private Date sendDt;

    private Integer redType;

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

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Date getSendDt() {
        return sendDt;
    }

    public void setSendDt(Date sendDt) {
        this.sendDt = sendDt;
    }

    public Integer getRedType() {
        return redType;
    }

    public void setRedType(Integer redType) {
        this.redType = redType;
    }
}