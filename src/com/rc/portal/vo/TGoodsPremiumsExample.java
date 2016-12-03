package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsPremiumsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsPremiumsExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsPremiumsExample(TGoodsPremiumsExample example) {
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

        public Criteria andPremiumsIdIsNull() {
            addCriterion("premiums_id is null");
            return this;


        }

        public Criteria andPremiumsIdIsNotNull() {
            addCriterion("premiums_id is not null");
            return this;


        }

        public Criteria andPremiumsIdEqualTo(Long value) {
            addCriterion("premiums_id =", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdNotEqualTo(Long value) {
            addCriterion("premiums_id <>", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdGreaterThan(Long value) {
            addCriterion("premiums_id >", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("premiums_id >=", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdLessThan(Long value) {
            addCriterion("premiums_id <", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdLessThanOrEqualTo(Long value) {
            addCriterion("premiums_id <=", value, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdIn(List values) {
            addCriterion("premiums_id in", values, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdNotIn(List values) {
            addCriterion("premiums_id not in", values, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdBetween(Long value1, Long value2) {
            addCriterion("premiums_id between", value1, value2, "premiumsId");
            return this;


        }

        public Criteria andPremiumsIdNotBetween(Long value1, Long value2) {
            addCriterion("premiums_id not between", value1, value2, "premiumsId");
            return this;


        }

        public Criteria andGoodsumIsNull() {
            addCriterion("goodsum is null");
            return this;


        }

        public Criteria andGoodsumIsNotNull() {
            addCriterion("goodsum is not null");
            return this;


        }

        public Criteria andGoodsumEqualTo(Integer value) {
            addCriterion("goodsum =", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumNotEqualTo(Integer value) {
            addCriterion("goodsum <>", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumGreaterThan(Integer value) {
            addCriterion("goodsum >", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsum >=", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumLessThan(Integer value) {
            addCriterion("goodsum <", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumLessThanOrEqualTo(Integer value) {
            addCriterion("goodsum <=", value, "goodsum");
            return this;


        }

        public Criteria andGoodsumIn(List values) {
            addCriterion("goodsum in", values, "goodsum");
            return this;


        }

        public Criteria andGoodsumNotIn(List values) {
            addCriterion("goodsum not in", values, "goodsum");
            return this;


        }

        public Criteria andGoodsumBetween(Integer value1, Integer value2) {
            addCriterion("goodsum between", value1, value2, "goodsum");
            return this;


        }

        public Criteria andGoodsumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsum not between", value1, value2, "goodsum");
            return this;


        }


    }


}
