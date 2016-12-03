package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberAmountOutExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberAmountOutExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberAmountOutExample(TMemberAmountOutExample example) {
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

        public Criteria andOutTypeIsNull() {
            addCriterion("out_type is null");
            return this;


        }

        public Criteria andOutTypeIsNotNull() {
            addCriterion("out_type is not null");
            return this;


        }

        public Criteria andOutTypeEqualTo(Integer value) {
            addCriterion("out_type =", value, "outType");
            return this;


        }

        public Criteria andOutTypeNotEqualTo(Integer value) {
            addCriterion("out_type <>", value, "outType");
            return this;


        }

        public Criteria andOutTypeGreaterThan(Integer value) {
            addCriterion("out_type >", value, "outType");
            return this;


        }

        public Criteria andOutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_type >=", value, "outType");
            return this;


        }

        public Criteria andOutTypeLessThan(Integer value) {
            addCriterion("out_type <", value, "outType");
            return this;


        }

        public Criteria andOutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_type <=", value, "outType");
            return this;


        }

        public Criteria andOutTypeIn(List values) {
            addCriterion("out_type in", values, "outType");
            return this;


        }

        public Criteria andOutTypeNotIn(List values) {
            addCriterion("out_type not in", values, "outType");
            return this;


        }

        public Criteria andOutTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_type between", value1, value2, "outType");
            return this;


        }

        public Criteria andOutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_type not between", value1, value2, "outType");
            return this;


        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return this;


        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return this;


        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return this;


        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return this;


        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return this;


        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return this;


        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return this;


        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return this;


        }

        public Criteria andAmountIn(List values) {
            addCriterion("amount in", values, "amount");
            return this;


        }

        public Criteria andAmountNotIn(List values) {
            addCriterion("amount not in", values, "amount");
            return this;


        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return this;


        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return this;


        }

        public Criteria andAlipayNoIsNull() {
            addCriterion("alipay_no is null");
            return this;


        }

        public Criteria andAlipayNoIsNotNull() {
            addCriterion("alipay_no is not null");
            return this;


        }

        public Criteria andAlipayNoEqualTo(String value) {
            addCriterion("alipay_no =", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoNotEqualTo(String value) {
            addCriterion("alipay_no <>", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoGreaterThan(String value) {
            addCriterion("alipay_no >", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_no >=", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoLessThan(String value) {
            addCriterion("alipay_no <", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoLessThanOrEqualTo(String value) {
            addCriterion("alipay_no <=", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoLike(String value) {
            addCriterion("alipay_no like", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoNotLike(String value) {
            addCriterion("alipay_no not like", value, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoIn(List values) {
            addCriterion("alipay_no in", values, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoNotIn(List values) {
            addCriterion("alipay_no not in", values, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoBetween(String value1, String value2) {
            addCriterion("alipay_no between", value1, value2, "alipayNo");
            return this;


        }

        public Criteria andAlipayNoNotBetween(String value1, String value2) {
            addCriterion("alipay_no not between", value1, value2, "alipayNo");
            return this;


        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return this;


        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return this;


        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return this;


        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return this;


        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return this;


        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return this;


        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return this;


        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return this;


        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return this;


        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return this;


        }

        public Criteria andBankNameIn(List values) {
            addCriterion("bank_name in", values, "bankName");
            return this;


        }

        public Criteria andBankNameNotIn(List values) {
            addCriterion("bank_name not in", values, "bankName");
            return this;


        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return this;


        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return this;


        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return this;


        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return this;


        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return this;


        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return this;


        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return this;


        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return this;


        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return this;


        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return this;


        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return this;


        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return this;


        }

        public Criteria andBankNoIn(List values) {
            addCriterion("bank_no in", values, "bankNo");
            return this;


        }

        public Criteria andBankNoNotIn(List values) {
            addCriterion("bank_no not in", values, "bankNo");
            return this;


        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return this;


        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return this;


        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return this;


        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return this;


        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return this;


        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return this;


        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return this;


        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return this;


        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return this;


        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return this;


        }

        public Criteria andOutTimeIn(List values) {
            addCriterion("out_time in", values, "outTime");
            return this;


        }

        public Criteria andOutTimeNotIn(List values) {
            addCriterion("out_time not in", values, "outTime");
            return this;


        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return this;


        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return this;


        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return this;


        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return this;


        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return this;


        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return this;


        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return this;


        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return this;


        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return this;


        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return this;


        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return this;


        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return this;


        }

        public Criteria andRealNameIn(List values) {
            addCriterion("real_name in", values, "realName");
            return this;


        }

        public Criteria andRealNameNotIn(List values) {
            addCriterion("real_name not in", values, "realName");
            return this;


        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return this;


        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return this;


        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return this;


        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return this;


        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return this;


        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return this;


        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return this;


        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return this;


        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return this;


        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return this;


        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return this;


        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return this;


        }

        public Criteria andCardIdIn(List values) {
            addCriterion("card_id in", values, "cardId");
            return this;


        }

        public Criteria andCardIdNotIn(List values) {
            addCriterion("card_id not in", values, "cardId");
            return this;


        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return this;


        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return this;


        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return this;


        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return this;


        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return this;


        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return this;


        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return this;


        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return this;


        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return this;


        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return this;


        }

        public Criteria andStatusIn(List values) {
            addCriterion("status in", values, "status");
            return this;


        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("status not in", values, "status");
            return this;


        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return this;


        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return this;


        }

        public Criteria andOutFeeIsNull() {
            addCriterion("out_fee is null");
            return this;


        }

        public Criteria andOutFeeIsNotNull() {
            addCriterion("out_fee is not null");
            return this;


        }

        public Criteria andOutFeeEqualTo(BigDecimal value) {
            addCriterion("out_fee =", value, "outFee");
            return this;


        }

        public Criteria andOutFeeNotEqualTo(BigDecimal value) {
            addCriterion("out_fee <>", value, "outFee");
            return this;


        }

        public Criteria andOutFeeGreaterThan(BigDecimal value) {
            addCriterion("out_fee >", value, "outFee");
            return this;


        }

        public Criteria andOutFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_fee >=", value, "outFee");
            return this;


        }

        public Criteria andOutFeeLessThan(BigDecimal value) {
            addCriterion("out_fee <", value, "outFee");
            return this;


        }

        public Criteria andOutFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_fee <=", value, "outFee");
            return this;


        }

        public Criteria andOutFeeIn(List values) {
            addCriterion("out_fee in", values, "outFee");
            return this;


        }

        public Criteria andOutFeeNotIn(List values) {
            addCriterion("out_fee not in", values, "outFee");
            return this;


        }

        public Criteria andOutFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_fee between", value1, value2, "outFee");
            return this;


        }

        public Criteria andOutFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_fee not between", value1, value2, "outFee");
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return this;


        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return this;


        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberIn(List values) {
            addCriterion("serial_number in", values, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotIn(List values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return this;


        }


    }


}
