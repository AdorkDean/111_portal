package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxLookCollectionExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxLookCollectionExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxLookCollectionExample(TLxLookCollectionExample example) {
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

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return this;


        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return this;


        }

        public Criteria andRelationIdEqualTo(Long value) {
            addCriterion("relation_id =", value, "relationId");
            return this;


        }

        public Criteria andRelationIdNotEqualTo(Long value) {
            addCriterion("relation_id <>", value, "relationId");
            return this;


        }

        public Criteria andRelationIdGreaterThan(Long value) {
            addCriterion("relation_id >", value, "relationId");
            return this;


        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_id >=", value, "relationId");
            return this;


        }

        public Criteria andRelationIdLessThan(Long value) {
            addCriterion("relation_id <", value, "relationId");
            return this;


        }

        public Criteria andRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_id <=", value, "relationId");
            return this;


        }

        public Criteria andRelationIdIn(List values) {
            addCriterion("relation_id in", values, "relationId");
            return this;


        }

        public Criteria andRelationIdNotIn(List values) {
            addCriterion("relation_id not in", values, "relationId");
            return this;


        }

        public Criteria andRelationIdBetween(Long value1, Long value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return this;


        }

        public Criteria andRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return this;


        }

        public Criteria andRelationTypeIsNull() {
            addCriterion("relation_type is null");
            return this;


        }

        public Criteria andRelationTypeIsNotNull() {
            addCriterion("relation_type is not null");
            return this;


        }

        public Criteria andRelationTypeEqualTo(Integer value) {
            addCriterion("relation_type =", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeNotEqualTo(Integer value) {
            addCriterion("relation_type <>", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeGreaterThan(Integer value) {
            addCriterion("relation_type >", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_type >=", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeLessThan(Integer value) {
            addCriterion("relation_type <", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("relation_type <=", value, "relationType");
            return this;


        }

        public Criteria andRelationTypeIn(List values) {
            addCriterion("relation_type in", values, "relationType");
            return this;


        }

        public Criteria andRelationTypeNotIn(List values) {
            addCriterion("relation_type not in", values, "relationType");
            return this;


        }

        public Criteria andRelationTypeBetween(Integer value1, Integer value2) {
            addCriterion("relation_type between", value1, value2, "relationType");
            return this;


        }

        public Criteria andRelationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("relation_type not between", value1, value2, "relationType");
            return this;


        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return this;


        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return this;


        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return this;


        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return this;


        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return this;


        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return this;


        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return this;


        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return this;


        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return this;


        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return this;


        }

        public Criteria andIpIn(List values) {
            addCriterion("ip in", values, "ip");
            return this;


        }

        public Criteria andIpNotIn(List values) {
            addCriterion("ip not in", values, "ip");
            return this;


        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return this;


        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
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

        public Criteria andLookSourceIsNull() {
            addCriterion("look_source is null");
            return this;


        }

        public Criteria andLookSourceIsNotNull() {
            addCriterion("look_source is not null");
            return this;


        }

        public Criteria andLookSourceEqualTo(Integer value) {
            addCriterion("look_source =", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceNotEqualTo(Integer value) {
            addCriterion("look_source <>", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceGreaterThan(Integer value) {
            addCriterion("look_source >", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("look_source >=", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceLessThan(Integer value) {
            addCriterion("look_source <", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceLessThanOrEqualTo(Integer value) {
            addCriterion("look_source <=", value, "lookSource");
            return this;


        }

        public Criteria andLookSourceIn(List values) {
            addCriterion("look_source in", values, "lookSource");
            return this;


        }

        public Criteria andLookSourceNotIn(List values) {
            addCriterion("look_source not in", values, "lookSource");
            return this;


        }

        public Criteria andLookSourceBetween(Integer value1, Integer value2) {
            addCriterion("look_source between", value1, value2, "lookSource");
            return this;


        }

        public Criteria andLookSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("look_source not between", value1, value2, "lookSource");
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

        public Criteria andUpdateDtIsNull() {
            addCriterion("update_dt is null");
            return this;


        }

        public Criteria andUpdateDtIsNotNull() {
            addCriterion("update_dt is not null");
            return this;


        }

        public Criteria andUpdateDtEqualTo(Date value) {
            addCriterion("update_dt =", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtNotEqualTo(Date value) {
            addCriterion("update_dt <>", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtGreaterThan(Date value) {
            addCriterion("update_dt >", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_dt >=", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtLessThan(Date value) {
            addCriterion("update_dt <", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtLessThanOrEqualTo(Date value) {
            addCriterion("update_dt <=", value, "updateDt");
            return this;


        }

        public Criteria andUpdateDtIn(List values) {
            addCriterion("update_dt in", values, "updateDt");
            return this;


        }

        public Criteria andUpdateDtNotIn(List values) {
            addCriterion("update_dt not in", values, "updateDt");
            return this;


        }

        public Criteria andUpdateDtBetween(Date value1, Date value2) {
            addCriterion("update_dt between", value1, value2, "updateDt");
            return this;


        }

        public Criteria andUpdateDtNotBetween(Date value1, Date value2) {
            addCriterion("update_dt not between", value1, value2, "updateDt");
            return this;


        }


    }


}
