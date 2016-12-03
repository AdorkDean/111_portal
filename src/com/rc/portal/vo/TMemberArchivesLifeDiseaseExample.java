package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberArchivesLifeDiseaseExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberArchivesLifeDiseaseExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberArchivesLifeDiseaseExample(TMemberArchivesLifeDiseaseExample example) {
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

        public Criteria andSymptomIsNull() {
            addCriterion("symptom is null");
            return this;


        }

        public Criteria andSymptomIsNotNull() {
            addCriterion("symptom is not null");
            return this;


        }

        public Criteria andSymptomEqualTo(String value) {
            addCriterion("symptom =", value, "symptom");
            return this;


        }

        public Criteria andSymptomNotEqualTo(String value) {
            addCriterion("symptom <>", value, "symptom");
            return this;


        }

        public Criteria andSymptomGreaterThan(String value) {
            addCriterion("symptom >", value, "symptom");
            return this;


        }

        public Criteria andSymptomGreaterThanOrEqualTo(String value) {
            addCriterion("symptom >=", value, "symptom");
            return this;


        }

        public Criteria andSymptomLessThan(String value) {
            addCriterion("symptom <", value, "symptom");
            return this;


        }

        public Criteria andSymptomLessThanOrEqualTo(String value) {
            addCriterion("symptom <=", value, "symptom");
            return this;


        }

        public Criteria andSymptomLike(String value) {
            addCriterion("symptom like", value, "symptom");
            return this;


        }

        public Criteria andSymptomNotLike(String value) {
            addCriterion("symptom not like", value, "symptom");
            return this;


        }

        public Criteria andSymptomIn(List values) {
            addCriterion("symptom in", values, "symptom");
            return this;


        }

        public Criteria andSymptomNotIn(List values) {
            addCriterion("symptom not in", values, "symptom");
            return this;


        }

        public Criteria andSymptomBetween(String value1, String value2) {
            addCriterion("symptom between", value1, value2, "symptom");
            return this;


        }

        public Criteria andSymptomNotBetween(String value1, String value2) {
            addCriterion("symptom not between", value1, value2, "symptom");
            return this;


        }

        public Criteria andCostPayIsNull() {
            addCriterion("cost_pay is null");
            return this;


        }

        public Criteria andCostPayIsNotNull() {
            addCriterion("cost_pay is not null");
            return this;


        }

        public Criteria andCostPayEqualTo(String value) {
            addCriterion("cost_pay =", value, "costPay");
            return this;


        }

        public Criteria andCostPayNotEqualTo(String value) {
            addCriterion("cost_pay <>", value, "costPay");
            return this;


        }

        public Criteria andCostPayGreaterThan(String value) {
            addCriterion("cost_pay >", value, "costPay");
            return this;


        }

        public Criteria andCostPayGreaterThanOrEqualTo(String value) {
            addCriterion("cost_pay >=", value, "costPay");
            return this;


        }

        public Criteria andCostPayLessThan(String value) {
            addCriterion("cost_pay <", value, "costPay");
            return this;


        }

        public Criteria andCostPayLessThanOrEqualTo(String value) {
            addCriterion("cost_pay <=", value, "costPay");
            return this;


        }

        public Criteria andCostPayLike(String value) {
            addCriterion("cost_pay like", value, "costPay");
            return this;


        }

        public Criteria andCostPayNotLike(String value) {
            addCriterion("cost_pay not like", value, "costPay");
            return this;


        }

        public Criteria andCostPayIn(List values) {
            addCriterion("cost_pay in", values, "costPay");
            return this;


        }

        public Criteria andCostPayNotIn(List values) {
            addCriterion("cost_pay not in", values, "costPay");
            return this;


        }

        public Criteria andCostPayBetween(String value1, String value2) {
            addCriterion("cost_pay between", value1, value2, "costPay");
            return this;


        }

        public Criteria andCostPayNotBetween(String value1, String value2) {
            addCriterion("cost_pay not between", value1, value2, "costPay");
            return this;


        }

        public Criteria andMedicineAllergyIsNull() {
            addCriterion("medicine_allergy is null");
            return this;


        }

        public Criteria andMedicineAllergyIsNotNull() {
            addCriterion("medicine_allergy is not null");
            return this;


        }

        public Criteria andMedicineAllergyEqualTo(String value) {
            addCriterion("medicine_allergy =", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyNotEqualTo(String value) {
            addCriterion("medicine_allergy <>", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyGreaterThan(String value) {
            addCriterion("medicine_allergy >", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_allergy >=", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyLessThan(String value) {
            addCriterion("medicine_allergy <", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyLessThanOrEqualTo(String value) {
            addCriterion("medicine_allergy <=", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyLike(String value) {
            addCriterion("medicine_allergy like", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyNotLike(String value) {
            addCriterion("medicine_allergy not like", value, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyIn(List values) {
            addCriterion("medicine_allergy in", values, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyNotIn(List values) {
            addCriterion("medicine_allergy not in", values, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyBetween(String value1, String value2) {
            addCriterion("medicine_allergy between", value1, value2, "medicineAllergy");
            return this;


        }

        public Criteria andMedicineAllergyNotBetween(String value1, String value2) {
            addCriterion("medicine_allergy not between", value1, value2, "medicineAllergy");
            return this;


        }

        public Criteria andExposeHistoryIsNull() {
            addCriterion("expose_history is null");
            return this;


        }

        public Criteria andExposeHistoryIsNotNull() {
            addCriterion("expose_history is not null");
            return this;


        }

        public Criteria andExposeHistoryEqualTo(String value) {
            addCriterion("expose_history =", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryNotEqualTo(String value) {
            addCriterion("expose_history <>", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryGreaterThan(String value) {
            addCriterion("expose_history >", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("expose_history >=", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryLessThan(String value) {
            addCriterion("expose_history <", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryLessThanOrEqualTo(String value) {
            addCriterion("expose_history <=", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryLike(String value) {
            addCriterion("expose_history like", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryNotLike(String value) {
            addCriterion("expose_history not like", value, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryIn(List values) {
            addCriterion("expose_history in", values, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryNotIn(List values) {
            addCriterion("expose_history not in", values, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryBetween(String value1, String value2) {
            addCriterion("expose_history between", value1, value2, "exposeHistory");
            return this;


        }

        public Criteria andExposeHistoryNotBetween(String value1, String value2) {
            addCriterion("expose_history not between", value1, value2, "exposeHistory");
            return this;


        }

        public Criteria andPastHistoryIsNull() {
            addCriterion("past_history is null");
            return this;


        }

        public Criteria andPastHistoryIsNotNull() {
            addCriterion("past_history is not null");
            return this;


        }

        public Criteria andPastHistoryEqualTo(String value) {
            addCriterion("past_history =", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryNotEqualTo(String value) {
            addCriterion("past_history <>", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryGreaterThan(String value) {
            addCriterion("past_history >", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("past_history >=", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryLessThan(String value) {
            addCriterion("past_history <", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryLessThanOrEqualTo(String value) {
            addCriterion("past_history <=", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryLike(String value) {
            addCriterion("past_history like", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryNotLike(String value) {
            addCriterion("past_history not like", value, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryIn(List values) {
            addCriterion("past_history in", values, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryNotIn(List values) {
            addCriterion("past_history not in", values, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryBetween(String value1, String value2) {
            addCriterion("past_history between", value1, value2, "pastHistory");
            return this;


        }

        public Criteria andPastHistoryNotBetween(String value1, String value2) {
            addCriterion("past_history not between", value1, value2, "pastHistory");
            return this;


        }

        public Criteria andFamilyHistoryIsNull() {
            addCriterion("family_history is null");
            return this;


        }

        public Criteria andFamilyHistoryIsNotNull() {
            addCriterion("family_history is not null");
            return this;


        }

        public Criteria andFamilyHistoryEqualTo(String value) {
            addCriterion("family_history =", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryNotEqualTo(String value) {
            addCriterion("family_history <>", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryGreaterThan(String value) {
            addCriterion("family_history >", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("family_history >=", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryLessThan(String value) {
            addCriterion("family_history <", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryLessThanOrEqualTo(String value) {
            addCriterion("family_history <=", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryLike(String value) {
            addCriterion("family_history like", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryNotLike(String value) {
            addCriterion("family_history not like", value, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryIn(List values) {
            addCriterion("family_history in", values, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryNotIn(List values) {
            addCriterion("family_history not in", values, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryBetween(String value1, String value2) {
            addCriterion("family_history between", value1, value2, "familyHistory");
            return this;


        }

        public Criteria andFamilyHistoryNotBetween(String value1, String value2) {
            addCriterion("family_history not between", value1, value2, "familyHistory");
            return this;


        }

        public Criteria andIsDisabilityIsNull() {
            addCriterion("is_disability is null");
            return this;


        }

        public Criteria andIsDisabilityIsNotNull() {
            addCriterion("is_disability is not null");
            return this;


        }

        public Criteria andIsDisabilityEqualTo(String value) {
            addCriterion("is_disability =", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityNotEqualTo(String value) {
            addCriterion("is_disability <>", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityGreaterThan(String value) {
            addCriterion("is_disability >", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityGreaterThanOrEqualTo(String value) {
            addCriterion("is_disability >=", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityLessThan(String value) {
            addCriterion("is_disability <", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityLessThanOrEqualTo(String value) {
            addCriterion("is_disability <=", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityLike(String value) {
            addCriterion("is_disability like", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityNotLike(String value) {
            addCriterion("is_disability not like", value, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityIn(List values) {
            addCriterion("is_disability in", values, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityNotIn(List values) {
            addCriterion("is_disability not in", values, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityBetween(String value1, String value2) {
            addCriterion("is_disability between", value1, value2, "isDisability");
            return this;


        }

        public Criteria andIsDisabilityNotBetween(String value1, String value2) {
            addCriterion("is_disability not between", value1, value2, "isDisability");
            return this;


        }

        public Criteria andExerciseFrequencyIsNull() {
            addCriterion("exercise_frequency is null");
            return this;


        }

        public Criteria andExerciseFrequencyIsNotNull() {
            addCriterion("exercise_frequency is not null");
            return this;


        }

        public Criteria andExerciseFrequencyEqualTo(Integer value) {
            addCriterion("exercise_frequency =", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyNotEqualTo(Integer value) {
            addCriterion("exercise_frequency <>", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyGreaterThan(Integer value) {
            addCriterion("exercise_frequency >", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("exercise_frequency >=", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyLessThan(Integer value) {
            addCriterion("exercise_frequency <", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("exercise_frequency <=", value, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyIn(List values) {
            addCriterion("exercise_frequency in", values, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyNotIn(List values) {
            addCriterion("exercise_frequency not in", values, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("exercise_frequency between", value1, value2, "exerciseFrequency");
            return this;


        }

        public Criteria andExerciseFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("exercise_frequency not between", value1, value2, "exerciseFrequency");
            return this;


        }

        public Criteria andEachExerciseIsNull() {
            addCriterion("each_exercise is null");
            return this;


        }

        public Criteria andEachExerciseIsNotNull() {
            addCriterion("each_exercise is not null");
            return this;


        }

        public Criteria andEachExerciseEqualTo(String value) {
            addCriterion("each_exercise =", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseNotEqualTo(String value) {
            addCriterion("each_exercise <>", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseGreaterThan(String value) {
            addCriterion("each_exercise >", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseGreaterThanOrEqualTo(String value) {
            addCriterion("each_exercise >=", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseLessThan(String value) {
            addCriterion("each_exercise <", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseLessThanOrEqualTo(String value) {
            addCriterion("each_exercise <=", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseLike(String value) {
            addCriterion("each_exercise like", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseNotLike(String value) {
            addCriterion("each_exercise not like", value, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseIn(List values) {
            addCriterion("each_exercise in", values, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseNotIn(List values) {
            addCriterion("each_exercise not in", values, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseBetween(String value1, String value2) {
            addCriterion("each_exercise between", value1, value2, "eachExercise");
            return this;


        }

        public Criteria andEachExerciseNotBetween(String value1, String value2) {
            addCriterion("each_exercise not between", value1, value2, "eachExercise");
            return this;


        }

        public Criteria andExerciseTimeIsNull() {
            addCriterion("exercise_time is null");
            return this;


        }

        public Criteria andExerciseTimeIsNotNull() {
            addCriterion("exercise_time is not null");
            return this;


        }

        public Criteria andExerciseTimeEqualTo(String value) {
            addCriterion("exercise_time =", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeNotEqualTo(String value) {
            addCriterion("exercise_time <>", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeGreaterThan(String value) {
            addCriterion("exercise_time >", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exercise_time >=", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeLessThan(String value) {
            addCriterion("exercise_time <", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeLessThanOrEqualTo(String value) {
            addCriterion("exercise_time <=", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeLike(String value) {
            addCriterion("exercise_time like", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeNotLike(String value) {
            addCriterion("exercise_time not like", value, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeIn(List values) {
            addCriterion("exercise_time in", values, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeNotIn(List values) {
            addCriterion("exercise_time not in", values, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeBetween(String value1, String value2) {
            addCriterion("exercise_time between", value1, value2, "exerciseTime");
            return this;


        }

        public Criteria andExerciseTimeNotBetween(String value1, String value2) {
            addCriterion("exercise_time not between", value1, value2, "exerciseTime");
            return this;


        }

        public Criteria andExerciseModeIsNull() {
            addCriterion("exercise_mode is null");
            return this;


        }

        public Criteria andExerciseModeIsNotNull() {
            addCriterion("exercise_mode is not null");
            return this;


        }

        public Criteria andExerciseModeEqualTo(String value) {
            addCriterion("exercise_mode =", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeNotEqualTo(String value) {
            addCriterion("exercise_mode <>", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeGreaterThan(String value) {
            addCriterion("exercise_mode >", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeGreaterThanOrEqualTo(String value) {
            addCriterion("exercise_mode >=", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeLessThan(String value) {
            addCriterion("exercise_mode <", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeLessThanOrEqualTo(String value) {
            addCriterion("exercise_mode <=", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeLike(String value) {
            addCriterion("exercise_mode like", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeNotLike(String value) {
            addCriterion("exercise_mode not like", value, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeIn(List values) {
            addCriterion("exercise_mode in", values, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeNotIn(List values) {
            addCriterion("exercise_mode not in", values, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeBetween(String value1, String value2) {
            addCriterion("exercise_mode between", value1, value2, "exerciseMode");
            return this;


        }

        public Criteria andExerciseModeNotBetween(String value1, String value2) {
            addCriterion("exercise_mode not between", value1, value2, "exerciseMode");
            return this;


        }

        public Criteria andEatingHabitsIsNull() {
            addCriterion("eating_habits is null");
            return this;


        }

        public Criteria andEatingHabitsIsNotNull() {
            addCriterion("eating_habits is not null");
            return this;


        }

        public Criteria andEatingHabitsEqualTo(Integer value) {
            addCriterion("eating_habits =", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsNotEqualTo(Integer value) {
            addCriterion("eating_habits <>", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsGreaterThan(Integer value) {
            addCriterion("eating_habits >", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("eating_habits >=", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsLessThan(Integer value) {
            addCriterion("eating_habits <", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsLessThanOrEqualTo(Integer value) {
            addCriterion("eating_habits <=", value, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsIn(List values) {
            addCriterion("eating_habits in", values, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsNotIn(List values) {
            addCriterion("eating_habits not in", values, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsBetween(Integer value1, Integer value2) {
            addCriterion("eating_habits between", value1, value2, "eatingHabits");
            return this;


        }

        public Criteria andEatingHabitsNotBetween(Integer value1, Integer value2) {
            addCriterion("eating_habits not between", value1, value2, "eatingHabits");
            return this;


        }

        public Criteria andIsSmokingIsNull() {
            addCriterion("is_smoking is null");
            return this;


        }

        public Criteria andIsSmokingIsNotNull() {
            addCriterion("is_smoking is not null");
            return this;


        }

        public Criteria andIsSmokingEqualTo(Integer value) {
            addCriterion("is_smoking =", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingNotEqualTo(Integer value) {
            addCriterion("is_smoking <>", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingGreaterThan(Integer value) {
            addCriterion("is_smoking >", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_smoking >=", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingLessThan(Integer value) {
            addCriterion("is_smoking <", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingLessThanOrEqualTo(Integer value) {
            addCriterion("is_smoking <=", value, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingIn(List values) {
            addCriterion("is_smoking in", values, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingNotIn(List values) {
            addCriterion("is_smoking not in", values, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingBetween(Integer value1, Integer value2) {
            addCriterion("is_smoking between", value1, value2, "isSmoking");
            return this;


        }

        public Criteria andIsSmokingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_smoking not between", value1, value2, "isSmoking");
            return this;


        }

        public Criteria andStartSmokingDtIsNull() {
            addCriterion("start_smoking_dt is null");
            return this;


        }

        public Criteria andStartSmokingDtIsNotNull() {
            addCriterion("start_smoking_dt is not null");
            return this;


        }

        public Criteria andStartSmokingDtEqualTo(String value) {
            addCriterion("start_smoking_dt =", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtNotEqualTo(String value) {
            addCriterion("start_smoking_dt <>", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtGreaterThan(String value) {
            addCriterion("start_smoking_dt >", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtGreaterThanOrEqualTo(String value) {
            addCriterion("start_smoking_dt >=", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtLessThan(String value) {
            addCriterion("start_smoking_dt <", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtLessThanOrEqualTo(String value) {
            addCriterion("start_smoking_dt <=", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtLike(String value) {
            addCriterion("start_smoking_dt like", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtNotLike(String value) {
            addCriterion("start_smoking_dt not like", value, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtIn(List values) {
            addCriterion("start_smoking_dt in", values, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtNotIn(List values) {
            addCriterion("start_smoking_dt not in", values, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtBetween(String value1, String value2) {
            addCriterion("start_smoking_dt between", value1, value2, "startSmokingDt");
            return this;


        }

        public Criteria andStartSmokingDtNotBetween(String value1, String value2) {
            addCriterion("start_smoking_dt not between", value1, value2, "startSmokingDt");
            return this;


        }

        public Criteria andQuitSmokingIsNull() {
            addCriterion("quit_smoking is null");
            return this;


        }

        public Criteria andQuitSmokingIsNotNull() {
            addCriterion("quit_smoking is not null");
            return this;


        }

        public Criteria andQuitSmokingEqualTo(String value) {
            addCriterion("quit_smoking =", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingNotEqualTo(String value) {
            addCriterion("quit_smoking <>", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingGreaterThan(String value) {
            addCriterion("quit_smoking >", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingGreaterThanOrEqualTo(String value) {
            addCriterion("quit_smoking >=", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingLessThan(String value) {
            addCriterion("quit_smoking <", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingLessThanOrEqualTo(String value) {
            addCriterion("quit_smoking <=", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingLike(String value) {
            addCriterion("quit_smoking like", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingNotLike(String value) {
            addCriterion("quit_smoking not like", value, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingIn(List values) {
            addCriterion("quit_smoking in", values, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingNotIn(List values) {
            addCriterion("quit_smoking not in", values, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingBetween(String value1, String value2) {
            addCriterion("quit_smoking between", value1, value2, "quitSmoking");
            return this;


        }

        public Criteria andQuitSmokingNotBetween(String value1, String value2) {
            addCriterion("quit_smoking not between", value1, value2, "quitSmoking");
            return this;


        }

        public Criteria andSmokingAmountIsNull() {
            addCriterion("smoking_amount is null");
            return this;


        }

        public Criteria andSmokingAmountIsNotNull() {
            addCriterion("smoking_amount is not null");
            return this;


        }

        public Criteria andSmokingAmountEqualTo(String value) {
            addCriterion("smoking_amount =", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountNotEqualTo(String value) {
            addCriterion("smoking_amount <>", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountGreaterThan(String value) {
            addCriterion("smoking_amount >", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountGreaterThanOrEqualTo(String value) {
            addCriterion("smoking_amount >=", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountLessThan(String value) {
            addCriterion("smoking_amount <", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountLessThanOrEqualTo(String value) {
            addCriterion("smoking_amount <=", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountLike(String value) {
            addCriterion("smoking_amount like", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountNotLike(String value) {
            addCriterion("smoking_amount not like", value, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountIn(List values) {
            addCriterion("smoking_amount in", values, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountNotIn(List values) {
            addCriterion("smoking_amount not in", values, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountBetween(String value1, String value2) {
            addCriterion("smoking_amount between", value1, value2, "smokingAmount");
            return this;


        }

        public Criteria andSmokingAmountNotBetween(String value1, String value2) {
            addCriterion("smoking_amount not between", value1, value2, "smokingAmount");
            return this;


        }

        public Criteria andDrinkingFrequencyIsNull() {
            addCriterion("drinking_frequency is null");
            return this;


        }

        public Criteria andDrinkingFrequencyIsNotNull() {
            addCriterion("drinking_frequency is not null");
            return this;


        }

        public Criteria andDrinkingFrequencyEqualTo(String value) {
            addCriterion("drinking_frequency =", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyNotEqualTo(String value) {
            addCriterion("drinking_frequency <>", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyGreaterThan(String value) {
            addCriterion("drinking_frequency >", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("drinking_frequency >=", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyLessThan(String value) {
            addCriterion("drinking_frequency <", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyLessThanOrEqualTo(String value) {
            addCriterion("drinking_frequency <=", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyLike(String value) {
            addCriterion("drinking_frequency like", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyNotLike(String value) {
            addCriterion("drinking_frequency not like", value, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyIn(List values) {
            addCriterion("drinking_frequency in", values, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyNotIn(List values) {
            addCriterion("drinking_frequency not in", values, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyBetween(String value1, String value2) {
            addCriterion("drinking_frequency between", value1, value2, "drinkingFrequency");
            return this;


        }

        public Criteria andDrinkingFrequencyNotBetween(String value1, String value2) {
            addCriterion("drinking_frequency not between", value1, value2, "drinkingFrequency");
            return this;


        }

        public Criteria andStartDrinkDtIsNull() {
            addCriterion("start_drink_dt is null");
            return this;


        }

        public Criteria andStartDrinkDtIsNotNull() {
            addCriterion("start_drink_dt is not null");
            return this;


        }

        public Criteria andStartDrinkDtEqualTo(String value) {
            addCriterion("start_drink_dt =", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtNotEqualTo(String value) {
            addCriterion("start_drink_dt <>", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtGreaterThan(String value) {
            addCriterion("start_drink_dt >", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtGreaterThanOrEqualTo(String value) {
            addCriterion("start_drink_dt >=", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtLessThan(String value) {
            addCriterion("start_drink_dt <", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtLessThanOrEqualTo(String value) {
            addCriterion("start_drink_dt <=", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtLike(String value) {
            addCriterion("start_drink_dt like", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtNotLike(String value) {
            addCriterion("start_drink_dt not like", value, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtIn(List values) {
            addCriterion("start_drink_dt in", values, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtNotIn(List values) {
            addCriterion("start_drink_dt not in", values, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtBetween(String value1, String value2) {
            addCriterion("start_drink_dt between", value1, value2, "startDrinkDt");
            return this;


        }

        public Criteria andStartDrinkDtNotBetween(String value1, String value2) {
            addCriterion("start_drink_dt not between", value1, value2, "startDrinkDt");
            return this;


        }

        public Criteria andQuitDrinkingIsNull() {
            addCriterion("quit_drinking is null");
            return this;


        }

        public Criteria andQuitDrinkingIsNotNull() {
            addCriterion("quit_drinking is not null");
            return this;


        }

        public Criteria andQuitDrinkingEqualTo(String value) {
            addCriterion("quit_drinking =", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingNotEqualTo(String value) {
            addCriterion("quit_drinking <>", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingGreaterThan(String value) {
            addCriterion("quit_drinking >", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingGreaterThanOrEqualTo(String value) {
            addCriterion("quit_drinking >=", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingLessThan(String value) {
            addCriterion("quit_drinking <", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingLessThanOrEqualTo(String value) {
            addCriterion("quit_drinking <=", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingLike(String value) {
            addCriterion("quit_drinking like", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingNotLike(String value) {
            addCriterion("quit_drinking not like", value, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingIn(List values) {
            addCriterion("quit_drinking in", values, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingNotIn(List values) {
            addCriterion("quit_drinking not in", values, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingBetween(String value1, String value2) {
            addCriterion("quit_drinking between", value1, value2, "quitDrinking");
            return this;


        }

        public Criteria andQuitDrinkingNotBetween(String value1, String value2) {
            addCriterion("quit_drinking not between", value1, value2, "quitDrinking");
            return this;


        }

        public Criteria andIsDrunkIsNull() {
            addCriterion("is_drunk is null");
            return this;


        }

        public Criteria andIsDrunkIsNotNull() {
            addCriterion("is_drunk is not null");
            return this;


        }

        public Criteria andIsDrunkEqualTo(Integer value) {
            addCriterion("is_drunk =", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkNotEqualTo(Integer value) {
            addCriterion("is_drunk <>", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkGreaterThan(Integer value) {
            addCriterion("is_drunk >", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_drunk >=", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkLessThan(Integer value) {
            addCriterion("is_drunk <", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkLessThanOrEqualTo(Integer value) {
            addCriterion("is_drunk <=", value, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkIn(List values) {
            addCriterion("is_drunk in", values, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkNotIn(List values) {
            addCriterion("is_drunk not in", values, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkBetween(Integer value1, Integer value2) {
            addCriterion("is_drunk between", value1, value2, "isDrunk");
            return this;


        }

        public Criteria andIsDrunkNotBetween(Integer value1, Integer value2) {
            addCriterion("is_drunk not between", value1, value2, "isDrunk");
            return this;


        }

        public Criteria andAlcoholConsumptionIsNull() {
            addCriterion("alcohol_consumption is null");
            return this;


        }

        public Criteria andAlcoholConsumptionIsNotNull() {
            addCriterion("alcohol_consumption is not null");
            return this;


        }

        public Criteria andAlcoholConsumptionEqualTo(String value) {
            addCriterion("alcohol_consumption =", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionNotEqualTo(String value) {
            addCriterion("alcohol_consumption <>", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionGreaterThan(String value) {
            addCriterion("alcohol_consumption >", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("alcohol_consumption >=", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionLessThan(String value) {
            addCriterion("alcohol_consumption <", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionLessThanOrEqualTo(String value) {
            addCriterion("alcohol_consumption <=", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionLike(String value) {
            addCriterion("alcohol_consumption like", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionNotLike(String value) {
            addCriterion("alcohol_consumption not like", value, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionIn(List values) {
            addCriterion("alcohol_consumption in", values, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionNotIn(List values) {
            addCriterion("alcohol_consumption not in", values, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionBetween(String value1, String value2) {
            addCriterion("alcohol_consumption between", value1, value2, "alcoholConsumption");
            return this;


        }

        public Criteria andAlcoholConsumptionNotBetween(String value1, String value2) {
            addCriterion("alcohol_consumption not between", value1, value2, "alcoholConsumption");
            return this;


        }

        public Criteria andDrinkVarietiesIsNull() {
            addCriterion("drink_varieties is null");
            return this;


        }

        public Criteria andDrinkVarietiesIsNotNull() {
            addCriterion("drink_varieties is not null");
            return this;


        }

        public Criteria andDrinkVarietiesEqualTo(String value) {
            addCriterion("drink_varieties =", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesNotEqualTo(String value) {
            addCriterion("drink_varieties <>", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesGreaterThan(String value) {
            addCriterion("drink_varieties >", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesGreaterThanOrEqualTo(String value) {
            addCriterion("drink_varieties >=", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesLessThan(String value) {
            addCriterion("drink_varieties <", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesLessThanOrEqualTo(String value) {
            addCriterion("drink_varieties <=", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesLike(String value) {
            addCriterion("drink_varieties like", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesNotLike(String value) {
            addCriterion("drink_varieties not like", value, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesIn(List values) {
            addCriterion("drink_varieties in", values, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesNotIn(List values) {
            addCriterion("drink_varieties not in", values, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesBetween(String value1, String value2) {
            addCriterion("drink_varieties between", value1, value2, "drinkVarieties");
            return this;


        }

        public Criteria andDrinkVarietiesNotBetween(String value1, String value2) {
            addCriterion("drink_varieties not between", value1, value2, "drinkVarieties");
            return this;


        }

        public Criteria andMentalStateIsNull() {
            addCriterion("mental_state is null");
            return this;


        }

        public Criteria andMentalStateIsNotNull() {
            addCriterion("mental_state is not null");
            return this;


        }

        public Criteria andMentalStateEqualTo(String value) {
            addCriterion("mental_state =", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateNotEqualTo(String value) {
            addCriterion("mental_state <>", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateGreaterThan(String value) {
            addCriterion("mental_state >", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateGreaterThanOrEqualTo(String value) {
            addCriterion("mental_state >=", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateLessThan(String value) {
            addCriterion("mental_state <", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateLessThanOrEqualTo(String value) {
            addCriterion("mental_state <=", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateLike(String value) {
            addCriterion("mental_state like", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateNotLike(String value) {
            addCriterion("mental_state not like", value, "mentalState");
            return this;


        }

        public Criteria andMentalStateIn(List values) {
            addCriterion("mental_state in", values, "mentalState");
            return this;


        }

        public Criteria andMentalStateNotIn(List values) {
            addCriterion("mental_state not in", values, "mentalState");
            return this;


        }

        public Criteria andMentalStateBetween(String value1, String value2) {
            addCriterion("mental_state between", value1, value2, "mentalState");
            return this;


        }

        public Criteria andMentalStateNotBetween(String value1, String value2) {
            addCriterion("mental_state not between", value1, value2, "mentalState");
            return this;


        }

        public Criteria andComplianceBehaviorIsNull() {
            addCriterion("compliance_behavior is null");
            return this;


        }

        public Criteria andComplianceBehaviorIsNotNull() {
            addCriterion("compliance_behavior is not null");
            return this;


        }

        public Criteria andComplianceBehaviorEqualTo(String value) {
            addCriterion("compliance_behavior =", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorNotEqualTo(String value) {
            addCriterion("compliance_behavior <>", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorGreaterThan(String value) {
            addCriterion("compliance_behavior >", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorGreaterThanOrEqualTo(String value) {
            addCriterion("compliance_behavior >=", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorLessThan(String value) {
            addCriterion("compliance_behavior <", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorLessThanOrEqualTo(String value) {
            addCriterion("compliance_behavior <=", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorLike(String value) {
            addCriterion("compliance_behavior like", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorNotLike(String value) {
            addCriterion("compliance_behavior not like", value, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorIn(List values) {
            addCriterion("compliance_behavior in", values, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorNotIn(List values) {
            addCriterion("compliance_behavior not in", values, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorBetween(String value1, String value2) {
            addCriterion("compliance_behavior between", value1, value2, "complianceBehavior");
            return this;


        }

        public Criteria andComplianceBehaviorNotBetween(String value1, String value2) {
            addCriterion("compliance_behavior not between", value1, value2, "complianceBehavior");
            return this;


        }

        public Criteria andLivingEnvironmentIsNull() {
            addCriterion("living_environment is null");
            return this;


        }

        public Criteria andLivingEnvironmentIsNotNull() {
            addCriterion("living_environment is not null");
            return this;


        }

        public Criteria andLivingEnvironmentEqualTo(String value) {
            addCriterion("living_environment =", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentNotEqualTo(String value) {
            addCriterion("living_environment <>", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentGreaterThan(String value) {
            addCriterion("living_environment >", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("living_environment >=", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentLessThan(String value) {
            addCriterion("living_environment <", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentLessThanOrEqualTo(String value) {
            addCriterion("living_environment <=", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentLike(String value) {
            addCriterion("living_environment like", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentNotLike(String value) {
            addCriterion("living_environment not like", value, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentIn(List values) {
            addCriterion("living_environment in", values, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentNotIn(List values) {
            addCriterion("living_environment not in", values, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentBetween(String value1, String value2) {
            addCriterion("living_environment between", value1, value2, "livingEnvironment");
            return this;


        }

        public Criteria andLivingEnvironmentNotBetween(String value1, String value2) {
            addCriterion("living_environment not between", value1, value2, "livingEnvironment");
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
