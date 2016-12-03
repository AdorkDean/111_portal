package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCartItemExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCartItemExample() {
        oredCriteria = new ArrayList();


    }

    protected TCartItemExample(TCartItemExample example) {
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

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return this;


        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return this;


        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return this;


        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return this;


        }

        public Criteria andQuantityIn(List values) {
            addCriterion("quantity in", values, "quantity");
            return this;


        }

        public Criteria andQuantityNotIn(List values) {
            addCriterion("quantity not in", values, "quantity");
            return this;


        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return this;


        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return this;


        }

        public Criteria andIsSelectedIsNull() {
            addCriterion("is_selected is null");
            return this;


        }

        public Criteria andIsSelectedIsNotNull() {
            addCriterion("is_selected is not null");
            return this;


        }

        public Criteria andIsSelectedEqualTo(Integer value) {
            addCriterion("is_selected =", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedNotEqualTo(Integer value) {
            addCriterion("is_selected <>", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedGreaterThan(Integer value) {
            addCriterion("is_selected >", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_selected >=", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedLessThan(Integer value) {
            addCriterion("is_selected <", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedLessThanOrEqualTo(Integer value) {
            addCriterion("is_selected <=", value, "isSelected");
            return this;


        }

        public Criteria andIsSelectedIn(List values) {
            addCriterion("is_selected in", values, "isSelected");
            return this;


        }

        public Criteria andIsSelectedNotIn(List values) {
            addCriterion("is_selected not in", values, "isSelected");
            return this;


        }

        public Criteria andIsSelectedBetween(Integer value1, Integer value2) {
            addCriterion("is_selected between", value1, value2, "isSelected");
            return this;


        }

        public Criteria andIsSelectedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_selected not between", value1, value2, "isSelected");
            return this;


        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return this;


        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return this;


        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return this;


        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("create_time in", values, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("create_time not in", values, "createTime");
            return this;


        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return this;


        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return this;


        }

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return this;


        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return this;


        }

        public Criteria andCartIdEqualTo(Long value) {
            addCriterion("cart_id =", value, "cartId");
            return this;


        }

        public Criteria andCartIdNotEqualTo(Long value) {
            addCriterion("cart_id <>", value, "cartId");
            return this;


        }

        public Criteria andCartIdGreaterThan(Long value) {
            addCriterion("cart_id >", value, "cartId");
            return this;


        }

        public Criteria andCartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cart_id >=", value, "cartId");
            return this;


        }

        public Criteria andCartIdLessThan(Long value) {
            addCriterion("cart_id <", value, "cartId");
            return this;


        }

        public Criteria andCartIdLessThanOrEqualTo(Long value) {
            addCriterion("cart_id <=", value, "cartId");
            return this;


        }

        public Criteria andCartIdIn(List values) {
            addCriterion("cart_id in", values, "cartId");
            return this;


        }

        public Criteria andCartIdNotIn(List values) {
            addCriterion("cart_id not in", values, "cartId");
            return this;


        }

        public Criteria andCartIdBetween(Long value1, Long value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return this;


        }

        public Criteria andCartIdNotBetween(Long value1, Long value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
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

        public Criteria andIfPremiumsIsNull() {
            addCriterion("if_premiums is null");
            return this;


        }

        public Criteria andIfPremiumsIsNotNull() {
            addCriterion("if_premiums is not null");
            return this;


        }

        public Criteria andIfPremiumsEqualTo(Integer value) {
            addCriterion("if_premiums =", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsNotEqualTo(Integer value) {
            addCriterion("if_premiums <>", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsGreaterThan(Integer value) {
            addCriterion("if_premiums >", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_premiums >=", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsLessThan(Integer value) {
            addCriterion("if_premiums <", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsLessThanOrEqualTo(Integer value) {
            addCriterion("if_premiums <=", value, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsIn(List values) {
            addCriterion("if_premiums in", values, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsNotIn(List values) {
            addCriterion("if_premiums not in", values, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsBetween(Integer value1, Integer value2) {
            addCriterion("if_premiums between", value1, value2, "ifPremiums");
            return this;


        }

        public Criteria andIfPremiumsNotBetween(Integer value1, Integer value2) {
            addCriterion("if_premiums not between", value1, value2, "ifPremiums");
            return this;


        }

        public Criteria andIsYktGoodIsNull() {
            addCriterion("is_ykt_good is null");
            return this;


        }

        public Criteria andIsYktGoodIsNotNull() {
            addCriterion("is_ykt_good is not null");
            return this;


        }

        public Criteria andIsYktGoodEqualTo(Integer value) {
            addCriterion("is_ykt_good =", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodNotEqualTo(Integer value) {
            addCriterion("is_ykt_good <>", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodGreaterThan(Integer value) {
            addCriterion("is_ykt_good >", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ykt_good >=", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodLessThan(Integer value) {
            addCriterion("is_ykt_good <", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodLessThanOrEqualTo(Integer value) {
            addCriterion("is_ykt_good <=", value, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodIn(List values) {
            addCriterion("is_ykt_good in", values, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodNotIn(List values) {
            addCriterion("is_ykt_good not in", values, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodBetween(Integer value1, Integer value2) {
            addCriterion("is_ykt_good between", value1, value2, "isYktGood");
            return this;


        }

        public Criteria andIsYktGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ykt_good not between", value1, value2, "isYktGood");
            return this;


        }


    }


}
