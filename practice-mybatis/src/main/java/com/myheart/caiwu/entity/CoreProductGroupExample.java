package com.myheart.caiwu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoreProductGroupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public CoreProductGroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIsNull() {
            addCriterion("request_source is null");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIsNotNull() {
            addCriterion("request_source is not null");
            return (Criteria) this;
        }

        public Criteria andRequestSourceEqualTo(String value) {
            addCriterion("request_source =", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotEqualTo(String value) {
            addCriterion("request_source <>", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceGreaterThan(String value) {
            addCriterion("request_source >", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceGreaterThanOrEqualTo(String value) {
            addCriterion("request_source >=", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLessThan(String value) {
            addCriterion("request_source <", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLessThanOrEqualTo(String value) {
            addCriterion("request_source <=", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLike(String value) {
            addCriterion("request_source like", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotLike(String value) {
            addCriterion("request_source not like", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIn(List<String> values) {
            addCriterion("request_source in", values, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotIn(List<String> values) {
            addCriterion("request_source not in", values, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceBetween(String value1, String value2) {
            addCriterion("request_source between", value1, value2, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotBetween(String value1, String value2) {
            addCriterion("request_source not between", value1, value2, "requestSource");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andAssetLevelIsNull() {
            addCriterion("asset_level is null");
            return (Criteria) this;
        }

        public Criteria andAssetLevelIsNotNull() {
            addCriterion("asset_level is not null");
            return (Criteria) this;
        }

        public Criteria andAssetLevelEqualTo(String value) {
            addCriterion("asset_level =", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelNotEqualTo(String value) {
            addCriterion("asset_level <>", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelGreaterThan(String value) {
            addCriterion("asset_level >", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelGreaterThanOrEqualTo(String value) {
            addCriterion("asset_level >=", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelLessThan(String value) {
            addCriterion("asset_level <", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelLessThanOrEqualTo(String value) {
            addCriterion("asset_level <=", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelLike(String value) {
            addCriterion("asset_level like", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelNotLike(String value) {
            addCriterion("asset_level not like", value, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelIn(List<String> values) {
            addCriterion("asset_level in", values, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelNotIn(List<String> values) {
            addCriterion("asset_level not in", values, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelBetween(String value1, String value2) {
            addCriterion("asset_level between", value1, value2, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andAssetLevelNotBetween(String value1, String value2) {
            addCriterion("asset_level not between", value1, value2, "assetLevel");
            return (Criteria) this;
        }

        public Criteria andPaySourceIsNull() {
            addCriterion("pay_source is null");
            return (Criteria) this;
        }

        public Criteria andPaySourceIsNotNull() {
            addCriterion("pay_source is not null");
            return (Criteria) this;
        }

        public Criteria andPaySourceEqualTo(String value) {
            addCriterion("pay_source =", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotEqualTo(String value) {
            addCriterion("pay_source <>", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceGreaterThan(String value) {
            addCriterion("pay_source >", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceGreaterThanOrEqualTo(String value) {
            addCriterion("pay_source >=", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceLessThan(String value) {
            addCriterion("pay_source <", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceLessThanOrEqualTo(String value) {
            addCriterion("pay_source <=", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceLike(String value) {
            addCriterion("pay_source like", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotLike(String value) {
            addCriterion("pay_source not like", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceIn(List<String> values) {
            addCriterion("pay_source in", values, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotIn(List<String> values) {
            addCriterion("pay_source not in", values, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceBetween(String value1, String value2) {
            addCriterion("pay_source between", value1, value2, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotBetween(String value1, String value2) {
            addCriterion("pay_source not between", value1, value2, "paySource");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_product_group
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_product_group
     *
     * @mbggenerated
     */
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