package com.caicongyang.springcloudapp.dao.mysql.entities;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * student
 */
public class TStudentExample {
    // 顺序排序
    public static final String ORDERBYDIRECTION_ASC = "asc";

    // 倒序排序
    public static final String ORDERBYDIRECTION_DESC = "desc";

    public static final String FIELD_ID = "Id";

    public static final String FIELD_NAME = "Name";

    public static final String FIELD_AGE = "Age";

    /**
     * student
     */
    protected Integer offset;

    /**
     * student
     */
    protected Integer size;

    /**
     * student
     */
    protected String orderByClause;

    /**
     * student
     */
    protected boolean distinct;

    /**
     * student
     */
    protected List<Criteria> oredCriteria;

    /**
     * student
     */
    public TStudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * student
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * student
     */
    public void setOrderByClause(OrderBy orderBy) {
        this.orderByClause = orderBy.toString();
    }

    /**
     * student
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * student
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * student
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * student
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * student
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * student
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * student
     */
    public Integer getSize() {
        return size;
    }

    /**
     * student
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * student
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * student
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * student
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * student
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * student
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * student
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

        protected void addCriterion(String condition, Object value, String property, boolean isBinary) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value, isBinary));
        }

        protected void addCriterion(String condition, Object value, String property) {
            addCriterion(condition, value, property, false);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property, boolean isBinary) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2, isBinary));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            addCriterion(condition, value1, value2, property, false);
        }

        /**
         */
        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeIsNull() {
            addCriterion("Age is null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeIsNotNull() {
            addCriterion("Age is not null");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("Age =", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("Age <>", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("Age >", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Age >=", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeLessThan(Integer value) {
            addCriterion("Age <", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("Age <=", value, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("Age in", values, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("Age not in", values, "age", false);
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("Age between", value1, value2, "age");
            return (Criteria) this;
        }

        /**
         */
        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("Age not between", value1, value2, "age");
            return (Criteria) this;
        }
    }

    /**
     *student
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * student
     */
    public static class Criterion {
        private boolean isBinary;

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public boolean isIsBinary() {
            return isBinary;
        }

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
            this.isBinary = false;
        }

        protected Criterion(String condition, Object value, String typeHandler, boolean isBinary) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
            this.isBinary = isBinary;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this(condition, value, typeHandler, false);
        }

        protected Criterion(String condition, Object value, boolean isBinary) {
            this(condition, value, null, isBinary);
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null, false);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler, boolean isBinary) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
            this.isBinary = isBinary;
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this(condition, value, secondValue, typeHandler, false);
        }

        protected Criterion(String condition, Object value, Object secondValue, boolean isBinary) {
            this(condition, value, secondValue, null, isBinary);
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null, false);
        }
    }

    /**
     *student
     */
    public static class OrderBy {
        private List<OrderByPair> orderByPairs;

        public OrderBy() {
            super();
            this.orderByPairs = new ArrayList<OrderByPair>();
        }

        public boolean isValid() {
            return orderByPairs.size() > 0;
        }

        public OrderBy clear() {
            orderByPairs.clear();
            return this;
        }

        public OrderBy addOrderBy(String fieldName) {
            return this.addOrderBy(fieldName, ORDERBYDIRECTION_ASC);
        }

        public OrderBy addOrderBy(String fieldName, String direction) {
            this.removeByFieldName(fieldName);//不能重复添加排序条件
            OrderByPair orderByPair = new OrderByPair(fieldName, direction);
            this.orderByPairs.add(orderByPair);
            return this;
        }

        private void removeByFieldName(String fieldName) {
            for (OrderByPair item : orderByPairs) {
                    if (StringUtils.equalsIgnoreCase(item.getFieldName(), fieldName)) {
                            orderByPairs.remove(item);
                            break;
                         }
                }
            }

        /**
         * 当没有任何排序条件时，直接返回null
         * 否则返回排序条件，多个条件时以,号分割
         */
        @Override
        public String toString() {
            if (!this.isValid()) {
                    return null;
            }
            StringBuilder sb = new StringBuilder();
            for (OrderByPair item : orderByPairs) {
                    sb.append(item.toString());
                    sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);//删除最后一个字符
            return sb.toString();
        }
    }

    /**
     *student
     */
    static class OrderByPair {
        private String fieldName;

        private String direction;

        public OrderByPair(String fieldName, String direction) {
            super();
            this.fieldName = fieldName;
            this.direction = direction;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public String getDirection() {
            return this.direction;
        }

        /**
         * 返回单个排序条件字符串
         */
        @Override
        public String toString() {
            return fieldName + " " + direction;
        }
    }
}