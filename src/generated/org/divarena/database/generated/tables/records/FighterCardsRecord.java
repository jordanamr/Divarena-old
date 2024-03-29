/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.records;


import org.divarena.database.generated.tables.FighterCards;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FighterCardsRecord extends UpdatableRecordImpl<FighterCardsRecord> implements Record14<Integer, String, Byte, Integer, Integer, Byte, Byte, Integer, Integer, Byte, Byte, Byte, Byte, Integer> {

    private static final long serialVersionUID = -831931161;

    /**
     * Setter for <code>divarena_db.fighter_cards.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.type</code>.
     */
    public void setType(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.type</code>.
     */
    public Byte getType() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.sub_type</code>.
     */
    public void setSubType(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.sub_type</code>.
     */
    public Integer getSubType() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.value</code>.
     */
    public void setValue(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.value</code>.
     */
    public Integer getValue() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.action_points</code>.
     */
    public void setActionPoints(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.action_points</code>.
     */
    public Byte getActionPoints() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.only_line</code>.
     */
    public void setOnlyLine(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.only_line</code>.
     */
    public Byte getOnlyLine() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.range_min</code>.
     */
    public void setRangeMin(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.range_min</code>.
     */
    public Integer getRangeMin() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.range_max</code>.
     */
    public void setRangeMax(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.range_max</code>.
     */
    public Integer getRangeMax() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.test_los</code>.
     */
    public void setTestLos(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.test_los</code>.
     */
    public Byte getTestLos() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.test_free</code>.
     */
    public void setTestFree(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.test_free</code>.
     */
    public Byte getTestFree() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.allow_carried</code>.
     */
    public void setAllowCarried(Byte value) {
        set(11, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.allow_carried</code>.
     */
    public Byte getAllowCarried() {
        return (Byte) get(11);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.allow_carrying</code>.
     */
    public void setAllowCarrying(Byte value) {
        set(12, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.allow_carrying</code>.
     */
    public Byte getAllowCarrying() {
        return (Byte) get(12);
    }

    /**
     * Setter for <code>divarena_db.fighter_cards.script_id</code>.
     */
    public void setScriptId(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>divarena_db.fighter_cards.script_id</code>.
     */
    public Integer getScriptId() {
        return (Integer) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<Integer, String, Byte, Integer, Integer, Byte, Byte, Integer, Integer, Byte, Byte, Byte, Byte, Integer> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<Integer, String, Byte, Integer, Integer, Byte, Byte, Integer, Integer, Byte, Byte, Byte, Byte, Integer> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return FighterCards.FIGHTER_CARDS.ID;
    }

    @Override
    public Field<String> field2() {
        return FighterCards.FIGHTER_CARDS.NAME;
    }

    @Override
    public Field<Byte> field3() {
        return FighterCards.FIGHTER_CARDS.TYPE;
    }

    @Override
    public Field<Integer> field4() {
        return FighterCards.FIGHTER_CARDS.SUB_TYPE;
    }

    @Override
    public Field<Integer> field5() {
        return FighterCards.FIGHTER_CARDS.VALUE;
    }

    @Override
    public Field<Byte> field6() {
        return FighterCards.FIGHTER_CARDS.ACTION_POINTS;
    }

    @Override
    public Field<Byte> field7() {
        return FighterCards.FIGHTER_CARDS.ONLY_LINE;
    }

    @Override
    public Field<Integer> field8() {
        return FighterCards.FIGHTER_CARDS.RANGE_MIN;
    }

    @Override
    public Field<Integer> field9() {
        return FighterCards.FIGHTER_CARDS.RANGE_MAX;
    }

    @Override
    public Field<Byte> field10() {
        return FighterCards.FIGHTER_CARDS.TEST_LOS;
    }

    @Override
    public Field<Byte> field11() {
        return FighterCards.FIGHTER_CARDS.TEST_FREE;
    }

    @Override
    public Field<Byte> field12() {
        return FighterCards.FIGHTER_CARDS.ALLOW_CARRIED;
    }

    @Override
    public Field<Byte> field13() {
        return FighterCards.FIGHTER_CARDS.ALLOW_CARRYING;
    }

    @Override
    public Field<Integer> field14() {
        return FighterCards.FIGHTER_CARDS.SCRIPT_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Byte component3() {
        return getType();
    }

    @Override
    public Integer component4() {
        return getSubType();
    }

    @Override
    public Integer component5() {
        return getValue();
    }

    @Override
    public Byte component6() {
        return getActionPoints();
    }

    @Override
    public Byte component7() {
        return getOnlyLine();
    }

    @Override
    public Integer component8() {
        return getRangeMin();
    }

    @Override
    public Integer component9() {
        return getRangeMax();
    }

    @Override
    public Byte component10() {
        return getTestLos();
    }

    @Override
    public Byte component11() {
        return getTestFree();
    }

    @Override
    public Byte component12() {
        return getAllowCarried();
    }

    @Override
    public Byte component13() {
        return getAllowCarrying();
    }

    @Override
    public Integer component14() {
        return getScriptId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Byte value3() {
        return getType();
    }

    @Override
    public Integer value4() {
        return getSubType();
    }

    @Override
    public Integer value5() {
        return getValue();
    }

    @Override
    public Byte value6() {
        return getActionPoints();
    }

    @Override
    public Byte value7() {
        return getOnlyLine();
    }

    @Override
    public Integer value8() {
        return getRangeMin();
    }

    @Override
    public Integer value9() {
        return getRangeMax();
    }

    @Override
    public Byte value10() {
        return getTestLos();
    }

    @Override
    public Byte value11() {
        return getTestFree();
    }

    @Override
    public Byte value12() {
        return getAllowCarried();
    }

    @Override
    public Byte value13() {
        return getAllowCarrying();
    }

    @Override
    public Integer value14() {
        return getScriptId();
    }

    @Override
    public FighterCardsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public FighterCardsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public FighterCardsRecord value3(Byte value) {
        setType(value);
        return this;
    }

    @Override
    public FighterCardsRecord value4(Integer value) {
        setSubType(value);
        return this;
    }

    @Override
    public FighterCardsRecord value5(Integer value) {
        setValue(value);
        return this;
    }

    @Override
    public FighterCardsRecord value6(Byte value) {
        setActionPoints(value);
        return this;
    }

    @Override
    public FighterCardsRecord value7(Byte value) {
        setOnlyLine(value);
        return this;
    }

    @Override
    public FighterCardsRecord value8(Integer value) {
        setRangeMin(value);
        return this;
    }

    @Override
    public FighterCardsRecord value9(Integer value) {
        setRangeMax(value);
        return this;
    }

    @Override
    public FighterCardsRecord value10(Byte value) {
        setTestLos(value);
        return this;
    }

    @Override
    public FighterCardsRecord value11(Byte value) {
        setTestFree(value);
        return this;
    }

    @Override
    public FighterCardsRecord value12(Byte value) {
        setAllowCarried(value);
        return this;
    }

    @Override
    public FighterCardsRecord value13(Byte value) {
        setAllowCarrying(value);
        return this;
    }

    @Override
    public FighterCardsRecord value14(Integer value) {
        setScriptId(value);
        return this;
    }

    @Override
    public FighterCardsRecord values(Integer value1, String value2, Byte value3, Integer value4, Integer value5, Byte value6, Byte value7, Integer value8, Integer value9, Byte value10, Byte value11, Byte value12, Byte value13, Integer value14) {
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
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FighterCardsRecord
     */
    public FighterCardsRecord() {
        super(FighterCards.FIGHTER_CARDS);
    }

    /**
     * Create a detached, initialised FighterCardsRecord
     */
    public FighterCardsRecord(Integer id, String name, Byte type, Integer subType, Integer value, Byte actionPoints, Byte onlyLine, Integer rangeMin, Integer rangeMax, Byte testLos, Byte testFree, Byte allowCarried, Byte allowCarrying, Integer scriptId) {
        super(FighterCards.FIGHTER_CARDS);

        set(0, id);
        set(1, name);
        set(2, type);
        set(3, subType);
        set(4, value);
        set(5, actionPoints);
        set(6, onlyLine);
        set(7, rangeMin);
        set(8, rangeMax);
        set(9, testLos);
        set(10, testFree);
        set(11, allowCarried);
        set(12, allowCarrying);
        set(13, scriptId);
    }
}
