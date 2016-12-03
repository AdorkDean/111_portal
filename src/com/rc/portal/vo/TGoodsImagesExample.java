package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsImagesExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsImagesExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsImagesExample(TGoodsImagesExample example) {
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

        public Criteria andTitelIsNull() {
            addCriterion("titel is null");
            return this;


        }

        public Criteria andTitelIsNotNull() {
            addCriterion("titel is not null");
            return this;


        }

        public Criteria andTitelEqualTo(String value) {
            addCriterion("titel =", value, "titel");
            return this;


        }

        public Criteria andTitelNotEqualTo(String value) {
            addCriterion("titel <>", value, "titel");
            return this;


        }

        public Criteria andTitelGreaterThan(String value) {
            addCriterion("titel >", value, "titel");
            return this;


        }

        public Criteria andTitelGreaterThanOrEqualTo(String value) {
            addCriterion("titel >=", value, "titel");
            return this;


        }

        public Criteria andTitelLessThan(String value) {
            addCriterion("titel <", value, "titel");
            return this;


        }

        public Criteria andTitelLessThanOrEqualTo(String value) {
            addCriterion("titel <=", value, "titel");
            return this;


        }

        public Criteria andTitelLike(String value) {
            addCriterion("titel like", value, "titel");
            return this;


        }

        public Criteria andTitelNotLike(String value) {
            addCriterion("titel not like", value, "titel");
            return this;


        }

        public Criteria andTitelIn(List values) {
            addCriterion("titel in", values, "titel");
            return this;


        }

        public Criteria andTitelNotIn(List values) {
            addCriterion("titel not in", values, "titel");
            return this;


        }

        public Criteria andTitelBetween(String value1, String value2) {
            addCriterion("titel between", value1, value2, "titel");
            return this;


        }

        public Criteria andTitelNotBetween(String value1, String value2) {
            addCriterion("titel not between", value1, value2, "titel");
            return this;


        }

        public Criteria andArtworkUrlIsNull() {
            addCriterion("artwork_url is null");
            return this;


        }

        public Criteria andArtworkUrlIsNotNull() {
            addCriterion("artwork_url is not null");
            return this;


        }

        public Criteria andArtworkUrlEqualTo(String value) {
            addCriterion("artwork_url =", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlNotEqualTo(String value) {
            addCriterion("artwork_url <>", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlGreaterThan(String value) {
            addCriterion("artwork_url >", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("artwork_url >=", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlLessThan(String value) {
            addCriterion("artwork_url <", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlLessThanOrEqualTo(String value) {
            addCriterion("artwork_url <=", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlLike(String value) {
            addCriterion("artwork_url like", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlNotLike(String value) {
            addCriterion("artwork_url not like", value, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlIn(List values) {
            addCriterion("artwork_url in", values, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlNotIn(List values) {
            addCriterion("artwork_url not in", values, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlBetween(String value1, String value2) {
            addCriterion("artwork_url between", value1, value2, "artworkUrl");
            return this;


        }

        public Criteria andArtworkUrlNotBetween(String value1, String value2) {
            addCriterion("artwork_url not between", value1, value2, "artworkUrl");
            return this;


        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return this;


        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return this;


        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlIn(List values) {
            addCriterion("image_url in", values, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotIn(List values) {
            addCriterion("image_url not in", values, "imageUrl");
            return this;


        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return this;


        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return this;


        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return this;


        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return this;


        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return this;


        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return this;


        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return this;


        }

        public Criteria andSortIn(List values) {
            addCriterion("sort in", values, "sort");
            return this;


        }

        public Criteria andSortNotIn(List values) {
            addCriterion("sort not in", values, "sort");
            return this;


        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return this;


        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return this;


        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return this;


        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return this;


        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return this;


        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return this;


        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return this;


        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return this;


        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return this;


        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return this;


        }

        public Criteria andUserTypeIn(List values) {
            addCriterion("user_type in", values, "userType");
            return this;


        }

        public Criteria andUserTypeNotIn(List values) {
            addCriterion("user_type not in", values, "userType");
            return this;


        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return this;


        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return this;


        }

        public Criteria andIsdefaultIsNull() {
            addCriterion("isdefault is null");
            return this;


        }

        public Criteria andIsdefaultIsNotNull() {
            addCriterion("isdefault is not null");
            return this;


        }

        public Criteria andIsdefaultEqualTo(Integer value) {
            addCriterion("isdefault =", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultNotEqualTo(Integer value) {
            addCriterion("isdefault <>", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultGreaterThan(Integer value) {
            addCriterion("isdefault >", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdefault >=", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultLessThan(Integer value) {
            addCriterion("isdefault <", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultLessThanOrEqualTo(Integer value) {
            addCriterion("isdefault <=", value, "isdefault");
            return this;


        }

        public Criteria andIsdefaultIn(List values) {
            addCriterion("isdefault in", values, "isdefault");
            return this;


        }

        public Criteria andIsdefaultNotIn(List values) {
            addCriterion("isdefault not in", values, "isdefault");
            return this;


        }

        public Criteria andIsdefaultBetween(Integer value1, Integer value2) {
            addCriterion("isdefault between", value1, value2, "isdefault");
            return this;


        }

        public Criteria andIsdefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("isdefault not between", value1, value2, "isdefault");
            return this;


        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return this;


        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return this;


        }

        public Criteria andGoodsidEqualTo(Long value) {
            addCriterion("goodsid =", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotEqualTo(Long value) {
            addCriterion("goodsid <>", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidGreaterThan(Long value) {
            addCriterion("goodsid >", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsid >=", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidLessThan(Long value) {
            addCriterion("goodsid <", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidLessThanOrEqualTo(Long value) {
            addCriterion("goodsid <=", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidIn(List values) {
            addCriterion("goodsid in", values, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotIn(List values) {
            addCriterion("goodsid not in", values, "goodsid");
            return this;


        }

        public Criteria andGoodsidBetween(Long value1, Long value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotBetween(Long value1, Long value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return this;


        }


    }


}
