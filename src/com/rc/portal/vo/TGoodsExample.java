package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsExample(TGoodsExample example) {
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

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return this;


        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return this;


        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return this;


        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return this;


        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return this;


        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return this;


        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return this;


        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return this;


        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return this;


        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return this;


        }

        public Criteria andShortNameIn(List values) {
            addCriterion("short_name in", values, "shortName");
            return this;


        }

        public Criteria andShortNameNotIn(List values) {
            addCriterion("short_name not in", values, "shortName");
            return this;


        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return this;


        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return this;


        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return this;


        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return this;


        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return this;


        }

        public Criteria andGoodsNameIn(List values) {
            addCriterion("goods_name in", values, "goodsName");
            return this;


        }

        public Criteria andGoodsNameNotIn(List values) {
            addCriterion("goods_name not in", values, "goodsName");
            return this;


        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return this;


        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return this;


        }

        public Criteria andMainTitleIsNull() {
            addCriterion("main_title is null");
            return this;


        }

        public Criteria andMainTitleIsNotNull() {
            addCriterion("main_title is not null");
            return this;


        }

        public Criteria andMainTitleEqualTo(String value) {
            addCriterion("main_title =", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleNotEqualTo(String value) {
            addCriterion("main_title <>", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleGreaterThan(String value) {
            addCriterion("main_title >", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("main_title >=", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleLessThan(String value) {
            addCriterion("main_title <", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleLessThanOrEqualTo(String value) {
            addCriterion("main_title <=", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleLike(String value) {
            addCriterion("main_title like", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleNotLike(String value) {
            addCriterion("main_title not like", value, "mainTitle");
            return this;


        }

        public Criteria andMainTitleIn(List values) {
            addCriterion("main_title in", values, "mainTitle");
            return this;


        }

        public Criteria andMainTitleNotIn(List values) {
            addCriterion("main_title not in", values, "mainTitle");
            return this;


        }

        public Criteria andMainTitleBetween(String value1, String value2) {
            addCriterion("main_title between", value1, value2, "mainTitle");
            return this;


        }

        public Criteria andMainTitleNotBetween(String value1, String value2) {
            addCriterion("main_title not between", value1, value2, "mainTitle");
            return this;


        }

        public Criteria andSubTitleIsNull() {
            addCriterion("sub_title is null");
            return this;


        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("sub_title is not null");
            return this;


        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("sub_title =", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("sub_title <>", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("sub_title >", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_title >=", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("sub_title <", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("sub_title <=", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("sub_title like", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("sub_title not like", value, "subTitle");
            return this;


        }

        public Criteria andSubTitleIn(List values) {
            addCriterion("sub_title in", values, "subTitle");
            return this;


        }

        public Criteria andSubTitleNotIn(List values) {
            addCriterion("sub_title not in", values, "subTitle");
            return this;


        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("sub_title between", value1, value2, "subTitle");
            return this;


        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("sub_title not between", value1, value2, "subTitle");
            return this;


        }

        public Criteria andGenericNameIsNull() {
            addCriterion("generic_name is null");
            return this;


        }

        public Criteria andGenericNameIsNotNull() {
            addCriterion("generic_name is not null");
            return this;


        }

        public Criteria andGenericNameEqualTo(String value) {
            addCriterion("generic_name =", value, "genericName");
            return this;


        }

        public Criteria andGenericNameNotEqualTo(String value) {
            addCriterion("generic_name <>", value, "genericName");
            return this;


        }

        public Criteria andGenericNameGreaterThan(String value) {
            addCriterion("generic_name >", value, "genericName");
            return this;


        }

        public Criteria andGenericNameGreaterThanOrEqualTo(String value) {
            addCriterion("generic_name >=", value, "genericName");
            return this;


        }

        public Criteria andGenericNameLessThan(String value) {
            addCriterion("generic_name <", value, "genericName");
            return this;


        }

        public Criteria andGenericNameLessThanOrEqualTo(String value) {
            addCriterion("generic_name <=", value, "genericName");
            return this;


        }

        public Criteria andGenericNameLike(String value) {
            addCriterion("generic_name like", value, "genericName");
            return this;


        }

        public Criteria andGenericNameNotLike(String value) {
            addCriterion("generic_name not like", value, "genericName");
            return this;


        }

        public Criteria andGenericNameIn(List values) {
            addCriterion("generic_name in", values, "genericName");
            return this;


        }

        public Criteria andGenericNameNotIn(List values) {
            addCriterion("generic_name not in", values, "genericName");
            return this;


        }

        public Criteria andGenericNameBetween(String value1, String value2) {
            addCriterion("generic_name between", value1, value2, "genericName");
            return this;


        }

        public Criteria andGenericNameNotBetween(String value1, String value2) {
            addCriterion("generic_name not between", value1, value2, "genericName");
            return this;


        }

        public Criteria andSkuIdIsNull() {
            addCriterion("SKU_ID is null");
            return this;


        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("SKU_ID is not null");
            return this;


        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("SKU_ID =", value, "skuId");
            return this;


        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("SKU_ID <>", value, "skuId");
            return this;


        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("SKU_ID >", value, "skuId");
            return this;


        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("SKU_ID >=", value, "skuId");
            return this;


        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("SKU_ID <", value, "skuId");
            return this;


        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("SKU_ID <=", value, "skuId");
            return this;


        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("SKU_ID like", value, "skuId");
            return this;


        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("SKU_ID not like", value, "skuId");
            return this;


        }

        public Criteria andSkuIdIn(List values) {
            addCriterion("SKU_ID in", values, "skuId");
            return this;


        }

        public Criteria andSkuIdNotIn(List values) {
            addCriterion("SKU_ID not in", values, "skuId");
            return this;


        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("SKU_ID between", value1, value2, "skuId");
            return this;


        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("SKU_ID not between", value1, value2, "skuId");
            return this;


        }

        public Criteria andGoodsnoIsNull() {
            addCriterion("goodsno is null");
            return this;


        }

        public Criteria andGoodsnoIsNotNull() {
            addCriterion("goodsno is not null");
            return this;


        }

        public Criteria andGoodsnoEqualTo(String value) {
            addCriterion("goodsno =", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoNotEqualTo(String value) {
            addCriterion("goodsno <>", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoGreaterThan(String value) {
            addCriterion("goodsno >", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoGreaterThanOrEqualTo(String value) {
            addCriterion("goodsno >=", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoLessThan(String value) {
            addCriterion("goodsno <", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoLessThanOrEqualTo(String value) {
            addCriterion("goodsno <=", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoLike(String value) {
            addCriterion("goodsno like", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoNotLike(String value) {
            addCriterion("goodsno not like", value, "goodsno");
            return this;


        }

        public Criteria andGoodsnoIn(List values) {
            addCriterion("goodsno in", values, "goodsno");
            return this;


        }

        public Criteria andGoodsnoNotIn(List values) {
            addCriterion("goodsno not in", values, "goodsno");
            return this;


        }

        public Criteria andGoodsnoBetween(String value1, String value2) {
            addCriterion("goodsno between", value1, value2, "goodsno");
            return this;


        }

        public Criteria andGoodsnoNotBetween(String value1, String value2) {
            addCriterion("goodsno not between", value1, value2, "goodsno");
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

        public Criteria andCostPriceIsNull() {
            addCriterion("cost_price is null");
            return this;


        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("cost_price is not null");
            return this;


        }

        public Criteria andCostPriceEqualTo(BigDecimal value) {
            addCriterion("cost_price =", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("cost_price <>", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceGreaterThan(BigDecimal value) {
            addCriterion("cost_price >", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price >=", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceLessThan(BigDecimal value) {
            addCriterion("cost_price <", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price <=", value, "costPrice");
            return this;


        }

        public Criteria andCostPriceIn(List values) {
            addCriterion("cost_price in", values, "costPrice");
            return this;


        }

        public Criteria andCostPriceNotIn(List values) {
            addCriterion("cost_price not in", values, "costPrice");
            return this;


        }

        public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price between", value1, value2, "costPrice");
            return this;


        }

        public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price not between", value1, value2, "costPrice");
            return this;


        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return this;


        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return this;


        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return this;


        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return this;


        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return this;


        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return this;


        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return this;


        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return this;


        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return this;


        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return this;


        }

        public Criteria andUnitIn(List values) {
            addCriterion("unit in", values, "unit");
            return this;


        }

        public Criteria andUnitNotIn(List values) {
            addCriterion("unit not in", values, "unit");
            return this;


        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return this;


        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return this;


        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return this;


        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return this;


        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
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

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return this;


        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return this;


        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return this;


        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return this;


        }

        public Criteria andStockEqualTo(Long value) {
            addCriterion("stock =", value, "stock");
            return this;


        }

        public Criteria andStockNotEqualTo(Long value) {
            addCriterion("stock <>", value, "stock");
            return this;


        }

        public Criteria andStockGreaterThan(Long value) {
            addCriterion("stock >", value, "stock");
            return this;


        }

        public Criteria andStockGreaterThanOrEqualTo(Long value) {
            addCriterion("stock >=", value, "stock");
            return this;


        }

        public Criteria andStockLessThan(Long value) {
            addCriterion("stock <", value, "stock");
            return this;


        }

        public Criteria andStockLessThanOrEqualTo(Long value) {
            addCriterion("stock <=", value, "stock");
            return this;


        }

        public Criteria andStockIn(List values) {
            addCriterion("stock in", values, "stock");
            return this;


        }

        public Criteria andStockNotIn(List values) {
            addCriterion("stock not in", values, "stock");
            return this;


        }

        public Criteria andStockBetween(Long value1, Long value2) {
            addCriterion("stock between", value1, value2, "stock");
            return this;


        }

        public Criteria andStockNotBetween(Long value1, Long value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return this;


        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return this;


        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return this;


        }

        public Criteria andIntegralEqualTo(Long value) {
            addCriterion("integral =", value, "integral");
            return this;


        }

        public Criteria andIntegralNotEqualTo(Long value) {
            addCriterion("integral <>", value, "integral");
            return this;


        }

        public Criteria andIntegralGreaterThan(Long value) {
            addCriterion("integral >", value, "integral");
            return this;


        }

        public Criteria andIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("integral >=", value, "integral");
            return this;


        }

        public Criteria andIntegralLessThan(Long value) {
            addCriterion("integral <", value, "integral");
            return this;


        }

        public Criteria andIntegralLessThanOrEqualTo(Long value) {
            addCriterion("integral <=", value, "integral");
            return this;


        }

        public Criteria andIntegralIn(List values) {
            addCriterion("integral in", values, "integral");
            return this;


        }

        public Criteria andIntegralNotIn(List values) {
            addCriterion("integral not in", values, "integral");
            return this;


        }

        public Criteria andIntegralBetween(Long value1, Long value2) {
            addCriterion("integral between", value1, value2, "integral");
            return this;


        }

        public Criteria andIntegralNotBetween(Long value1, Long value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return this;


        }

        public Criteria andIsReleaseIsNull() {
            addCriterion("is_release is null");
            return this;


        }

        public Criteria andIsReleaseIsNotNull() {
            addCriterion("is_release is not null");
            return this;


        }

        public Criteria andIsReleaseEqualTo(Integer value) {
            addCriterion("is_release =", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseNotEqualTo(Integer value) {
            addCriterion("is_release <>", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseGreaterThan(Integer value) {
            addCriterion("is_release >", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_release >=", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseLessThan(Integer value) {
            addCriterion("is_release <", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("is_release <=", value, "isRelease");
            return this;


        }

        public Criteria andIsReleaseIn(List values) {
            addCriterion("is_release in", values, "isRelease");
            return this;


        }

        public Criteria andIsReleaseNotIn(List values) {
            addCriterion("is_release not in", values, "isRelease");
            return this;


        }

        public Criteria andIsReleaseBetween(Integer value1, Integer value2) {
            addCriterion("is_release between", value1, value2, "isRelease");
            return this;


        }

        public Criteria andIsReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_release not between", value1, value2, "isRelease");
            return this;


        }

        public Criteria andIsSuitIsNull() {
            addCriterion("is_suit is null");
            return this;


        }

        public Criteria andIsSuitIsNotNull() {
            addCriterion("is_suit is not null");
            return this;


        }

        public Criteria andIsSuitEqualTo(Integer value) {
            addCriterion("is_suit =", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitNotEqualTo(Integer value) {
            addCriterion("is_suit <>", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitGreaterThan(Integer value) {
            addCriterion("is_suit >", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_suit >=", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitLessThan(Integer value) {
            addCriterion("is_suit <", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitLessThanOrEqualTo(Integer value) {
            addCriterion("is_suit <=", value, "isSuit");
            return this;


        }

        public Criteria andIsSuitIn(List values) {
            addCriterion("is_suit in", values, "isSuit");
            return this;


        }

        public Criteria andIsSuitNotIn(List values) {
            addCriterion("is_suit not in", values, "isSuit");
            return this;


        }

        public Criteria andIsSuitBetween(Integer value1, Integer value2) {
            addCriterion("is_suit between", value1, value2, "isSuit");
            return this;


        }

        public Criteria andIsSuitNotBetween(Integer value1, Integer value2) {
            addCriterion("is_suit not between", value1, value2, "isSuit");
            return this;


        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return this;


        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return this;


        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return this;


        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return this;


        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return this;


        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return this;


        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return this;


        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return this;


        }

        public Criteria andTypeIn(List values) {
            addCriterion("type in", values, "type");
            return this;


        }

        public Criteria andTypeNotIn(List values) {
            addCriterion("type not in", values, "type");
            return this;


        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return this;


        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return this;


        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return this;


        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return this;


        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return this;


        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return this;


        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return this;


        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return this;


        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return this;


        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return this;


        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return this;


        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return this;


        }

        public Criteria andSpecIn(List values) {
            addCriterion("spec in", values, "spec");
            return this;


        }

        public Criteria andSpecNotIn(List values) {
            addCriterion("spec not in", values, "spec");
            return this;


        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return this;


        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return this;


        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approval_number is null");
            return this;


        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approval_number is not null");
            return this;


        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approval_number =", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approval_number <>", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approval_number >", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approval_number >=", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approval_number <", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approval_number <=", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approval_number like", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approval_number not like", value, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberIn(List values) {
            addCriterion("approval_number in", values, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberNotIn(List values) {
            addCriterion("approval_number not in", values, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approval_number between", value1, value2, "approvalNumber");
            return this;


        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approval_number not between", value1, value2, "approvalNumber");
            return this;


        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return this;


        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return this;


        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return this;


        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return this;


        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return this;


        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return this;


        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return this;


        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return this;


        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return this;


        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return this;


        }

        public Criteria andBarCodeIn(List values) {
            addCriterion("bar_code in", values, "barCode");
            return this;


        }

        public Criteria andBarCodeNotIn(List values) {
            addCriterion("bar_code not in", values, "barCode");
            return this;


        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return this;


        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return this;


        }

        public Criteria andManufacturerIdIsNull() {
            addCriterion("manufacturer_id is null");
            return this;


        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("manufacturer_id is not null");
            return this;


        }

        public Criteria andManufacturerIdEqualTo(Long value) {
            addCriterion("manufacturer_id =", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdNotEqualTo(Long value) {
            addCriterion("manufacturer_id <>", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdGreaterThan(Long value) {
            addCriterion("manufacturer_id >", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("manufacturer_id >=", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdLessThan(Long value) {
            addCriterion("manufacturer_id <", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdLessThanOrEqualTo(Long value) {
            addCriterion("manufacturer_id <=", value, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdIn(List values) {
            addCriterion("manufacturer_id in", values, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdNotIn(List values) {
            addCriterion("manufacturer_id not in", values, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdBetween(Long value1, Long value2) {
            addCriterion("manufacturer_id between", value1, value2, "manufacturerId");
            return this;


        }

        public Criteria andManufacturerIdNotBetween(Long value1, Long value2) {
            addCriterion("manufacturer_id not between", value1, value2, "manufacturerId");
            return this;


        }

        public Criteria andDoseIdIsNull() {
            addCriterion("dose_id is null");
            return this;


        }

        public Criteria andDoseIdIsNotNull() {
            addCriterion("dose_id is not null");
            return this;


        }

        public Criteria andDoseIdEqualTo(Long value) {
            addCriterion("dose_id =", value, "doseId");
            return this;


        }

        public Criteria andDoseIdNotEqualTo(Long value) {
            addCriterion("dose_id <>", value, "doseId");
            return this;


        }

        public Criteria andDoseIdGreaterThan(Long value) {
            addCriterion("dose_id >", value, "doseId");
            return this;


        }

        public Criteria andDoseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dose_id >=", value, "doseId");
            return this;


        }

        public Criteria andDoseIdLessThan(Long value) {
            addCriterion("dose_id <", value, "doseId");
            return this;


        }

        public Criteria andDoseIdLessThanOrEqualTo(Long value) {
            addCriterion("dose_id <=", value, "doseId");
            return this;


        }

        public Criteria andDoseIdIn(List values) {
            addCriterion("dose_id in", values, "doseId");
            return this;


        }

        public Criteria andDoseIdNotIn(List values) {
            addCriterion("dose_id not in", values, "doseId");
            return this;


        }

        public Criteria andDoseIdBetween(Long value1, Long value2) {
            addCriterion("dose_id between", value1, value2, "doseId");
            return this;


        }

        public Criteria andDoseIdNotBetween(Long value1, Long value2) {
            addCriterion("dose_id not between", value1, value2, "doseId");
            return this;


        }

        public Criteria andAbbreviationPictureIsNull() {
            addCriterion("abbreviation_picture is null");
            return this;


        }

        public Criteria andAbbreviationPictureIsNotNull() {
            addCriterion("abbreviation_picture is not null");
            return this;


        }

        public Criteria andAbbreviationPictureEqualTo(String value) {
            addCriterion("abbreviation_picture =", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureNotEqualTo(String value) {
            addCriterion("abbreviation_picture <>", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureGreaterThan(String value) {
            addCriterion("abbreviation_picture >", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureGreaterThanOrEqualTo(String value) {
            addCriterion("abbreviation_picture >=", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureLessThan(String value) {
            addCriterion("abbreviation_picture <", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureLessThanOrEqualTo(String value) {
            addCriterion("abbreviation_picture <=", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureLike(String value) {
            addCriterion("abbreviation_picture like", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureNotLike(String value) {
            addCriterion("abbreviation_picture not like", value, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureIn(List values) {
            addCriterion("abbreviation_picture in", values, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureNotIn(List values) {
            addCriterion("abbreviation_picture not in", values, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureBetween(String value1, String value2) {
            addCriterion("abbreviation_picture between", value1, value2, "abbreviationPicture");
            return this;


        }

        public Criteria andAbbreviationPictureNotBetween(String value1, String value2) {
            addCriterion("abbreviation_picture not between", value1, value2, "abbreviationPicture");
            return this;


        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return this;


        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return this;


        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return this;


        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return this;


        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return this;


        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return this;


        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return this;


        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return this;


        }

        public Criteria andBrandIdIn(List values) {
            addCriterion("brand_id in", values, "brandId");
            return this;


        }

        public Criteria andBrandIdNotIn(List values) {
            addCriterion("brand_id not in", values, "brandId");
            return this;


        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return this;


        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return this;


        }

        public Criteria andPromotionIdIsNull() {
            addCriterion("promotion_id is null");
            return this;


        }

        public Criteria andPromotionIdIsNotNull() {
            addCriterion("promotion_id is not null");
            return this;


        }

        public Criteria andPromotionIdEqualTo(Long value) {
            addCriterion("promotion_id =", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdNotEqualTo(Long value) {
            addCriterion("promotion_id <>", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdGreaterThan(Long value) {
            addCriterion("promotion_id >", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("promotion_id >=", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdLessThan(Long value) {
            addCriterion("promotion_id <", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdLessThanOrEqualTo(Long value) {
            addCriterion("promotion_id <=", value, "promotionId");
            return this;


        }

        public Criteria andPromotionIdIn(List values) {
            addCriterion("promotion_id in", values, "promotionId");
            return this;


        }

        public Criteria andPromotionIdNotIn(List values) {
            addCriterion("promotion_id not in", values, "promotionId");
            return this;


        }

        public Criteria andPromotionIdBetween(Long value1, Long value2) {
            addCriterion("promotion_id between", value1, value2, "promotionId");
            return this;


        }

        public Criteria andPromotionIdNotBetween(Long value1, Long value2) {
            addCriterion("promotion_id not between", value1, value2, "promotionId");
            return this;


        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return this;


        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return this;


        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return this;


        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtIn(List values) {
            addCriterion("create_dt in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtNotIn(List values) {
            addCriterion("create_dt not in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return this;


        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
            return this;


        }

        public Criteria andGoodscodeIsNull() {
            addCriterion("goodscode is null");
            return this;


        }

        public Criteria andGoodscodeIsNotNull() {
            addCriterion("goodscode is not null");
            return this;


        }

        public Criteria andGoodscodeEqualTo(String value) {
            addCriterion("goodscode =", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeNotEqualTo(String value) {
            addCriterion("goodscode <>", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeGreaterThan(String value) {
            addCriterion("goodscode >", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeGreaterThanOrEqualTo(String value) {
            addCriterion("goodscode >=", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeLessThan(String value) {
            addCriterion("goodscode <", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeLessThanOrEqualTo(String value) {
            addCriterion("goodscode <=", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeLike(String value) {
            addCriterion("goodscode like", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeNotLike(String value) {
            addCriterion("goodscode not like", value, "goodscode");
            return this;


        }

        public Criteria andGoodscodeIn(List values) {
            addCriterion("goodscode in", values, "goodscode");
            return this;


        }

        public Criteria andGoodscodeNotIn(List values) {
            addCriterion("goodscode not in", values, "goodscode");
            return this;


        }

        public Criteria andGoodscodeBetween(String value1, String value2) {
            addCriterion("goodscode between", value1, value2, "goodscode");
            return this;


        }

        public Criteria andGoodscodeNotBetween(String value1, String value2) {
            addCriterion("goodscode not between", value1, value2, "goodscode");
            return this;


        }

        public Criteria andGoodAliasIsNull() {
            addCriterion("good_alias is null");
            return this;


        }

        public Criteria andGoodAliasIsNotNull() {
            addCriterion("good_alias is not null");
            return this;


        }

        public Criteria andGoodAliasEqualTo(String value) {
            addCriterion("good_alias =", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasNotEqualTo(String value) {
            addCriterion("good_alias <>", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasGreaterThan(String value) {
            addCriterion("good_alias >", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasGreaterThanOrEqualTo(String value) {
            addCriterion("good_alias >=", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasLessThan(String value) {
            addCriterion("good_alias <", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasLessThanOrEqualTo(String value) {
            addCriterion("good_alias <=", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasLike(String value) {
            addCriterion("good_alias like", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasNotLike(String value) {
            addCriterion("good_alias not like", value, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasIn(List values) {
            addCriterion("good_alias in", values, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasNotIn(List values) {
            addCriterion("good_alias not in", values, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasBetween(String value1, String value2) {
            addCriterion("good_alias between", value1, value2, "goodAlias");
            return this;


        }

        public Criteria andGoodAliasNotBetween(String value1, String value2) {
            addCriterion("good_alias not between", value1, value2, "goodAlias");
            return this;


        }

        public Criteria andSearchWordIsNull() {
            addCriterion("search_word is null");
            return this;


        }

        public Criteria andSearchWordIsNotNull() {
            addCriterion("search_word is not null");
            return this;


        }

        public Criteria andSearchWordEqualTo(String value) {
            addCriterion("search_word =", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordNotEqualTo(String value) {
            addCriterion("search_word <>", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordGreaterThan(String value) {
            addCriterion("search_word >", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordGreaterThanOrEqualTo(String value) {
            addCriterion("search_word >=", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordLessThan(String value) {
            addCriterion("search_word <", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordLessThanOrEqualTo(String value) {
            addCriterion("search_word <=", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordLike(String value) {
            addCriterion("search_word like", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordNotLike(String value) {
            addCriterion("search_word not like", value, "searchWord");
            return this;


        }

        public Criteria andSearchWordIn(List values) {
            addCriterion("search_word in", values, "searchWord");
            return this;


        }

        public Criteria andSearchWordNotIn(List values) {
            addCriterion("search_word not in", values, "searchWord");
            return this;


        }

        public Criteria andSearchWordBetween(String value1, String value2) {
            addCriterion("search_word between", value1, value2, "searchWord");
            return this;


        }

        public Criteria andSearchWordNotBetween(String value1, String value2) {
            addCriterion("search_word not between", value1, value2, "searchWord");
            return this;


        }

        public Criteria andDrugCodeIsNull() {
            addCriterion("drug_code is null");
            return this;


        }

        public Criteria andDrugCodeIsNotNull() {
            addCriterion("drug_code is not null");
            return this;


        }

        public Criteria andDrugCodeEqualTo(String value) {
            addCriterion("drug_code =", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeNotEqualTo(String value) {
            addCriterion("drug_code <>", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeGreaterThan(String value) {
            addCriterion("drug_code >", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeGreaterThanOrEqualTo(String value) {
            addCriterion("drug_code >=", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeLessThan(String value) {
            addCriterion("drug_code <", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeLessThanOrEqualTo(String value) {
            addCriterion("drug_code <=", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeLike(String value) {
            addCriterion("drug_code like", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeNotLike(String value) {
            addCriterion("drug_code not like", value, "drugCode");
            return this;


        }

        public Criteria andDrugCodeIn(List values) {
            addCriterion("drug_code in", values, "drugCode");
            return this;


        }

        public Criteria andDrugCodeNotIn(List values) {
            addCriterion("drug_code not in", values, "drugCode");
            return this;


        }

        public Criteria andDrugCodeBetween(String value1, String value2) {
            addCriterion("drug_code between", value1, value2, "drugCode");
            return this;


        }

        public Criteria andDrugCodeNotBetween(String value1, String value2) {
            addCriterion("drug_code not between", value1, value2, "drugCode");
            return this;


        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return this;


        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return this;


        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return this;


        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return this;


        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return this;


        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return this;


        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return this;


        }

        public Criteria andPinyinIn(List values) {
            addCriterion("pinyin in", values, "pinyin");
            return this;


        }

        public Criteria andPinyinNotIn(List values) {
            addCriterion("pinyin not in", values, "pinyin");
            return this;


        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return this;


        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return this;


        }


    }


}
