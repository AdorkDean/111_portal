package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberBalanceExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberBalanceExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberBalanceExample(TMemberBalanceExample example) {
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

        public Criteria andStreamTypeIsNull() {
            addCriterion("stream_type is null");
            return this;


        }

        public Criteria andStreamTypeIsNotNull() {
            addCriterion("stream_type is not null");
            return this;


        }

        public Criteria andStreamTypeEqualTo(Integer value) {
            addCriterion("stream_type =", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeNotEqualTo(Integer value) {
            addCriterion("stream_type <>", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeGreaterThan(Integer value) {
            addCriterion("stream_type >", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stream_type >=", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeLessThan(Integer value) {
            addCriterion("stream_type <", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeLessThanOrEqualTo(Integer value) {
            addCriterion("stream_type <=", value, "streamType");
            return this;


        }

        public Criteria andStreamTypeIn(List values) {
            addCriterion("stream_type in", values, "streamType");
            return this;


        }

        public Criteria andStreamTypeNotIn(List values) {
            addCriterion("stream_type not in", values, "streamType");
            return this;


        }

        public Criteria andStreamTypeBetween(Integer value1, Integer value2) {
            addCriterion("stream_type between", value1, value2, "streamType");
            return this;


        }

        public Criteria andStreamTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stream_type not between", value1, value2, "streamType");
            return this;


        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return this;


        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return this;


        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return this;


        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return this;


        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return this;


        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return this;


        }

        public Criteria andPriceIn(List values) {
            addCriterion("price in", values, "price");
            return this;


        }

        public Criteria andPriceNotIn(List values) {
            addCriterion("price not in", values, "price");
            return this;


        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return this;


        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return this;


        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return this;


        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return this;


        }

        public Criteria andBalanceEqualTo(Long value) {
            addCriterion("balance =", value, "balance");
            return this;


        }

        public Criteria andBalanceNotEqualTo(Long value) {
            addCriterion("balance <>", value, "balance");
            return this;


        }

        public Criteria andBalanceGreaterThan(Long value) {
            addCriterion("balance >", value, "balance");
            return this;


        }

        public Criteria andBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("balance >=", value, "balance");
            return this;


        }

        public Criteria andBalanceLessThan(Long value) {
            addCriterion("balance <", value, "balance");
            return this;


        }

        public Criteria andBalanceLessThanOrEqualTo(Long value) {
            addCriterion("balance <=", value, "balance");
            return this;


        }

        public Criteria andBalanceIn(List values) {
            addCriterion("balance in", values, "balance");
            return this;


        }

        public Criteria andBalanceNotIn(List values) {
            addCriterion("balance not in", values, "balance");
            return this;


        }

        public Criteria andBalanceBetween(Long value1, Long value2) {
            addCriterion("balance between", value1, value2, "balance");
            return this;


        }

        public Criteria andBalanceNotBetween(Long value1, Long value2) {
            addCriterion("balance not between", value1, value2, "balance");
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


    }


}
