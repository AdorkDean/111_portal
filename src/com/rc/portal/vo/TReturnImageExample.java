package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TReturnImageExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TReturnImageExample() {
        oredCriteria = new ArrayList();


    }

    protected TReturnImageExample(TReturnImageExample example) {
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

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return this;


        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return this;


        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return this;


        }

        public Criteria andImageUrlIn(List values) {
            addCriterion("image_url in", values, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotIn(List values) {
            addCriterion("image_url not in", values, "imageUrl");
            return this;


        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return this;


        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return this;


        }

        public Criteria andReturnIdIsNull() {
            addCriterion("return_id is null");
            return this;


        }

        public Criteria andReturnIdIsNotNull() {
            addCriterion("return_id is not null");
            return this;


        }

        public Criteria andReturnIdEqualTo(Long value) {
            addCriterion("return_id =", value, "returnId");
            return this;


        }

        public Criteria andReturnIdNotEqualTo(Long value) {
            addCriterion("return_id <>", value, "returnId");
            return this;


        }

        public Criteria andReturnIdGreaterThan(Long value) {
            addCriterion("return_id >", value, "returnId");
            return this;


        }

        public Criteria andReturnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("return_id >=", value, "returnId");
            return this;


        }

        public Criteria andReturnIdLessThan(Long value) {
            addCriterion("return_id <", value, "returnId");
            return this;


        }

        public Criteria andReturnIdLessThanOrEqualTo(Long value) {
            addCriterion("return_id <=", value, "returnId");
            return this;


        }

        public Criteria andReturnIdIn(List values) {
            addCriterion("return_id in", values, "returnId");
            return this;


        }

        public Criteria andReturnIdNotIn(List values) {
            addCriterion("return_id not in", values, "returnId");
            return this;


        }

        public Criteria andReturnIdBetween(Long value1, Long value2) {
            addCriterion("return_id between", value1, value2, "returnId");
            return this;


        }

        public Criteria andReturnIdNotBetween(Long value1, Long value2) {
            addCriterion("return_id not between", value1, value2, "returnId");
            return this;


        }


    }


}
