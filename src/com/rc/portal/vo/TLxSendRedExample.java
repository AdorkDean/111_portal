package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxSendRedExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxSendRedExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxSendRedExample(TLxSendRedExample example) {
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

        public Criteria andCententIsNull() {
            addCriterion("centent is null");
            return this;


        }

        public Criteria andCententIsNotNull() {
            addCriterion("centent is not null");
            return this;


        }

        public Criteria andCententEqualTo(String value) {
            addCriterion("centent =", value, "centent");
            return this;


        }

        public Criteria andCententNotEqualTo(String value) {
            addCriterion("centent <>", value, "centent");
            return this;


        }

        public Criteria andCententGreaterThan(String value) {
            addCriterion("centent >", value, "centent");
            return this;


        }

        public Criteria andCententGreaterThanOrEqualTo(String value) {
            addCriterion("centent >=", value, "centent");
            return this;


        }

        public Criteria andCententLessThan(String value) {
            addCriterion("centent <", value, "centent");
            return this;


        }

        public Criteria andCententLessThanOrEqualTo(String value) {
            addCriterion("centent <=", value, "centent");
            return this;


        }

        public Criteria andCententLike(String value) {
            addCriterion("centent like", value, "centent");
            return this;


        }

        public Criteria andCententNotLike(String value) {
            addCriterion("centent not like", value, "centent");
            return this;


        }

        public Criteria andCententIn(List values) {
            addCriterion("centent in", values, "centent");
            return this;


        }

        public Criteria andCententNotIn(List values) {
            addCriterion("centent not in", values, "centent");
            return this;


        }

        public Criteria andCententBetween(String value1, String value2) {
            addCriterion("centent between", value1, value2, "centent");
            return this;


        }

        public Criteria andCententNotBetween(String value1, String value2) {
            addCriterion("centent not between", value1, value2, "centent");
            return this;


        }

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return this;


        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return this;


        }

        public Criteria andRelationIdEqualTo(Long value) {
            addCriterion("relation_id =", value, "relationId");
            return this;


        }

        public Criteria andRelationIdNotEqualTo(Long value) {
            addCriterion("relation_id <>", value, "relationId");
            return this;


        }

        public Criteria andRelationIdGreaterThan(Long value) {
            addCriterion("relation_id >", value, "relationId");
            return this;


        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_id >=", value, "relationId");
            return this;


        }

        public Criteria andRelationIdLessThan(Long value) {
            addCriterion("relation_id <", value, "relationId");
            return this;


        }

        public Criteria andRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_id <=", value, "relationId");
            return this;


        }

        public Criteria andRelationIdIn(List values) {
            addCriterion("relation_id in", values, "relationId");
            return this;


        }

        public Criteria andRelationIdNotIn(List values) {
            addCriterion("relation_id not in", values, "relationId");
            return this;


        }

        public Criteria andRelationIdBetween(Long value1, Long value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return this;


        }

        public Criteria andRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return this;


        }

        public Criteria andSendDtIsNull() {
            addCriterion("send_dt is null");
            return this;


        }

        public Criteria andSendDtIsNotNull() {
            addCriterion("send_dt is not null");
            return this;


        }

        public Criteria andSendDtEqualTo(Date value) {
            addCriterion("send_dt =", value, "sendDt");
            return this;


        }

        public Criteria andSendDtNotEqualTo(Date value) {
            addCriterion("send_dt <>", value, "sendDt");
            return this;


        }

        public Criteria andSendDtGreaterThan(Date value) {
            addCriterion("send_dt >", value, "sendDt");
            return this;


        }

        public Criteria andSendDtGreaterThanOrEqualTo(Date value) {
            addCriterion("send_dt >=", value, "sendDt");
            return this;


        }

        public Criteria andSendDtLessThan(Date value) {
            addCriterion("send_dt <", value, "sendDt");
            return this;


        }

        public Criteria andSendDtLessThanOrEqualTo(Date value) {
            addCriterion("send_dt <=", value, "sendDt");
            return this;


        }

        public Criteria andSendDtIn(List values) {
            addCriterion("send_dt in", values, "sendDt");
            return this;


        }

        public Criteria andSendDtNotIn(List values) {
            addCriterion("send_dt not in", values, "sendDt");
            return this;


        }

        public Criteria andSendDtBetween(Date value1, Date value2) {
            addCriterion("send_dt between", value1, value2, "sendDt");
            return this;


        }

        public Criteria andSendDtNotBetween(Date value1, Date value2) {
            addCriterion("send_dt not between", value1, value2, "sendDt");
            return this;


        }

        public Criteria andRedTypeIsNull() {
            addCriterion("red_type is null");
            return this;


        }

        public Criteria andRedTypeIsNotNull() {
            addCriterion("red_type is not null");
            return this;


        }

        public Criteria andRedTypeEqualTo(Integer value) {
            addCriterion("red_type =", value, "redType");
            return this;


        }

        public Criteria andRedTypeNotEqualTo(Integer value) {
            addCriterion("red_type <>", value, "redType");
            return this;


        }

        public Criteria andRedTypeGreaterThan(Integer value) {
            addCriterion("red_type >", value, "redType");
            return this;


        }

        public Criteria andRedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("red_type >=", value, "redType");
            return this;


        }

        public Criteria andRedTypeLessThan(Integer value) {
            addCriterion("red_type <", value, "redType");
            return this;


        }

        public Criteria andRedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("red_type <=", value, "redType");
            return this;


        }

        public Criteria andRedTypeIn(List values) {
            addCriterion("red_type in", values, "redType");
            return this;


        }

        public Criteria andRedTypeNotIn(List values) {
            addCriterion("red_type not in", values, "redType");
            return this;


        }

        public Criteria andRedTypeBetween(Integer value1, Integer value2) {
            addCriterion("red_type between", value1, value2, "redType");
            return this;


        }

        public Criteria andRedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("red_type not between", value1, value2, "redType");
            return this;


        }


    }


}
