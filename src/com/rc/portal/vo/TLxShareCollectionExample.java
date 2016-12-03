package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TLxShareCollectionExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TLxShareCollectionExample() {
        oredCriteria = new ArrayList();


    }

    protected TLxShareCollectionExample(TLxShareCollectionExample example) {
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

        public Criteria andShareDescIsNull() {
            addCriterion("share_desc is null");
            return this;


        }

        public Criteria andShareDescIsNotNull() {
            addCriterion("share_desc is not null");
            return this;


        }

        public Criteria andShareDescEqualTo(String value) {
            addCriterion("share_desc =", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescNotEqualTo(String value) {
            addCriterion("share_desc <>", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescGreaterThan(String value) {
            addCriterion("share_desc >", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescGreaterThanOrEqualTo(String value) {
            addCriterion("share_desc >=", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescLessThan(String value) {
            addCriterion("share_desc <", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescLessThanOrEqualTo(String value) {
            addCriterion("share_desc <=", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescLike(String value) {
            addCriterion("share_desc like", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescNotLike(String value) {
            addCriterion("share_desc not like", value, "shareDesc");
            return this;


        }

        public Criteria andShareDescIn(List values) {
            addCriterion("share_desc in", values, "shareDesc");
            return this;


        }

        public Criteria andShareDescNotIn(List values) {
            addCriterion("share_desc not in", values, "shareDesc");
            return this;


        }

        public Criteria andShareDescBetween(String value1, String value2) {
            addCriterion("share_desc between", value1, value2, "shareDesc");
            return this;


        }

        public Criteria andShareDescNotBetween(String value1, String value2) {
            addCriterion("share_desc not between", value1, value2, "shareDesc");
            return this;


        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return this;


        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return this;


        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return this;


        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return this;


        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return this;


        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return this;


        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return this;


        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return this;


        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return this;


        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return this;


        }

        public Criteria andLinkIn(List values) {
            addCriterion("link in", values, "link");
            return this;


        }

        public Criteria andLinkNotIn(List values) {
            addCriterion("link not in", values, "link");
            return this;


        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return this;


        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return this;


        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return this;


        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return this;


        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return this;


        }

        public Criteria andImgUrlIn(List values) {
            addCriterion("img_url in", values, "imgUrl");
            return this;


        }

        public Criteria andImgUrlNotIn(List values) {
            addCriterion("img_url not in", values, "imgUrl");
            return this;


        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return this;


        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return this;


        }

        public Criteria andShareTypeIsNull() {
            addCriterion("share_type is null");
            return this;


        }

        public Criteria andShareTypeIsNotNull() {
            addCriterion("share_type is not null");
            return this;


        }

        public Criteria andShareTypeEqualTo(String value) {
            addCriterion("share_type =", value, "shareType");
            return this;


        }

        public Criteria andShareTypeNotEqualTo(String value) {
            addCriterion("share_type <>", value, "shareType");
            return this;


        }

        public Criteria andShareTypeGreaterThan(String value) {
            addCriterion("share_type >", value, "shareType");
            return this;


        }

        public Criteria andShareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("share_type >=", value, "shareType");
            return this;


        }

        public Criteria andShareTypeLessThan(String value) {
            addCriterion("share_type <", value, "shareType");
            return this;


        }

        public Criteria andShareTypeLessThanOrEqualTo(String value) {
            addCriterion("share_type <=", value, "shareType");
            return this;


        }

        public Criteria andShareTypeLike(String value) {
            addCriterion("share_type like", value, "shareType");
            return this;


        }

        public Criteria andShareTypeNotLike(String value) {
            addCriterion("share_type not like", value, "shareType");
            return this;


        }

        public Criteria andShareTypeIn(List values) {
            addCriterion("share_type in", values, "shareType");
            return this;


        }

        public Criteria andShareTypeNotIn(List values) {
            addCriterion("share_type not in", values, "shareType");
            return this;


        }

        public Criteria andShareTypeBetween(String value1, String value2) {
            addCriterion("share_type between", value1, value2, "shareType");
            return this;


        }

        public Criteria andShareTypeNotBetween(String value1, String value2) {
            addCriterion("share_type not between", value1, value2, "shareType");
            return this;


        }

        public Criteria andDataUrlIsNull() {
            addCriterion("data_url is null");
            return this;


        }

        public Criteria andDataUrlIsNotNull() {
            addCriterion("data_url is not null");
            return this;


        }

        public Criteria andDataUrlEqualTo(String value) {
            addCriterion("data_url =", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlNotEqualTo(String value) {
            addCriterion("data_url <>", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlGreaterThan(String value) {
            addCriterion("data_url >", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("data_url >=", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlLessThan(String value) {
            addCriterion("data_url <", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlLessThanOrEqualTo(String value) {
            addCriterion("data_url <=", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlLike(String value) {
            addCriterion("data_url like", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlNotLike(String value) {
            addCriterion("data_url not like", value, "dataUrl");
            return this;


        }

        public Criteria andDataUrlIn(List values) {
            addCriterion("data_url in", values, "dataUrl");
            return this;


        }

        public Criteria andDataUrlNotIn(List values) {
            addCriterion("data_url not in", values, "dataUrl");
            return this;


        }

        public Criteria andDataUrlBetween(String value1, String value2) {
            addCriterion("data_url between", value1, value2, "dataUrl");
            return this;


        }

        public Criteria andDataUrlNotBetween(String value1, String value2) {
            addCriterion("data_url not between", value1, value2, "dataUrl");
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

        public Criteria andShareWayIsNull() {
            addCriterion("share_way is null");
            return this;


        }

        public Criteria andShareWayIsNotNull() {
            addCriterion("share_way is not null");
            return this;


        }

        public Criteria andShareWayEqualTo(String value) {
            addCriterion("share_way =", value, "shareWay");
            return this;


        }

        public Criteria andShareWayNotEqualTo(String value) {
            addCriterion("share_way <>", value, "shareWay");
            return this;


        }

        public Criteria andShareWayGreaterThan(String value) {
            addCriterion("share_way >", value, "shareWay");
            return this;


        }

        public Criteria andShareWayGreaterThanOrEqualTo(String value) {
            addCriterion("share_way >=", value, "shareWay");
            return this;


        }

        public Criteria andShareWayLessThan(String value) {
            addCriterion("share_way <", value, "shareWay");
            return this;


        }

        public Criteria andShareWayLessThanOrEqualTo(String value) {
            addCriterion("share_way <=", value, "shareWay");
            return this;


        }

        public Criteria andShareWayLike(String value) {
            addCriterion("share_way like", value, "shareWay");
            return this;


        }

        public Criteria andShareWayNotLike(String value) {
            addCriterion("share_way not like", value, "shareWay");
            return this;


        }

        public Criteria andShareWayIn(List values) {
            addCriterion("share_way in", values, "shareWay");
            return this;


        }

        public Criteria andShareWayNotIn(List values) {
            addCriterion("share_way not in", values, "shareWay");
            return this;


        }

        public Criteria andShareWayBetween(String value1, String value2) {
            addCriterion("share_way between", value1, value2, "shareWay");
            return this;


        }

        public Criteria andShareWayNotBetween(String value1, String value2) {
            addCriterion("share_way not between", value1, value2, "shareWay");
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
