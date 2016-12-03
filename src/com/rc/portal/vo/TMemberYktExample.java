package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberYktExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberYktExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberYktExample(TMemberYktExample example) {
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

        public Criteria andYktCodeIsNull() {
            addCriterion("ykt_code is null");
            return this;


        }

        public Criteria andYktCodeIsNotNull() {
            addCriterion("ykt_code is not null");
            return this;


        }

        public Criteria andYktCodeEqualTo(String value) {
            addCriterion("ykt_code =", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeNotEqualTo(String value) {
            addCriterion("ykt_code <>", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeGreaterThan(String value) {
            addCriterion("ykt_code >", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ykt_code >=", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeLessThan(String value) {
            addCriterion("ykt_code <", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeLessThanOrEqualTo(String value) {
            addCriterion("ykt_code <=", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeLike(String value) {
            addCriterion("ykt_code like", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeNotLike(String value) {
            addCriterion("ykt_code not like", value, "yktCode");
            return this;


        }

        public Criteria andYktCodeIn(List values) {
            addCriterion("ykt_code in", values, "yktCode");
            return this;


        }

        public Criteria andYktCodeNotIn(List values) {
            addCriterion("ykt_code not in", values, "yktCode");
            return this;


        }

        public Criteria andYktCodeBetween(String value1, String value2) {
            addCriterion("ykt_code between", value1, value2, "yktCode");
            return this;


        }

        public Criteria andYktCodeNotBetween(String value1, String value2) {
            addCriterion("ykt_code not between", value1, value2, "yktCode");
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
