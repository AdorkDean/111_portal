package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class CPositionExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public CPositionExample() {
        oredCriteria = new ArrayList();


    }

    protected CPositionExample(CPositionExample example) {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;


        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;


        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;


        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;


        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;


        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
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

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;


        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;


        }

        public Criteria andTxtIsNull() {
            addCriterion("txt is null");
            return this;


        }

        public Criteria andTxtIsNotNull() {
            addCriterion("txt is not null");
            return this;


        }

        public Criteria andTxtEqualTo(String value) {
            addCriterion("txt =", value, "txt");
            return this;


        }

        public Criteria andTxtNotEqualTo(String value) {
            addCriterion("txt <>", value, "txt");
            return this;


        }

        public Criteria andTxtGreaterThan(String value) {
            addCriterion("txt >", value, "txt");
            return this;


        }

        public Criteria andTxtGreaterThanOrEqualTo(String value) {
            addCriterion("txt >=", value, "txt");
            return this;


        }

        public Criteria andTxtLessThan(String value) {
            addCriterion("txt <", value, "txt");
            return this;


        }

        public Criteria andTxtLessThanOrEqualTo(String value) {
            addCriterion("txt <=", value, "txt");
            return this;


        }

        public Criteria andTxtLike(String value) {
            addCriterion("txt like", value, "txt");
            return this;


        }

        public Criteria andTxtNotLike(String value) {
            addCriterion("txt not like", value, "txt");
            return this;


        }

        public Criteria andTxtIn(List values) {
            addCriterion("txt in", values, "txt");
            return this;


        }

        public Criteria andTxtNotIn(List values) {
            addCriterion("txt not in", values, "txt");
            return this;


        }

        public Criteria andTxtBetween(String value1, String value2) {
            addCriterion("txt between", value1, value2, "txt");
            return this;


        }

        public Criteria andTxtNotBetween(String value1, String value2) {
            addCriterion("txt not between", value1, value2, "txt");
            return this;


        }

        public Criteria andTxtLinkIsNull() {
            addCriterion("txt_link is null");
            return this;


        }

        public Criteria andTxtLinkIsNotNull() {
            addCriterion("txt_link is not null");
            return this;


        }

        public Criteria andTxtLinkEqualTo(String value) {
            addCriterion("txt_link =", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkNotEqualTo(String value) {
            addCriterion("txt_link <>", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkGreaterThan(String value) {
            addCriterion("txt_link >", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkGreaterThanOrEqualTo(String value) {
            addCriterion("txt_link >=", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkLessThan(String value) {
            addCriterion("txt_link <", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkLessThanOrEqualTo(String value) {
            addCriterion("txt_link <=", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkLike(String value) {
            addCriterion("txt_link like", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkNotLike(String value) {
            addCriterion("txt_link not like", value, "txtLink");
            return this;


        }

        public Criteria andTxtLinkIn(List values) {
            addCriterion("txt_link in", values, "txtLink");
            return this;


        }

        public Criteria andTxtLinkNotIn(List values) {
            addCriterion("txt_link not in", values, "txtLink");
            return this;


        }

        public Criteria andTxtLinkBetween(String value1, String value2) {
            addCriterion("txt_link between", value1, value2, "txtLink");
            return this;


        }

        public Criteria andTxtLinkNotBetween(String value1, String value2) {
            addCriterion("txt_link not between", value1, value2, "txtLink");
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

        public Criteria andImgLinkIsNull() {
            addCriterion("img_link is null");
            return this;


        }

        public Criteria andImgLinkIsNotNull() {
            addCriterion("img_link is not null");
            return this;


        }

        public Criteria andImgLinkEqualTo(String value) {
            addCriterion("img_link =", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkNotEqualTo(String value) {
            addCriterion("img_link <>", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkGreaterThan(String value) {
            addCriterion("img_link >", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkGreaterThanOrEqualTo(String value) {
            addCriterion("img_link >=", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkLessThan(String value) {
            addCriterion("img_link <", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkLessThanOrEqualTo(String value) {
            addCriterion("img_link <=", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkLike(String value) {
            addCriterion("img_link like", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkNotLike(String value) {
            addCriterion("img_link not like", value, "imgLink");
            return this;


        }

        public Criteria andImgLinkIn(List values) {
            addCriterion("img_link in", values, "imgLink");
            return this;


        }

        public Criteria andImgLinkNotIn(List values) {
            addCriterion("img_link not in", values, "imgLink");
            return this;


        }

        public Criteria andImgLinkBetween(String value1, String value2) {
            addCriterion("img_link between", value1, value2, "imgLink");
            return this;


        }

        public Criteria andImgLinkNotBetween(String value1, String value2) {
            addCriterion("img_link not between", value1, value2, "imgLink");
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

        public Criteria andTitleUrlIsNull() {
            addCriterion("title_url is null");
            return this;


        }

        public Criteria andTitleUrlIsNotNull() {
            addCriterion("title_url is not null");
            return this;


        }

        public Criteria andTitleUrlEqualTo(String value) {
            addCriterion("title_url =", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlNotEqualTo(String value) {
            addCriterion("title_url <>", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlGreaterThan(String value) {
            addCriterion("title_url >", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("title_url >=", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlLessThan(String value) {
            addCriterion("title_url <", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlLessThanOrEqualTo(String value) {
            addCriterion("title_url <=", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlLike(String value) {
            addCriterion("title_url like", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlNotLike(String value) {
            addCriterion("title_url not like", value, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlIn(List values) {
            addCriterion("title_url in", values, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlNotIn(List values) {
            addCriterion("title_url not in", values, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlBetween(String value1, String value2) {
            addCriterion("title_url between", value1, value2, "titleUrl");
            return this;


        }

        public Criteria andTitleUrlNotBetween(String value1, String value2) {
            addCriterion("title_url not between", value1, value2, "titleUrl");
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

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return this;


        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return this;


        }

        public Criteria andChannelEqualTo(Integer value) {
            addCriterion("channel =", value, "channel");
            return this;


        }

        public Criteria andChannelNotEqualTo(Integer value) {
            addCriterion("channel <>", value, "channel");
            return this;


        }

        public Criteria andChannelGreaterThan(Integer value) {
            addCriterion("channel >", value, "channel");
            return this;


        }

        public Criteria andChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel >=", value, "channel");
            return this;


        }

        public Criteria andChannelLessThan(Integer value) {
            addCriterion("channel <", value, "channel");
            return this;


        }

        public Criteria andChannelLessThanOrEqualTo(Integer value) {
            addCriterion("channel <=", value, "channel");
            return this;


        }

        public Criteria andChannelIn(List values) {
            addCriterion("channel in", values, "channel");
            return this;


        }

        public Criteria andChannelNotIn(List values) {
            addCriterion("channel not in", values, "channel");
            return this;


        }

        public Criteria andChannelBetween(Integer value1, Integer value2) {
            addCriterion("channel between", value1, value2, "channel");
            return this;


        }

        public Criteria andChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("channel not between", value1, value2, "channel");
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

        public Criteria andIssueEqualTo(Integer value) {
            addCriterion("issue =", value, "issue");
            return this;


        }

        public Criteria andIssueNotEqualTo(Integer value) {
            addCriterion("issue <>", value, "issue");
            return this;


        }

        public Criteria andIssueGreaterThan(Integer value) {
            addCriterion("issue >", value, "issue");
            return this;


        }

        public Criteria andIssueGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue >=", value, "issue");
            return this;


        }

        public Criteria andIssueLessThan(Integer value) {
            addCriterion("issue <", value, "issue");
            return this;


        }

        public Criteria andIssueLessThanOrEqualTo(Integer value) {
            addCriterion("issue <=", value, "issue");
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

        public Criteria andIssueBetween(Integer value1, Integer value2) {
            addCriterion("issue between", value1, value2, "issue");
            return this;


        }

        public Criteria andIssueNotBetween(Integer value1, Integer value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return this;


        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return this;


        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return this;


        }

        public Criteria andMarketPriceEqualTo(String value) {
            addCriterion("market_price =", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceNotEqualTo(String value) {
            addCriterion("market_price <>", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceGreaterThan(String value) {
            addCriterion("market_price >", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(String value) {
            addCriterion("market_price >=", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceLessThan(String value) {
            addCriterion("market_price <", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceLessThanOrEqualTo(String value) {
            addCriterion("market_price <=", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceLike(String value) {
            addCriterion("market_price like", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceNotLike(String value) {
            addCriterion("market_price not like", value, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceIn(List values) {
            addCriterion("market_price in", values, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceNotIn(List values) {
            addCriterion("market_price not in", values, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceBetween(String value1, String value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return this;


        }

        public Criteria andMarketPriceNotBetween(String value1, String value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
            return this;


        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return this;


        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return this;


        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return this;


        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return this;


        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return this;


        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return this;


        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return this;


        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return this;


        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return this;


        }

        public Criteria andPriceIn(List values) {
            addCriterion("price in", values, "price");
            return this;


        }

        public Criteria andPriceNotIn(List values) {
            addCriterion("price not in", values, "price");
            return this;


        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return this;


        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return this;


        }

        public Criteria andPriceUrlIsNull() {
            addCriterion("price_url is null");
            return this;


        }

        public Criteria andPriceUrlIsNotNull() {
            addCriterion("price_url is not null");
            return this;


        }

        public Criteria andPriceUrlEqualTo(String value) {
            addCriterion("price_url =", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlNotEqualTo(String value) {
            addCriterion("price_url <>", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlGreaterThan(String value) {
            addCriterion("price_url >", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("price_url >=", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlLessThan(String value) {
            addCriterion("price_url <", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlLessThanOrEqualTo(String value) {
            addCriterion("price_url <=", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlLike(String value) {
            addCriterion("price_url like", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlNotLike(String value) {
            addCriterion("price_url not like", value, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlIn(List values) {
            addCriterion("price_url in", values, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlNotIn(List values) {
            addCriterion("price_url not in", values, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlBetween(String value1, String value2) {
            addCriterion("price_url between", value1, value2, "priceUrl");
            return this;


        }

        public Criteria andPriceUrlNotBetween(String value1, String value2) {
            addCriterion("price_url not between", value1, value2, "priceUrl");
            return this;


        }

        public Criteria andTitleAllIsNull() {
            addCriterion("title_all is null");
            return this;


        }

        public Criteria andTitleAllIsNotNull() {
            addCriterion("title_all is not null");
            return this;


        }

        public Criteria andTitleAllEqualTo(String value) {
            addCriterion("title_all =", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllNotEqualTo(String value) {
            addCriterion("title_all <>", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllGreaterThan(String value) {
            addCriterion("title_all >", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllGreaterThanOrEqualTo(String value) {
            addCriterion("title_all >=", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllLessThan(String value) {
            addCriterion("title_all <", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllLessThanOrEqualTo(String value) {
            addCriterion("title_all <=", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllLike(String value) {
            addCriterion("title_all like", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllNotLike(String value) {
            addCriterion("title_all not like", value, "titleAll");
            return this;


        }

        public Criteria andTitleAllIn(List values) {
            addCriterion("title_all in", values, "titleAll");
            return this;


        }

        public Criteria andTitleAllNotIn(List values) {
            addCriterion("title_all not in", values, "titleAll");
            return this;


        }

        public Criteria andTitleAllBetween(String value1, String value2) {
            addCriterion("title_all between", value1, value2, "titleAll");
            return this;


        }

        public Criteria andTitleAllNotBetween(String value1, String value2) {
            addCriterion("title_all not between", value1, value2, "titleAll");
            return this;


        }


    }


}
