package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class PurchaseItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseItemExample() {
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

        public Criteria andPurchaseItemCodeIsNull() {
            addCriterion("purchaseItemCode is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeIsNotNull() {
            addCriterion("purchaseItemCode is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeEqualTo(String value) {
            addCriterion("purchaseItemCode =", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeNotEqualTo(String value) {
            addCriterion("purchaseItemCode <>", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeGreaterThan(String value) {
            addCriterion("purchaseItemCode >", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("purchaseItemCode >=", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeLessThan(String value) {
            addCriterion("purchaseItemCode <", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeLessThanOrEqualTo(String value) {
            addCriterion("purchaseItemCode <=", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeLike(String value) {
            addCriterion("purchaseItemCode like", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeNotLike(String value) {
            addCriterion("purchaseItemCode not like", value, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeIn(List<String> values) {
            addCriterion("purchaseItemCode in", values, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeNotIn(List<String> values) {
            addCriterion("purchaseItemCode not in", values, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeBetween(String value1, String value2) {
            addCriterion("purchaseItemCode between", value1, value2, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseItemCodeNotBetween(String value1, String value2) {
            addCriterion("purchaseItemCode not between", value1, value2, "purchaseItemCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeIsNull() {
            addCriterion("purchaseOrdCode is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeIsNotNull() {
            addCriterion("purchaseOrdCode is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeEqualTo(String value) {
            addCriterion("purchaseOrdCode =", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeNotEqualTo(String value) {
            addCriterion("purchaseOrdCode <>", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeGreaterThan(String value) {
            addCriterion("purchaseOrdCode >", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("purchaseOrdCode >=", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeLessThan(String value) {
            addCriterion("purchaseOrdCode <", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeLessThanOrEqualTo(String value) {
            addCriterion("purchaseOrdCode <=", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeLike(String value) {
            addCriterion("purchaseOrdCode like", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeNotLike(String value) {
            addCriterion("purchaseOrdCode not like", value, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeIn(List<String> values) {
            addCriterion("purchaseOrdCode in", values, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeNotIn(List<String> values) {
            addCriterion("purchaseOrdCode not in", values, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeBetween(String value1, String value2) {
            addCriterion("purchaseOrdCode between", value1, value2, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrdCodeNotBetween(String value1, String value2) {
            addCriterion("purchaseOrdCode not between", value1, value2, "purchaseOrdCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("modelCode is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("modelCode is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("modelCode =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("modelCode <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("modelCode >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("modelCode >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("modelCode <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("modelCode <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("modelCode like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("modelCode not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("modelCode in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("modelCode not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("modelCode between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("modelCode not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("totalNum =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("totalNum <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("totalNum >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalNum >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("totalNum <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("totalNum <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("totalNum in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("totalNum not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("totalNum between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("totalNum not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceIsNull() {
            addCriterion("orignalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceIsNotNull() {
            addCriterion("orignalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceEqualTo(Float value) {
            addCriterion("orignalPrice =", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceNotEqualTo(Float value) {
            addCriterion("orignalPrice <>", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceGreaterThan(Float value) {
            addCriterion("orignalPrice >", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("orignalPrice >=", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceLessThan(Float value) {
            addCriterion("orignalPrice <", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceLessThanOrEqualTo(Float value) {
            addCriterion("orignalPrice <=", value, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceIn(List<Float> values) {
            addCriterion("orignalPrice in", values, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceNotIn(List<Float> values) {
            addCriterion("orignalPrice not in", values, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceBetween(Float value1, Float value2) {
            addCriterion("orignalPrice between", value1, value2, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andOrignalPriceNotBetween(Float value1, Float value2) {
            addCriterion("orignalPrice not between", value1, value2, "orignalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("totalPrice =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("totalPrice <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("totalPrice >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPrice >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("totalPrice <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("totalPrice <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("totalPrice in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("totalPrice not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("totalPrice between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("totalPrice not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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