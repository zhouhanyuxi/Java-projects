package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class WholesaleExchangeRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WholesaleExchangeRecExample() {
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

        public Criteria andExchangeRecNumIsNull() {
            addCriterion("exchangeRecNum is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumIsNotNull() {
            addCriterion("exchangeRecNum is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumEqualTo(Long value) {
            addCriterion("exchangeRecNum =", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumNotEqualTo(Long value) {
            addCriterion("exchangeRecNum <>", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumGreaterThan(Long value) {
            addCriterion("exchangeRecNum >", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumGreaterThanOrEqualTo(Long value) {
            addCriterion("exchangeRecNum >=", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumLessThan(Long value) {
            addCriterion("exchangeRecNum <", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumLessThanOrEqualTo(Long value) {
            addCriterion("exchangeRecNum <=", value, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumIn(List<Long> values) {
            addCriterion("exchangeRecNum in", values, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumNotIn(List<Long> values) {
            addCriterion("exchangeRecNum not in", values, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumBetween(Long value1, Long value2) {
            addCriterion("exchangeRecNum between", value1, value2, "exchangeRecNum");
            return (Criteria) this;
        }

        public Criteria andExchangeRecNumNotBetween(Long value1, Long value2) {
            addCriterion("exchangeRecNum not between", value1, value2, "exchangeRecNum");
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

        public Criteria andWholesaleItemCodeIsNull() {
            addCriterion("wholesaleItemCode is null");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeIsNotNull() {
            addCriterion("wholesaleItemCode is not null");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeEqualTo(String value) {
            addCriterion("wholesaleItemCode =", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeNotEqualTo(String value) {
            addCriterion("wholesaleItemCode <>", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeGreaterThan(String value) {
            addCriterion("wholesaleItemCode >", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wholesaleItemCode >=", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeLessThan(String value) {
            addCriterion("wholesaleItemCode <", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeLessThanOrEqualTo(String value) {
            addCriterion("wholesaleItemCode <=", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeLike(String value) {
            addCriterion("wholesaleItemCode like", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeNotLike(String value) {
            addCriterion("wholesaleItemCode not like", value, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeIn(List<String> values) {
            addCriterion("wholesaleItemCode in", values, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeNotIn(List<String> values) {
            addCriterion("wholesaleItemCode not in", values, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeBetween(String value1, String value2) {
            addCriterion("wholesaleItemCode between", value1, value2, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andWholesaleItemCodeNotBetween(String value1, String value2) {
            addCriterion("wholesaleItemCode not between", value1, value2, "wholesaleItemCode");
            return (Criteria) this;
        }

        public Criteria andExchangeNumIsNull() {
            addCriterion("exchangeNum is null");
            return (Criteria) this;
        }

        public Criteria andExchangeNumIsNotNull() {
            addCriterion("exchangeNum is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeNumEqualTo(Integer value) {
            addCriterion("exchangeNum =", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumNotEqualTo(Integer value) {
            addCriterion("exchangeNum <>", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumGreaterThan(Integer value) {
            addCriterion("exchangeNum >", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchangeNum >=", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumLessThan(Integer value) {
            addCriterion("exchangeNum <", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumLessThanOrEqualTo(Integer value) {
            addCriterion("exchangeNum <=", value, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumIn(List<Integer> values) {
            addCriterion("exchangeNum in", values, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumNotIn(List<Integer> values) {
            addCriterion("exchangeNum not in", values, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumBetween(Integer value1, Integer value2) {
            addCriterion("exchangeNum between", value1, value2, "exchangeNum");
            return (Criteria) this;
        }

        public Criteria andExchangeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("exchangeNum not between", value1, value2, "exchangeNum");
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

        public Criteria andBackShipCodeIsNull() {
            addCriterion("backShipCode is null");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeIsNotNull() {
            addCriterion("backShipCode is not null");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeEqualTo(String value) {
            addCriterion("backShipCode =", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeNotEqualTo(String value) {
            addCriterion("backShipCode <>", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeGreaterThan(String value) {
            addCriterion("backShipCode >", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("backShipCode >=", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeLessThan(String value) {
            addCriterion("backShipCode <", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeLessThanOrEqualTo(String value) {
            addCriterion("backShipCode <=", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeLike(String value) {
            addCriterion("backShipCode like", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeNotLike(String value) {
            addCriterion("backShipCode not like", value, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeIn(List<String> values) {
            addCriterion("backShipCode in", values, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeNotIn(List<String> values) {
            addCriterion("backShipCode not in", values, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeBetween(String value1, String value2) {
            addCriterion("backShipCode between", value1, value2, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andBackShipCodeNotBetween(String value1, String value2) {
            addCriterion("backShipCode not between", value1, value2, "backShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeIsNull() {
            addCriterion("resendShipCode is null");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeIsNotNull() {
            addCriterion("resendShipCode is not null");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeEqualTo(String value) {
            addCriterion("resendShipCode =", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeNotEqualTo(String value) {
            addCriterion("resendShipCode <>", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeGreaterThan(String value) {
            addCriterion("resendShipCode >", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resendShipCode >=", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeLessThan(String value) {
            addCriterion("resendShipCode <", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeLessThanOrEqualTo(String value) {
            addCriterion("resendShipCode <=", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeLike(String value) {
            addCriterion("resendShipCode like", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeNotLike(String value) {
            addCriterion("resendShipCode not like", value, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeIn(List<String> values) {
            addCriterion("resendShipCode in", values, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeNotIn(List<String> values) {
            addCriterion("resendShipCode not in", values, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeBetween(String value1, String value2) {
            addCriterion("resendShipCode between", value1, value2, "resendShipCode");
            return (Criteria) this;
        }

        public Criteria andResendShipCodeNotBetween(String value1, String value2) {
            addCriterion("resendShipCode not between", value1, value2, "resendShipCode");
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