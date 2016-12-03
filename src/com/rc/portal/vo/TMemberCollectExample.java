package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberCollectExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberCollectExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberCollectExample(TMemberCollectExample example) {
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

        public Criteria andRelevanceIdIsNull() {
            addCriterion("relevance_id is null");
            return this;


        }

        public Criteria andRelevanceIdIsNotNull() {
            addCriterion("relevance_id is not null");
            return this;


        }

        public Criteria andRelevanceIdEqualTo(Long value) {
            addCriterion("relevance_id =", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdNotEqualTo(Long value) {
            addCriterion("relevance_id <>", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdGreaterThan(Long value) {
            addCriterion("relevance_id >", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relevance_id >=", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdLessThan(Long value) {
            addCriterion("relevance_id <", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdLessThanOrEqualTo(Long value) {
            addCriterion("relevance_id <=", value, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdIn(List values) {
            addCriterion("relevance_id in", values, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdNotIn(List values) {
            addCriterion("relevance_id not in", values, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdBetween(Long value1, Long value2) {
            addCriterion("relevance_id between", value1, value2, "relevanceId");
            return this;


        }

        public Criteria andRelevanceIdNotBetween(Long value1, Long value2) {
            addCriterion("relevance_id not between", value1, value2, "relevanceId");
            return this;


        }

        public Criteria andCollectTypeIsNull() {
            addCriterion("collect_type is null");
            return this;


        }

        public Criteria andCollectTypeIsNotNull() {
            addCriterion("collect_type is not null");
            return this;


        }

        public Criteria andCollectTypeEqualTo(Integer value) {
            addCriterion("collect_type =", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeNotEqualTo(Integer value) {
            addCriterion("collect_type <>", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeGreaterThan(Integer value) {
            addCriterion("collect_type >", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_type >=", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeLessThan(Integer value) {
            addCriterion("collect_type <", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("collect_type <=", value, "collectType");
            return this;


        }

        public Criteria andCollectTypeIn(List values) {
            addCriterion("collect_type in", values, "collectType");
            return this;


        }

        public Criteria andCollectTypeNotIn(List values) {
            addCriterion("collect_type not in", values, "collectType");
            return this;


        }

        public Criteria andCollectTypeBetween(Integer value1, Integer value2) {
            addCriterion("collect_type between", value1, value2, "collectType");
            return this;


        }

        public Criteria andCollectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_type not between", value1, value2, "collectType");
            return this;


        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return this;


        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return this;


        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return this;


        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateIn(List values) {
            addCriterion("create_date in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateNotIn(List values) {
            addCriterion("create_date not in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return this;


        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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


    }


}
