package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class WholesaleCancelRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WholesaleCancelRecExample() {
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

        public Criteria andCancelRecNumIsNull() {
            addCriterion("cancelRecNum is null");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumIsNotNull() {
            addCriterion("cancelRecNum is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumEqualTo(Long value) {
            addCriterion("cancelRecNum =", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumNotEqualTo(Long value) {
            addCriterion("cancelRecNum <>", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumGreaterThan(Long value) {
            addCriterion("cancelRecNum >", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumGreaterThanOrEqualTo(Long value) {
            addCriterion("cancelRecNum >=", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumLessThan(Long value) {
            addCriterion("cancelRecNum <", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumLessThanOrEqualTo(Long value) {
            addCriterion("cancelRecNum <=", value, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumIn(List<Long> values) {
            addCriterion("cancelRecNum in", values, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumNotIn(List<Long> values) {
            addCriterion("cancelRecNum not in", values, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumBetween(Long value1, Long value2) {
            addCriterion("cancelRecNum between", value1, value2, "cancelRecNum");
            return (Criteria) this;
        }

        public Criteria andCancelRecNumNotBetween(Long value1, Long value2) {
            addCriterion("cancelRecNum not between", value1, value2, "cancelRecNum");
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

        public Criteria andRecordStateIsNull() {
            addCriterion("recordState is null");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNotNull() {
            addCriterion("recordState is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStateEqualTo(String value) {
            addCriterion("recordState =", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotEqualTo(String value) {
            addCriterion("recordState <>", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThan(String value) {
            addCriterion("recordState >", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThanOrEqualTo(String value) {
            addCriterion("recordState >=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThan(String value) {
            addCriterion("recordState <", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThanOrEqualTo(String value) {
            addCriterion("recordState <=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLike(String value) {
            addCriterion("recordState like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotLike(String value) {
            addCriterion("recordState not like", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateIn(List<String> values) {
            addCriterion("recordState in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotIn(List<String> values) {
            addCriterion("recordState not in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateBetween(String value1, String value2) {
            addCriterion("recordState between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotBetween(String value1, String value2) {
            addCriterion("recordState not between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateIsNull() {
            addCriterion("moneyState is null");
            return (Criteria) this;
        }

        public Criteria andMoneyStateIsNotNull() {
            addCriterion("moneyState is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyStateEqualTo(String value) {
            addCriterion("moneyState =", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateNotEqualTo(String value) {
            addCriterion("moneyState <>", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateGreaterThan(String value) {
            addCriterion("moneyState >", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateGreaterThanOrEqualTo(String value) {
            addCriterion("moneyState >=", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateLessThan(String value) {
            addCriterion("moneyState <", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateLessThanOrEqualTo(String value) {
            addCriterion("moneyState <=", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateLike(String value) {
            addCriterion("moneyState like", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateNotLike(String value) {
            addCriterion("moneyState not like", value, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateIn(List<String> values) {
            addCriterion("moneyState in", values, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateNotIn(List<String> values) {
            addCriterion("moneyState not in", values, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateBetween(String value1, String value2) {
            addCriterion("moneyState between", value1, value2, "moneyState");
            return (Criteria) this;
        }

        public Criteria andMoneyStateNotBetween(String value1, String value2) {
            addCriterion("moneyState not between", value1, value2, "moneyState");
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