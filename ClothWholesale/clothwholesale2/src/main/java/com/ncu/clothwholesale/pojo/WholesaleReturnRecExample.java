package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class WholesaleReturnRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WholesaleReturnRecExample() {
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

        public Criteria andReturnRecNumIsNull() {
            addCriterion("returnRecNum is null");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumIsNotNull() {
            addCriterion("returnRecNum is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumEqualTo(Long value) {
            addCriterion("returnRecNum =", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumNotEqualTo(Long value) {
            addCriterion("returnRecNum <>", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumGreaterThan(Long value) {
            addCriterion("returnRecNum >", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumGreaterThanOrEqualTo(Long value) {
            addCriterion("returnRecNum >=", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumLessThan(Long value) {
            addCriterion("returnRecNum <", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumLessThanOrEqualTo(Long value) {
            addCriterion("returnRecNum <=", value, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumIn(List<Long> values) {
            addCriterion("returnRecNum in", values, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumNotIn(List<Long> values) {
            addCriterion("returnRecNum not in", values, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumBetween(Long value1, Long value2) {
            addCriterion("returnRecNum between", value1, value2, "returnRecNum");
            return (Criteria) this;
        }

        public Criteria andReturnRecNumNotBetween(Long value1, Long value2) {
            addCriterion("returnRecNum not between", value1, value2, "returnRecNum");
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

        public Criteria andReturnNumIsNull() {
            addCriterion("returnNum is null");
            return (Criteria) this;
        }

        public Criteria andReturnNumIsNotNull() {
            addCriterion("returnNum is not null");
            return (Criteria) this;
        }

        public Criteria andReturnNumEqualTo(Integer value) {
            addCriterion("returnNum =", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotEqualTo(Integer value) {
            addCriterion("returnNum <>", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumGreaterThan(Integer value) {
            addCriterion("returnNum >", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("returnNum >=", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumLessThan(Integer value) {
            addCriterion("returnNum <", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumLessThanOrEqualTo(Integer value) {
            addCriterion("returnNum <=", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumIn(List<Integer> values) {
            addCriterion("returnNum in", values, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotIn(List<Integer> values) {
            addCriterion("returnNum not in", values, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumBetween(Integer value1, Integer value2) {
            addCriterion("returnNum between", value1, value2, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotBetween(Integer value1, Integer value2) {
            addCriterion("returnNum not between", value1, value2, "returnNum");
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

        public Criteria andProductStateIsNull() {
            addCriterion("productState is null");
            return (Criteria) this;
        }

        public Criteria andProductStateIsNotNull() {
            addCriterion("productState is not null");
            return (Criteria) this;
        }

        public Criteria andProductStateEqualTo(String value) {
            addCriterion("productState =", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotEqualTo(String value) {
            addCriterion("productState <>", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThan(String value) {
            addCriterion("productState >", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThanOrEqualTo(String value) {
            addCriterion("productState >=", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThan(String value) {
            addCriterion("productState <", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThanOrEqualTo(String value) {
            addCriterion("productState <=", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateLike(String value) {
            addCriterion("productState like", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotLike(String value) {
            addCriterion("productState not like", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateIn(List<String> values) {
            addCriterion("productState in", values, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotIn(List<String> values) {
            addCriterion("productState not in", values, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateBetween(String value1, String value2) {
            addCriterion("productState between", value1, value2, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotBetween(String value1, String value2) {
            addCriterion("productState not between", value1, value2, "productState");
            return (Criteria) this;
        }

        public Criteria andMoneystateIsNull() {
            addCriterion("moneystate is null");
            return (Criteria) this;
        }

        public Criteria andMoneystateIsNotNull() {
            addCriterion("moneystate is not null");
            return (Criteria) this;
        }

        public Criteria andMoneystateEqualTo(String value) {
            addCriterion("moneystate =", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateNotEqualTo(String value) {
            addCriterion("moneystate <>", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateGreaterThan(String value) {
            addCriterion("moneystate >", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateGreaterThanOrEqualTo(String value) {
            addCriterion("moneystate >=", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateLessThan(String value) {
            addCriterion("moneystate <", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateLessThanOrEqualTo(String value) {
            addCriterion("moneystate <=", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateLike(String value) {
            addCriterion("moneystate like", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateNotLike(String value) {
            addCriterion("moneystate not like", value, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateIn(List<String> values) {
            addCriterion("moneystate in", values, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateNotIn(List<String> values) {
            addCriterion("moneystate not in", values, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateBetween(String value1, String value2) {
            addCriterion("moneystate between", value1, value2, "moneystate");
            return (Criteria) this;
        }

        public Criteria andMoneystateNotBetween(String value1, String value2) {
            addCriterion("moneystate not between", value1, value2, "moneystate");
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