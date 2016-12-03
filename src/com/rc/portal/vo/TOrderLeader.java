package com.rc.portal.vo;

import java.util.Date;

public class TOrderLeader {
    private Long id;

    private Long leaderId;

    private Long orderId;

    private Date orderFinishDt;

    private Integer isFinish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderFinishDt() {
        return orderFinishDt;
    }

    public void setOrderFinishDt(Date orderFinishDt) {
        this.orderFinishDt = orderFinishDt;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }
}