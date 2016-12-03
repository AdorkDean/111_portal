package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TOrderExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TOrderExample() {
        oredCriteria = new ArrayList();


    }

    protected TOrderExample(TOrderExample example) {
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

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return this;


        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return this;


        }

        public Criteria andOrderSourceEqualTo(Integer value) {
            addCriterion("order_source =", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceNotEqualTo(Integer value) {
            addCriterion("order_source <>", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceGreaterThan(Integer value) {
            addCriterion("order_source >", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_source >=", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceLessThan(Integer value) {
            addCriterion("order_source <", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceLessThanOrEqualTo(Integer value) {
            addCriterion("order_source <=", value, "orderSource");
            return this;


        }

        public Criteria andOrderSourceIn(List values) {
            addCriterion("order_source in", values, "orderSource");
            return this;


        }

        public Criteria andOrderSourceNotIn(List values) {
            addCriterion("order_source not in", values, "orderSource");
            return this;


        }

        public Criteria andOrderSourceBetween(Integer value1, Integer value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return this;


        }

        public Criteria andOrderSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
            return this;


        }

        public Criteria andShippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return this;


        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return this;


        }

        public Criteria andShippingFeeEqualTo(BigDecimal value) {
            addCriterion("shipping_fee =", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeNotEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <>", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeGreaterThan(BigDecimal value) {
            addCriterion("shipping_fee >", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee >=", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeLessThan(BigDecimal value) {
            addCriterion("shipping_fee <", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <=", value, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeIn(List values) {
            addCriterion("shipping_fee in", values, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeNotIn(List values) {
            addCriterion("shipping_fee not in", values, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee between", value1, value2, "shippingFee");
            return this;


        }

        public Criteria andShippingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee not between", value1, value2, "shippingFee");
            return this;


        }

        public Criteria andPromotionalDiscountIsNull() {
            addCriterion("promotional_discount is null");
            return this;


        }

        public Criteria andPromotionalDiscountIsNotNull() {
            addCriterion("promotional_discount is not null");
            return this;


        }

        public Criteria andPromotionalDiscountEqualTo(BigDecimal value) {
            addCriterion("promotional_discount =", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotEqualTo(BigDecimal value) {
            addCriterion("promotional_discount <>", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountGreaterThan(BigDecimal value) {
            addCriterion("promotional_discount >", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_discount >=", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountLessThan(BigDecimal value) {
            addCriterion("promotional_discount <", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_discount <=", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountIn(List values) {
            addCriterion("promotional_discount in", values, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotIn(List values) {
            addCriterion("promotional_discount not in", values, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_discount between", value1, value2, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_discount not between", value1, value2, "promotionalDiscount");
            return this;


        }

        public Criteria andCouponDiscountIsNull() {
            addCriterion("coupon_discount is null");
            return this;


        }

        public Criteria andCouponDiscountIsNotNull() {
            addCriterion("coupon_discount is not null");
            return this;


        }

        public Criteria andCouponDiscountEqualTo(BigDecimal value) {
            addCriterion("coupon_discount =", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_discount <>", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountGreaterThan(BigDecimal value) {
            addCriterion("coupon_discount >", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_discount >=", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountLessThan(BigDecimal value) {
            addCriterion("coupon_discount <", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_discount <=", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountIn(List values) {
            addCriterion("coupon_discount in", values, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotIn(List values) {
            addCriterion("coupon_discount not in", values, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_discount between", value1, value2, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_discount not between", value1, value2, "couponDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountIsNull() {
            addCriterion("integration_discount is null");
            return this;


        }

        public Criteria andIntegrationDiscountIsNotNull() {
            addCriterion("integration_discount is not null");
            return this;


        }

        public Criteria andIntegrationDiscountEqualTo(BigDecimal value) {
            addCriterion("integration_discount =", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotEqualTo(BigDecimal value) {
            addCriterion("integration_discount <>", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountGreaterThan(BigDecimal value) {
            addCriterion("integration_discount >", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_discount >=", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountLessThan(BigDecimal value) {
            addCriterion("integration_discount <", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_discount <=", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountIn(List values) {
            addCriterion("integration_discount in", values, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotIn(List values) {
            addCriterion("integration_discount not in", values, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_discount between", value1, value2, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_discount not between", value1, value2, "integrationDiscount");
            return this;


        }

        public Criteria andUseIntegrationIsNull() {
            addCriterion("use_integration is null");
            return this;


        }

        public Criteria andUseIntegrationIsNotNull() {
            addCriterion("use_integration is not null");
            return this;


        }

        public Criteria andUseIntegrationEqualTo(Integer value) {
            addCriterion("use_integration =", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotEqualTo(Integer value) {
            addCriterion("use_integration <>", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationGreaterThan(Integer value) {
            addCriterion("use_integration >", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_integration >=", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationLessThan(Integer value) {
            addCriterion("use_integration <", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("use_integration <=", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationIn(List values) {
            addCriterion("use_integration in", values, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotIn(List values) {
            addCriterion("use_integration not in", values, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("use_integration between", value1, value2, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("use_integration not between", value1, value2, "useIntegration");
            return this;


        }

        public Criteria andAdjustAmountIsNull() {
            addCriterion("adjust_amount is null");
            return this;


        }

        public Criteria andAdjustAmountIsNotNull() {
            addCriterion("adjust_amount is not null");
            return this;


        }

        public Criteria andAdjustAmountEqualTo(BigDecimal value) {
            addCriterion("adjust_amount =", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotEqualTo(BigDecimal value) {
            addCriterion("adjust_amount <>", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountGreaterThan(BigDecimal value) {
            addCriterion("adjust_amount >", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_amount >=", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountLessThan(BigDecimal value) {
            addCriterion("adjust_amount <", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_amount <=", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountIn(List values) {
            addCriterion("adjust_amount in", values, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotIn(List values) {
            addCriterion("adjust_amount not in", values, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_amount between", value1, value2, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_amount not between", value1, value2, "adjustAmount");
            return this;


        }

        public Criteria andPaidAmountIsNull() {
            addCriterion("paid_amount is null");
            return this;


        }

        public Criteria andPaidAmountIsNotNull() {
            addCriterion("paid_amount is not null");
            return this;


        }

        public Criteria andPaidAmountEqualTo(BigDecimal value) {
            addCriterion("paid_amount =", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountNotEqualTo(BigDecimal value) {
            addCriterion("paid_amount <>", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountGreaterThan(BigDecimal value) {
            addCriterion("paid_amount >", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amount >=", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountLessThan(BigDecimal value) {
            addCriterion("paid_amount <", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amount <=", value, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountIn(List values) {
            addCriterion("paid_amount in", values, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountNotIn(List values) {
            addCriterion("paid_amount not in", values, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amount between", value1, value2, "paidAmount");
            return this;


        }

        public Criteria andPaidAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amount not between", value1, value2, "paidAmount");
            return this;


        }

        public Criteria andRewardIntegrationIsNull() {
            addCriterion("reward_integration is null");
            return this;


        }

        public Criteria andRewardIntegrationIsNotNull() {
            addCriterion("reward_integration is not null");
            return this;


        }

        public Criteria andRewardIntegrationEqualTo(Integer value) {
            addCriterion("reward_integration =", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationNotEqualTo(Integer value) {
            addCriterion("reward_integration <>", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationGreaterThan(Integer value) {
            addCriterion("reward_integration >", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_integration >=", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationLessThan(Integer value) {
            addCriterion("reward_integration <", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("reward_integration <=", value, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationIn(List values) {
            addCriterion("reward_integration in", values, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationNotIn(List values) {
            addCriterion("reward_integration not in", values, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("reward_integration between", value1, value2, "rewardIntegration");
            return this;


        }

        public Criteria andRewardIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_integration not between", value1, value2, "rewardIntegration");
            return this;


        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return this;


        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return this;


        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return this;


        }

        public Criteria andReceiverIn(List values) {
            addCriterion("receiver in", values, "receiver");
            return this;


        }

        public Criteria andReceiverNotIn(List values) {
            addCriterion("receiver not in", values, "receiver");
            return this;


        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return this;


        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return this;


        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return this;


        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return this;


        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return this;


        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdIn(List values) {
            addCriterion("area_id in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdNotIn(List values) {
            addCriterion("area_id not in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return this;


        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return this;


        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return this;


        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return this;


        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return this;


        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return this;


        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return this;


        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return this;


        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return this;


        }

        public Criteria andAreaNameIn(List values) {
            addCriterion("area_name in", values, "areaName");
            return this;


        }

        public Criteria andAreaNameNotIn(List values) {
            addCriterion("area_name not in", values, "areaName");
            return this;


        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return this;


        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return this;


        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return this;


        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return this;


        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressIn(List values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotIn(List values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return this;


        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return this;


        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return this;


        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeIn(List values) {
            addCriterion("zip_code in", values, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotIn(List values) {
            addCriterion("zip_code not in", values, "zipCode");
            return this;


        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return this;


        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return this;


        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return this;


        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return this;


        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return this;


        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return this;


        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return this;


        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return this;


        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return this;


        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return this;


        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return this;


        }

        public Criteria andPhoneIn(List values) {
            addCriterion("phone in", values, "phone");
            return this;


        }

        public Criteria andPhoneNotIn(List values) {
            addCriterion("phone not in", values, "phone");
            return this;


        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return this;


        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return this;


        }

        public Criteria andIfInvoiceIsNull() {
            addCriterion("if_invoice is null");
            return this;


        }

        public Criteria andIfInvoiceIsNotNull() {
            addCriterion("if_invoice is not null");
            return this;


        }

        public Criteria andIfInvoiceEqualTo(Integer value) {
            addCriterion("if_invoice =", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceNotEqualTo(Integer value) {
            addCriterion("if_invoice <>", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceGreaterThan(Integer value) {
            addCriterion("if_invoice >", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_invoice >=", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceLessThan(Integer value) {
            addCriterion("if_invoice <", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceLessThanOrEqualTo(Integer value) {
            addCriterion("if_invoice <=", value, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceIn(List values) {
            addCriterion("if_invoice in", values, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceNotIn(List values) {
            addCriterion("if_invoice not in", values, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceBetween(Integer value1, Integer value2) {
            addCriterion("if_invoice between", value1, value2, "ifInvoice");
            return this;


        }

        public Criteria andIfInvoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("if_invoice not between", value1, value2, "ifInvoice");
            return this;


        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return this;


        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return this;


        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleIn(List values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleNotIn(List values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return this;


        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return this;


        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return this;


        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return this;


        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("tax =", value, "tax");
            return this;


        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("tax <>", value, "tax");
            return this;


        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("tax >", value, "tax");
            return this;


        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax >=", value, "tax");
            return this;


        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("tax <", value, "tax");
            return this;


        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax <=", value, "tax");
            return this;


        }

        public Criteria andTaxIn(List values) {
            addCriterion("tax in", values, "tax");
            return this;


        }

        public Criteria andTaxNotIn(List values) {
            addCriterion("tax not in", values, "tax");
            return this;


        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax between", value1, value2, "tax");
            return this;


        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax not between", value1, value2, "tax");
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

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return this;


        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return this;


        }

        public Criteria andPaymentIdEqualTo(Long value) {
            addCriterion("payment_id =", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdNotEqualTo(Long value) {
            addCriterion("payment_id <>", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdGreaterThan(Long value) {
            addCriterion("payment_id >", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_id >=", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdLessThan(Long value) {
            addCriterion("payment_id <", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("payment_id <=", value, "paymentId");
            return this;


        }

        public Criteria andPaymentIdIn(List values) {
            addCriterion("payment_id in", values, "paymentId");
            return this;


        }

        public Criteria andPaymentIdNotIn(List values) {
            addCriterion("payment_id not in", values, "paymentId");
            return this;


        }

        public Criteria andPaymentIdBetween(Long value1, Long value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return this;


        }

        public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return this;


        }

        public Criteria andDeliveryIdIsNull() {
            addCriterion("delivery_id is null");
            return this;


        }

        public Criteria andDeliveryIdIsNotNull() {
            addCriterion("delivery_id is not null");
            return this;


        }

        public Criteria andDeliveryIdEqualTo(Long value) {
            addCriterion("delivery_id =", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdNotEqualTo(Long value) {
            addCriterion("delivery_id <>", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdGreaterThan(Long value) {
            addCriterion("delivery_id >", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("delivery_id >=", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdLessThan(Long value) {
            addCriterion("delivery_id <", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdLessThanOrEqualTo(Long value) {
            addCriterion("delivery_id <=", value, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdIn(List values) {
            addCriterion("delivery_id in", values, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdNotIn(List values) {
            addCriterion("delivery_id not in", values, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdBetween(Long value1, Long value2) {
            addCriterion("delivery_id between", value1, value2, "deliveryId");
            return this;


        }

        public Criteria andDeliveryIdNotBetween(Long value1, Long value2) {
            addCriterion("delivery_id not between", value1, value2, "deliveryId");
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

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return this;


        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return this;


        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return this;


        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return this;


        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return this;


        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return this;


        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return this;


        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return this;


        }

        public Criteria andCouponIdIn(List values) {
            addCriterion("coupon_id in", values, "couponId");
            return this;


        }

        public Criteria andCouponIdNotIn(List values) {
            addCriterion("coupon_id not in", values, "couponId");
            return this;


        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return this;


        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return this;


        }

        public Criteria andIsPushIsNull() {
            addCriterion("is_push is null");
            return this;


        }

        public Criteria andIsPushIsNotNull() {
            addCriterion("is_push is not null");
            return this;


        }

        public Criteria andIsPushEqualTo(Integer value) {
            addCriterion("is_push =", value, "isPush");
            return this;


        }

        public Criteria andIsPushNotEqualTo(Integer value) {
            addCriterion("is_push <>", value, "isPush");
            return this;


        }

        public Criteria andIsPushGreaterThan(Integer value) {
            addCriterion("is_push >", value, "isPush");
            return this;


        }

        public Criteria andIsPushGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_push >=", value, "isPush");
            return this;


        }

        public Criteria andIsPushLessThan(Integer value) {
            addCriterion("is_push <", value, "isPush");
            return this;


        }

        public Criteria andIsPushLessThanOrEqualTo(Integer value) {
            addCriterion("is_push <=", value, "isPush");
            return this;


        }

        public Criteria andIsPushIn(List values) {
            addCriterion("is_push in", values, "isPush");
            return this;


        }

        public Criteria andIsPushNotIn(List values) {
            addCriterion("is_push not in", values, "isPush");
            return this;


        }

        public Criteria andIsPushBetween(Integer value1, Integer value2) {
            addCriterion("is_push between", value1, value2, "isPush");
            return this;


        }

        public Criteria andIsPushNotBetween(Integer value1, Integer value2) {
            addCriterion("is_push not between", value1, value2, "isPush");
            return this;


        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return this;


        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return this;


        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return this;


        }

        public Criteria andPushTimeIn(List values) {
            addCriterion("push_time in", values, "pushTime");
            return this;


        }

        public Criteria andPushTimeNotIn(List values) {
            addCriterion("push_time not in", values, "pushTime");
            return this;


        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return this;


        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return this;


        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return this;


        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return this;


        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusIn(List values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusNotIn(List values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return this;


        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
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

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return this;


        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return this;


        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountIn(List values) {
            addCriterion("order_amount in", values, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotIn(List values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return this;


        }

        public Criteria andPayableAmountIsNull() {
            addCriterion("payable_amount is null");
            return this;


        }

        public Criteria andPayableAmountIsNotNull() {
            addCriterion("payable_amount is not null");
            return this;


        }

        public Criteria andPayableAmountEqualTo(BigDecimal value) {
            addCriterion("payable_amount =", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountNotEqualTo(BigDecimal value) {
            addCriterion("payable_amount <>", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountGreaterThan(BigDecimal value) {
            addCriterion("payable_amount >", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payable_amount >=", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountLessThan(BigDecimal value) {
            addCriterion("payable_amount <", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payable_amount <=", value, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountIn(List values) {
            addCriterion("payable_amount in", values, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountNotIn(List values) {
            addCriterion("payable_amount not in", values, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payable_amount between", value1, value2, "payableAmount");
            return this;


        }

        public Criteria andPayableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payable_amount not between", value1, value2, "payableAmount");
            return this;


        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return this;


        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return this;


        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeIn(List values) {
            addCriterion("order_type in", values, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotIn(List values) {
            addCriterion("order_type not in", values, "orderType");
            return this;


        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return this;


        }

        public Criteria andReturnTypeIsNull() {
            addCriterion("return_type is null");
            return this;


        }

        public Criteria andReturnTypeIsNotNull() {
            addCriterion("return_type is not null");
            return this;


        }

        public Criteria andReturnTypeEqualTo(Integer value) {
            addCriterion("return_type =", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeNotEqualTo(Integer value) {
            addCriterion("return_type <>", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeGreaterThan(Integer value) {
            addCriterion("return_type >", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_type >=", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeLessThan(Integer value) {
            addCriterion("return_type <", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeLessThanOrEqualTo(Integer value) {
            addCriterion("return_type <=", value, "returnType");
            return this;


        }

        public Criteria andReturnTypeIn(List values) {
            addCriterion("return_type in", values, "returnType");
            return this;


        }

        public Criteria andReturnTypeNotIn(List values) {
            addCriterion("return_type not in", values, "returnType");
            return this;


        }

        public Criteria andReturnTypeBetween(Integer value1, Integer value2) {
            addCriterion("return_type between", value1, value2, "returnType");
            return this;


        }

        public Criteria andReturnTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("return_type not between", value1, value2, "returnType");
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

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return this;


        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return this;


        }

        public Criteria andVerifyStatusEqualTo(Integer value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusNotEqualTo(Integer value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusGreaterThan(Integer value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusLessThan(Integer value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusIn(List values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusNotIn(List values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return this;


        }

        public Criteria andVerifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
            return this;


        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return this;


        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return this;


        }

        public Criteria andInvoiceTypeEqualTo(Integer value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeNotEqualTo(Integer value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeGreaterThan(Integer value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeLessThan(Integer value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeIn(List values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeNotIn(List values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return this;


        }

        public Criteria andInvoiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return this;


        }

        public Criteria andFinishDateIsNull() {
            addCriterion("finish_date is null");
            return this;


        }

        public Criteria andFinishDateIsNotNull() {
            addCriterion("finish_date is not null");
            return this;


        }

        public Criteria andFinishDateEqualTo(Date value) {
            addCriterion("finish_date =", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateNotEqualTo(Date value) {
            addCriterion("finish_date <>", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateGreaterThan(Date value) {
            addCriterion("finish_date >", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_date >=", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateLessThan(Date value) {
            addCriterion("finish_date <", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateLessThanOrEqualTo(Date value) {
            addCriterion("finish_date <=", value, "finishDate");
            return this;


        }

        public Criteria andFinishDateIn(List values) {
            addCriterion("finish_date in", values, "finishDate");
            return this;


        }

        public Criteria andFinishDateNotIn(List values) {
            addCriterion("finish_date not in", values, "finishDate");
            return this;


        }

        public Criteria andFinishDateBetween(Date value1, Date value2) {
            addCriterion("finish_date between", value1, value2, "finishDate");
            return this;


        }

        public Criteria andFinishDateNotBetween(Date value1, Date value2) {
            addCriterion("finish_date not between", value1, value2, "finishDate");
            return this;


        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return this;


        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return this;


        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return this;


        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return this;


        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return this;


        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return this;


        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return this;


        }

        public Criteria andLongitudeIn(List values) {
            addCriterion("longitude in", values, "longitude");
            return this;


        }

        public Criteria andLongitudeNotIn(List values) {
            addCriterion("longitude not in", values, "longitude");
            return this;


        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return this;


        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return this;


        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return this;


        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return this;


        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return this;


        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return this;


        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return this;


        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return this;


        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return this;


        }

        public Criteria andLatitudeIn(List values) {
            addCriterion("latitude in", values, "latitude");
            return this;


        }

        public Criteria andLatitudeNotIn(List values) {
            addCriterion("latitude not in", values, "latitude");
            return this;


        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return this;


        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return this;


        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return this;


        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return this;


        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("store_id =", value, "storeId");
            return this;


        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("store_id <>", value, "storeId");
            return this;


        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("store_id >", value, "storeId");
            return this;


        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("store_id >=", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("store_id <", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("store_id <=", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("store_id like", value, "storeId");
            return this;


        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("store_id not like", value, "storeId");
            return this;


        }

        public Criteria andStoreIdIn(List values) {
            addCriterion("store_id in", values, "storeId");
            return this;


        }

        public Criteria andStoreIdNotIn(List values) {
            addCriterion("store_id not in", values, "storeId");
            return this;


        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return this;


        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return this;


        }


    }


}
