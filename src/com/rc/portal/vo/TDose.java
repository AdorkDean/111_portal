package com.rc.portal.vo;

public class TDose {
    private Long id;

    private String dosename;

    private Integer sort;

    private String doseDescribe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosename() {
        return dosename;
    }

    public void setDosename(String dosename) {
        this.dosename = dosename;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDoseDescribe() {
        return doseDescribe;
    }

    public void setDoseDescribe(String doseDescribe) {
        this.doseDescribe = doseDescribe;
    }
}