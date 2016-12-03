package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCouponCardExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCouponCardExample() {
        oredCriteria = new ArrayList();


    }

    protected TCouponCardExample(TCouponCardExample example) {
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

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return this;


        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return this;


        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return this;


        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return this;


        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return this;


        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return this;


        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return this;


        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return this;


        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return this;


        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return this;


        }

        public Criteria andCardNoIn(List values) {
            addCriterion("card_no in", values, "cardNo");
            return this;


        }

        public Criteria andCardNoNotIn(List values) {
            addCriterion("card_no not in", values, "cardNo");
            return this;


        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return this;


        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
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

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return this;


        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return this;


        }

        public Criteria andUseTimeEqualTo(Date value) {
            addCriterion("use_time =", value, "useTime");
            return this;


        }

        public Criteria andUseTimeNotEqualTo(Date value) {
            addCriterion("use_time <>", value, "useTime");
            return this;


        }

        public Criteria andUseTimeGreaterThan(Date value) {
            addCriterion("use_time >", value, "useTime");
            return this;


        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_time >=", value, "useTime");
            return this;


        }

        public Criteria andUseTimeLessThan(Date value) {
            addCriterion("use_time <", value, "useTime");
            return this;


        }

        public Criteria andUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_time <=", value, "useTime");
            return this;


        }

        public Criteria andUseTimeIn(List values) {
            addCriterion("use_time in", values, "useTime");
            return this;


        }

        public Criteria andUseTimeNotIn(List values) {
            addCriterion("use_time not in", values, "useTime");
            return this;


        }

        public Criteria andUseTimeBetween(Date value1, Date value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return this;


        }

        public Criteria andUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
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

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return this;


        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return this;


        }

        public Criteria andTicketIdEqualTo(Long value) {
            addCriterion("ticket_id =", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdNotEqualTo(Long value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdGreaterThan(Long value) {
            addCriterion("ticket_id >", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdLessThan(Long value) {
            addCriterion("ticket_id <", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdLessThanOrEqualTo(Long value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return this;


        }

        public Criteria andTicketIdIn(List values) {
            addCriterion("ticket_id in", values, "ticketId");
            return this;


        }

        public Criteria andTicketIdNotIn(List values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return this;


        }

        public Criteria andTicketIdBetween(Long value1, Long value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return this;


        }

        public Criteria andTicketIdNotBetween(Long value1, Long value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return this;


        }


    }


}
