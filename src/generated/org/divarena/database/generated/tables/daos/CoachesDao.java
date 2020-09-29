/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.daos;


import java.util.List;

import org.divarena.database.generated.tables.Coaches;
import org.divarena.database.generated.tables.records.CoachesRecord;
import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CoachesDao extends DAOImpl<CoachesRecord, org.divarena.database.generated.tables.pojos.Coaches, Record2<Integer, Integer>> {

    /**
     * Create a new CoachesDao without any configuration
     */
    public CoachesDao() {
        super(Coaches.COACHES, org.divarena.database.generated.tables.pojos.Coaches.class);
    }

    /**
     * Create a new CoachesDao with an attached configuration
     */
    public CoachesDao(Configuration configuration) {
        super(Coaches.COACHES, org.divarena.database.generated.tables.pojos.Coaches.class, configuration);
    }

    @Override
    public Record2<Integer, Integer> getId(org.divarena.database.generated.tables.pojos.Coaches object) {
        return compositeKeyRecord(object.getId(), object.getAccountId());
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchById(Integer... values) {
        return fetch(Coaches.COACHES.ID, values);
    }

    /**
     * Fetch records that have <code>account_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfAccountId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.ACCOUNT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>account_id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByAccountId(Integer... values) {
        return fetch(Coaches.COACHES.ACCOUNT_ID, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Coaches.COACHES.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByName(String... values) {
        return fetch(Coaches.COACHES.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public org.divarena.database.generated.tables.pojos.Coaches fetchOneByName(String value) {
        return fetchOne(Coaches.COACHES.NAME, value);
    }

    /**
     * Fetch records that have <code>skin_color BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfSkinColor(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Coaches.COACHES.SKIN_COLOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>skin_color IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchBySkinColor(Byte... values) {
        return fetch(Coaches.COACHES.SKIN_COLOR, values);
    }

    /**
     * Fetch records that have <code>hair_color BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfHairColor(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Coaches.COACHES.HAIR_COLOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>hair_color IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByHairColor(Byte... values) {
        return fetch(Coaches.COACHES.HAIR_COLOR, values);
    }

    /**
     * Fetch records that have <code>sex BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfSex(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Coaches.COACHES.SEX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sex IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchBySex(Byte... values) {
        return fetch(Coaches.COACHES.SEX, values);
    }

    /**
     * Fetch records that have <code>instance BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfInstance(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.INSTANCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>instance IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByInstance(Integer... values) {
        return fetch(Coaches.COACHES.INSTANCE, values);
    }

    /**
     * Fetch records that have <code>x BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfX(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.X, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>x IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByX(Integer... values) {
        return fetch(Coaches.COACHES.X, values);
    }

    /**
     * Fetch records that have <code>y BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfY(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.Y, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>y IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByY(Integer... values) {
        return fetch(Coaches.COACHES.Y, values);
    }

    /**
     * Fetch records that have <code>z BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfZ(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Coaches.COACHES.Z, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>z IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByZ(Integer... values) {
        return fetch(Coaches.COACHES.Z, values);
    }

    /**
     * Fetch records that have <code>inventory BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfInventory(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Coaches.COACHES.INVENTORY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>inventory IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByInventory(byte[]... values) {
        return fetch(Coaches.COACHES.INVENTORY, values);
    }

    /**
     * Fetch records that have <code>equipment BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfEquipment(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Coaches.COACHES.EQUIPMENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>equipment IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByEquipment(byte[]... values) {
        return fetch(Coaches.COACHES.EQUIPMENT, values);
    }

    /**
     * Fetch records that have <code>fighters BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchRangeOfFighters(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Coaches.COACHES.FIGHTERS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>fighters IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Coaches> fetchByFighters(byte[]... values) {
        return fetch(Coaches.COACHES.FIGHTERS, values);
    }
}
