package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsBrokerageExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsBrokerageExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsBrokerageExample(TGoodsBrokerageExample example) {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return this;


        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return this;


        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdIn(List values) {
            addCriterion("goods_id in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotIn(List values) {
            addCriterion("goods_id not in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return this;


        }

        public Criteria andBrokerageIsNull() {
            addCriterion("brokerage is null");
            return this;


        }

        public Criteria andBrokerageIsNotNull() {
            addCriterion("brokerage is not null");
            return this;


        }

        public Criteria andBrokerageEqualTo(Long value) {
            addCriterion("brokerage =", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageNotEqualTo(Long value) {
            addCriterion("brokerage <>", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageGreaterThan(Long value) {
            addCriterion("brokerage >", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageGreaterThanOrEqualTo(Long value) {
            addCriterion("brokerage >=", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageLessThan(Long value) {
            addCriterion("brokerage <", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageLessThanOrEqualTo(Long value) {
            addCriterion("brokerage <=", value, "brokerage");
            return this;


        }

        public Criteria andBrokerageIn(List values) {
            addCriterion("brokerage in", values, "brokerage");
            return this;


        }

        public Criteria andBrokerageNotIn(List values) {
            addCriterion("brokerage not in", values, "brokerage");
            return this;


        }

        public Criteria andBrokerageBetween(Long value1, Long value2) {
            addCriterion("brokerage between", value1, value2, "brokerage");
            return this;


        }

        public Criteria andBrokerageNotBetween(Long value1, Long value2) {
            addCriterion("brokerage not between", value1, value2, "brokerage");
            return this;


        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return this;


        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return this;


        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return this;


        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return this;


        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return this;


        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return this;


        }

        public Criteria andWeightIn(List values) {
            addCriterion("weight in", values, "weight");
            return this;


        }

        public Criteria andWeightNotIn(List values) {
            addCriterion("weight not in", values, "weight");
            return this;


        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return this;


        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return this;


        }

        public Criteria andRebateAmountIsNull() {
            addCriterion("rebate_amount is null");
            return this;


        }

        public Criteria andRebateAmountIsNotNull() {
            addCriterion("rebate_amount is not null");
            return this;


        }

        public Criteria andRebateAmountEqualTo(BigDecimal value) {
            addCriterion("rebate_amount =", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountNotEqualTo(BigDecimal value) {
            addCriterion("rebate_amount <>", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountGreaterThan(BigDecimal value) {
            addCriterion("rebate_amount >", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_amount >=", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountLessThan(BigDecimal value) {
            addCriterion("rebate_amount <", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_amount <=", value, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountIn(List values) {
            addCriterion("rebate_amount in", values, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountNotIn(List values) {
            addCriterion("rebate_amount not in", values, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_amount between", value1, value2, "rebateAmount");
            return this;


        }

        public Criteria andRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_amount not between", value1, value2, "rebateAmount");
            return this;


        }


    }


}
