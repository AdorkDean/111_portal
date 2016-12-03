package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TBrandExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TBrandExample() {
        oredCriteria = new ArrayList();


    }

    protected TBrandExample(TBrandExample example) {
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

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return this;


        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return this;


        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return this;


        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return this;


        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return this;


        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return this;


        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return this;


        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return this;


        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return this;


        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return this;


        }

        public Criteria andBrandNameIn(List values) {
            addCriterion("brand_name in", values, "brandName");
            return this;


        }

        public Criteria andBrandNameNotIn(List values) {
            addCriterion("brand_name not in", values, "brandName");
            return this;


        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return this;


        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return this;


        }

        public Criteria andBrandTypeIsNull() {
            addCriterion("brand_type is null");
            return this;


        }

        public Criteria andBrandTypeIsNotNull() {
            addCriterion("brand_type is not null");
            return this;


        }

        public Criteria andBrandTypeEqualTo(Integer value) {
            addCriterion("brand_type =", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeNotEqualTo(Integer value) {
            addCriterion("brand_type <>", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeGreaterThan(Integer value) {
            addCriterion("brand_type >", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_type >=", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeLessThan(Integer value) {
            addCriterion("brand_type <", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeLessThanOrEqualTo(Integer value) {
            addCriterion("brand_type <=", value, "brandType");
            return this;


        }

        public Criteria andBrandTypeIn(List values) {
            addCriterion("brand_type in", values, "brandType");
            return this;


        }

        public Criteria andBrandTypeNotIn(List values) {
            addCriterion("brand_type not in", values, "brandType");
            return this;


        }

        public Criteria andBrandTypeBetween(Integer value1, Integer value2) {
            addCriterion("brand_type between", value1, value2, "brandType");
            return this;


        }

        public Criteria andBrandTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_type not between", value1, value2, "brandType");
            return this;


        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return this;


        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return this;


        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return this;


        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return this;


        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return this;


        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return this;


        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return this;


        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return this;


        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return this;


        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return this;


        }

        public Criteria andLogoIn(List values) {
            addCriterion("logo in", values, "logo");
            return this;


        }

        public Criteria andLogoNotIn(List values) {
            addCriterion("logo not in", values, "logo");
            return this;


        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return this;


        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return this;


        }

        public Criteria andBrandUrlIsNull() {
            addCriterion("brand_url is null");
            return this;


        }

        public Criteria andBrandUrlIsNotNull() {
            addCriterion("brand_url is not null");
            return this;


        }

        public Criteria andBrandUrlEqualTo(String value) {
            addCriterion("brand_url =", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlNotEqualTo(String value) {
            addCriterion("brand_url <>", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlGreaterThan(String value) {
            addCriterion("brand_url >", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlGreaterThanOrEqualTo(String value) {
            addCriterion("brand_url >=", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlLessThan(String value) {
            addCriterion("brand_url <", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlLessThanOrEqualTo(String value) {
            addCriterion("brand_url <=", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlLike(String value) {
            addCriterion("brand_url like", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlNotLike(String value) {
            addCriterion("brand_url not like", value, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlIn(List values) {
            addCriterion("brand_url in", values, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlNotIn(List values) {
            addCriterion("brand_url not in", values, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlBetween(String value1, String value2) {
            addCriterion("brand_url between", value1, value2, "brandUrl");
            return this;


        }

        public Criteria andBrandUrlNotBetween(String value1, String value2) {
            addCriterion("brand_url not between", value1, value2, "brandUrl");
            return this;


        }

        public Criteria andBrandInfoIsNull() {
            addCriterion("brand_info is null");
            return this;


        }

        public Criteria andBrandInfoIsNotNull() {
            addCriterion("brand_info is not null");
            return this;


        }

        public Criteria andBrandInfoEqualTo(String value) {
            addCriterion("brand_info =", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoNotEqualTo(String value) {
            addCriterion("brand_info <>", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoGreaterThan(String value) {
            addCriterion("brand_info >", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoGreaterThanOrEqualTo(String value) {
            addCriterion("brand_info >=", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoLessThan(String value) {
            addCriterion("brand_info <", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoLessThanOrEqualTo(String value) {
            addCriterion("brand_info <=", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoLike(String value) {
            addCriterion("brand_info like", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoNotLike(String value) {
            addCriterion("brand_info not like", value, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoIn(List values) {
            addCriterion("brand_info in", values, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoNotIn(List values) {
            addCriterion("brand_info not in", values, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoBetween(String value1, String value2) {
            addCriterion("brand_info between", value1, value2, "brandInfo");
            return this;


        }

        public Criteria andBrandInfoNotBetween(String value1, String value2) {
            addCriterion("brand_info not between", value1, value2, "brandInfo");
            return this;


        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return this;


        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return this;


        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return this;


        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return this;


        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return this;


        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return this;


        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return this;


        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return this;


        }

        public Criteria andPinyinIn(List values) {
            addCriterion("pinyin in", values, "pinyin");
            return this;


        }

        public Criteria andPinyinNotIn(List values) {
            addCriterion("pinyin not in", values, "pinyin");
            return this;


        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return this;


        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
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


    }


}
