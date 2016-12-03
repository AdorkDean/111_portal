package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxArticleExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxArticleExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxArticleExample(TLxArticleExample example) {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return this;


        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return this;


        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return this;


        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return this;


        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return this;


        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return this;


        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return this;


        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return this;


        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return this;


        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return this;


        }

        public Criteria andTitleIn(List values) {
            addCriterion("title in", values, "title");
            return this;


        }

        public Criteria andTitleNotIn(List values) {
            addCriterion("title not in", values, "title");
            return this;


        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return this;


        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return this;


        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return this;


        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return this;


        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return this;


        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return this;


        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return this;


        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return this;


        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return this;


        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return this;


        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return this;


        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return this;


        }

        public Criteria andShareImgIn(List values) {
            addCriterion("share_img in", values, "shareImg");
            return this;


        }

        public Criteria andShareImgNotIn(List values) {
            addCriterion("share_img not in", values, "shareImg");
            return this;


        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return this;


        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
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
