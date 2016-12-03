package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLeaderAccountNumberExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLeaderAccountNumberExample() {
        oredCriteria = new ArrayList();


    }

    protected TLeaderAccountNumberExample(TLeaderAccountNumberExample example) {
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

        public Criteria andLeaderIdIsNull() {
            addCriterion("leader_id is null");
            return this;


        }

        public Criteria andLeaderIdIsNotNull() {
            addCriterion("leader_id is not null");
            return this;


        }

        public Criteria andLeaderIdEqualTo(Long value) {
            addCriterion("leader_id =", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotEqualTo(Long value) {
            addCriterion("leader_id <>", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdGreaterThan(Long value) {
            addCriterion("leader_id >", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("leader_id >=", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdLessThan(Long value) {
            addCriterion("leader_id <", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("leader_id <=", value, "leaderId");
            return this;


        }

        public Criteria andLeaderIdIn(List values) {
            addCriterion("leader_id in", values, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotIn(List values) {
            addCriterion("leader_id not in", values, "leaderId");
            return this;


        }

        public Criteria andLeaderIdBetween(Long value1, Long value2) {
            addCriterion("leader_id between", value1, value2, "leaderId");
            return this;


        }

        public Criteria andLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("leader_id not between", value1, value2, "leaderId");
            return this;


        }

        public Criteria andNumberTypeIsNull() {
            addCriterion("number_type is null");
            return this;


        }

        public Criteria andNumberTypeIsNotNull() {
            addCriterion("number_type is not null");
            return this;


        }

        public Criteria andNumberTypeEqualTo(Integer value) {
            addCriterion("number_type =", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeNotEqualTo(Integer value) {
            addCriterion("number_type <>", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeGreaterThan(Integer value) {
            addCriterion("number_type >", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_type >=", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeLessThan(Integer value) {
            addCriterion("number_type <", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeLessThanOrEqualTo(Integer value) {
            addCriterion("number_type <=", value, "numberType");
            return this;


        }

        public Criteria andNumberTypeIn(List values) {
            addCriterion("number_type in", values, "numberType");
            return this;


        }

        public Criteria andNumberTypeNotIn(List values) {
            addCriterion("number_type not in", values, "numberType");
            return this;


        }

        public Criteria andNumberTypeBetween(Integer value1, Integer value2) {
            addCriterion("number_type between", value1, value2, "numberType");
            return this;


        }

        public Criteria andNumberTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("number_type not between", value1, value2, "numberType");
            return this;


        }

        public Criteria andAccountNumberIsNull() {
            addCriterion("account_number is null");
            return this;


        }

        public Criteria andAccountNumberIsNotNull() {
            addCriterion("account_number is not null");
            return this;


        }

        public Criteria andAccountNumberEqualTo(String value) {
            addCriterion("account_number =", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberNotEqualTo(String value) {
            addCriterion("account_number <>", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberGreaterThan(String value) {
            addCriterion("account_number >", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("account_number >=", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberLessThan(String value) {
            addCriterion("account_number <", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("account_number <=", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberLike(String value) {
            addCriterion("account_number like", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberNotLike(String value) {
            addCriterion("account_number not like", value, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberIn(List values) {
            addCriterion("account_number in", values, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberNotIn(List values) {
            addCriterion("account_number not in", values, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberBetween(String value1, String value2) {
            addCriterion("account_number between", value1, value2, "accountNumber");
            return this;


        }

        public Criteria andAccountNumberNotBetween(String value1, String value2) {
            addCriterion("account_number not between", value1, value2, "accountNumber");
            return this;


        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return this;


        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return this;


        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return this;


        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return this;


        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return this;


        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return this;


        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return this;


        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return this;


        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return this;


        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return this;


        }

        public Criteria andBankNameIn(List values) {
            addCriterion("bank_name in", values, "bankName");
            return this;


        }

        public Criteria andBankNameNotIn(List values) {
            addCriterion("bank_name not in", values, "bankName");
            return this;


        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return this;


        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
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

        public Criteria andBankOpenNameIsNull() {
            addCriterion("bank_open_name is null");
            return this;


        }

        public Criteria andBankOpenNameIsNotNull() {
            addCriterion("bank_open_name is not null");
            return this;


        }

        public Criteria andBankOpenNameEqualTo(String value) {
            addCriterion("bank_open_name =", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameNotEqualTo(String value) {
            addCriterion("bank_open_name <>", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameGreaterThan(String value) {
            addCriterion("bank_open_name >", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_open_name >=", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameLessThan(String value) {
            addCriterion("bank_open_name <", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameLessThanOrEqualTo(String value) {
            addCriterion("bank_open_name <=", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameLike(String value) {
            addCriterion("bank_open_name like", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameNotLike(String value) {
            addCriterion("bank_open_name not like", value, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameIn(List values) {
            addCriterion("bank_open_name in", values, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameNotIn(List values) {
            addCriterion("bank_open_name not in", values, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameBetween(String value1, String value2) {
            addCriterion("bank_open_name between", value1, value2, "bankOpenName");
            return this;


        }

        public Criteria andBankOpenNameNotBetween(String value1, String value2) {
            addCriterion("bank_open_name not between", value1, value2, "bankOpenName");
            return this;


        }

        public Criteria andAccountRealNameIsNull() {
            addCriterion("account_real_name is null");
            return this;


        }

        public Criteria andAccountRealNameIsNotNull() {
            addCriterion("account_real_name is not null");
            return this;


        }

        public Criteria andAccountRealNameEqualTo(String value) {
            addCriterion("account_real_name =", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameNotEqualTo(String value) {
            addCriterion("account_real_name <>", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameGreaterThan(String value) {
            addCriterion("account_real_name >", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_real_name >=", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameLessThan(String value) {
            addCriterion("account_real_name <", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameLessThanOrEqualTo(String value) {
            addCriterion("account_real_name <=", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameLike(String value) {
            addCriterion("account_real_name like", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameNotLike(String value) {
            addCriterion("account_real_name not like", value, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameIn(List values) {
            addCriterion("account_real_name in", values, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameNotIn(List values) {
            addCriterion("account_real_name not in", values, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameBetween(String value1, String value2) {
            addCriterion("account_real_name between", value1, value2, "accountRealName");
            return this;


        }

        public Criteria andAccountRealNameNotBetween(String value1, String value2) {
            addCriterion("account_real_name not between", value1, value2, "accountRealName");
            return this;


        }


    }


}
