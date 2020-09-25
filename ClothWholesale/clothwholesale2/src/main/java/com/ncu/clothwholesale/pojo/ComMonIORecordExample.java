package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComMonIORecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComMonIORecordExample() {
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

        public Criteria andComIORecCodeIsNull() {
            addCriterion("comIORecCode is null");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeIsNotNull() {
            addCriterion("comIORecCode is not null");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeEqualTo(String value) {
            addCriterion("comIORecCode =", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeNotEqualTo(String value) {
            addCriterion("comIORecCode <>", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeGreaterThan(String value) {
            addCriterion("comIORecCode >", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("comIORecCode >=", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeLessThan(String value) {
            addCriterion("comIORecCode <", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeLessThanOrEqualTo(String value) {
            addCriterion("comIORecCode <=", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeLike(String value) {
            addCriterion("comIORecCode like", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeNotLike(String value) {
            addCriterion("comIORecCode not like", value, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeIn(List<String> values) {
            addCriterion("comIORecCode in", values, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeNotIn(List<String> values) {
            addCriterion("comIORecCode not in", values, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeBetween(String value1, String value2) {
            addCriterion("comIORecCode between", value1, value2, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andComIORecCodeNotBetween(String value1, String value2) {
            addCriterion("comIORecCode not between", value1, value2, "comIORecCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIsNull() {
            addCriterion("adminCode is null");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIsNotNull() {
            addCriterion("adminCode is not null");
            return (Criteria) this;
        }

        public Criteria andAdminCodeEqualTo(String value) {
            addCriterion("adminCode =", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotEqualTo(String value) {
            addCriterion("adminCode <>", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeGreaterThan(String value) {
            addCriterion("adminCode >", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeGreaterThanOrEqualTo(String value) {
            addCriterion("adminCode >=", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeLessThan(String value) {
            addCriterion("adminCode <", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeLessThanOrEqualTo(String value) {
            addCriterion("adminCode <=", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeLike(String value) {
            addCriterion("adminCode like", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotLike(String value) {
            addCriterion("adminCode not like", value, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeIn(List<String> values) {
            addCriterion("adminCode in", values, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotIn(List<String> values) {
            addCriterion("adminCode not in", values, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeBetween(String value1, String value2) {
            addCriterion("adminCode between", value1, value2, "adminCode");
            return (Criteria) this;
        }

        public Criteria andAdminCodeNotBetween(String value1, String value2) {
            addCriterion("adminCode not between", value1, value2, "adminCode");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andIOmarkIsNull() {
            addCriterion("IOmark is null");
            return (Criteria) this;
        }

        public Criteria andIOmarkIsNotNull() {
            addCriterion("IOmark is not null");
            return (Criteria) this;
        }

        public Criteria andIOmarkEqualTo(String value) {
            addCriterion("IOmark =", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkNotEqualTo(String value) {
            addCriterion("IOmark <>", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkGreaterThan(String value) {
            addCriterion("IOmark >", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkGreaterThanOrEqualTo(String value) {
            addCriterion("IOmark >=", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkLessThan(String value) {
            addCriterion("IOmark <", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkLessThanOrEqualTo(String value) {
            addCriterion("IOmark <=", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkLike(String value) {
            addCriterion("IOmark like", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkNotLike(String value) {
            addCriterion("IOmark not like", value, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkIn(List<String> values) {
            addCriterion("IOmark in", values, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkNotIn(List<String> values) {
            addCriterion("IOmark not in", values, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkBetween(String value1, String value2) {
            addCriterion("IOmark between", value1, value2, "IOmark");
            return (Criteria) this;
        }

        public Criteria andIOmarkNotBetween(String value1, String value2) {
            addCriterion("IOmark not between", value1, value2, "IOmark");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOrdCodeIsNull() {
            addCriterion("ordCode is null");
            return (Criteria) this;
        }

        public Criteria andOrdCodeIsNotNull() {
            addCriterion("ordCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdCodeEqualTo(String value) {
            addCriterion("ordCode =", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeNotEqualTo(String value) {
            addCriterion("ordCode <>", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeGreaterThan(String value) {
            addCriterion("ordCode >", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ordCode >=", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeLessThan(String value) {
            addCriterion("ordCode <", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeLessThanOrEqualTo(String value) {
            addCriterion("ordCode <=", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeLike(String value) {
            addCriterion("ordCode like", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeNotLike(String value) {
            addCriterion("ordCode not like", value, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeIn(List<String> values) {
            addCriterion("ordCode in", values, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeNotIn(List<String> values) {
            addCriterion("ordCode not in", values, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeBetween(String value1, String value2) {
            addCriterion("ordCode between", value1, value2, "ordCode");
            return (Criteria) this;
        }

        public Criteria andOrdCodeNotBetween(String value1, String value2) {
            addCriterion("ordCode not between", value1, value2, "ordCode");
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