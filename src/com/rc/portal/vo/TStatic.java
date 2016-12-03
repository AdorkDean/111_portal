package com.rc.portal.vo;

import java.util.Date;

public class TStatic {
    private Long id;

    private String staticName;

    private String staticMehtod;

    private String templatePath;

    private String templateName;

    private String outPath;

    private Date updateDate;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaticName() {
        return staticName;
    }

    public void setStaticName(String staticName) {
        this.staticName = staticName;
    }

    public String getStaticMehtod() {
        return staticMehtod;
    }

    public void setStaticMehtod(String staticMehtod) {
        this.staticMehtod = staticMehtod;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}