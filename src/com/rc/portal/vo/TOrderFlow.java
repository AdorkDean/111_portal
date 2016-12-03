package com.rc.portal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TOrderFlow {
    private Long id;

    private Long memberId;

    private Integer paymentStatus;

    private String paymentPlugin;

    private String payMethod;

    private BigDecimal havePay;

    private Date payDate;

    private String remark;

    private String thirdPaySerialnumber;

    private Date createTime;

    private Long orderId;

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

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentPlugin() {
        return paymentPlugin;
    }

    public void setPaymentPlugin(String paymentPlugin) {
        this.paymentPlugin = paymentPlugin;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public BigDecimal getHavePay() {
        return havePay;
    }

    public void setHavePay(BigDecimal havePay) {
        this.havePay = havePay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getThirdPaySerialnumber() {
        return thirdPaySerialnumber;
    }

    public void setThirdPaySerialnumber(String thirdPaySerialnumber) {
        this.thirdPaySerialnumber = thirdPaySerialnumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}