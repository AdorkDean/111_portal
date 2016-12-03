package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsPriceExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsPriceExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsPriceExample(TGoodsPriceExample example) {
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

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platform_type is null");
            return this;


        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platform_type is not null");
            return this;


        }

        public Criteria andPlatformTypeEqualTo(String value) {
            addCriterion("platform_type =", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeNotEqualTo(String value) {
            addCriterion("platform_type <>", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeGreaterThan(String value) {
            addCriterion("platform_type >", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(String value) {
            addCriterion("platform_type >=", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeLessThan(String value) {
            addCriterion("platform_type <", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeLessThanOrEqualTo(String value) {
            addCriterion("platform_type <=", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeLike(String value) {
            addCriterion("platform_type like", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeNotLike(String value) {
            addCriterion("platform_type not like", value, "platformType");
            return this;


        }

        public Criteria andPlatformTypeIn(List values) {
            addCriterion("platform_type in", values, "platformType");
            return this;


        }

        public Criteria andPlatformTypeNotIn(List values) {
            addCriterion("platform_type not in", values, "platformType");
            return this;


        }

        public Criteria andPlatformTypeBetween(String value1, String value2) {
            addCriterion("platform_type between", value1, value2, "platformType");
            return this;


        }

        public Criteria andPlatformTypeNotBetween(String value1, String value2) {
            addCriterion("platform_type not between", value1, value2, "platformType");
            return this;


        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("price_type is null");
            return this;


        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("price_type is not null");
            return this;


        }

        public Criteria andPriceTypeEqualTo(String value) {
            addCriterion("price_type =", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeNotEqualTo(String value) {
            addCriterion("price_type <>", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeGreaterThan(String value) {
            addCriterion("price_type >", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("price_type >=", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeLessThan(String value) {
            addCriterion("price_type <", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("price_type <=", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeLike(String value) {
            addCriterion("price_type like", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeNotLike(String value) {
            addCriterion("price_type not like", value, "priceType");
            return this;


        }

        public Criteria andPriceTypeIn(List values) {
            addCriterion("price_type in", values, "priceType");
            return this;


        }

        public Criteria andPriceTypeNotIn(List values) {
            addCriterion("price_type not in", values, "priceType");
            return this;


        }

        public Criteria andPriceTypeBetween(String value1, String value2) {
            addCriterion("price_type between", value1, value2, "priceType");
            return this;


        }

        public Criteria andPriceTypeNotBetween(String value1, String value2) {
            addCriterion("price_type not between", value1, value2, "priceType");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return this;


        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return this;


        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return this;


        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return this;


        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return this;


        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return this;


        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return this;


        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
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

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return this;


        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
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

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return this;


        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return this;


        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return this;


        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return this;


        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return this;


        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return this;


        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return this;


        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return this;


        }

        public Criteria andIsShowIn(List values) {
            addCriterion("is_show in", values, "isShow");
            return this;


        }

        public Criteria andIsShowNotIn(List values) {
            addCriterion("is_show not in", values, "isShow");
            return this;


        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return this;


        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return this;


        }

        public Criteria andIsTopIsNull() {
            addCriterion("is_top is null");
            return this;


        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("is_top is not null");
            return this;


        }

        public Criteria andIsTopEqualTo(Integer value) {
            addCriterion("is_top =", value, "isTop");
            return this;


        }

        public Criteria andIsTopNotEqualTo(Integer value) {
            addCriterion("is_top <>", value, "isTop");
            return this;


        }

        public Criteria andIsTopGreaterThan(Integer value) {
            addCriterion("is_top >", value, "isTop");
            return this;


        }

        public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_top >=", value, "isTop");
            return this;


        }

        public Criteria andIsTopLessThan(Integer value) {
            addCriterion("is_top <", value, "isTop");
            return this;


        }

        public Criteria andIsTopLessThanOrEqualTo(Integer value) {
            addCriterion("is_top <=", value, "isTop");
            return this;


        }

        public Criteria andIsTopIn(List values) {
            addCriterion("is_top in", values, "isTop");
            return this;


        }

        public Criteria andIsTopNotIn(List values) {
            addCriterion("is_top not in", values, "isTop");
            return this;


        }

        public Criteria andIsTopBetween(Integer value1, Integer value2) {
            addCriterion("is_top between", value1, value2, "isTop");
            return this;


        }

        public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_top not between", value1, value2, "isTop");
            return this;


        }

        public Criteria andPromotionWordIsNull() {
            addCriterion("promotion_word is null");
            return this;


        }

        public Criteria andPromotionWordIsNotNull() {
            addCriterion("promotion_word is not null");
            return this;


        }

        public Criteria andPromotionWordEqualTo(String value) {
            addCriterion("promotion_word =", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordNotEqualTo(String value) {
            addCriterion("promotion_word <>", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordGreaterThan(String value) {
            addCriterion("promotion_word >", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_word >=", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordLessThan(String value) {
            addCriterion("promotion_word <", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordLessThanOrEqualTo(String value) {
            addCriterion("promotion_word <=", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordLike(String value) {
            addCriterion("promotion_word like", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordNotLike(String value) {
            addCriterion("promotion_word not like", value, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordIn(List values) {
            addCriterion("promotion_word in", values, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordNotIn(List values) {
            addCriterion("promotion_word not in", values, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordBetween(String value1, String value2) {
            addCriterion("promotion_word between", value1, value2, "promotionWord");
            return this;


        }

        public Criteria andPromotionWordNotBetween(String value1, String value2) {
            addCriterion("promotion_word not between", value1, value2, "promotionWord");
            return this;


        }

        public Criteria andUpDtIsNull() {
            addCriterion("up_dt is null");
            return this;


        }

        public Criteria andUpDtIsNotNull() {
            addCriterion("up_dt is not null");
            return this;


        }

        public Criteria andUpDtEqualTo(Date value) {
            addCriterion("up_dt =", value, "upDt");
            return this;


        }

        public Criteria andUpDtNotEqualTo(Date value) {
            addCriterion("up_dt <>", value, "upDt");
            return this;


        }

        public Criteria andUpDtGreaterThan(Date value) {
            addCriterion("up_dt >", value, "upDt");
            return this;


        }

        public Criteria andUpDtGreaterThanOrEqualTo(Date value) {
            addCriterion("up_dt >=", value, "upDt");
            return this;


        }

        public Criteria andUpDtLessThan(Date value) {
            addCriterion("up_dt <", value, "upDt");
            return this;


        }

        public Criteria andUpDtLessThanOrEqualTo(Date value) {
            addCriterion("up_dt <=", value, "upDt");
            return this;


        }

        public Criteria andUpDtIn(List values) {
            addCriterion("up_dt in", values, "upDt");
            return this;


        }

        public Criteria andUpDtNotIn(List values) {
            addCriterion("up_dt not in", values, "upDt");
            return this;


        }

        public Criteria andUpDtBetween(Date value1, Date value2) {
            addCriterion("up_dt between", value1, value2, "upDt");
            return this;


        }

        public Criteria andUpDtNotBetween(Date value1, Date value2) {
            addCriterion("up_dt not between", value1, value2, "upDt");
            return this;


        }

        public Criteria andDownDtIsNull() {
            addCriterion("down_dt is null");
            return this;


        }

        public Criteria andDownDtIsNotNull() {
            addCriterion("down_dt is not null");
            return this;


        }

        public Criteria andDownDtEqualTo(Date value) {
            addCriterion("down_dt =", value, "downDt");
            return this;


        }

        public Criteria andDownDtNotEqualTo(Date value) {
            addCriterion("down_dt <>", value, "downDt");
            return this;


        }

        public Criteria andDownDtGreaterThan(Date value) {
            addCriterion("down_dt >", value, "downDt");
            return this;


        }

        public Criteria andDownDtGreaterThanOrEqualTo(Date value) {
            addCriterion("down_dt >=", value, "downDt");
            return this;


        }

        public Criteria andDownDtLessThan(Date value) {
            addCriterion("down_dt <", value, "downDt");
            return this;


        }

        public Criteria andDownDtLessThanOrEqualTo(Date value) {
            addCriterion("down_dt <=", value, "downDt");
            return this;


        }

        public Criteria andDownDtIn(List values) {
            addCriterion("down_dt in", values, "downDt");
            return this;


        }

        public Criteria andDownDtNotIn(List values) {
            addCriterion("down_dt not in", values, "downDt");
            return this;


        }

        public Criteria andDownDtBetween(Date value1, Date value2) {
            addCriterion("down_dt between", value1, value2, "downDt");
            return this;


        }

        public Criteria andDownDtNotBetween(Date value1, Date value2) {
            addCriterion("down_dt not between", value1, value2, "downDt");
            return this;


        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return this;


        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return this;


        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return this;


        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return this;


        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return this;


        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return this;


        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return this;


        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return this;


        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return this;


        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return this;


        }

        public Criteria andRemarksIn(List values) {
            addCriterion("remarks in", values, "remarks");
            return this;


        }

        public Criteria andRemarksNotIn(List values) {
            addCriterion("remarks not in", values, "remarks");
            return this;


        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return this;


        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return this;


        }


    }


}
