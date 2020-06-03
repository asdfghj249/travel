package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Route_imgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Route_imgExample() {
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

        public Criteria andRgidIsNull() {
            addCriterion("rgid is null");
            return (Criteria) this;
        }

        public Criteria andRgidIsNotNull() {
            addCriterion("rgid is not null");
            return (Criteria) this;
        }

        public Criteria andRgidEqualTo(Integer value) {
            addCriterion("rgid =", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidNotEqualTo(Integer value) {
            addCriterion("rgid <>", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidGreaterThan(Integer value) {
            addCriterion("rgid >", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rgid >=", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidLessThan(Integer value) {
            addCriterion("rgid <", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidLessThanOrEqualTo(Integer value) {
            addCriterion("rgid <=", value, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidIn(List<Integer> values) {
            addCriterion("rgid in", values, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidNotIn(List<Integer> values) {
            addCriterion("rgid not in", values, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidBetween(Integer value1, Integer value2) {
            addCriterion("rgid between", value1, value2, "rgid");
            return (Criteria) this;
        }

        public Criteria andRgidNotBetween(Integer value1, Integer value2) {
            addCriterion("rgid not between", value1, value2, "rgid");
            return (Criteria) this;
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

        public Criteria andBigPicIsNull() {
            addCriterion("bigPic is null");
            return (Criteria) this;
        }

        public Criteria andBigPicIsNotNull() {
            addCriterion("bigPic is not null");
            return (Criteria) this;
        }

        public Criteria andBigPicEqualTo(String value) {
            addCriterion("bigPic =", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotEqualTo(String value) {
            addCriterion("bigPic <>", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicGreaterThan(String value) {
            addCriterion("bigPic >", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicGreaterThanOrEqualTo(String value) {
            addCriterion("bigPic >=", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLessThan(String value) {
            addCriterion("bigPic <", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLessThanOrEqualTo(String value) {
            addCriterion("bigPic <=", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicLike(String value) {
            addCriterion("bigPic like", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotLike(String value) {
            addCriterion("bigPic not like", value, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicIn(List<String> values) {
            addCriterion("bigPic in", values, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotIn(List<String> values) {
            addCriterion("bigPic not in", values, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicBetween(String value1, String value2) {
            addCriterion("bigPic between", value1, value2, "bigPic");
            return (Criteria) this;
        }

        public Criteria andBigPicNotBetween(String value1, String value2) {
            addCriterion("bigPic not between", value1, value2, "bigPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicIsNull() {
            addCriterion("smallPic is null");
            return (Criteria) this;
        }

        public Criteria andSmallPicIsNotNull() {
            addCriterion("smallPic is not null");
            return (Criteria) this;
        }

        public Criteria andSmallPicEqualTo(String value) {
            addCriterion("smallPic =", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotEqualTo(String value) {
            addCriterion("smallPic <>", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicGreaterThan(String value) {
            addCriterion("smallPic >", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicGreaterThanOrEqualTo(String value) {
            addCriterion("smallPic >=", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLessThan(String value) {
            addCriterion("smallPic <", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLessThanOrEqualTo(String value) {
            addCriterion("smallPic <=", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLike(String value) {
            addCriterion("smallPic like", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotLike(String value) {
            addCriterion("smallPic not like", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicIn(List<String> values) {
            addCriterion("smallPic in", values, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotIn(List<String> values) {
            addCriterion("smallPic not in", values, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicBetween(String value1, String value2) {
            addCriterion("smallPic between", value1, value2, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotBetween(String value1, String value2) {
            addCriterion("smallPic not between", value1, value2, "smallPic");
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