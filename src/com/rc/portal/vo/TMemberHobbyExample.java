package com.rc.portal.vo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.app.framework.webapp.model.BaseModel;

public class TMemberHobbyExample  extends BaseModel{

    protected String orderByClause;

    protected List oredCriteria;

    public TMemberHobbyExample() {
        oredCriteria = new ArrayList();


    }

    protected TMemberHobbyExample(TMemberHobbyExample example) {
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

        public Criteria andShoppingLikeIsNull() {
            addCriterion("shopping_like is null");
            return this;


        }

        public Criteria andShoppingLikeIsNotNull() {
            addCriterion("shopping_like is not null");
            return this;


        }

        public Criteria andShoppingLikeEqualTo(String value) {
            addCriterion("shopping_like =", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeNotEqualTo(String value) {
            addCriterion("shopping_like <>", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeGreaterThan(String value) {
            addCriterion("shopping_like >", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeGreaterThanOrEqualTo(String value) {
            addCriterion("shopping_like >=", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeLessThan(String value) {
            addCriterion("shopping_like <", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeLessThanOrEqualTo(String value) {
            addCriterion("shopping_like <=", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeLike(String value) {
            addCriterion("shopping_like like", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeNotLike(String value) {
            addCriterion("shopping_like not like", value, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeIn(List values) {
            addCriterion("shopping_like in", values, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeNotIn(List values) {
            addCriterion("shopping_like not in", values, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeBetween(String value1, String value2) {
            addCriterion("shopping_like between", value1, value2, "shoppingLike");
            return this;


        }

        public Criteria andShoppingLikeNotBetween(String value1, String value2) {
            addCriterion("shopping_like not between", value1, value2, "shoppingLike");
            return this;


        }

        public Criteria andShoppingPreferenceIsNull() {
            addCriterion("shopping_preference is null");
            return this;


        }

        public Criteria andShoppingPreferenceIsNotNull() {
            addCriterion("shopping_preference is not null");
            return this;


        }

        public Criteria andShoppingPreferenceEqualTo(String value) {
            addCriterion("shopping_preference =", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceNotEqualTo(String value) {
            addCriterion("shopping_preference <>", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceGreaterThan(String value) {
            addCriterion("shopping_preference >", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceGreaterThanOrEqualTo(String value) {
            addCriterion("shopping_preference >=", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceLessThan(String value) {
            addCriterion("shopping_preference <", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceLessThanOrEqualTo(String value) {
            addCriterion("shopping_preference <=", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceLike(String value) {
            addCriterion("shopping_preference like", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceNotLike(String value) {
            addCriterion("shopping_preference not like", value, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceIn(List values) {
            addCriterion("shopping_preference in", values, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceNotIn(List values) {
            addCriterion("shopping_preference not in", values, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceBetween(String value1, String value2) {
            addCriterion("shopping_preference between", value1, value2, "shoppingPreference");
            return this;


        }

        public Criteria andShoppingPreferenceNotBetween(String value1, String value2) {
            addCriterion("shopping_preference not between", value1, value2, "shoppingPreference");
            return this;


        }

        public Criteria andLikeFilmIsNull() {
            addCriterion("like_film is null");
            return this;


        }

        public Criteria andLikeFilmIsNotNull() {
            addCriterion("like_film is not null");
            return this;


        }

        public Criteria andLikeFilmEqualTo(String value) {
            addCriterion("like_film =", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmNotEqualTo(String value) {
            addCriterion("like_film <>", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmGreaterThan(String value) {
            addCriterion("like_film >", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmGreaterThanOrEqualTo(String value) {
            addCriterion("like_film >=", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmLessThan(String value) {
            addCriterion("like_film <", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmLessThanOrEqualTo(String value) {
            addCriterion("like_film <=", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmLike(String value) {
            addCriterion("like_film like", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmNotLike(String value) {
            addCriterion("like_film not like", value, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmIn(List values) {
            addCriterion("like_film in", values, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmNotIn(List values) {
            addCriterion("like_film not in", values, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmBetween(String value1, String value2) {
            addCriterion("like_film between", value1, value2, "likeFilm");
            return this;


        }

        public Criteria andLikeFilmNotBetween(String value1, String value2) {
            addCriterion("like_film not between", value1, value2, "likeFilm");
            return this;


        }

        public Criteria andLikeCharacterIsNull() {
            addCriterion("like_character is null");
            return this;


        }

        public Criteria andLikeCharacterIsNotNull() {
            addCriterion("like_character is not null");
            return this;


        }

        public Criteria andLikeCharacterEqualTo(String value) {
            addCriterion("like_character =", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterNotEqualTo(String value) {
            addCriterion("like_character <>", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterGreaterThan(String value) {
            addCriterion("like_character >", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("like_character >=", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterLessThan(String value) {
            addCriterion("like_character <", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterLessThanOrEqualTo(String value) {
            addCriterion("like_character <=", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterLike(String value) {
            addCriterion("like_character like", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterNotLike(String value) {
            addCriterion("like_character not like", value, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterIn(List values) {
            addCriterion("like_character in", values, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterNotIn(List values) {
            addCriterion("like_character not in", values, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterBetween(String value1, String value2) {
            addCriterion("like_character between", value1, value2, "likeCharacter");
            return this;


        }

        public Criteria andLikeCharacterNotBetween(String value1, String value2) {
            addCriterion("like_character not between", value1, value2, "likeCharacter");
            return this;


        }

        public Criteria andLikeStarIsNull() {
            addCriterion("like_star is null");
            return this;


        }

        public Criteria andLikeStarIsNotNull() {
            addCriterion("like_star is not null");
            return this;


        }

        public Criteria andLikeStarEqualTo(String value) {
            addCriterion("like_star =", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarNotEqualTo(String value) {
            addCriterion("like_star <>", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarGreaterThan(String value) {
            addCriterion("like_star >", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarGreaterThanOrEqualTo(String value) {
            addCriterion("like_star >=", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarLessThan(String value) {
            addCriterion("like_star <", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarLessThanOrEqualTo(String value) {
            addCriterion("like_star <=", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarLike(String value) {
            addCriterion("like_star like", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarNotLike(String value) {
            addCriterion("like_star not like", value, "likeStar");
            return this;


        }

        public Criteria andLikeStarIn(List values) {
            addCriterion("like_star in", values, "likeStar");
            return this;


        }

        public Criteria andLikeStarNotIn(List values) {
            addCriterion("like_star not in", values, "likeStar");
            return this;


        }

        public Criteria andLikeStarBetween(String value1, String value2) {
            addCriterion("like_star between", value1, value2, "likeStar");
            return this;


        }

        public Criteria andLikeStarNotBetween(String value1, String value2) {
            addCriterion("like_star not between", value1, value2, "likeStar");
            return this;


        }

        public Criteria andLikeBrandIsNull() {
            addCriterion("like_brand is null");
            return this;


        }

        public Criteria andLikeBrandIsNotNull() {
            addCriterion("like_brand is not null");
            return this;


        }

        public Criteria andLikeBrandEqualTo(String value) {
            addCriterion("like_brand =", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandNotEqualTo(String value) {
            addCriterion("like_brand <>", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandGreaterThan(String value) {
            addCriterion("like_brand >", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandGreaterThanOrEqualTo(String value) {
            addCriterion("like_brand >=", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandLessThan(String value) {
            addCriterion("like_brand <", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandLessThanOrEqualTo(String value) {
            addCriterion("like_brand <=", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandLike(String value) {
            addCriterion("like_brand like", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandNotLike(String value) {
            addCriterion("like_brand not like", value, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandIn(List values) {
            addCriterion("like_brand in", values, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandNotIn(List values) {
            addCriterion("like_brand not in", values, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandBetween(String value1, String value2) {
            addCriterion("like_brand between", value1, value2, "likeBrand");
            return this;


        }

        public Criteria andLikeBrandNotBetween(String value1, String value2) {
            addCriterion("like_brand not between", value1, value2, "likeBrand");
            return this;


        }


    }


}
