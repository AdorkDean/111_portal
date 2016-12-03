package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberAccountExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberAccountExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberAccountExample(TMemberAccountExample example) {
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

        public Criteria andRemainingAmountIsNull() {
            addCriterion("remaining_amount is null");
            return this;


        }

        public Criteria andRemainingAmountIsNotNull() {
            addCriterion("remaining_amount is not null");
            return this;


        }

        public Criteria andRemainingAmountEqualTo(BigDecimal value) {
            addCriterion("remaining_amount =", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountNotEqualTo(BigDecimal value) {
            addCriterion("remaining_amount <>", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountGreaterThan(BigDecimal value) {
            addCriterion("remaining_amount >", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining_amount >=", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountLessThan(BigDecimal value) {
            addCriterion("remaining_amount <", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining_amount <=", value, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountIn(List values) {
            addCriterion("remaining_amount in", values, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountNotIn(List values) {
            addCriterion("remaining_amount not in", values, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining_amount between", value1, value2, "remainingAmount");
            return this;


        }

        public Criteria andRemainingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining_amount not between", value1, value2, "remainingAmount");
            return this;


        }

        public Criteria andFreezeAmountIsNull() {
            addCriterion("freeze_amount is null");
            return this;


        }

        public Criteria andFreezeAmountIsNotNull() {
            addCriterion("freeze_amount is not null");
            return this;


        }

        public Criteria andFreezeAmountEqualTo(BigDecimal value) {
            addCriterion("freeze_amount =", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountNotEqualTo(BigDecimal value) {
            addCriterion("freeze_amount <>", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountGreaterThan(BigDecimal value) {
            addCriterion("freeze_amount >", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_amount >=", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountLessThan(BigDecimal value) {
            addCriterion("freeze_amount <", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_amount <=", value, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountIn(List values) {
            addCriterion("freeze_amount in", values, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountNotIn(List values) {
            addCriterion("freeze_amount not in", values, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_amount between", value1, value2, "freezeAmount");
            return this;


        }

        public Criteria andFreezeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_amount not between", value1, value2, "freezeAmount");
            return this;


        }

        public Criteria andWaitAmountIsNull() {
            addCriterion("wait_amount is null");
            return this;


        }

        public Criteria andWaitAmountIsNotNull() {
            addCriterion("wait_amount is not null");
            return this;


        }

        public Criteria andWaitAmountEqualTo(BigDecimal value) {
            addCriterion("wait_amount =", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountNotEqualTo(BigDecimal value) {
            addCriterion("wait_amount <>", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountGreaterThan(BigDecimal value) {
            addCriterion("wait_amount >", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wait_amount >=", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountLessThan(BigDecimal value) {
            addCriterion("wait_amount <", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wait_amount <=", value, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountIn(List values) {
            addCriterion("wait_amount in", values, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountNotIn(List values) {
            addCriterion("wait_amount not in", values, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wait_amount between", value1, value2, "waitAmount");
            return this;


        }

        public Criteria andWaitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wait_amount not between", value1, value2, "waitAmount");
            return this;


        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return this;


        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return this;


        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountIn(List values) {
            addCriterion("total_amount in", values, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountNotIn(List values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return this;


        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return this;


        }


    }


}
