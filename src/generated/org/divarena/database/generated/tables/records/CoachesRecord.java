/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.records;


import org.divarena.database.generated.tables.Coaches;
import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Record2;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CoachesRecord extends UpdatableRecordImpl<CoachesRecord> implements Record13<Integer, Integer, String, Byte, Byte, Byte, Integer, Integer, Integer, Integer, byte[], byte[], byte[]> {

    private static final long serialVersionUID = -1065878432;

    /**
     * Setter for <code>divarena_db.coaches.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>divarena_db.coaches.account_id</code>.
     */
    public void setAccountId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.account_id</code>.
     */
    public Integer getAccountId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>divarena_db.coaches.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>divarena_db.coaches.skin_color</code>.
     */
    public void setSkinColor(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.skin_color</code>.
     */
    public Byte getSkinColor() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>divarena_db.coaches.hair_color</code>.
     */
    public void setHairColor(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.hair_color</code>.
     */
    public Byte getHairColor() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>divarena_db.coaches.sex</code>.
     */
    public void setSex(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.sex</code>.
     */
    public Byte getSex() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>divarena_db.coaches.instance</code>.
     */
    public void setInstance(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.instance</code>.
     */
    public Integer getInstance() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>divarena_db.coaches.x</code>.
     */
    public void setX(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.x</code>.
     */
    public Integer getX() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>divarena_db.coaches.y</code>.
     */
    public void setY(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.y</code>.
     */
    public Integer getY() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>divarena_db.coaches.z</code>.
     */
    public void setZ(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.z</code>.
     */
    public Integer getZ() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>divarena_db.coaches.inventory</code>.
     */
    public void setInventory(byte[] value) {
        set(10, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.inventory</code>.
     */
    public byte[] getInventory() {
        return (byte[]) get(10);
    }

    /**
     * Setter for <code>divarena_db.coaches.equipment</code>.
     */
    public void setEquipment(byte[] value) {
        set(11, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.equipment</code>.
     */
    public byte[] getEquipment() {
        return (byte[]) get(11);
    }

    /**
     * Setter for <code>divarena_db.coaches.fighters</code>.
     */
    public void setFighters(byte[] value) {
        set(12, value);
    }

    /**
     * Getter for <code>divarena_db.coaches.fighters</code>.
     */
    public byte[] getFighters() {
        return (byte[]) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, Integer, String, Byte, Byte, Byte, Integer, Integer, Integer, Integer, byte[], byte[], byte[]> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Integer, Integer, String, Byte, Byte, Byte, Integer, Integer, Integer, Integer, byte[], byte[], byte[]> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Coaches.COACHES.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Coaches.COACHES.ACCOUNT_ID;
    }

    @Override
    public Field<String> field3() {
        return Coaches.COACHES.NAME;
    }

    @Override
    public Field<Byte> field4() {
        return Coaches.COACHES.SKIN_COLOR;
    }

    @Override
    public Field<Byte> field5() {
        return Coaches.COACHES.HAIR_COLOR;
    }

    @Override
    public Field<Byte> field6() {
        return Coaches.COACHES.SEX;
    }

    @Override
    public Field<Integer> field7() {
        return Coaches.COACHES.INSTANCE;
    }

    @Override
    public Field<Integer> field8() {
        return Coaches.COACHES.X;
    }

    @Override
    public Field<Integer> field9() {
        return Coaches.COACHES.Y;
    }

    @Override
    public Field<Integer> field10() {
        return Coaches.COACHES.Z;
    }

    @Override
    public Field<byte[]> field11() {
        return Coaches.COACHES.INVENTORY;
    }

    @Override
    public Field<byte[]> field12() {
        return Coaches.COACHES.EQUIPMENT;
    }

    @Override
    public Field<byte[]> field13() {
        return Coaches.COACHES.FIGHTERS;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getAccountId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public Byte component4() {
        return getSkinColor();
    }

    @Override
    public Byte component5() {
        return getHairColor();
    }

    @Override
    public Byte component6() {
        return getSex();
    }

    @Override
    public Integer component7() {
        return getInstance();
    }

    @Override
    public Integer component8() {
        return getX();
    }

    @Override
    public Integer component9() {
        return getY();
    }

    @Override
    public Integer component10() {
        return getZ();
    }

    @Override
    public byte[] component11() {
        return getInventory();
    }

    @Override
    public byte[] component12() {
        return getEquipment();
    }

    @Override
    public byte[] component13() {
        return getFighters();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getAccountId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public Byte value4() {
        return getSkinColor();
    }

    @Override
    public Byte value5() {
        return getHairColor();
    }

    @Override
    public Byte value6() {
        return getSex();
    }

    @Override
    public Integer value7() {
        return getInstance();
    }

    @Override
    public Integer value8() {
        return getX();
    }

    @Override
    public Integer value9() {
        return getY();
    }

    @Override
    public Integer value10() {
        return getZ();
    }

    @Override
    public byte[] value11() {
        return getInventory();
    }

    @Override
    public byte[] value12() {
        return getEquipment();
    }

    @Override
    public byte[] value13() {
        return getFighters();
    }

    @Override
    public CoachesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public CoachesRecord value2(Integer value) {
        setAccountId(value);
        return this;
    }

    @Override
    public CoachesRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public CoachesRecord value4(Byte value) {
        setSkinColor(value);
        return this;
    }

    @Override
    public CoachesRecord value5(Byte value) {
        setHairColor(value);
        return this;
    }

    @Override
    public CoachesRecord value6(Byte value) {
        setSex(value);
        return this;
    }

    @Override
    public CoachesRecord value7(Integer value) {
        setInstance(value);
        return this;
    }

    @Override
    public CoachesRecord value8(Integer value) {
        setX(value);
        return this;
    }

    @Override
    public CoachesRecord value9(Integer value) {
        setY(value);
        return this;
    }

    @Override
    public CoachesRecord value10(Integer value) {
        setZ(value);
        return this;
    }

    @Override
    public CoachesRecord value11(byte[] value) {
        setInventory(value);
        return this;
    }

    @Override
    public CoachesRecord value12(byte[] value) {
        setEquipment(value);
        return this;
    }

    @Override
    public CoachesRecord value13(byte[] value) {
        setFighters(value);
        return this;
    }

    @Override
    public CoachesRecord values(Integer value1, Integer value2, String value3, Byte value4, Byte value5, Byte value6, Integer value7, Integer value8, Integer value9, Integer value10, byte[] value11, byte[] value12, byte[] value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CoachesRecord
     */
    public CoachesRecord() {
        super(Coaches.COACHES);
    }

    /**
     * Create a detached, initialised CoachesRecord
     */
    public CoachesRecord(Integer id, Integer accountId, String name, Byte skinColor, Byte hairColor, Byte sex, Integer instance, Integer x, Integer y, Integer z, byte[] inventory, byte[] equipment, byte[] fighters) {
        super(Coaches.COACHES);

        set(0, id);
        set(1, accountId);
        set(2, name);
        set(3, skinColor);
        set(4, hairColor);
        set(5, sex);
        set(6, instance);
        set(7, x);
        set(8, y);
        set(9, z);
        set(10, inventory);
        set(11, equipment);
        set(12, fighters);
    }
}
