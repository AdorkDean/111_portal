package com.rc.portal.vo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class RxTReserveOrderExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public RxTReserveOrderExample() {
        oredCriteria = new ArrayList();


    }

    protected RxTReserveOrderExample(RxTReserveOrderExample example) {
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

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return this;


        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return this;


        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return this;


        }

        public Criteria andOrderSnIn(List values) {
            addCriterion("order_sn in", values, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotIn(List values) {
            addCriterion("order_sn not in", values, "orderSn");
            return this;


        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return this;


        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return this;


        }

        public Criteria andGoodidIsNull() {
            addCriterion("goodid is null");
            return this;


        }

        public Criteria andGoodidIsNotNull() {
            addCriterion("goodid is not null");
            return this;


        }

        public Criteria andGoodidEqualTo(Long value) {
            addCriterion("goodid =", value, "goodid");
            return this;


        }

        public Criteria andGoodidNotEqualTo(Long value) {
            addCriterion("goodid <>", value, "goodid");
            return this;


        }

        public Criteria andGoodidGreaterThan(Long value) {
            addCriterion("goodid >", value, "goodid");
            return this;


        }

        public Criteria andGoodidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodid >=", value, "goodid");
            return this;


        }

        public Criteria andGoodidLessThan(Long value) {
            addCriterion("goodid <", value, "goodid");
            return this;


        }

        public Criteria andGoodidLessThanOrEqualTo(Long value) {
            addCriterion("goodid <=", value, "goodid");
            return this;


        }

        public Criteria andGoodidIn(List values) {
            addCriterion("goodid in", values, "goodid");
            return this;


        }

        public Criteria andGoodidNotIn(List values) {
            addCriterion("goodid not in", values, "goodid");
            return this;


        }

        public Criteria andGoodidBetween(Long value1, Long value2) {
            addCriterion("goodid between", value1, value2, "goodid");
            return this;


        }

        public Criteria andGoodidNotBetween(Long value1, Long value2) {
            addCriterion("goodid not between", value1, value2, "goodid");
            return this;


        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return this;


        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return this;


        }

        public Criteria andGoodPriceEqualTo(BigDecimal value) {
            addCriterion("good_price =", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotEqualTo(BigDecimal value) {
            addCriterion("good_price <>", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceGreaterThan(BigDecimal value) {
            addCriterion("good_price >", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price >=", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceLessThan(BigDecimal value) {
            addCriterion("good_price <", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price <=", value, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceIn(List values) {
            addCriterion("good_price in", values, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotIn(List values) {
            addCriterion("good_price not in", values, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return this;


        }

        public Criteria andGoodPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return this;


        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return this;


        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return this;


        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return this;


        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return this;


        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return this;


        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return this;


        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return this;


        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return this;


        }

        public Criteria andNumIn(List values) {
            addCriterion("num in", values, "num");
            return this;


        }

        public Criteria andNumNotIn(List values) {
            addCriterion("num not in", values, "num");
            return this;


        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return this;


        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return this;


        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return this;


        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return this;


        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return this;


        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return this;


        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return this;


        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return this;


        }

        public Criteria andReceiverIn(List values) {
            addCriterion("receiver in", values, "receiver");
            return this;


        }

        public Criteria andReceiverNotIn(List values) {
            addCriterion("receiver not in", values, "receiver");
            return this;


        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return this;


        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return this;


        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return this;


        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return this;


        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return this;


        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return this;


        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return this;


        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return this;


        }

        public Criteria andAreaIdIn(List values) {
            addCriterion("area_id in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdNotIn(List values) {
            addCriterion("area_id not in", values, "areaId");
            return this;


        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return this;


        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return this;


        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return this;


        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return this;


        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return this;


        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return this;


        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return this;


        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return this;


        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return this;


        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return this;


        }

        public Criteria andAreaNameIn(List values) {
            addCriterion("area_name in", values, "areaName");
            return this;


        }

        public Criteria andAreaNameNotIn(List values) {
            addCriterion("area_name not in", values, "areaName");
            return this;


        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return this;


        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return this;


        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return this;


        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return this;


        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressIn(List values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotIn(List values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return this;


        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return this;


        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return this;


        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return this;


        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return this;


        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return this;


        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return this;


        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return this;


        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return this;


        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return this;


        }

        public Criteria andLongitudeIn(List values) {
            addCriterion("longitude in", values, "longitude");
            return this;


        }

        public Criteria andLongitudeNotIn(List values) {
            addCriterion("longitude not in", values, "longitude");
            return this;


        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return this;


        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return this;


        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return this;


        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return this;


        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return this;


        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return this;


        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return this;


        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return this;


        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return this;


        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return this;


        }

        public Criteria andLatitudeIn(List values) {
            addCriterion("latitude in", values, "latitude");
            return this;


        }

        public Criteria andLatitudeNotIn(List values) {
            addCriterion("latitude not in", values, "latitude");
            return this;


        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return this;


        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return this;


        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return this;


        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return this;


        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("store_id =", value, "storeId");
            return this;


        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("store_id <>", value, "storeId");
            return this;


        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("store_id >", value, "storeId");
            return this;


        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("store_id >=", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("store_id <", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("store_id <=", value, "storeId");
            return this;


        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("store_id like", value, "storeId");
            return this;


        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("store_id not like", value, "storeId");
            return this;


        }

        public Criteria andStoreIdIn(List values) {
            addCriterion("store_id in", values, "storeId");
            return this;


        }

        public Criteria andStoreIdNotIn(List values) {
            addCriterion("store_id not in", values, "storeId");
            return this;


        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return this;


        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return this;


        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return this;


        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return this;


        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return this;


        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return this;


        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return this;


        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return this;


        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return this;


        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return this;


        }

        public Criteria andMobileIn(List values) {
            addCriterion("mobile in", values, "mobile");
            return this;


        }

        public Criteria andMobileNotIn(List values) {
            addCriterion("mobile not in", values, "mobile");
            return this;


        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return this;


        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return this;


        }

        public Criteria andReplyMobileIsNull() {
            addCriterion("reply_mobile is null");
            return this;


        }

        public Criteria andReplyMobileIsNotNull() {
            addCriterion("reply_mobile is not null");
            return this;


        }

        public Criteria andReplyMobileEqualTo(String value) {
            addCriterion("reply_mobile =", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileNotEqualTo(String value) {
            addCriterion("reply_mobile <>", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileGreaterThan(String value) {
            addCriterion("reply_mobile >", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileGreaterThanOrEqualTo(String value) {
            addCriterion("reply_mobile >=", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileLessThan(String value) {
            addCriterion("reply_mobile <", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileLessThanOrEqualTo(String value) {
            addCriterion("reply_mobile <=", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileLike(String value) {
            addCriterion("reply_mobile like", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileNotLike(String value) {
            addCriterion("reply_mobile not like", value, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileIn(List values) {
            addCriterion("reply_mobile in", values, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileNotIn(List values) {
            addCriterion("reply_mobile not in", values, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileBetween(String value1, String value2) {
            addCriterion("reply_mobile between", value1, value2, "replyMobile");
            return this;


        }

        public Criteria andReplyMobileNotBetween(String value1, String value2) {
            addCriterion("reply_mobile not between", value1, value2, "replyMobile");
            return this;


        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return this;


        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return this;


        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusIn(List values) {
            addCriterion("order_status in", values, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotIn(List values) {
            addCriterion("order_status not in", values, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return this;


        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return this;


        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return this;


        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return this;


        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusIn(List values) {
            addCriterion("audit_status in", values, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotIn(List values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return this;


        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return this;


        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return this;


        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return this;


        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountIn(List values) {
            addCriterion("order_amount in", values, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotIn(List values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return this;


        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return this;


        }

        public Criteria andPromotionalDiscountIsNull() {
            addCriterion("promotional_discount is null");
            return this;


        }

        public Criteria andPromotionalDiscountIsNotNull() {
            addCriterion("promotional_discount is not null");
            return this;


        }

        public Criteria andPromotionalDiscountEqualTo(BigDecimal value) {
            addCriterion("promotional_discount =", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotEqualTo(BigDecimal value) {
            addCriterion("promotional_discount <>", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountGreaterThan(BigDecimal value) {
            addCriterion("promotional_discount >", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_discount >=", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountLessThan(BigDecimal value) {
            addCriterion("promotional_discount <", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotional_discount <=", value, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountIn(List values) {
            addCriterion("promotional_discount in", values, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotIn(List values) {
            addCriterion("promotional_discount not in", values, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_discount between", value1, value2, "promotionalDiscount");
            return this;


        }

        public Criteria andPromotionalDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotional_discount not between", value1, value2, "promotionalDiscount");
            return this;


        }

        public Criteria andCouponDiscountIsNull() {
            addCriterion("coupon_discount is null");
            return this;


        }

        public Criteria andCouponDiscountIsNotNull() {
            addCriterion("coupon_discount is not null");
            return this;


        }

        public Criteria andCouponDiscountEqualTo(BigDecimal value) {
            addCriterion("coupon_discount =", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotEqualTo(BigDecimal value) {
            addCriterion("coupon_discount <>", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountGreaterThan(BigDecimal value) {
            addCriterion("coupon_discount >", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_discount >=", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountLessThan(BigDecimal value) {
            addCriterion("coupon_discount <", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_discount <=", value, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountIn(List values) {
            addCriterion("coupon_discount in", values, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotIn(List values) {
            addCriterion("coupon_discount not in", values, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_discount between", value1, value2, "couponDiscount");
            return this;


        }

        public Criteria andCouponDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_discount not between", value1, value2, "couponDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountIsNull() {
            addCriterion("integration_discount is null");
            return this;


        }

        public Criteria andIntegrationDiscountIsNotNull() {
            addCriterion("integration_discount is not null");
            return this;


        }

        public Criteria andIntegrationDiscountEqualTo(BigDecimal value) {
            addCriterion("integration_discount =", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotEqualTo(BigDecimal value) {
            addCriterion("integration_discount <>", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountGreaterThan(BigDecimal value) {
            addCriterion("integration_discount >", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_discount >=", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountLessThan(BigDecimal value) {
            addCriterion("integration_discount <", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("integration_discount <=", value, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountIn(List values) {
            addCriterion("integration_discount in", values, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotIn(List values) {
            addCriterion("integration_discount not in", values, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_discount between", value1, value2, "integrationDiscount");
            return this;


        }

        public Criteria andIntegrationDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integration_discount not between", value1, value2, "integrationDiscount");
            return this;


        }

        public Criteria andUseIntegrationIsNull() {
            addCriterion("use_integration is null");
            return this;


        }

        public Criteria andUseIntegrationIsNotNull() {
            addCriterion("use_integration is not null");
            return this;


        }

        public Criteria andUseIntegrationEqualTo(Integer value) {
            addCriterion("use_integration =", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotEqualTo(Integer value) {
            addCriterion("use_integration <>", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationGreaterThan(Integer value) {
            addCriterion("use_integration >", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_integration >=", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationLessThan(Integer value) {
            addCriterion("use_integration <", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("use_integration <=", value, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationIn(List values) {
            addCriterion("use_integration in", values, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotIn(List values) {
            addCriterion("use_integration not in", values, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("use_integration between", value1, value2, "useIntegration");
            return this;


        }

        public Criteria andUseIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("use_integration not between", value1, value2, "useIntegration");
            return this;


        }

        public Criteria andAdjustAmountIsNull() {
            addCriterion("adjust_amount is null");
            return this;


        }

        public Criteria andAdjustAmountIsNotNull() {
            addCriterion("adjust_amount is not null");
            return this;


        }

        public Criteria andAdjustAmountEqualTo(BigDecimal value) {
            addCriterion("adjust_amount =", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotEqualTo(BigDecimal value) {
            addCriterion("adjust_amount <>", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountGreaterThan(BigDecimal value) {
            addCriterion("adjust_amount >", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_amount >=", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountLessThan(BigDecimal value) {
            addCriterion("adjust_amount <", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_amount <=", value, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountIn(List values) {
            addCriterion("adjust_amount in", values, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotIn(List values) {
            addCriterion("adjust_amount not in", values, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_amount between", value1, value2, "adjustAmount");
            return this;


        }

        public Criteria andAdjustAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_amount not between", value1, value2, "adjustAmount");
            return this;


        }

        public Criteria andRxImgUrlIsNull() {
            addCriterion("rx_img_url is null");
            return this;


        }

        public Criteria andRxImgUrlIsNotNull() {
            addCriterion("rx_img_url is not null");
            return this;


        }

        public Criteria andRxImgUrlEqualTo(String value) {
            addCriterion("rx_img_url =", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlNotEqualTo(String value) {
            addCriterion("rx_img_url <>", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlGreaterThan(String value) {
            addCriterion("rx_img_url >", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rx_img_url >=", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlLessThan(String value) {
            addCriterion("rx_img_url <", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlLessThanOrEqualTo(String value) {
            addCriterion("rx_img_url <=", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlLike(String value) {
            addCriterion("rx_img_url like", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlNotLike(String value) {
            addCriterion("rx_img_url not like", value, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlIn(List values) {
            addCriterion("rx_img_url in", values, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlNotIn(List values) {
            addCriterion("rx_img_url not in", values, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlBetween(String value1, String value2) {
            addCriterion("rx_img_url between", value1, value2, "rxImgUrl");
            return this;


        }

        public Criteria andRxImgUrlNotBetween(String value1, String value2) {
            addCriterion("rx_img_url not between", value1, value2, "rxImgUrl");
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return this;


        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return this;


        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return this;


        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return this;


        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return this;


        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return this;


        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return this;


        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return this;


        }

        public Criteria andSourceIn(List values) {
            addCriterion("source in", values, "source");
            return this;


        }

        public Criteria andSourceNotIn(List values) {
            addCriterion("source not in", values, "source");
            return this;


        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return this;


        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return this;


        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return this;


        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return this;


        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return this;


        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return this;


        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return this;


        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return this;


        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return this;


        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return this;


        }

        public Criteria andRemarkIn(List values) {
            addCriterion("remark in", values, "remark");
            return this;


        }

        public Criteria andRemarkNotIn(List values) {
            addCriterion("remark not in", values, "remark");
            return this;


        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return this;


        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return this;


        }

        public Criteria andCancelRemarkIsNull() {
            addCriterion("cancel_remark is null");
            return this;


        }

        public Criteria andCancelRemarkIsNotNull() {
            addCriterion("cancel_remark is not null");
            return this;


        }

        public Criteria andCancelRemarkEqualTo(String value) {
            addCriterion("cancel_remark =", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkNotEqualTo(String value) {
            addCriterion("cancel_remark <>", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkGreaterThan(String value) {
            addCriterion("cancel_remark >", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_remark >=", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkLessThan(String value) {
            addCriterion("cancel_remark <", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkLessThanOrEqualTo(String value) {
            addCriterion("cancel_remark <=", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkLike(String value) {
            addCriterion("cancel_remark like", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkNotLike(String value) {
            addCriterion("cancel_remark not like", value, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkIn(List values) {
            addCriterion("cancel_remark in", values, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkNotIn(List values) {
            addCriterion("cancel_remark not in", values, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkBetween(String value1, String value2) {
            addCriterion("cancel_remark between", value1, value2, "cancelRemark");
            return this;


        }

        public Criteria andCancelRemarkNotBetween(String value1, String value2) {
            addCriterion("cancel_remark not between", value1, value2, "cancelRemark");
            return this;


        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return this;


        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return this;


        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return this;


        }

        public Criteria andUpdateUserIn(List values) {
            addCriterion("update_user in", values, "updateUser");
            return this;


        }

        public Criteria andUpdateUserNotIn(List values) {
            addCriterion("update_user not in", values, "updateUser");
            return this;


        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return this;


        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return this;


        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return this;


        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return this;


        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return this;


        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return this;


        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return this;


        }

        public Criteria andOrderIdIn(List values) {
            addCriterion("order_id in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdNotIn(List values) {
            addCriterion("order_id not in", values, "orderId");
            return this;


        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return this;


        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return this;


        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return this;


        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return this;


        }

        public Criteria andFreightEqualTo(BigDecimal value) {
            addCriterion("freight =", value, "freight");
            return this;


        }

        public Criteria andFreightNotEqualTo(BigDecimal value) {
            addCriterion("freight <>", value, "freight");
            return this;


        }

        public Criteria andFreightGreaterThan(BigDecimal value) {
            addCriterion("freight >", value, "freight");
            return this;


        }

        public Criteria andFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight >=", value, "freight");
            return this;


        }

        public Criteria andFreightLessThan(BigDecimal value) {
            addCriterion("freight <", value, "freight");
            return this;


        }

        public Criteria andFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight <=", value, "freight");
            return this;


        }

        public Criteria andFreightIn(List values) {
            addCriterion("freight in", values, "freight");
            return this;


        }

        public Criteria andFreightNotIn(List values) {
            addCriterion("freight not in", values, "freight");
            return this;


        }

        public Criteria andFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight between", value1, value2, "freight");
            return this;


        }

        public Criteria andFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return this;


        }

        public Criteria andCancelDtIsNull() {
            addCriterion("cancel_dt is null");
            return this;


        }

        public Criteria andCancelDtIsNotNull() {
            addCriterion("cancel_dt is not null");
            return this;


        }

        public Criteria andCancelDtEqualTo(Date value) {
            addCriterion("cancel_dt =", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtNotEqualTo(Date value) {
            addCriterion("cancel_dt <>", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtGreaterThan(Date value) {
            addCriterion("cancel_dt >", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_dt >=", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtLessThan(Date value) {
            addCriterion("cancel_dt <", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtLessThanOrEqualTo(Date value) {
            addCriterion("cancel_dt <=", value, "cancelDt");
            return this;


        }

        public Criteria andCancelDtIn(List values) {
            addCriterion("cancel_dt in", values, "cancelDt");
            return this;


        }

        public Criteria andCancelDtNotIn(List values) {
            addCriterion("cancel_dt not in", values, "cancelDt");
            return this;


        }

        public Criteria andCancelDtBetween(Date value1, Date value2) {
            addCriterion("cancel_dt between", value1, value2, "cancelDt");
            return this;


        }

        public Criteria andCancelDtNotBetween(Date value1, Date value2) {
            addCriterion("cancel_dt not between", value1, value2, "cancelDt");
            return this;


        }

        public Criteria andIsEndIsNull() {
            addCriterion("is_end is null");
            return this;


        }

        public Criteria andIsEndIsNotNull() {
            addCriterion("is_end is not null");
            return this;


        }

        public Criteria andIsEndEqualTo(Integer value) {
            addCriterion("is_end =", value, "isEnd");
            return this;


        }

        public Criteria andIsEndNotEqualTo(Integer value) {
            addCriterion("is_end <>", value, "isEnd");
            return this;


        }

        public Criteria andIsEndGreaterThan(Integer value) {
            addCriterion("is_end >", value, "isEnd");
            return this;


        }

        public Criteria andIsEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_end >=", value, "isEnd");
            return this;


        }

        public Criteria andIsEndLessThan(Integer value) {
            addCriterion("is_end <", value, "isEnd");
            return this;


        }

        public Criteria andIsEndLessThanOrEqualTo(Integer value) {
            addCriterion("is_end <=", value, "isEnd");
            return this;


        }

        public Criteria andIsEndIn(List values) {
            addCriterion("is_end in", values, "isEnd");
            return this;


        }

        public Criteria andIsEndNotIn(List values) {
            addCriterion("is_end not in", values, "isEnd");
            return this;


        }

        public Criteria andIsEndBetween(Integer value1, Integer value2) {
            addCriterion("is_end between", value1, value2, "isEnd");
            return this;


        }

        public Criteria andIsEndNotBetween(Integer value1, Integer value2) {
            addCriterion("is_end not between", value1, value2, "isEnd");
            return this;


        }


    }


}
