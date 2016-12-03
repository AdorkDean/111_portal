package com.rc.portal.vo;

import java.math.BigDecimal;

public class TMemberAccount {
    private Long memberId;

    private BigDecimal remainingAmount;

    private BigDecimal freezeAmount;

    private BigDecimal waitAmount;

    private BigDecimal totalAmount;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public BigDecimal getWaitAmount() {
        return waitAmount;
    }

    public void setWaitAmount(BigDecimal waitAmount) {
        this.waitAmount = waitAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}