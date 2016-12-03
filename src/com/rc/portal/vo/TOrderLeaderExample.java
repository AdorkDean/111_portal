package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TOrderLeaderExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TOrderLeaderExample() {
        oredCriteria = new ArrayList();


    }

    protected TOrderLeaderExample(TOrderLeaderExample example) {
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

        public Criteria andLeaderIdIsNull() {
            addCriterion("leader_id is null");
            return this;


        }

        public Criteria andLeaderIdIsNotNull() {
            addCriterion("leader_id is not null");
            return this;


        }

        public Criteria andLeaderIdEqualTo(Long value) {
            addCriterion("leader_id =", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotEqualTo(Long value) {
            addCriterion("leader_id <>", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdGreaterThan(Long value) {
            addCriterion("leader_id >", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("leader_id >=", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdLessThan(Long value) {
            addCriterion("leader_id <", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("leader_id <=", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdIn(List values) {
            addCriterion("leader_id in", values, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotIn(List values) {
            addCriterion("leader_id not in", values, "leaderId");
            return this;


        }

        public Criteria andLeaderIdBetween(Long value1, Long value2) {
            addCriterion("leader_id between", value1, value2, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("leader_id not between", value1, value2, "leaderId");
            return this;


        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return this;


        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return this;


        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return this;


        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdIn(List values) {
            addCriterion("order_id in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdNotIn(List values) {
            addCriterion("order_id not in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return this;


        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return this;


        }

        public Criteria andOrderFinishDtIsNull() {
            addCriterion("order_finish_dt is null");
            return this;


        }

        public Criteria andOrderFinishDtIsNotNull() {
            addCriterion("order_finish_dt is not null");
            return this;


        }

        public Criteria andOrderFinishDtEqualTo(Date value) {
            addCriterion("order_finish_dt =", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtNotEqualTo(Date value) {
            addCriterion("order_finish_dt <>", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtGreaterThan(Date value) {
            addCriterion("order_finish_dt >", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtGreaterThanOrEqualTo(Date value) {
            addCriterion("order_finish_dt >=", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtLessThan(Date value) {
            addCriterion("order_finish_dt <", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtLessThanOrEqualTo(Date value) {
            addCriterion("order_finish_dt <=", value, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtIn(List values) {
            addCriterion("order_finish_dt in", values, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtNotIn(List values) {
            addCriterion("order_finish_dt not in", values, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtBetween(Date value1, Date value2) {
            addCriterion("order_finish_dt between", value1, value2, "orderFinishDt");
            return this;


        }

        public Criteria andOrderFinishDtNotBetween(Date value1, Date value2) {
            addCriterion("order_finish_dt not between", value1, value2, "orderFinishDt");
            return this;


        }

        public Criteria andIsFinishIsNull() {
            addCriterion("is_finish is null");
            return this;


        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("is_finish is not null");
            return this;


        }

        public Criteria andIsFinishEqualTo(Integer value) {
            addCriterion("is_finish =", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishNotEqualTo(Integer value) {
            addCriterion("is_finish <>", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishGreaterThan(Integer value) {
            addCriterion("is_finish >", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_finish >=", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishLessThan(Integer value) {
            addCriterion("is_finish <", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishLessThanOrEqualTo(Integer value) {
            addCriterion("is_finish <=", value, "isFinish");
            return this;


        }

        public Criteria andIsFinishIn(List values) {
            addCriterion("is_finish in", values, "isFinish");
            return this;


        }

        public Criteria andIsFinishNotIn(List values) {
            addCriterion("is_finish not in", values, "isFinish");
            return this;


        }

        public Criteria andIsFinishBetween(Integer value1, Integer value2) {
            addCriterion("is_finish between", value1, value2, "isFinish");
            return this;


        }

        public Criteria andIsFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("is_finish not between", value1, value2, "isFinish");
            return this;


        }


    }


}
