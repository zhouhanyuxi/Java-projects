package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CusMonIORecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CusMonIORecExample() {
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

        public Criteria andCusMonIORecCodeIsNull() {
            addCriterion("cusMonIORecCode is null");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeIsNotNull() {
            addCriterion("cusMonIORecCode is not null");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeEqualTo(String value) {
            addCriterion("cusMonIORecCode =", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeNotEqualTo(String value) {
            addCriterion("cusMonIORecCode <>", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeGreaterThan(String value) {
            addCriterion("cusMonIORecCode >", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cusMonIORecCode >=", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeLessThan(String value) {
            addCriterion("cusMonIORecCode <", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeLessThanOrEqualTo(String value) {
            addCriterion("cusMonIORecCode <=", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeLike(String value) {
            addCriterion("cusMonIORecCode like", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeNotLike(String value) {
            addCriterion("cusMonIORecCode not like", value, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeIn(List<String> values) {
            addCriterion("cusMonIORecCode in", values, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeNotIn(List<String> values) {
            addCriterion("cusMonIORecCode not in", values, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeBetween(String value1, String value2) {
            addCriterion("cusMonIORecCode between", value1, value2, "cusMonIORecCode");
            return (Criteria) this;
        }

        public Criteria andCusMonIORecCodeNotBetween(String value1, String value2) {
            addCriterion("cusMonIORecCode not between", value1, value2, "cusMonIORecCode");
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

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
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