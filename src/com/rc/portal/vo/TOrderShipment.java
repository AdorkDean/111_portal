package com.rc.portal.vo;

import java.util.Date;

public class TOrderShipment {
    private Long id;

    private String logisticsNo;

    private String logisticsName;

    private String logisticsPosition;

    private Date shipmentDt;

    private Long orderId;

    private String state;

    private Integer orderType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsPosition() {
        return logisticsPosition;
    }

    public void setLogisticsPosition(String logisticsPosition) {
        this.logisticsPosition = logisticsPosition;
    }

    public Date getShipmentDt() {
        return shipmentDt;
    }

    public void setShipmentDt(Date shipmentDt) {
        this.shipmentDt = shipmentDt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}