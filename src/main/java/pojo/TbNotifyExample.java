package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbNotifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbNotifyExample() {
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

        public Criteria andNotifyidIsNull() {
            addCriterion("NotifyId is null");
            return (Criteria) this;
        }

        public Criteria andNotifyidIsNotNull() {
            addCriterion("NotifyId is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyidEqualTo(String value) {
            addCriterion("NotifyId =", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotEqualTo(String value) {
            addCriterion("NotifyId <>", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidGreaterThan(String value) {
            addCriterion("NotifyId >", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidGreaterThanOrEqualTo(String value) {
            addCriterion("NotifyId >=", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLessThan(String value) {
            addCriterion("NotifyId <", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLessThanOrEqualTo(String value) {
            addCriterion("NotifyId <=", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidLike(String value) {
            addCriterion("NotifyId like", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotLike(String value) {
            addCriterion("NotifyId not like", value, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidIn(List<String> values) {
            addCriterion("NotifyId in", values, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotIn(List<String> values) {
            addCriterion("NotifyId not in", values, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidBetween(String value1, String value2) {
            addCriterion("NotifyId between", value1, value2, "notifyid");
            return (Criteria) this;
        }

        public Criteria andNotifyidNotBetween(String value1, String value2) {
            addCriterion("NotifyId not between", value1, value2, "notifyid");
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

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIsNull() {
            addCriterion("NotifyTime is null");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIsNotNull() {
            addCriterion("NotifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andNotifytimeEqualTo(Date value) {
            addCriterion("NotifyTime =", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotEqualTo(Date value) {
            addCriterion("NotifyTime <>", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeGreaterThan(Date value) {
            addCriterion("NotifyTime >", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NotifyTime >=", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeLessThan(Date value) {
            addCriterion("NotifyTime <", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeLessThanOrEqualTo(Date value) {
            addCriterion("NotifyTime <=", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIn(List<Date> values) {
            addCriterion("NotifyTime in", values, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotIn(List<Date> values) {
            addCriterion("NotifyTime not in", values, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeBetween(Date value1, Date value2) {
            addCriterion("NotifyTime between", value1, value2, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotBetween(Date value1, Date value2) {
            addCriterion("NotifyTime not between", value1, value2, "notifytime");
            return (Criteria) this;
        }

        public Criteria andAdscriptionIsNull() {
            addCriterion("Adscription is null");
            return (Criteria) this;
        }

        public Criteria andAdscriptionIsNotNull() {
            addCriterion("Adscription is not null");
            return (Criteria) this;
        }

        public Criteria andAdscriptionEqualTo(String value) {
            addCriterion("Adscription =", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionNotEqualTo(String value) {
            addCriterion("Adscription <>", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionGreaterThan(String value) {
            addCriterion("Adscription >", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Adscription >=", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionLessThan(String value) {
            addCriterion("Adscription <", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionLessThanOrEqualTo(String value) {
            addCriterion("Adscription <=", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionLike(String value) {
            addCriterion("Adscription like", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionNotLike(String value) {
            addCriterion("Adscription not like", value, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionIn(List<String> values) {
            addCriterion("Adscription in", values, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionNotIn(List<String> values) {
            addCriterion("Adscription not in", values, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionBetween(String value1, String value2) {
            addCriterion("Adscription between", value1, value2, "adscription");
            return (Criteria) this;
        }

        public Criteria andAdscriptionNotBetween(String value1, String value2) {
            addCriterion("Adscription not between", value1, value2, "adscription");
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