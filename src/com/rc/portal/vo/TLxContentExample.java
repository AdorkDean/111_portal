package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxContentExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxContentExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxContentExample(TLxContentExample example) {
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

        public Criteria andTileIsNull() {
            addCriterion("tile is null");
            return this;


        }

        public Criteria andTileIsNotNull() {
            addCriterion("tile is not null");
            return this;


        }

        public Criteria andTileEqualTo(String value) {
            addCriterion("tile =", value, "tile");
            return this;


        }

        public Criteria andTileNotEqualTo(String value) {
            addCriterion("tile <>", value, "tile");
            return this;


        }

        public Criteria andTileGreaterThan(String value) {
            addCriterion("tile >", value, "tile");
            return this;


        }

        public Criteria andTileGreaterThanOrEqualTo(String value) {
            addCriterion("tile >=", value, "tile");
            return this;


        }

        public Criteria andTileLessThan(String value) {
            addCriterion("tile <", value, "tile");
            return this;


        }

        public Criteria andTileLessThanOrEqualTo(String value) {
            addCriterion("tile <=", value, "tile");
            return this;


        }

        public Criteria andTileLike(String value) {
            addCriterion("tile like", value, "tile");
            return this;


        }

        public Criteria andTileNotLike(String value) {
            addCriterion("tile not like", value, "tile");
            return this;


        }

        public Criteria andTileIn(List values) {
            addCriterion("tile in", values, "tile");
            return this;


        }

        public Criteria andTileNotIn(List values) {
            addCriterion("tile not in", values, "tile");
            return this;


        }

        public Criteria andTileBetween(String value1, String value2) {
            addCriterion("tile between", value1, value2, "tile");
            return this;


        }

        public Criteria andTileNotBetween(String value1, String value2) {
            addCriterion("tile not between", value1, value2, "tile");
            return this;


        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return this;


        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return this;


        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return this;


        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return this;


        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return this;


        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return this;


        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return this;


        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return this;


        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return this;


        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return this;


        }

        public Criteria andContextIn(List values) {
            addCriterion("context in", values, "context");
            return this;


        }

        public Criteria andContextNotIn(List values) {
            addCriterion("context not in", values, "context");
            return this;


        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return this;


        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
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
