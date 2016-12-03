package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCustomerCallExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCustomerCallExample() {
        oredCriteria = new ArrayList();


    }

    protected TCustomerCallExample(TCustomerCallExample example) {
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

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return this;


        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return this;


        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberIn(List values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberNotIn(List values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return this;


        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return this;


        }

        public Criteria andCallStatusIsNull() {
            addCriterion("call_status is null");
            return this;


        }

        public Criteria andCallStatusIsNotNull() {
            addCriterion("call_status is not null");
            return this;


        }

        public Criteria andCallStatusEqualTo(Integer value) {
            addCriterion("call_status =", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusNotEqualTo(Integer value) {
            addCriterion("call_status <>", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusGreaterThan(Integer value) {
            addCriterion("call_status >", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_status >=", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusLessThan(Integer value) {
            addCriterion("call_status <", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusLessThanOrEqualTo(Integer value) {
            addCriterion("call_status <=", value, "callStatus");
            return this;


        }

        public Criteria andCallStatusIn(List values) {
            addCriterion("call_status in", values, "callStatus");
            return this;


        }

        public Criteria andCallStatusNotIn(List values) {
            addCriterion("call_status not in", values, "callStatus");
            return this;


        }

        public Criteria andCallStatusBetween(Integer value1, Integer value2) {
            addCriterion("call_status between", value1, value2, "callStatus");
            return this;


        }

        public Criteria andCallStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("call_status not between", value1, value2, "callStatus");
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

        public Criteria andCallTimeIsNull() {
            addCriterion("call_time is null");
            return this;


        }

        public Criteria andCallTimeIsNotNull() {
            addCriterion("call_time is not null");
            return this;


        }

        public Criteria andCallTimeEqualTo(Date value) {
            addCriterion("call_time =", value, "callTime");
            return this;


        }

        public Criteria andCallTimeNotEqualTo(Date value) {
            addCriterion("call_time <>", value, "callTime");
            return this;


        }

        public Criteria andCallTimeGreaterThan(Date value) {
            addCriterion("call_time >", value, "callTime");
            return this;


        }

        public Criteria andCallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("call_time >=", value, "callTime");
            return this;


        }

        public Criteria andCallTimeLessThan(Date value) {
            addCriterion("call_time <", value, "callTime");
            return this;


        }

        public Criteria andCallTimeLessThanOrEqualTo(Date value) {
            addCriterion("call_time <=", value, "callTime");
            return this;


        }

        public Criteria andCallTimeIn(List values) {
            addCriterion("call_time in", values, "callTime");
            return this;


        }

        public Criteria andCallTimeNotIn(List values) {
            addCriterion("call_time not in", values, "callTime");
            return this;


        }

        public Criteria andCallTimeBetween(Date value1, Date value2) {
            addCriterion("call_time between", value1, value2, "callTime");
            return this;


        }

        public Criteria andCallTimeNotBetween(Date value1, Date value2) {
            addCriterion("call_time not between", value1, value2, "callTime");
            return this;


        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return this;


        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return this;


        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return this;


        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return this;


        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return this;


        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return this;


        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return this;


        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return this;


        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return this;


        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return this;


        }

        public Criteria andOperatorIn(List values) {
            addCriterion("operator in", values, "operator");
            return this;


        }

        public Criteria andOperatorNotIn(List values) {
            addCriterion("operator not in", values, "operator");
            return this;


        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return this;


        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return this;


        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return this;


        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return this;


        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdIn(List values) {
            addCriterion("goods_id in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotIn(List values) {
            addCriterion("goods_id not in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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


    }


}
