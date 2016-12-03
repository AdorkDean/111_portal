package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberReceiverExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberReceiverExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberReceiverExample(TMemberReceiverExample example) {
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

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return this;


        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return this;


        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return this;


        }

        public Criteria andZipCodeIn(List values) {
            addCriterion("zip_code in", values, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotIn(List values) {
            addCriterion("zip_code not in", values, "zipCode");
            return this;


        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return this;


        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return this;


        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return this;


        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return this;


        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return this;


        }

        public Criteria andReceiverIn(List values) {
            addCriterion("receiver in", values, "receiver");
            return this;


        }

        public Criteria andReceiverNotIn(List values) {
            addCriterion("receiver not in", values, "receiver");
            return this;


        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return this;


        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return this;


        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return this;


        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return this;


        }

        public Criteria andIsDefaultEqualTo(Integer value) {
            addCriterion("is_default =", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotEqualTo(Integer value) {
            addCriterion("is_default <>", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultGreaterThan(Integer value) {
            addCriterion("is_default >", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default >=", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultLessThan(Integer value) {
            addCriterion("is_default <", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("is_default <=", value, "isDefault");
            return this;


        }

        public Criteria andIsDefaultIn(List values) {
            addCriterion("is_default in", values, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotIn(List values) {
            addCriterion("is_default not in", values, "isDefault");
            return this;


        }

        public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return this;


        }

        public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
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
