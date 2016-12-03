package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CImageExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CImageExample() {
        oredCriteria = new ArrayList();


    }

    protected CImageExample(CImageExample example) {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;


        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;


        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;


        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;


        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;


        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
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

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;


        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;


        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return this;


        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return this;


        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return this;


        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return this;


        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return this;


        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return this;


        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return this;


        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return this;


        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return this;


        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return this;


        }

        public Criteria andImgurlIn(List values) {
            addCriterion("imgurl in", values, "imgurl");
            return this;


        }

        public Criteria andImgurlNotIn(List values) {
            addCriterion("imgurl not in", values, "imgurl");
            return this;


        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return this;


        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return this;


        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return this;


        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return this;


        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return this;


        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return this;


        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return this;


        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return this;


        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return this;


        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return this;


        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return this;


        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return this;


        }

        public Criteria andNameIn(List values) {
            addCriterion("name in", values, "name");
            return this;


        }

        public Criteria andNameNotIn(List values) {
            addCriterion("name not in", values, "name");
            return this;


        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return this;


        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return this;


        }

        public Criteria andBakIsNull() {
            addCriterion("bak is null");
            return this;


        }

        public Criteria andBakIsNotNull() {
            addCriterion("bak is not null");
            return this;


        }

        public Criteria andBakEqualTo(String value) {
            addCriterion("bak =", value, "bak");
            return this;


        }

        public Criteria andBakNotEqualTo(String value) {
            addCriterion("bak <>", value, "bak");
            return this;


        }

        public Criteria andBakGreaterThan(String value) {
            addCriterion("bak >", value, "bak");
            return this;


        }

        public Criteria andBakGreaterThanOrEqualTo(String value) {
            addCriterion("bak >=", value, "bak");
            return this;


        }

        public Criteria andBakLessThan(String value) {
            addCriterion("bak <", value, "bak");
            return this;


        }

        public Criteria andBakLessThanOrEqualTo(String value) {
            addCriterion("bak <=", value, "bak");
            return this;


        }

        public Criteria andBakLike(String value) {
            addCriterion("bak like", value, "bak");
            return this;


        }

        public Criteria andBakNotLike(String value) {
            addCriterion("bak not like", value, "bak");
            return this;


        }

        public Criteria andBakIn(List values) {
            addCriterion("bak in", values, "bak");
            return this;


        }

        public Criteria andBakNotIn(List values) {
            addCriterion("bak not in", values, "bak");
            return this;


        }

        public Criteria andBakBetween(String value1, String value2) {
            addCriterion("bak between", value1, value2, "bak");
            return this;


        }

        public Criteria andBakNotBetween(String value1, String value2) {
            addCriterion("bak not between", value1, value2, "bak");
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

        public Criteria andImgTypeIsNull() {
            addCriterion("img_type is null");
            return this;


        }

        public Criteria andImgTypeIsNotNull() {
            addCriterion("img_type is not null");
            return this;


        }

        public Criteria andImgTypeEqualTo(Integer value) {
            addCriterion("img_type =", value, "imgType");
            return this;


        }

        public Criteria andImgTypeNotEqualTo(Integer value) {
            addCriterion("img_type <>", value, "imgType");
            return this;


        }

        public Criteria andImgTypeGreaterThan(Integer value) {
            addCriterion("img_type >", value, "imgType");
            return this;


        }

        public Criteria andImgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_type >=", value, "imgType");
            return this;


        }

        public Criteria andImgTypeLessThan(Integer value) {
            addCriterion("img_type <", value, "imgType");
            return this;


        }

        public Criteria andImgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("img_type <=", value, "imgType");
            return this;


        }

        public Criteria andImgTypeIn(List values) {
            addCriterion("img_type in", values, "imgType");
            return this;


        }

        public Criteria andImgTypeNotIn(List values) {
            addCriterion("img_type not in", values, "imgType");
            return this;


        }

        public Criteria andImgTypeBetween(Integer value1, Integer value2) {
            addCriterion("img_type between", value1, value2, "imgType");
            return this;


        }

        public Criteria andImgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("img_type not between", value1, value2, "imgType");
            return this;


        }


    }


}
