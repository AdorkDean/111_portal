package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsCommentExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsCommentExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsCommentExample(TGoodsCommentExample example) {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return this;


        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return this;


        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return this;


        }

        public Criteria andGoodsIdIn(List values) {
            addCriterion("goods_id in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotIn(List values) {
            addCriterion("goods_id not in", values, "goodsId");
            return this;


        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return this;


        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return this;


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

        public Criteria andSumFractionIsNull() {
            addCriterion("sum_fraction is null");
            return this;


        }

        public Criteria andSumFractionIsNotNull() {
            addCriterion("sum_fraction is not null");
            return this;


        }

        public Criteria andSumFractionEqualTo(Integer value) {
            addCriterion("sum_fraction =", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionNotEqualTo(Integer value) {
            addCriterion("sum_fraction <>", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionGreaterThan(Integer value) {
            addCriterion("sum_fraction >", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_fraction >=", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionLessThan(Integer value) {
            addCriterion("sum_fraction <", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionLessThanOrEqualTo(Integer value) {
            addCriterion("sum_fraction <=", value, "sumFraction");
            return this;


        }

        public Criteria andSumFractionIn(List values) {
            addCriterion("sum_fraction in", values, "sumFraction");
            return this;


        }

        public Criteria andSumFractionNotIn(List values) {
            addCriterion("sum_fraction not in", values, "sumFraction");
            return this;


        }

        public Criteria andSumFractionBetween(Integer value1, Integer value2) {
            addCriterion("sum_fraction between", value1, value2, "sumFraction");
            return this;


        }

        public Criteria andSumFractionNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_fraction not between", value1, value2, "sumFraction");
            return this;


        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return this;


        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return this;


        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return this;


        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return this;


        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return this;


        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return this;


        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return this;


        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return this;


        }

        public Criteria andTypeIn(List values) {
            addCriterion("type in", values, "type");
            return this;


        }

        public Criteria andTypeNotIn(List values) {
            addCriterion("type not in", values, "type");
            return this;


        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return this;


        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return this;


        }

        public Criteria andSellerIsNull() {
            addCriterion("seller is null");
            return this;


        }

        public Criteria andSellerIsNotNull() {
            addCriterion("seller is not null");
            return this;


        }

        public Criteria andSellerEqualTo(Integer value) {
            addCriterion("seller =", value, "seller");
            return this;


        }

        public Criteria andSellerNotEqualTo(Integer value) {
            addCriterion("seller <>", value, "seller");
            return this;


        }

        public Criteria andSellerGreaterThan(Integer value) {
            addCriterion("seller >", value, "seller");
            return this;


        }

        public Criteria andSellerGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller >=", value, "seller");
            return this;


        }

        public Criteria andSellerLessThan(Integer value) {
            addCriterion("seller <", value, "seller");
            return this;


        }

        public Criteria andSellerLessThanOrEqualTo(Integer value) {
            addCriterion("seller <=", value, "seller");
            return this;


        }

        public Criteria andSellerIn(List values) {
            addCriterion("seller in", values, "seller");
            return this;


        }

        public Criteria andSellerNotIn(List values) {
            addCriterion("seller not in", values, "seller");
            return this;


        }

        public Criteria andSellerBetween(Integer value1, Integer value2) {
            addCriterion("seller between", value1, value2, "seller");
            return this;


        }

        public Criteria andSellerNotBetween(Integer value1, Integer value2) {
            addCriterion("seller not between", value1, value2, "seller");
            return this;


        }

        public Criteria andFastMailIsNull() {
            addCriterion("fast_mail is null");
            return this;


        }

        public Criteria andFastMailIsNotNull() {
            addCriterion("fast_mail is not null");
            return this;


        }

        public Criteria andFastMailEqualTo(Integer value) {
            addCriterion("fast_mail =", value, "fastMail");
            return this;


        }

        public Criteria andFastMailNotEqualTo(Integer value) {
            addCriterion("fast_mail <>", value, "fastMail");
            return this;


        }

        public Criteria andFastMailGreaterThan(Integer value) {
            addCriterion("fast_mail >", value, "fastMail");
            return this;


        }

        public Criteria andFastMailGreaterThanOrEqualTo(Integer value) {
            addCriterion("fast_mail >=", value, "fastMail");
            return this;


        }

        public Criteria andFastMailLessThan(Integer value) {
            addCriterion("fast_mail <", value, "fastMail");
            return this;


        }

        public Criteria andFastMailLessThanOrEqualTo(Integer value) {
            addCriterion("fast_mail <=", value, "fastMail");
            return this;


        }

        public Criteria andFastMailIn(List values) {
            addCriterion("fast_mail in", values, "fastMail");
            return this;


        }

        public Criteria andFastMailNotIn(List values) {
            addCriterion("fast_mail not in", values, "fastMail");
            return this;


        }

        public Criteria andFastMailBetween(Integer value1, Integer value2) {
            addCriterion("fast_mail between", value1, value2, "fastMail");
            return this;


        }

        public Criteria andFastMailNotBetween(Integer value1, Integer value2) {
            addCriterion("fast_mail not between", value1, value2, "fastMail");
            return this;


        }

        public Criteria andGoodsIsNull() {
            addCriterion("goods is null");
            return this;


        }

        public Criteria andGoodsIsNotNull() {
            addCriterion("goods is not null");
            return this;


        }

        public Criteria andGoodsEqualTo(Integer value) {
            addCriterion("goods =", value, "goods");
            return this;


        }

        public Criteria andGoodsNotEqualTo(Integer value) {
            addCriterion("goods <>", value, "goods");
            return this;


        }

        public Criteria andGoodsGreaterThan(Integer value) {
            addCriterion("goods >", value, "goods");
            return this;


        }

        public Criteria andGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods >=", value, "goods");
            return this;


        }

        public Criteria andGoodsLessThan(Integer value) {
            addCriterion("goods <", value, "goods");
            return this;


        }

        public Criteria andGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("goods <=", value, "goods");
            return this;


        }

        public Criteria andGoodsIn(List values) {
            addCriterion("goods in", values, "goods");
            return this;


        }

        public Criteria andGoodsNotIn(List values) {
            addCriterion("goods not in", values, "goods");
            return this;


        }

        public Criteria andGoodsBetween(Integer value1, Integer value2) {
            addCriterion("goods between", value1, value2, "goods");
            return this;


        }

        public Criteria andGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("goods not between", value1, value2, "goods");
            return this;


        }

        public Criteria andFastMailPeopleIsNull() {
            addCriterion("fast_mail_people is null");
            return this;


        }

        public Criteria andFastMailPeopleIsNotNull() {
            addCriterion("fast_mail_people is not null");
            return this;


        }

        public Criteria andFastMailPeopleEqualTo(Integer value) {
            addCriterion("fast_mail_people =", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleNotEqualTo(Integer value) {
            addCriterion("fast_mail_people <>", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleGreaterThan(Integer value) {
            addCriterion("fast_mail_people >", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("fast_mail_people >=", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleLessThan(Integer value) {
            addCriterion("fast_mail_people <", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("fast_mail_people <=", value, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleIn(List values) {
            addCriterion("fast_mail_people in", values, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleNotIn(List values) {
            addCriterion("fast_mail_people not in", values, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleBetween(Integer value1, Integer value2) {
            addCriterion("fast_mail_people between", value1, value2, "fastMailPeople");
            return this;


        }

        public Criteria andFastMailPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("fast_mail_people not between", value1, value2, "fastMailPeople");
            return this;


        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return this;


        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return this;


        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return this;


        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return this;


        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return this;


        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return this;


        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return this;


        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return this;


        }

        public Criteria andIsShowIn(List values) {
            addCriterion("is_show in", values, "isShow");
            return this;


        }

        public Criteria andIsShowNotIn(List values) {
            addCriterion("is_show not in", values, "isShow");
            return this;


        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return this;


        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return this;


        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return this;


        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return this;


        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return this;


        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return this;


        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return this;


        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return this;


        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return this;


        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return this;


        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return this;


        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return this;


        }

        public Criteria andCommentIn(List values) {
            addCriterion("comment in", values, "comment");
            return this;


        }

        public Criteria andCommentNotIn(List values) {
            addCriterion("comment not in", values, "comment");
            return this;


        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return this;


        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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


    }


}
