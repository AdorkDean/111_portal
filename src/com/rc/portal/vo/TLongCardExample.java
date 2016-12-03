package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLongCardExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLongCardExample() {
        oredCriteria = new ArrayList();


    }

    protected TLongCardExample(TLongCardExample example) {
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

        public Criteria andCardIsNull() {
            addCriterion("card is null");
            return this;


        }

        public Criteria andCardIsNotNull() {
            addCriterion("card is not null");
            return this;


        }

        public Criteria andCardEqualTo(String value) {
            addCriterion("card =", value, "card");
            return this;


        }

        public Criteria andCardNotEqualTo(String value) {
            addCriterion("card <>", value, "card");
            return this;


        }

        public Criteria andCardGreaterThan(String value) {
            addCriterion("card >", value, "card");
            return this;


        }

        public Criteria andCardGreaterThanOrEqualTo(String value) {
            addCriterion("card >=", value, "card");
            return this;


        }

        public Criteria andCardLessThan(String value) {
            addCriterion("card <", value, "card");
            return this;


        }

        public Criteria andCardLessThanOrEqualTo(String value) {
            addCriterion("card <=", value, "card");
            return this;


        }

        public Criteria andCardLike(String value) {
            addCriterion("card like", value, "card");
            return this;


        }

        public Criteria andCardNotLike(String value) {
            addCriterion("card not like", value, "card");
            return this;


        }

        public Criteria andCardIn(List values) {
            addCriterion("card in", values, "card");
            return this;


        }

        public Criteria andCardNotIn(List values) {
            addCriterion("card not in", values, "card");
            return this;


        }

        public Criteria andCardBetween(String value1, String value2) {
            addCriterion("card between", value1, value2, "card");
            return this;


        }

        public Criteria andCardNotBetween(String value1, String value2) {
            addCriterion("card not between", value1, value2, "card");
            return this;


        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return this;


        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return this;


        }

        public Criteria andIsUseEqualTo(Integer value) {
            addCriterion("is_use =", value, "isUse");
            return this;


        }

        public Criteria andIsUseNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "isUse");
            return this;


        }

        public Criteria andIsUseGreaterThan(Integer value) {
            addCriterion("is_use >", value, "isUse");
            return this;


        }

        public Criteria andIsUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "isUse");
            return this;


        }

        public Criteria andIsUseLessThan(Integer value) {
            addCriterion("is_use <", value, "isUse");
            return this;


        }

        public Criteria andIsUseLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "isUse");
            return this;


        }

        public Criteria andIsUseIn(List values) {
            addCriterion("is_use in", values, "isUse");
            return this;


        }

        public Criteria andIsUseNotIn(List values) {
            addCriterion("is_use not in", values, "isUse");
            return this;


        }

        public Criteria andIsUseBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return this;


        }

        public Criteria andIsUseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return this;


        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return this;


        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return this;


        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return this;


        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return this;


        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return this;


        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return this;


        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return this;


        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return this;


        }

        public Criteria andMemberIdIn(List values) {
            addCriterion("member_id in", values, "memberId");
            return this;


        }

        public Criteria andMemberIdNotIn(List values) {
            addCriterion("member_id not in", values, "memberId");
            return this;


        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return this;


        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return this;


        }

        public Criteria andUsedTimeIsNull() {
            addCriterion("used_time is null");
            return this;


        }

        public Criteria andUsedTimeIsNotNull() {
            addCriterion("used_time is not null");
            return this;


        }

        public Criteria andUsedTimeEqualTo(Date value) {
            addCriterion("used_time =", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeNotEqualTo(Date value) {
            addCriterion("used_time <>", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeGreaterThan(Date value) {
            addCriterion("used_time >", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("used_time >=", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeLessThan(Date value) {
            addCriterion("used_time <", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeLessThanOrEqualTo(Date value) {
            addCriterion("used_time <=", value, "usedTime");
            return this;


        }

        public Criteria andUsedTimeIn(List values) {
            addCriterion("used_time in", values, "usedTime");
            return this;


        }

        public Criteria andUsedTimeNotIn(List values) {
            addCriterion("used_time not in", values, "usedTime");
            return this;


        }

        public Criteria andUsedTimeBetween(Date value1, Date value2) {
            addCriterion("used_time between", value1, value2, "usedTime");
            return this;


        }

        public Criteria andUsedTimeNotBetween(Date value1, Date value2) {
            addCriterion("used_time not between", value1, value2, "usedTime");
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

        public Criteria andLongCardIdIsNull() {
            addCriterion("long_card_id is null");
            return this;


        }

        public Criteria andLongCardIdIsNotNull() {
            addCriterion("long_card_id is not null");
            return this;


        }

        public Criteria andLongCardIdEqualTo(Long value) {
            addCriterion("long_card_id =", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdNotEqualTo(Long value) {
            addCriterion("long_card_id <>", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdGreaterThan(Long value) {
            addCriterion("long_card_id >", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("long_card_id >=", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdLessThan(Long value) {
            addCriterion("long_card_id <", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdLessThanOrEqualTo(Long value) {
            addCriterion("long_card_id <=", value, "longCardId");
            return this;


        }

        public Criteria andLongCardIdIn(List values) {
            addCriterion("long_card_id in", values, "longCardId");
            return this;


        }

        public Criteria andLongCardIdNotIn(List values) {
            addCriterion("long_card_id not in", values, "longCardId");
            return this;


        }

        public Criteria andLongCardIdBetween(Long value1, Long value2) {
            addCriterion("long_card_id between", value1, value2, "longCardId");
            return this;


        }

        public Criteria andLongCardIdNotBetween(Long value1, Long value2) {
            addCriterion("long_card_id not between", value1, value2, "longCardId");
            return this;


        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return this;


        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return this;


        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return this;


        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return this;


        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return this;


        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return this;


        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return this;


        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return this;


        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return this;


        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return this;


        }

        public Criteria andPasswordIn(List values) {
            addCriterion("password in", values, "password");
            return this;


        }

        public Criteria andPasswordNotIn(List values) {
            addCriterion("password not in", values, "password");
            return this;


        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return this;


        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return this;


        }


    }


}
