package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberGradeExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberGradeExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberGradeExample(TMemberGradeExample example) {
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

        public Criteria andEnterpriseDiscountIsNull() {
            addCriterion("enterprise_discount is null");
            return this;


        }

        public Criteria andEnterpriseDiscountIsNotNull() {
            addCriterion("enterprise_discount is not null");
            return this;


        }

        public Criteria andEnterpriseDiscountEqualTo(BigDecimal value) {
            addCriterion("enterprise_discount =", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountNotEqualTo(BigDecimal value) {
            addCriterion("enterprise_discount <>", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountGreaterThan(BigDecimal value) {
            addCriterion("enterprise_discount >", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enterprise_discount >=", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountLessThan(BigDecimal value) {
            addCriterion("enterprise_discount <", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enterprise_discount <=", value, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountIn(List values) {
            addCriterion("enterprise_discount in", values, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountNotIn(List values) {
            addCriterion("enterprise_discount not in", values, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enterprise_discount between", value1, value2, "enterpriseDiscount");
            return this;


        }

        public Criteria andEnterpriseDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enterprise_discount not between", value1, value2, "enterpriseDiscount");
            return this;


        }

        public Criteria andConsumePriceIsNull() {
            addCriterion("consume_price is null");
            return this;


        }

        public Criteria andConsumePriceIsNotNull() {
            addCriterion("consume_price is not null");
            return this;


        }

        public Criteria andConsumePriceEqualTo(BigDecimal value) {
            addCriterion("consume_price =", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceNotEqualTo(BigDecimal value) {
            addCriterion("consume_price <>", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceGreaterThan(BigDecimal value) {
            addCriterion("consume_price >", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_price >=", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceLessThan(BigDecimal value) {
            addCriterion("consume_price <", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_price <=", value, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceIn(List values) {
            addCriterion("consume_price in", values, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceNotIn(List values) {
            addCriterion("consume_price not in", values, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_price between", value1, value2, "consumePrice");
            return this;


        }

        public Criteria andConsumePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_price not between", value1, value2, "consumePrice");
            return this;


        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return this;


        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return this;


        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultIn(List values) {
            addCriterion("is_default in", values, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotIn(List values) {
            addCriterion("is_default not in", values, "isDefault");
            return this;


        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return this;


        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return this;


        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return this;


        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return this;


        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateIn(List values) {
            addCriterion("create_date in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateNotIn(List values) {
            addCriterion("create_date not in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return this;


        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return this;


        }

        public Criteria andCreatePeopleIsNull() {
            addCriterion("create_people is null");
            return this;


        }

        public Criteria andCreatePeopleIsNotNull() {
            addCriterion("create_people is not null");
            return this;


        }

        public Criteria andCreatePeopleEqualTo(String value) {
            addCriterion("create_people =", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleNotEqualTo(String value) {
            addCriterion("create_people <>", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleGreaterThan(String value) {
            addCriterion("create_people >", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("create_people >=", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleLessThan(String value) {
            addCriterion("create_people <", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleLessThanOrEqualTo(String value) {
            addCriterion("create_people <=", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleLike(String value) {
            addCriterion("create_people like", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleNotLike(String value) {
            addCriterion("create_people not like", value, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleIn(List values) {
            addCriterion("create_people in", values, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleNotIn(List values) {
            addCriterion("create_people not in", values, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleBetween(String value1, String value2) {
            addCriterion("create_people between", value1, value2, "createPeople");
            return this;


        }

        public Criteria andCreatePeopleNotBetween(String value1, String value2) {
            addCriterion("create_people not between", value1, value2, "createPeople");
            return this;


        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return this;


        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return this;


        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateIn(List values) {
            addCriterion("update_date in", values, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotIn(List values) {
            addCriterion("update_date not in", values, "updateDate");
            return this;


        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return this;


        }

        public Criteria andUpdatePeopleIsNull() {
            addCriterion("update_people is null");
            return this;


        }

        public Criteria andUpdatePeopleIsNotNull() {
            addCriterion("update_people is not null");
            return this;


        }

        public Criteria andUpdatePeopleEqualTo(String value) {
            addCriterion("update_people =", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleNotEqualTo(String value) {
            addCriterion("update_people <>", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleGreaterThan(String value) {
            addCriterion("update_people >", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("update_people >=", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleLessThan(String value) {
            addCriterion("update_people <", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleLessThanOrEqualTo(String value) {
            addCriterion("update_people <=", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleLike(String value) {
            addCriterion("update_people like", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleNotLike(String value) {
            addCriterion("update_people not like", value, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleIn(List values) {
            addCriterion("update_people in", values, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleNotIn(List values) {
            addCriterion("update_people not in", values, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleBetween(String value1, String value2) {
            addCriterion("update_people between", value1, value2, "updatePeople");
            return this;


        }

        public Criteria andUpdatePeopleNotBetween(String value1, String value2) {
            addCriterion("update_people not between", value1, value2, "updatePeople");
            return this;


        }


    }


}
