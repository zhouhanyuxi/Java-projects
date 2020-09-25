package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class InventoryContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryContentExample() {
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

        public Criteria andInventoryContIndIsNull() {
            addCriterion("inventoryContInd is null");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndIsNotNull() {
            addCriterion("inventoryContInd is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndEqualTo(Long value) {
            addCriterion("inventoryContInd =", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndNotEqualTo(Long value) {
            addCriterion("inventoryContInd <>", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndGreaterThan(Long value) {
            addCriterion("inventoryContInd >", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndGreaterThanOrEqualTo(Long value) {
            addCriterion("inventoryContInd >=", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndLessThan(Long value) {
            addCriterion("inventoryContInd <", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndLessThanOrEqualTo(Long value) {
            addCriterion("inventoryContInd <=", value, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndIn(List<Long> values) {
            addCriterion("inventoryContInd in", values, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndNotIn(List<Long> values) {
            addCriterion("inventoryContInd not in", values, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndBetween(Long value1, Long value2) {
            addCriterion("inventoryContInd between", value1, value2, "inventoryContInd");
            return (Criteria) this;
        }

        public Criteria andInventoryContIndNotBetween(Long value1, Long value2) {
            addCriterion("inventoryContInd not between", value1, value2, "inventoryContInd");
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

        public Criteria andContentSumIsNull() {
            addCriterion("ContentSum is null");
            return (Criteria) this;
        }

        public Criteria andContentSumIsNotNull() {
            addCriterion("ContentSum is not null");
            return (Criteria) this;
        }

        public Criteria andContentSumEqualTo(Integer value) {
            addCriterion("ContentSum =", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumNotEqualTo(Integer value) {
            addCriterion("ContentSum <>", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumGreaterThan(Integer value) {
            addCriterion("ContentSum >", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ContentSum >=", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumLessThan(Integer value) {
            addCriterion("ContentSum <", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumLessThanOrEqualTo(Integer value) {
            addCriterion("ContentSum <=", value, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumIn(List<Integer> values) {
            addCriterion("ContentSum in", values, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumNotIn(List<Integer> values) {
            addCriterion("ContentSum not in", values, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumBetween(Integer value1, Integer value2) {
            addCriterion("ContentSum between", value1, value2, "contentSum");
            return (Criteria) this;
        }

        public Criteria andContentSumNotBetween(Integer value1, Integer value2) {
            addCriterion("ContentSum not between", value1, value2, "contentSum");
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