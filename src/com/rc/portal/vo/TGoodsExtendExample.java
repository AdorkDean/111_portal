package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TGoodsExtendExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TGoodsExtendExample() {
        oredCriteria = new ArrayList();


    }

    protected TGoodsExtendExample(TGoodsExtendExample example) {
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return this;


        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return this;


        }

        public Criteria andGoodsidEqualTo(Long value) {
            addCriterion("goodsid =", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotEqualTo(Long value) {
            addCriterion("goodsid <>", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidGreaterThan(Long value) {
            addCriterion("goodsid >", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsid >=", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidLessThan(Long value) {
            addCriterion("goodsid <", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidLessThanOrEqualTo(Long value) {
            addCriterion("goodsid <=", value, "goodsid");
            return this;


        }

        public Criteria andGoodsidIn(List values) {
            addCriterion("goodsid in", values, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotIn(List values) {
            addCriterion("goodsid not in", values, "goodsid");
            return this;


        }

        public Criteria andGoodsidBetween(Long value1, Long value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return this;


        }

        public Criteria andGoodsidNotBetween(Long value1, Long value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return this;


        }

        public Criteria andPinyinCodeIsNull() {
            addCriterion("pinyin_code is null");
            return this;


        }

        public Criteria andPinyinCodeIsNotNull() {
            addCriterion("pinyin_code is not null");
            return this;


        }

        public Criteria andPinyinCodeEqualTo(String value) {
            addCriterion("pinyin_code =", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeNotEqualTo(String value) {
            addCriterion("pinyin_code <>", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeGreaterThan(String value) {
            addCriterion("pinyin_code >", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin_code >=", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeLessThan(String value) {
            addCriterion("pinyin_code <", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeLessThanOrEqualTo(String value) {
            addCriterion("pinyin_code <=", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeLike(String value) {
            addCriterion("pinyin_code like", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeNotLike(String value) {
            addCriterion("pinyin_code not like", value, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeIn(List values) {
            addCriterion("pinyin_code in", values, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeNotIn(List values) {
            addCriterion("pinyin_code not in", values, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeBetween(String value1, String value2) {
            addCriterion("pinyin_code between", value1, value2, "pinyinCode");
            return this;


        }

        public Criteria andPinyinCodeNotBetween(String value1, String value2) {
            addCriterion("pinyin_code not between", value1, value2, "pinyinCode");
            return this;


        }

        public Criteria andBasesIsNull() {
            addCriterion("bases is null");
            return this;


        }

        public Criteria andBasesIsNotNull() {
            addCriterion("bases is not null");
            return this;


        }

        public Criteria andBasesEqualTo(String value) {
            addCriterion("bases =", value, "bases");
            return this;


        }

        public Criteria andBasesNotEqualTo(String value) {
            addCriterion("bases <>", value, "bases");
            return this;


        }

        public Criteria andBasesGreaterThan(String value) {
            addCriterion("bases >", value, "bases");
            return this;


        }

        public Criteria andBasesGreaterThanOrEqualTo(String value) {
            addCriterion("bases >=", value, "bases");
            return this;


        }

        public Criteria andBasesLessThan(String value) {
            addCriterion("bases <", value, "bases");
            return this;


        }

        public Criteria andBasesLessThanOrEqualTo(String value) {
            addCriterion("bases <=", value, "bases");
            return this;


        }

        public Criteria andBasesLike(String value) {
            addCriterion("bases like", value, "bases");
            return this;


        }

        public Criteria andBasesNotLike(String value) {
            addCriterion("bases not like", value, "bases");
            return this;


        }

        public Criteria andBasesIn(List values) {
            addCriterion("bases in", values, "bases");
            return this;


        }

        public Criteria andBasesNotIn(List values) {
            addCriterion("bases not in", values, "bases");
            return this;


        }

        public Criteria andBasesBetween(String value1, String value2) {
            addCriterion("bases between", value1, value2, "bases");
            return this;


        }

        public Criteria andBasesNotBetween(String value1, String value2) {
            addCriterion("bases not between", value1, value2, "bases");
            return this;


        }

        public Criteria andCharacterdIsNull() {
            addCriterion("characterd is null");
            return this;


        }

        public Criteria andCharacterdIsNotNull() {
            addCriterion("characterd is not null");
            return this;


        }

        public Criteria andCharacterdEqualTo(String value) {
            addCriterion("characterd =", value, "characterd");
            return this;


        }

        public Criteria andCharacterdNotEqualTo(String value) {
            addCriterion("characterd <>", value, "characterd");
            return this;


        }

        public Criteria andCharacterdGreaterThan(String value) {
            addCriterion("characterd >", value, "characterd");
            return this;


        }

        public Criteria andCharacterdGreaterThanOrEqualTo(String value) {
            addCriterion("characterd >=", value, "characterd");
            return this;


        }

        public Criteria andCharacterdLessThan(String value) {
            addCriterion("characterd <", value, "characterd");
            return this;


        }

        public Criteria andCharacterdLessThanOrEqualTo(String value) {
            addCriterion("characterd <=", value, "characterd");
            return this;


        }

        public Criteria andCharacterdLike(String value) {
            addCriterion("characterd like", value, "characterd");
            return this;


        }

        public Criteria andCharacterdNotLike(String value) {
            addCriterion("characterd not like", value, "characterd");
            return this;


        }

        public Criteria andCharacterdIn(List values) {
            addCriterion("characterd in", values, "characterd");
            return this;


        }

        public Criteria andCharacterdNotIn(List values) {
            addCriterion("characterd not in", values, "characterd");
            return this;


        }

        public Criteria andCharacterdBetween(String value1, String value2) {
            addCriterion("characterd between", value1, value2, "characterd");
            return this;


        }

        public Criteria andCharacterdNotBetween(String value1, String value2) {
            addCriterion("characterd not between", value1, value2, "characterd");
            return this;


        }

        public Criteria andIndicationIsNull() {
            addCriterion("indication is null");
            return this;


        }

        public Criteria andIndicationIsNotNull() {
            addCriterion("indication is not null");
            return this;


        }

        public Criteria andIndicationEqualTo(String value) {
            addCriterion("indication =", value, "indication");
            return this;


        }

        public Criteria andIndicationNotEqualTo(String value) {
            addCriterion("indication <>", value, "indication");
            return this;


        }

        public Criteria andIndicationGreaterThan(String value) {
            addCriterion("indication >", value, "indication");
            return this;


        }

        public Criteria andIndicationGreaterThanOrEqualTo(String value) {
            addCriterion("indication >=", value, "indication");
            return this;


        }

        public Criteria andIndicationLessThan(String value) {
            addCriterion("indication <", value, "indication");
            return this;


        }

        public Criteria andIndicationLessThanOrEqualTo(String value) {
            addCriterion("indication <=", value, "indication");
            return this;


        }

        public Criteria andIndicationLike(String value) {
            addCriterion("indication like", value, "indication");
            return this;


        }

        public Criteria andIndicationNotLike(String value) {
            addCriterion("indication not like", value, "indication");
            return this;


        }

        public Criteria andIndicationIn(List values) {
            addCriterion("indication in", values, "indication");
            return this;


        }

        public Criteria andIndicationNotIn(List values) {
            addCriterion("indication not in", values, "indication");
            return this;


        }

        public Criteria andIndicationBetween(String value1, String value2) {
            addCriterion("indication between", value1, value2, "indication");
            return this;


        }

        public Criteria andIndicationNotBetween(String value1, String value2) {
            addCriterion("indication not between", value1, value2, "indication");
            return this;


        }

        public Criteria andUsagedIsNull() {
            addCriterion("usaged is null");
            return this;


        }

        public Criteria andUsagedIsNotNull() {
            addCriterion("usaged is not null");
            return this;


        }

        public Criteria andUsagedEqualTo(String value) {
            addCriterion("usaged =", value, "usaged");
            return this;


        }

        public Criteria andUsagedNotEqualTo(String value) {
            addCriterion("usaged <>", value, "usaged");
            return this;


        }

        public Criteria andUsagedGreaterThan(String value) {
            addCriterion("usaged >", value, "usaged");
            return this;


        }

        public Criteria andUsagedGreaterThanOrEqualTo(String value) {
            addCriterion("usaged >=", value, "usaged");
            return this;


        }

        public Criteria andUsagedLessThan(String value) {
            addCriterion("usaged <", value, "usaged");
            return this;


        }

        public Criteria andUsagedLessThanOrEqualTo(String value) {
            addCriterion("usaged <=", value, "usaged");
            return this;


        }

        public Criteria andUsagedLike(String value) {
            addCriterion("usaged like", value, "usaged");
            return this;


        }

        public Criteria andUsagedNotLike(String value) {
            addCriterion("usaged not like", value, "usaged");
            return this;


        }

        public Criteria andUsagedIn(List values) {
            addCriterion("usaged in", values, "usaged");
            return this;


        }

        public Criteria andUsagedNotIn(List values) {
            addCriterion("usaged not in", values, "usaged");
            return this;


        }

        public Criteria andUsagedBetween(String value1, String value2) {
            addCriterion("usaged between", value1, value2, "usaged");
            return this;


        }

        public Criteria andUsagedNotBetween(String value1, String value2) {
            addCriterion("usaged not between", value1, value2, "usaged");
            return this;


        }

        public Criteria andUntowardEffectIsNull() {
            addCriterion("untoward_effect is null");
            return this;


        }

        public Criteria andUntowardEffectIsNotNull() {
            addCriterion("untoward_effect is not null");
            return this;


        }

        public Criteria andUntowardEffectEqualTo(String value) {
            addCriterion("untoward_effect =", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectNotEqualTo(String value) {
            addCriterion("untoward_effect <>", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectGreaterThan(String value) {
            addCriterion("untoward_effect >", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectGreaterThanOrEqualTo(String value) {
            addCriterion("untoward_effect >=", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectLessThan(String value) {
            addCriterion("untoward_effect <", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectLessThanOrEqualTo(String value) {
            addCriterion("untoward_effect <=", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectLike(String value) {
            addCriterion("untoward_effect like", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectNotLike(String value) {
            addCriterion("untoward_effect not like", value, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectIn(List values) {
            addCriterion("untoward_effect in", values, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectNotIn(List values) {
            addCriterion("untoward_effect not in", values, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectBetween(String value1, String value2) {
            addCriterion("untoward_effect between", value1, value2, "untowardEffect");
            return this;


        }

        public Criteria andUntowardEffectNotBetween(String value1, String value2) {
            addCriterion("untoward_effect not between", value1, value2, "untowardEffect");
            return this;


        }

        public Criteria andTabooIsNull() {
            addCriterion("taboo is null");
            return this;


        }

        public Criteria andTabooIsNotNull() {
            addCriterion("taboo is not null");
            return this;


        }

        public Criteria andTabooEqualTo(String value) {
            addCriterion("taboo =", value, "taboo");
            return this;


        }

        public Criteria andTabooNotEqualTo(String value) {
            addCriterion("taboo <>", value, "taboo");
            return this;


        }

        public Criteria andTabooGreaterThan(String value) {
            addCriterion("taboo >", value, "taboo");
            return this;


        }

        public Criteria andTabooGreaterThanOrEqualTo(String value) {
            addCriterion("taboo >=", value, "taboo");
            return this;


        }

        public Criteria andTabooLessThan(String value) {
            addCriterion("taboo <", value, "taboo");
            return this;


        }

        public Criteria andTabooLessThanOrEqualTo(String value) {
            addCriterion("taboo <=", value, "taboo");
            return this;


        }

        public Criteria andTabooLike(String value) {
            addCriterion("taboo like", value, "taboo");
            return this;


        }

        public Criteria andTabooNotLike(String value) {
            addCriterion("taboo not like", value, "taboo");
            return this;


        }

        public Criteria andTabooIn(List values) {
            addCriterion("taboo in", values, "taboo");
            return this;


        }

        public Criteria andTabooNotIn(List values) {
            addCriterion("taboo not in", values, "taboo");
            return this;


        }

        public Criteria andTabooBetween(String value1, String value2) {
            addCriterion("taboo between", value1, value2, "taboo");
            return this;


        }

        public Criteria andTabooNotBetween(String value1, String value2) {
            addCriterion("taboo not between", value1, value2, "taboo");
            return this;


        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return this;


        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return this;


        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return this;


        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return this;


        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return this;


        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return this;


        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return this;


        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return this;


        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return this;


        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return this;


        }

        public Criteria andNoteIn(List values) {
            addCriterion("note in", values, "note");
            return this;


        }

        public Criteria andNoteNotIn(List values) {
            addCriterion("note not in", values, "note");
            return this;


        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return this;


        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return this;


        }

        public Criteria andPharmacologyIsNull() {
            addCriterion("pharmacology is null");
            return this;


        }

        public Criteria andPharmacologyIsNotNull() {
            addCriterion("pharmacology is not null");
            return this;


        }

        public Criteria andPharmacologyEqualTo(String value) {
            addCriterion("pharmacology =", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyNotEqualTo(String value) {
            addCriterion("pharmacology <>", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyGreaterThan(String value) {
            addCriterion("pharmacology >", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyGreaterThanOrEqualTo(String value) {
            addCriterion("pharmacology >=", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyLessThan(String value) {
            addCriterion("pharmacology <", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyLessThanOrEqualTo(String value) {
            addCriterion("pharmacology <=", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyLike(String value) {
            addCriterion("pharmacology like", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyNotLike(String value) {
            addCriterion("pharmacology not like", value, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyIn(List values) {
            addCriterion("pharmacology in", values, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyNotIn(List values) {
            addCriterion("pharmacology not in", values, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyBetween(String value1, String value2) {
            addCriterion("pharmacology between", value1, value2, "pharmacology");
            return this;


        }

        public Criteria andPharmacologyNotBetween(String value1, String value2) {
            addCriterion("pharmacology not between", value1, value2, "pharmacology");
            return this;


        }

        public Criteria andStoragedIsNull() {
            addCriterion("storaged is null");
            return this;


        }

        public Criteria andStoragedIsNotNull() {
            addCriterion("storaged is not null");
            return this;


        }

        public Criteria andStoragedEqualTo(String value) {
            addCriterion("storaged =", value, "storaged");
            return this;


        }

        public Criteria andStoragedNotEqualTo(String value) {
            addCriterion("storaged <>", value, "storaged");
            return this;


        }

        public Criteria andStoragedGreaterThan(String value) {
            addCriterion("storaged >", value, "storaged");
            return this;


        }

        public Criteria andStoragedGreaterThanOrEqualTo(String value) {
            addCriterion("storaged >=", value, "storaged");
            return this;


        }

        public Criteria andStoragedLessThan(String value) {
            addCriterion("storaged <", value, "storaged");
            return this;


        }

        public Criteria andStoragedLessThanOrEqualTo(String value) {
            addCriterion("storaged <=", value, "storaged");
            return this;


        }

        public Criteria andStoragedLike(String value) {
            addCriterion("storaged like", value, "storaged");
            return this;


        }

        public Criteria andStoragedNotLike(String value) {
            addCriterion("storaged not like", value, "storaged");
            return this;


        }

        public Criteria andStoragedIn(List values) {
            addCriterion("storaged in", values, "storaged");
            return this;


        }

        public Criteria andStoragedNotIn(List values) {
            addCriterion("storaged not in", values, "storaged");
            return this;


        }

        public Criteria andStoragedBetween(String value1, String value2) {
            addCriterion("storaged between", value1, value2, "storaged");
            return this;


        }

        public Criteria andStoragedNotBetween(String value1, String value2) {
            addCriterion("storaged not between", value1, value2, "storaged");
            return this;


        }

        public Criteria andPackingIsNull() {
            addCriterion("packing is null");
            return this;


        }

        public Criteria andPackingIsNotNull() {
            addCriterion("packing is not null");
            return this;


        }

        public Criteria andPackingEqualTo(String value) {
            addCriterion("packing =", value, "packing");
            return this;


        }

        public Criteria andPackingNotEqualTo(String value) {
            addCriterion("packing <>", value, "packing");
            return this;


        }

        public Criteria andPackingGreaterThan(String value) {
            addCriterion("packing >", value, "packing");
            return this;


        }

        public Criteria andPackingGreaterThanOrEqualTo(String value) {
            addCriterion("packing >=", value, "packing");
            return this;


        }

        public Criteria andPackingLessThan(String value) {
            addCriterion("packing <", value, "packing");
            return this;


        }

        public Criteria andPackingLessThanOrEqualTo(String value) {
            addCriterion("packing <=", value, "packing");
            return this;


        }

        public Criteria andPackingLike(String value) {
            addCriterion("packing like", value, "packing");
            return this;


        }

        public Criteria andPackingNotLike(String value) {
            addCriterion("packing not like", value, "packing");
            return this;


        }

        public Criteria andPackingIn(List values) {
            addCriterion("packing in", values, "packing");
            return this;


        }

        public Criteria andPackingNotIn(List values) {
            addCriterion("packing not in", values, "packing");
            return this;


        }

        public Criteria andPackingBetween(String value1, String value2) {
            addCriterion("packing between", value1, value2, "packing");
            return this;


        }

        public Criteria andPackingNotBetween(String value1, String value2) {
            addCriterion("packing not between", value1, value2, "packing");
            return this;


        }

        public Criteria andLastsIsNull() {
            addCriterion("lasts is null");
            return this;


        }

        public Criteria andLastsIsNotNull() {
            addCriterion("lasts is not null");
            return this;


        }

        public Criteria andLastsEqualTo(String value) {
            addCriterion("lasts =", value, "lasts");
            return this;


        }

        public Criteria andLastsNotEqualTo(String value) {
            addCriterion("lasts <>", value, "lasts");
            return this;


        }

        public Criteria andLastsGreaterThan(String value) {
            addCriterion("lasts >", value, "lasts");
            return this;


        }

        public Criteria andLastsGreaterThanOrEqualTo(String value) {
            addCriterion("lasts >=", value, "lasts");
            return this;


        }

        public Criteria andLastsLessThan(String value) {
            addCriterion("lasts <", value, "lasts");
            return this;


        }

        public Criteria andLastsLessThanOrEqualTo(String value) {
            addCriterion("lasts <=", value, "lasts");
            return this;


        }

        public Criteria andLastsLike(String value) {
            addCriterion("lasts like", value, "lasts");
            return this;


        }

        public Criteria andLastsNotLike(String value) {
            addCriterion("lasts not like", value, "lasts");
            return this;


        }

        public Criteria andLastsIn(List values) {
            addCriterion("lasts in", values, "lasts");
            return this;


        }

        public Criteria andLastsNotIn(List values) {
            addCriterion("lasts not in", values, "lasts");
            return this;


        }

        public Criteria andLastsBetween(String value1, String value2) {
            addCriterion("lasts between", value1, value2, "lasts");
            return this;


        }

        public Criteria andLastsNotBetween(String value1, String value2) {
            addCriterion("lasts not between", value1, value2, "lasts");
            return this;


        }

        public Criteria andAttendingIsNull() {
            addCriterion("attending is null");
            return this;


        }

        public Criteria andAttendingIsNotNull() {
            addCriterion("attending is not null");
            return this;


        }

        public Criteria andAttendingEqualTo(String value) {
            addCriterion("attending =", value, "attending");
            return this;


        }

        public Criteria andAttendingNotEqualTo(String value) {
            addCriterion("attending <>", value, "attending");
            return this;


        }

        public Criteria andAttendingGreaterThan(String value) {
            addCriterion("attending >", value, "attending");
            return this;


        }

        public Criteria andAttendingGreaterThanOrEqualTo(String value) {
            addCriterion("attending >=", value, "attending");
            return this;


        }

        public Criteria andAttendingLessThan(String value) {
            addCriterion("attending <", value, "attending");
            return this;


        }

        public Criteria andAttendingLessThanOrEqualTo(String value) {
            addCriterion("attending <=", value, "attending");
            return this;


        }

        public Criteria andAttendingLike(String value) {
            addCriterion("attending like", value, "attending");
            return this;


        }

        public Criteria andAttendingNotLike(String value) {
            addCriterion("attending not like", value, "attending");
            return this;


        }

        public Criteria andAttendingIn(List values) {
            addCriterion("attending in", values, "attending");
            return this;


        }

        public Criteria andAttendingNotIn(List values) {
            addCriterion("attending not in", values, "attending");
            return this;


        }

        public Criteria andAttendingBetween(String value1, String value2) {
            addCriterion("attending between", value1, value2, "attending");
            return this;


        }

        public Criteria andAttendingNotBetween(String value1, String value2) {
            addCriterion("attending not between", value1, value2, "attending");
            return this;


        }

        public Criteria andSeoTitleIsNull() {
            addCriterion("seo_title is null");
            return this;


        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("seo_title is not null");
            return this;


        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("seo_title =", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("seo_title <>", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("seo_title >", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("seo_title >=", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("seo_title <", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("seo_title <=", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("seo_title like", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("seo_title not like", value, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleIn(List values) {
            addCriterion("seo_title in", values, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotIn(List values) {
            addCriterion("seo_title not in", values, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("seo_title between", value1, value2, "seoTitle");
            return this;


        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("seo_title not between", value1, value2, "seoTitle");
            return this;


        }

        public Criteria andSeoKeywordIsNull() {
            addCriterion("seo_keyword is null");
            return this;


        }

        public Criteria andSeoKeywordIsNotNull() {
            addCriterion("seo_keyword is not null");
            return this;


        }

        public Criteria andSeoKeywordEqualTo(String value) {
            addCriterion("seo_keyword =", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotEqualTo(String value) {
            addCriterion("seo_keyword <>", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordGreaterThan(String value) {
            addCriterion("seo_keyword >", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("seo_keyword >=", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLessThan(String value) {
            addCriterion("seo_keyword <", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLessThanOrEqualTo(String value) {
            addCriterion("seo_keyword <=", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordLike(String value) {
            addCriterion("seo_keyword like", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotLike(String value) {
            addCriterion("seo_keyword not like", value, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordIn(List values) {
            addCriterion("seo_keyword in", values, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotIn(List values) {
            addCriterion("seo_keyword not in", values, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordBetween(String value1, String value2) {
            addCriterion("seo_keyword between", value1, value2, "seoKeyword");
            return this;


        }

        public Criteria andSeoKeywordNotBetween(String value1, String value2) {
            addCriterion("seo_keyword not between", value1, value2, "seoKeyword");
            return this;


        }

        public Criteria andSeoDescribeIsNull() {
            addCriterion("seo_describe is null");
            return this;


        }

        public Criteria andSeoDescribeIsNotNull() {
            addCriterion("seo_describe is not null");
            return this;


        }

        public Criteria andSeoDescribeEqualTo(String value) {
            addCriterion("seo_describe =", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotEqualTo(String value) {
            addCriterion("seo_describe <>", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeGreaterThan(String value) {
            addCriterion("seo_describe >", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("seo_describe >=", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLessThan(String value) {
            addCriterion("seo_describe <", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLessThanOrEqualTo(String value) {
            addCriterion("seo_describe <=", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeLike(String value) {
            addCriterion("seo_describe like", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotLike(String value) {
            addCriterion("seo_describe not like", value, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeIn(List values) {
            addCriterion("seo_describe in", values, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotIn(List values) {
            addCriterion("seo_describe not in", values, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeBetween(String value1, String value2) {
            addCriterion("seo_describe between", value1, value2, "seoDescribe");
            return this;


        }

        public Criteria andSeoDescribeNotBetween(String value1, String value2) {
            addCriterion("seo_describe not between", value1, value2, "seoDescribe");
            return this;


        }

        public Criteria andSymptomIsNull() {
            addCriterion("symptom is null");
            return this;


        }

        public Criteria andSymptomIsNotNull() {
            addCriterion("symptom is not null");
            return this;


        }

        public Criteria andSymptomEqualTo(String value) {
            addCriterion("symptom =", value, "symptom");
            return this;


        }

        public Criteria andSymptomNotEqualTo(String value) {
            addCriterion("symptom <>", value, "symptom");
            return this;


        }

        public Criteria andSymptomGreaterThan(String value) {
            addCriterion("symptom >", value, "symptom");
            return this;


        }

        public Criteria andSymptomGreaterThanOrEqualTo(String value) {
            addCriterion("symptom >=", value, "symptom");
            return this;


        }

        public Criteria andSymptomLessThan(String value) {
            addCriterion("symptom <", value, "symptom");
            return this;


        }

        public Criteria andSymptomLessThanOrEqualTo(String value) {
            addCriterion("symptom <=", value, "symptom");
            return this;


        }

        public Criteria andSymptomLike(String value) {
            addCriterion("symptom like", value, "symptom");
            return this;


        }

        public Criteria andSymptomNotLike(String value) {
            addCriterion("symptom not like", value, "symptom");
            return this;


        }

        public Criteria andSymptomIn(List values) {
            addCriterion("symptom in", values, "symptom");
            return this;


        }

        public Criteria andSymptomNotIn(List values) {
            addCriterion("symptom not in", values, "symptom");
            return this;


        }

        public Criteria andSymptomBetween(String value1, String value2) {
            addCriterion("symptom between", value1, value2, "symptom");
            return this;


        }

        public Criteria andSymptomNotBetween(String value1, String value2) {
            addCriterion("symptom not between", value1, value2, "symptom");
            return this;


        }

        public Criteria andSymptomRmIsNull() {
            addCriterion("symptom_rm is null");
            return this;


        }

        public Criteria andSymptomRmIsNotNull() {
            addCriterion("symptom_rm is not null");
            return this;


        }

        public Criteria andSymptomRmEqualTo(String value) {
            addCriterion("symptom_rm =", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmNotEqualTo(String value) {
            addCriterion("symptom_rm <>", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmGreaterThan(String value) {
            addCriterion("symptom_rm >", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_rm >=", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmLessThan(String value) {
            addCriterion("symptom_rm <", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmLessThanOrEqualTo(String value) {
            addCriterion("symptom_rm <=", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmLike(String value) {
            addCriterion("symptom_rm like", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmNotLike(String value) {
            addCriterion("symptom_rm not like", value, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmIn(List values) {
            addCriterion("symptom_rm in", values, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmNotIn(List values) {
            addCriterion("symptom_rm not in", values, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmBetween(String value1, String value2) {
            addCriterion("symptom_rm between", value1, value2, "symptomRm");
            return this;


        }

        public Criteria andSymptomRmNotBetween(String value1, String value2) {
            addCriterion("symptom_rm not between", value1, value2, "symptomRm");
            return this;


        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return this;


        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return this;


        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return this;


        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return this;


        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return this;


        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return this;


        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return this;


        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return this;


        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return this;


        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return this;


        }

        public Criteria andPositionIn(List values) {
            addCriterion("position in", values, "position");
            return this;


        }

        public Criteria andPositionNotIn(List values) {
            addCriterion("position not in", values, "position");
            return this;


        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return this;


        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return this;


        }

        public Criteria andPositionRmIsNull() {
            addCriterion("position_rm is null");
            return this;


        }

        public Criteria andPositionRmIsNotNull() {
            addCriterion("position_rm is not null");
            return this;


        }

        public Criteria andPositionRmEqualTo(String value) {
            addCriterion("position_rm =", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmNotEqualTo(String value) {
            addCriterion("position_rm <>", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmGreaterThan(String value) {
            addCriterion("position_rm >", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmGreaterThanOrEqualTo(String value) {
            addCriterion("position_rm >=", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmLessThan(String value) {
            addCriterion("position_rm <", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmLessThanOrEqualTo(String value) {
            addCriterion("position_rm <=", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmLike(String value) {
            addCriterion("position_rm like", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmNotLike(String value) {
            addCriterion("position_rm not like", value, "positionRm");
            return this;


        }

        public Criteria andPositionRmIn(List values) {
            addCriterion("position_rm in", values, "positionRm");
            return this;


        }

        public Criteria andPositionRmNotIn(List values) {
            addCriterion("position_rm not in", values, "positionRm");
            return this;


        }

        public Criteria andPositionRmBetween(String value1, String value2) {
            addCriterion("position_rm between", value1, value2, "positionRm");
            return this;


        }

        public Criteria andPositionRmNotBetween(String value1, String value2) {
            addCriterion("position_rm not between", value1, value2, "positionRm");
            return this;


        }

        public Criteria andDiseaseIsNull() {
            addCriterion("disease is null");
            return this;


        }

        public Criteria andDiseaseIsNotNull() {
            addCriterion("disease is not null");
            return this;


        }

        public Criteria andDiseaseEqualTo(String value) {
            addCriterion("disease =", value, "disease");
            return this;


        }

        public Criteria andDiseaseNotEqualTo(String value) {
            addCriterion("disease <>", value, "disease");
            return this;


        }

        public Criteria andDiseaseGreaterThan(String value) {
            addCriterion("disease >", value, "disease");
            return this;


        }

        public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("disease >=", value, "disease");
            return this;


        }

        public Criteria andDiseaseLessThan(String value) {
            addCriterion("disease <", value, "disease");
            return this;


        }

        public Criteria andDiseaseLessThanOrEqualTo(String value) {
            addCriterion("disease <=", value, "disease");
            return this;


        }

        public Criteria andDiseaseLike(String value) {
            addCriterion("disease like", value, "disease");
            return this;


        }

        public Criteria andDiseaseNotLike(String value) {
            addCriterion("disease not like", value, "disease");
            return this;


        }

        public Criteria andDiseaseIn(List values) {
            addCriterion("disease in", values, "disease");
            return this;


        }

        public Criteria andDiseaseNotIn(List values) {
            addCriterion("disease not in", values, "disease");
            return this;


        }

        public Criteria andDiseaseBetween(String value1, String value2) {
            addCriterion("disease between", value1, value2, "disease");
            return this;


        }

        public Criteria andDiseaseNotBetween(String value1, String value2) {
            addCriterion("disease not between", value1, value2, "disease");
            return this;


        }

        public Criteria andDiseaseRmIsNull() {
            addCriterion("disease_rm is null");
            return this;


        }

        public Criteria andDiseaseRmIsNotNull() {
            addCriterion("disease_rm is not null");
            return this;


        }

        public Criteria andDiseaseRmEqualTo(String value) {
            addCriterion("disease_rm =", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmNotEqualTo(String value) {
            addCriterion("disease_rm <>", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmGreaterThan(String value) {
            addCriterion("disease_rm >", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmGreaterThanOrEqualTo(String value) {
            addCriterion("disease_rm >=", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmLessThan(String value) {
            addCriterion("disease_rm <", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmLessThanOrEqualTo(String value) {
            addCriterion("disease_rm <=", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmLike(String value) {
            addCriterion("disease_rm like", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmNotLike(String value) {
            addCriterion("disease_rm not like", value, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmIn(List values) {
            addCriterion("disease_rm in", values, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmNotIn(List values) {
            addCriterion("disease_rm not in", values, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmBetween(String value1, String value2) {
            addCriterion("disease_rm between", value1, value2, "diseaseRm");
            return this;


        }

        public Criteria andDiseaseRmNotBetween(String value1, String value2) {
            addCriterion("disease_rm not between", value1, value2, "diseaseRm");
            return this;


        }


    }


}
