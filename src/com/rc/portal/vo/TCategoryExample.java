package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCategoryExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCategoryExample() {
        oredCriteria = new ArrayList();


    }

    protected TCategoryExample(TCategoryExample example) {
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

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return this;


        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return this;


        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return this;


        }

        public Criteria andCategoryNameIn(List values) {
            addCriterion("category_name in", values, "categoryName");
            return this;


        }

        public Criteria andCategoryNameNotIn(List values) {
            addCriterion("category_name not in", values, "categoryName");
            return this;


        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return this;


        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return this;


        }

        public Criteria andCategoryDescribeIsNull() {
            addCriterion("category_describe is null");
            return this;


        }

        public Criteria andCategoryDescribeIsNotNull() {
            addCriterion("category_describe is not null");
            return this;


        }

        public Criteria andCategoryDescribeEqualTo(String value) {
            addCriterion("category_describe =", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeNotEqualTo(String value) {
            addCriterion("category_describe <>", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeGreaterThan(String value) {
            addCriterion("category_describe >", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("category_describe >=", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeLessThan(String value) {
            addCriterion("category_describe <", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeLessThanOrEqualTo(String value) {
            addCriterion("category_describe <=", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeLike(String value) {
            addCriterion("category_describe like", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeNotLike(String value) {
            addCriterion("category_describe not like", value, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeIn(List values) {
            addCriterion("category_describe in", values, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeNotIn(List values) {
            addCriterion("category_describe not in", values, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeBetween(String value1, String value2) {
            addCriterion("category_describe between", value1, value2, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryDescribeNotBetween(String value1, String value2) {
            addCriterion("category_describe not between", value1, value2, "categoryDescribe");
            return this;


        }

        public Criteria andCategoryLevelIsNull() {
            addCriterion("category_level is null");
            return this;


        }

        public Criteria andCategoryLevelIsNotNull() {
            addCriterion("category_level is not null");
            return this;


        }

        public Criteria andCategoryLevelEqualTo(Integer value) {
            addCriterion("category_level =", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelNotEqualTo(Integer value) {
            addCriterion("category_level <>", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelGreaterThan(Integer value) {
            addCriterion("category_level >", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_level >=", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelLessThan(Integer value) {
            addCriterion("category_level <", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelLessThanOrEqualTo(Integer value) {
            addCriterion("category_level <=", value, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelIn(List values) {
            addCriterion("category_level in", values, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelNotIn(List values) {
            addCriterion("category_level not in", values, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelBetween(Integer value1, Integer value2) {
            addCriterion("category_level between", value1, value2, "categoryLevel");
            return this;


        }

        public Criteria andCategoryLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("category_level not between", value1, value2, "categoryLevel");
            return this;


        }

        public Criteria andAllParentIdIsNull() {
            addCriterion("all_parent_id is null");
            return this;


        }

        public Criteria andAllParentIdIsNotNull() {
            addCriterion("all_parent_id is not null");
            return this;


        }

        public Criteria andAllParentIdEqualTo(String value) {
            addCriterion("all_parent_id =", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdNotEqualTo(String value) {
            addCriterion("all_parent_id <>", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdGreaterThan(String value) {
            addCriterion("all_parent_id >", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("all_parent_id >=", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdLessThan(String value) {
            addCriterion("all_parent_id <", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdLessThanOrEqualTo(String value) {
            addCriterion("all_parent_id <=", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdLike(String value) {
            addCriterion("all_parent_id like", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdNotLike(String value) {
            addCriterion("all_parent_id not like", value, "allParentId");
            return this;


        }

        public Criteria andAllParentIdIn(List values) {
            addCriterion("all_parent_id in", values, "allParentId");
            return this;


        }

        public Criteria andAllParentIdNotIn(List values) {
            addCriterion("all_parent_id not in", values, "allParentId");
            return this;


        }

        public Criteria andAllParentIdBetween(String value1, String value2) {
            addCriterion("all_parent_id between", value1, value2, "allParentId");
            return this;


        }

        public Criteria andAllParentIdNotBetween(String value1, String value2) {
            addCriterion("all_parent_id not between", value1, value2, "allParentId");
            return this;


        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return this;


        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return this;


        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return this;


        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return this;


        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return this;


        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return this;


        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return this;


        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return this;


        }

        public Criteria andParentIdIn(List values) {
            addCriterion("parent_id in", values, "parentId");
            return this;


        }

        public Criteria andParentIdNotIn(List values) {
            addCriterion("parent_id not in", values, "parentId");
            return this;


        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return this;


        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return this;


        }

        public Criteria andIsWapIsNull() {
            addCriterion("is_wap is null");
            return this;


        }

        public Criteria andIsWapIsNotNull() {
            addCriterion("is_wap is not null");
            return this;


        }

        public Criteria andIsWapEqualTo(Integer value) {
            addCriterion("is_wap =", value, "isWap");
            return this;


        }

        public Criteria andIsWapNotEqualTo(Integer value) {
            addCriterion("is_wap <>", value, "isWap");
            return this;


        }

        public Criteria andIsWapGreaterThan(Integer value) {
            addCriterion("is_wap >", value, "isWap");
            return this;


        }

        public Criteria andIsWapGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_wap >=", value, "isWap");
            return this;


        }

        public Criteria andIsWapLessThan(Integer value) {
            addCriterion("is_wap <", value, "isWap");
            return this;


        }

        public Criteria andIsWapLessThanOrEqualTo(Integer value) {
            addCriterion("is_wap <=", value, "isWap");
            return this;


        }

        public Criteria andIsWapIn(List values) {
            addCriterion("is_wap in", values, "isWap");
            return this;


        }

        public Criteria andIsWapNotIn(List values) {
            addCriterion("is_wap not in", values, "isWap");
            return this;


        }

        public Criteria andIsWapBetween(Integer value1, Integer value2) {
            addCriterion("is_wap between", value1, value2, "isWap");
            return this;


        }

        public Criteria andIsWapNotBetween(Integer value1, Integer value2) {
            addCriterion("is_wap not between", value1, value2, "isWap");
            return this;


        }

        public Criteria andIsAppIsNull() {
            addCriterion("is_app is null");
            return this;


        }

        public Criteria andIsAppIsNotNull() {
            addCriterion("is_app is not null");
            return this;


        }

        public Criteria andIsAppEqualTo(Integer value) {
            addCriterion("is_app =", value, "isApp");
            return this;


        }

        public Criteria andIsAppNotEqualTo(Integer value) {
            addCriterion("is_app <>", value, "isApp");
            return this;


        }

        public Criteria andIsAppGreaterThan(Integer value) {
            addCriterion("is_app >", value, "isApp");
            return this;


        }

        public Criteria andIsAppGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_app >=", value, "isApp");
            return this;


        }

        public Criteria andIsAppLessThan(Integer value) {
            addCriterion("is_app <", value, "isApp");
            return this;


        }

        public Criteria andIsAppLessThanOrEqualTo(Integer value) {
            addCriterion("is_app <=", value, "isApp");
            return this;


        }

        public Criteria andIsAppIn(List values) {
            addCriterion("is_app in", values, "isApp");
            return this;


        }

        public Criteria andIsAppNotIn(List values) {
            addCriterion("is_app not in", values, "isApp");
            return this;


        }

        public Criteria andIsAppBetween(Integer value1, Integer value2) {
            addCriterion("is_app between", value1, value2, "isApp");
            return this;


        }

        public Criteria andIsAppNotBetween(Integer value1, Integer value2) {
            addCriterion("is_app not between", value1, value2, "isApp");
            return this;


        }

        public Criteria andIsPcIsNull() {
            addCriterion("is_pc is null");
            return this;


        }

        public Criteria andIsPcIsNotNull() {
            addCriterion("is_pc is not null");
            return this;


        }

        public Criteria andIsPcEqualTo(Integer value) {
            addCriterion("is_pc =", value, "isPc");
            return this;


        }

        public Criteria andIsPcNotEqualTo(Integer value) {
            addCriterion("is_pc <>", value, "isPc");
            return this;


        }

        public Criteria andIsPcGreaterThan(Integer value) {
            addCriterion("is_pc >", value, "isPc");
            return this;


        }

        public Criteria andIsPcGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pc >=", value, "isPc");
            return this;


        }

        public Criteria andIsPcLessThan(Integer value) {
            addCriterion("is_pc <", value, "isPc");
            return this;


        }

        public Criteria andIsPcLessThanOrEqualTo(Integer value) {
            addCriterion("is_pc <=", value, "isPc");
            return this;


        }

        public Criteria andIsPcIn(List values) {
            addCriterion("is_pc in", values, "isPc");
            return this;


        }

        public Criteria andIsPcNotIn(List values) {
            addCriterion("is_pc not in", values, "isPc");
            return this;


        }

        public Criteria andIsPcBetween(Integer value1, Integer value2) {
            addCriterion("is_pc between", value1, value2, "isPc");
            return this;


        }

        public Criteria andIsPcNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pc not between", value1, value2, "isPc");
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

        public Criteria andSeoTitleIsNull() {
            addCriterion("seo_title is null");
            return this;


        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("seo_title is not null");
            return this;


        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("seo_title =", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("seo_title <>", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("seo_title >", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("seo_title >=", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("seo_title <", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("seo_title <=", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("seo_title like", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("seo_title not like", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleIn(List values) {
            addCriterion("seo_title in", values, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotIn(List values) {
            addCriterion("seo_title not in", values, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("seo_title between", value1, value2, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("seo_title not between", value1, value2, "seoTitle");
            return this;


        }

        public Criteria andSeoKeywordIsNull() {
            addCriterion("seo_keyword is null");
            return this;


        }

        public Criteria andSeoKeywordIsNotNull() {
            addCriterion("seo_keyword is not null");
            return this;


        }

        public Criteria andSeoKeywordEqualTo(String value) {
            addCriterion("seo_keyword =", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotEqualTo(String value) {
            addCriterion("seo_keyword <>", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordGreaterThan(String value) {
            addCriterion("seo_keyword >", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("seo_keyword >=", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLessThan(String value) {
            addCriterion("seo_keyword <", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLessThanOrEqualTo(String value) {
            addCriterion("seo_keyword <=", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLike(String value) {
            addCriterion("seo_keyword like", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotLike(String value) {
            addCriterion("seo_keyword not like", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordIn(List values) {
            addCriterion("seo_keyword in", values, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotIn(List values) {
            addCriterion("seo_keyword not in", values, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordBetween(String value1, String value2) {
            addCriterion("seo_keyword between", value1, value2, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotBetween(String value1, String value2) {
            addCriterion("seo_keyword not between", value1, value2, "seoKeyword");
            return this;


        }

        public Criteria andSeoDescribeIsNull() {
            addCriterion("seo_describe is null");
            return this;


        }

        public Criteria andSeoDescribeIsNotNull() {
            addCriterion("seo_describe is not null");
            return this;


        }

        public Criteria andSeoDescribeEqualTo(String value) {
            addCriterion("seo_describe =", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotEqualTo(String value) {
            addCriterion("seo_describe <>", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeGreaterThan(String value) {
            addCriterion("seo_describe >", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("seo_describe >=", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLessThan(String value) {
            addCriterion("seo_describe <", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLessThanOrEqualTo(String value) {
            addCriterion("seo_describe <=", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLike(String value) {
            addCriterion("seo_describe like", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotLike(String value) {
            addCriterion("seo_describe not like", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeIn(List values) {
            addCriterion("seo_describe in", values, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotIn(List values) {
            addCriterion("seo_describe not in", values, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeBetween(String value1, String value2) {
            addCriterion("seo_describe between", value1, value2, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotBetween(String value1, String value2) {
            addCriterion("seo_describe not between", value1, value2, "seoDescribe");
            return this;


        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return this;


        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return this;


        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return this;


        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return this;


        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return this;


        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return this;


        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return this;


        }

        public Criteria andWeightIn(List values) {
            addCriterion("weight in", values, "weight");
            return this;


        }

        public Criteria andWeightNotIn(List values) {
            addCriterion("weight not in", values, "weight");
            return this;


        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return this;


        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return this;


        }


    }


}
