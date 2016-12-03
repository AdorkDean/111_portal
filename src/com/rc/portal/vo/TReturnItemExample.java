package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TReturnItemExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TReturnItemExample() {
        oredCriteria = new ArrayList();


    }

    protected TReturnItemExample(TReturnItemExample example) {
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

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return this;


        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return this;


        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return this;


        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return this;


        }

        public Criteria andQuantityIn(List values) {
            addCriterion("quantity in", values, "quantity");
            return this;


        }

        public Criteria andQuantityNotIn(List values) {
            addCriterion("quantity not in", values, "quantity");
            return this;


        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return this;


        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return this;


        }

        public Criteria andProductAmountIsNull() {
            addCriterion("product_amount is null");
            return this;


        }

        public Criteria andProductAmountIsNotNull() {
            addCriterion("product_amount is not null");
            return this;


        }

        public Criteria andProductAmountEqualTo(BigDecimal value) {
            addCriterion("product_amount =", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountNotEqualTo(BigDecimal value) {
            addCriterion("product_amount <>", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountGreaterThan(BigDecimal value) {
            addCriterion("product_amount >", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount >=", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountLessThan(BigDecimal value) {
            addCriterion("product_amount <", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount <=", value, "productAmount");
            return this;


        }

        public Criteria andProductAmountIn(List values) {
            addCriterion("product_amount in", values, "productAmount");
            return this;


        }

        public Criteria andProductAmountNotIn(List values) {
            addCriterion("product_amount not in", values, "productAmount");
            return this;


        }

        public Criteria andProductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount between", value1, value2, "productAmount");
            return this;


        }

        public Criteria andProductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount not between", value1, value2, "productAmount");
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

        public Criteria andReturnIdIsNull() {
            addCriterion("return_id is null");
            return this;


        }

        public Criteria andReturnIdIsNotNull() {
            addCriterion("return_id is not null");
            return this;


        }

        public Criteria andReturnIdEqualTo(Long value) {
            addCriterion("return_id =", value, "returnId");
            return this;


        }

        public Criteria andReturnIdNotEqualTo(Long value) {
            addCriterion("return_id <>", value, "returnId");
            return this;


        }

        public Criteria andReturnIdGreaterThan(Long value) {
            addCriterion("return_id >", value, "returnId");
            return this;


        }

        public Criteria andReturnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("return_id >=", value, "returnId");
            return this;


        }

        public Criteria andReturnIdLessThan(Long value) {
            addCriterion("return_id <", value, "returnId");
            return this;


        }

        public Criteria andReturnIdLessThanOrEqualTo(Long value) {
            addCriterion("return_id <=", value, "returnId");
            return this;


        }

        public Criteria andReturnIdIn(List values) {
            addCriterion("return_id in", values, "returnId");
            return this;


        }

        public Criteria andReturnIdNotIn(List values) {
            addCriterion("return_id not in", values, "returnId");
            return this;


        }

        public Criteria andReturnIdBetween(Long value1, Long value2) {
            addCriterion("return_id between", value1, value2, "returnId");
            return this;


        }

        public Criteria andReturnIdNotBetween(Long value1, Long value2) {
            addCriterion("return_id not between", value1, value2, "returnId");
            return this;


        }


    }


}
