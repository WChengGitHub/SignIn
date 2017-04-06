package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbActivityattendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbActivityattendanceExample() {
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

        public Criteria andActivityattendanceidIsNull() {
            addCriterion("ActivityAttendanceId is null");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidIsNotNull() {
            addCriterion("ActivityAttendanceId is not null");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidEqualTo(String value) {
            addCriterion("ActivityAttendanceId =", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidNotEqualTo(String value) {
            addCriterion("ActivityAttendanceId <>", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidGreaterThan(String value) {
            addCriterion("ActivityAttendanceId >", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityAttendanceId >=", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidLessThan(String value) {
            addCriterion("ActivityAttendanceId <", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidLessThanOrEqualTo(String value) {
            addCriterion("ActivityAttendanceId <=", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidLike(String value) {
            addCriterion("ActivityAttendanceId like", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidNotLike(String value) {
            addCriterion("ActivityAttendanceId not like", value, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidIn(List<String> values) {
            addCriterion("ActivityAttendanceId in", values, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidNotIn(List<String> values) {
            addCriterion("ActivityAttendanceId not in", values, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidBetween(String value1, String value2) {
            addCriterion("ActivityAttendanceId between", value1, value2, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andActivityattendanceidNotBetween(String value1, String value2) {
            addCriterion("ActivityAttendanceId not between", value1, value2, "activityattendanceid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNull() {
            addCriterion("EmployeeId is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNotNull() {
            addCriterion("EmployeeId is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidEqualTo(String value) {
            addCriterion("EmployeeId =", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotEqualTo(String value) {
            addCriterion("EmployeeId <>", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThan(String value) {
            addCriterion("EmployeeId >", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThanOrEqualTo(String value) {
            addCriterion("EmployeeId >=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThan(String value) {
            addCriterion("EmployeeId <", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThanOrEqualTo(String value) {
            addCriterion("EmployeeId <=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLike(String value) {
            addCriterion("EmployeeId like", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotLike(String value) {
            addCriterion("EmployeeId not like", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIn(List<String> values) {
            addCriterion("EmployeeId in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotIn(List<String> values) {
            addCriterion("EmployeeId not in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidBetween(String value1, String value2) {
            addCriterion("EmployeeId between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotBetween(String value1, String value2) {
            addCriterion("EmployeeId not between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNull() {
            addCriterion("ActivityId is null");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("ActivityId is not null");
            return (Criteria) this;
        }

        public Criteria andActivityidEqualTo(String value) {
            addCriterion("ActivityId =", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotEqualTo(String value) {
            addCriterion("ActivityId <>", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThan(String value) {
            addCriterion("ActivityId >", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityId >=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThan(String value) {
            addCriterion("ActivityId <", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThanOrEqualTo(String value) {
            addCriterion("ActivityId <=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLike(String value) {
            addCriterion("ActivityId like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotLike(String value) {
            addCriterion("ActivityId not like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidIn(List<String> values) {
            addCriterion("ActivityId in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotIn(List<String> values) {
            addCriterion("ActivityId not in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidBetween(String value1, String value2) {
            addCriterion("ActivityId between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotBetween(String value1, String value2) {
            addCriterion("ActivityId not between", value1, value2, "activityid");
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

        public Criteria andEntertimeEqualTo(Date value) {
            addCriterion("EnterTime =", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotEqualTo(Date value) {
            addCriterion("EnterTime <>", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThan(Date value) {
            addCriterion("EnterTime >", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EnterTime >=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThan(Date value) {
            addCriterion("EnterTime <", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThanOrEqualTo(Date value) {
            addCriterion("EnterTime <=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeIn(List<Date> values) {
            addCriterion("EnterTime in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotIn(List<Date> values) {
            addCriterion("EnterTime not in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeBetween(Date value1, Date value2) {
            addCriterion("EnterTime between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotBetween(Date value1, Date value2) {
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

        public Criteria andOuttimeEqualTo(Date value) {
            addCriterion("OutTime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            addCriterion("OutTime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            addCriterion("OutTime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OutTime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            addCriterion("OutTime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            addCriterion("OutTime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            addCriterion("OutTime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            addCriterion("OutTime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            addCriterion("OutTime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            addCriterion("OutTime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
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