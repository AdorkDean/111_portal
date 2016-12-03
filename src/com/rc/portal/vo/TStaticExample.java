package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TStaticExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TStaticExample() {
        oredCriteria = new ArrayList();


    }

    protected TStaticExample(TStaticExample example) {
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

        public Criteria andStaticNameIsNull() {
            addCriterion("static_name is null");
            return this;


        }

        public Criteria andStaticNameIsNotNull() {
            addCriterion("static_name is not null");
            return this;


        }

        public Criteria andStaticNameEqualTo(String value) {
            addCriterion("static_name =", value, "staticName");
            return this;


        }

        public Criteria andStaticNameNotEqualTo(String value) {
            addCriterion("static_name <>", value, "staticName");
            return this;


        }

        public Criteria andStaticNameGreaterThan(String value) {
            addCriterion("static_name >", value, "staticName");
            return this;


        }

        public Criteria andStaticNameGreaterThanOrEqualTo(String value) {
            addCriterion("static_name >=", value, "staticName");
            return this;


        }

        public Criteria andStaticNameLessThan(String value) {
            addCriterion("static_name <", value, "staticName");
            return this;


        }

        public Criteria andStaticNameLessThanOrEqualTo(String value) {
            addCriterion("static_name <=", value, "staticName");
            return this;


        }

        public Criteria andStaticNameLike(String value) {
            addCriterion("static_name like", value, "staticName");
            return this;


        }

        public Criteria andStaticNameNotLike(String value) {
            addCriterion("static_name not like", value, "staticName");
            return this;


        }

        public Criteria andStaticNameIn(List values) {
            addCriterion("static_name in", values, "staticName");
            return this;


        }

        public Criteria andStaticNameNotIn(List values) {
            addCriterion("static_name not in", values, "staticName");
            return this;


        }

        public Criteria andStaticNameBetween(String value1, String value2) {
            addCriterion("static_name between", value1, value2, "staticName");
            return this;


        }

        public Criteria andStaticNameNotBetween(String value1, String value2) {
            addCriterion("static_name not between", value1, value2, "staticName");
            return this;


        }

        public Criteria andStaticMehtodIsNull() {
            addCriterion("static_mehtod is null");
            return this;


        }

        public Criteria andStaticMehtodIsNotNull() {
            addCriterion("static_mehtod is not null");
            return this;


        }

        public Criteria andStaticMehtodEqualTo(String value) {
            addCriterion("static_mehtod =", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodNotEqualTo(String value) {
            addCriterion("static_mehtod <>", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodGreaterThan(String value) {
            addCriterion("static_mehtod >", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodGreaterThanOrEqualTo(String value) {
            addCriterion("static_mehtod >=", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodLessThan(String value) {
            addCriterion("static_mehtod <", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodLessThanOrEqualTo(String value) {
            addCriterion("static_mehtod <=", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodLike(String value) {
            addCriterion("static_mehtod like", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodNotLike(String value) {
            addCriterion("static_mehtod not like", value, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodIn(List values) {
            addCriterion("static_mehtod in", values, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodNotIn(List values) {
            addCriterion("static_mehtod not in", values, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodBetween(String value1, String value2) {
            addCriterion("static_mehtod between", value1, value2, "staticMehtod");
            return this;


        }

        public Criteria andStaticMehtodNotBetween(String value1, String value2) {
            addCriterion("static_mehtod not between", value1, value2, "staticMehtod");
            return this;


        }

        public Criteria andTemplatePathIsNull() {
            addCriterion("template_path is null");
            return this;


        }

        public Criteria andTemplatePathIsNotNull() {
            addCriterion("template_path is not null");
            return this;


        }

        public Criteria andTemplatePathEqualTo(String value) {
            addCriterion("template_path =", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathNotEqualTo(String value) {
            addCriterion("template_path <>", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathGreaterThan(String value) {
            addCriterion("template_path >", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathGreaterThanOrEqualTo(String value) {
            addCriterion("template_path >=", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathLessThan(String value) {
            addCriterion("template_path <", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathLessThanOrEqualTo(String value) {
            addCriterion("template_path <=", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathLike(String value) {
            addCriterion("template_path like", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathNotLike(String value) {
            addCriterion("template_path not like", value, "templatePath");
            return this;


        }

        public Criteria andTemplatePathIn(List values) {
            addCriterion("template_path in", values, "templatePath");
            return this;


        }

        public Criteria andTemplatePathNotIn(List values) {
            addCriterion("template_path not in", values, "templatePath");
            return this;


        }

        public Criteria andTemplatePathBetween(String value1, String value2) {
            addCriterion("template_path between", value1, value2, "templatePath");
            return this;


        }

        public Criteria andTemplatePathNotBetween(String value1, String value2) {
            addCriterion("template_path not between", value1, value2, "templatePath");
            return this;


        }

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return this;


        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return this;


        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return this;


        }

        public Criteria andTemplateNameIn(List values) {
            addCriterion("template_name in", values, "templateName");
            return this;


        }

        public Criteria andTemplateNameNotIn(List values) {
            addCriterion("template_name not in", values, "templateName");
            return this;


        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return this;


        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
            return this;


        }

        public Criteria andOutPathIsNull() {
            addCriterion("out_path is null");
            return this;


        }

        public Criteria andOutPathIsNotNull() {
            addCriterion("out_path is not null");
            return this;


        }

        public Criteria andOutPathEqualTo(String value) {
            addCriterion("out_path =", value, "outPath");
            return this;


        }

        public Criteria andOutPathNotEqualTo(String value) {
            addCriterion("out_path <>", value, "outPath");
            return this;


        }

        public Criteria andOutPathGreaterThan(String value) {
            addCriterion("out_path >", value, "outPath");
            return this;


        }

        public Criteria andOutPathGreaterThanOrEqualTo(String value) {
            addCriterion("out_path >=", value, "outPath");
            return this;


        }

        public Criteria andOutPathLessThan(String value) {
            addCriterion("out_path <", value, "outPath");
            return this;


        }

        public Criteria andOutPathLessThanOrEqualTo(String value) {
            addCriterion("out_path <=", value, "outPath");
            return this;


        }

        public Criteria andOutPathLike(String value) {
            addCriterion("out_path like", value, "outPath");
            return this;


        }

        public Criteria andOutPathNotLike(String value) {
            addCriterion("out_path not like", value, "outPath");
            return this;


        }

        public Criteria andOutPathIn(List values) {
            addCriterion("out_path in", values, "outPath");
            return this;


        }

        public Criteria andOutPathNotIn(List values) {
            addCriterion("out_path not in", values, "outPath");
            return this;


        }

        public Criteria andOutPathBetween(String value1, String value2) {
            addCriterion("out_path between", value1, value2, "outPath");
            return this;


        }

        public Criteria andOutPathNotBetween(String value1, String value2) {
            addCriterion("out_path not between", value1, value2, "outPath");
            return this;


        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return this;


        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return this;


        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return this;


        }

        public Criteria andUpdateDateIn(List values) {
            addCriterion("update_date in", values, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotIn(List values) {
            addCriterion("update_date not in", values, "updateDate");
            return this;


        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return this;


        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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


    }


}
