package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberExample(TMemberExample example) {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return this;


        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return this;


        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return this;


        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return this;


        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return this;


        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return this;


        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return this;


        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return this;


        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return this;


        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return this;


        }

        public Criteria andUserNameIn(List values) {
            addCriterion("user_name in", values, "userName");
            return this;


        }

        public Criteria andUserNameNotIn(List values) {
            addCriterion("user_name not in", values, "userName");
            return this;


        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return this;


        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andMemberGradeIdIsNull() {
            addCriterion("member_grade_id is null");
            return this;


        }

        public Criteria andMemberGradeIdIsNotNull() {
            addCriterion("member_grade_id is not null");
            return this;


        }

        public Criteria andMemberGradeIdEqualTo(Long value) {
            addCriterion("member_grade_id =", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdNotEqualTo(Long value) {
            addCriterion("member_grade_id <>", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdGreaterThan(Long value) {
            addCriterion("member_grade_id >", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_grade_id >=", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdLessThan(Long value) {
            addCriterion("member_grade_id <", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("member_grade_id <=", value, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdIn(List values) {
            addCriterion("member_grade_id in", values, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdNotIn(List values) {
            addCriterion("member_grade_id not in", values, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdBetween(Long value1, Long value2) {
            addCriterion("member_grade_id between", value1, value2, "memberGradeId");
            return this;


        }

        public Criteria andMemberGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("member_grade_id not between", value1, value2, "memberGradeId");
            return this;


        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return this;


        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return this;


        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return this;


        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdIn(List values) {
            addCriterion("area_id in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdNotIn(List values) {
            addCriterion("area_id not in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return this;


        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return this;


        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return this;


        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return this;


        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return this;


        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return this;


        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return this;


        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return this;


        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return this;


        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return this;


        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return this;


        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return this;


        }

        public Criteria andEmailIn(List values) {
            addCriterion("email in", values, "email");
            return this;


        }

        public Criteria andEmailNotIn(List values) {
            addCriterion("email not in", values, "email");
            return this;


        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return this;


        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return this;


        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return this;


        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return this;


        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return this;


        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return this;


        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return this;


        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return this;


        }

        public Criteria andMobileIn(List values) {
            addCriterion("mobile in", values, "mobile");
            return this;


        }

        public Criteria andMobileNotIn(List values) {
            addCriterion("mobile not in", values, "mobile");
            return this;


        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return this;


        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return this;


        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return this;


        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return this;


        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return this;


        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return this;


        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return this;


        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return this;


        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return this;


        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return this;


        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return this;


        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return this;


        }

        public Criteria andPhoneIn(List values) {
            addCriterion("phone in", values, "phone");
            return this;


        }

        public Criteria andPhoneNotIn(List values) {
            addCriterion("phone not in", values, "phone");
            return this;


        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return this;


        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return this;


        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return this;


        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return this;


        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return this;


        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return this;


        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return this;


        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return this;


        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return this;


        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return this;


        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return this;


        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return this;


        }

        public Criteria andRealNameIn(List values) {
            addCriterion("real_name in", values, "realName");
            return this;


        }

        public Criteria andRealNameNotIn(List values) {
            addCriterion("real_name not in", values, "realName");
            return this;


        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return this;


        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return this;


        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return this;


        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return this;


        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return this;


        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return this;


        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return this;


        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return this;


        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return this;


        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return this;


        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return this;


        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return this;


        }

        public Criteria andNickNameIn(List values) {
            addCriterion("nick_name in", values, "nickName");
            return this;


        }

        public Criteria andNickNameNotIn(List values) {
            addCriterion("nick_name not in", values, "nickName");
            return this;


        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return this;


        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return this;


        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return this;


        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return this;


        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return this;


        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return this;


        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return this;


        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return this;


        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return this;


        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return this;


        }

        public Criteria andSexIn(List values) {
            addCriterion("sex in", values, "sex");
            return this;


        }

        public Criteria andSexNotIn(List values) {
            addCriterion("sex not in", values, "sex");
            return this;


        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return this;


        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return this;


        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return this;


        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return this;


        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return this;


        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return this;


        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return this;


        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return this;


        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return this;


        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return this;


        }

        public Criteria andBirthdayIn(List values) {
            addCriterion("birthday in", values, "birthday");
            return this;


        }

        public Criteria andBirthdayNotIn(List values) {
            addCriterion("birthday not in", values, "birthday");
            return this;


        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return this;


        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return this;


        }

        public Criteria andHeadPortraitIsNull() {
            addCriterion("head_portrait is null");
            return this;


        }

        public Criteria andHeadPortraitIsNotNull() {
            addCriterion("head_portrait is not null");
            return this;


        }

        public Criteria andHeadPortraitEqualTo(String value) {
            addCriterion("head_portrait =", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitNotEqualTo(String value) {
            addCriterion("head_portrait <>", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitGreaterThan(String value) {
            addCriterion("head_portrait >", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("head_portrait >=", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitLessThan(String value) {
            addCriterion("head_portrait <", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitLessThanOrEqualTo(String value) {
            addCriterion("head_portrait <=", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitLike(String value) {
            addCriterion("head_portrait like", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitNotLike(String value) {
            addCriterion("head_portrait not like", value, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitIn(List values) {
            addCriterion("head_portrait in", values, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitNotIn(List values) {
            addCriterion("head_portrait not in", values, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitBetween(String value1, String value2) {
            addCriterion("head_portrait between", value1, value2, "headPortrait");
            return this;


        }

        public Criteria andHeadPortraitNotBetween(String value1, String value2) {
            addCriterion("head_portrait not between", value1, value2, "headPortrait");
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

        public Criteria andIsEnterpriseIsNull() {
            addCriterion("is_enterprise is null");
            return this;


        }

        public Criteria andIsEnterpriseIsNotNull() {
            addCriterion("is_enterprise is not null");
            return this;


        }

        public Criteria andIsEnterpriseEqualTo(Integer value) {
            addCriterion("is_enterprise =", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseNotEqualTo(Integer value) {
            addCriterion("is_enterprise <>", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseGreaterThan(Integer value) {
            addCriterion("is_enterprise >", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enterprise >=", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseLessThan(Integer value) {
            addCriterion("is_enterprise <", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseLessThanOrEqualTo(Integer value) {
            addCriterion("is_enterprise <=", value, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseIn(List values) {
            addCriterion("is_enterprise in", values, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseNotIn(List values) {
            addCriterion("is_enterprise not in", values, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseBetween(Integer value1, Integer value2) {
            addCriterion("is_enterprise between", value1, value2, "isEnterprise");
            return this;


        }

        public Criteria andIsEnterpriseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enterprise not between", value1, value2, "isEnterprise");
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

        public Criteria andIsLeaderIsNull() {
            addCriterion("is_leader is null");
            return this;


        }

        public Criteria andIsLeaderIsNotNull() {
            addCriterion("is_leader is not null");
            return this;


        }

        public Criteria andIsLeaderEqualTo(Integer value) {
            addCriterion("is_leader =", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderNotEqualTo(Integer value) {
            addCriterion("is_leader <>", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderGreaterThan(Integer value) {
            addCriterion("is_leader >", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_leader >=", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderLessThan(Integer value) {
            addCriterion("is_leader <", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderLessThanOrEqualTo(Integer value) {
            addCriterion("is_leader <=", value, "isLeader");
            return this;


        }

        public Criteria andIsLeaderIn(List values) {
            addCriterion("is_leader in", values, "isLeader");
            return this;


        }

        public Criteria andIsLeaderNotIn(List values) {
            addCriterion("is_leader not in", values, "isLeader");
            return this;


        }

        public Criteria andIsLeaderBetween(Integer value1, Integer value2) {
            addCriterion("is_leader between", value1, value2, "isLeader");
            return this;


        }

        public Criteria andIsLeaderNotBetween(Integer value1, Integer value2) {
            addCriterion("is_leader not between", value1, value2, "isLeader");
            return this;


        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return this;


        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return this;


        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return this;


        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return this;


        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return this;


        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return this;


        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return this;


        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return this;


        }

        public Criteria andIntegralIn(List values) {
            addCriterion("integral in", values, "integral");
            return this;


        }

        public Criteria andIntegralNotIn(List values) {
            addCriterion("integral not in", values, "integral");
            return this;


        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return this;


        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return this;


        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return this;


        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return this;


        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("platform =", value, "platform");
            return this;


        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("platform <>", value, "platform");
            return this;


        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("platform >", value, "platform");
            return this;


        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform >=", value, "platform");
            return this;


        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("platform <", value, "platform");
            return this;


        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("platform <=", value, "platform");
            return this;


        }

        public Criteria andPlatformIn(List values) {
            addCriterion("platform in", values, "platform");
            return this;


        }

        public Criteria andPlatformNotIn(List values) {
            addCriterion("platform not in", values, "platform");
            return this;


        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("platform between", value1, value2, "platform");
            return this;


        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("platform not between", value1, value2, "platform");
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

        public Criteria andRegisterIpIsNull() {
            addCriterion("register_ip is null");
            return this;


        }

        public Criteria andRegisterIpIsNotNull() {
            addCriterion("register_ip is not null");
            return this;


        }

        public Criteria andRegisterIpEqualTo(String value) {
            addCriterion("register_ip =", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpNotEqualTo(String value) {
            addCriterion("register_ip <>", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpGreaterThan(String value) {
            addCriterion("register_ip >", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("register_ip >=", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpLessThan(String value) {
            addCriterion("register_ip <", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("register_ip <=", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpLike(String value) {
            addCriterion("register_ip like", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpNotLike(String value) {
            addCriterion("register_ip not like", value, "registerIp");
            return this;


        }

        public Criteria andRegisterIpIn(List values) {
            addCriterion("register_ip in", values, "registerIp");
            return this;


        }

        public Criteria andRegisterIpNotIn(List values) {
            addCriterion("register_ip not in", values, "registerIp");
            return this;


        }

        public Criteria andRegisterIpBetween(String value1, String value2) {
            addCriterion("register_ip between", value1, value2, "registerIp");
            return this;


        }

        public Criteria andRegisterIpNotBetween(String value1, String value2) {
            addCriterion("register_ip not between", value1, value2, "registerIp");
            return this;


        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return this;


        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return this;


        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterion("register_date =", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterion("register_date <>", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterion("register_date >", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("register_date >=", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterion("register_date <", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterion("register_date <=", value, "registerDate");
            return this;


        }

        public Criteria andRegisterDateIn(List values) {
            addCriterion("register_date in", values, "registerDate");
            return this;


        }

        public Criteria andRegisterDateNotIn(List values) {
            addCriterion("register_date not in", values, "registerDate");
            return this;


        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterion("register_date between", value1, value2, "registerDate");
            return this;


        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterion("register_date not between", value1, value2, "registerDate");
            return this;


        }

        public Criteria andLastDateIsNull() {
            addCriterion("last_date is null");
            return this;


        }

        public Criteria andLastDateIsNotNull() {
            addCriterion("last_date is not null");
            return this;


        }

        public Criteria andLastDateEqualTo(Date value) {
            addCriterion("last_date =", value, "lastDate");
            return this;


        }

        public Criteria andLastDateNotEqualTo(Date value) {
            addCriterion("last_date <>", value, "lastDate");
            return this;


        }

        public Criteria andLastDateGreaterThan(Date value) {
            addCriterion("last_date >", value, "lastDate");
            return this;


        }

        public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_date >=", value, "lastDate");
            return this;


        }

        public Criteria andLastDateLessThan(Date value) {
            addCriterion("last_date <", value, "lastDate");
            return this;


        }

        public Criteria andLastDateLessThanOrEqualTo(Date value) {
            addCriterion("last_date <=", value, "lastDate");
            return this;


        }

        public Criteria andLastDateIn(List values) {
            addCriterion("last_date in", values, "lastDate");
            return this;


        }

        public Criteria andLastDateNotIn(List values) {
            addCriterion("last_date not in", values, "lastDate");
            return this;


        }

        public Criteria andLastDateBetween(Date value1, Date value2) {
            addCriterion("last_date between", value1, value2, "lastDate");
            return this;


        }

        public Criteria andLastDateNotBetween(Date value1, Date value2) {
            addCriterion("last_date not between", value1, value2, "lastDate");
            return this;


        }

        public Criteria andLastIpIsNull() {
            addCriterion("last_ip is null");
            return this;


        }

        public Criteria andLastIpIsNotNull() {
            addCriterion("last_ip is not null");
            return this;


        }

        public Criteria andLastIpEqualTo(String value) {
            addCriterion("last_ip =", value, "lastIp");
            return this;


        }

        public Criteria andLastIpNotEqualTo(String value) {
            addCriterion("last_ip <>", value, "lastIp");
            return this;


        }

        public Criteria andLastIpGreaterThan(String value) {
            addCriterion("last_ip >", value, "lastIp");
            return this;


        }

        public Criteria andLastIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_ip >=", value, "lastIp");
            return this;


        }

        public Criteria andLastIpLessThan(String value) {
            addCriterion("last_ip <", value, "lastIp");
            return this;


        }

        public Criteria andLastIpLessThanOrEqualTo(String value) {
            addCriterion("last_ip <=", value, "lastIp");
            return this;


        }

        public Criteria andLastIpLike(String value) {
            addCriterion("last_ip like", value, "lastIp");
            return this;


        }

        public Criteria andLastIpNotLike(String value) {
            addCriterion("last_ip not like", value, "lastIp");
            return this;


        }

        public Criteria andLastIpIn(List values) {
            addCriterion("last_ip in", values, "lastIp");
            return this;


        }

        public Criteria andLastIpNotIn(List values) {
            addCriterion("last_ip not in", values, "lastIp");
            return this;


        }

        public Criteria andLastIpBetween(String value1, String value2) {
            addCriterion("last_ip between", value1, value2, "lastIp");
            return this;


        }

        public Criteria andLastIpNotBetween(String value1, String value2) {
            addCriterion("last_ip not between", value1, value2, "lastIp");
            return this;


        }

        public Criteria andIsEmailCheckIsNull() {
            addCriterion("is_email_check is null");
            return this;


        }

        public Criteria andIsEmailCheckIsNotNull() {
            addCriterion("is_email_check is not null");
            return this;


        }

        public Criteria andIsEmailCheckEqualTo(Integer value) {
            addCriterion("is_email_check =", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckNotEqualTo(Integer value) {
            addCriterion("is_email_check <>", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckGreaterThan(Integer value) {
            addCriterion("is_email_check >", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_email_check >=", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckLessThan(Integer value) {
            addCriterion("is_email_check <", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_email_check <=", value, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckIn(List values) {
            addCriterion("is_email_check in", values, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckNotIn(List values) {
            addCriterion("is_email_check not in", values, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_email_check between", value1, value2, "isEmailCheck");
            return this;


        }

        public Criteria andIsEmailCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_email_check not between", value1, value2, "isEmailCheck");
            return this;


        }

        public Criteria andIsMobileCheckIsNull() {
            addCriterion("is_mobile_check is null");
            return this;


        }

        public Criteria andIsMobileCheckIsNotNull() {
            addCriterion("is_mobile_check is not null");
            return this;


        }

        public Criteria andIsMobileCheckEqualTo(Integer value) {
            addCriterion("is_mobile_check =", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckNotEqualTo(Integer value) {
            addCriterion("is_mobile_check <>", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckGreaterThan(Integer value) {
            addCriterion("is_mobile_check >", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mobile_check >=", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckLessThan(Integer value) {
            addCriterion("is_mobile_check <", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_mobile_check <=", value, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckIn(List values) {
            addCriterion("is_mobile_check in", values, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckNotIn(List values) {
            addCriterion("is_mobile_check not in", values, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_mobile_check between", value1, value2, "isMobileCheck");
            return this;


        }

        public Criteria andIsMobileCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mobile_check not between", value1, value2, "isMobileCheck");
            return this;


        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return this;


        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return this;


        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return this;


        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return this;


        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return this;


        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return this;


        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return this;


        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return this;


        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return this;


        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return this;


        }

        public Criteria andAreaIn(List values) {
            addCriterion("area in", values, "area");
            return this;


        }

        public Criteria andAreaNotIn(List values) {
            addCriterion("area not in", values, "area");
            return this;


        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return this;


        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return this;


        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return this;


        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return this;


        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return this;


        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return this;


        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return this;


        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return this;


        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return this;


        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return this;


        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return this;


        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return this;


        }

        public Criteria andAddressIn(List values) {
            addCriterion("address in", values, "address");
            return this;


        }

        public Criteria andAddressNotIn(List values) {
            addCriterion("address not in", values, "address");
            return this;


        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return this;


        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return this;


        }

        public Criteria andBloodTypeIsNull() {
            addCriterion("blood_type is null");
            return this;


        }

        public Criteria andBloodTypeIsNotNull() {
            addCriterion("blood_type is not null");
            return this;


        }

        public Criteria andBloodTypeEqualTo(String value) {
            addCriterion("blood_type =", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeNotEqualTo(String value) {
            addCriterion("blood_type <>", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeGreaterThan(String value) {
            addCriterion("blood_type >", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("blood_type >=", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeLessThan(String value) {
            addCriterion("blood_type <", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeLessThanOrEqualTo(String value) {
            addCriterion("blood_type <=", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeLike(String value) {
            addCriterion("blood_type like", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeNotLike(String value) {
            addCriterion("blood_type not like", value, "bloodType");
            return this;


        }

        public Criteria andBloodTypeIn(List values) {
            addCriterion("blood_type in", values, "bloodType");
            return this;


        }

        public Criteria andBloodTypeNotIn(List values) {
            addCriterion("blood_type not in", values, "bloodType");
            return this;


        }

        public Criteria andBloodTypeBetween(String value1, String value2) {
            addCriterion("blood_type between", value1, value2, "bloodType");
            return this;


        }

        public Criteria andBloodTypeNotBetween(String value1, String value2) {
            addCriterion("blood_type not between", value1, value2, "bloodType");
            return this;


        }

        public Criteria andAccumulateIntegralIsNull() {
            addCriterion("accumulate_integral is null");
            return this;


        }

        public Criteria andAccumulateIntegralIsNotNull() {
            addCriterion("accumulate_integral is not null");
            return this;


        }

        public Criteria andAccumulateIntegralEqualTo(Integer value) {
            addCriterion("accumulate_integral =", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralNotEqualTo(Integer value) {
            addCriterion("accumulate_integral <>", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralGreaterThan(Integer value) {
            addCriterion("accumulate_integral >", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("accumulate_integral >=", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralLessThan(Integer value) {
            addCriterion("accumulate_integral <", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("accumulate_integral <=", value, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralIn(List values) {
            addCriterion("accumulate_integral in", values, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralNotIn(List values) {
            addCriterion("accumulate_integral not in", values, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralBetween(Integer value1, Integer value2) {
            addCriterion("accumulate_integral between", value1, value2, "accumulateIntegral");
            return this;


        }

        public Criteria andAccumulateIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("accumulate_integral not between", value1, value2, "accumulateIntegral");
            return this;


        }

        public Criteria andHistoryIsNull() {
            addCriterion("history is null");
            return this;


        }

        public Criteria andHistoryIsNotNull() {
            addCriterion("history is not null");
            return this;


        }

        public Criteria andHistoryEqualTo(String value) {
            addCriterion("history =", value, "history");
            return this;


        }

        public Criteria andHistoryNotEqualTo(String value) {
            addCriterion("history <>", value, "history");
            return this;


        }

        public Criteria andHistoryGreaterThan(String value) {
            addCriterion("history >", value, "history");
            return this;


        }

        public Criteria andHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("history >=", value, "history");
            return this;


        }

        public Criteria andHistoryLessThan(String value) {
            addCriterion("history <", value, "history");
            return this;


        }

        public Criteria andHistoryLessThanOrEqualTo(String value) {
            addCriterion("history <=", value, "history");
            return this;


        }

        public Criteria andHistoryLike(String value) {
            addCriterion("history like", value, "history");
            return this;


        }

        public Criteria andHistoryNotLike(String value) {
            addCriterion("history not like", value, "history");
            return this;


        }

        public Criteria andHistoryIn(List values) {
            addCriterion("history in", values, "history");
            return this;


        }

        public Criteria andHistoryNotIn(List values) {
            addCriterion("history not in", values, "history");
            return this;


        }

        public Criteria andHistoryBetween(String value1, String value2) {
            addCriterion("history between", value1, value2, "history");
            return this;


        }

        public Criteria andHistoryNotBetween(String value1, String value2) {
            addCriterion("history not between", value1, value2, "history");
            return this;


        }

        public Criteria andAllergyIsNull() {
            addCriterion("allergy is null");
            return this;


        }

        public Criteria andAllergyIsNotNull() {
            addCriterion("allergy is not null");
            return this;


        }

        public Criteria andAllergyEqualTo(String value) {
            addCriterion("allergy =", value, "allergy");
            return this;


        }

        public Criteria andAllergyNotEqualTo(String value) {
            addCriterion("allergy <>", value, "allergy");
            return this;


        }

        public Criteria andAllergyGreaterThan(String value) {
            addCriterion("allergy >", value, "allergy");
            return this;


        }

        public Criteria andAllergyGreaterThanOrEqualTo(String value) {
            addCriterion("allergy >=", value, "allergy");
            return this;


        }

        public Criteria andAllergyLessThan(String value) {
            addCriterion("allergy <", value, "allergy");
            return this;


        }

        public Criteria andAllergyLessThanOrEqualTo(String value) {
            addCriterion("allergy <=", value, "allergy");
            return this;


        }

        public Criteria andAllergyLike(String value) {
            addCriterion("allergy like", value, "allergy");
            return this;


        }

        public Criteria andAllergyNotLike(String value) {
            addCriterion("allergy not like", value, "allergy");
            return this;


        }

        public Criteria andAllergyIn(List values) {
            addCriterion("allergy in", values, "allergy");
            return this;


        }

        public Criteria andAllergyNotIn(List values) {
            addCriterion("allergy not in", values, "allergy");
            return this;


        }

        public Criteria andAllergyBetween(String value1, String value2) {
            addCriterion("allergy between", value1, value2, "allergy");
            return this;


        }

        public Criteria andAllergyNotBetween(String value1, String value2) {
            addCriterion("allergy not between", value1, value2, "allergy");
            return this;


        }

        public Criteria andDrugIsNull() {
            addCriterion("drug is null");
            return this;


        }

        public Criteria andDrugIsNotNull() {
            addCriterion("drug is not null");
            return this;


        }

        public Criteria andDrugEqualTo(String value) {
            addCriterion("drug =", value, "drug");
            return this;


        }

        public Criteria andDrugNotEqualTo(String value) {
            addCriterion("drug <>", value, "drug");
            return this;


        }

        public Criteria andDrugGreaterThan(String value) {
            addCriterion("drug >", value, "drug");
            return this;


        }

        public Criteria andDrugGreaterThanOrEqualTo(String value) {
            addCriterion("drug >=", value, "drug");
            return this;


        }

        public Criteria andDrugLessThan(String value) {
            addCriterion("drug <", value, "drug");
            return this;


        }

        public Criteria andDrugLessThanOrEqualTo(String value) {
            addCriterion("drug <=", value, "drug");
            return this;


        }

        public Criteria andDrugLike(String value) {
            addCriterion("drug like", value, "drug");
            return this;


        }

        public Criteria andDrugNotLike(String value) {
            addCriterion("drug not like", value, "drug");
            return this;


        }

        public Criteria andDrugIn(List values) {
            addCriterion("drug in", values, "drug");
            return this;


        }

        public Criteria andDrugNotIn(List values) {
            addCriterion("drug not in", values, "drug");
            return this;


        }

        public Criteria andDrugBetween(String value1, String value2) {
            addCriterion("drug between", value1, value2, "drug");
            return this;


        }

        public Criteria andDrugNotBetween(String value1, String value2) {
            addCriterion("drug not between", value1, value2, "drug");
            return this;


        }

        public Criteria andMd5DataIsNull() {
            addCriterion("md5_data is null");
            return this;


        }

        public Criteria andMd5DataIsNotNull() {
            addCriterion("md5_data is not null");
            return this;


        }

        public Criteria andMd5DataEqualTo(String value) {
            addCriterion("md5_data =", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataNotEqualTo(String value) {
            addCriterion("md5_data <>", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataGreaterThan(String value) {
            addCriterion("md5_data >", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataGreaterThanOrEqualTo(String value) {
            addCriterion("md5_data >=", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataLessThan(String value) {
            addCriterion("md5_data <", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataLessThanOrEqualTo(String value) {
            addCriterion("md5_data <=", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataLike(String value) {
            addCriterion("md5_data like", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataNotLike(String value) {
            addCriterion("md5_data not like", value, "md5Data");
            return this;


        }

        public Criteria andMd5DataIn(List values) {
            addCriterion("md5_data in", values, "md5Data");
            return this;


        }

        public Criteria andMd5DataNotIn(List values) {
            addCriterion("md5_data not in", values, "md5Data");
            return this;


        }

        public Criteria andMd5DataBetween(String value1, String value2) {
            addCriterion("md5_data between", value1, value2, "md5Data");
            return this;


        }

        public Criteria andMd5DataNotBetween(String value1, String value2) {
            addCriterion("md5_data not between", value1, value2, "md5Data");
            return this;


        }

        public Criteria andIsAgentIsNull() {
            addCriterion("is_agent is null");
            return this;


        }

        public Criteria andIsAgentIsNotNull() {
            addCriterion("is_agent is not null");
            return this;


        }

        public Criteria andIsAgentEqualTo(Integer value) {
            addCriterion("is_agent =", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentNotEqualTo(Integer value) {
            addCriterion("is_agent <>", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentGreaterThan(Integer value) {
            addCriterion("is_agent >", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_agent >=", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentLessThan(Integer value) {
            addCriterion("is_agent <", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentLessThanOrEqualTo(Integer value) {
            addCriterion("is_agent <=", value, "isAgent");
            return this;


        }

        public Criteria andIsAgentIn(List values) {
            addCriterion("is_agent in", values, "isAgent");
            return this;


        }

        public Criteria andIsAgentNotIn(List values) {
            addCriterion("is_agent not in", values, "isAgent");
            return this;


        }

        public Criteria andIsAgentBetween(Integer value1, Integer value2) {
            addCriterion("is_agent between", value1, value2, "isAgent");
            return this;


        }

        public Criteria andIsAgentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_agent not between", value1, value2, "isAgent");
            return this;


        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return this;


        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return this;


        }

        public Criteria andAgentIdEqualTo(Long value) {
            addCriterion("agent_id =", value, "agentId");
            return this;


        }

        public Criteria andAgentIdNotEqualTo(Long value) {
            addCriterion("agent_id <>", value, "agentId");
            return this;


        }

        public Criteria andAgentIdGreaterThan(Long value) {
            addCriterion("agent_id >", value, "agentId");
            return this;


        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agent_id >=", value, "agentId");
            return this;


        }

        public Criteria andAgentIdLessThan(Long value) {
            addCriterion("agent_id <", value, "agentId");
            return this;


        }

        public Criteria andAgentIdLessThanOrEqualTo(Long value) {
            addCriterion("agent_id <=", value, "agentId");
            return this;


        }

        public Criteria andAgentIdIn(List values) {
            addCriterion("agent_id in", values, "agentId");
            return this;


        }

        public Criteria andAgentIdNotIn(List values) {
            addCriterion("agent_id not in", values, "agentId");
            return this;


        }

        public Criteria andAgentIdBetween(Long value1, Long value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return this;


        }

        public Criteria andAgentIdNotBetween(Long value1, Long value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return this;


        }


    }


}
