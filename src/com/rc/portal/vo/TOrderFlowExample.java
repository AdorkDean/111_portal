package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TOrderFlowExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TOrderFlowExample() {
        oredCriteria = new ArrayList();


    }

    protected TOrderFlowExample(TOrderFlowExample example) {
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

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return this;


        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return this;


        }

        public Criteria andPaymentStatusEqualTo(Integer value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusNotEqualTo(Integer value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusGreaterThan(Integer value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusLessThan(Integer value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusIn(List values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusNotIn(List values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusBetween(Integer value1, Integer value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return this;


        }

        public Criteria andPaymentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
            return this;


        }

        public Criteria andPaymentPluginIsNull() {
            addCriterion("payment_plugin is null");
            return this;


        }

        public Criteria andPaymentPluginIsNotNull() {
            addCriterion("payment_plugin is not null");
            return this;


        }

        public Criteria andPaymentPluginEqualTo(String value) {
            addCriterion("payment_plugin =", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginNotEqualTo(String value) {
            addCriterion("payment_plugin <>", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginGreaterThan(String value) {
            addCriterion("payment_plugin >", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginGreaterThanOrEqualTo(String value) {
            addCriterion("payment_plugin >=", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginLessThan(String value) {
            addCriterion("payment_plugin <", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginLessThanOrEqualTo(String value) {
            addCriterion("payment_plugin <=", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginLike(String value) {
            addCriterion("payment_plugin like", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginNotLike(String value) {
            addCriterion("payment_plugin not like", value, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginIn(List values) {
            addCriterion("payment_plugin in", values, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginNotIn(List values) {
            addCriterion("payment_plugin not in", values, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginBetween(String value1, String value2) {
            addCriterion("payment_plugin between", value1, value2, "paymentPlugin");
            return this;


        }

        public Criteria andPaymentPluginNotBetween(String value1, String value2) {
            addCriterion("payment_plugin not between", value1, value2, "paymentPlugin");
            return this;


        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return this;


        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return this;


        }

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("pay_method =", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("pay_method <>", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("pay_method >", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_method >=", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("pay_method <", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("pay_method <=", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("pay_method like", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("pay_method not like", value, "payMethod");
            return this;


        }

        public Criteria andPayMethodIn(List values) {
            addCriterion("pay_method in", values, "payMethod");
            return this;


        }

        public Criteria andPayMethodNotIn(List values) {
            addCriterion("pay_method not in", values, "payMethod");
            return this;


        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return this;


        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return this;


        }

        public Criteria andHavePayIsNull() {
            addCriterion("have_pay is null");
            return this;


        }

        public Criteria andHavePayIsNotNull() {
            addCriterion("have_pay is not null");
            return this;


        }

        public Criteria andHavePayEqualTo(BigDecimal value) {
            addCriterion("have_pay =", value, "havePay");
            return this;


        }

        public Criteria andHavePayNotEqualTo(BigDecimal value) {
            addCriterion("have_pay <>", value, "havePay");
            return this;


        }

        public Criteria andHavePayGreaterThan(BigDecimal value) {
            addCriterion("have_pay >", value, "havePay");
            return this;


        }

        public Criteria andHavePayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("have_pay >=", value, "havePay");
            return this;


        }

        public Criteria andHavePayLessThan(BigDecimal value) {
            addCriterion("have_pay <", value, "havePay");
            return this;


        }

        public Criteria andHavePayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("have_pay <=", value, "havePay");
            return this;


        }

        public Criteria andHavePayIn(List values) {
            addCriterion("have_pay in", values, "havePay");
            return this;


        }

        public Criteria andHavePayNotIn(List values) {
            addCriterion("have_pay not in", values, "havePay");
            return this;


        }

        public Criteria andHavePayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("have_pay between", value1, value2, "havePay");
            return this;


        }

        public Criteria andHavePayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("have_pay not between", value1, value2, "havePay");
            return this;


        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return this;


        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return this;


        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterion("pay_date =", value, "payDate");
            return this;


        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "payDate");
            return this;


        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "payDate");
            return this;


        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "payDate");
            return this;


        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterion("pay_date <", value, "payDate");
            return this;


        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "payDate");
            return this;


        }

        public Criteria andPayDateIn(List values) {
            addCriterion("pay_date in", values, "payDate");
            return this;


        }

        public Criteria andPayDateNotIn(List values) {
            addCriterion("pay_date not in", values, "payDate");
            return this;


        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return this;


        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
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

        public Criteria andThirdPaySerialnumberIsNull() {
            addCriterion("third_pay_serialnumber is null");
            return this;


        }

        public Criteria andThirdPaySerialnumberIsNotNull() {
            addCriterion("third_pay_serialnumber is not null");
            return this;


        }

        public Criteria andThirdPaySerialnumberEqualTo(String value) {
            addCriterion("third_pay_serialnumber =", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberNotEqualTo(String value) {
            addCriterion("third_pay_serialnumber <>", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberGreaterThan(String value) {
            addCriterion("third_pay_serialnumber >", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("third_pay_serialnumber >=", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberLessThan(String value) {
            addCriterion("third_pay_serialnumber <", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberLessThanOrEqualTo(String value) {
            addCriterion("third_pay_serialnumber <=", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberLike(String value) {
            addCriterion("third_pay_serialnumber like", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberNotLike(String value) {
            addCriterion("third_pay_serialnumber not like", value, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberIn(List values) {
            addCriterion("third_pay_serialnumber in", values, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberNotIn(List values) {
            addCriterion("third_pay_serialnumber not in", values, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberBetween(String value1, String value2) {
            addCriterion("third_pay_serialnumber between", value1, value2, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andThirdPaySerialnumberNotBetween(String value1, String value2) {
            addCriterion("third_pay_serialnumber not between", value1, value2, "thirdPaySerialnumber");
            return this;


        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return this;


        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return this;


        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("create_time in", values, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("create_time not in", values, "createTime");
            return this;


        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
