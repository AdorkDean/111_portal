package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TReturnExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TReturnExample() {
        oredCriteria = new ArrayList();


    }

    protected TReturnExample(TReturnExample example) {
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

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return this;


        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return this;


        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnIn(List values) {
            addCriterion("order_sn in", values, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotIn(List values) {
            addCriterion("order_sn not in", values, "orderSn");
            return this;


        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return this;


        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return this;


        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return this;


        }

        public Criteria andServiceTypeEqualTo(Integer value) {
            addCriterion("service_type =", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeNotEqualTo(Integer value) {
            addCriterion("service_type <>", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeGreaterThan(Integer value) {
            addCriterion("service_type >", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_type >=", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeLessThan(Integer value) {
            addCriterion("service_type <", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_type <=", value, "serviceType");
            return this;


        }

        public Criteria andServiceTypeIn(List values) {
            addCriterion("service_type in", values, "serviceType");
            return this;


        }

        public Criteria andServiceTypeNotIn(List values) {
            addCriterion("service_type not in", values, "serviceType");
            return this;


        }

        public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return this;


        }

        public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return this;


        }

        public Criteria andExpressDeliveryIsNull() {
            addCriterion("express_delivery is null");
            return this;


        }

        public Criteria andExpressDeliveryIsNotNull() {
            addCriterion("express_delivery is not null");
            return this;


        }

        public Criteria andExpressDeliveryEqualTo(String value) {
            addCriterion("express_delivery =", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryNotEqualTo(String value) {
            addCriterion("express_delivery <>", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryGreaterThan(String value) {
            addCriterion("express_delivery >", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("express_delivery >=", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryLessThan(String value) {
            addCriterion("express_delivery <", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryLessThanOrEqualTo(String value) {
            addCriterion("express_delivery <=", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryLike(String value) {
            addCriterion("express_delivery like", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryNotLike(String value) {
            addCriterion("express_delivery not like", value, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryIn(List values) {
            addCriterion("express_delivery in", values, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryNotIn(List values) {
            addCriterion("express_delivery not in", values, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryBetween(String value1, String value2) {
            addCriterion("express_delivery between", value1, value2, "expressDelivery");
            return this;


        }

        public Criteria andExpressDeliveryNotBetween(String value1, String value2) {
            addCriterion("express_delivery not between", value1, value2, "expressDelivery");
            return this;


        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return this;


        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return this;


        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyIn(List values) {
            addCriterion("express_company in", values, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyNotIn(List values) {
            addCriterion("express_company not in", values, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return this;


        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return this;


        }

        public Criteria andShipperPhoneIsNull() {
            addCriterion("shipper_phone is null");
            return this;


        }

        public Criteria andShipperPhoneIsNotNull() {
            addCriterion("shipper_phone is not null");
            return this;


        }

        public Criteria andShipperPhoneEqualTo(String value) {
            addCriterion("shipper_phone =", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneNotEqualTo(String value) {
            addCriterion("shipper_phone <>", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneGreaterThan(String value) {
            addCriterion("shipper_phone >", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shipper_phone >=", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneLessThan(String value) {
            addCriterion("shipper_phone <", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneLessThanOrEqualTo(String value) {
            addCriterion("shipper_phone <=", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneLike(String value) {
            addCriterion("shipper_phone like", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneNotLike(String value) {
            addCriterion("shipper_phone not like", value, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneIn(List values) {
            addCriterion("shipper_phone in", values, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneNotIn(List values) {
            addCriterion("shipper_phone not in", values, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneBetween(String value1, String value2) {
            addCriterion("shipper_phone between", value1, value2, "shipperPhone");
            return this;


        }

        public Criteria andShipperPhoneNotBetween(String value1, String value2) {
            addCriterion("shipper_phone not between", value1, value2, "shipperPhone");
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

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return this;


        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return this;


        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountIn(List values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountNotIn(List values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return this;


        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return this;


        }

        public Criteria andRefundDescribeIsNull() {
            addCriterion("refund_describe is null");
            return this;


        }

        public Criteria andRefundDescribeIsNotNull() {
            addCriterion("refund_describe is not null");
            return this;


        }

        public Criteria andRefundDescribeEqualTo(String value) {
            addCriterion("refund_describe =", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeNotEqualTo(String value) {
            addCriterion("refund_describe <>", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeGreaterThan(String value) {
            addCriterion("refund_describe >", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_describe >=", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeLessThan(String value) {
            addCriterion("refund_describe <", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeLessThanOrEqualTo(String value) {
            addCriterion("refund_describe <=", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeLike(String value) {
            addCriterion("refund_describe like", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeNotLike(String value) {
            addCriterion("refund_describe not like", value, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeIn(List values) {
            addCriterion("refund_describe in", values, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeNotIn(List values) {
            addCriterion("refund_describe not in", values, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeBetween(String value1, String value2) {
            addCriterion("refund_describe between", value1, value2, "refundDescribe");
            return this;


        }

        public Criteria andRefundDescribeNotBetween(String value1, String value2) {
            addCriterion("refund_describe not between", value1, value2, "refundDescribe");
            return this;


        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return this;


        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return this;


        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusIn(List values) {
            addCriterion("order_status in", values, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotIn(List values) {
            addCriterion("order_status not in", values, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return this;


        }

        public Criteria andRefundAccountIsNull() {
            addCriterion("refund_account is null");
            return this;


        }

        public Criteria andRefundAccountIsNotNull() {
            addCriterion("refund_account is not null");
            return this;


        }

        public Criteria andRefundAccountEqualTo(String value) {
            addCriterion("refund_account =", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountNotEqualTo(String value) {
            addCriterion("refund_account <>", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountGreaterThan(String value) {
            addCriterion("refund_account >", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountGreaterThanOrEqualTo(String value) {
            addCriterion("refund_account >=", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountLessThan(String value) {
            addCriterion("refund_account <", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountLessThanOrEqualTo(String value) {
            addCriterion("refund_account <=", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountLike(String value) {
            addCriterion("refund_account like", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountNotLike(String value) {
            addCriterion("refund_account not like", value, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountIn(List values) {
            addCriterion("refund_account in", values, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountNotIn(List values) {
            addCriterion("refund_account not in", values, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountBetween(String value1, String value2) {
            addCriterion("refund_account between", value1, value2, "refundAccount");
            return this;


        }

        public Criteria andRefundAccountNotBetween(String value1, String value2) {
            addCriterion("refund_account not between", value1, value2, "refundAccount");
            return this;


        }

        public Criteria andRefundBankIsNull() {
            addCriterion("refund_bank is null");
            return this;


        }

        public Criteria andRefundBankIsNotNull() {
            addCriterion("refund_bank is not null");
            return this;


        }

        public Criteria andRefundBankEqualTo(String value) {
            addCriterion("refund_bank =", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankNotEqualTo(String value) {
            addCriterion("refund_bank <>", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankGreaterThan(String value) {
            addCriterion("refund_bank >", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankGreaterThanOrEqualTo(String value) {
            addCriterion("refund_bank >=", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankLessThan(String value) {
            addCriterion("refund_bank <", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankLessThanOrEqualTo(String value) {
            addCriterion("refund_bank <=", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankLike(String value) {
            addCriterion("refund_bank like", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankNotLike(String value) {
            addCriterion("refund_bank not like", value, "refundBank");
            return this;


        }

        public Criteria andRefundBankIn(List values) {
            addCriterion("refund_bank in", values, "refundBank");
            return this;


        }

        public Criteria andRefundBankNotIn(List values) {
            addCriterion("refund_bank not in", values, "refundBank");
            return this;


        }

        public Criteria andRefundBankBetween(String value1, String value2) {
            addCriterion("refund_bank between", value1, value2, "refundBank");
            return this;


        }

        public Criteria andRefundBankNotBetween(String value1, String value2) {
            addCriterion("refund_bank not between", value1, value2, "refundBank");
            return this;


        }

        public Criteria andRefundRemarkIsNull() {
            addCriterion("refund_remark is null");
            return this;


        }

        public Criteria andRefundRemarkIsNotNull() {
            addCriterion("refund_remark is not null");
            return this;


        }

        public Criteria andRefundRemarkEqualTo(String value) {
            addCriterion("refund_remark =", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkNotEqualTo(String value) {
            addCriterion("refund_remark <>", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkGreaterThan(String value) {
            addCriterion("refund_remark >", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("refund_remark >=", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkLessThan(String value) {
            addCriterion("refund_remark <", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkLessThanOrEqualTo(String value) {
            addCriterion("refund_remark <=", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkLike(String value) {
            addCriterion("refund_remark like", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkNotLike(String value) {
            addCriterion("refund_remark not like", value, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkIn(List values) {
            addCriterion("refund_remark in", values, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkNotIn(List values) {
            addCriterion("refund_remark not in", values, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkBetween(String value1, String value2) {
            addCriterion("refund_remark between", value1, value2, "refundRemark");
            return this;


        }

        public Criteria andRefundRemarkNotBetween(String value1, String value2) {
            addCriterion("refund_remark not between", value1, value2, "refundRemark");
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

        public Criteria andOldOrderIdIsNull() {
            addCriterion("old_order_id is null");
            return this;


        }

        public Criteria andOldOrderIdIsNotNull() {
            addCriterion("old_order_id is not null");
            return this;


        }

        public Criteria andOldOrderIdEqualTo(Long value) {
            addCriterion("old_order_id =", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdNotEqualTo(Long value) {
            addCriterion("old_order_id <>", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdGreaterThan(Long value) {
            addCriterion("old_order_id >", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("old_order_id >=", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdLessThan(Long value) {
            addCriterion("old_order_id <", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("old_order_id <=", value, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdIn(List values) {
            addCriterion("old_order_id in", values, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdNotIn(List values) {
            addCriterion("old_order_id not in", values, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdBetween(Long value1, Long value2) {
            addCriterion("old_order_id between", value1, value2, "oldOrderId");
            return this;


        }

        public Criteria andOldOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("old_order_id not between", value1, value2, "oldOrderId");
            return this;
        }

        public Criteria andFinishDtIsNull() {
            addCriterion("finish_dt is null");
            return this;
        }

        public Criteria andFinishDtIsNotNull() {
            addCriterion("finish_dt is not null");
            return this;
        }

        public Criteria andFinishDtEqualTo(Date value) {
            addCriterion("finish_dt =", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtNotEqualTo(Date value) {
            addCriterion("finish_dt <>", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtGreaterThan(Date value) {
            addCriterion("finish_dt >", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_dt >=", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtLessThan(Date value) {
            addCriterion("finish_dt <", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtLessThanOrEqualTo(Date value) {
            addCriterion("finish_dt <=", value, "finishDt");
            return this;
        }

        public Criteria andFinishDtIn(List values) {
            addCriterion("finish_dt in", values, "finishDt");
            return this;
        }

        public Criteria andFinishDtNotIn(List values) {
            addCriterion("finish_dt not in", values, "finishDt");
            return this;
        }

        public Criteria andFinishDtBetween(Date value1, Date value2) {
            addCriterion("finish_dt between", value1, value2, "finishDt");
            return this;
        }

        public Criteria andFinishDtNotBetween(Date value1, Date value2) {
            addCriterion("finish_dt not between", value1, value2, "finishDt");
            return this;
        }
    }
}
