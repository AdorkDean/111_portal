package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TShortGoodsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TShortGoodsExample() {
        oredCriteria = new ArrayList();


    }

    protected TShortGoodsExample(TShortGoodsExample example) {
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

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return this;


        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return this;


        }

        public Criteria andTotalCountEqualTo(Integer value) {
            addCriterion("total_count =", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountGreaterThan(Integer value) {
            addCriterion("total_count >", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountLessThan(Integer value) {
            addCriterion("total_count <", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "totalCount");
            return this;


        }

        public Criteria andTotalCountIn(List values) {
            addCriterion("total_count in", values, "totalCount");
            return this;


        }

        public Criteria andTotalCountNotIn(List values) {
            addCriterion("total_count not in", values, "totalCount");
            return this;


        }

        public Criteria andTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return this;


        }

        public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return this;


        }

        public Criteria andShortBuyIdIsNull() {
            addCriterion("short_buy_id is null");
            return this;


        }

        public Criteria andShortBuyIdIsNotNull() {
            addCriterion("short_buy_id is not null");
            return this;


        }

        public Criteria andShortBuyIdEqualTo(Long value) {
            addCriterion("short_buy_id =", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdNotEqualTo(Long value) {
            addCriterion("short_buy_id <>", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdGreaterThan(Long value) {
            addCriterion("short_buy_id >", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("short_buy_id >=", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdLessThan(Long value) {
            addCriterion("short_buy_id <", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdLessThanOrEqualTo(Long value) {
            addCriterion("short_buy_id <=", value, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdIn(List values) {
            addCriterion("short_buy_id in", values, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdNotIn(List values) {
            addCriterion("short_buy_id not in", values, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdBetween(Long value1, Long value2) {
            addCriterion("short_buy_id between", value1, value2, "shortBuyId");
            return this;


        }

        public Criteria andShortBuyIdNotBetween(Long value1, Long value2) {
            addCriterion("short_buy_id not between", value1, value2, "shortBuyId");
            return this;


        }


    }


}
