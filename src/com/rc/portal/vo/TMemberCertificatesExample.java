package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberCertificatesExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberCertificatesExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberCertificatesExample(TMemberCertificatesExample example) {
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

        public Criteria andIdcardJustUrlIsNull() {
            addCriterion("idcard_just_url is null");
            return this;


        }

        public Criteria andIdcardJustUrlIsNotNull() {
            addCriterion("idcard_just_url is not null");
            return this;


        }

        public Criteria andIdcardJustUrlEqualTo(String value) {
            addCriterion("idcard_just_url =", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlNotEqualTo(String value) {
            addCriterion("idcard_just_url <>", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlGreaterThan(String value) {
            addCriterion("idcard_just_url >", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_just_url >=", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlLessThan(String value) {
            addCriterion("idcard_just_url <", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlLessThanOrEqualTo(String value) {
            addCriterion("idcard_just_url <=", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlLike(String value) {
            addCriterion("idcard_just_url like", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlNotLike(String value) {
            addCriterion("idcard_just_url not like", value, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlIn(List values) {
            addCriterion("idcard_just_url in", values, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlNotIn(List values) {
            addCriterion("idcard_just_url not in", values, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlBetween(String value1, String value2) {
            addCriterion("idcard_just_url between", value1, value2, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardJustUrlNotBetween(String value1, String value2) {
            addCriterion("idcard_just_url not between", value1, value2, "idcardJustUrl");
            return this;


        }

        public Criteria andIdcardBackUrlIsNull() {
            addCriterion("idcard_back_url is null");
            return this;


        }

        public Criteria andIdcardBackUrlIsNotNull() {
            addCriterion("idcard_back_url is not null");
            return this;


        }

        public Criteria andIdcardBackUrlEqualTo(String value) {
            addCriterion("idcard_back_url =", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlNotEqualTo(String value) {
            addCriterion("idcard_back_url <>", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlGreaterThan(String value) {
            addCriterion("idcard_back_url >", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_back_url >=", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlLessThan(String value) {
            addCriterion("idcard_back_url <", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlLessThanOrEqualTo(String value) {
            addCriterion("idcard_back_url <=", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlLike(String value) {
            addCriterion("idcard_back_url like", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlNotLike(String value) {
            addCriterion("idcard_back_url not like", value, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlIn(List values) {
            addCriterion("idcard_back_url in", values, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlNotIn(List values) {
            addCriterion("idcard_back_url not in", values, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlBetween(String value1, String value2) {
            addCriterion("idcard_back_url between", value1, value2, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardBackUrlNotBetween(String value1, String value2) {
            addCriterion("idcard_back_url not between", value1, value2, "idcardBackUrl");
            return this;


        }

        public Criteria andIdcardTypeIsNull() {
            addCriterion("idcard_type is null");
            return this;


        }

        public Criteria andIdcardTypeIsNotNull() {
            addCriterion("idcard_type is not null");
            return this;


        }

        public Criteria andIdcardTypeEqualTo(Integer value) {
            addCriterion("idcard_type =", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeNotEqualTo(Integer value) {
            addCriterion("idcard_type <>", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeGreaterThan(Integer value) {
            addCriterion("idcard_type >", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcard_type >=", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeLessThan(Integer value) {
            addCriterion("idcard_type <", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeLessThanOrEqualTo(Integer value) {
            addCriterion("idcard_type <=", value, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeIn(List values) {
            addCriterion("idcard_type in", values, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeNotIn(List values) {
            addCriterion("idcard_type not in", values, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeBetween(Integer value1, Integer value2) {
            addCriterion("idcard_type between", value1, value2, "idcardType");
            return this;


        }

        public Criteria andIdcardTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("idcard_type not between", value1, value2, "idcardType");
            return this;


        }

        public Criteria andIdcardCodeIsNull() {
            addCriterion("idcard_code is null");
            return this;


        }

        public Criteria andIdcardCodeIsNotNull() {
            addCriterion("idcard_code is not null");
            return this;


        }

        public Criteria andIdcardCodeEqualTo(String value) {
            addCriterion("idcard_code =", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeNotEqualTo(String value) {
            addCriterion("idcard_code <>", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeGreaterThan(String value) {
            addCriterion("idcard_code >", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_code >=", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeLessThan(String value) {
            addCriterion("idcard_code <", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeLessThanOrEqualTo(String value) {
            addCriterion("idcard_code <=", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeLike(String value) {
            addCriterion("idcard_code like", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeNotLike(String value) {
            addCriterion("idcard_code not like", value, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeIn(List values) {
            addCriterion("idcard_code in", values, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeNotIn(List values) {
            addCriterion("idcard_code not in", values, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeBetween(String value1, String value2) {
            addCriterion("idcard_code between", value1, value2, "idcardCode");
            return this;


        }

        public Criteria andIdcardCodeNotBetween(String value1, String value2) {
            addCriterion("idcard_code not between", value1, value2, "idcardCode");
            return this;


        }

        public Criteria andIdcardAddressIsNull() {
            addCriterion("idcard_address is null");
            return this;


        }

        public Criteria andIdcardAddressIsNotNull() {
            addCriterion("idcard_address is not null");
            return this;


        }

        public Criteria andIdcardAddressEqualTo(String value) {
            addCriterion("idcard_address =", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressNotEqualTo(String value) {
            addCriterion("idcard_address <>", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressGreaterThan(String value) {
            addCriterion("idcard_address >", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_address >=", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressLessThan(String value) {
            addCriterion("idcard_address <", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressLessThanOrEqualTo(String value) {
            addCriterion("idcard_address <=", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressLike(String value) {
            addCriterion("idcard_address like", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressNotLike(String value) {
            addCriterion("idcard_address not like", value, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressIn(List values) {
            addCriterion("idcard_address in", values, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressNotIn(List values) {
            addCriterion("idcard_address not in", values, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressBetween(String value1, String value2) {
            addCriterion("idcard_address between", value1, value2, "idcardAddress");
            return this;


        }

        public Criteria andIdcardAddressNotBetween(String value1, String value2) {
            addCriterion("idcard_address not between", value1, value2, "idcardAddress");
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


    }


}
