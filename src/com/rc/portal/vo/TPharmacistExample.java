package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TPharmacistExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TPharmacistExample() {
        oredCriteria = new ArrayList();


    }

    protected TPharmacistExample(TPharmacistExample example) {
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

        public Criteria andPharmacistIdIsNull() {
            addCriterion("pharmacist_id is null");
            return this;


        }

        public Criteria andPharmacistIdIsNotNull() {
            addCriterion("pharmacist_id is not null");
            return this;


        }

        public Criteria andPharmacistIdEqualTo(Long value) {
            addCriterion("pharmacist_id =", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdNotEqualTo(Long value) {
            addCriterion("pharmacist_id <>", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdGreaterThan(Long value) {
            addCriterion("pharmacist_id >", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pharmacist_id >=", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdLessThan(Long value) {
            addCriterion("pharmacist_id <", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdLessThanOrEqualTo(Long value) {
            addCriterion("pharmacist_id <=", value, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdIn(List values) {
            addCriterion("pharmacist_id in", values, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdNotIn(List values) {
            addCriterion("pharmacist_id not in", values, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdBetween(Long value1, Long value2) {
            addCriterion("pharmacist_id between", value1, value2, "pharmacistId");
            return this;


        }

        public Criteria andPharmacistIdNotBetween(Long value1, Long value2) {
            addCriterion("pharmacist_id not between", value1, value2, "pharmacistId");
            return this;


        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return this;


        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return this;


        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return this;


        }

        public Criteria andCommentContentIn(List values) {
            addCriterion("comment_content in", values, "commentContent");
            return this;


        }

        public Criteria andCommentContentNotIn(List values) {
            addCriterion("comment_content not in", values, "commentContent");
            return this;


        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return this;


        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return this;


        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return this;


        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return this;


        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return this;


        }

        public Criteria andCommentTimeIn(List values) {
            addCriterion("comment_time in", values, "commentTime");
            return this;


        }

        public Criteria andCommentTimeNotIn(List values) {
            addCriterion("comment_time not in", values, "commentTime");
            return this;


        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return this;


        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return this;


        }

        public Criteria andIsViewIsNull() {
            addCriterion("is_view is null");
            return this;


        }

        public Criteria andIsViewIsNotNull() {
            addCriterion("is_view is not null");
            return this;


        }

        public Criteria andIsViewEqualTo(Integer value) {
            addCriterion("is_view =", value, "isView");
            return this;


        }

        public Criteria andIsViewNotEqualTo(Integer value) {
            addCriterion("is_view <>", value, "isView");
            return this;


        }

        public Criteria andIsViewGreaterThan(Integer value) {
            addCriterion("is_view >", value, "isView");
            return this;


        }

        public Criteria andIsViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_view >=", value, "isView");
            return this;


        }

        public Criteria andIsViewLessThan(Integer value) {
            addCriterion("is_view <", value, "isView");
            return this;


        }

        public Criteria andIsViewLessThanOrEqualTo(Integer value) {
            addCriterion("is_view <=", value, "isView");
            return this;


        }

        public Criteria andIsViewIn(List values) {
            addCriterion("is_view in", values, "isView");
            return this;


        }

        public Criteria andIsViewNotIn(List values) {
            addCriterion("is_view not in", values, "isView");
            return this;


        }

        public Criteria andIsViewBetween(Integer value1, Integer value2) {
            addCriterion("is_view between", value1, value2, "isView");
            return this;


        }

        public Criteria andIsViewNotBetween(Integer value1, Integer value2) {
            addCriterion("is_view not between", value1, value2, "isView");
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
