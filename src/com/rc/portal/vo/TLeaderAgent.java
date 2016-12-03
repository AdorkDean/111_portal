package com.rc.portal.vo;

import java.util.Date;

public class TLeaderAgent {
    private Long id;

    private Long memberId;

    private String realName;

    private String codeUrl;

    private String pushLink;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getPushLink() {
        return pushLink;
    }

    public void setPushLink(String pushLink) {
        this.pushLink = pushLink;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}