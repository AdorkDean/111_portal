package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLeaderArticleGoodsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLeaderArticleGoodsExample() {
        oredCriteria = new ArrayList();


    }

    protected TLeaderArticleGoodsExample(TLeaderArticleGoodsExample example) {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return this;


        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return this;


        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return this;


        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return this;


        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return this;


        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return this;


        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return this;


        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return this;


        }

        public Criteria andArticleIdIn(List values) {
            addCriterion("article_id in", values, "articleId");
            return this;


        }

        public Criteria andArticleIdNotIn(List values) {
            addCriterion("article_id not in", values, "articleId");
            return this;


        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return this;


        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return this;


        }

        public Criteria andGoodImageUrlIsNull() {
            addCriterion("good_image_url is null");
            return this;


        }

        public Criteria andGoodImageUrlIsNotNull() {
            addCriterion("good_image_url is not null");
            return this;


        }

        public Criteria andGoodImageUrlEqualTo(String value) {
            addCriterion("good_image_url =", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlNotEqualTo(String value) {
            addCriterion("good_image_url <>", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlGreaterThan(String value) {
            addCriterion("good_image_url >", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("good_image_url >=", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlLessThan(String value) {
            addCriterion("good_image_url <", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlLessThanOrEqualTo(String value) {
            addCriterion("good_image_url <=", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlLike(String value) {
            addCriterion("good_image_url like", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlNotLike(String value) {
            addCriterion("good_image_url not like", value, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlIn(List values) {
            addCriterion("good_image_url in", values, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlNotIn(List values) {
            addCriterion("good_image_url not in", values, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlBetween(String value1, String value2) {
            addCriterion("good_image_url between", value1, value2, "goodImageUrl");
            return this;


        }

        public Criteria andGoodImageUrlNotBetween(String value1, String value2) {
            addCriterion("good_image_url not between", value1, value2, "goodImageUrl");
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


    }


}
