package com.rc.portal.vo;

import java.util.Date;

public class TMemberBalance {
    private Long id;

    private Integer streamType;

    private Long price;

    private Long balance;

    private String remark;

    private Date createDate;

    private Long memberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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