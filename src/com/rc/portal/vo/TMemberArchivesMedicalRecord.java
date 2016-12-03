package com.rc.portal.vo;

import java.util.Date;

public class TMemberArchivesMedicalRecord {
    private Long id;

    private Long memberId;

    private String hospital;

    private String doctor;

    private String department;

    private Date createDt;

    private String medicalRecordUrl;

    private String illnessDescribe;

    private String doctorEntrust;

    private String illnessMedication;

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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getMedicalRecordUrl() {
        return medicalRecordUrl;
    }

    public void setMedicalRecordUrl(String medicalRecordUrl) {
        this.medicalRecordUrl = medicalRecordUrl;
    }

    public String getIllnessDescribe() {
        return illnessDescribe;
    }

    public void setIllnessDescribe(String illnessDescribe) {
        this.illnessDescribe = illnessDescribe;
    }

    public String getDoctorEntrust() {
        return doctorEntrust;
    }

    public void setDoctorEntrust(String doctorEntrust) {
        this.doctorEntrust = doctorEntrust;
    }

    public String getIllnessMedication() {
        return illnessMedication;
    }

    public void setIllnessMedication(String illnessMedication) {
        this.illnessMedication = illnessMedication;
    }
}