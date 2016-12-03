package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TPromotionExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TPromotionExample() {
        oredCriteria = new ArrayList();


    }

    protected TPromotionExample(TPromotionExample example) {
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

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return this;


        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return this;


        }

        public Criteria andScopeEqualTo(Integer value) {
            addCriterion("scope =", value, "scope");
            return this;


        }

        public Criteria andScopeNotEqualTo(Integer value) {
            addCriterion("scope <>", value, "scope");
            return this;


        }

        public Criteria andScopeGreaterThan(Integer value) {
            addCriterion("scope >", value, "scope");
            return this;


        }

        public Criteria andScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scope >=", value, "scope");
            return this;


        }

        public Criteria andScopeLessThan(Integer value) {
            addCriterion("scope <", value, "scope");
            return this;


        }

        public Criteria andScopeLessThanOrEqualTo(Integer value) {
            addCriterion("scope <=", value, "scope");
            return this;


        }

        public Criteria andScopeIn(List values) {
            addCriterion("scope in", values, "scope");
            return this;


        }

        public Criteria andScopeNotIn(List values) {
            addCriterion("scope not in", values, "scope");
            return this;


        }

        public Criteria andScopeBetween(Integer value1, Integer value2) {
            addCriterion("scope between", value1, value2, "scope");
            return this;


        }

        public Criteria andScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return this;


        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return this;


        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return this;


        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return this;


        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return this;


        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return this;


        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return this;


        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return this;


        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return this;


        }

        public Criteria andStatusIn(List values) {
            addCriterion("status in", values, "status");
            return this;


        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("status not in", values, "status");
            return this;


        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return this;


        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return this;


        }

        public Criteria andDescribIsNull() {
            addCriterion("describ is null");
            return this;


        }

        public Criteria andDescribIsNotNull() {
            addCriterion("describ is not null");
            return this;


        }

        public Criteria andDescribEqualTo(String value) {
            addCriterion("describ =", value, "describ");
            return this;


        }

        public Criteria andDescribNotEqualTo(String value) {
            addCriterion("describ <>", value, "describ");
            return this;


        }

        public Criteria andDescribGreaterThan(String value) {
            addCriterion("describ >", value, "describ");
            return this;


        }

        public Criteria andDescribGreaterThanOrEqualTo(String value) {
            addCriterion("describ >=", value, "describ");
            return this;


        }

        public Criteria andDescribLessThan(String value) {
            addCriterion("describ <", value, "describ");
            return this;


        }

        public Criteria andDescribLessThanOrEqualTo(String value) {
            addCriterion("describ <=", value, "describ");
            return this;


        }

        public Criteria andDescribLike(String value) {
            addCriterion("describ like", value, "describ");
            return this;


        }

        public Criteria andDescribNotLike(String value) {
            addCriterion("describ not like", value, "describ");
            return this;


        }

        public Criteria andDescribIn(List values) {
            addCriterion("describ in", values, "describ");
            return this;


        }

        public Criteria andDescribNotIn(List values) {
            addCriterion("describ not in", values, "describ");
            return this;


        }

        public Criteria andDescribBetween(String value1, String value2) {
            addCriterion("describ between", value1, value2, "describ");
            return this;


        }

        public Criteria andDescribNotBetween(String value1, String value2) {
            addCriterion("describ not between", value1, value2, "describ");
            return this;


        }

        public Criteria andAdvertiseIsNull() {
            addCriterion("advertise is null");
            return this;


        }

        public Criteria andAdvertiseIsNotNull() {
            addCriterion("advertise is not null");
            return this;


        }

        public Criteria andAdvertiseEqualTo(String value) {
            addCriterion("advertise =", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotEqualTo(String value) {
            addCriterion("advertise <>", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseGreaterThan(String value) {
            addCriterion("advertise >", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseGreaterThanOrEqualTo(String value) {
            addCriterion("advertise >=", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLessThan(String value) {
            addCriterion("advertise <", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLessThanOrEqualTo(String value) {
            addCriterion("advertise <=", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLike(String value) {
            addCriterion("advertise like", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotLike(String value) {
            addCriterion("advertise not like", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseIn(List values) {
            addCriterion("advertise in", values, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotIn(List values) {
            addCriterion("advertise not in", values, "advertise");
            return this;


        }

        public Criteria andAdvertiseBetween(String value1, String value2) {
            addCriterion("advertise between", value1, value2, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotBetween(String value1, String value2) {
            addCriterion("advertise not between", value1, value2, "advertise");
            return this;


        }

        public Criteria andIsTiketIsNull() {
            addCriterion("is_tiket is null");
            return this;


        }

        public Criteria andIsTiketIsNotNull() {
            addCriterion("is_tiket is not null");
            return this;


        }

        public Criteria andIsTiketEqualTo(Integer value) {
            addCriterion("is_tiket =", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketNotEqualTo(Integer value) {
            addCriterion("is_tiket <>", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketGreaterThan(Integer value) {
            addCriterion("is_tiket >", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_tiket >=", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketLessThan(Integer value) {
            addCriterion("is_tiket <", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketLessThanOrEqualTo(Integer value) {
            addCriterion("is_tiket <=", value, "isTiket");
            return this;


        }

        public Criteria andIsTiketIn(List values) {
            addCriterion("is_tiket in", values, "isTiket");
            return this;


        }

        public Criteria andIsTiketNotIn(List values) {
            addCriterion("is_tiket not in", values, "isTiket");
            return this;


        }

        public Criteria andIsTiketBetween(Integer value1, Integer value2) {
            addCriterion("is_tiket between", value1, value2, "isTiket");
            return this;


        }

        public Criteria andIsTiketNotBetween(Integer value1, Integer value2) {
            addCriterion("is_tiket not between", value1, value2, "isTiket");
            return this;


        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return this;


        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return this;


        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return this;


        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return this;


        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return this;


        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return this;


        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return this;


        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return this;


        }

        public Criteria andStartTimeIn(List values) {
            addCriterion("start_time in", values, "startTime");
            return this;


        }

        public Criteria andStartTimeNotIn(List values) {
            addCriterion("start_time not in", values, "startTime");
            return this;


        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return this;


        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return this;


        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return this;


        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return this;


        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return this;


        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return this;


        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return this;


        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return this;


        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return this;


        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return this;


        }

        public Criteria andEndTimeIn(List values) {
            addCriterion("end_time in", values, "endTime");
            return this;


        }

        public Criteria andEndTimeNotIn(List values) {
            addCriterion("end_time not in", values, "endTime");
            return this;


        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return this;


        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return this;


        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return this;


        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return this;


        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return this;


        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return this;


        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return this;


        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return this;


        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return this;


        }

        public Criteria andCreateUserIn(List values) {
            addCriterion("create_user in", values, "createUser");
            return this;


        }

        public Criteria andCreateUserNotIn(List values) {
            addCriterion("create_user not in", values, "createUser");
            return this;


        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return this;


        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return this;


        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return this;


        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return this;


        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return this;


        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return this;


        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return this;


        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return this;


        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return this;


        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return this;


        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return this;


        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return this;


        }

        public Criteria andLinkIn(List values) {
            addCriterion("link in", values, "link");
            return this;


        }

        public Criteria andLinkNotIn(List values) {
            addCriterion("link not in", values, "link");
            return this;


        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return this;


        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return this;


        }

        public Criteria andRuleIsNull() {
            addCriterion("rule is null");
            return this;


        }

        public Criteria andRuleIsNotNull() {
            addCriterion("rule is not null");
            return this;


        }

        public Criteria andRuleEqualTo(String value) {
            addCriterion("rule =", value, "rule");
            return this;


        }

        public Criteria andRuleNotEqualTo(String value) {
            addCriterion("rule <>", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThan(String value) {
            addCriterion("rule >", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThanOrEqualTo(String value) {
            addCriterion("rule >=", value, "rule");
            return this;


        }

        public Criteria andRuleLessThan(String value) {
            addCriterion("rule <", value, "rule");
            return this;


        }

        public Criteria andRuleLessThanOrEqualTo(String value) {
            addCriterion("rule <=", value, "rule");
            return this;


        }

        public Criteria andRuleLike(String value) {
            addCriterion("rule like", value, "rule");
            return this;


        }

        public Criteria andRuleNotLike(String value) {
            addCriterion("rule not like", value, "rule");
            return this;


        }

        public Criteria andRuleIn(List values) {
            addCriterion("rule in", values, "rule");
            return this;


        }

        public Criteria andRuleNotIn(List values) {
            addCriterion("rule not in", values, "rule");
            return this;


        }

        public Criteria andRuleBetween(String value1, String value2) {
            addCriterion("rule between", value1, value2, "rule");
            return this;


        }

        public Criteria andRuleNotBetween(String value1, String value2) {
            addCriterion("rule not between", value1, value2, "rule");
            return this;


        }

        public Criteria andMinAmountIsNull() {
            addCriterion("min_amount is null");
            return this;


        }

        public Criteria andMinAmountIsNotNull() {
            addCriterion("min_amount is not null");
            return this;


        }

        public Criteria andMinAmountEqualTo(BigDecimal value) {
            addCriterion("min_amount =", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountNotEqualTo(BigDecimal value) {
            addCriterion("min_amount <>", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountGreaterThan(BigDecimal value) {
            addCriterion("min_amount >", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_amount >=", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountLessThan(BigDecimal value) {
            addCriterion("min_amount <", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_amount <=", value, "minAmount");
            return this;


        }

        public Criteria andMinAmountIn(List values) {
            addCriterion("min_amount in", values, "minAmount");
            return this;


        }

        public Criteria andMinAmountNotIn(List values) {
            addCriterion("min_amount not in", values, "minAmount");
            return this;


        }

        public Criteria andMinAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_amount between", value1, value2, "minAmount");
            return this;


        }

        public Criteria andMinAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_amount not between", value1, value2, "minAmount");
            return this;


        }

        public Criteria andMaxAmountIsNull() {
            addCriterion("max_amount is null");
            return this;


        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("max_amount is not null");
            return this;


        }

        public Criteria andMaxAmountEqualTo(BigDecimal value) {
            addCriterion("max_amount =", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("max_amount <>", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("max_amount >", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount >=", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountLessThan(BigDecimal value) {
            addCriterion("max_amount <", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount <=", value, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountIn(List values) {
            addCriterion("max_amount in", values, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountNotIn(List values) {
            addCriterion("max_amount not in", values, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount between", value1, value2, "maxAmount");
            return this;


        }

        public Criteria andMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount not between", value1, value2, "maxAmount");
            return this;


        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return this;


        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return this;


        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return this;


        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return this;


        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return this;


        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return this;


        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return this;


        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return this;


        }

        public Criteria andAmountIn(List values) {
            addCriterion("amount in", values, "amount");
            return this;


        }

        public Criteria andAmountNotIn(List values) {
            addCriterion("amount not in", values, "amount");
            return this;


        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return this;


        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return this;


        }


    }


}
