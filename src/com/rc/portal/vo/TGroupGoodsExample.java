package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGroupGoodsExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGroupGoodsExample() {
        oredCriteria = new ArrayList();


    }

    protected TGroupGoodsExample(TGroupGoodsExample example) {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return this;


        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return this;


        }

        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("group_id =", value, "groupId");
            return this;


        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "groupId");
            return this;


        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("group_id >", value, "groupId");
            return this;


        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "groupId");
            return this;


        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("group_id <", value, "groupId");
            return this;


        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "groupId");
            return this;


        }

        public Criteria andGroupIdIn(List values) {
            addCriterion("group_id in", values, "groupId");
            return this;


        }

        public Criteria andGroupIdNotIn(List values) {
            addCriterion("group_id not in", values, "groupId");
            return this;


        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return this;


        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return this;


        }

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return this;


        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return this;


        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumIn(List values) {
            addCriterion("goods_num in", values, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumNotIn(List values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return this;


        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
            return this;


        }

        public Criteria andMainGoodsIsNull() {
            addCriterion("main_goods is null");
            return this;


        }

        public Criteria andMainGoodsIsNotNull() {
            addCriterion("main_goods is not null");
            return this;


        }

        public Criteria andMainGoodsEqualTo(Integer value) {
            addCriterion("main_goods =", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsNotEqualTo(Integer value) {
            addCriterion("main_goods <>", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsGreaterThan(Integer value) {
            addCriterion("main_goods >", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_goods >=", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsLessThan(Integer value) {
            addCriterion("main_goods <", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("main_goods <=", value, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsIn(List values) {
            addCriterion("main_goods in", values, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsNotIn(List values) {
            addCriterion("main_goods not in", values, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsBetween(Integer value1, Integer value2) {
            addCriterion("main_goods between", value1, value2, "mainGoods");
            return this;


        }

        public Criteria andMainGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("main_goods not between", value1, value2, "mainGoods");
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
