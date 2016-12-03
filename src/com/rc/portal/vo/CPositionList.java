package com.rc.portal.vo;

import java.util.Date;

public class CPositionList {
    private Integer id;

    private String name;

    private String mPath;

    private String mName;

    private String outPath;

    private Date createDt;

    private String rule;

    private Integer isrelease;

    private Integer genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(Integer isrelease) {
        this.isrelease = isrelease;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }
}