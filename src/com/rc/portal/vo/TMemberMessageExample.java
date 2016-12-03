package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberMessageExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberMessageExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberMessageExample(TMemberMessageExample example) {
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

        public Criteria andSendPeopleIsNull() {
            addCriterion("send_people is null");
            return this;


        }

        public Criteria andSendPeopleIsNotNull() {
            addCriterion("send_people is not null");
            return this;


        }

        public Criteria andSendPeopleEqualTo(String value) {
            addCriterion("send_people =", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleNotEqualTo(String value) {
            addCriterion("send_people <>", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleGreaterThan(String value) {
            addCriterion("send_people >", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("send_people >=", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleLessThan(String value) {
            addCriterion("send_people <", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleLessThanOrEqualTo(String value) {
            addCriterion("send_people <=", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleLike(String value) {
            addCriterion("send_people like", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleNotLike(String value) {
            addCriterion("send_people not like", value, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleIn(List values) {
            addCriterion("send_people in", values, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleNotIn(List values) {
            addCriterion("send_people not in", values, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleBetween(String value1, String value2) {
            addCriterion("send_people between", value1, value2, "sendPeople");
            return this;


        }

        public Criteria andSendPeopleNotBetween(String value1, String value2) {
            addCriterion("send_people not between", value1, value2, "sendPeople");
            return this;


        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return this;


        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return this;


        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return this;


        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return this;


        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return this;


        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return this;


        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return this;


        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return this;


        }

        public Criteria andIsReadIn(List values) {
            addCriterion("is_read in", values, "isRead");
            return this;


        }

        public Criteria andIsReadNotIn(List values) {
            addCriterion("is_read not in", values, "isRead");
            return this;


        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return this;


        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return this;


        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return this;


        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return this;


        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return this;


        }

        public Criteria andIsDeleteIn(List values) {
            addCriterion("is_delete in", values, "isDelete");
            return this;


        }

        public Criteria andIsDeleteNotIn(List values) {
            addCriterion("is_delete not in", values, "isDelete");
            return this;


        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return this;


        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return this;


        }

        public Criteria andSendDateIsNull() {
            addCriterion("send_date is null");
            return this;


        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("send_date is not null");
            return this;


        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("send_date =", value, "sendDate");
            return this;


        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("send_date <>", value, "sendDate");
            return this;


        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("send_date >", value, "sendDate");
            return this;


        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date >=", value, "sendDate");
            return this;


        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("send_date <", value, "sendDate");
            return this;


        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("send_date <=", value, "sendDate");
            return this;


        }

        public Criteria andSendDateIn(List values) {
            addCriterion("send_date in", values, "sendDate");
            return this;


        }

        public Criteria andSendDateNotIn(List values) {
            addCriterion("send_date not in", values, "sendDate");
            return this;


        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("send_date between", value1, value2, "sendDate");
            return this;


        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("send_date not between", value1, value2, "sendDate");
            return this;


        }

        public Criteria andReceiverIdIsNull() {
            addCriterion("receiver_id is null");
            return this;


        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiver_id is not null");
            return this;


        }

        public Criteria andReceiverIdEqualTo(Long value) {
            addCriterion("receiver_id =", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdNotEqualTo(Long value) {
            addCriterion("receiver_id <>", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdGreaterThan(Long value) {
            addCriterion("receiver_id >", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id >=", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdLessThan(Long value) {
            addCriterion("receiver_id <", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id <=", value, "receiverId");
            return this;


        }

        public Criteria andReceiverIdIn(List values) {
            addCriterion("receiver_id in", values, "receiverId");
            return this;


        }

        public Criteria andReceiverIdNotIn(List values) {
            addCriterion("receiver_id not in", values, "receiverId");
            return this;


        }

        public Criteria andReceiverIdBetween(Long value1, Long value2) {
            addCriterion("receiver_id between", value1, value2, "receiverId");
            return this;


        }

        public Criteria andReceiverIdNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id not between", value1, value2, "receiverId");
            return this;


        }


    }


}
