package com.ncu.clothwholesale.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductCodeIsNull() {
            addCriterion("productCode is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("productCode is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("productCode =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("productCode <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("productCode >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("productCode >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("productCode <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("productCode <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("productCode like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("productCode not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("productCode in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("productCode not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("productCode between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("productCode not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("productName =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("productName >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("productName <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("productName like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("productName not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("productName in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNull() {
            addCriterion("originalName is null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNotNull() {
            addCriterion("originalName is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameEqualTo(String value) {
            addCriterion("originalName =", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotEqualTo(String value) {
            addCriterion("originalName <>", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThan(String value) {
            addCriterion("originalName >", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("originalName >=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThan(String value) {
            addCriterion("originalName <", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("originalName <=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLike(String value) {
            addCriterion("originalName like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotLike(String value) {
            addCriterion("originalName not like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIn(List<String> values) {
            addCriterion("originalName in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotIn(List<String> values) {
            addCriterion("originalName not in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameBetween(String value1, String value2) {
            addCriterion("originalName between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotBetween(String value1, String value2) {
            addCriterion("originalName not between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("originalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("originalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(Double value) {
            addCriterion("originalPrice =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(Double value) {
            addCriterion("originalPrice <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(Double value) {
            addCriterion("originalPrice >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("originalPrice >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(Double value) {
            addCriterion("originalPrice <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(Double value) {
            addCriterion("originalPrice <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<Double> values) {
            addCriterion("originalPrice in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<Double> values) {
            addCriterion("originalPrice not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(Double value1, Double value2) {
            addCriterion("originalPrice between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(Double value1, Double value2) {
            addCriterion("originalPrice not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andTypeTotalIsNull() {
            addCriterion("typeTotal is null");
            return (Criteria) this;
        }

        public Criteria andTypeTotalIsNotNull() {
            addCriterion("typeTotal is not null");
            return (Criteria) this;
        }

        public Criteria andTypeTotalEqualTo(Short value) {
            addCriterion("typeTotal =", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalNotEqualTo(Short value) {
            addCriterion("typeTotal <>", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalGreaterThan(Short value) {
            addCriterion("typeTotal >", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("typeTotal >=", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalLessThan(Short value) {
            addCriterion("typeTotal <", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalLessThanOrEqualTo(Short value) {
            addCriterion("typeTotal <=", value, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalIn(List<Short> values) {
            addCriterion("typeTotal in", values, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalNotIn(List<Short> values) {
            addCriterion("typeTotal not in", values, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalBetween(Short value1, Short value2) {
            addCriterion("typeTotal between", value1, value2, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andTypeTotalNotBetween(Short value1, Short value2) {
            addCriterion("typeTotal not between", value1, value2, "typeTotal");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNull() {
            addCriterion("thickness is null");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNotNull() {
            addCriterion("thickness is not null");
            return (Criteria) this;
        }

        public Criteria andThicknessEqualTo(String value) {
            addCriterion("thickness =", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotEqualTo(String value) {
            addCriterion("thickness <>", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThan(String value) {
            addCriterion("thickness >", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThanOrEqualTo(String value) {
            addCriterion("thickness >=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThan(String value) {
            addCriterion("thickness <", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThanOrEqualTo(String value) {
            addCriterion("thickness <=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLike(String value) {
            addCriterion("thickness like", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotLike(String value) {
            addCriterion("thickness not like", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessIn(List<String> values) {
            addCriterion("thickness in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotIn(List<String> values) {
            addCriterion("thickness not in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessBetween(String value1, String value2) {
            addCriterion("thickness between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotBetween(String value1, String value2) {
            addCriterion("thickness not between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andCompositionIsNull() {
            addCriterion("composition is null");
            return (Criteria) this;
        }

        public Criteria andCompositionIsNotNull() {
            addCriterion("composition is not null");
            return (Criteria) this;
        }

        public Criteria andCompositionEqualTo(String value) {
            addCriterion("composition =", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotEqualTo(String value) {
            addCriterion("composition <>", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionGreaterThan(String value) {
            addCriterion("composition >", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionGreaterThanOrEqualTo(String value) {
            addCriterion("composition >=", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLessThan(String value) {
            addCriterion("composition <", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLessThanOrEqualTo(String value) {
            addCriterion("composition <=", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLike(String value) {
            addCriterion("composition like", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotLike(String value) {
            addCriterion("composition not like", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionIn(List<String> values) {
            addCriterion("composition in", values, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotIn(List<String> values) {
            addCriterion("composition not in", values, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionBetween(String value1, String value2) {
            addCriterion("composition between", value1, value2, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotBetween(String value1, String value2) {
            addCriterion("composition not between", value1, value2, "composition");
            return (Criteria) this;
        }

        public Criteria andIngredientIsNull() {
            addCriterion("ingredient is null");
            return (Criteria) this;
        }

        public Criteria andIngredientIsNotNull() {
            addCriterion("ingredient is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientEqualTo(String value) {
            addCriterion("ingredient =", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientNotEqualTo(String value) {
            addCriterion("ingredient <>", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientGreaterThan(String value) {
            addCriterion("ingredient >", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientGreaterThanOrEqualTo(String value) {
            addCriterion("ingredient >=", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientLessThan(String value) {
            addCriterion("ingredient <", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientLessThanOrEqualTo(String value) {
            addCriterion("ingredient <=", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientLike(String value) {
            addCriterion("ingredient like", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientNotLike(String value) {
            addCriterion("ingredient not like", value, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientIn(List<String> values) {
            addCriterion("ingredient in", values, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientNotIn(List<String> values) {
            addCriterion("ingredient not in", values, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientBetween(String value1, String value2) {
            addCriterion("ingredient between", value1, value2, "ingredient");
            return (Criteria) this;
        }

        public Criteria andIngredientNotBetween(String value1, String value2) {
            addCriterion("ingredient not between", value1, value2, "ingredient");
            return (Criteria) this;
        }

        public Criteria andDensityIsNull() {
            addCriterion("density is null");
            return (Criteria) this;
        }

        public Criteria andDensityIsNotNull() {
            addCriterion("density is not null");
            return (Criteria) this;
        }

        public Criteria andDensityEqualTo(String value) {
            addCriterion("density =", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotEqualTo(String value) {
            addCriterion("density <>", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThan(String value) {
            addCriterion("density >", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThanOrEqualTo(String value) {
            addCriterion("density >=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThan(String value) {
            addCriterion("density <", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThanOrEqualTo(String value) {
            addCriterion("density <=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLike(String value) {
            addCriterion("density like", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotLike(String value) {
            addCriterion("density not like", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityIn(List<String> values) {
            addCriterion("density in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotIn(List<String> values) {
            addCriterion("density not in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityBetween(String value1, String value2) {
            addCriterion("density between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotBetween(String value1, String value2) {
            addCriterion("density not between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andTextileProcessIsNull() {
            addCriterion("textileProcess is null");
            return (Criteria) this;
        }

        public Criteria andTextileProcessIsNotNull() {
            addCriterion("textileProcess is not null");
            return (Criteria) this;
        }

        public Criteria andTextileProcessEqualTo(String value) {
            addCriterion("textileProcess =", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessNotEqualTo(String value) {
            addCriterion("textileProcess <>", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessGreaterThan(String value) {
            addCriterion("textileProcess >", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessGreaterThanOrEqualTo(String value) {
            addCriterion("textileProcess >=", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessLessThan(String value) {
            addCriterion("textileProcess <", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessLessThanOrEqualTo(String value) {
            addCriterion("textileProcess <=", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessLike(String value) {
            addCriterion("textileProcess like", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessNotLike(String value) {
            addCriterion("textileProcess not like", value, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessIn(List<String> values) {
            addCriterion("textileProcess in", values, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessNotIn(List<String> values) {
            addCriterion("textileProcess not in", values, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessBetween(String value1, String value2) {
            addCriterion("textileProcess between", value1, value2, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andTextileProcessNotBetween(String value1, String value2) {
            addCriterion("textileProcess not between", value1, value2, "textileProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessIsNull() {
            addCriterion("dyeProcess is null");
            return (Criteria) this;
        }

        public Criteria andDyeProcessIsNotNull() {
            addCriterion("dyeProcess is not null");
            return (Criteria) this;
        }

        public Criteria andDyeProcessEqualTo(String value) {
            addCriterion("dyeProcess =", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessNotEqualTo(String value) {
            addCriterion("dyeProcess <>", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessGreaterThan(String value) {
            addCriterion("dyeProcess >", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessGreaterThanOrEqualTo(String value) {
            addCriterion("dyeProcess >=", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessLessThan(String value) {
            addCriterion("dyeProcess <", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessLessThanOrEqualTo(String value) {
            addCriterion("dyeProcess <=", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessLike(String value) {
            addCriterion("dyeProcess like", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessNotLike(String value) {
            addCriterion("dyeProcess not like", value, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessIn(List<String> values) {
            addCriterion("dyeProcess in", values, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessNotIn(List<String> values) {
            addCriterion("dyeProcess not in", values, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessBetween(String value1, String value2) {
            addCriterion("dyeProcess between", value1, value2, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andDyeProcessNotBetween(String value1, String value2) {
            addCriterion("dyeProcess not between", value1, value2, "dyeProcess");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationIsNull() {
            addCriterion("fiberOrganization is null");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationIsNotNull() {
            addCriterion("fiberOrganization is not null");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationEqualTo(String value) {
            addCriterion("fiberOrganization =", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationNotEqualTo(String value) {
            addCriterion("fiberOrganization <>", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationGreaterThan(String value) {
            addCriterion("fiberOrganization >", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("fiberOrganization >=", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationLessThan(String value) {
            addCriterion("fiberOrganization <", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationLessThanOrEqualTo(String value) {
            addCriterion("fiberOrganization <=", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationLike(String value) {
            addCriterion("fiberOrganization like", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationNotLike(String value) {
            addCriterion("fiberOrganization not like", value, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationIn(List<String> values) {
            addCriterion("fiberOrganization in", values, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationNotIn(List<String> values) {
            addCriterion("fiberOrganization not in", values, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationBetween(String value1, String value2) {
            addCriterion("fiberOrganization between", value1, value2, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andFiberOrganizationNotBetween(String value1, String value2) {
            addCriterion("fiberOrganization not between", value1, value2, "fiberOrganization");
            return (Criteria) this;
        }

        public Criteria andPatternIsNull() {
            addCriterion("pattern is null");
            return (Criteria) this;
        }

        public Criteria andPatternIsNotNull() {
            addCriterion("pattern is not null");
            return (Criteria) this;
        }

        public Criteria andPatternEqualTo(String value) {
            addCriterion("pattern =", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotEqualTo(String value) {
            addCriterion("pattern <>", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThan(String value) {
            addCriterion("pattern >", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThanOrEqualTo(String value) {
            addCriterion("pattern >=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThan(String value) {
            addCriterion("pattern <", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThanOrEqualTo(String value) {
            addCriterion("pattern <=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLike(String value) {
            addCriterion("pattern like", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotLike(String value) {
            addCriterion("pattern not like", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternIn(List<String> values) {
            addCriterion("pattern in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotIn(List<String> values) {
            addCriterion("pattern not in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternBetween(String value1, String value2) {
            addCriterion("pattern between", value1, value2, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotBetween(String value1, String value2) {
            addCriterion("pattern not between", value1, value2, "pattern");
            return (Criteria) this;
        }

        public Criteria andMainUseIsNull() {
            addCriterion("mainUse is null");
            return (Criteria) this;
        }

        public Criteria andMainUseIsNotNull() {
            addCriterion("mainUse is not null");
            return (Criteria) this;
        }

        public Criteria andMainUseEqualTo(String value) {
            addCriterion("mainUse =", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseNotEqualTo(String value) {
            addCriterion("mainUse <>", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseGreaterThan(String value) {
            addCriterion("mainUse >", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseGreaterThanOrEqualTo(String value) {
            addCriterion("mainUse >=", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseLessThan(String value) {
            addCriterion("mainUse <", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseLessThanOrEqualTo(String value) {
            addCriterion("mainUse <=", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseLike(String value) {
            addCriterion("mainUse like", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseNotLike(String value) {
            addCriterion("mainUse not like", value, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseIn(List<String> values) {
            addCriterion("mainUse in", values, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseNotIn(List<String> values) {
            addCriterion("mainUse not in", values, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseBetween(String value1, String value2) {
            addCriterion("mainUse between", value1, value2, "mainUse");
            return (Criteria) this;
        }

        public Criteria andMainUseNotBetween(String value1, String value2) {
            addCriterion("mainUse not between", value1, value2, "mainUse");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNull() {
            addCriterion("season is null");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNotNull() {
            addCriterion("season is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEqualTo(String value) {
            addCriterion("season =", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotEqualTo(String value) {
            addCriterion("season <>", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThan(String value) {
            addCriterion("season >", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("season >=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThan(String value) {
            addCriterion("season <", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThanOrEqualTo(String value) {
            addCriterion("season <=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLike(String value) {
            addCriterion("season like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotLike(String value) {
            addCriterion("season not like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonIn(List<String> values) {
            addCriterion("season in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotIn(List<String> values) {
            addCriterion("season not in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonBetween(String value1, String value2) {
            addCriterion("season between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotBetween(String value1, String value2) {
            addCriterion("season not between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNull() {
            addCriterion("shippingFee is null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shippingFee is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeEqualTo(Float value) {
            addCriterion("shippingFee =", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotEqualTo(Float value) {
            addCriterion("shippingFee <>", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThan(Float value) {
            addCriterion("shippingFee >", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("shippingFee >=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThan(Float value) {
            addCriterion("shippingFee <", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThanOrEqualTo(Float value) {
            addCriterion("shippingFee <=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIn(List<Float> values) {
            addCriterion("shippingFee in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotIn(List<Float> values) {
            addCriterion("shippingFee not in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeBetween(Float value1, Float value2) {
            addCriterion("shippingFee between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotBetween(Float value1, Float value2) {
            addCriterion("shippingFee not between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
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