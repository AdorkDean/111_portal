package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CPositionListExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CPositionListExample() {
        oredCriteria = new ArrayList();


    }

    protected CPositionListExample(CPositionListExample example) {
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

        public Criteria andMPathIsNull() {
            addCriterion("m_path is null");
            return this;


        }

        public Criteria andMPathIsNotNull() {
            addCriterion("m_path is not null");
            return this;


        }

        public Criteria andMPathEqualTo(String value) {
            addCriterion("m_path =", value, "mPath");
            return this;


        }

        public Criteria andMPathNotEqualTo(String value) {
            addCriterion("m_path <>", value, "mPath");
            return this;


        }

        public Criteria andMPathGreaterThan(String value) {
            addCriterion("m_path >", value, "mPath");
            return this;


        }

        public Criteria andMPathGreaterThanOrEqualTo(String value) {
            addCriterion("m_path >=", value, "mPath");
            return this;


        }

        public Criteria andMPathLessThan(String value) {
            addCriterion("m_path <", value, "mPath");
            return this;


        }

        public Criteria andMPathLessThanOrEqualTo(String value) {
            addCriterion("m_path <=", value, "mPath");
            return this;


        }

        public Criteria andMPathLike(String value) {
            addCriterion("m_path like", value, "mPath");
            return this;


        }

        public Criteria andMPathNotLike(String value) {
            addCriterion("m_path not like", value, "mPath");
            return this;


        }

        public Criteria andMPathIn(List values) {
            addCriterion("m_path in", values, "mPath");
            return this;


        }

        public Criteria andMPathNotIn(List values) {
            addCriterion("m_path not in", values, "mPath");
            return this;


        }

        public Criteria andMPathBetween(String value1, String value2) {
            addCriterion("m_path between", value1, value2, "mPath");
            return this;


        }

        public Criteria andMPathNotBetween(String value1, String value2) {
            addCriterion("m_path not between", value1, value2, "mPath");
            return this;


        }

        public Criteria andMNameIsNull() {
            addCriterion("m_name is null");
            return this;


        }

        public Criteria andMNameIsNotNull() {
            addCriterion("m_name is not null");
            return this;


        }

        public Criteria andMNameEqualTo(String value) {
            addCriterion("m_name =", value, "mName");
            return this;


        }

        public Criteria andMNameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "mName");
            return this;


        }

        public Criteria andMNameGreaterThan(String value) {
            addCriterion("m_name >", value, "mName");
            return this;


        }

        public Criteria andMNameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "mName");
            return this;


        }

        public Criteria andMNameLessThan(String value) {
            addCriterion("m_name <", value, "mName");
            return this;


        }

        public Criteria andMNameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "mName");
            return this;


        }

        public Criteria andMNameLike(String value) {
            addCriterion("m_name like", value, "mName");
            return this;


        }

        public Criteria andMNameNotLike(String value) {
            addCriterion("m_name not like", value, "mName");
            return this;


        }

        public Criteria andMNameIn(List values) {
            addCriterion("m_name in", values, "mName");
            return this;


        }

        public Criteria andMNameNotIn(List values) {
            addCriterion("m_name not in", values, "mName");
            return this;


        }

        public Criteria andMNameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "mName");
            return this;


        }

        public Criteria andMNameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "mName");
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

        public Criteria andRuleIsNull() {
            addCriterion("rule is null");
            return this;


        }

        public Criteria andRuleIsNotNull() {
            addCriterion("rule is not null");
            return this;


        }

        public Criteria andRuleEqualTo(String value) {
            addCriterion("rule =", value, "rule");
            return this;


        }

        public Criteria andRuleNotEqualTo(String value) {
            addCriterion("rule <>", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThan(String value) {
            addCriterion("rule >", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThanOrEqualTo(String value) {
            addCriterion("rule >=", value, "rule");
            return this;


        }

        public Criteria andRuleLessThan(String value) {
            addCriterion("rule <", value, "rule");
            return this;


        }

        public Criteria andRuleLessThanOrEqualTo(String value) {
            addCriterion("rule <=", value, "rule");
            return this;


        }

        public Criteria andRuleLike(String value) {
            addCriterion("rule like", value, "rule");
            return this;


        }

        public Criteria andRuleNotLike(String value) {
            addCriterion("rule not like", value, "rule");
            return this;


        }

        public Criteria andRuleIn(List values) {
            addCriterion("rule in", values, "rule");
            return this;


        }

        public Criteria andRuleNotIn(List values) {
            addCriterion("rule not in", values, "rule");
            return this;


        }

        public Criteria andRuleBetween(String value1, String value2) {
            addCriterion("rule between", value1, value2, "rule");
            return this;


        }

        public Criteria andRuleNotBetween(String value1, String value2) {
            addCriterion("rule not between", value1, value2, "rule");
            return this;


        }

        public Criteria andIsreleaseIsNull() {
            addCriterion("isrelease is null");
            return this;


        }

        public Criteria andIsreleaseIsNotNull() {
            addCriterion("isrelease is not null");
            return this;


        }

        public Criteria andIsreleaseEqualTo(Integer value) {
            addCriterion("isrelease =", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseNotEqualTo(Integer value) {
            addCriterion("isrelease <>", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseGreaterThan(Integer value) {
            addCriterion("isrelease >", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("isrelease >=", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseLessThan(Integer value) {
            addCriterion("isrelease <", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseLessThanOrEqualTo(Integer value) {
            addCriterion("isrelease <=", value, "isrelease");
            return this;


        }

        public Criteria andIsreleaseIn(List values) {
            addCriterion("isrelease in", values, "isrelease");
            return this;


        }

        public Criteria andIsreleaseNotIn(List values) {
            addCriterion("isrelease not in", values, "isrelease");
            return this;


        }

        public Criteria andIsreleaseBetween(Integer value1, Integer value2) {
            addCriterion("isrelease between", value1, value2, "isrelease");
            return this;


        }

        public Criteria andIsreleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("isrelease not between", value1, value2, "isrelease");
            return this;


        }

        public Criteria andGenreIsNull() {
            addCriterion("genre is null");
            return this;


        }

        public Criteria andGenreIsNotNull() {
            addCriterion("genre is not null");
            return this;


        }

        public Criteria andGenreEqualTo(Integer value) {
            addCriterion("genre =", value, "genre");
            return this;


        }

        public Criteria andGenreNotEqualTo(Integer value) {
            addCriterion("genre <>", value, "genre");
            return this;


        }

        public Criteria andGenreGreaterThan(Integer value) {
            addCriterion("genre >", value, "genre");
            return this;


        }

        public Criteria andGenreGreaterThanOrEqualTo(Integer value) {
            addCriterion("genre >=", value, "genre");
            return this;


        }

        public Criteria andGenreLessThan(Integer value) {
            addCriterion("genre <", value, "genre");
            return this;


        }

        public Criteria andGenreLessThanOrEqualTo(Integer value) {
            addCriterion("genre <=", value, "genre");
            return this;


        }

        public Criteria andGenreIn(List values) {
            addCriterion("genre in", values, "genre");
            return this;


        }

        public Criteria andGenreNotIn(List values) {
            addCriterion("genre not in", values, "genre");
            return this;


        }

        public Criteria andGenreBetween(Integer value1, Integer value2) {
            addCriterion("genre between", value1, value2, "genre");
            return this;


        }

        public Criteria andGenreNotBetween(Integer value1, Integer value2) {
            addCriterion("genre not between", value1, value2, "genre");
            return this;


        }


    }


}
