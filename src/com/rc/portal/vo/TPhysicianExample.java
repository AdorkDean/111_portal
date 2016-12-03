package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TPhysicianExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TPhysicianExample() {
        oredCriteria = new ArrayList();


    }

    protected TPhysicianExample(TPhysicianExample example) {
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

        public Criteria andCardUrlIsNull() {
            addCriterion("card_url is null");
            return this;


        }

        public Criteria andCardUrlIsNotNull() {
            addCriterion("card_url is not null");
            return this;


        }

        public Criteria andCardUrlEqualTo(String value) {
            addCriterion("card_url =", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlNotEqualTo(String value) {
            addCriterion("card_url <>", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlGreaterThan(String value) {
            addCriterion("card_url >", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlGreaterThanOrEqualTo(String value) {
            addCriterion("card_url >=", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlLessThan(String value) {
            addCriterion("card_url <", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlLessThanOrEqualTo(String value) {
            addCriterion("card_url <=", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlLike(String value) {
            addCriterion("card_url like", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlNotLike(String value) {
            addCriterion("card_url not like", value, "cardUrl");
            return this;


        }

        public Criteria andCardUrlIn(List values) {
            addCriterion("card_url in", values, "cardUrl");
            return this;


        }

        public Criteria andCardUrlNotIn(List values) {
            addCriterion("card_url not in", values, "cardUrl");
            return this;


        }

        public Criteria andCardUrlBetween(String value1, String value2) {
            addCriterion("card_url between", value1, value2, "cardUrl");
            return this;


        }

        public Criteria andCardUrlNotBetween(String value1, String value2) {
            addCriterion("card_url not between", value1, value2, "cardUrl");
            return this;


        }

        public Criteria andSeniorityUrlIsNull() {
            addCriterion("seniority_url is null");
            return this;


        }

        public Criteria andSeniorityUrlIsNotNull() {
            addCriterion("seniority_url is not null");
            return this;


        }

        public Criteria andSeniorityUrlEqualTo(String value) {
            addCriterion("seniority_url =", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlNotEqualTo(String value) {
            addCriterion("seniority_url <>", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlGreaterThan(String value) {
            addCriterion("seniority_url >", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlGreaterThanOrEqualTo(String value) {
            addCriterion("seniority_url >=", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlLessThan(String value) {
            addCriterion("seniority_url <", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlLessThanOrEqualTo(String value) {
            addCriterion("seniority_url <=", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlLike(String value) {
            addCriterion("seniority_url like", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlNotLike(String value) {
            addCriterion("seniority_url not like", value, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlIn(List values) {
            addCriterion("seniority_url in", values, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlNotIn(List values) {
            addCriterion("seniority_url not in", values, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlBetween(String value1, String value2) {
            addCriterion("seniority_url between", value1, value2, "seniorityUrl");
            return this;


        }

        public Criteria andSeniorityUrlNotBetween(String value1, String value2) {
            addCriterion("seniority_url not between", value1, value2, "seniorityUrl");
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return this;


        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return this;


        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return this;


        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return this;


        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return this;


        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return this;


        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return this;


        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return this;


        }

        public Criteria andAdminIdIn(List values) {
            addCriterion("admin_id in", values, "adminId");
            return this;


        }

        public Criteria andAdminIdNotIn(List values) {
            addCriterion("admin_id not in", values, "adminId");
            return this;


        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return this;


        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
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


    }


}
