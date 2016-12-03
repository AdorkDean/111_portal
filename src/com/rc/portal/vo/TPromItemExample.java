package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TPromItemExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TPromItemExample() {
        oredCriteria = new ArrayList();


    }

    protected TPromItemExample(TPromItemExample example) {
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

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return this;


        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return this;


        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("target_id =", value, "targetId");
            return this;


        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("target_id <>", value, "targetId");
            return this;


        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("target_id >", value, "targetId");
            return this;


        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("target_id >=", value, "targetId");
            return this;


        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("target_id <", value, "targetId");
            return this;


        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("target_id <=", value, "targetId");
            return this;


        }

        public Criteria andTargetIdIn(List values) {
            addCriterion("target_id in", values, "targetId");
            return this;


        }

        public Criteria andTargetIdNotIn(List values) {
            addCriterion("target_id not in", values, "targetId");
            return this;


        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return this;


        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return this;


        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return this;


        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return this;


        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return this;


        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return this;


        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return this;


        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return this;


        }

        public Criteria andPriceIn(List values) {
            addCriterion("price in", values, "price");
            return this;


        }

        public Criteria andPriceNotIn(List values) {
            addCriterion("price not in", values, "price");
            return this;


        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return this;


        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return this;


        }

        public Criteria andLimitCountIsNull() {
            addCriterion("limit_count is null");
            return this;


        }

        public Criteria andLimitCountIsNotNull() {
            addCriterion("limit_count is not null");
            return this;


        }

        public Criteria andLimitCountEqualTo(Integer value) {
            addCriterion("limit_count =", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountNotEqualTo(Integer value) {
            addCriterion("limit_count <>", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountGreaterThan(Integer value) {
            addCriterion("limit_count >", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_count >=", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountLessThan(Integer value) {
            addCriterion("limit_count <", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountLessThanOrEqualTo(Integer value) {
            addCriterion("limit_count <=", value, "limitCount");
            return this;


        }

        public Criteria andLimitCountIn(List values) {
            addCriterion("limit_count in", values, "limitCount");
            return this;


        }

        public Criteria andLimitCountNotIn(List values) {
            addCriterion("limit_count not in", values, "limitCount");
            return this;


        }

        public Criteria andLimitCountBetween(Integer value1, Integer value2) {
            addCriterion("limit_count between", value1, value2, "limitCount");
            return this;


        }

        public Criteria andLimitCountNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_count not between", value1, value2, "limitCount");
            return this;


        }

        public Criteria andSaleCountIsNull() {
            addCriterion("sale_count is null");
            return this;


        }

        public Criteria andSaleCountIsNotNull() {
            addCriterion("sale_count is not null");
            return this;


        }

        public Criteria andSaleCountEqualTo(Integer value) {
            addCriterion("sale_count =", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountNotEqualTo(Integer value) {
            addCriterion("sale_count <>", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountGreaterThan(Integer value) {
            addCriterion("sale_count >", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_count >=", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountLessThan(Integer value) {
            addCriterion("sale_count <", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountLessThanOrEqualTo(Integer value) {
            addCriterion("sale_count <=", value, "saleCount");
            return this;


        }

        public Criteria andSaleCountIn(List values) {
            addCriterion("sale_count in", values, "saleCount");
            return this;


        }

        public Criteria andSaleCountNotIn(List values) {
            addCriterion("sale_count not in", values, "saleCount");
            return this;


        }

        public Criteria andSaleCountBetween(Integer value1, Integer value2) {
            addCriterion("sale_count between", value1, value2, "saleCount");
            return this;


        }

        public Criteria andSaleCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_count not between", value1, value2, "saleCount");
            return this;


        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return this;


        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return this;


        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return this;


        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return this;


        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return this;


        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return this;


        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return this;


        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return this;


        }

        public Criteria andPidIn(List values) {
            addCriterion("pid in", values, "pid");
            return this;


        }

        public Criteria andPidNotIn(List values) {
            addCriterion("pid not in", values, "pid");
            return this;


        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return this;


        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return this;


        }


    }


}
