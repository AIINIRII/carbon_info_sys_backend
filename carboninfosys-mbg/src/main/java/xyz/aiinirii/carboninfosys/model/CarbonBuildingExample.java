package xyz.aiinirii.carboninfosys.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarbonBuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarbonBuildingExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Long value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Long value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Long value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Long value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Long value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Long> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Long> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Long value1, Long value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Long value1, Long value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
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

        public Criteria andElLightIsNull() {
            addCriterion("el_light is null");
            return (Criteria) this;
        }

        public Criteria andElLightIsNotNull() {
            addCriterion("el_light is not null");
            return (Criteria) this;
        }

        public Criteria andElLightEqualTo(BigDecimal value) {
            addCriterion("el_light =", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightNotEqualTo(BigDecimal value) {
            addCriterion("el_light <>", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightGreaterThan(BigDecimal value) {
            addCriterion("el_light >", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_light >=", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightLessThan(BigDecimal value) {
            addCriterion("el_light <", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_light <=", value, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightIn(List<BigDecimal> values) {
            addCriterion("el_light in", values, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightNotIn(List<BigDecimal> values) {
            addCriterion("el_light not in", values, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_light between", value1, value2, "elLight");
            return (Criteria) this;
        }

        public Criteria andElLightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_light not between", value1, value2, "elLight");
            return (Criteria) this;
        }

        public Criteria andElAirConditionIsNull() {
            addCriterion("el_air_condition is null");
            return (Criteria) this;
        }

        public Criteria andElAirConditionIsNotNull() {
            addCriterion("el_air_condition is not null");
            return (Criteria) this;
        }

        public Criteria andElAirConditionEqualTo(BigDecimal value) {
            addCriterion("el_air_condition =", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionNotEqualTo(BigDecimal value) {
            addCriterion("el_air_condition <>", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionGreaterThan(BigDecimal value) {
            addCriterion("el_air_condition >", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_air_condition >=", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionLessThan(BigDecimal value) {
            addCriterion("el_air_condition <", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_air_condition <=", value, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionIn(List<BigDecimal> values) {
            addCriterion("el_air_condition in", values, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionNotIn(List<BigDecimal> values) {
            addCriterion("el_air_condition not in", values, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_air_condition between", value1, value2, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElAirConditionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_air_condition not between", value1, value2, "elAirCondition");
            return (Criteria) this;
        }

        public Criteria andElMotionIsNull() {
            addCriterion("el_motion is null");
            return (Criteria) this;
        }

        public Criteria andElMotionIsNotNull() {
            addCriterion("el_motion is not null");
            return (Criteria) this;
        }

        public Criteria andElMotionEqualTo(BigDecimal value) {
            addCriterion("el_motion =", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionNotEqualTo(BigDecimal value) {
            addCriterion("el_motion <>", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionGreaterThan(BigDecimal value) {
            addCriterion("el_motion >", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_motion >=", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionLessThan(BigDecimal value) {
            addCriterion("el_motion <", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_motion <=", value, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionIn(List<BigDecimal> values) {
            addCriterion("el_motion in", values, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionNotIn(List<BigDecimal> values) {
            addCriterion("el_motion not in", values, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_motion between", value1, value2, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElMotionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_motion not between", value1, value2, "elMotion");
            return (Criteria) this;
        }

        public Criteria andElSpecialIsNull() {
            addCriterion("el_special is null");
            return (Criteria) this;
        }

        public Criteria andElSpecialIsNotNull() {
            addCriterion("el_special is not null");
            return (Criteria) this;
        }

        public Criteria andElSpecialEqualTo(BigDecimal value) {
            addCriterion("el_special =", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialNotEqualTo(BigDecimal value) {
            addCriterion("el_special <>", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialGreaterThan(BigDecimal value) {
            addCriterion("el_special >", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_special >=", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialLessThan(BigDecimal value) {
            addCriterion("el_special <", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_special <=", value, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialIn(List<BigDecimal> values) {
            addCriterion("el_special in", values, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialNotIn(List<BigDecimal> values) {
            addCriterion("el_special not in", values, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_special between", value1, value2, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andElSpecialNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_special not between", value1, value2, "elSpecial");
            return (Criteria) this;
        }

        public Criteria andWaSupplyIsNull() {
            addCriterion("wa_supply is null");
            return (Criteria) this;
        }

        public Criteria andWaSupplyIsNotNull() {
            addCriterion("wa_supply is not null");
            return (Criteria) this;
        }

        public Criteria andWaSupplyEqualTo(BigDecimal value) {
            addCriterion("wa_supply =", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyNotEqualTo(BigDecimal value) {
            addCriterion("wa_supply <>", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyGreaterThan(BigDecimal value) {
            addCriterion("wa_supply >", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_supply >=", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyLessThan(BigDecimal value) {
            addCriterion("wa_supply <", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_supply <=", value, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyIn(List<BigDecimal> values) {
            addCriterion("wa_supply in", values, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyNotIn(List<BigDecimal> values) {
            addCriterion("wa_supply not in", values, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_supply between", value1, value2, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaSupplyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_supply not between", value1, value2, "waSupply");
            return (Criteria) this;
        }

        public Criteria andWaDrainIsNull() {
            addCriterion("wa_drain is null");
            return (Criteria) this;
        }

        public Criteria andWaDrainIsNotNull() {
            addCriterion("wa_drain is not null");
            return (Criteria) this;
        }

        public Criteria andWaDrainEqualTo(BigDecimal value) {
            addCriterion("wa_drain =", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainNotEqualTo(BigDecimal value) {
            addCriterion("wa_drain <>", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainGreaterThan(BigDecimal value) {
            addCriterion("wa_drain >", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_drain >=", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainLessThan(BigDecimal value) {
            addCriterion("wa_drain <", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_drain <=", value, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainIn(List<BigDecimal> values) {
            addCriterion("wa_drain in", values, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainNotIn(List<BigDecimal> values) {
            addCriterion("wa_drain not in", values, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_drain between", value1, value2, "waDrain");
            return (Criteria) this;
        }

        public Criteria andWaDrainNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_drain not between", value1, value2, "waDrain");
            return (Criteria) this;
        }

        public Criteria andMeKitchenIsNull() {
            addCriterion("me_kitchen is null");
            return (Criteria) this;
        }

        public Criteria andMeKitchenIsNotNull() {
            addCriterion("me_kitchen is not null");
            return (Criteria) this;
        }

        public Criteria andMeKitchenEqualTo(BigDecimal value) {
            addCriterion("me_kitchen =", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenNotEqualTo(BigDecimal value) {
            addCriterion("me_kitchen <>", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenGreaterThan(BigDecimal value) {
            addCriterion("me_kitchen >", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("me_kitchen >=", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenLessThan(BigDecimal value) {
            addCriterion("me_kitchen <", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("me_kitchen <=", value, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenIn(List<BigDecimal> values) {
            addCriterion("me_kitchen in", values, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenNotIn(List<BigDecimal> values) {
            addCriterion("me_kitchen not in", values, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_kitchen between", value1, value2, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeKitchenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_kitchen not between", value1, value2, "meKitchen");
            return (Criteria) this;
        }

        public Criteria andMeHeatingIsNull() {
            addCriterion("me_heating is null");
            return (Criteria) this;
        }

        public Criteria andMeHeatingIsNotNull() {
            addCriterion("me_heating is not null");
            return (Criteria) this;
        }

        public Criteria andMeHeatingEqualTo(BigDecimal value) {
            addCriterion("me_heating =", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingNotEqualTo(BigDecimal value) {
            addCriterion("me_heating <>", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingGreaterThan(BigDecimal value) {
            addCriterion("me_heating >", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("me_heating >=", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingLessThan(BigDecimal value) {
            addCriterion("me_heating <", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("me_heating <=", value, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingIn(List<BigDecimal> values) {
            addCriterion("me_heating in", values, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingNotIn(List<BigDecimal> values) {
            addCriterion("me_heating not in", values, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_heating between", value1, value2, "meHeating");
            return (Criteria) this;
        }

        public Criteria andMeHeatingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_heating not between", value1, value2, "meHeating");
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