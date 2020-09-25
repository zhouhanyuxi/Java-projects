package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseOrderExample() {
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

        public Criteria andSupplierCodeIsNull() {
            addCriterion("supplierCode is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNotNull() {
            addCriterion("supplierCode is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeEqualTo(String value) {
            addCriterion("supplierCode =", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotEqualTo(String value) {
            addCriterion("supplierCode <>", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThan(String value) {
            addCriterion("supplierCode >", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("supplierCode >=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThan(String value) {
            addCriterion("supplierCode <", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThanOrEqualTo(String value) {
            addCriterion("supplierCode <=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLike(String value) {
            addCriterion("supplierCode like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotLike(String value) {
            addCriterion("supplierCode not like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIn(List<String> values) {
            addCriterion("supplierCode in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotIn(List<String> values) {
            addCriterion("supplierCode not in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeBetween(String value1, String value2) {
            addCriterion("supplierCode between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotBetween(String value1, String value2) {
            addCriterion("supplierCode not between", value1, value2, "supplierCode");
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

        public Criteria andPaidPriceIsNull() {
            addCriterion("paidPrice is null");
            return (Criteria) this;
        }

        public Criteria andPaidPriceIsNotNull() {
            addCriterion("paidPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPaidPriceEqualTo(Double value) {
            addCriterion("paidPrice =", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceNotEqualTo(Double value) {
            addCriterion("paidPrice <>", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceGreaterThan(Double value) {
            addCriterion("paidPrice >", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("paidPrice >=", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceLessThan(Double value) {
            addCriterion("paidPrice <", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceLessThanOrEqualTo(Double value) {
            addCriterion("paidPrice <=", value, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceIn(List<Double> values) {
            addCriterion("paidPrice in", values, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceNotIn(List<Double> values) {
            addCriterion("paidPrice not in", values, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceBetween(Double value1, Double value2) {
            addCriterion("paidPrice between", value1, value2, "paidPrice");
            return (Criteria) this;
        }

        public Criteria andPaidPriceNotBetween(Double value1, Double value2) {
            addCriterion("paidPrice not between", value1, value2, "paidPrice");
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