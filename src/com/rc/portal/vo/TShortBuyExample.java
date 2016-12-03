package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TShortBuyExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TShortBuyExample() {
        oredCriteria = new ArrayList();


    }

    protected TShortBuyExample(TShortBuyExample example) {
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return this;


        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return this;


        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return this;


        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return this;


        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return this;


        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return this;


        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return this;


        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return this;


        }

        public Criteria andStartTimeIn(List values) {
            addCriterion("start_time in", values, "startTime");
            return this;


        }

        public Criteria andStartTimeNotIn(List values) {
            addCriterion("start_time not in", values, "startTime");
            return this;


        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return this;


        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return this;


        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return this;


        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return this;


        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return this;


        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return this;


        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return this;


        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return this;


        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return this;


        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return this;


        }

        public Criteria andEndTimeIn(List values) {
            addCriterion("end_time in", values, "endTime");
            return this;


        }

        public Criteria andEndTimeNotIn(List values) {
            addCriterion("end_time not in", values, "endTime");
            return this;


        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return this;


        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return this;


        }

        public Criteria andAdvertiseIsNull() {
            addCriterion("advertise is null");
            return this;


        }

        public Criteria andAdvertiseIsNotNull() {
            addCriterion("advertise is not null");
            return this;


        }

        public Criteria andAdvertiseEqualTo(String value) {
            addCriterion("advertise =", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotEqualTo(String value) {
            addCriterion("advertise <>", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseGreaterThan(String value) {
            addCriterion("advertise >", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseGreaterThanOrEqualTo(String value) {
            addCriterion("advertise >=", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLessThan(String value) {
            addCriterion("advertise <", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLessThanOrEqualTo(String value) {
            addCriterion("advertise <=", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseLike(String value) {
            addCriterion("advertise like", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotLike(String value) {
            addCriterion("advertise not like", value, "advertise");
            return this;


        }

        public Criteria andAdvertiseIn(List values) {
            addCriterion("advertise in", values, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotIn(List values) {
            addCriterion("advertise not in", values, "advertise");
            return this;


        }

        public Criteria andAdvertiseBetween(String value1, String value2) {
            addCriterion("advertise between", value1, value2, "advertise");
            return this;


        }

        public Criteria andAdvertiseNotBetween(String value1, String value2) {
            addCriterion("advertise not between", value1, value2, "advertise");
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

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return this;


        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return this;


        }

        public Criteria andIssueEqualTo(String value) {
            addCriterion("issue =", value, "issue");
            return this;


        }

        public Criteria andIssueNotEqualTo(String value) {
            addCriterion("issue <>", value, "issue");
            return this;


        }

        public Criteria andIssueGreaterThan(String value) {
            addCriterion("issue >", value, "issue");
            return this;


        }

        public Criteria andIssueGreaterThanOrEqualTo(String value) {
            addCriterion("issue >=", value, "issue");
            return this;


        }

        public Criteria andIssueLessThan(String value) {
            addCriterion("issue <", value, "issue");
            return this;


        }

        public Criteria andIssueLessThanOrEqualTo(String value) {
            addCriterion("issue <=", value, "issue");
            return this;


        }

        public Criteria andIssueLike(String value) {
            addCriterion("issue like", value, "issue");
            return this;


        }

        public Criteria andIssueNotLike(String value) {
            addCriterion("issue not like", value, "issue");
            return this;


        }

        public Criteria andIssueIn(List values) {
            addCriterion("issue in", values, "issue");
            return this;


        }

        public Criteria andIssueNotIn(List values) {
            addCriterion("issue not in", values, "issue");
            return this;


        }

        public Criteria andIssueBetween(String value1, String value2) {
            addCriterion("issue between", value1, value2, "issue");
            return this;


        }

        public Criteria andIssueNotBetween(String value1, String value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return this;


        }


    }


}
