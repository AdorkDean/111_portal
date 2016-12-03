package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TCouponExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TCouponExample() {
        oredCriteria = new ArrayList();


    }

    protected TCouponExample(TCouponExample example) {
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

        public Criteria andPrefixIsNull() {
            addCriterion("prefix is null");
            return this;


        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("prefix is not null");
            return this;


        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("prefix =", value, "prefix");
            return this;


        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("prefix <>", value, "prefix");
            return this;


        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("prefix >", value, "prefix");
            return this;


        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("prefix >=", value, "prefix");
            return this;


        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("prefix <", value, "prefix");
            return this;


        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("prefix <=", value, "prefix");
            return this;


        }

        public Criteria andPrefixLike(String value) {
            addCriterion("prefix like", value, "prefix");
            return this;


        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("prefix not like", value, "prefix");
            return this;


        }

        public Criteria andPrefixIn(List values) {
            addCriterion("prefix in", values, "prefix");
            return this;


        }

        public Criteria andPrefixNotIn(List values) {
            addCriterion("prefix not in", values, "prefix");
            return this;


        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("prefix between", value1, value2, "prefix");
            return this;


        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("prefix not between", value1, value2, "prefix");
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

        public Criteria andStartPriceIsNull() {
            addCriterion("start_price is null");
            return this;


        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("start_price is not null");
            return this;


        }

        public Criteria andStartPriceEqualTo(BigDecimal value) {
            addCriterion("start_price =", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceNotEqualTo(BigDecimal value) {
            addCriterion("start_price <>", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceGreaterThan(BigDecimal value) {
            addCriterion("start_price >", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price >=", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceLessThan(BigDecimal value) {
            addCriterion("start_price <", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price <=", value, "startPrice");
            return this;


        }

        public Criteria andStartPriceIn(List values) {
            addCriterion("start_price in", values, "startPrice");
            return this;


        }

        public Criteria andStartPriceNotIn(List values) {
            addCriterion("start_price not in", values, "startPrice");
            return this;


        }

        public Criteria andStartPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price between", value1, value2, "startPrice");
            return this;


        }

        public Criteria andStartPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price not between", value1, value2, "startPrice");
            return this;


        }

        public Criteria andEndPriceIsNull() {
            addCriterion("end_price is null");
            return this;


        }

        public Criteria andEndPriceIsNotNull() {
            addCriterion("end_price is not null");
            return this;


        }

        public Criteria andEndPriceEqualTo(BigDecimal value) {
            addCriterion("end_price =", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceNotEqualTo(BigDecimal value) {
            addCriterion("end_price <>", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceGreaterThan(BigDecimal value) {
            addCriterion("end_price >", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("end_price >=", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceLessThan(BigDecimal value) {
            addCriterion("end_price <", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("end_price <=", value, "endPrice");
            return this;


        }

        public Criteria andEndPriceIn(List values) {
            addCriterion("end_price in", values, "endPrice");
            return this;


        }

        public Criteria andEndPriceNotIn(List values) {
            addCriterion("end_price not in", values, "endPrice");
            return this;


        }

        public Criteria andEndPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_price between", value1, value2, "endPrice");
            return this;


        }

        public Criteria andEndPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_price not between", value1, value2, "endPrice");
            return this;


        }

        public Criteria andDisPriceIsNull() {
            addCriterion("dis_price is null");
            return this;


        }

        public Criteria andDisPriceIsNotNull() {
            addCriterion("dis_price is not null");
            return this;


        }

        public Criteria andDisPriceEqualTo(BigDecimal value) {
            addCriterion("dis_price =", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceNotEqualTo(BigDecimal value) {
            addCriterion("dis_price <>", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceGreaterThan(BigDecimal value) {
            addCriterion("dis_price >", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dis_price >=", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceLessThan(BigDecimal value) {
            addCriterion("dis_price <", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dis_price <=", value, "disPrice");
            return this;


        }

        public Criteria andDisPriceIn(List values) {
            addCriterion("dis_price in", values, "disPrice");
            return this;


        }

        public Criteria andDisPriceNotIn(List values) {
            addCriterion("dis_price not in", values, "disPrice");
            return this;


        }

        public Criteria andDisPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dis_price between", value1, value2, "disPrice");
            return this;


        }

        public Criteria andDisPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dis_price not between", value1, value2, "disPrice");
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

        public Criteria andIsExchangeIsNull() {
            addCriterion("is_exchange is null");
            return this;


        }

        public Criteria andIsExchangeIsNotNull() {
            addCriterion("is_exchange is not null");
            return this;


        }

        public Criteria andIsExchangeEqualTo(Integer value) {
            addCriterion("is_exchange =", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeNotEqualTo(Integer value) {
            addCriterion("is_exchange <>", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeGreaterThan(Integer value) {
            addCriterion("is_exchange >", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_exchange >=", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeLessThan(Integer value) {
            addCriterion("is_exchange <", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeLessThanOrEqualTo(Integer value) {
            addCriterion("is_exchange <=", value, "isExchange");
            return this;


        }

        public Criteria andIsExchangeIn(List values) {
            addCriterion("is_exchange in", values, "isExchange");
            return this;


        }

        public Criteria andIsExchangeNotIn(List values) {
            addCriterion("is_exchange not in", values, "isExchange");
            return this;


        }

        public Criteria andIsExchangeBetween(Integer value1, Integer value2) {
            addCriterion("is_exchange between", value1, value2, "isExchange");
            return this;


        }

        public Criteria andIsExchangeNotBetween(Integer value1, Integer value2) {
            addCriterion("is_exchange not between", value1, value2, "isExchange");
            return this;


        }

        public Criteria andExchangeCountIsNull() {
            addCriterion("exchange_count is null");
            return this;


        }

        public Criteria andExchangeCountIsNotNull() {
            addCriterion("exchange_count is not null");
            return this;


        }

        public Criteria andExchangeCountEqualTo(Integer value) {
            addCriterion("exchange_count =", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountNotEqualTo(Integer value) {
            addCriterion("exchange_count <>", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountGreaterThan(Integer value) {
            addCriterion("exchange_count >", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_count >=", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountLessThan(Integer value) {
            addCriterion("exchange_count <", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_count <=", value, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountIn(List values) {
            addCriterion("exchange_count in", values, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountNotIn(List values) {
            addCriterion("exchange_count not in", values, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountBetween(Integer value1, Integer value2) {
            addCriterion("exchange_count between", value1, value2, "exchangeCount");
            return this;


        }

        public Criteria andExchangeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_count not between", value1, value2, "exchangeCount");
            return this;


        }

        public Criteria andIsRepeatIsNull() {
            addCriterion("is_repeat is null");
            return this;


        }

        public Criteria andIsRepeatIsNotNull() {
            addCriterion("is_repeat is not null");
            return this;


        }

        public Criteria andIsRepeatEqualTo(Integer value) {
            addCriterion("is_repeat =", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatNotEqualTo(Integer value) {
            addCriterion("is_repeat <>", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatGreaterThan(Integer value) {
            addCriterion("is_repeat >", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_repeat >=", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatLessThan(Integer value) {
            addCriterion("is_repeat <", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatLessThanOrEqualTo(Integer value) {
            addCriterion("is_repeat <=", value, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatIn(List values) {
            addCriterion("is_repeat in", values, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatNotIn(List values) {
            addCriterion("is_repeat not in", values, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat between", value1, value2, "isRepeat");
            return this;


        }

        public Criteria andIsRepeatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat not between", value1, value2, "isRepeat");
            return this;


        }

        public Criteria andCodeLengthIsNull() {
            addCriterion("code_length is null");
            return this;


        }

        public Criteria andCodeLengthIsNotNull() {
            addCriterion("code_length is not null");
            return this;


        }

        public Criteria andCodeLengthEqualTo(Integer value) {
            addCriterion("code_length =", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthNotEqualTo(Integer value) {
            addCriterion("code_length <>", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthGreaterThan(Integer value) {
            addCriterion("code_length >", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_length >=", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthLessThan(Integer value) {
            addCriterion("code_length <", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthLessThanOrEqualTo(Integer value) {
            addCriterion("code_length <=", value, "codeLength");
            return this;


        }

        public Criteria andCodeLengthIn(List values) {
            addCriterion("code_length in", values, "codeLength");
            return this;


        }

        public Criteria andCodeLengthNotIn(List values) {
            addCriterion("code_length not in", values, "codeLength");
            return this;


        }

        public Criteria andCodeLengthBetween(Integer value1, Integer value2) {
            addCriterion("code_length between", value1, value2, "codeLength");
            return this;


        }

        public Criteria andCodeLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("code_length not between", value1, value2, "codeLength");
            return this;


        }

        public Criteria andInstroIsNull() {
            addCriterion("instro is null");
            return this;


        }

        public Criteria andInstroIsNotNull() {
            addCriterion("instro is not null");
            return this;


        }

        public Criteria andInstroEqualTo(String value) {
            addCriterion("instro =", value, "instro");
            return this;


        }

        public Criteria andInstroNotEqualTo(String value) {
            addCriterion("instro <>", value, "instro");
            return this;


        }

        public Criteria andInstroGreaterThan(String value) {
            addCriterion("instro >", value, "instro");
            return this;


        }

        public Criteria andInstroGreaterThanOrEqualTo(String value) {
            addCriterion("instro >=", value, "instro");
            return this;


        }

        public Criteria andInstroLessThan(String value) {
            addCriterion("instro <", value, "instro");
            return this;


        }

        public Criteria andInstroLessThanOrEqualTo(String value) {
            addCriterion("instro <=", value, "instro");
            return this;


        }

        public Criteria andInstroLike(String value) {
            addCriterion("instro like", value, "instro");
            return this;


        }

        public Criteria andInstroNotLike(String value) {
            addCriterion("instro not like", value, "instro");
            return this;


        }

        public Criteria andInstroIn(List values) {
            addCriterion("instro in", values, "instro");
            return this;


        }

        public Criteria andInstroNotIn(List values) {
            addCriterion("instro not in", values, "instro");
            return this;


        }

        public Criteria andInstroBetween(String value1, String value2) {
            addCriterion("instro between", value1, value2, "instro");
            return this;


        }

        public Criteria andInstroNotBetween(String value1, String value2) {
            addCriterion("instro not between", value1, value2, "instro");
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

        public Criteria andRuleEqualTo(Integer value) {
            addCriterion("rule =", value, "rule");
            return this;


        }

        public Criteria andRuleNotEqualTo(Integer value) {
            addCriterion("rule <>", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThan(Integer value) {
            addCriterion("rule >", value, "rule");
            return this;


        }

        public Criteria andRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule >=", value, "rule");
            return this;


        }

        public Criteria andRuleLessThan(Integer value) {
            addCriterion("rule <", value, "rule");
            return this;


        }

        public Criteria andRuleLessThanOrEqualTo(Integer value) {
            addCriterion("rule <=", value, "rule");
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

        public Criteria andRuleBetween(Integer value1, Integer value2) {
            addCriterion("rule between", value1, value2, "rule");
            return this;


        }

        public Criteria andRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("rule not between", value1, value2, "rule");
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

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return this;


        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return this;


        }

        public Criteria andScopeEqualTo(Integer value) {
            addCriterion("scope =", value, "scope");
            return this;


        }

        public Criteria andScopeNotEqualTo(Integer value) {
            addCriterion("scope <>", value, "scope");
            return this;


        }

        public Criteria andScopeGreaterThan(Integer value) {
            addCriterion("scope >", value, "scope");
            return this;


        }

        public Criteria andScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scope >=", value, "scope");
            return this;


        }

        public Criteria andScopeLessThan(Integer value) {
            addCriterion("scope <", value, "scope");
            return this;


        }

        public Criteria andScopeLessThanOrEqualTo(Integer value) {
            addCriterion("scope <=", value, "scope");
            return this;


        }

        public Criteria andScopeIn(List values) {
            addCriterion("scope in", values, "scope");
            return this;


        }

        public Criteria andScopeNotIn(List values) {
            addCriterion("scope not in", values, "scope");
            return this;


        }

        public Criteria andScopeBetween(Integer value1, Integer value2) {
            addCriterion("scope between", value1, value2, "scope");
            return this;


        }

        public Criteria andScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return this;


        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return this;


        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return this;


        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return this;


        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return this;


        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return this;


        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return this;


        }

        public Criteria andQuantityIn(List values) {
            addCriterion("quantity in", values, "quantity");
            return this;


        }

        public Criteria andQuantityNotIn(List values) {
            addCriterion("quantity not in", values, "quantity");
            return this;


        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return this;


        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return this;


        }


    }


}
