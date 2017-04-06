package pojo;

import java.util.ArrayList;
import java.util.List;

public class TbDepartmentscheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDepartmentscheduleExample() {
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

        public Criteria andScheduleidIsNull() {
            addCriterion("ScheduleId is null");
            return (Criteria) this;
        }

        public Criteria andScheduleidIsNotNull() {
            addCriterion("ScheduleId is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleidEqualTo(String value) {
            addCriterion("ScheduleId =", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidNotEqualTo(String value) {
            addCriterion("ScheduleId <>", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidGreaterThan(String value) {
            addCriterion("ScheduleId >", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidGreaterThanOrEqualTo(String value) {
            addCriterion("ScheduleId >=", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidLessThan(String value) {
            addCriterion("ScheduleId <", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidLessThanOrEqualTo(String value) {
            addCriterion("ScheduleId <=", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidLike(String value) {
            addCriterion("ScheduleId like", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidNotLike(String value) {
            addCriterion("ScheduleId not like", value, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidIn(List<String> values) {
            addCriterion("ScheduleId in", values, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidNotIn(List<String> values) {
            addCriterion("ScheduleId not in", values, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidBetween(String value1, String value2) {
            addCriterion("ScheduleId between", value1, value2, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andScheduleidNotBetween(String value1, String value2) {
            addCriterion("ScheduleId not between", value1, value2, "scheduleid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("DepartmentId is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("DepartmentId is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(String value) {
            addCriterion("DepartmentId =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(String value) {
            addCriterion("DepartmentId <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(String value) {
            addCriterion("DepartmentId >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(String value) {
            addCriterion("DepartmentId >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(String value) {
            addCriterion("DepartmentId <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(String value) {
            addCriterion("DepartmentId <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLike(String value) {
            addCriterion("DepartmentId like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotLike(String value) {
            addCriterion("DepartmentId not like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<String> values) {
            addCriterion("DepartmentId in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<String> values) {
            addCriterion("DepartmentId not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(String value1, String value2) {
            addCriterion("DepartmentId between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(String value1, String value2) {
            addCriterion("DepartmentId not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNull() {
            addCriterion("EnterTime is null");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNotNull() {
            addCriterion("EnterTime is not null");
            return (Criteria) this;
        }

        public Criteria andEntertimeEqualTo(String value) {
            addCriterion("EnterTime =", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotEqualTo(String value) {
            addCriterion("EnterTime <>", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThan(String value) {
            addCriterion("EnterTime >", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThanOrEqualTo(String value) {
            addCriterion("EnterTime >=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThan(String value) {
            addCriterion("EnterTime <", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThanOrEqualTo(String value) {
            addCriterion("EnterTime <=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLike(String value) {
            addCriterion("EnterTime like", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotLike(String value) {
            addCriterion("EnterTime not like", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeIn(List<String> values) {
            addCriterion("EnterTime in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotIn(List<String> values) {
            addCriterion("EnterTime not in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeBetween(String value1, String value2) {
            addCriterion("EnterTime between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotBetween(String value1, String value2) {
            addCriterion("EnterTime not between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNull() {
            addCriterion("OutTime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("OutTime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(String value) {
            addCriterion("OutTime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(String value) {
            addCriterion("OutTime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(String value) {
            addCriterion("OutTime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(String value) {
            addCriterion("OutTime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(String value) {
            addCriterion("OutTime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(String value) {
            addCriterion("OutTime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLike(String value) {
            addCriterion("OutTime like", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotLike(String value) {
            addCriterion("OutTime not like", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<String> values) {
            addCriterion("OutTime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<String> values) {
            addCriterion("OutTime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(String value1, String value2) {
            addCriterion("OutTime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(String value1, String value2) {
            addCriterion("OutTime not between", value1, value2, "outtime");
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