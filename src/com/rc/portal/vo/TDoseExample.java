package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TDoseExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TDoseExample() {
        oredCriteria = new ArrayList();


    }

    protected TDoseExample(TDoseExample example) {
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

        public Criteria andDosenameIsNull() {
            addCriterion("dosename is null");
            return this;


        }

        public Criteria andDosenameIsNotNull() {
            addCriterion("dosename is not null");
            return this;


        }

        public Criteria andDosenameEqualTo(String value) {
            addCriterion("dosename =", value, "dosename");
            return this;


        }

        public Criteria andDosenameNotEqualTo(String value) {
            addCriterion("dosename <>", value, "dosename");
            return this;


        }

        public Criteria andDosenameGreaterThan(String value) {
            addCriterion("dosename >", value, "dosename");
            return this;


        }

        public Criteria andDosenameGreaterThanOrEqualTo(String value) {
            addCriterion("dosename >=", value, "dosename");
            return this;


        }

        public Criteria andDosenameLessThan(String value) {
            addCriterion("dosename <", value, "dosename");
            return this;


        }

        public Criteria andDosenameLessThanOrEqualTo(String value) {
            addCriterion("dosename <=", value, "dosename");
            return this;


        }

        public Criteria andDosenameLike(String value) {
            addCriterion("dosename like", value, "dosename");
            return this;


        }

        public Criteria andDosenameNotLike(String value) {
            addCriterion("dosename not like", value, "dosename");
            return this;


        }

        public Criteria andDosenameIn(List values) {
            addCriterion("dosename in", values, "dosename");
            return this;


        }

        public Criteria andDosenameNotIn(List values) {
            addCriterion("dosename not in", values, "dosename");
            return this;


        }

        public Criteria andDosenameBetween(String value1, String value2) {
            addCriterion("dosename between", value1, value2, "dosename");
            return this;


        }

        public Criteria andDosenameNotBetween(String value1, String value2) {
            addCriterion("dosename not between", value1, value2, "dosename");
            return this;


        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return this;


        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return this;


        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return this;


        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return this;


        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return this;


        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return this;


        }

        public Criteria andSortIn(List values) {
            addCriterion("sort in", values, "sort");
            return this;


        }

        public Criteria andSortNotIn(List values) {
            addCriterion("sort not in", values, "sort");
            return this;


        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return this;


        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return this;


        }

        public Criteria andDoseDescribeIsNull() {
            addCriterion("dose_describe is null");
            return this;


        }

        public Criteria andDoseDescribeIsNotNull() {
            addCriterion("dose_describe is not null");
            return this;


        }

        public Criteria andDoseDescribeEqualTo(String value) {
            addCriterion("dose_describe =", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeNotEqualTo(String value) {
            addCriterion("dose_describe <>", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeGreaterThan(String value) {
            addCriterion("dose_describe >", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("dose_describe >=", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeLessThan(String value) {
            addCriterion("dose_describe <", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeLessThanOrEqualTo(String value) {
            addCriterion("dose_describe <=", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeLike(String value) {
            addCriterion("dose_describe like", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeNotLike(String value) {
            addCriterion("dose_describe not like", value, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeIn(List values) {
            addCriterion("dose_describe in", values, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeNotIn(List values) {
            addCriterion("dose_describe not in", values, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeBetween(String value1, String value2) {
            addCriterion("dose_describe between", value1, value2, "doseDescribe");
            return this;


        }

        public Criteria andDoseDescribeNotBetween(String value1, String value2) {
            addCriterion("dose_describe not between", value1, value2, "doseDescribe");
            return this;


        }


    }


}
