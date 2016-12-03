package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberArchivesMedicalRecordExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberArchivesMedicalRecordExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberArchivesMedicalRecordExample(TMemberArchivesMedicalRecordExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;


    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;


    }

    public String getOrderByClause() {
        return orderByClause;


    }

    public List getOredCriteria() {
        return oredCriteria;


    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);


    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);


        }
        return criteria;


    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;


    }

    public void clear() {
        oredCriteria.clear();


    }

    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();


        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;


        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;


        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;


        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;


        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;


        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");


            }
            criteriaWithoutValue.add(condition);


        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");


            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);


        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");


            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);


        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");


            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);


        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;


        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;


        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return this;


        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return this;


        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return this;


        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return this;


        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return this;


        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return this;


        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;


        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;


        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return this;


        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;


        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return this;


        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return this;


        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return this;


        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return this;


        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return this;


        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return this;


        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return this;


        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return this;


        }

        public Criteria andMemberIdIn(List values) {
            addCriterion("member_id in", values, "memberId");
            return this;


        }

        public Criteria andMemberIdNotIn(List values) {
            addCriterion("member_id not in", values, "memberId");
            return this;


        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return this;


        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return this;


        }

        public Criteria andHospitalIsNull() {
            addCriterion("hospital is null");
            return this;


        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("hospital is not null");
            return this;


        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("hospital =", value, "hospital");
            return this;


        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("hospital <>", value, "hospital");
            return this;


        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("hospital >", value, "hospital");
            return this;


        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("hospital >=", value, "hospital");
            return this;


        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("hospital <", value, "hospital");
            return this;


        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("hospital <=", value, "hospital");
            return this;


        }

        public Criteria andHospitalLike(String value) {
            addCriterion("hospital like", value, "hospital");
            return this;


        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("hospital not like", value, "hospital");
            return this;


        }

        public Criteria andHospitalIn(List values) {
            addCriterion("hospital in", values, "hospital");
            return this;


        }

        public Criteria andHospitalNotIn(List values) {
            addCriterion("hospital not in", values, "hospital");
            return this;


        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("hospital between", value1, value2, "hospital");
            return this;


        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("hospital not between", value1, value2, "hospital");
            return this;


        }

        public Criteria andDoctorIsNull() {
            addCriterion("doctor is null");
            return this;


        }

        public Criteria andDoctorIsNotNull() {
            addCriterion("doctor is not null");
            return this;


        }

        public Criteria andDoctorEqualTo(String value) {
            addCriterion("doctor =", value, "doctor");
            return this;


        }

        public Criteria andDoctorNotEqualTo(String value) {
            addCriterion("doctor <>", value, "doctor");
            return this;


        }

        public Criteria andDoctorGreaterThan(String value) {
            addCriterion("doctor >", value, "doctor");
            return this;


        }

        public Criteria andDoctorGreaterThanOrEqualTo(String value) {
            addCriterion("doctor >=", value, "doctor");
            return this;


        }

        public Criteria andDoctorLessThan(String value) {
            addCriterion("doctor <", value, "doctor");
            return this;


        }

        public Criteria andDoctorLessThanOrEqualTo(String value) {
            addCriterion("doctor <=", value, "doctor");
            return this;


        }

        public Criteria andDoctorLike(String value) {
            addCriterion("doctor like", value, "doctor");
            return this;


        }

        public Criteria andDoctorNotLike(String value) {
            addCriterion("doctor not like", value, "doctor");
            return this;


        }

        public Criteria andDoctorIn(List values) {
            addCriterion("doctor in", values, "doctor");
            return this;


        }

        public Criteria andDoctorNotIn(List values) {
            addCriterion("doctor not in", values, "doctor");
            return this;


        }

        public Criteria andDoctorBetween(String value1, String value2) {
            addCriterion("doctor between", value1, value2, "doctor");
            return this;


        }

        public Criteria andDoctorNotBetween(String value1, String value2) {
            addCriterion("doctor not between", value1, value2, "doctor");
            return this;


        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return this;


        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return this;


        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return this;


        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return this;


        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return this;


        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return this;


        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return this;


        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return this;


        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return this;


        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return this;


        }

        public Criteria andDepartmentIn(List values) {
            addCriterion("department in", values, "department");
            return this;


        }

        public Criteria andDepartmentNotIn(List values) {
            addCriterion("department not in", values, "department");
            return this;


        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return this;


        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return this;


        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return this;


        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return this;


        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return this;


        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtIn(List values) {
            addCriterion("create_dt in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtNotIn(List values) {
            addCriterion("create_dt not in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return this;


        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
            return this;


        }

        public Criteria andMedicalRecordUrlIsNull() {
            addCriterion("medical_record_url is null");
            return this;


        }

        public Criteria andMedicalRecordUrlIsNotNull() {
            addCriterion("medical_record_url is not null");
            return this;


        }

        public Criteria andMedicalRecordUrlEqualTo(String value) {
            addCriterion("medical_record_url =", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlNotEqualTo(String value) {
            addCriterion("medical_record_url <>", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlGreaterThan(String value) {
            addCriterion("medical_record_url >", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlGreaterThanOrEqualTo(String value) {
            addCriterion("medical_record_url >=", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlLessThan(String value) {
            addCriterion("medical_record_url <", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlLessThanOrEqualTo(String value) {
            addCriterion("medical_record_url <=", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlLike(String value) {
            addCriterion("medical_record_url like", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlNotLike(String value) {
            addCriterion("medical_record_url not like", value, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlIn(List values) {
            addCriterion("medical_record_url in", values, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlNotIn(List values) {
            addCriterion("medical_record_url not in", values, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlBetween(String value1, String value2) {
            addCriterion("medical_record_url between", value1, value2, "medicalRecordUrl");
            return this;


        }

        public Criteria andMedicalRecordUrlNotBetween(String value1, String value2) {
            addCriterion("medical_record_url not between", value1, value2, "medicalRecordUrl");
            return this;


        }

        public Criteria andIllnessDescribeIsNull() {
            addCriterion("illness_describe is null");
            return this;


        }

        public Criteria andIllnessDescribeIsNotNull() {
            addCriterion("illness_describe is not null");
            return this;


        }

        public Criteria andIllnessDescribeEqualTo(String value) {
            addCriterion("illness_describe =", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeNotEqualTo(String value) {
            addCriterion("illness_describe <>", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeGreaterThan(String value) {
            addCriterion("illness_describe >", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("illness_describe >=", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeLessThan(String value) {
            addCriterion("illness_describe <", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeLessThanOrEqualTo(String value) {
            addCriterion("illness_describe <=", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeLike(String value) {
            addCriterion("illness_describe like", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeNotLike(String value) {
            addCriterion("illness_describe not like", value, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeIn(List values) {
            addCriterion("illness_describe in", values, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeNotIn(List values) {
            addCriterion("illness_describe not in", values, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeBetween(String value1, String value2) {
            addCriterion("illness_describe between", value1, value2, "illnessDescribe");
            return this;


        }

        public Criteria andIllnessDescribeNotBetween(String value1, String value2) {
            addCriterion("illness_describe not between", value1, value2, "illnessDescribe");
            return this;


        }

        public Criteria andDoctorEntrustIsNull() {
            addCriterion("doctor_entrust is null");
            return this;


        }

        public Criteria andDoctorEntrustIsNotNull() {
            addCriterion("doctor_entrust is not null");
            return this;


        }

        public Criteria andDoctorEntrustEqualTo(String value) {
            addCriterion("doctor_entrust =", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustNotEqualTo(String value) {
            addCriterion("doctor_entrust <>", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustGreaterThan(String value) {
            addCriterion("doctor_entrust >", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_entrust >=", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustLessThan(String value) {
            addCriterion("doctor_entrust <", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustLessThanOrEqualTo(String value) {
            addCriterion("doctor_entrust <=", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustLike(String value) {
            addCriterion("doctor_entrust like", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustNotLike(String value) {
            addCriterion("doctor_entrust not like", value, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustIn(List values) {
            addCriterion("doctor_entrust in", values, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustNotIn(List values) {
            addCriterion("doctor_entrust not in", values, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustBetween(String value1, String value2) {
            addCriterion("doctor_entrust between", value1, value2, "doctorEntrust");
            return this;


        }

        public Criteria andDoctorEntrustNotBetween(String value1, String value2) {
            addCriterion("doctor_entrust not between", value1, value2, "doctorEntrust");
            return this;


        }

        public Criteria andIllnessMedicationIsNull() {
            addCriterion("illness_medication is null");
            return this;


        }

        public Criteria andIllnessMedicationIsNotNull() {
            addCriterion("illness_medication is not null");
            return this;


        }

        public Criteria andIllnessMedicationEqualTo(String value) {
            addCriterion("illness_medication =", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationNotEqualTo(String value) {
            addCriterion("illness_medication <>", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationGreaterThan(String value) {
            addCriterion("illness_medication >", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationGreaterThanOrEqualTo(String value) {
            addCriterion("illness_medication >=", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationLessThan(String value) {
            addCriterion("illness_medication <", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationLessThanOrEqualTo(String value) {
            addCriterion("illness_medication <=", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationLike(String value) {
            addCriterion("illness_medication like", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationNotLike(String value) {
            addCriterion("illness_medication not like", value, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationIn(List values) {
            addCriterion("illness_medication in", values, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationNotIn(List values) {
            addCriterion("illness_medication not in", values, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationBetween(String value1, String value2) {
            addCriterion("illness_medication between", value1, value2, "illnessMedication");
            return this;


        }

        public Criteria andIllnessMedicationNotBetween(String value1, String value2) {
            addCriterion("illness_medication not between", value1, value2, "illnessMedication");
            return this;


        }


    }


}
