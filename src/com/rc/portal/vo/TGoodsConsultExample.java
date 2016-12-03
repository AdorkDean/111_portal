package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsConsultExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsConsultExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsConsultExample(TGoodsConsultExample example) {
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

        public Criteria andConsultContentIsNull() {
            addCriterion("consult_content is null");
            return this;


        }

        public Criteria andConsultContentIsNotNull() {
            addCriterion("consult_content is not null");
            return this;


        }

        public Criteria andConsultContentEqualTo(String value) {
            addCriterion("consult_content =", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentNotEqualTo(String value) {
            addCriterion("consult_content <>", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentGreaterThan(String value) {
            addCriterion("consult_content >", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentGreaterThanOrEqualTo(String value) {
            addCriterion("consult_content >=", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentLessThan(String value) {
            addCriterion("consult_content <", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentLessThanOrEqualTo(String value) {
            addCriterion("consult_content <=", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentLike(String value) {
            addCriterion("consult_content like", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentNotLike(String value) {
            addCriterion("consult_content not like", value, "consultContent");
            return this;


        }

        public Criteria andConsultContentIn(List values) {
            addCriterion("consult_content in", values, "consultContent");
            return this;


        }

        public Criteria andConsultContentNotIn(List values) {
            addCriterion("consult_content not in", values, "consultContent");
            return this;


        }

        public Criteria andConsultContentBetween(String value1, String value2) {
            addCriterion("consult_content between", value1, value2, "consultContent");
            return this;


        }

        public Criteria andConsultContentNotBetween(String value1, String value2) {
            addCriterion("consult_content not between", value1, value2, "consultContent");
            return this;


        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return this;


        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return this;


        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return this;


        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return this;


        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return this;


        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return this;


        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return this;


        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return this;


        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return this;


        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return this;


        }

        public Criteria andAnswerIn(List values) {
            addCriterion("answer in", values, "answer");
            return this;


        }

        public Criteria andAnswerNotIn(List values) {
            addCriterion("answer not in", values, "answer");
            return this;


        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return this;


        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return this;


        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return this;


        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return this;


        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return this;


        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return this;


        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return this;


        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return this;


        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return this;


        }

        public Criteria andParentIdIn(List values) {
            addCriterion("parent_id in", values, "parentId");
            return this;


        }

        public Criteria andParentIdNotIn(List values) {
            addCriterion("parent_id not in", values, "parentId");
            return this;


        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return this;


        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return this;


        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return this;


        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return this;


        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return this;


        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return this;


        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return this;


        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return this;


        }

        public Criteria andCreateDateIn(List values) {
            addCriterion("create_date in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateNotIn(List values) {
            addCriterion("create_date not in", values, "createDate");
            return this;


        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return this;


        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return this;


        }

        public Criteria andAnswerDateIsNull() {
            addCriterion("answer_date is null");
            return this;


        }

        public Criteria andAnswerDateIsNotNull() {
            addCriterion("answer_date is not null");
            return this;


        }

        public Criteria andAnswerDateEqualTo(Date value) {
            addCriterion("answer_date =", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateNotEqualTo(Date value) {
            addCriterion("answer_date <>", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateGreaterThan(Date value) {
            addCriterion("answer_date >", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateGreaterThanOrEqualTo(Date value) {
            addCriterion("answer_date >=", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateLessThan(Date value) {
            addCriterion("answer_date <", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateLessThanOrEqualTo(Date value) {
            addCriterion("answer_date <=", value, "answerDate");
            return this;


        }

        public Criteria andAnswerDateIn(List values) {
            addCriterion("answer_date in", values, "answerDate");
            return this;


        }

        public Criteria andAnswerDateNotIn(List values) {
            addCriterion("answer_date not in", values, "answerDate");
            return this;


        }

        public Criteria andAnswerDateBetween(Date value1, Date value2) {
            addCriterion("answer_date between", value1, value2, "answerDate");
            return this;


        }

        public Criteria andAnswerDateNotBetween(Date value1, Date value2) {
            addCriterion("answer_date not between", value1, value2, "answerDate");
            return this;


        }

        public Criteria andAnswerUserNameIsNull() {
            addCriterion("answer_user_name is null");
            return this;


        }

        public Criteria andAnswerUserNameIsNotNull() {
            addCriterion("answer_user_name is not null");
            return this;


        }

        public Criteria andAnswerUserNameEqualTo(String value) {
            addCriterion("answer_user_name =", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameNotEqualTo(String value) {
            addCriterion("answer_user_name <>", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameGreaterThan(String value) {
            addCriterion("answer_user_name >", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("answer_user_name >=", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameLessThan(String value) {
            addCriterion("answer_user_name <", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameLessThanOrEqualTo(String value) {
            addCriterion("answer_user_name <=", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameLike(String value) {
            addCriterion("answer_user_name like", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameNotLike(String value) {
            addCriterion("answer_user_name not like", value, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameIn(List values) {
            addCriterion("answer_user_name in", values, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameNotIn(List values) {
            addCriterion("answer_user_name not in", values, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameBetween(String value1, String value2) {
            addCriterion("answer_user_name between", value1, value2, "answerUserName");
            return this;


        }

        public Criteria andAnswerUserNameNotBetween(String value1, String value2) {
            addCriterion("answer_user_name not between", value1, value2, "answerUserName");
            return this;


        }


    }


}
