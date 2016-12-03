package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberArchivesExaminationExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberArchivesExaminationExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberArchivesExaminationExample(TMemberArchivesExaminationExample example) {
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

        public Criteria andExaminationUrlIsNull() {
            addCriterion("examination_url is null");
            return this;


        }

        public Criteria andExaminationUrlIsNotNull() {
            addCriterion("examination_url is not null");
            return this;


        }

        public Criteria andExaminationUrlEqualTo(String value) {
            addCriterion("examination_url =", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlNotEqualTo(String value) {
            addCriterion("examination_url <>", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlGreaterThan(String value) {
            addCriterion("examination_url >", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("examination_url >=", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlLessThan(String value) {
            addCriterion("examination_url <", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlLessThanOrEqualTo(String value) {
            addCriterion("examination_url <=", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlLike(String value) {
            addCriterion("examination_url like", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlNotLike(String value) {
            addCriterion("examination_url not like", value, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlIn(List values) {
            addCriterion("examination_url in", values, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlNotIn(List values) {
            addCriterion("examination_url not in", values, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlBetween(String value1, String value2) {
            addCriterion("examination_url between", value1, value2, "examinationUrl");
            return this;


        }

        public Criteria andExaminationUrlNotBetween(String value1, String value2) {
            addCriterion("examination_url not between", value1, value2, "examinationUrl");
            return this;


        }

        public Criteria andExaminationDtIsNull() {
            addCriterion("examination_dt is null");
            return this;


        }

        public Criteria andExaminationDtIsNotNull() {
            addCriterion("examination_dt is not null");
            return this;


        }

        public Criteria andExaminationDtEqualTo(Date value) {
            addCriterion("examination_dt =", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtNotEqualTo(Date value) {
            addCriterion("examination_dt <>", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtGreaterThan(Date value) {
            addCriterion("examination_dt >", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtGreaterThanOrEqualTo(Date value) {
            addCriterion("examination_dt >=", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtLessThan(Date value) {
            addCriterion("examination_dt <", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtLessThanOrEqualTo(Date value) {
            addCriterion("examination_dt <=", value, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtIn(List values) {
            addCriterion("examination_dt in", values, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtNotIn(List values) {
            addCriterion("examination_dt not in", values, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtBetween(Date value1, Date value2) {
            addCriterion("examination_dt between", value1, value2, "examinationDt");
            return this;


        }

        public Criteria andExaminationDtNotBetween(Date value1, Date value2) {
            addCriterion("examination_dt not between", value1, value2, "examinationDt");
            return this;


        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return this;


        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return this;


        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return this;


        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return this;


        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return this;


        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return this;


        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return this;


        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return this;


        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return this;


        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return this;


        }

        public Criteria andTemperatureIn(List values) {
            addCriterion("temperature in", values, "temperature");
            return this;


        }

        public Criteria andTemperatureNotIn(List values) {
            addCriterion("temperature not in", values, "temperature");
            return this;


        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return this;


        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return this;


        }

        public Criteria andPulseIsNull() {
            addCriterion("pulse is null");
            return this;


        }

        public Criteria andPulseIsNotNull() {
            addCriterion("pulse is not null");
            return this;


        }

        public Criteria andPulseEqualTo(String value) {
            addCriterion("pulse =", value, "pulse");
            return this;


        }

        public Criteria andPulseNotEqualTo(String value) {
            addCriterion("pulse <>", value, "pulse");
            return this;


        }

        public Criteria andPulseGreaterThan(String value) {
            addCriterion("pulse >", value, "pulse");
            return this;


        }

        public Criteria andPulseGreaterThanOrEqualTo(String value) {
            addCriterion("pulse >=", value, "pulse");
            return this;


        }

        public Criteria andPulseLessThan(String value) {
            addCriterion("pulse <", value, "pulse");
            return this;


        }

        public Criteria andPulseLessThanOrEqualTo(String value) {
            addCriterion("pulse <=", value, "pulse");
            return this;


        }

        public Criteria andPulseLike(String value) {
            addCriterion("pulse like", value, "pulse");
            return this;


        }

        public Criteria andPulseNotLike(String value) {
            addCriterion("pulse not like", value, "pulse");
            return this;


        }

        public Criteria andPulseIn(List values) {
            addCriterion("pulse in", values, "pulse");
            return this;


        }

        public Criteria andPulseNotIn(List values) {
            addCriterion("pulse not in", values, "pulse");
            return this;


        }

        public Criteria andPulseBetween(String value1, String value2) {
            addCriterion("pulse between", value1, value2, "pulse");
            return this;


        }

        public Criteria andPulseNotBetween(String value1, String value2) {
            addCriterion("pulse not between", value1, value2, "pulse");
            return this;


        }

        public Criteria andBreathingIsNull() {
            addCriterion("breathing is null");
            return this;


        }

        public Criteria andBreathingIsNotNull() {
            addCriterion("breathing is not null");
            return this;


        }

        public Criteria andBreathingEqualTo(String value) {
            addCriterion("breathing =", value, "breathing");
            return this;


        }

        public Criteria andBreathingNotEqualTo(String value) {
            addCriterion("breathing <>", value, "breathing");
            return this;


        }

        public Criteria andBreathingGreaterThan(String value) {
            addCriterion("breathing >", value, "breathing");
            return this;


        }

        public Criteria andBreathingGreaterThanOrEqualTo(String value) {
            addCriterion("breathing >=", value, "breathing");
            return this;


        }

        public Criteria andBreathingLessThan(String value) {
            addCriterion("breathing <", value, "breathing");
            return this;


        }

        public Criteria andBreathingLessThanOrEqualTo(String value) {
            addCriterion("breathing <=", value, "breathing");
            return this;


        }

        public Criteria andBreathingLike(String value) {
            addCriterion("breathing like", value, "breathing");
            return this;


        }

        public Criteria andBreathingNotLike(String value) {
            addCriterion("breathing not like", value, "breathing");
            return this;


        }

        public Criteria andBreathingIn(List values) {
            addCriterion("breathing in", values, "breathing");
            return this;


        }

        public Criteria andBreathingNotIn(List values) {
            addCriterion("breathing not in", values, "breathing");
            return this;


        }

        public Criteria andBreathingBetween(String value1, String value2) {
            addCriterion("breathing between", value1, value2, "breathing");
            return this;


        }

        public Criteria andBreathingNotBetween(String value1, String value2) {
            addCriterion("breathing not between", value1, value2, "breathing");
            return this;


        }

        public Criteria andBloodPressureIsNull() {
            addCriterion("blood_pressure is null");
            return this;


        }

        public Criteria andBloodPressureIsNotNull() {
            addCriterion("blood_pressure is not null");
            return this;


        }

        public Criteria andBloodPressureEqualTo(String value) {
            addCriterion("blood_pressure =", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureNotEqualTo(String value) {
            addCriterion("blood_pressure <>", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureGreaterThan(String value) {
            addCriterion("blood_pressure >", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureGreaterThanOrEqualTo(String value) {
            addCriterion("blood_pressure >=", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureLessThan(String value) {
            addCriterion("blood_pressure <", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureLessThanOrEqualTo(String value) {
            addCriterion("blood_pressure <=", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureLike(String value) {
            addCriterion("blood_pressure like", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureNotLike(String value) {
            addCriterion("blood_pressure not like", value, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureIn(List values) {
            addCriterion("blood_pressure in", values, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureNotIn(List values) {
            addCriterion("blood_pressure not in", values, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureBetween(String value1, String value2) {
            addCriterion("blood_pressure between", value1, value2, "bloodPressure");
            return this;


        }

        public Criteria andBloodPressureNotBetween(String value1, String value2) {
            addCriterion("blood_pressure not between", value1, value2, "bloodPressure");
            return this;


        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return this;


        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return this;


        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return this;


        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return this;


        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return this;


        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return this;


        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return this;


        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return this;


        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return this;


        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return this;


        }

        public Criteria andHeightIn(List values) {
            addCriterion("height in", values, "height");
            return this;


        }

        public Criteria andHeightNotIn(List values) {
            addCriterion("height not in", values, "height");
            return this;


        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return this;


        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return this;


        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return this;


        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return this;


        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return this;


        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return this;


        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return this;


        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return this;


        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return this;


        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return this;


        }

        public Criteria andWeightIn(List values) {
            addCriterion("weight in", values, "weight");
            return this;


        }

        public Criteria andWeightNotIn(List values) {
            addCriterion("weight not in", values, "weight");
            return this;


        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return this;


        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return this;


        }

        public Criteria andWaistIsNull() {
            addCriterion("waist is null");
            return this;


        }

        public Criteria andWaistIsNotNull() {
            addCriterion("waist is not null");
            return this;


        }

        public Criteria andWaistEqualTo(String value) {
            addCriterion("waist =", value, "waist");
            return this;


        }

        public Criteria andWaistNotEqualTo(String value) {
            addCriterion("waist <>", value, "waist");
            return this;


        }

        public Criteria andWaistGreaterThan(String value) {
            addCriterion("waist >", value, "waist");
            return this;


        }

        public Criteria andWaistGreaterThanOrEqualTo(String value) {
            addCriterion("waist >=", value, "waist");
            return this;


        }

        public Criteria andWaistLessThan(String value) {
            addCriterion("waist <", value, "waist");
            return this;


        }

        public Criteria andWaistLessThanOrEqualTo(String value) {
            addCriterion("waist <=", value, "waist");
            return this;


        }

        public Criteria andWaistLike(String value) {
            addCriterion("waist like", value, "waist");
            return this;


        }

        public Criteria andWaistNotLike(String value) {
            addCriterion("waist not like", value, "waist");
            return this;


        }

        public Criteria andWaistIn(List values) {
            addCriterion("waist in", values, "waist");
            return this;


        }

        public Criteria andWaistNotIn(List values) {
            addCriterion("waist not in", values, "waist");
            return this;


        }

        public Criteria andWaistBetween(String value1, String value2) {
            addCriterion("waist between", value1, value2, "waist");
            return this;


        }

        public Criteria andWaistNotBetween(String value1, String value2) {
            addCriterion("waist not between", value1, value2, "waist");
            return this;


        }

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return this;


        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return this;


        }

        public Criteria andBmiEqualTo(String value) {
            addCriterion("bmi =", value, "bmi");
            return this;


        }

        public Criteria andBmiNotEqualTo(String value) {
            addCriterion("bmi <>", value, "bmi");
            return this;


        }

        public Criteria andBmiGreaterThan(String value) {
            addCriterion("bmi >", value, "bmi");
            return this;


        }

        public Criteria andBmiGreaterThanOrEqualTo(String value) {
            addCriterion("bmi >=", value, "bmi");
            return this;


        }

        public Criteria andBmiLessThan(String value) {
            addCriterion("bmi <", value, "bmi");
            return this;


        }

        public Criteria andBmiLessThanOrEqualTo(String value) {
            addCriterion("bmi <=", value, "bmi");
            return this;


        }

        public Criteria andBmiLike(String value) {
            addCriterion("bmi like", value, "bmi");
            return this;


        }

        public Criteria andBmiNotLike(String value) {
            addCriterion("bmi not like", value, "bmi");
            return this;


        }

        public Criteria andBmiIn(List values) {
            addCriterion("bmi in", values, "bmi");
            return this;


        }

        public Criteria andBmiNotIn(List values) {
            addCriterion("bmi not in", values, "bmi");
            return this;


        }

        public Criteria andBmiBetween(String value1, String value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return this;


        }

        public Criteria andBmiNotBetween(String value1, String value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
            return this;


        }

        public Criteria andCognitionIsNull() {
            addCriterion("cognition is null");
            return this;


        }

        public Criteria andCognitionIsNotNull() {
            addCriterion("cognition is not null");
            return this;


        }

        public Criteria andCognitionEqualTo(String value) {
            addCriterion("cognition =", value, "cognition");
            return this;


        }

        public Criteria andCognitionNotEqualTo(String value) {
            addCriterion("cognition <>", value, "cognition");
            return this;


        }

        public Criteria andCognitionGreaterThan(String value) {
            addCriterion("cognition >", value, "cognition");
            return this;


        }

        public Criteria andCognitionGreaterThanOrEqualTo(String value) {
            addCriterion("cognition >=", value, "cognition");
            return this;


        }

        public Criteria andCognitionLessThan(String value) {
            addCriterion("cognition <", value, "cognition");
            return this;


        }

        public Criteria andCognitionLessThanOrEqualTo(String value) {
            addCriterion("cognition <=", value, "cognition");
            return this;


        }

        public Criteria andCognitionLike(String value) {
            addCriterion("cognition like", value, "cognition");
            return this;


        }

        public Criteria andCognitionNotLike(String value) {
            addCriterion("cognition not like", value, "cognition");
            return this;


        }

        public Criteria andCognitionIn(List values) {
            addCriterion("cognition in", values, "cognition");
            return this;


        }

        public Criteria andCognitionNotIn(List values) {
            addCriterion("cognition not in", values, "cognition");
            return this;


        }

        public Criteria andCognitionBetween(String value1, String value2) {
            addCriterion("cognition between", value1, value2, "cognition");
            return this;


        }

        public Criteria andCognitionNotBetween(String value1, String value2) {
            addCriterion("cognition not between", value1, value2, "cognition");
            return this;


        }

        public Criteria andEmotionIsNull() {
            addCriterion("emotion is null");
            return this;


        }

        public Criteria andEmotionIsNotNull() {
            addCriterion("emotion is not null");
            return this;


        }

        public Criteria andEmotionEqualTo(String value) {
            addCriterion("emotion =", value, "emotion");
            return this;


        }

        public Criteria andEmotionNotEqualTo(String value) {
            addCriterion("emotion <>", value, "emotion");
            return this;


        }

        public Criteria andEmotionGreaterThan(String value) {
            addCriterion("emotion >", value, "emotion");
            return this;


        }

        public Criteria andEmotionGreaterThanOrEqualTo(String value) {
            addCriterion("emotion >=", value, "emotion");
            return this;


        }

        public Criteria andEmotionLessThan(String value) {
            addCriterion("emotion <", value, "emotion");
            return this;


        }

        public Criteria andEmotionLessThanOrEqualTo(String value) {
            addCriterion("emotion <=", value, "emotion");
            return this;


        }

        public Criteria andEmotionLike(String value) {
            addCriterion("emotion like", value, "emotion");
            return this;


        }

        public Criteria andEmotionNotLike(String value) {
            addCriterion("emotion not like", value, "emotion");
            return this;


        }

        public Criteria andEmotionIn(List values) {
            addCriterion("emotion in", values, "emotion");
            return this;


        }

        public Criteria andEmotionNotIn(List values) {
            addCriterion("emotion not in", values, "emotion");
            return this;


        }

        public Criteria andEmotionBetween(String value1, String value2) {
            addCriterion("emotion between", value1, value2, "emotion");
            return this;


        }

        public Criteria andEmotionNotBetween(String value1, String value2) {
            addCriterion("emotion not between", value1, value2, "emotion");
            return this;


        }

        public Criteria andLifeQualityIsNull() {
            addCriterion("life_quality is null");
            return this;


        }

        public Criteria andLifeQualityIsNotNull() {
            addCriterion("life_quality is not null");
            return this;


        }

        public Criteria andLifeQualityEqualTo(String value) {
            addCriterion("life_quality =", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityNotEqualTo(String value) {
            addCriterion("life_quality <>", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityGreaterThan(String value) {
            addCriterion("life_quality >", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityGreaterThanOrEqualTo(String value) {
            addCriterion("life_quality >=", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityLessThan(String value) {
            addCriterion("life_quality <", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityLessThanOrEqualTo(String value) {
            addCriterion("life_quality <=", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityLike(String value) {
            addCriterion("life_quality like", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityNotLike(String value) {
            addCriterion("life_quality not like", value, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityIn(List values) {
            addCriterion("life_quality in", values, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityNotIn(List values) {
            addCriterion("life_quality not in", values, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityBetween(String value1, String value2) {
            addCriterion("life_quality between", value1, value2, "lifeQuality");
            return this;


        }

        public Criteria andLifeQualityNotBetween(String value1, String value2) {
            addCriterion("life_quality not between", value1, value2, "lifeQuality");
            return this;


        }

        public Criteria andVisionIsNull() {
            addCriterion("vision is null");
            return this;


        }

        public Criteria andVisionIsNotNull() {
            addCriterion("vision is not null");
            return this;


        }

        public Criteria andVisionEqualTo(String value) {
            addCriterion("vision =", value, "vision");
            return this;


        }

        public Criteria andVisionNotEqualTo(String value) {
            addCriterion("vision <>", value, "vision");
            return this;


        }

        public Criteria andVisionGreaterThan(String value) {
            addCriterion("vision >", value, "vision");
            return this;


        }

        public Criteria andVisionGreaterThanOrEqualTo(String value) {
            addCriterion("vision >=", value, "vision");
            return this;


        }

        public Criteria andVisionLessThan(String value) {
            addCriterion("vision <", value, "vision");
            return this;


        }

        public Criteria andVisionLessThanOrEqualTo(String value) {
            addCriterion("vision <=", value, "vision");
            return this;


        }

        public Criteria andVisionLike(String value) {
            addCriterion("vision like", value, "vision");
            return this;


        }

        public Criteria andVisionNotLike(String value) {
            addCriterion("vision not like", value, "vision");
            return this;


        }

        public Criteria andVisionIn(List values) {
            addCriterion("vision in", values, "vision");
            return this;


        }

        public Criteria andVisionNotIn(List values) {
            addCriterion("vision not in", values, "vision");
            return this;


        }

        public Criteria andVisionBetween(String value1, String value2) {
            addCriterion("vision between", value1, value2, "vision");
            return this;


        }

        public Criteria andVisionNotBetween(String value1, String value2) {
            addCriterion("vision not between", value1, value2, "vision");
            return this;


        }

        public Criteria andHearingIsNull() {
            addCriterion("hearing is null");
            return this;


        }

        public Criteria andHearingIsNotNull() {
            addCriterion("hearing is not null");
            return this;


        }

        public Criteria andHearingEqualTo(String value) {
            addCriterion("hearing =", value, "hearing");
            return this;


        }

        public Criteria andHearingNotEqualTo(String value) {
            addCriterion("hearing <>", value, "hearing");
            return this;


        }

        public Criteria andHearingGreaterThan(String value) {
            addCriterion("hearing >", value, "hearing");
            return this;


        }

        public Criteria andHearingGreaterThanOrEqualTo(String value) {
            addCriterion("hearing >=", value, "hearing");
            return this;


        }

        public Criteria andHearingLessThan(String value) {
            addCriterion("hearing <", value, "hearing");
            return this;


        }

        public Criteria andHearingLessThanOrEqualTo(String value) {
            addCriterion("hearing <=", value, "hearing");
            return this;


        }

        public Criteria andHearingLike(String value) {
            addCriterion("hearing like", value, "hearing");
            return this;


        }

        public Criteria andHearingNotLike(String value) {
            addCriterion("hearing not like", value, "hearing");
            return this;


        }

        public Criteria andHearingIn(List values) {
            addCriterion("hearing in", values, "hearing");
            return this;


        }

        public Criteria andHearingNotIn(List values) {
            addCriterion("hearing not in", values, "hearing");
            return this;


        }

        public Criteria andHearingBetween(String value1, String value2) {
            addCriterion("hearing between", value1, value2, "hearing");
            return this;


        }

        public Criteria andHearingNotBetween(String value1, String value2) {
            addCriterion("hearing not between", value1, value2, "hearing");
            return this;


        }

        public Criteria andMotionFunctionIsNull() {
            addCriterion("motion_function is null");
            return this;


        }

        public Criteria andMotionFunctionIsNotNull() {
            addCriterion("motion_function is not null");
            return this;


        }

        public Criteria andMotionFunctionEqualTo(String value) {
            addCriterion("motion_function =", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionNotEqualTo(String value) {
            addCriterion("motion_function <>", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionGreaterThan(String value) {
            addCriterion("motion_function >", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("motion_function >=", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionLessThan(String value) {
            addCriterion("motion_function <", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionLessThanOrEqualTo(String value) {
            addCriterion("motion_function <=", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionLike(String value) {
            addCriterion("motion_function like", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionNotLike(String value) {
            addCriterion("motion_function not like", value, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionIn(List values) {
            addCriterion("motion_function in", values, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionNotIn(List values) {
            addCriterion("motion_function not in", values, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionBetween(String value1, String value2) {
            addCriterion("motion_function between", value1, value2, "motionFunction");
            return this;


        }

        public Criteria andMotionFunctionNotBetween(String value1, String value2) {
            addCriterion("motion_function not between", value1, value2, "motionFunction");
            return this;


        }

        public Criteria andSkinIsNull() {
            addCriterion("skin is null");
            return this;


        }

        public Criteria andSkinIsNotNull() {
            addCriterion("skin is not null");
            return this;


        }

        public Criteria andSkinEqualTo(String value) {
            addCriterion("skin =", value, "skin");
            return this;


        }

        public Criteria andSkinNotEqualTo(String value) {
            addCriterion("skin <>", value, "skin");
            return this;


        }

        public Criteria andSkinGreaterThan(String value) {
            addCriterion("skin >", value, "skin");
            return this;


        }

        public Criteria andSkinGreaterThanOrEqualTo(String value) {
            addCriterion("skin >=", value, "skin");
            return this;


        }

        public Criteria andSkinLessThan(String value) {
            addCriterion("skin <", value, "skin");
            return this;


        }

        public Criteria andSkinLessThanOrEqualTo(String value) {
            addCriterion("skin <=", value, "skin");
            return this;


        }

        public Criteria andSkinLike(String value) {
            addCriterion("skin like", value, "skin");
            return this;


        }

        public Criteria andSkinNotLike(String value) {
            addCriterion("skin not like", value, "skin");
            return this;


        }

        public Criteria andSkinIn(List values) {
            addCriterion("skin in", values, "skin");
            return this;


        }

        public Criteria andSkinNotIn(List values) {
            addCriterion("skin not in", values, "skin");
            return this;


        }

        public Criteria andSkinBetween(String value1, String value2) {
            addCriterion("skin between", value1, value2, "skin");
            return this;


        }

        public Criteria andSkinNotBetween(String value1, String value2) {
            addCriterion("skin not between", value1, value2, "skin");
            return this;


        }

        public Criteria andLymphNodesIsNull() {
            addCriterion("lymph_nodes is null");
            return this;


        }

        public Criteria andLymphNodesIsNotNull() {
            addCriterion("lymph_nodes is not null");
            return this;


        }

        public Criteria andLymphNodesEqualTo(String value) {
            addCriterion("lymph_nodes =", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesNotEqualTo(String value) {
            addCriterion("lymph_nodes <>", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesGreaterThan(String value) {
            addCriterion("lymph_nodes >", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesGreaterThanOrEqualTo(String value) {
            addCriterion("lymph_nodes >=", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesLessThan(String value) {
            addCriterion("lymph_nodes <", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesLessThanOrEqualTo(String value) {
            addCriterion("lymph_nodes <=", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesLike(String value) {
            addCriterion("lymph_nodes like", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesNotLike(String value) {
            addCriterion("lymph_nodes not like", value, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesIn(List values) {
            addCriterion("lymph_nodes in", values, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesNotIn(List values) {
            addCriterion("lymph_nodes not in", values, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesBetween(String value1, String value2) {
            addCriterion("lymph_nodes between", value1, value2, "lymphNodes");
            return this;


        }

        public Criteria andLymphNodesNotBetween(String value1, String value2) {
            addCriterion("lymph_nodes not between", value1, value2, "lymphNodes");
            return this;


        }

        public Criteria andLungsIsNull() {
            addCriterion("lungs is null");
            return this;


        }

        public Criteria andLungsIsNotNull() {
            addCriterion("lungs is not null");
            return this;


        }

        public Criteria andLungsEqualTo(String value) {
            addCriterion("lungs =", value, "lungs");
            return this;


        }

        public Criteria andLungsNotEqualTo(String value) {
            addCriterion("lungs <>", value, "lungs");
            return this;


        }

        public Criteria andLungsGreaterThan(String value) {
            addCriterion("lungs >", value, "lungs");
            return this;


        }

        public Criteria andLungsGreaterThanOrEqualTo(String value) {
            addCriterion("lungs >=", value, "lungs");
            return this;


        }

        public Criteria andLungsLessThan(String value) {
            addCriterion("lungs <", value, "lungs");
            return this;


        }

        public Criteria andLungsLessThanOrEqualTo(String value) {
            addCriterion("lungs <=", value, "lungs");
            return this;


        }

        public Criteria andLungsLike(String value) {
            addCriterion("lungs like", value, "lungs");
            return this;


        }

        public Criteria andLungsNotLike(String value) {
            addCriterion("lungs not like", value, "lungs");
            return this;


        }

        public Criteria andLungsIn(List values) {
            addCriterion("lungs in", values, "lungs");
            return this;


        }

        public Criteria andLungsNotIn(List values) {
            addCriterion("lungs not in", values, "lungs");
            return this;


        }

        public Criteria andLungsBetween(String value1, String value2) {
            addCriterion("lungs between", value1, value2, "lungs");
            return this;


        }

        public Criteria andLungsNotBetween(String value1, String value2) {
            addCriterion("lungs not between", value1, value2, "lungs");
            return this;


        }

        public Criteria andHeartIsNull() {
            addCriterion("heart is null");
            return this;


        }

        public Criteria andHeartIsNotNull() {
            addCriterion("heart is not null");
            return this;


        }

        public Criteria andHeartEqualTo(String value) {
            addCriterion("heart =", value, "heart");
            return this;


        }

        public Criteria andHeartNotEqualTo(String value) {
            addCriterion("heart <>", value, "heart");
            return this;


        }

        public Criteria andHeartGreaterThan(String value) {
            addCriterion("heart >", value, "heart");
            return this;


        }

        public Criteria andHeartGreaterThanOrEqualTo(String value) {
            addCriterion("heart >=", value, "heart");
            return this;


        }

        public Criteria andHeartLessThan(String value) {
            addCriterion("heart <", value, "heart");
            return this;


        }

        public Criteria andHeartLessThanOrEqualTo(String value) {
            addCriterion("heart <=", value, "heart");
            return this;


        }

        public Criteria andHeartLike(String value) {
            addCriterion("heart like", value, "heart");
            return this;


        }

        public Criteria andHeartNotLike(String value) {
            addCriterion("heart not like", value, "heart");
            return this;


        }

        public Criteria andHeartIn(List values) {
            addCriterion("heart in", values, "heart");
            return this;


        }

        public Criteria andHeartNotIn(List values) {
            addCriterion("heart not in", values, "heart");
            return this;


        }

        public Criteria andHeartBetween(String value1, String value2) {
            addCriterion("heart between", value1, value2, "heart");
            return this;


        }

        public Criteria andHeartNotBetween(String value1, String value2) {
            addCriterion("heart not between", value1, value2, "heart");
            return this;


        }

        public Criteria andAbdomenIsNull() {
            addCriterion("abdomen is null");
            return this;


        }

        public Criteria andAbdomenIsNotNull() {
            addCriterion("abdomen is not null");
            return this;


        }

        public Criteria andAbdomenEqualTo(String value) {
            addCriterion("abdomen =", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenNotEqualTo(String value) {
            addCriterion("abdomen <>", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenGreaterThan(String value) {
            addCriterion("abdomen >", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenGreaterThanOrEqualTo(String value) {
            addCriterion("abdomen >=", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenLessThan(String value) {
            addCriterion("abdomen <", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenLessThanOrEqualTo(String value) {
            addCriterion("abdomen <=", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenLike(String value) {
            addCriterion("abdomen like", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenNotLike(String value) {
            addCriterion("abdomen not like", value, "abdomen");
            return this;


        }

        public Criteria andAbdomenIn(List values) {
            addCriterion("abdomen in", values, "abdomen");
            return this;


        }

        public Criteria andAbdomenNotIn(List values) {
            addCriterion("abdomen not in", values, "abdomen");
            return this;


        }

        public Criteria andAbdomenBetween(String value1, String value2) {
            addCriterion("abdomen between", value1, value2, "abdomen");
            return this;


        }

        public Criteria andAbdomenNotBetween(String value1, String value2) {
            addCriterion("abdomen not between", value1, value2, "abdomen");
            return this;


        }

        public Criteria andEdemaIsNull() {
            addCriterion("edema is null");
            return this;


        }

        public Criteria andEdemaIsNotNull() {
            addCriterion("edema is not null");
            return this;


        }

        public Criteria andEdemaEqualTo(String value) {
            addCriterion("edema =", value, "edema");
            return this;


        }

        public Criteria andEdemaNotEqualTo(String value) {
            addCriterion("edema <>", value, "edema");
            return this;


        }

        public Criteria andEdemaGreaterThan(String value) {
            addCriterion("edema >", value, "edema");
            return this;


        }

        public Criteria andEdemaGreaterThanOrEqualTo(String value) {
            addCriterion("edema >=", value, "edema");
            return this;


        }

        public Criteria andEdemaLessThan(String value) {
            addCriterion("edema <", value, "edema");
            return this;


        }

        public Criteria andEdemaLessThanOrEqualTo(String value) {
            addCriterion("edema <=", value, "edema");
            return this;


        }

        public Criteria andEdemaLike(String value) {
            addCriterion("edema like", value, "edema");
            return this;


        }

        public Criteria andEdemaNotLike(String value) {
            addCriterion("edema not like", value, "edema");
            return this;


        }

        public Criteria andEdemaIn(List values) {
            addCriterion("edema in", values, "edema");
            return this;


        }

        public Criteria andEdemaNotIn(List values) {
            addCriterion("edema not in", values, "edema");
            return this;


        }

        public Criteria andEdemaBetween(String value1, String value2) {
            addCriterion("edema between", value1, value2, "edema");
            return this;


        }

        public Criteria andEdemaNotBetween(String value1, String value2) {
            addCriterion("edema not between", value1, value2, "edema");
            return this;


        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return this;


        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return this;


        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return this;


        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return this;


        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return this;


        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return this;


        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return this;


        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return this;


        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return this;


        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return this;


        }

        public Criteria andOtherIn(List values) {
            addCriterion("other in", values, "other");
            return this;


        }

        public Criteria andOtherNotIn(List values) {
            addCriterion("other not in", values, "other");
            return this;


        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return this;


        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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


    }


}
