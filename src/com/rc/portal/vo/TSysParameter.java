package com.rc.portal.vo;

public class TSysParameter {
    private Long id;

    private String sysKey;

    private String sysValue;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}