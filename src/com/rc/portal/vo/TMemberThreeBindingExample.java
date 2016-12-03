package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberThreeBindingExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberThreeBindingExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberThreeBindingExample(TMemberThreeBindingExample example) {
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

        public Criteria andBindingUuidIsNull() {
            addCriterion("binding_uuid is null");
            return this;


        }

        public Criteria andBindingUuidIsNotNull() {
            addCriterion("binding_uuid is not null");
            return this;


        }

        public Criteria andBindingUuidEqualTo(String value) {
            addCriterion("binding_uuid =", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidNotEqualTo(String value) {
            addCriterion("binding_uuid <>", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidGreaterThan(String value) {
            addCriterion("binding_uuid >", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidGreaterThanOrEqualTo(String value) {
            addCriterion("binding_uuid >=", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidLessThan(String value) {
            addCriterion("binding_uuid <", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidLessThanOrEqualTo(String value) {
            addCriterion("binding_uuid <=", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidLike(String value) {
            addCriterion("binding_uuid like", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidNotLike(String value) {
            addCriterion("binding_uuid not like", value, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidIn(List values) {
            addCriterion("binding_uuid in", values, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidNotIn(List values) {
            addCriterion("binding_uuid not in", values, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidBetween(String value1, String value2) {
            addCriterion("binding_uuid between", value1, value2, "bindingUuid");
            return this;


        }

        public Criteria andBindingUuidNotBetween(String value1, String value2) {
            addCriterion("binding_uuid not between", value1, value2, "bindingUuid");
            return this;


        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return this;


        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return this;


        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return this;


        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return this;


        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return this;


        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return this;


        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return this;


        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return this;


        }

        public Criteria andSourceIn(List values) {
            addCriterion("source in", values, "source");
            return this;


        }

        public Criteria andSourceNotIn(List values) {
            addCriterion("source not in", values, "source");
            return this;


        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return this;


        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
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

        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return this;


        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return this;


        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidIn(List values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidNotIn(List values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return this;


        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
            return this;


        }

        public Criteria andWxAppidIsNull() {
            addCriterion("wx_appid is null");
            return this;


        }

        public Criteria andWxAppidIsNotNull() {
            addCriterion("wx_appid is not null");
            return this;


        }

        public Criteria andWxAppidEqualTo(String value) {
            addCriterion("wx_appid =", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidNotEqualTo(String value) {
            addCriterion("wx_appid <>", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidGreaterThan(String value) {
            addCriterion("wx_appid >", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_appid >=", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidLessThan(String value) {
            addCriterion("wx_appid <", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidLessThanOrEqualTo(String value) {
            addCriterion("wx_appid <=", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidLike(String value) {
            addCriterion("wx_appid like", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidNotLike(String value) {
            addCriterion("wx_appid not like", value, "wxAppid");
            return this;


        }

        public Criteria andWxAppidIn(List values) {
            addCriterion("wx_appid in", values, "wxAppid");
            return this;


        }

        public Criteria andWxAppidNotIn(List values) {
            addCriterion("wx_appid not in", values, "wxAppid");
            return this;


        }

        public Criteria andWxAppidBetween(String value1, String value2) {
            addCriterion("wx_appid between", value1, value2, "wxAppid");
            return this;


        }

        public Criteria andWxAppidNotBetween(String value1, String value2) {
            addCriterion("wx_appid not between", value1, value2, "wxAppid");
            return this;


        }


    }


}
