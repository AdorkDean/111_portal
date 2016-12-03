package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxGoodsArticleExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxGoodsArticleExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxGoodsArticleExample(TLxGoodsArticleExample example) {
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

        public Criteria andShareImageUrlIsNull() {
            addCriterion("share_image_url is null");
            return this;


        }

        public Criteria andShareImageUrlIsNotNull() {
            addCriterion("share_image_url is not null");
            return this;


        }

        public Criteria andShareImageUrlEqualTo(String value) {
            addCriterion("share_image_url =", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlNotEqualTo(String value) {
            addCriterion("share_image_url <>", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlGreaterThan(String value) {
            addCriterion("share_image_url >", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_image_url >=", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlLessThan(String value) {
            addCriterion("share_image_url <", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlLessThanOrEqualTo(String value) {
            addCriterion("share_image_url <=", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlLike(String value) {
            addCriterion("share_image_url like", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlNotLike(String value) {
            addCriterion("share_image_url not like", value, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlIn(List values) {
            addCriterion("share_image_url in", values, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlNotIn(List values) {
            addCriterion("share_image_url not in", values, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlBetween(String value1, String value2) {
            addCriterion("share_image_url between", value1, value2, "shareImageUrl");
            return this;


        }

        public Criteria andShareImageUrlNotBetween(String value1, String value2) {
            addCriterion("share_image_url not between", value1, value2, "shareImageUrl");
            return this;


        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return this;


        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return this;


        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return this;


        }

        public Criteria andShareTitleIn(List values) {
            addCriterion("share_title in", values, "shareTitle");
            return this;


        }

        public Criteria andShareTitleNotIn(List values) {
            addCriterion("share_title not in", values, "shareTitle");
            return this;


        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return this;


        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
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

        public Criteria andSendDtIsNull() {
            addCriterion("send_dt is null");
            return this;


        }

        public Criteria andSendDtIsNotNull() {
            addCriterion("send_dt is not null");
            return this;


        }

        public Criteria andSendDtEqualTo(Date value) {
            addCriterion("send_dt =", value, "sendDt");
            return this;


        }

        public Criteria andSendDtNotEqualTo(Date value) {
            addCriterion("send_dt <>", value, "sendDt");
            return this;


        }

        public Criteria andSendDtGreaterThan(Date value) {
            addCriterion("send_dt >", value, "sendDt");
            return this;


        }

        public Criteria andSendDtGreaterThanOrEqualTo(Date value) {
            addCriterion("send_dt >=", value, "sendDt");
            return this;


        }

        public Criteria andSendDtLessThan(Date value) {
            addCriterion("send_dt <", value, "sendDt");
            return this;


        }

        public Criteria andSendDtLessThanOrEqualTo(Date value) {
            addCriterion("send_dt <=", value, "sendDt");
            return this;


        }

        public Criteria andSendDtIn(List values) {
            addCriterion("send_dt in", values, "sendDt");
            return this;


        }

        public Criteria andSendDtNotIn(List values) {
            addCriterion("send_dt not in", values, "sendDt");
            return this;


        }

        public Criteria andSendDtBetween(Date value1, Date value2) {
            addCriterion("send_dt between", value1, value2, "sendDt");
            return this;


        }

        public Criteria andSendDtNotBetween(Date value1, Date value2) {
            addCriterion("send_dt not between", value1, value2, "sendDt");
            return this;


        }

        public Criteria andFormatTypeIsNull() {
            addCriterion("format_type is null");
            return this;


        }

        public Criteria andFormatTypeIsNotNull() {
            addCriterion("format_type is not null");
            return this;


        }

        public Criteria andFormatTypeEqualTo(Integer value) {
            addCriterion("format_type =", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeNotEqualTo(Integer value) {
            addCriterion("format_type <>", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeGreaterThan(Integer value) {
            addCriterion("format_type >", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("format_type >=", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeLessThan(Integer value) {
            addCriterion("format_type <", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeLessThanOrEqualTo(Integer value) {
            addCriterion("format_type <=", value, "formatType");
            return this;


        }

        public Criteria andFormatTypeIn(List values) {
            addCriterion("format_type in", values, "formatType");
            return this;


        }

        public Criteria andFormatTypeNotIn(List values) {
            addCriterion("format_type not in", values, "formatType");
            return this;


        }

        public Criteria andFormatTypeBetween(Integer value1, Integer value2) {
            addCriterion("format_type between", value1, value2, "formatType");
            return this;


        }

        public Criteria andFormatTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("format_type not between", value1, value2, "formatType");
            return this;


        }


    }


}
