package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CPaymentWayExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CPaymentWayExample() {
        oredCriteria = new ArrayList();


    }

    protected CPaymentWayExample(CPaymentWayExample example) {
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

        public Criteria andPaymentWayIsNull() {
            addCriterion("payment_way is null");
            return this;


        }

        public Criteria andPaymentWayIsNotNull() {
            addCriterion("payment_way is not null");
            return this;


        }

        public Criteria andPaymentWayEqualTo(Integer value) {
            addCriterion("payment_way =", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayNotEqualTo(Integer value) {
            addCriterion("payment_way <>", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayGreaterThan(Integer value) {
            addCriterion("payment_way >", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_way >=", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayLessThan(Integer value) {
            addCriterion("payment_way <", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayLessThanOrEqualTo(Integer value) {
            addCriterion("payment_way <=", value, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayIn(List values) {
            addCriterion("payment_way in", values, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayNotIn(List values) {
            addCriterion("payment_way not in", values, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayBetween(Integer value1, Integer value2) {
            addCriterion("payment_way between", value1, value2, "paymentWay");
            return this;


        }

        public Criteria andPaymentWayNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_way not between", value1, value2, "paymentWay");
            return this;


        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return this;


        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return this;


        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return this;


        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return this;


        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return this;


        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return this;


        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return this;


        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return this;


        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return this;


        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return this;


        }

        public Criteria andIconIn(List values) {
            addCriterion("icon in", values, "icon");
            return this;


        }

        public Criteria andIconNotIn(List values) {
            addCriterion("icon not in", values, "icon");
            return this;


        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return this;


        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return this;


        }

        public Criteria andTimeoutIsNull() {
            addCriterion("timeout is null");
            return this;


        }

        public Criteria andTimeoutIsNotNull() {
            addCriterion("timeout is not null");
            return this;


        }

        public Criteria andTimeoutEqualTo(Integer value) {
            addCriterion("timeout =", value, "timeout");
            return this;


        }

        public Criteria andTimeoutNotEqualTo(Integer value) {
            addCriterion("timeout <>", value, "timeout");
            return this;


        }

        public Criteria andTimeoutGreaterThan(Integer value) {
            addCriterion("timeout >", value, "timeout");
            return this;


        }

        public Criteria andTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeout >=", value, "timeout");
            return this;


        }

        public Criteria andTimeoutLessThan(Integer value) {
            addCriterion("timeout <", value, "timeout");
            return this;


        }

        public Criteria andTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("timeout <=", value, "timeout");
            return this;


        }

        public Criteria andTimeoutIn(List values) {
            addCriterion("timeout in", values, "timeout");
            return this;


        }

        public Criteria andTimeoutNotIn(List values) {
            addCriterion("timeout not in", values, "timeout");
            return this;


        }

        public Criteria andTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("timeout between", value1, value2, "timeout");
            return this;


        }

        public Criteria andTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("timeout not between", value1, value2, "timeout");
            return this;


        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return this;


        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return this;


        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return this;


        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return this;


        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return this;


        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return this;


        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return this;


        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return this;


        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return this;


        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return this;


        }

        public Criteria andIntroIn(List values) {
            addCriterion("intro in", values, "intro");
            return this;


        }

        public Criteria andIntroNotIn(List values) {
            addCriterion("intro not in", values, "intro");
            return this;


        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return this;


        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return this;


        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return this;


        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return this;


        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return this;


        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return this;


        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return this;


        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return this;


        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return this;


        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return this;


        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return this;


        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return this;


        }

        public Criteria andContentIn(List values) {
            addCriterion("content in", values, "content");
            return this;


        }

        public Criteria andContentNotIn(List values) {
            addCriterion("content not in", values, "content");
            return this;


        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return this;


        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return this;


        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return this;


        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return this;


        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return this;


        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return this;


        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return this;


        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return this;


        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return this;


        }

        public Criteria andSortIn(List values) {
            addCriterion("sort in", values, "sort");
            return this;


        }

        public Criteria andSortNotIn(List values) {
            addCriterion("sort not in", values, "sort");
            return this;


        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return this;


        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andPaymentCodeIsNull() {
            addCriterion("payment_code is null");
            return this;


        }

        public Criteria andPaymentCodeIsNotNull() {
            addCriterion("payment_code is not null");
            return this;


        }

        public Criteria andPaymentCodeEqualTo(String value) {
            addCriterion("payment_code =", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeNotEqualTo(String value) {
            addCriterion("payment_code <>", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeGreaterThan(String value) {
            addCriterion("payment_code >", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_code >=", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeLessThan(String value) {
            addCriterion("payment_code <", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeLessThanOrEqualTo(String value) {
            addCriterion("payment_code <=", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeLike(String value) {
            addCriterion("payment_code like", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeNotLike(String value) {
            addCriterion("payment_code not like", value, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeIn(List values) {
            addCriterion("payment_code in", values, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeNotIn(List values) {
            addCriterion("payment_code not in", values, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeBetween(String value1, String value2) {
            addCriterion("payment_code between", value1, value2, "paymentCode");
            return this;


        }

        public Criteria andPaymentCodeNotBetween(String value1, String value2) {
            addCriterion("payment_code not between", value1, value2, "paymentCode");
            return this;


        }


    }


}
