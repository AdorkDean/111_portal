package com.rc.portal.vo;

import java.util.Date;

public class TMemberThreeBinding {
    private Long id;

    private String bindingUuid;

    private Integer source;

    private Date createDate;

    private Long memberId;

    private String wxOpenid;

    private String wxAppid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBindingUuid() {
        return bindingUuid;
    }

    public void setBindingUuid(String bindingUuid) {
        this.bindingUuid = bindingUuid;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }
}