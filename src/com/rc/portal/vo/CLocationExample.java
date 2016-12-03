package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CLocationExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CLocationExample() {
        oredCriteria = new ArrayList();


    }

    protected CLocationExample(CLocationExample example) {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;


        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;


        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;


        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;


        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;


        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
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

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;


        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;


        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return this;


        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return this;


        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return this;


        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return this;


        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return this;


        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return this;


        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return this;


        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return this;


        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return this;


        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return this;


        }

        public Criteria andNameIn(List values) {
            addCriterion("name in", values, "name");
            return this;


        }

        public Criteria andNameNotIn(List values) {
            addCriterion("name not in", values, "name");
            return this;


        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return this;


        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return this;


        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return this;


        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return this;


        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return this;


        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return this;


        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return this;


        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return this;


        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return this;


        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return this;


        }

        public Criteria andParentidIn(List values) {
            addCriterion("parentid in", values, "parentid");
            return this;


        }

        public Criteria andParentidNotIn(List values) {
            addCriterion("parentid not in", values, "parentid");
            return this;


        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return this;


        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return this;


        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return this;


        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return this;


        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return this;


        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return this;


        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return this;


        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return this;


        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return this;


        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return this;


        }

        public Criteria andGradeIn(List values) {
            addCriterion("grade in", values, "grade");
            return this;


        }

        public Criteria andGradeNotIn(List values) {
            addCriterion("grade not in", values, "grade");
            return this;


        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return this;


        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return this;


        }


    }


}
