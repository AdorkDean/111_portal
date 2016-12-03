package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxReceiveRedExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxReceiveRedExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxReceiveRedExample(TLxReceiveRedExample example) {
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

        public Criteria andRedIdIsNull() {
            addCriterion("red_id is null");
            return this;


        }

        public Criteria andRedIdIsNotNull() {
            addCriterion("red_id is not null");
            return this;


        }

        public Criteria andRedIdEqualTo(Long value) {
            addCriterion("red_id =", value, "redId");
            return this;


        }

        public Criteria andRedIdNotEqualTo(Long value) {
            addCriterion("red_id <>", value, "redId");
            return this;


        }

        public Criteria andRedIdGreaterThan(Long value) {
            addCriterion("red_id >", value, "redId");
            return this;


        }

        public Criteria andRedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("red_id >=", value, "redId");
            return this;


        }

        public Criteria andRedIdLessThan(Long value) {
            addCriterion("red_id <", value, "redId");
            return this;


        }

        public Criteria andRedIdLessThanOrEqualTo(Long value) {
            addCriterion("red_id <=", value, "redId");
            return this;


        }

        public Criteria andRedIdIn(List values) {
            addCriterion("red_id in", values, "redId");
            return this;


        }

        public Criteria andRedIdNotIn(List values) {
            addCriterion("red_id not in", values, "redId");
            return this;


        }

        public Criteria andRedIdBetween(Long value1, Long value2) {
            addCriterion("red_id between", value1, value2, "redId");
            return this;


        }

        public Criteria andRedIdNotBetween(Long value1, Long value2) {
            addCriterion("red_id not between", value1, value2, "redId");
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

        public Criteria andReceiveDtIsNull() {
            addCriterion("receive_dt is null");
            return this;


        }

        public Criteria andReceiveDtIsNotNull() {
            addCriterion("receive_dt is not null");
            return this;


        }

        public Criteria andReceiveDtEqualTo(Date value) {
            addCriterion("receive_dt =", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtNotEqualTo(Date value) {
            addCriterion("receive_dt <>", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtGreaterThan(Date value) {
            addCriterion("receive_dt >", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_dt >=", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtLessThan(Date value) {
            addCriterion("receive_dt <", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtLessThanOrEqualTo(Date value) {
            addCriterion("receive_dt <=", value, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtIn(List values) {
            addCriterion("receive_dt in", values, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtNotIn(List values) {
            addCriterion("receive_dt not in", values, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtBetween(Date value1, Date value2) {
            addCriterion("receive_dt between", value1, value2, "receiveDt");
            return this;


        }

        public Criteria andReceiveDtNotBetween(Date value1, Date value2) {
            addCriterion("receive_dt not between", value1, value2, "receiveDt");
            return this;


        }

        public Criteria andCouponCardIdIsNull() {
            addCriterion("coupon_card_id is null");
            return this;


        }

        public Criteria andCouponCardIdIsNotNull() {
            addCriterion("coupon_card_id is not null");
            return this;


        }

        public Criteria andCouponCardIdEqualTo(Long value) {
            addCriterion("coupon_card_id =", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdNotEqualTo(Long value) {
            addCriterion("coupon_card_id <>", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdGreaterThan(Long value) {
            addCriterion("coupon_card_id >", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_card_id >=", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdLessThan(Long value) {
            addCriterion("coupon_card_id <", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_card_id <=", value, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdIn(List values) {
            addCriterion("coupon_card_id in", values, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdNotIn(List values) {
            addCriterion("coupon_card_id not in", values, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdBetween(Long value1, Long value2) {
            addCriterion("coupon_card_id between", value1, value2, "couponCardId");
            return this;


        }

        public Criteria andCouponCardIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_card_id not between", value1, value2, "couponCardId");
            return this;


        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return this;


        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return this;


        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return this;


        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return this;


        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return this;


        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return this;


        }

        public Criteria andMobileIn(List values) {
            addCriterion("mobile in", values, "mobile");
            return this;


        }

        public Criteria andMobileNotIn(List values) {
            addCriterion("mobile not in", values, "mobile");
            return this;


        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return this;


        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return this;


        }


    }


}
