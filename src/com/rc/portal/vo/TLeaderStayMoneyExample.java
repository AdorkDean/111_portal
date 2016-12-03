package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLeaderStayMoneyExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLeaderStayMoneyExample() {
        oredCriteria = new ArrayList();


    }

    protected TLeaderStayMoneyExample(TLeaderStayMoneyExample example) {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return this;


        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return this;


        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return this;


        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdIn(List values) {
            addCriterion("order_id in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdNotIn(List values) {
            addCriterion("order_id not in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return this;


        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andRelationMemberIdIsNull() {
            addCriterion("relation_member_id is null");
            return this;


        }

        public Criteria andRelationMemberIdIsNotNull() {
            addCriterion("relation_member_id is not null");
            return this;


        }

        public Criteria andRelationMemberIdEqualTo(Long value) {
            addCriterion("relation_member_id =", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdNotEqualTo(Long value) {
            addCriterion("relation_member_id <>", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdGreaterThan(Long value) {
            addCriterion("relation_member_id >", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_member_id >=", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdLessThan(Long value) {
            addCriterion("relation_member_id <", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_member_id <=", value, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdIn(List values) {
            addCriterion("relation_member_id in", values, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdNotIn(List values) {
            addCriterion("relation_member_id not in", values, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdBetween(Long value1, Long value2) {
            addCriterion("relation_member_id between", value1, value2, "relationMemberId");
            return this;


        }

        public Criteria andRelationMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_member_id not between", value1, value2, "relationMemberId");
            return this;


        }

        public Criteria andMemberTypeIsNull() {
            addCriterion("member_type is null");
            return this;


        }

        public Criteria andMemberTypeIsNotNull() {
            addCriterion("member_type is not null");
            return this;


        }

        public Criteria andMemberTypeEqualTo(Integer value) {
            addCriterion("member_type =", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeNotEqualTo(Integer value) {
            addCriterion("member_type <>", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeGreaterThan(Integer value) {
            addCriterion("member_type >", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_type >=", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeLessThan(Integer value) {
            addCriterion("member_type <", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeLessThanOrEqualTo(Integer value) {
            addCriterion("member_type <=", value, "memberType");
            return this;


        }

        public Criteria andMemberTypeIn(List values) {
            addCriterion("member_type in", values, "memberType");
            return this;


        }

        public Criteria andMemberTypeNotIn(List values) {
            addCriterion("member_type not in", values, "memberType");
            return this;


        }

        public Criteria andMemberTypeBetween(Integer value1, Integer value2) {
            addCriterion("member_type between", value1, value2, "memberType");
            return this;


        }

        public Criteria andMemberTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("member_type not between", value1, value2, "memberType");
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return this;


        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return this;


        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberIn(List values) {
            addCriterion("serial_number in", values, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotIn(List values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return this;


        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return this;


        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return this;


        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return this;


        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusIn(List values) {
            addCriterion("audit_status in", values, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotIn(List values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return this;


        }

        public Criteria andAuditDateIsNull() {
            addCriterion("audit_date is null");
            return this;


        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("audit_date is not null");
            return this;


        }

        public Criteria andAuditDateEqualTo(Date value) {
            addCriterion("audit_date =", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateNotEqualTo(Date value) {
            addCriterion("audit_date <>", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateGreaterThan(Date value) {
            addCriterion("audit_date >", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_date >=", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateLessThan(Date value) {
            addCriterion("audit_date <", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateLessThanOrEqualTo(Date value) {
            addCriterion("audit_date <=", value, "auditDate");
            return this;


        }

        public Criteria andAuditDateIn(List values) {
            addCriterion("audit_date in", values, "auditDate");
            return this;


        }

        public Criteria andAuditDateNotIn(List values) {
            addCriterion("audit_date not in", values, "auditDate");
            return this;


        }

        public Criteria andAuditDateBetween(Date value1, Date value2) {
            addCriterion("audit_date between", value1, value2, "auditDate");
            return this;


        }

        public Criteria andAuditDateNotBetween(Date value1, Date value2) {
            addCriterion("audit_date not between", value1, value2, "auditDate");
            return this;


        }

        public Criteria andAuditOpinionIsNull() {
            addCriterion("audit_opinion is null");
            return this;


        }

        public Criteria andAuditOpinionIsNotNull() {
            addCriterion("audit_opinion is not null");
            return this;


        }

        public Criteria andAuditOpinionEqualTo(String value) {
            addCriterion("audit_opinion =", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionNotEqualTo(String value) {
            addCriterion("audit_opinion <>", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionGreaterThan(String value) {
            addCriterion("audit_opinion >", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("audit_opinion >=", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionLessThan(String value) {
            addCriterion("audit_opinion <", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionLessThanOrEqualTo(String value) {
            addCriterion("audit_opinion <=", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionLike(String value) {
            addCriterion("audit_opinion like", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionNotLike(String value) {
            addCriterion("audit_opinion not like", value, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionIn(List values) {
            addCriterion("audit_opinion in", values, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionNotIn(List values) {
            addCriterion("audit_opinion not in", values, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionBetween(String value1, String value2) {
            addCriterion("audit_opinion between", value1, value2, "auditOpinion");
            return this;


        }

        public Criteria andAuditOpinionNotBetween(String value1, String value2) {
            addCriterion("audit_opinion not between", value1, value2, "auditOpinion");
            return this;


        }


    }


}
