package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WholesaleOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WholesaleOrderExample() {
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

        public Criteria andWholesaleOrdCodeIsNull() {
            addCriterion("wholesaleOrdCode is null");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeIsNotNull() {
            addCriterion("wholesaleOrdCode is not null");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeEqualTo(String value) {
            addCriterion("wholesaleOrdCode =", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeNotEqualTo(String value) {
            addCriterion("wholesaleOrdCode <>", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeGreaterThan(String value) {
            addCriterion("wholesaleOrdCode >", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wholesaleOrdCode >=", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeLessThan(String value) {
            addCriterion("wholesaleOrdCode <", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeLessThanOrEqualTo(String value) {
            addCriterion("wholesaleOrdCode <=", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeLike(String value) {
            addCriterion("wholesaleOrdCode like", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeNotLike(String value) {
            addCriterion("wholesaleOrdCode not like", value, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeIn(List<String> values) {
            addCriterion("wholesaleOrdCode in", values, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeNotIn(List<String> values) {
            addCriterion("wholesaleOrdCode not in", values, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeBetween(String value1, String value2) {
            addCriterion("wholesaleOrdCode between", value1, value2, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleOrdCodeNotBetween(String value1, String value2) {
            addCriterion("wholesaleOrdCode not between", value1, value2, "wholesaleOrdCode");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumIsNull() {
            addCriterion("shippingAddrNum is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumIsNotNull() {
            addCriterion("shippingAddrNum is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumEqualTo(Long value) {
            addCriterion("shippingAddrNum =", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumNotEqualTo(Long value) {
            addCriterion("shippingAddrNum <>", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumGreaterThan(Long value) {
            addCriterion("shippingAddrNum >", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumGreaterThanOrEqualTo(Long value) {
            addCriterion("shippingAddrNum >=", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumLessThan(Long value) {
            addCriterion("shippingAddrNum <", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumLessThanOrEqualTo(Long value) {
            addCriterion("shippingAddrNum <=", value, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumIn(List<Long> values) {
            addCriterion("shippingAddrNum in", values, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumNotIn(List<Long> values) {
            addCriterion("shippingAddrNum not in", values, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumBetween(Long value1, Long value2) {
            addCriterion("shippingAddrNum between", value1, value2, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andShippingAddrNumNotBetween(Long value1, Long value2) {
            addCriterion("shippingAddrNum not between", value1, value2, "shippingAddrNum");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("orderState is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("orderState is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("orderState =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("orderState <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("orderState >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("orderState >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("orderState <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("orderState <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("orderState like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("orderState not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("orderState in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("orderState not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("orderState between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("orderState not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andShippingCodeIsNull() {
            addCriterion("shippingCode is null");
            return (Criteria) this;
        }

        public Criteria andShippingCodeIsNotNull() {
            addCriterion("shippingCode is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCodeEqualTo(String value) {
            addCriterion("shippingCode =", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeNotEqualTo(String value) {
            addCriterion("shippingCode <>", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeGreaterThan(String value) {
            addCriterion("shippingCode >", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shippingCode >=", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeLessThan(String value) {
            addCriterion("shippingCode <", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeLessThanOrEqualTo(String value) {
            addCriterion("shippingCode <=", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeLike(String value) {
            addCriterion("shippingCode like", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeNotLike(String value) {
            addCriterion("shippingCode not like", value, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeIn(List<String> values) {
            addCriterion("shippingCode in", values, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeNotIn(List<String> values) {
            addCriterion("shippingCode not in", values, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeBetween(String value1, String value2) {
            addCriterion("shippingCode between", value1, value2, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andShippingCodeNotBetween(String value1, String value2) {
            addCriterion("shippingCode not between", value1, value2, "shippingCode");
            return (Criteria) this;
        }

        public Criteria andSumPriceIsNull() {
            addCriterion("sumPrice is null");
            return (Criteria) this;
        }

        public Criteria andSumPriceIsNotNull() {
            addCriterion("sumPrice is not null");
            return (Criteria) this;
        }

        public Criteria andSumPriceEqualTo(Double value) {
            addCriterion("sumPrice =", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceNotEqualTo(Double value) {
            addCriterion("sumPrice <>", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceGreaterThan(Double value) {
            addCriterion("sumPrice >", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("sumPrice >=", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceLessThan(Double value) {
            addCriterion("sumPrice <", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceLessThanOrEqualTo(Double value) {
            addCriterion("sumPrice <=", value, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceIn(List<Double> values) {
            addCriterion("sumPrice in", values, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceNotIn(List<Double> values) {
            addCriterion("sumPrice not in", values, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceBetween(Double value1, Double value2) {
            addCriterion("sumPrice between", value1, value2, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andSumPriceNotBetween(Double value1, Double value2) {
            addCriterion("sumPrice not between", value1, value2, "sumPrice");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andOrderRateIsNull() {
            addCriterion("orderRate is null");
            return (Criteria) this;
        }

        public Criteria andOrderRateIsNotNull() {
            addCriterion("orderRate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRateEqualTo(String value) {
            addCriterion("orderRate =", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateNotEqualTo(String value) {
            addCriterion("orderRate <>", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateGreaterThan(String value) {
            addCriterion("orderRate >", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateGreaterThanOrEqualTo(String value) {
            addCriterion("orderRate >=", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateLessThan(String value) {
            addCriterion("orderRate <", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateLessThanOrEqualTo(String value) {
            addCriterion("orderRate <=", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateLike(String value) {
            addCriterion("orderRate like", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateNotLike(String value) {
            addCriterion("orderRate not like", value, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateIn(List<String> values) {
            addCriterion("orderRate in", values, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateNotIn(List<String> values) {
            addCriterion("orderRate not in", values, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateBetween(String value1, String value2) {
            addCriterion("orderRate between", value1, value2, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderRateNotBetween(String value1, String value2) {
            addCriterion("orderRate not between", value1, value2, "orderRate");
            return (Criteria) this;
        }

        public Criteria andOrderCommentIsNull() {
            addCriterion("orderComment is null");
            return (Criteria) this;
        }

        public Criteria andOrderCommentIsNotNull() {
            addCriterion("orderComment is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCommentEqualTo(String value) {
            addCriterion("orderComment =", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotEqualTo(String value) {
            addCriterion("orderComment <>", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentGreaterThan(String value) {
            addCriterion("orderComment >", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentGreaterThanOrEqualTo(String value) {
            addCriterion("orderComment >=", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLessThan(String value) {
            addCriterion("orderComment <", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLessThanOrEqualTo(String value) {
            addCriterion("orderComment <=", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLike(String value) {
            addCriterion("orderComment like", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotLike(String value) {
            addCriterion("orderComment not like", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentIn(List<String> values) {
            addCriterion("orderComment in", values, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotIn(List<String> values) {
            addCriterion("orderComment not in", values, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentBetween(String value1, String value2) {
            addCriterion("orderComment between", value1, value2, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotBetween(String value1, String value2) {
            addCriterion("orderComment not between", value1, value2, "orderComment");
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