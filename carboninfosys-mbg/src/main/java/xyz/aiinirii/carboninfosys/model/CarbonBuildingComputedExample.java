package xyz.aiinirii.carboninfosys.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarbonBuildingComputedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarbonBuildingComputedExample() {
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

        public Criteria andElLightComputedIsNull() {
            addCriterion("el_light_computed is null");
            return (Criteria) this;
        }

        public Criteria andElLightComputedIsNotNull() {
            addCriterion("el_light_computed is not null");
            return (Criteria) this;
        }

        public Criteria andElLightComputedEqualTo(BigDecimal value) {
            addCriterion("el_light_computed =", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedNotEqualTo(BigDecimal value) {
            addCriterion("el_light_computed <>", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedGreaterThan(BigDecimal value) {
            addCriterion("el_light_computed >", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_light_computed >=", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedLessThan(BigDecimal value) {
            addCriterion("el_light_computed <", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_light_computed <=", value, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedIn(List<BigDecimal> values) {
            addCriterion("el_light_computed in", values, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedNotIn(List<BigDecimal> values) {
            addCriterion("el_light_computed not in", values, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_light_computed between", value1, value2, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElLightComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_light_computed not between", value1, value2, "elLightComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedIsNull() {
            addCriterion("el_air_condition_computed is null");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedIsNotNull() {
            addCriterion("el_air_condition_computed is not null");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedEqualTo(BigDecimal value) {
            addCriterion("el_air_condition_computed =", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedNotEqualTo(BigDecimal value) {
            addCriterion("el_air_condition_computed <>", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedGreaterThan(BigDecimal value) {
            addCriterion("el_air_condition_computed >", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_air_condition_computed >=", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedLessThan(BigDecimal value) {
            addCriterion("el_air_condition_computed <", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_air_condition_computed <=", value, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedIn(List<BigDecimal> values) {
            addCriterion("el_air_condition_computed in", values, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedNotIn(List<BigDecimal> values) {
            addCriterion("el_air_condition_computed not in", values, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_air_condition_computed between", value1, value2, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElAirConditionComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_air_condition_computed not between", value1, value2, "elAirConditionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedIsNull() {
            addCriterion("el_motion_computed is null");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedIsNotNull() {
            addCriterion("el_motion_computed is not null");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedEqualTo(BigDecimal value) {
            addCriterion("el_motion_computed =", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedNotEqualTo(BigDecimal value) {
            addCriterion("el_motion_computed <>", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedGreaterThan(BigDecimal value) {
            addCriterion("el_motion_computed >", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_motion_computed >=", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedLessThan(BigDecimal value) {
            addCriterion("el_motion_computed <", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_motion_computed <=", value, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedIn(List<BigDecimal> values) {
            addCriterion("el_motion_computed in", values, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedNotIn(List<BigDecimal> values) {
            addCriterion("el_motion_computed not in", values, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_motion_computed between", value1, value2, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElMotionComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_motion_computed not between", value1, value2, "elMotionComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedIsNull() {
            addCriterion("el_special_computed is null");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedIsNotNull() {
            addCriterion("el_special_computed is not null");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedEqualTo(BigDecimal value) {
            addCriterion("el_special_computed =", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedNotEqualTo(BigDecimal value) {
            addCriterion("el_special_computed <>", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedGreaterThan(BigDecimal value) {
            addCriterion("el_special_computed >", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_special_computed >=", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedLessThan(BigDecimal value) {
            addCriterion("el_special_computed <", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_special_computed <=", value, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedIn(List<BigDecimal> values) {
            addCriterion("el_special_computed in", values, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedNotIn(List<BigDecimal> values) {
            addCriterion("el_special_computed not in", values, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_special_computed between", value1, value2, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andElSpecialComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_special_computed not between", value1, value2, "elSpecialComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedIsNull() {
            addCriterion("wa_supply_computed is null");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedIsNotNull() {
            addCriterion("wa_supply_computed is not null");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedEqualTo(BigDecimal value) {
            addCriterion("wa_supply_computed =", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedNotEqualTo(BigDecimal value) {
            addCriterion("wa_supply_computed <>", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedGreaterThan(BigDecimal value) {
            addCriterion("wa_supply_computed >", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_supply_computed >=", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedLessThan(BigDecimal value) {
            addCriterion("wa_supply_computed <", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_supply_computed <=", value, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedIn(List<BigDecimal> values) {
            addCriterion("wa_supply_computed in", values, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedNotIn(List<BigDecimal> values) {
            addCriterion("wa_supply_computed not in", values, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_supply_computed between", value1, value2, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaSupplyComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_supply_computed not between", value1, value2, "waSupplyComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedIsNull() {
            addCriterion("wa_drain_computed is null");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedIsNotNull() {
            addCriterion("wa_drain_computed is not null");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedEqualTo(BigDecimal value) {
            addCriterion("wa_drain_computed =", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedNotEqualTo(BigDecimal value) {
            addCriterion("wa_drain_computed <>", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedGreaterThan(BigDecimal value) {
            addCriterion("wa_drain_computed >", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_drain_computed >=", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedLessThan(BigDecimal value) {
            addCriterion("wa_drain_computed <", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_drain_computed <=", value, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedIn(List<BigDecimal> values) {
            addCriterion("wa_drain_computed in", values, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedNotIn(List<BigDecimal> values) {
            addCriterion("wa_drain_computed not in", values, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_drain_computed between", value1, value2, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andWaDrainComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_drain_computed not between", value1, value2, "waDrainComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedIsNull() {
            addCriterion("me_kitchen_computed is null");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedIsNotNull() {
            addCriterion("me_kitchen_computed is not null");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedEqualTo(BigDecimal value) {
            addCriterion("me_kitchen_computed =", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedNotEqualTo(BigDecimal value) {
            addCriterion("me_kitchen_computed <>", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedGreaterThan(BigDecimal value) {
            addCriterion("me_kitchen_computed >", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("me_kitchen_computed >=", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedLessThan(BigDecimal value) {
            addCriterion("me_kitchen_computed <", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("me_kitchen_computed <=", value, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedIn(List<BigDecimal> values) {
            addCriterion("me_kitchen_computed in", values, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedNotIn(List<BigDecimal> values) {
            addCriterion("me_kitchen_computed not in", values, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_kitchen_computed between", value1, value2, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeKitchenComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_kitchen_computed not between", value1, value2, "meKitchenComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedIsNull() {
            addCriterion("me_heating_computed is null");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedIsNotNull() {
            addCriterion("me_heating_computed is not null");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedEqualTo(BigDecimal value) {
            addCriterion("me_heating_computed =", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedNotEqualTo(BigDecimal value) {
            addCriterion("me_heating_computed <>", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedGreaterThan(BigDecimal value) {
            addCriterion("me_heating_computed >", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("me_heating_computed >=", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedLessThan(BigDecimal value) {
            addCriterion("me_heating_computed <", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("me_heating_computed <=", value, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedIn(List<BigDecimal> values) {
            addCriterion("me_heating_computed in", values, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedNotIn(List<BigDecimal> values) {
            addCriterion("me_heating_computed not in", values, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_heating_computed between", value1, value2, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andMeHeatingComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_heating_computed not between", value1, value2, "meHeatingComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedIsNull() {
            addCriterion("el_total_computed is null");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedIsNotNull() {
            addCriterion("el_total_computed is not null");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedEqualTo(BigDecimal value) {
            addCriterion("el_total_computed =", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedNotEqualTo(BigDecimal value) {
            addCriterion("el_total_computed <>", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedGreaterThan(BigDecimal value) {
            addCriterion("el_total_computed >", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("el_total_computed >=", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedLessThan(BigDecimal value) {
            addCriterion("el_total_computed <", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("el_total_computed <=", value, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedIn(List<BigDecimal> values) {
            addCriterion("el_total_computed in", values, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedNotIn(List<BigDecimal> values) {
            addCriterion("el_total_computed not in", values, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_total_computed between", value1, value2, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andElTotalComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("el_total_computed not between", value1, value2, "elTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedIsNull() {
            addCriterion("wa_total_computed is null");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedIsNotNull() {
            addCriterion("wa_total_computed is not null");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedEqualTo(BigDecimal value) {
            addCriterion("wa_total_computed =", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedNotEqualTo(BigDecimal value) {
            addCriterion("wa_total_computed <>", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedGreaterThan(BigDecimal value) {
            addCriterion("wa_total_computed >", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_total_computed >=", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedLessThan(BigDecimal value) {
            addCriterion("wa_total_computed <", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wa_total_computed <=", value, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedIn(List<BigDecimal> values) {
            addCriterion("wa_total_computed in", values, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedNotIn(List<BigDecimal> values) {
            addCriterion("wa_total_computed not in", values, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_total_computed between", value1, value2, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andWaTotalComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wa_total_computed not between", value1, value2, "waTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedIsNull() {
            addCriterion("me_total_computed is null");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedIsNotNull() {
            addCriterion("me_total_computed is not null");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedEqualTo(BigDecimal value) {
            addCriterion("me_total_computed =", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedNotEqualTo(BigDecimal value) {
            addCriterion("me_total_computed <>", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedGreaterThan(BigDecimal value) {
            addCriterion("me_total_computed >", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("me_total_computed >=", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedLessThan(BigDecimal value) {
            addCriterion("me_total_computed <", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("me_total_computed <=", value, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedIn(List<BigDecimal> values) {
            addCriterion("me_total_computed in", values, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedNotIn(List<BigDecimal> values) {
            addCriterion("me_total_computed not in", values, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_total_computed between", value1, value2, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andMeTotalComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("me_total_computed not between", value1, value2, "meTotalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedIsNull() {
            addCriterion("total_computed is null");
            return (Criteria) this;
        }

        public Criteria andTotalComputedIsNotNull() {
            addCriterion("total_computed is not null");
            return (Criteria) this;
        }

        public Criteria andTotalComputedEqualTo(BigDecimal value) {
            addCriterion("total_computed =", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedNotEqualTo(BigDecimal value) {
            addCriterion("total_computed <>", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedGreaterThan(BigDecimal value) {
            addCriterion("total_computed >", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_computed >=", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedLessThan(BigDecimal value) {
            addCriterion("total_computed <", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_computed <=", value, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedIn(List<BigDecimal> values) {
            addCriterion("total_computed in", values, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedNotIn(List<BigDecimal> values) {
            addCriterion("total_computed not in", values, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_computed between", value1, value2, "totalComputed");
            return (Criteria) this;
        }

        public Criteria andTotalComputedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_computed not between", value1, value2, "totalComputed");
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