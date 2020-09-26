/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables;


import java.util.Arrays;
import java.util.List;

import org.divarena.database.generated.DivarenaDb;
import org.divarena.database.generated.Keys;
import org.divarena.database.generated.tables.records.CoachCardsRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CoachCards extends TableImpl<CoachCardsRecord> {

    private static final long serialVersionUID = -545626381;

    /**
     * The reference instance of <code>divarena_db.coach_cards</code>
     */
    public static final CoachCards COACH_CARDS = new CoachCards();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CoachCardsRecord> getRecordType() {
        return CoachCardsRecord.class;
    }

    /**
     * The column <code>divarena_db.coach_cards.id</code>.
     */
    public final TableField<CoachCardsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>divarena_db.coach_cards.name</code>.
     */
    public final TableField<CoachCardsRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>divarena_db.coach_cards.type</code>.
     */
    public final TableField<CoachCardsRecord, Integer> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coach_cards.value</code>.
     */
    public final TableField<CoachCardsRecord, Integer> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coach_cards.set_id</code>.
     */
    public final TableField<CoachCardsRecord, Integer> SET_ID = createField(DSL.name("set_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>divarena_db.coach_cards</code> table reference
     */
    public CoachCards() {
        this(DSL.name("coach_cards"), null);
    }

    /**
     * Create an aliased <code>divarena_db.coach_cards</code> table reference
     */
    public CoachCards(String alias) {
        this(DSL.name(alias), COACH_CARDS);
    }

    /**
     * Create an aliased <code>divarena_db.coach_cards</code> table reference
     */
    public CoachCards(Name alias) {
        this(alias, COACH_CARDS);
    }

    private CoachCards(Name alias, Table<CoachCardsRecord> aliased) {
        this(alias, aliased, null);
    }

    private CoachCards(Name alias, Table<CoachCardsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> CoachCards(Table<O> child, ForeignKey<O, CoachCardsRecord> key) {
        super(child, key, COACH_CARDS);
    }

    @Override
    public Schema getSchema() {
        return DivarenaDb.DIVARENA_DB;
    }

    @Override
    public Identity<CoachCardsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COACH_CARDS;
    }

    @Override
    public UniqueKey<CoachCardsRecord> getPrimaryKey() {
        return Keys.KEY_COACH_CARDS_PRIMARY;
    }

    @Override
    public List<UniqueKey<CoachCardsRecord>> getKeys() {
        return Arrays.<UniqueKey<CoachCardsRecord>>asList(Keys.KEY_COACH_CARDS_PRIMARY);
    }

    @Override
    public CoachCards as(String alias) {
        return new CoachCards(DSL.name(alias), this);
    }

    @Override
    public CoachCards as(Name alias) {
        return new CoachCards(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CoachCards rename(String name) {
        return new CoachCards(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CoachCards rename(Name name) {
        return new CoachCards(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
