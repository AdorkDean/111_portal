package com.rc.portal.vo;

import java.util.Date;

public class TLxReceiveRed {
    private Long id;

    private Long redId;

    private Long memberId;

    private Date receiveDt;

    private Long couponCardId;

    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedId() {
        return redId;
    }

    public void setRedId(Long redId) {
        this.redId = redId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getReceiveDt() {
        return receiveDt;
    }

    public void setReceiveDt(Date receiveDt) {
        this.receiveDt = receiveDt;
    }

    public Long getCouponCardId() {
        return couponCardId;
    }

    public void setCouponCardId(Long couponCardId) {
        this.couponCardId = couponCardId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}