package com.rc.portal.vo;

import java.util.Date;

public class TMemberCertificates {
    private Long id;

    private Long memberId;

    private String idcardJustUrl;

    private String idcardBackUrl;

    private Integer idcardType;

    private String idcardCode;

    private String idcardAddress;

    private Date createDt;

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

    public String getIdcardJustUrl() {
        return idcardJustUrl;
    }

    public void setIdcardJustUrl(String idcardJustUrl) {
        this.idcardJustUrl = idcardJustUrl;
    }

    public String getIdcardBackUrl() {
        return idcardBackUrl;
    }

    public void setIdcardBackUrl(String idcardBackUrl) {
        this.idcardBackUrl = idcardBackUrl;
    }

    public Integer getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(Integer idcardType) {
        this.idcardType = idcardType;
    }

    public String getIdcardCode() {
        return idcardCode;
    }

    public void setIdcardCode(String idcardCode) {
        this.idcardCode = idcardCode;
    }

    public String getIdcardAddress() {
        return idcardAddress;
    }

    public void setIdcardAddress(String idcardAddress) {
        this.idcardAddress = idcardAddress;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}