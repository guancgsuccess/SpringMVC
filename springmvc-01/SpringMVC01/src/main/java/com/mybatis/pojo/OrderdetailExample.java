package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIsNull() {
            addCriterion("ORDERS_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIsNotNull() {
            addCriterion("ORDERS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdEqualTo(Long value) {
            addCriterion("ORDERS_ID =", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotEqualTo(Long value) {
            addCriterion("ORDERS_ID <>", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThan(Long value) {
            addCriterion("ORDERS_ID >", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERS_ID >=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThan(Long value) {
            addCriterion("ORDERS_ID <", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDERS_ID <=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIn(List<Long> values) {
            addCriterion("ORDERS_ID in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotIn(List<Long> values) {
            addCriterion("ORDERS_ID not in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdBetween(Long value1, Long value2) {
            addCriterion("ORDERS_ID between", value1, value2, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDERS_ID not between", value1, value2, "ordersId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNull() {
            addCriterion("ITEMS_ID is null");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNotNull() {
            addCriterion("ITEMS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andItemsIdEqualTo(Long value) {
            addCriterion("ITEMS_ID =", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotEqualTo(Long value) {
            addCriterion("ITEMS_ID <>", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThan(Long value) {
            addCriterion("ITEMS_ID >", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ITEMS_ID >=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThan(Long value) {
            addCriterion("ITEMS_ID <", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThanOrEqualTo(Long value) {
            addCriterion("ITEMS_ID <=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIn(List<Long> values) {
            addCriterion("ITEMS_ID in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotIn(List<Long> values) {
            addCriterion("ITEMS_ID not in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdBetween(Long value1, Long value2) {
            addCriterion("ITEMS_ID between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotBetween(Long value1, Long value2) {
            addCriterion("ITEMS_ID not between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsNumIsNull() {
            addCriterion("ITEMS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andItemsNumIsNotNull() {
            addCriterion("ITEMS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andItemsNumEqualTo(Long value) {
            addCriterion("ITEMS_NUM =", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotEqualTo(Long value) {
            addCriterion("ITEMS_NUM <>", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumGreaterThan(Long value) {
            addCriterion("ITEMS_NUM >", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumGreaterThanOrEqualTo(Long value) {
            addCriterion("ITEMS_NUM >=", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumLessThan(Long value) {
            addCriterion("ITEMS_NUM <", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumLessThanOrEqualTo(Long value) {
            addCriterion("ITEMS_NUM <=", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumIn(List<Long> values) {
            addCriterion("ITEMS_NUM in", values, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotIn(List<Long> values) {
            addCriterion("ITEMS_NUM not in", values, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumBetween(Long value1, Long value2) {
            addCriterion("ITEMS_NUM between", value1, value2, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotBetween(Long value1, Long value2) {
            addCriterion("ITEMS_NUM not between", value1, value2, "itemsNum");
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