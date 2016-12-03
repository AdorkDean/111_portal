package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLeaderExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLeaderExample() {
        oredCriteria = new ArrayList();


    }

    protected TLeaderExample(TLeaderExample example) {
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

        public Criteria andWorkYearIsNull() {
            addCriterion("work_year is null");
            return this;


        }

        public Criteria andWorkYearIsNotNull() {
            addCriterion("work_year is not null");
            return this;


        }

        public Criteria andWorkYearEqualTo(String value) {
            addCriterion("work_year =", value, "workYear");
            return this;


        }

        public Criteria andWorkYearNotEqualTo(String value) {
            addCriterion("work_year <>", value, "workYear");
            return this;


        }

        public Criteria andWorkYearGreaterThan(String value) {
            addCriterion("work_year >", value, "workYear");
            return this;


        }

        public Criteria andWorkYearGreaterThanOrEqualTo(String value) {
            addCriterion("work_year >=", value, "workYear");
            return this;


        }

        public Criteria andWorkYearLessThan(String value) {
            addCriterion("work_year <", value, "workYear");
            return this;


        }

        public Criteria andWorkYearLessThanOrEqualTo(String value) {
            addCriterion("work_year <=", value, "workYear");
            return this;


        }

        public Criteria andWorkYearLike(String value) {
            addCriterion("work_year like", value, "workYear");
            return this;


        }

        public Criteria andWorkYearNotLike(String value) {
            addCriterion("work_year not like", value, "workYear");
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

        public Criteria andWorkYearBetween(String value1, String value2) {
            addCriterion("work_year between", value1, value2, "workYear");
            return this;


        }

        public Criteria andWorkYearNotBetween(String value1, String value2) {
            addCriterion("work_year not between", value1, value2, "workYear");
            return this;


        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return this;


        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return this;


        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return this;


        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return this;


        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return this;


        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return this;


        }

        public Criteria andRemarkIn(List values) {
            addCriterion("remark in", values, "remark");
            return this;


        }

        public Criteria andRemarkNotIn(List values) {
            addCriterion("remark not in", values, "remark");
            return this;


        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return this;


        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return this;


        }

        public Criteria andAuditTypeIsNull() {
            addCriterion("audit_type is null");
            return this;


        }

        public Criteria andAuditTypeIsNotNull() {
            addCriterion("audit_type is not null");
            return this;


        }

        public Criteria andAuditTypeEqualTo(Integer value) {
            addCriterion("audit_type =", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeNotEqualTo(Integer value) {
            addCriterion("audit_type <>", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeGreaterThan(Integer value) {
            addCriterion("audit_type >", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_type >=", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeLessThan(Integer value) {
            addCriterion("audit_type <", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeLessThanOrEqualTo(Integer value) {
            addCriterion("audit_type <=", value, "auditType");
            return this;


        }

        public Criteria andAuditTypeIn(List values) {
            addCriterion("audit_type in", values, "auditType");
            return this;


        }

        public Criteria andAuditTypeNotIn(List values) {
            addCriterion("audit_type not in", values, "auditType");
            return this;


        }

        public Criteria andAuditTypeBetween(Integer value1, Integer value2) {
            addCriterion("audit_type between", value1, value2, "auditType");
            return this;


        }

        public Criteria andAuditTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_type not between", value1, value2, "auditType");
            return this;


        }

        public Criteria andAuditRemarkIsNull() {
            addCriterion("audit_remark is null");
            return this;


        }

        public Criteria andAuditRemarkIsNotNull() {
            addCriterion("audit_remark is not null");
            return this;


        }

        public Criteria andAuditRemarkEqualTo(String value) {
            addCriterion("audit_remark =", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkNotEqualTo(String value) {
            addCriterion("audit_remark <>", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkGreaterThan(String value) {
            addCriterion("audit_remark >", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("audit_remark >=", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkLessThan(String value) {
            addCriterion("audit_remark <", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkLessThanOrEqualTo(String value) {
            addCriterion("audit_remark <=", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkLike(String value) {
            addCriterion("audit_remark like", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkNotLike(String value) {
            addCriterion("audit_remark not like", value, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkIn(List values) {
            addCriterion("audit_remark in", values, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkNotIn(List values) {
            addCriterion("audit_remark not in", values, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkBetween(String value1, String value2) {
            addCriterion("audit_remark between", value1, value2, "auditRemark");
            return this;


        }

        public Criteria andAuditRemarkNotBetween(String value1, String value2) {
            addCriterion("audit_remark not between", value1, value2, "auditRemark");
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

        public Criteria andCardFirstUrlIsNull() {
            addCriterion("card_first_url is null");
            return this;


        }

        public Criteria andCardFirstUrlIsNotNull() {
            addCriterion("card_first_url is not null");
            return this;


        }

        public Criteria andCardFirstUrlEqualTo(String value) {
            addCriterion("card_first_url =", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlNotEqualTo(String value) {
            addCriterion("card_first_url <>", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlGreaterThan(String value) {
            addCriterion("card_first_url >", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlGreaterThanOrEqualTo(String value) {
            addCriterion("card_first_url >=", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlLessThan(String value) {
            addCriterion("card_first_url <", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlLessThanOrEqualTo(String value) {
            addCriterion("card_first_url <=", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlLike(String value) {
            addCriterion("card_first_url like", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlNotLike(String value) {
            addCriterion("card_first_url not like", value, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlIn(List values) {
            addCriterion("card_first_url in", values, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlNotIn(List values) {
            addCriterion("card_first_url not in", values, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlBetween(String value1, String value2) {
            addCriterion("card_first_url between", value1, value2, "cardFirstUrl");
            return this;


        }

        public Criteria andCardFirstUrlNotBetween(String value1, String value2) {
            addCriterion("card_first_url not between", value1, value2, "cardFirstUrl");
            return this;


        }

        public Criteria andCardTwoUrlIsNull() {
            addCriterion("card_two_url is null");
            return this;


        }

        public Criteria andCardTwoUrlIsNotNull() {
            addCriterion("card_two_url is not null");
            return this;


        }

        public Criteria andCardTwoUrlEqualTo(String value) {
            addCriterion("card_two_url =", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlNotEqualTo(String value) {
            addCriterion("card_two_url <>", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlGreaterThan(String value) {
            addCriterion("card_two_url >", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("card_two_url >=", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlLessThan(String value) {
            addCriterion("card_two_url <", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlLessThanOrEqualTo(String value) {
            addCriterion("card_two_url <=", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlLike(String value) {
            addCriterion("card_two_url like", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlNotLike(String value) {
            addCriterion("card_two_url not like", value, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlIn(List values) {
            addCriterion("card_two_url in", values, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlNotIn(List values) {
            addCriterion("card_two_url not in", values, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlBetween(String value1, String value2) {
            addCriterion("card_two_url between", value1, value2, "cardTwoUrl");
            return this;


        }

        public Criteria andCardTwoUrlNotBetween(String value1, String value2) {
            addCriterion("card_two_url not between", value1, value2, "cardTwoUrl");
            return this;


        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("head_url is null");
            return this;


        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("head_url is not null");
            return this;


        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("head_url =", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("head_url >", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("head_url <", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("head_url like", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("head_url not like", value, "headUrl");
            return this;


        }

        public Criteria andHeadUrlIn(List values) {
            addCriterion("head_url in", values, "headUrl");
            return this;


        }

        public Criteria andHeadUrlNotIn(List values) {
            addCriterion("head_url not in", values, "headUrl");
            return this;


        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "headUrl");
            return this;


        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "headUrl");
            return this;


        }

        public Criteria andCardCodeIsNull() {
            addCriterion("card_code is null");
            return this;


        }

        public Criteria andCardCodeIsNotNull() {
            addCriterion("card_code is not null");
            return this;


        }

        public Criteria andCardCodeEqualTo(String value) {
            addCriterion("card_code =", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeNotEqualTo(String value) {
            addCriterion("card_code <>", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeGreaterThan(String value) {
            addCriterion("card_code >", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("card_code >=", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeLessThan(String value) {
            addCriterion("card_code <", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeLessThanOrEqualTo(String value) {
            addCriterion("card_code <=", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeLike(String value) {
            addCriterion("card_code like", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeNotLike(String value) {
            addCriterion("card_code not like", value, "cardCode");
            return this;


        }

        public Criteria andCardCodeIn(List values) {
            addCriterion("card_code in", values, "cardCode");
            return this;


        }

        public Criteria andCardCodeNotIn(List values) {
            addCriterion("card_code not in", values, "cardCode");
            return this;


        }

        public Criteria andCardCodeBetween(String value1, String value2) {
            addCriterion("card_code between", value1, value2, "cardCode");
            return this;


        }

        public Criteria andCardCodeNotBetween(String value1, String value2) {
            addCriterion("card_code not between", value1, value2, "cardCode");
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return this;


        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return this;


        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return this;


        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return this;


        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return this;


        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return this;


        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return this;


        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return this;


        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return this;


        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return this;


        }

        public Criteria andCodeIn(List values) {
            addCriterion("code in", values, "code");
            return this;


        }

        public Criteria andCodeNotIn(List values) {
            addCriterion("code not in", values, "code");
            return this;


        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return this;


        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andDimensionalCodeUrlIsNull() {
            addCriterion("dimensional_code_url is null");
            return this;


        }

        public Criteria andDimensionalCodeUrlIsNotNull() {
            addCriterion("dimensional_code_url is not null");
            return this;


        }

        public Criteria andDimensionalCodeUrlEqualTo(String value) {
            addCriterion("dimensional_code_url =", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlNotEqualTo(String value) {
            addCriterion("dimensional_code_url <>", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlGreaterThan(String value) {
            addCriterion("dimensional_code_url >", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("dimensional_code_url >=", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlLessThan(String value) {
            addCriterion("dimensional_code_url <", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("dimensional_code_url <=", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlLike(String value) {
            addCriterion("dimensional_code_url like", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlNotLike(String value) {
            addCriterion("dimensional_code_url not like", value, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlIn(List values) {
            addCriterion("dimensional_code_url in", values, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlNotIn(List values) {
            addCriterion("dimensional_code_url not in", values, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlBetween(String value1, String value2) {
            addCriterion("dimensional_code_url between", value1, value2, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andDimensionalCodeUrlNotBetween(String value1, String value2) {
            addCriterion("dimensional_code_url not between", value1, value2, "dimensionalCodeUrl");
            return this;


        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return this;


        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return this;


        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return this;


        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return this;


        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return this;


        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return this;


        }

        public Criteria andCreateDtIn(List values) {
            addCriterion("create_dt in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtNotIn(List values) {
            addCriterion("create_dt not in", values, "createDt");
            return this;


        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return this;


        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
            return this;


        }

        public Criteria andPeopleRankingIsNull() {
            addCriterion("people_ranking is null");
            return this;


        }

        public Criteria andPeopleRankingIsNotNull() {
            addCriterion("people_ranking is not null");
            return this;


        }

        public Criteria andPeopleRankingEqualTo(Integer value) {
            addCriterion("people_ranking =", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingNotEqualTo(Integer value) {
            addCriterion("people_ranking <>", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingGreaterThan(Integer value) {
            addCriterion("people_ranking >", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_ranking >=", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingLessThan(Integer value) {
            addCriterion("people_ranking <", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingLessThanOrEqualTo(Integer value) {
            addCriterion("people_ranking <=", value, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingIn(List values) {
            addCriterion("people_ranking in", values, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingNotIn(List values) {
            addCriterion("people_ranking not in", values, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingBetween(Integer value1, Integer value2) {
            addCriterion("people_ranking between", value1, value2, "peopleRanking");
            return this;


        }

        public Criteria andPeopleRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("people_ranking not between", value1, value2, "peopleRanking");
            return this;


        }

        public Criteria andPriceRankingIsNull() {
            addCriterion("price_ranking is null");
            return this;


        }

        public Criteria andPriceRankingIsNotNull() {
            addCriterion("price_ranking is not null");
            return this;


        }

        public Criteria andPriceRankingEqualTo(Integer value) {
            addCriterion("price_ranking =", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingNotEqualTo(Integer value) {
            addCriterion("price_ranking <>", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingGreaterThan(Integer value) {
            addCriterion("price_ranking >", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_ranking >=", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingLessThan(Integer value) {
            addCriterion("price_ranking <", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingLessThanOrEqualTo(Integer value) {
            addCriterion("price_ranking <=", value, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingIn(List values) {
            addCriterion("price_ranking in", values, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingNotIn(List values) {
            addCriterion("price_ranking not in", values, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingBetween(Integer value1, Integer value2) {
            addCriterion("price_ranking between", value1, value2, "priceRanking");
            return this;


        }

        public Criteria andPriceRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("price_ranking not between", value1, value2, "priceRanking");
            return this;


        }


    }


}
