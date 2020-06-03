package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class RouteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RouteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
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
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceIsNull() {
            addCriterion("routeIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceIsNotNull() {
            addCriterion("routeIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceEqualTo(String value) {
            addCriterion("routeIntroduce =", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceNotEqualTo(String value) {
            addCriterion("routeIntroduce <>", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceGreaterThan(String value) {
            addCriterion("routeIntroduce >", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("routeIntroduce >=", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceLessThan(String value) {
            addCriterion("routeIntroduce <", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceLessThanOrEqualTo(String value) {
            addCriterion("routeIntroduce <=", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceLike(String value) {
            addCriterion("routeIntroduce like", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceNotLike(String value) {
            addCriterion("routeIntroduce not like", value, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceIn(List<String> values) {
            addCriterion("routeIntroduce in", values, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceNotIn(List<String> values) {
            addCriterion("routeIntroduce not in", values, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceBetween(String value1, String value2) {
            addCriterion("routeIntroduce between", value1, value2, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRouteIntroduceNotBetween(String value1, String value2) {
            addCriterion("routeIntroduce not between", value1, value2, "routeIntroduce");
            return (Criteria) this;
        }

        public Criteria andRflagIsNull() {
            addCriterion("rflag is null");
            return (Criteria) this;
        }

        public Criteria andRflagIsNotNull() {
            addCriterion("rflag is not null");
            return (Criteria) this;
        }

        public Criteria andRflagEqualTo(String value) {
            addCriterion("rflag =", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagNotEqualTo(String value) {
            addCriterion("rflag <>", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagGreaterThan(String value) {
            addCriterion("rflag >", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagGreaterThanOrEqualTo(String value) {
            addCriterion("rflag >=", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagLessThan(String value) {
            addCriterion("rflag <", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagLessThanOrEqualTo(String value) {
            addCriterion("rflag <=", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagLike(String value) {
            addCriterion("rflag like", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagNotLike(String value) {
            addCriterion("rflag not like", value, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagIn(List<String> values) {
            addCriterion("rflag in", values, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagNotIn(List<String> values) {
            addCriterion("rflag not in", values, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagBetween(String value1, String value2) {
            addCriterion("rflag between", value1, value2, "rflag");
            return (Criteria) this;
        }

        public Criteria andRflagNotBetween(String value1, String value2) {
            addCriterion("rflag not between", value1, value2, "rflag");
            return (Criteria) this;
        }

        public Criteria andRdateIsNull() {
            addCriterion("rdate is null");
            return (Criteria) this;
        }

        public Criteria andRdateIsNotNull() {
            addCriterion("rdate is not null");
            return (Criteria) this;
        }

        public Criteria andRdateEqualTo(String value) {
            addCriterion("rdate =", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotEqualTo(String value) {
            addCriterion("rdate <>", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateGreaterThan(String value) {
            addCriterion("rdate >", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateGreaterThanOrEqualTo(String value) {
            addCriterion("rdate >=", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateLessThan(String value) {
            addCriterion("rdate <", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateLessThanOrEqualTo(String value) {
            addCriterion("rdate <=", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateLike(String value) {
            addCriterion("rdate like", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotLike(String value) {
            addCriterion("rdate not like", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateIn(List<String> values) {
            addCriterion("rdate in", values, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotIn(List<String> values) {
            addCriterion("rdate not in", values, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateBetween(String value1, String value2) {
            addCriterion("rdate between", value1, value2, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotBetween(String value1, String value2) {
            addCriterion("rdate not between", value1, value2, "rdate");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourIsNull() {
            addCriterion("isThemeTour is null");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourIsNotNull() {
            addCriterion("isThemeTour is not null");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourEqualTo(String value) {
            addCriterion("isThemeTour =", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourNotEqualTo(String value) {
            addCriterion("isThemeTour <>", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourGreaterThan(String value) {
            addCriterion("isThemeTour >", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourGreaterThanOrEqualTo(String value) {
            addCriterion("isThemeTour >=", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourLessThan(String value) {
            addCriterion("isThemeTour <", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourLessThanOrEqualTo(String value) {
            addCriterion("isThemeTour <=", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourLike(String value) {
            addCriterion("isThemeTour like", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourNotLike(String value) {
            addCriterion("isThemeTour not like", value, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourIn(List<String> values) {
            addCriterion("isThemeTour in", values, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourNotIn(List<String> values) {
            addCriterion("isThemeTour not in", values, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourBetween(String value1, String value2) {
            addCriterion("isThemeTour between", value1, value2, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andIsThemeTourNotBetween(String value1, String value2) {
            addCriterion("isThemeTour not between", value1, value2, "isThemeTour");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andRimageIsNull() {
            addCriterion("rimage is null");
            return (Criteria) this;
        }

        public Criteria andRimageIsNotNull() {
            addCriterion("rimage is not null");
            return (Criteria) this;
        }

        public Criteria andRimageEqualTo(String value) {
            addCriterion("rimage =", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageNotEqualTo(String value) {
            addCriterion("rimage <>", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageGreaterThan(String value) {
            addCriterion("rimage >", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageGreaterThanOrEqualTo(String value) {
            addCriterion("rimage >=", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageLessThan(String value) {
            addCriterion("rimage <", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageLessThanOrEqualTo(String value) {
            addCriterion("rimage <=", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageLike(String value) {
            addCriterion("rimage like", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageNotLike(String value) {
            addCriterion("rimage not like", value, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageIn(List<String> values) {
            addCriterion("rimage in", values, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageNotIn(List<String> values) {
            addCriterion("rimage not in", values, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageBetween(String value1, String value2) {
            addCriterion("rimage between", value1, value2, "rimage");
            return (Criteria) this;
        }

        public Criteria andRimageNotBetween(String value1, String value2) {
            addCriterion("rimage not between", value1, value2, "rimage");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("sourceId is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("sourceId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("sourceId =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("sourceId <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("sourceId >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("sourceId >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("sourceId <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("sourceId <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("sourceId like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("sourceId not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("sourceId in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("sourceId not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("sourceId between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("sourceId not between", value1, value2, "sourceId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}