package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderMonRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderMonRecExample() {
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

        public Criteria andOrdMonRecCodeIsNull() {
            addCriterion("OrdMonRecCode is null");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeIsNotNull() {
            addCriterion("OrdMonRecCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeEqualTo(String value) {
            addCriterion("OrdMonRecCode =", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeNotEqualTo(String value) {
            addCriterion("OrdMonRecCode <>", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeGreaterThan(String value) {
            addCriterion("OrdMonRecCode >", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OrdMonRecCode >=", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeLessThan(String value) {
            addCriterion("OrdMonRecCode <", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeLessThanOrEqualTo(String value) {
            addCriterion("OrdMonRecCode <=", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeLike(String value) {
            addCriterion("OrdMonRecCode like", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeNotLike(String value) {
            addCriterion("OrdMonRecCode not like", value, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeIn(List<String> values) {
            addCriterion("OrdMonRecCode in", values, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeNotIn(List<String> values) {
            addCriterion("OrdMonRecCode not in", values, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeBetween(String value1, String value2) {
            addCriterion("OrdMonRecCode between", value1, value2, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andOrdMonRecCodeNotBetween(String value1, String value2) {
            addCriterion("OrdMonRecCode not between", value1, value2, "ordMonRecCode");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("orderNum =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("orderNum <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("orderNum >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNum >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("orderNum <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("orderNum <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("orderNum in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("orderNum not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("orderNum between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNum not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIsNull() {
            addCriterion("moneyNum is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIsNotNull() {
            addCriterion("moneyNum is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumEqualTo(Double value) {
            addCriterion("moneyNum =", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotEqualTo(Double value) {
            addCriterion("moneyNum <>", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumGreaterThan(Double value) {
            addCriterion("moneyNum >", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumGreaterThanOrEqualTo(Double value) {
            addCriterion("moneyNum >=", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumLessThan(Double value) {
            addCriterion("moneyNum <", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumLessThanOrEqualTo(Double value) {
            addCriterion("moneyNum <=", value, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumIn(List<Double> values) {
            addCriterion("moneyNum in", values, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotIn(List<Double> values) {
            addCriterion("moneyNum not in", values, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumBetween(Double value1, Double value2) {
            addCriterion("moneyNum between", value1, value2, "moneyNum");
            return (Criteria) this;
        }

        public Criteria andMoneyNumNotBetween(Double value1, Double value2) {
            addCriterion("moneyNum not between", value1, value2, "moneyNum");
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