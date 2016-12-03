package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsPropertyExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsPropertyExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsPropertyExample(TGoodsPropertyExample example) {
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

        public Criteria andAttentionIsNull() {
            addCriterion("attention is null");
            return this;


        }

        public Criteria andAttentionIsNotNull() {
            addCriterion("attention is not null");
            return this;


        }

        public Criteria andAttentionEqualTo(Integer value) {
            addCriterion("attention =", value, "attention");
            return this;


        }

        public Criteria andAttentionNotEqualTo(Integer value) {
            addCriterion("attention <>", value, "attention");
            return this;


        }

        public Criteria andAttentionGreaterThan(Integer value) {
            addCriterion("attention >", value, "attention");
            return this;


        }

        public Criteria andAttentionGreaterThanOrEqualTo(Integer value) {
            addCriterion("attention >=", value, "attention");
            return this;


        }

        public Criteria andAttentionLessThan(Integer value) {
            addCriterion("attention <", value, "attention");
            return this;


        }

        public Criteria andAttentionLessThanOrEqualTo(Integer value) {
            addCriterion("attention <=", value, "attention");
            return this;


        }

        public Criteria andAttentionIn(List values) {
            addCriterion("attention in", values, "attention");
            return this;


        }

        public Criteria andAttentionNotIn(List values) {
            addCriterion("attention not in", values, "attention");
            return this;


        }

        public Criteria andAttentionBetween(Integer value1, Integer value2) {
            addCriterion("attention between", value1, value2, "attention");
            return this;


        }

        public Criteria andAttentionNotBetween(Integer value1, Integer value2) {
            addCriterion("attention not between", value1, value2, "attention");
            return this;


        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return this;


        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return this;


        }

        public Criteria andSalesEqualTo(Integer value) {
            addCriterion("sales =", value, "sales");
            return this;


        }

        public Criteria andSalesNotEqualTo(Integer value) {
            addCriterion("sales <>", value, "sales");
            return this;


        }

        public Criteria andSalesGreaterThan(Integer value) {
            addCriterion("sales >", value, "sales");
            return this;


        }

        public Criteria andSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales >=", value, "sales");
            return this;


        }

        public Criteria andSalesLessThan(Integer value) {
            addCriterion("sales <", value, "sales");
            return this;


        }

        public Criteria andSalesLessThanOrEqualTo(Integer value) {
            addCriterion("sales <=", value, "sales");
            return this;


        }

        public Criteria andSalesIn(List values) {
            addCriterion("sales in", values, "sales");
            return this;


        }

        public Criteria andSalesNotIn(List values) {
            addCriterion("sales not in", values, "sales");
            return this;


        }

        public Criteria andSalesBetween(Integer value1, Integer value2) {
            addCriterion("sales between", value1, value2, "sales");
            return this;


        }

        public Criteria andSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return this;


        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return this;


        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return this;


        }

        public Criteria andEvaluateEqualTo(Integer value) {
            addCriterion("evaluate =", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateNotEqualTo(Integer value) {
            addCriterion("evaluate <>", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateGreaterThan(Integer value) {
            addCriterion("evaluate >", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate >=", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateLessThan(Integer value) {
            addCriterion("evaluate <", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate <=", value, "evaluate");
            return this;


        }

        public Criteria andEvaluateIn(List values) {
            addCriterion("evaluate in", values, "evaluate");
            return this;


        }

        public Criteria andEvaluateNotIn(List values) {
            addCriterion("evaluate not in", values, "evaluate");
            return this;


        }

        public Criteria andEvaluateBetween(Integer value1, Integer value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return this;


        }

        public Criteria andEvaluateNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
            return this;


        }


    }


}
