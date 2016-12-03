package com.rc.portal.vo;

import java.util.Date;

public class TLxLookCollection {
    private Long id;

    private Long relationId;

    private Integer relationType;

    private String ip;

    private Long memberId;

    private Integer lookSource;

    private Date createDt;

    private Date updateDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getLookSource() {
        return lookSource;
    }

    public void setLookSource(Integer lookSource) {
        this.lookSource = lookSource;
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
}