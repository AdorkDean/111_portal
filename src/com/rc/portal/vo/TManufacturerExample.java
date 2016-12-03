package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TManufacturerExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TManufacturerExample() {
        oredCriteria = new ArrayList();


    }

    protected TManufacturerExample(TManufacturerExample example) {
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

        public Criteria andManuNameIsNull() {
            addCriterion("manu_name is null");
            return this;


        }

        public Criteria andManuNameIsNotNull() {
            addCriterion("manu_name is not null");
            return this;


        }

        public Criteria andManuNameEqualTo(String value) {
            addCriterion("manu_name =", value, "manuName");
            return this;


        }

        public Criteria andManuNameNotEqualTo(String value) {
            addCriterion("manu_name <>", value, "manuName");
            return this;


        }

        public Criteria andManuNameGreaterThan(String value) {
            addCriterion("manu_name >", value, "manuName");
            return this;


        }

        public Criteria andManuNameGreaterThanOrEqualTo(String value) {
            addCriterion("manu_name >=", value, "manuName");
            return this;


        }

        public Criteria andManuNameLessThan(String value) {
            addCriterion("manu_name <", value, "manuName");
            return this;


        }

        public Criteria andManuNameLessThanOrEqualTo(String value) {
            addCriterion("manu_name <=", value, "manuName");
            return this;


        }

        public Criteria andManuNameLike(String value) {
            addCriterion("manu_name like", value, "manuName");
            return this;


        }

        public Criteria andManuNameNotLike(String value) {
            addCriterion("manu_name not like", value, "manuName");
            return this;


        }

        public Criteria andManuNameIn(List values) {
            addCriterion("manu_name in", values, "manuName");
            return this;


        }

        public Criteria andManuNameNotIn(List values) {
            addCriterion("manu_name not in", values, "manuName");
            return this;


        }

        public Criteria andManuNameBetween(String value1, String value2) {
            addCriterion("manu_name between", value1, value2, "manuName");
            return this;


        }

        public Criteria andManuNameNotBetween(String value1, String value2) {
            addCriterion("manu_name not between", value1, value2, "manuName");
            return this;


        }

        public Criteria andManuLogoIsNull() {
            addCriterion("manu_logo is null");
            return this;


        }

        public Criteria andManuLogoIsNotNull() {
            addCriterion("manu_logo is not null");
            return this;


        }

        public Criteria andManuLogoEqualTo(String value) {
            addCriterion("manu_logo =", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoNotEqualTo(String value) {
            addCriterion("manu_logo <>", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoGreaterThan(String value) {
            addCriterion("manu_logo >", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoGreaterThanOrEqualTo(String value) {
            addCriterion("manu_logo >=", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoLessThan(String value) {
            addCriterion("manu_logo <", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoLessThanOrEqualTo(String value) {
            addCriterion("manu_logo <=", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoLike(String value) {
            addCriterion("manu_logo like", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoNotLike(String value) {
            addCriterion("manu_logo not like", value, "manuLogo");
            return this;


        }

        public Criteria andManuLogoIn(List values) {
            addCriterion("manu_logo in", values, "manuLogo");
            return this;


        }

        public Criteria andManuLogoNotIn(List values) {
            addCriterion("manu_logo not in", values, "manuLogo");
            return this;


        }

        public Criteria andManuLogoBetween(String value1, String value2) {
            addCriterion("manu_logo between", value1, value2, "manuLogo");
            return this;


        }

        public Criteria andManuLogoNotBetween(String value1, String value2) {
            addCriterion("manu_logo not between", value1, value2, "manuLogo");
            return this;


        }

        public Criteria andManuDescribeIsNull() {
            addCriterion("manu_describe is null");
            return this;


        }

        public Criteria andManuDescribeIsNotNull() {
            addCriterion("manu_describe is not null");
            return this;


        }

        public Criteria andManuDescribeEqualTo(String value) {
            addCriterion("manu_describe =", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeNotEqualTo(String value) {
            addCriterion("manu_describe <>", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeGreaterThan(String value) {
            addCriterion("manu_describe >", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("manu_describe >=", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeLessThan(String value) {
            addCriterion("manu_describe <", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeLessThanOrEqualTo(String value) {
            addCriterion("manu_describe <=", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeLike(String value) {
            addCriterion("manu_describe like", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeNotLike(String value) {
            addCriterion("manu_describe not like", value, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeIn(List values) {
            addCriterion("manu_describe in", values, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeNotIn(List values) {
            addCriterion("manu_describe not in", values, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeBetween(String value1, String value2) {
            addCriterion("manu_describe between", value1, value2, "manuDescribe");
            return this;


        }

        public Criteria andManuDescribeNotBetween(String value1, String value2) {
            addCriterion("manu_describe not between", value1, value2, "manuDescribe");
            return this;


        }

        public Criteria andSloganIsNull() {
            addCriterion("slogan is null");
            return this;


        }

        public Criteria andSloganIsNotNull() {
            addCriterion("slogan is not null");
            return this;


        }

        public Criteria andSloganEqualTo(String value) {
            addCriterion("slogan =", value, "slogan");
            return this;


        }

        public Criteria andSloganNotEqualTo(String value) {
            addCriterion("slogan <>", value, "slogan");
            return this;


        }

        public Criteria andSloganGreaterThan(String value) {
            addCriterion("slogan >", value, "slogan");
            return this;


        }

        public Criteria andSloganGreaterThanOrEqualTo(String value) {
            addCriterion("slogan >=", value, "slogan");
            return this;


        }

        public Criteria andSloganLessThan(String value) {
            addCriterion("slogan <", value, "slogan");
            return this;


        }

        public Criteria andSloganLessThanOrEqualTo(String value) {
            addCriterion("slogan <=", value, "slogan");
            return this;


        }

        public Criteria andSloganLike(String value) {
            addCriterion("slogan like", value, "slogan");
            return this;


        }

        public Criteria andSloganNotLike(String value) {
            addCriterion("slogan not like", value, "slogan");
            return this;


        }

        public Criteria andSloganIn(List values) {
            addCriterion("slogan in", values, "slogan");
            return this;


        }

        public Criteria andSloganNotIn(List values) {
            addCriterion("slogan not in", values, "slogan");
            return this;


        }

        public Criteria andSloganBetween(String value1, String value2) {
            addCriterion("slogan between", value1, value2, "slogan");
            return this;


        }

        public Criteria andSloganNotBetween(String value1, String value2) {
            addCriterion("slogan not between", value1, value2, "slogan");
            return this;


        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return this;


        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return this;


        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return this;


        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return this;


        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return this;


        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return this;


        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return this;


        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return this;


        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return this;


        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return this;


        }

        public Criteria andRemarksIn(List values) {
            addCriterion("remarks in", values, "remarks");
            return this;


        }

        public Criteria andRemarksNotIn(List values) {
            addCriterion("remarks not in", values, "remarks");
            return this;


        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return this;


        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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


    }


}
