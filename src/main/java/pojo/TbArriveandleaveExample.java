package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbArriveandleaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbArriveandleaveExample() {
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

        public Criteria andArriveandleaveidIsNull() {
            addCriterion("ArriveAndLeaveId is null");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidIsNotNull() {
            addCriterion("ArriveAndLeaveId is not null");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidEqualTo(String value) {
            addCriterion("ArriveAndLeaveId =", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidNotEqualTo(String value) {
            addCriterion("ArriveAndLeaveId <>", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidGreaterThan(String value) {
            addCriterion("ArriveAndLeaveId >", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidGreaterThanOrEqualTo(String value) {
            addCriterion("ArriveAndLeaveId >=", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidLessThan(String value) {
            addCriterion("ArriveAndLeaveId <", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidLessThanOrEqualTo(String value) {
            addCriterion("ArriveAndLeaveId <=", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidLike(String value) {
            addCriterion("ArriveAndLeaveId like", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidNotLike(String value) {
            addCriterion("ArriveAndLeaveId not like", value, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidIn(List<String> values) {
            addCriterion("ArriveAndLeaveId in", values, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidNotIn(List<String> values) {
            addCriterion("ArriveAndLeaveId not in", values, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidBetween(String value1, String value2) {
            addCriterion("ArriveAndLeaveId between", value1, value2, "arriveandleaveid");
            return (Criteria) this;
        }

        public Criteria andArriveandleaveidNotBetween(String value1, String value2) {
            addCriterion("ArriveAndLeaveId not between", value1, value2, "arriveandleaveid");
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

        public Criteria andArrivetimeIsNull() {
            addCriterion("ArriveTime is null");
            return (Criteria) this;
        }

        public Criteria andArrivetimeIsNotNull() {
            addCriterion("ArriveTime is not null");
            return (Criteria) this;
        }

        public Criteria andArrivetimeEqualTo(Date value) {
            addCriterion("ArriveTime =", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotEqualTo(Date value) {
            addCriterion("ArriveTime <>", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeGreaterThan(Date value) {
            addCriterion("ArriveTime >", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ArriveTime >=", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeLessThan(Date value) {
            addCriterion("ArriveTime <", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeLessThanOrEqualTo(Date value) {
            addCriterion("ArriveTime <=", value, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeIn(List<Date> values) {
            addCriterion("ArriveTime in", values, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotIn(List<Date> values) {
            addCriterion("ArriveTime not in", values, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeBetween(Date value1, Date value2) {
            addCriterion("ArriveTime between", value1, value2, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andArrivetimeNotBetween(Date value1, Date value2) {
            addCriterion("ArriveTime not between", value1, value2, "arrivetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNull() {
            addCriterion("LeaveTime is null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNotNull() {
            addCriterion("LeaveTime is not null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeEqualTo(Date value) {
            addCriterion("LeaveTime =", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotEqualTo(Date value) {
            addCriterion("LeaveTime <>", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThan(Date value) {
            addCriterion("LeaveTime >", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LeaveTime >=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThan(Date value) {
            addCriterion("LeaveTime <", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThanOrEqualTo(Date value) {
            addCriterion("LeaveTime <=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIn(List<Date> values) {
            addCriterion("LeaveTime in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotIn(List<Date> values) {
            addCriterion("LeaveTime not in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeBetween(Date value1, Date value2) {
            addCriterion("LeaveTime between", value1, value2, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotBetween(Date value1, Date value2) {
            addCriterion("LeaveTime not between", value1, value2, "leavetime");
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