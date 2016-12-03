package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TSysParameterExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TSysParameterExample() {
        oredCriteria = new ArrayList();


    }

    protected TSysParameterExample(TSysParameterExample example) {
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

        public Criteria andSysKeyIsNull() {
            addCriterion("sys_key is null");
            return this;


        }

        public Criteria andSysKeyIsNotNull() {
            addCriterion("sys_key is not null");
            return this;


        }

        public Criteria andSysKeyEqualTo(String value) {
            addCriterion("sys_key =", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyNotEqualTo(String value) {
            addCriterion("sys_key <>", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyGreaterThan(String value) {
            addCriterion("sys_key >", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sys_key >=", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyLessThan(String value) {
            addCriterion("sys_key <", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyLessThanOrEqualTo(String value) {
            addCriterion("sys_key <=", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyLike(String value) {
            addCriterion("sys_key like", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyNotLike(String value) {
            addCriterion("sys_key not like", value, "sysKey");
            return this;


        }

        public Criteria andSysKeyIn(List values) {
            addCriterion("sys_key in", values, "sysKey");
            return this;


        }

        public Criteria andSysKeyNotIn(List values) {
            addCriterion("sys_key not in", values, "sysKey");
            return this;


        }

        public Criteria andSysKeyBetween(String value1, String value2) {
            addCriterion("sys_key between", value1, value2, "sysKey");
            return this;


        }

        public Criteria andSysKeyNotBetween(String value1, String value2) {
            addCriterion("sys_key not between", value1, value2, "sysKey");
            return this;


        }

        public Criteria andSysValueIsNull() {
            addCriterion("sys_value is null");
            return this;


        }

        public Criteria andSysValueIsNotNull() {
            addCriterion("sys_value is not null");
            return this;


        }

        public Criteria andSysValueEqualTo(String value) {
            addCriterion("sys_value =", value, "sysValue");
            return this;


        }

        public Criteria andSysValueNotEqualTo(String value) {
            addCriterion("sys_value <>", value, "sysValue");
            return this;


        }

        public Criteria andSysValueGreaterThan(String value) {
            addCriterion("sys_value >", value, "sysValue");
            return this;


        }

        public Criteria andSysValueGreaterThanOrEqualTo(String value) {
            addCriterion("sys_value >=", value, "sysValue");
            return this;


        }

        public Criteria andSysValueLessThan(String value) {
            addCriterion("sys_value <", value, "sysValue");
            return this;


        }

        public Criteria andSysValueLessThanOrEqualTo(String value) {
            addCriterion("sys_value <=", value, "sysValue");
            return this;


        }

        public Criteria andSysValueLike(String value) {
            addCriterion("sys_value like", value, "sysValue");
            return this;


        }

        public Criteria andSysValueNotLike(String value) {
            addCriterion("sys_value not like", value, "sysValue");
            return this;


        }

        public Criteria andSysValueIn(List values) {
            addCriterion("sys_value in", values, "sysValue");
            return this;


        }

        public Criteria andSysValueNotIn(List values) {
            addCriterion("sys_value not in", values, "sysValue");
            return this;


        }

        public Criteria andSysValueBetween(String value1, String value2) {
            addCriterion("sys_value between", value1, value2, "sysValue");
            return this;


        }

        public Criteria andSysValueNotBetween(String value1, String value2) {
            addCriterion("sys_value not between", value1, value2, "sysValue");
            return this;


        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return this;


        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return this;


        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return this;


        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return this;


        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return this;


        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return this;


        }

        public Criteria andRemarkIn(List values) {
            addCriterion("remark in", values, "remark");
            return this;


        }

        public Criteria andRemarkNotIn(List values) {
            addCriterion("remark not in", values, "remark");
            return this;


        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return this;


        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return this;


        }


    }


}
