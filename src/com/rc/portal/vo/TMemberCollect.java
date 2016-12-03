package com.rc.portal.vo;

import java.util.Date;

public class TMemberCollect {
    private Long id;

    private Long relevanceId;

    private Integer collectType;

    private Date createDate;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(Long relevanceId) {
        this.relevanceId = relevanceId;
    }

    public Integer getCollectType() {
        return collectType;
    }

    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}