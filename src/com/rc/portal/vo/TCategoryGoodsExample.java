package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCategoryGoodsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCategoryGoodsExample() {
        oredCriteria = new ArrayList();


    }

    protected TCategoryGoodsExample(TCategoryGoodsExample example) {
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

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return this;


        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return this;


        }

        public Criteria andCategoryidEqualTo(Long value) {
            addCriterion("categoryid =", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidNotEqualTo(Long value) {
            addCriterion("categoryid <>", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidGreaterThan(Long value) {
            addCriterion("categoryid >", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Long value) {
            addCriterion("categoryid >=", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidLessThan(Long value) {
            addCriterion("categoryid <", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidLessThanOrEqualTo(Long value) {
            addCriterion("categoryid <=", value, "categoryid");
            return this;


        }

        public Criteria andCategoryidIn(List values) {
            addCriterion("categoryid in", values, "categoryid");
            return this;


        }

        public Criteria andCategoryidNotIn(List values) {
            addCriterion("categoryid not in", values, "categoryid");
            return this;


        }

        public Criteria andCategoryidBetween(Long value1, Long value2) {
            addCriterion("categoryid between", value1, value2, "categoryid");
            return this;


        }

        public Criteria andCategoryidNotBetween(Long value1, Long value2) {
            addCriterion("categoryid not between", value1, value2, "categoryid");
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


    }


}
