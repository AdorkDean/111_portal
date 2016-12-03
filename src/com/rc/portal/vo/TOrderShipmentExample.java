package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TOrderShipmentExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TOrderShipmentExample() {
        oredCriteria = new ArrayList();


    }

    protected TOrderShipmentExample(TOrderShipmentExample example) {
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

        public Criteria andLogisticsNoIsNull() {
            addCriterion("logistics_no is null");
            return this;


        }

        public Criteria andLogisticsNoIsNotNull() {
            addCriterion("logistics_no is not null");
            return this;


        }

        public Criteria andLogisticsNoEqualTo(String value) {
            addCriterion("logistics_no =", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoNotEqualTo(String value) {
            addCriterion("logistics_no <>", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoGreaterThan(String value) {
            addCriterion("logistics_no >", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_no >=", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoLessThan(String value) {
            addCriterion("logistics_no <", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoLessThanOrEqualTo(String value) {
            addCriterion("logistics_no <=", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoLike(String value) {
            addCriterion("logistics_no like", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoNotLike(String value) {
            addCriterion("logistics_no not like", value, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoIn(List values) {
            addCriterion("logistics_no in", values, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoNotIn(List values) {
            addCriterion("logistics_no not in", values, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoBetween(String value1, String value2) {
            addCriterion("logistics_no between", value1, value2, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNoNotBetween(String value1, String value2) {
            addCriterion("logistics_no not between", value1, value2, "logisticsNo");
            return this;


        }

        public Criteria andLogisticsNameIsNull() {
            addCriterion("logistics_name is null");
            return this;


        }

        public Criteria andLogisticsNameIsNotNull() {
            addCriterion("logistics_name is not null");
            return this;


        }

        public Criteria andLogisticsNameEqualTo(String value) {
            addCriterion("logistics_name =", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameNotEqualTo(String value) {
            addCriterion("logistics_name <>", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameGreaterThan(String value) {
            addCriterion("logistics_name >", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_name >=", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameLessThan(String value) {
            addCriterion("logistics_name <", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_name <=", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameLike(String value) {
            addCriterion("logistics_name like", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameNotLike(String value) {
            addCriterion("logistics_name not like", value, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameIn(List values) {
            addCriterion("logistics_name in", values, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameNotIn(List values) {
            addCriterion("logistics_name not in", values, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameBetween(String value1, String value2) {
            addCriterion("logistics_name between", value1, value2, "logisticsName");
            return this;


        }

        public Criteria andLogisticsNameNotBetween(String value1, String value2) {
            addCriterion("logistics_name not between", value1, value2, "logisticsName");
            return this;


        }

        public Criteria andLogisticsPositionIsNull() {
            addCriterion("logistics_position is null");
            return this;


        }

        public Criteria andLogisticsPositionIsNotNull() {
            addCriterion("logistics_position is not null");
            return this;


        }

        public Criteria andLogisticsPositionEqualTo(String value) {
            addCriterion("logistics_position =", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionNotEqualTo(String value) {
            addCriterion("logistics_position <>", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionGreaterThan(String value) {
            addCriterion("logistics_position >", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_position >=", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionLessThan(String value) {
            addCriterion("logistics_position <", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionLessThanOrEqualTo(String value) {
            addCriterion("logistics_position <=", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionLike(String value) {
            addCriterion("logistics_position like", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionNotLike(String value) {
            addCriterion("logistics_position not like", value, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionIn(List values) {
            addCriterion("logistics_position in", values, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionNotIn(List values) {
            addCriterion("logistics_position not in", values, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionBetween(String value1, String value2) {
            addCriterion("logistics_position between", value1, value2, "logisticsPosition");
            return this;


        }

        public Criteria andLogisticsPositionNotBetween(String value1, String value2) {
            addCriterion("logistics_position not between", value1, value2, "logisticsPosition");
            return this;


        }

        public Criteria andShipmentDtIsNull() {
            addCriterion("shipment_dt is null");
            return this;


        }

        public Criteria andShipmentDtIsNotNull() {
            addCriterion("shipment_dt is not null");
            return this;


        }

        public Criteria andShipmentDtEqualTo(Date value) {
            addCriterion("shipment_dt =", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtNotEqualTo(Date value) {
            addCriterion("shipment_dt <>", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtGreaterThan(Date value) {
            addCriterion("shipment_dt >", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtGreaterThanOrEqualTo(Date value) {
            addCriterion("shipment_dt >=", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtLessThan(Date value) {
            addCriterion("shipment_dt <", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtLessThanOrEqualTo(Date value) {
            addCriterion("shipment_dt <=", value, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtIn(List values) {
            addCriterion("shipment_dt in", values, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtNotIn(List values) {
            addCriterion("shipment_dt not in", values, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtBetween(Date value1, Date value2) {
            addCriterion("shipment_dt between", value1, value2, "shipmentDt");
            return this;


        }

        public Criteria andShipmentDtNotBetween(Date value1, Date value2) {
            addCriterion("shipment_dt not between", value1, value2, "shipmentDt");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return this;


        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return this;


        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return this;


        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return this;


        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return this;


        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return this;


        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return this;


        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return this;


        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return this;


        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return this;


        }

        public Criteria andStateIn(List values) {
            addCriterion("state in", values, "state");
            return this;


        }

        public Criteria andStateNotIn(List values) {
            addCriterion("state not in", values, "state");
            return this;


        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return this;


        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return this;


        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return this;


        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return this;


        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return this;


        }

        public Criteria andOrderTypeIn(List values) {
            addCriterion("order_type in", values, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotIn(List values) {
            addCriterion("order_type not in", values, "orderType");
            return this;


        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return this;


        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return this;


        }


    }


}
