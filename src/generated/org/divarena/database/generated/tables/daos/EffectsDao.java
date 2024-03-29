/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.daos;


import java.util.List;

import org.divarena.database.generated.tables.Effects;
import org.divarena.database.generated.tables.records.EffectsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EffectsDao extends DAOImpl<EffectsRecord, org.divarena.database.generated.tables.pojos.Effects, Integer> {

    /**
     * Create a new EffectsDao without any configuration
     */
    public EffectsDao() {
        super(Effects.EFFECTS, org.divarena.database.generated.tables.pojos.Effects.class);
    }

    /**
     * Create a new EffectsDao with an attached configuration
     */
    public EffectsDao(Configuration configuration) {
        super(Effects.EFFECTS, org.divarena.database.generated.tables.pojos.Effects.class, configuration);
    }

    @Override
    public Integer getId(org.divarena.database.generated.tables.pojos.Effects object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Effects.EFFECTS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchById(Integer... values) {
        return fetch(Effects.EFFECTS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.divarena.database.generated.tables.pojos.Effects fetchOneById(Integer value) {
        return fetchOne(Effects.EFFECTS.ID, value);
    }

    /**
     * Fetch records that have <code>parent_type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfParentType(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.PARENT_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>parent_type IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByParentType(String... values) {
        return fetch(Effects.EFFECTS.PARENT_TYPE, values);
    }

    /**
     * Fetch records that have <code>parent_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfParentId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Effects.EFFECTS.PARENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>parent_id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByParentId(Integer... values) {
        return fetch(Effects.EFFECTS.PARENT_ID, values);
    }

    /**
     * Fetch records that have <code>duration BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfDuration(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.DURATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>duration IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByDuration(String... values) {
        return fetch(Effects.EFFECTS.DURATION, values);
    }

    /**
     * Fetch records that have <code>action_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfActionId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Effects.EFFECTS.ACTION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>action_id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByActionId(Integer... values) {
        return fetch(Effects.EFFECTS.ACTION_ID, values);
    }

    /**
     * Fetch records that have <code>critical BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfCritical(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Effects.EFFECTS.CRITICAL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>critical IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByCritical(Byte... values) {
        return fetch(Effects.EFFECTS.CRITICAL, values);
    }

    /**
     * Fetch records that have <code>params BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfParams(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.PARAMS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>params IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByParams(String... values) {
        return fetch(Effects.EFFECTS.PARAMS, values);
    }

    /**
     * Fetch records that have <code>area_shape BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfAreaShape(Short lowerInclusive, Short upperInclusive) {
        return fetchRange(Effects.EFFECTS.AREA_SHAPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>area_shape IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByAreaShape(Short... values) {
        return fetch(Effects.EFFECTS.AREA_SHAPE, values);
    }

    /**
     * Fetch records that have <code>area_size BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfAreaSize(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.AREA_SIZE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>area_size IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByAreaSize(String... values) {
        return fetch(Effects.EFFECTS.AREA_SIZE, values);
    }

    /**
     * Fetch records that have <code>targets BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfTargets(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.TARGETS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>targets IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByTargets(String... values) {
        return fetch(Effects.EFFECTS.TARGETS, values);
    }

    /**
     * Fetch records that have <code>triggers_after BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfTriggersAfter(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.TRIGGERS_AFTER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>triggers_after IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByTriggersAfter(String... values) {
        return fetch(Effects.EFFECTS.TRIGGERS_AFTER, values);
    }

    /**
     * Fetch records that have <code>triggers_before BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfTriggersBefore(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.TRIGGERS_BEFORE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>triggers_before IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByTriggersBefore(String... values) {
        return fetch(Effects.EFFECTS.TRIGGERS_BEFORE, values);
    }

    /**
     * Fetch records that have <code>end_triggers BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfEndTriggers(String lowerInclusive, String upperInclusive) {
        return fetchRange(Effects.EFFECTS.END_TRIGGERS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>end_triggers IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByEndTriggers(String... values) {
        return fetch(Effects.EFFECTS.END_TRIGGERS, values);
    }

    /**
     * Fetch records that have <code>affected_by_localisation BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchRangeOfAffectedByLocalisation(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Effects.EFFECTS.AFFECTED_BY_LOCALISATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>affected_by_localisation IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Effects> fetchByAffectedByLocalisation(Byte... values) {
        return fetch(Effects.EFFECTS.AFFECTED_BY_LOCALISATION, values);
    }
}
