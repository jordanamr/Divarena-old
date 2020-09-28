/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables;


import java.util.Arrays;
import java.util.List;

import org.divarena.database.generated.DivarenaDb;
import org.divarena.database.generated.Keys;
import org.divarena.database.generated.tables.records.CoachesRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row12;
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
public class Coaches extends TableImpl<CoachesRecord> {

    private static final long serialVersionUID = -1261341363;

    /**
     * The reference instance of <code>divarena_db.coaches</code>
     */
    public static final Coaches COACHES = new Coaches();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CoachesRecord> getRecordType() {
        return CoachesRecord.class;
    }

    /**
     * The column <code>divarena_db.coaches.id</code>.
     */
    public final TableField<CoachesRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>divarena_db.coaches.account_id</code>.
     */
    public final TableField<CoachesRecord, Integer> ACCOUNT_ID = createField(DSL.name("account_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.name</code>.
     */
    public final TableField<CoachesRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.skin_color</code>.
     */
    public final TableField<CoachesRecord, Byte> SKIN_COLOR = createField(DSL.name("skin_color"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.hair_color</code>.
     */
    public final TableField<CoachesRecord, Byte> HAIR_COLOR = createField(DSL.name("hair_color"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.sex</code>.
     */
    public final TableField<CoachesRecord, Byte> SEX = createField(DSL.name("sex"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.instance</code>.
     */
    public final TableField<CoachesRecord, Integer> INSTANCE = createField(DSL.name("instance"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.x</code>.
     */
    public final TableField<CoachesRecord, Integer> X = createField(DSL.name("x"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.y</code>.
     */
    public final TableField<CoachesRecord, Integer> Y = createField(DSL.name("y"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.z</code>.
     */
    public final TableField<CoachesRecord, Integer> Z = createField(DSL.name("z"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>divarena_db.coaches.inventory</code>.
     */
    public final TableField<CoachesRecord, byte[]> INVENTORY = createField(DSL.name("inventory"), org.jooq.impl.SQLDataType.BLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("''", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * The column <code>divarena_db.coaches.equipment</code>.
     */
    public final TableField<CoachesRecord, byte[]> EQUIPMENT = createField(DSL.name("equipment"), org.jooq.impl.SQLDataType.BLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("''", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * Create a <code>divarena_db.coaches</code> table reference
     */
    public Coaches() {
        this(DSL.name("coaches"), null);
    }

    /**
     * Create an aliased <code>divarena_db.coaches</code> table reference
     */
    public Coaches(String alias) {
        this(DSL.name(alias), COACHES);
    }

    /**
     * Create an aliased <code>divarena_db.coaches</code> table reference
     */
    public Coaches(Name alias) {
        this(alias, COACHES);
    }

    private Coaches(Name alias, Table<CoachesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Coaches(Name alias, Table<CoachesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Coaches(Table<O> child, ForeignKey<O, CoachesRecord> key) {
        super(child, key, COACHES);
    }

    @Override
    public Schema getSchema() {
        return DivarenaDb.DIVARENA_DB;
    }

    @Override
    public Identity<CoachesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COACHES;
    }

    @Override
    public UniqueKey<CoachesRecord> getPrimaryKey() {
        return Keys.KEY_COACHES_PRIMARY;
    }

    @Override
    public List<UniqueKey<CoachesRecord>> getKeys() {
        return Arrays.<UniqueKey<CoachesRecord>>asList(Keys.KEY_COACHES_PRIMARY, Keys.KEY_COACHES_NAME);
    }

    @Override
    public Coaches as(String alias) {
        return new Coaches(DSL.name(alias), this);
    }

    @Override
    public Coaches as(Name alias) {
        return new Coaches(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Coaches rename(String name) {
        return new Coaches(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Coaches rename(Name name) {
        return new Coaches(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<Integer, Integer, String, Byte, Byte, Byte, Integer, Integer, Integer, Integer, byte[], byte[]> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}
