package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehouseIORecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehouseIORecordExample() {
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

        public Criteria andWarehouseIORecCodeIsNull() {
            addCriterion("warehouseIORecCode is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeIsNotNull() {
            addCriterion("warehouseIORecCode is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeEqualTo(String value) {
            addCriterion("warehouseIORecCode =", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeNotEqualTo(String value) {
            addCriterion("warehouseIORecCode <>", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeGreaterThan(String value) {
            addCriterion("warehouseIORecCode >", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("warehouseIORecCode >=", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeLessThan(String value) {
            addCriterion("warehouseIORecCode <", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeLessThanOrEqualTo(String value) {
            addCriterion("warehouseIORecCode <=", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeLike(String value) {
            addCriterion("warehouseIORecCode like", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeNotLike(String value) {
            addCriterion("warehouseIORecCode not like", value, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeIn(List<String> values) {
            addCriterion("warehouseIORecCode in", values, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeNotIn(List<String> values) {
            addCriterion("warehouseIORecCode not in", values, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeBetween(String value1, String value2) {
            addCriterion("warehouseIORecCode between", value1, value2, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseIORecCodeNotBetween(String value1, String value2) {
            addCriterion("warehouseIORecCode not between", value1, value2, "warehouseIORecCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIsNull() {
            addCriterion("warehouseCode is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIsNotNull() {
            addCriterion("warehouseCode is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeEqualTo(String value) {
            addCriterion("warehouseCode =", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotEqualTo(String value) {
            addCriterion("warehouseCode <>", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeGreaterThan(String value) {
            addCriterion("warehouseCode >", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("warehouseCode >=", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLessThan(String value) {
            addCriterion("warehouseCode <", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLessThanOrEqualTo(String value) {
            addCriterion("warehouseCode <=", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeLike(String value) {
            addCriterion("warehouseCode like", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotLike(String value) {
            addCriterion("warehouseCode not like", value, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeIn(List<String> values) {
            addCriterion("warehouseCode in", values, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotIn(List<String> values) {
            addCriterion("warehouseCode not in", values, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeBetween(String value1, String value2) {
            addCriterion("warehouseCode between", value1, value2, "warehouseCode");
            return (Criteria) this;
        }

        public Criteria andWarehouseCodeNotBetween(String value1, String value2) {
            addCriterion("warehouseCode not between", value1, value2, "warehouseCode");
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

        public Criteria andNumberChangeIsNull() {
            addCriterion("numberChange is null");
            return (Criteria) this;
        }

        public Criteria andNumberChangeIsNotNull() {
            addCriterion("numberChange is not null");
            return (Criteria) this;
        }

        public Criteria andNumberChangeEqualTo(Integer value) {
            addCriterion("numberChange =", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeNotEqualTo(Integer value) {
            addCriterion("numberChange <>", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeGreaterThan(Integer value) {
            addCriterion("numberChange >", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberChange >=", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeLessThan(Integer value) {
            addCriterion("numberChange <", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeLessThanOrEqualTo(Integer value) {
            addCriterion("numberChange <=", value, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeIn(List<Integer> values) {
            addCriterion("numberChange in", values, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeNotIn(List<Integer> values) {
            addCriterion("numberChange not in", values, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeBetween(Integer value1, Integer value2) {
            addCriterion("numberChange between", value1, value2, "numberChange");
            return (Criteria) this;
        }

        public Criteria andNumberChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("numberChange not between", value1, value2, "numberChange");
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

        public Criteria andIOMarkIsNull() {
            addCriterion("IOMark is null");
            return (Criteria) this;
        }

        public Criteria andIOMarkIsNotNull() {
            addCriterion("IOMark is not null");
            return (Criteria) this;
        }

        public Criteria andIOMarkEqualTo(String value) {
            addCriterion("IOMark =", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkNotEqualTo(String value) {
            addCriterion("IOMark <>", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkGreaterThan(String value) {
            addCriterion("IOMark >", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkGreaterThanOrEqualTo(String value) {
            addCriterion("IOMark >=", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkLessThan(String value) {
            addCriterion("IOMark <", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkLessThanOrEqualTo(String value) {
            addCriterion("IOMark <=", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkLike(String value) {
            addCriterion("IOMark like", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkNotLike(String value) {
            addCriterion("IOMark not like", value, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkIn(List<String> values) {
            addCriterion("IOMark in", values, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkNotIn(List<String> values) {
            addCriterion("IOMark not in", values, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkBetween(String value1, String value2) {
            addCriterion("IOMark between", value1, value2, "IOMark");
            return (Criteria) this;
        }

        public Criteria andIOMarkNotBetween(String value1, String value2) {
            addCriterion("IOMark not between", value1, value2, "IOMark");
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