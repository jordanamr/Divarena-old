/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.daos;


import java.util.List;

import org.divarena.database.generated.tables.Counts;
import org.divarena.database.generated.tables.records.CountsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CountsDao extends DAOImpl<CountsRecord, org.divarena.database.generated.tables.pojos.Counts, Integer> {

    /**
     * Create a new CountsDao without any configuration
     */
    public CountsDao() {
        super(Counts.COUNTS, org.divarena.database.generated.tables.pojos.Counts.class);
    }

    /**
     * Create a new CountsDao with an attached configuration
     */
    public CountsDao(Configuration configuration) {
        super(Counts.COUNTS, org.divarena.database.generated.tables.pojos.Counts.class, configuration);
    }

    @Override
    public Integer getId(org.divarena.database.generated.tables.pojos.Counts object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Counts.COUNTS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchById(Integer... values) {
        return fetch(Counts.COUNTS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.divarena.database.generated.tables.pojos.Counts fetchOneById(Integer value) {
        return fetchOne(Counts.COUNTS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Counts.COUNTS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchByName(String... values) {
        return fetch(Counts.COUNTS.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public org.divarena.database.generated.tables.pojos.Counts fetchOneByName(String value) {
        return fetchOne(Counts.COUNTS.NAME, value);
    }

    /**
     * Fetch records that have <code>count BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchRangeOfCount(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Counts.COUNTS.COUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>count IN (values)</code>
     */
    public List<org.divarena.database.generated.tables.pojos.Counts> fetchByCount(Integer... values) {
        return fetch(Counts.COUNTS.COUNT, values);
    }
}
