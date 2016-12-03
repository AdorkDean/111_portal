package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberBaseMessageExtExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberBaseMessageExtExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberBaseMessageExtExample(TMemberBaseMessageExtExample example) {
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

        public Criteria andBillEmailIsNull() {
            addCriterion("bill_email is null");
            return this;


        }

        public Criteria andBillEmailIsNotNull() {
            addCriterion("bill_email is not null");
            return this;


        }

        public Criteria andBillEmailEqualTo(String value) {
            addCriterion("bill_email =", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailNotEqualTo(String value) {
            addCriterion("bill_email <>", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailGreaterThan(String value) {
            addCriterion("bill_email >", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailGreaterThanOrEqualTo(String value) {
            addCriterion("bill_email >=", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailLessThan(String value) {
            addCriterion("bill_email <", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailLessThanOrEqualTo(String value) {
            addCriterion("bill_email <=", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailLike(String value) {
            addCriterion("bill_email like", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailNotLike(String value) {
            addCriterion("bill_email not like", value, "billEmail");
            return this;


        }

        public Criteria andBillEmailIn(List values) {
            addCriterion("bill_email in", values, "billEmail");
            return this;


        }

        public Criteria andBillEmailNotIn(List values) {
            addCriterion("bill_email not in", values, "billEmail");
            return this;


        }

        public Criteria andBillEmailBetween(String value1, String value2) {
            addCriterion("bill_email between", value1, value2, "billEmail");
            return this;


        }

        public Criteria andBillEmailNotBetween(String value1, String value2) {
            addCriterion("bill_email not between", value1, value2, "billEmail");
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

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return this;


        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return this;


        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return this;


        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return this;


        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return this;


        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return this;


        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return this;


        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return this;


        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return this;


        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return this;


        }

        public Criteria andNationalityIn(List values) {
            addCriterion("nationality in", values, "nationality");
            return this;


        }

        public Criteria andNationalityNotIn(List values) {
            addCriterion("nationality not in", values, "nationality");
            return this;


        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return this;


        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
            return this;


        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return this;


        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return this;


        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return this;


        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return this;


        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return this;


        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return this;


        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return this;


        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return this;


        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return this;


        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return this;


        }

        public Criteria andNationIn(List values) {
            addCriterion("nation in", values, "nation");
            return this;


        }

        public Criteria andNationNotIn(List values) {
            addCriterion("nation not in", values, "nation");
            return this;


        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return this;


        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return this;


        }

        public Criteria andIsMarryIsNull() {
            addCriterion("is_marry is null");
            return this;


        }

        public Criteria andIsMarryIsNotNull() {
            addCriterion("is_marry is not null");
            return this;


        }

        public Criteria andIsMarryEqualTo(Integer value) {
            addCriterion("is_marry =", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryNotEqualTo(Integer value) {
            addCriterion("is_marry <>", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryGreaterThan(Integer value) {
            addCriterion("is_marry >", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_marry >=", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryLessThan(Integer value) {
            addCriterion("is_marry <", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryLessThanOrEqualTo(Integer value) {
            addCriterion("is_marry <=", value, "isMarry");
            return this;


        }

        public Criteria andIsMarryIn(List values) {
            addCriterion("is_marry in", values, "isMarry");
            return this;


        }

        public Criteria andIsMarryNotIn(List values) {
            addCriterion("is_marry not in", values, "isMarry");
            return this;


        }

        public Criteria andIsMarryBetween(Integer value1, Integer value2) {
            addCriterion("is_marry between", value1, value2, "isMarry");
            return this;


        }

        public Criteria andIsMarryNotBetween(Integer value1, Integer value2) {
            addCriterion("is_marry not between", value1, value2, "isMarry");
            return this;


        }

        public Criteria andFamilyMemberIsNull() {
            addCriterion("family_member is null");
            return this;


        }

        public Criteria andFamilyMemberIsNotNull() {
            addCriterion("family_member is not null");
            return this;


        }

        public Criteria andFamilyMemberEqualTo(Integer value) {
            addCriterion("family_member =", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberNotEqualTo(Integer value) {
            addCriterion("family_member <>", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberGreaterThan(Integer value) {
            addCriterion("family_member >", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_member >=", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberLessThan(Integer value) {
            addCriterion("family_member <", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberLessThanOrEqualTo(Integer value) {
            addCriterion("family_member <=", value, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberIn(List values) {
            addCriterion("family_member in", values, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberNotIn(List values) {
            addCriterion("family_member not in", values, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberBetween(Integer value1, Integer value2) {
            addCriterion("family_member between", value1, value2, "familyMember");
            return this;


        }

        public Criteria andFamilyMemberNotBetween(Integer value1, Integer value2) {
            addCriterion("family_member not between", value1, value2, "familyMember");
            return this;


        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return this;


        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return this;


        }

        public Criteria andIdentityEqualTo(Integer value) {
            addCriterion("identity =", value, "identity");
            return this;


        }

        public Criteria andIdentityNotEqualTo(Integer value) {
            addCriterion("identity <>", value, "identity");
            return this;


        }

        public Criteria andIdentityGreaterThan(Integer value) {
            addCriterion("identity >", value, "identity");
            return this;


        }

        public Criteria andIdentityGreaterThanOrEqualTo(Integer value) {
            addCriterion("identity >=", value, "identity");
            return this;


        }

        public Criteria andIdentityLessThan(Integer value) {
            addCriterion("identity <", value, "identity");
            return this;


        }

        public Criteria andIdentityLessThanOrEqualTo(Integer value) {
            addCriterion("identity <=", value, "identity");
            return this;


        }

        public Criteria andIdentityIn(List values) {
            addCriterion("identity in", values, "identity");
            return this;


        }

        public Criteria andIdentityNotIn(List values) {
            addCriterion("identity not in", values, "identity");
            return this;


        }

        public Criteria andIdentityBetween(Integer value1, Integer value2) {
            addCriterion("identity between", value1, value2, "identity");
            return this;


        }

        public Criteria andIdentityNotBetween(Integer value1, Integer value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return this;


        }

        public Criteria andLiveStatusIsNull() {
            addCriterion("live_status is null");
            return this;


        }

        public Criteria andLiveStatusIsNotNull() {
            addCriterion("live_status is not null");
            return this;


        }

        public Criteria andLiveStatusEqualTo(String value) {
            addCriterion("live_status =", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusNotEqualTo(String value) {
            addCriterion("live_status <>", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusGreaterThan(String value) {
            addCriterion("live_status >", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("live_status >=", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusLessThan(String value) {
            addCriterion("live_status <", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusLessThanOrEqualTo(String value) {
            addCriterion("live_status <=", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusLike(String value) {
            addCriterion("live_status like", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusNotLike(String value) {
            addCriterion("live_status not like", value, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusIn(List values) {
            addCriterion("live_status in", values, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusNotIn(List values) {
            addCriterion("live_status not in", values, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusBetween(String value1, String value2) {
            addCriterion("live_status between", value1, value2, "liveStatus");
            return this;


        }

        public Criteria andLiveStatusNotBetween(String value1, String value2) {
            addCriterion("live_status not between", value1, value2, "liveStatus");
            return this;


        }

        public Criteria andPersonalIncomeIsNull() {
            addCriterion("personal_income is null");
            return this;


        }

        public Criteria andPersonalIncomeIsNotNull() {
            addCriterion("personal_income is not null");
            return this;


        }

        public Criteria andPersonalIncomeEqualTo(Integer value) {
            addCriterion("personal_income =", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeNotEqualTo(Integer value) {
            addCriterion("personal_income <>", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeGreaterThan(Integer value) {
            addCriterion("personal_income >", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_income >=", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeLessThan(Integer value) {
            addCriterion("personal_income <", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("personal_income <=", value, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeIn(List values) {
            addCriterion("personal_income in", values, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeNotIn(List values) {
            addCriterion("personal_income not in", values, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeBetween(Integer value1, Integer value2) {
            addCriterion("personal_income between", value1, value2, "personalIncome");
            return this;


        }

        public Criteria andPersonalIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_income not between", value1, value2, "personalIncome");
            return this;


        }

        public Criteria andChildAgeIsNull() {
            addCriterion("child_age is null");
            return this;


        }

        public Criteria andChildAgeIsNotNull() {
            addCriterion("child_age is not null");
            return this;


        }

        public Criteria andChildAgeEqualTo(String value) {
            addCriterion("child_age =", value, "childAge");
            return this;


        }

        public Criteria andChildAgeNotEqualTo(String value) {
            addCriterion("child_age <>", value, "childAge");
            return this;


        }

        public Criteria andChildAgeGreaterThan(String value) {
            addCriterion("child_age >", value, "childAge");
            return this;


        }

        public Criteria andChildAgeGreaterThanOrEqualTo(String value) {
            addCriterion("child_age >=", value, "childAge");
            return this;


        }

        public Criteria andChildAgeLessThan(String value) {
            addCriterion("child_age <", value, "childAge");
            return this;


        }

        public Criteria andChildAgeLessThanOrEqualTo(String value) {
            addCriterion("child_age <=", value, "childAge");
            return this;


        }

        public Criteria andChildAgeLike(String value) {
            addCriterion("child_age like", value, "childAge");
            return this;


        }

        public Criteria andChildAgeNotLike(String value) {
            addCriterion("child_age not like", value, "childAge");
            return this;


        }

        public Criteria andChildAgeIn(List values) {
            addCriterion("child_age in", values, "childAge");
            return this;


        }

        public Criteria andChildAgeNotIn(List values) {
            addCriterion("child_age not in", values, "childAge");
            return this;


        }

        public Criteria andChildAgeBetween(String value1, String value2) {
            addCriterion("child_age between", value1, value2, "childAge");
            return this;


        }

        public Criteria andChildAgeNotBetween(String value1, String value2) {
            addCriterion("child_age not between", value1, value2, "childAge");
            return this;


        }

        public Criteria andIsCartIsNull() {
            addCriterion("is_cart is null");
            return this;


        }

        public Criteria andIsCartIsNotNull() {
            addCriterion("is_cart is not null");
            return this;


        }

        public Criteria andIsCartEqualTo(Integer value) {
            addCriterion("is_cart =", value, "isCart");
            return this;


        }

        public Criteria andIsCartNotEqualTo(Integer value) {
            addCriterion("is_cart <>", value, "isCart");
            return this;


        }

        public Criteria andIsCartGreaterThan(Integer value) {
            addCriterion("is_cart >", value, "isCart");
            return this;


        }

        public Criteria andIsCartGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cart >=", value, "isCart");
            return this;


        }

        public Criteria andIsCartLessThan(Integer value) {
            addCriterion("is_cart <", value, "isCart");
            return this;


        }

        public Criteria andIsCartLessThanOrEqualTo(Integer value) {
            addCriterion("is_cart <=", value, "isCart");
            return this;


        }

        public Criteria andIsCartIn(List values) {
            addCriterion("is_cart in", values, "isCart");
            return this;


        }

        public Criteria andIsCartNotIn(List values) {
            addCriterion("is_cart not in", values, "isCart");
            return this;


        }

        public Criteria andIsCartBetween(Integer value1, Integer value2) {
            addCriterion("is_cart between", value1, value2, "isCart");
            return this;


        }

        public Criteria andIsCartNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cart not between", value1, value2, "isCart");
            return this;


        }

        public Criteria andPlaceOriginIsNull() {
            addCriterion("place_origin is null");
            return this;


        }

        public Criteria andPlaceOriginIsNotNull() {
            addCriterion("place_origin is not null");
            return this;


        }

        public Criteria andPlaceOriginEqualTo(String value) {
            addCriterion("place_origin =", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginNotEqualTo(String value) {
            addCriterion("place_origin <>", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginGreaterThan(String value) {
            addCriterion("place_origin >", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginGreaterThanOrEqualTo(String value) {
            addCriterion("place_origin >=", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginLessThan(String value) {
            addCriterion("place_origin <", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginLessThanOrEqualTo(String value) {
            addCriterion("place_origin <=", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginLike(String value) {
            addCriterion("place_origin like", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginNotLike(String value) {
            addCriterion("place_origin not like", value, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginIn(List values) {
            addCriterion("place_origin in", values, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginNotIn(List values) {
            addCriterion("place_origin not in", values, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginBetween(String value1, String value2) {
            addCriterion("place_origin between", value1, value2, "placeOrigin");
            return this;


        }

        public Criteria andPlaceOriginNotBetween(String value1, String value2) {
            addCriterion("place_origin not between", value1, value2, "placeOrigin");
            return this;


        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return this;


        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return this;


        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return this;


        }

        public Criteria andCompanyNameIn(List values) {
            addCriterion("company_name in", values, "companyName");
            return this;


        }

        public Criteria andCompanyNameNotIn(List values) {
            addCriterion("company_name not in", values, "companyName");
            return this;


        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return this;


        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return this;


        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return this;


        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return this;


        }

        public Criteria andIndustryEqualTo(Integer value) {
            addCriterion("industry =", value, "industry");
            return this;


        }

        public Criteria andIndustryNotEqualTo(Integer value) {
            addCriterion("industry <>", value, "industry");
            return this;


        }

        public Criteria andIndustryGreaterThan(Integer value) {
            addCriterion("industry >", value, "industry");
            return this;


        }

        public Criteria andIndustryGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry >=", value, "industry");
            return this;


        }

        public Criteria andIndustryLessThan(Integer value) {
            addCriterion("industry <", value, "industry");
            return this;


        }

        public Criteria andIndustryLessThanOrEqualTo(Integer value) {
            addCriterion("industry <=", value, "industry");
            return this;


        }

        public Criteria andIndustryIn(List values) {
            addCriterion("industry in", values, "industry");
            return this;


        }

        public Criteria andIndustryNotIn(List values) {
            addCriterion("industry not in", values, "industry");
            return this;


        }

        public Criteria andIndustryBetween(Integer value1, Integer value2) {
            addCriterion("industry between", value1, value2, "industry");
            return this;


        }

        public Criteria andIndustryNotBetween(Integer value1, Integer value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return this;


        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return this;


        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return this;


        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return this;


        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return this;


        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return this;


        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return this;


        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return this;


        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return this;


        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return this;


        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return this;


        }

        public Criteria andPositionIn(List values) {
            addCriterion("position in", values, "position");
            return this;


        }

        public Criteria andPositionNotIn(List values) {
            addCriterion("position not in", values, "position");
            return this;


        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return this;


        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return this;


        }

        public Criteria andWorkYearIsNull() {
            addCriterion("work_year is null");
            return this;


        }

        public Criteria andWorkYearIsNotNull() {
            addCriterion("work_year is not null");
            return this;


        }

        public Criteria andWorkYearEqualTo(Integer value) {
            addCriterion("work_year =", value, "workYear");
            return this;


        }

        public Criteria andWorkYearNotEqualTo(Integer value) {
            addCriterion("work_year <>", value, "workYear");
            return this;


        }

        public Criteria andWorkYearGreaterThan(Integer value) {
            addCriterion("work_year >", value, "workYear");
            return this;


        }

        public Criteria andWorkYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_year >=", value, "workYear");
            return this;


        }

        public Criteria andWorkYearLessThan(Integer value) {
            addCriterion("work_year <", value, "workYear");
            return this;


        }

        public Criteria andWorkYearLessThanOrEqualTo(Integer value) {
            addCriterion("work_year <=", value, "workYear");
            return this;


        }

        public Criteria andWorkYearIn(List values) {
            addCriterion("work_year in", values, "workYear");
            return this;


        }

        public Criteria andWorkYearNotIn(List values) {
            addCriterion("work_year not in", values, "workYear");
            return this;


        }

        public Criteria andWorkYearBetween(Integer value1, Integer value2) {
            addCriterion("work_year between", value1, value2, "workYear");
            return this;


        }

        public Criteria andWorkYearNotBetween(Integer value1, Integer value2) {
            addCriterion("work_year not between", value1, value2, "workYear");
            return this;


        }

        public Criteria andDiplomaIsNull() {
            addCriterion("diploma is null");
            return this;


        }

        public Criteria andDiplomaIsNotNull() {
            addCriterion("diploma is not null");
            return this;


        }

        public Criteria andDiplomaEqualTo(Integer value) {
            addCriterion("diploma =", value, "diploma");
            return this;


        }

        public Criteria andDiplomaNotEqualTo(Integer value) {
            addCriterion("diploma <>", value, "diploma");
            return this;


        }

        public Criteria andDiplomaGreaterThan(Integer value) {
            addCriterion("diploma >", value, "diploma");
            return this;


        }

        public Criteria andDiplomaGreaterThanOrEqualTo(Integer value) {
            addCriterion("diploma >=", value, "diploma");
            return this;


        }

        public Criteria andDiplomaLessThan(Integer value) {
            addCriterion("diploma <", value, "diploma");
            return this;


        }

        public Criteria andDiplomaLessThanOrEqualTo(Integer value) {
            addCriterion("diploma <=", value, "diploma");
            return this;


        }

        public Criteria andDiplomaIn(List values) {
            addCriterion("diploma in", values, "diploma");
            return this;


        }

        public Criteria andDiplomaNotIn(List values) {
            addCriterion("diploma not in", values, "diploma");
            return this;


        }

        public Criteria andDiplomaBetween(Integer value1, Integer value2) {
            addCriterion("diploma between", value1, value2, "diploma");
            return this;


        }

        public Criteria andDiplomaNotBetween(Integer value1, Integer value2) {
            addCriterion("diploma not between", value1, value2, "diploma");
            return this;


        }

        public Criteria andGraduationSchoolIsNull() {
            addCriterion("graduation_school is null");
            return this;


        }

        public Criteria andGraduationSchoolIsNotNull() {
            addCriterion("graduation_school is not null");
            return this;


        }

        public Criteria andGraduationSchoolEqualTo(String value) {
            addCriterion("graduation_school =", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolNotEqualTo(String value) {
            addCriterion("graduation_school <>", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolGreaterThan(String value) {
            addCriterion("graduation_school >", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduation_school >=", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolLessThan(String value) {
            addCriterion("graduation_school <", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolLessThanOrEqualTo(String value) {
            addCriterion("graduation_school <=", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolLike(String value) {
            addCriterion("graduation_school like", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolNotLike(String value) {
            addCriterion("graduation_school not like", value, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolIn(List values) {
            addCriterion("graduation_school in", values, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolNotIn(List values) {
            addCriterion("graduation_school not in", values, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolBetween(String value1, String value2) {
            addCriterion("graduation_school between", value1, value2, "graduationSchool");
            return this;


        }

        public Criteria andGraduationSchoolNotBetween(String value1, String value2) {
            addCriterion("graduation_school not between", value1, value2, "graduationSchool");
            return this;


        }

        public Criteria andGraduationDtIsNull() {
            addCriterion("graduation_dt is null");
            return this;


        }

        public Criteria andGraduationDtIsNotNull() {
            addCriterion("graduation_dt is not null");
            return this;


        }

        public Criteria andGraduationDtEqualTo(String value) {
            addCriterion("graduation_dt =", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtNotEqualTo(String value) {
            addCriterion("graduation_dt <>", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtGreaterThan(String value) {
            addCriterion("graduation_dt >", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtGreaterThanOrEqualTo(String value) {
            addCriterion("graduation_dt >=", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtLessThan(String value) {
            addCriterion("graduation_dt <", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtLessThanOrEqualTo(String value) {
            addCriterion("graduation_dt <=", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtLike(String value) {
            addCriterion("graduation_dt like", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtNotLike(String value) {
            addCriterion("graduation_dt not like", value, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtIn(List values) {
            addCriterion("graduation_dt in", values, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtNotIn(List values) {
            addCriterion("graduation_dt not in", values, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtBetween(String value1, String value2) {
            addCriterion("graduation_dt between", value1, value2, "graduationDt");
            return this;


        }

        public Criteria andGraduationDtNotBetween(String value1, String value2) {
            addCriterion("graduation_dt not between", value1, value2, "graduationDt");
            return this;


        }


    }


}
