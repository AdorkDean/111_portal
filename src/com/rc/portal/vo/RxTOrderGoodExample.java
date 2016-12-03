package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class RxTOrderGoodExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public RxTOrderGoodExample() {
        oredCriteria = new ArrayList();


    }

    protected RxTOrderGoodExample(RxTOrderGoodExample example) {
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

        public Criteria andReserveOrderIdIsNull() {
            addCriterion("reserve_order_id is null");
            return this;


        }

        public Criteria andReserveOrderIdIsNotNull() {
            addCriterion("reserve_order_id is not null");
            return this;


        }

        public Criteria andReserveOrderIdEqualTo(Long value) {
            addCriterion("reserve_order_id =", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdNotEqualTo(Long value) {
            addCriterion("reserve_order_id <>", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdGreaterThan(Long value) {
            addCriterion("reserve_order_id >", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reserve_order_id >=", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdLessThan(Long value) {
            addCriterion("reserve_order_id <", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("reserve_order_id <=", value, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdIn(List values) {
            addCriterion("reserve_order_id in", values, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdNotIn(List values) {
            addCriterion("reserve_order_id not in", values, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdBetween(Long value1, Long value2) {
            addCriterion("reserve_order_id between", value1, value2, "reserveOrderId");
            return this;


        }

        public Criteria andReserveOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("reserve_order_id not between", value1, value2, "reserveOrderId");
            return this;


        }

        public Criteria andGoodidIsNull() {
            addCriterion("goodid is null");
            return this;


        }

        public Criteria andGoodidIsNotNull() {
            addCriterion("goodid is not null");
            return this;


        }

        public Criteria andGoodidEqualTo(Long value) {
            addCriterion("goodid =", value, "goodid");
            return this;


        }

        public Criteria andGoodidNotEqualTo(Long value) {
            addCriterion("goodid <>", value, "goodid");
            return this;


        }

        public Criteria andGoodidGreaterThan(Long value) {
            addCriterion("goodid >", value, "goodid");
            return this;


        }

        public Criteria andGoodidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodid >=", value, "goodid");
            return this;


        }

        public Criteria andGoodidLessThan(Long value) {
            addCriterion("goodid <", value, "goodid");
            return this;


        }

        public Criteria andGoodidLessThanOrEqualTo(Long value) {
            addCriterion("goodid <=", value, "goodid");
            return this;


        }

        public Criteria andGoodidIn(List values) {
            addCriterion("goodid in", values, "goodid");
            return this;


        }

        public Criteria andGoodidNotIn(List values) {
            addCriterion("goodid not in", values, "goodid");
            return this;


        }

        public Criteria andGoodidBetween(Long value1, Long value2) {
            addCriterion("goodid between", value1, value2, "goodid");
            return this;


        }

        public Criteria andGoodidNotBetween(Long value1, Long value2) {
            addCriterion("goodid not between", value1, value2, "goodid");
            return this;


        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return this;


        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return this;


        }

        public Criteria andGoodPriceEqualTo(BigDecimal value) {
            addCriterion("good_price =", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotEqualTo(BigDecimal value) {
            addCriterion("good_price <>", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceGreaterThan(BigDecimal value) {
            addCriterion("good_price >", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price >=", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceLessThan(BigDecimal value) {
            addCriterion("good_price <", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price <=", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceIn(List values) {
            addCriterion("good_price in", values, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotIn(List values) {
            addCriterion("good_price not in", values, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return this;


        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return this;


        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return this;


        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return this;


        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return this;


        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return this;


        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return this;


        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return this;


        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return this;


        }

        public Criteria andNumIn(List values) {
            addCriterion("num in", values, "num");
            return this;


        }

        public Criteria andNumNotIn(List values) {
            addCriterion("num not in", values, "num");
            return this;


        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return this;


        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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


    }


}
