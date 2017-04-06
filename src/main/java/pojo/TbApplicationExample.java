package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbApplicationExample() {
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

        public Criteria andApplicationidIsNull() {
            addCriterion("ApplicationId is null");
            return (Criteria) this;
        }

        public Criteria andApplicationidIsNotNull() {
            addCriterion("ApplicationId is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationidEqualTo(String value) {
            addCriterion("ApplicationId =", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotEqualTo(String value) {
            addCriterion("ApplicationId <>", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThan(String value) {
            addCriterion("ApplicationId >", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThanOrEqualTo(String value) {
            addCriterion("ApplicationId >=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThan(String value) {
            addCriterion("ApplicationId <", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThanOrEqualTo(String value) {
            addCriterion("ApplicationId <=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLike(String value) {
            addCriterion("ApplicationId like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotLike(String value) {
            addCriterion("ApplicationId not like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidIn(List<String> values) {
            addCriterion("ApplicationId in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotIn(List<String> values) {
            addCriterion("ApplicationId not in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidBetween(String value1, String value2) {
            addCriterion("ApplicationId between", value1, value2, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotBetween(String value1, String value2) {
            addCriterion("ApplicationId not between", value1, value2, "applicationid");
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

        public Criteria andDailyattendanceidIsNull() {
            addCriterion("DailyAttendanceId is null");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidIsNotNull() {
            addCriterion("DailyAttendanceId is not null");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidEqualTo(String value) {
            addCriterion("DailyAttendanceId =", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidNotEqualTo(String value) {
            addCriterion("DailyAttendanceId <>", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidGreaterThan(String value) {
            addCriterion("DailyAttendanceId >", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidGreaterThanOrEqualTo(String value) {
            addCriterion("DailyAttendanceId >=", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidLessThan(String value) {
            addCriterion("DailyAttendanceId <", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidLessThanOrEqualTo(String value) {
            addCriterion("DailyAttendanceId <=", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidLike(String value) {
            addCriterion("DailyAttendanceId like", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidNotLike(String value) {
            addCriterion("DailyAttendanceId not like", value, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidIn(List<String> values) {
            addCriterion("DailyAttendanceId in", values, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidNotIn(List<String> values) {
            addCriterion("DailyAttendanceId not in", values, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidBetween(String value1, String value2) {
            addCriterion("DailyAttendanceId between", value1, value2, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andDailyattendanceidNotBetween(String value1, String value2) {
            addCriterion("DailyAttendanceId not between", value1, value2, "dailyattendanceid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNull() {
            addCriterion("ApplicationTime is null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNotNull() {
            addCriterion("ApplicationTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeEqualTo(Date value) {
            addCriterion("ApplicationTime =", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotEqualTo(Date value) {
            addCriterion("ApplicationTime <>", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThan(Date value) {
            addCriterion("ApplicationTime >", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime >=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThan(Date value) {
            addCriterion("ApplicationTime <", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime <=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIn(List<Date> values) {
            addCriterion("ApplicationTime in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotIn(List<Date> values) {
            addCriterion("ApplicationTime not in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime not between", value1, value2, "applicationtime");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
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