package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CDeliveryWayExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CDeliveryWayExample() {
        oredCriteria = new ArrayList();


    }

    protected CDeliveryWayExample(CDeliveryWayExample example) {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return this;


        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return this;


        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return this;


        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return this;


        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return this;


        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return this;


        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return this;


        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return this;


        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return this;


        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return this;


        }

        public Criteria andNameIn(List values) {
            addCriterion("name in", values, "name");
            return this;


        }

        public Criteria andNameNotIn(List values) {
            addCriterion("name not in", values, "name");
            return this;


        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return this;


        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return this;


        }

        public Criteria andInitWeightIsNull() {
            addCriterion("init_weight is null");
            return this;


        }

        public Criteria andInitWeightIsNotNull() {
            addCriterion("init_weight is not null");
            return this;


        }

        public Criteria andInitWeightEqualTo(BigDecimal value) {
            addCriterion("init_weight =", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightNotEqualTo(BigDecimal value) {
            addCriterion("init_weight <>", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightGreaterThan(BigDecimal value) {
            addCriterion("init_weight >", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("init_weight >=", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightLessThan(BigDecimal value) {
            addCriterion("init_weight <", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("init_weight <=", value, "initWeight");
            return this;


        }

        public Criteria andInitWeightIn(List values) {
            addCriterion("init_weight in", values, "initWeight");
            return this;


        }

        public Criteria andInitWeightNotIn(List values) {
            addCriterion("init_weight not in", values, "initWeight");
            return this;


        }

        public Criteria andInitWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("init_weight between", value1, value2, "initWeight");
            return this;


        }

        public Criteria andInitWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("init_weight not between", value1, value2, "initWeight");
            return this;


        }

        public Criteria andAddWeightIsNull() {
            addCriterion("add_weight is null");
            return this;


        }

        public Criteria andAddWeightIsNotNull() {
            addCriterion("add_weight is not null");
            return this;


        }

        public Criteria andAddWeightEqualTo(BigDecimal value) {
            addCriterion("add_weight =", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightNotEqualTo(BigDecimal value) {
            addCriterion("add_weight <>", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightGreaterThan(BigDecimal value) {
            addCriterion("add_weight >", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("add_weight >=", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightLessThan(BigDecimal value) {
            addCriterion("add_weight <", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("add_weight <=", value, "addWeight");
            return this;


        }

        public Criteria andAddWeightIn(List values) {
            addCriterion("add_weight in", values, "addWeight");
            return this;


        }

        public Criteria andAddWeightNotIn(List values) {
            addCriterion("add_weight not in", values, "addWeight");
            return this;


        }

        public Criteria andAddWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_weight between", value1, value2, "addWeight");
            return this;


        }

        public Criteria andAddWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_weight not between", value1, value2, "addWeight");
            return this;


        }

        public Criteria andInitPriceIsNull() {
            addCriterion("init_price is null");
            return this;


        }

        public Criteria andInitPriceIsNotNull() {
            addCriterion("init_price is not null");
            return this;


        }

        public Criteria andInitPriceEqualTo(BigDecimal value) {
            addCriterion("init_price =", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceNotEqualTo(BigDecimal value) {
            addCriterion("init_price <>", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceGreaterThan(BigDecimal value) {
            addCriterion("init_price >", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("init_price >=", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceLessThan(BigDecimal value) {
            addCriterion("init_price <", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("init_price <=", value, "initPrice");
            return this;


        }

        public Criteria andInitPriceIn(List values) {
            addCriterion("init_price in", values, "initPrice");
            return this;


        }

        public Criteria andInitPriceNotIn(List values) {
            addCriterion("init_price not in", values, "initPrice");
            return this;


        }

        public Criteria andInitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("init_price between", value1, value2, "initPrice");
            return this;


        }

        public Criteria andInitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("init_price not between", value1, value2, "initPrice");
            return this;


        }

        public Criteria andAddPriceIsNull() {
            addCriterion("add_price is null");
            return this;


        }

        public Criteria andAddPriceIsNotNull() {
            addCriterion("add_price is not null");
            return this;


        }

        public Criteria andAddPriceEqualTo(BigDecimal value) {
            addCriterion("add_price =", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceNotEqualTo(BigDecimal value) {
            addCriterion("add_price <>", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceGreaterThan(BigDecimal value) {
            addCriterion("add_price >", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("add_price >=", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceLessThan(BigDecimal value) {
            addCriterion("add_price <", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("add_price <=", value, "addPrice");
            return this;


        }

        public Criteria andAddPriceIn(List values) {
            addCriterion("add_price in", values, "addPrice");
            return this;


        }

        public Criteria andAddPriceNotIn(List values) {
            addCriterion("add_price not in", values, "addPrice");
            return this;


        }

        public Criteria andAddPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_price between", value1, value2, "addPrice");
            return this;


        }

        public Criteria andAddPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("add_price not between", value1, value2, "addPrice");
            return this;


        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return this;


        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return this;


        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return this;


        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return this;


        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return this;


        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return this;


        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return this;


        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return this;


        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return this;


        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return this;


        }

        public Criteria andIconIn(List values) {
            addCriterion("icon in", values, "icon");
            return this;


        }

        public Criteria andIconNotIn(List values) {
            addCriterion("icon not in", values, "icon");
            return this;


        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return this;


        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return this;


        }

        public Criteria andInstroIsNull() {
            addCriterion("instro is null");
            return this;


        }

        public Criteria andInstroIsNotNull() {
            addCriterion("instro is not null");
            return this;


        }

        public Criteria andInstroEqualTo(String value) {
            addCriterion("instro =", value, "instro");
            return this;


        }

        public Criteria andInstroNotEqualTo(String value) {
            addCriterion("instro <>", value, "instro");
            return this;


        }

        public Criteria andInstroGreaterThan(String value) {
            addCriterion("instro >", value, "instro");
            return this;


        }

        public Criteria andInstroGreaterThanOrEqualTo(String value) {
            addCriterion("instro >=", value, "instro");
            return this;


        }

        public Criteria andInstroLessThan(String value) {
            addCriterion("instro <", value, "instro");
            return this;


        }

        public Criteria andInstroLessThanOrEqualTo(String value) {
            addCriterion("instro <=", value, "instro");
            return this;


        }

        public Criteria andInstroLike(String value) {
            addCriterion("instro like", value, "instro");
            return this;


        }

        public Criteria andInstroNotLike(String value) {
            addCriterion("instro not like", value, "instro");
            return this;


        }

        public Criteria andInstroIn(List values) {
            addCriterion("instro in", values, "instro");
            return this;


        }

        public Criteria andInstroNotIn(List values) {
            addCriterion("instro not in", values, "instro");
            return this;


        }

        public Criteria andInstroBetween(String value1, String value2) {
            addCriterion("instro between", value1, value2, "instro");
            return this;


        }

        public Criteria andInstroNotBetween(String value1, String value2) {
            addCriterion("instro not between", value1, value2, "instro");
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

        public Criteria andIsFreeIsNull() {
            addCriterion("is_free is null");
            return this;


        }

        public Criteria andIsFreeIsNotNull() {
            addCriterion("is_free is not null");
            return this;


        }

        public Criteria andIsFreeEqualTo(Integer value) {
            addCriterion("is_free =", value, "isFree");
            return this;


        }

        public Criteria andIsFreeNotEqualTo(Integer value) {
            addCriterion("is_free <>", value, "isFree");
            return this;


        }

        public Criteria andIsFreeGreaterThan(Integer value) {
            addCriterion("is_free >", value, "isFree");
            return this;


        }

        public Criteria andIsFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_free >=", value, "isFree");
            return this;


        }

        public Criteria andIsFreeLessThan(Integer value) {
            addCriterion("is_free <", value, "isFree");
            return this;


        }

        public Criteria andIsFreeLessThanOrEqualTo(Integer value) {
            addCriterion("is_free <=", value, "isFree");
            return this;


        }

        public Criteria andIsFreeIn(List values) {
            addCriterion("is_free in", values, "isFree");
            return this;


        }

        public Criteria andIsFreeNotIn(List values) {
            addCriterion("is_free not in", values, "isFree");
            return this;


        }

        public Criteria andIsFreeBetween(Integer value1, Integer value2) {
            addCriterion("is_free between", value1, value2, "isFree");
            return this;


        }

        public Criteria andIsFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_free not between", value1, value2, "isFree");
            return this;


        }

        public Criteria andDeliveryCodeIsNull() {
            addCriterion("delivery_code is null");
            return this;


        }

        public Criteria andDeliveryCodeIsNotNull() {
            addCriterion("delivery_code is not null");
            return this;


        }

        public Criteria andDeliveryCodeEqualTo(String value) {
            addCriterion("delivery_code =", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeNotEqualTo(String value) {
            addCriterion("delivery_code <>", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeGreaterThan(String value) {
            addCriterion("delivery_code >", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_code >=", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeLessThan(String value) {
            addCriterion("delivery_code <", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_code <=", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeLike(String value) {
            addCriterion("delivery_code like", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeNotLike(String value) {
            addCriterion("delivery_code not like", value, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeIn(List values) {
            addCriterion("delivery_code in", values, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeNotIn(List values) {
            addCriterion("delivery_code not in", values, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeBetween(String value1, String value2) {
            addCriterion("delivery_code between", value1, value2, "deliveryCode");
            return this;


        }

        public Criteria andDeliveryCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_code not between", value1, value2, "deliveryCode");
            return this;


        }


    }


}
