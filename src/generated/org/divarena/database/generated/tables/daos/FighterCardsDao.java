/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.daos;


import java.util.List;

import org.divarena.database.generated.tables.FighterCards;
import org.divarena.database.generated.tables.records.FighterCardsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FighterCardsDao extends DAOImpl<FighterCardsRecord, org.divarena.database.generated.tables.pojos.FighterCards, Integer> {

    /**
     * Create a new FighterCardsDao without any configuration
     */
    public FighterCardsDao() {
        super(FighterCards.FIGHTER_CARDS, org.divarena.database.generated.tables.pojos.FighterCards.class);
    }

    /**
     * Create a new FighterCardsDao with an attached configuration
     */
    public FighterCardsDao(Configuration configuration) {
        super(FighterCards.FIGHTER_CARDS, org.divarena.database.generated.tables.pojos.FighterCards.class, configuration);
    }

    @Override
    public Integer getId(org.divarena.database.generated.tables.pojos.FighterCards object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchById(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.divarena.database.generated.tables.pojos.FighterCards fetchOneById(Integer value) {
        return fetchOne(FighterCards.FIGHTER_CARDS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByName(String... values) {
        return fetch(FighterCards.FIGHTER_CARDS.NAME, values);
    }

    /**
     * Fetch records that have <code>type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfType(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByType(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.TYPE, values);
    }

    /**
     * Fetch records that have <code>sub_type BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfSubType(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.SUB_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sub_type IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchBySubType(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.SUB_TYPE, values);
    }

    /**
     * Fetch records that have <code>value BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfValue(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.VALUE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>value IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByValue(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.VALUE, values);
    }

    /**
     * Fetch records that have <code>action_points BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfActionPoints(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.ACTION_POINTS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>action_points IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByActionPoints(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.ACTION_POINTS, values);
    }

    /**
     * Fetch records that have <code>only_line BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfOnlyLine(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.ONLY_LINE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>only_line IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByOnlyLine(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.ONLY_LINE, values);
    }

    /**
     * Fetch records that have <code>range_min BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfRangeMin(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.RANGE_MIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>range_min IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByRangeMin(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.RANGE_MIN, values);
    }

    /**
     * Fetch records that have <code>range_max BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfRangeMax(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.RANGE_MAX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>range_max IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByRangeMax(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.RANGE_MAX, values);
    }

    /**
     * Fetch records that have <code>test_los BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfTestLos(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.TEST_LOS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>test_los IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByTestLos(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.TEST_LOS, values);
    }

    /**
     * Fetch records that have <code>test_free BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfTestFree(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.TEST_FREE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>test_free IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByTestFree(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.TEST_FREE, values);
    }

    /**
     * Fetch records that have <code>allow_carried BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfAllowCarried(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.ALLOW_CARRIED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>allow_carried IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByAllowCarried(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.ALLOW_CARRIED, values);
    }

    /**
     * Fetch records that have <code>allow_carrying BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfAllowCarrying(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.ALLOW_CARRYING, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>allow_carrying IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByAllowCarrying(Byte... values) {
        return fetch(FighterCards.FIGHTER_CARDS.ALLOW_CARRYING, values);
    }

    /**
     * Fetch records that have <code>script_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchRangeOfScriptId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(FighterCards.FIGHTER_CARDS.SCRIPT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>script_id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.FighterCards> fetchByScriptId(Integer... values) {
        return fetch(FighterCards.FIGHTER_CARDS.SCRIPT_ID, values);
    }
}
