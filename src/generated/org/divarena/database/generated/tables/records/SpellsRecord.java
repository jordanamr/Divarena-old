/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.records;


import org.divarena.database.generated.tables.Spells;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SpellsRecord extends UpdatableRecordImpl<SpellsRecord> implements Record17<Integer, String, Integer, Integer, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Integer, Integer, Byte, String> {

    private static final long serialVersionUID = -1395150276;

    /**
     * Setter for <code>divarena_db.spells.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>divarena_db.spells.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>divarena_db.spells.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>divarena_db.spells.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>divarena_db.spells.value</code>.
     */
    public void setValue(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>divarena_db.spells.value</code>.
     */
    public Integer getValue() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>divarena_db.spells.breed_id</code>.
     */
    public void setBreedId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>divarena_db.spells.breed_id</code>.
     */
    public Integer getBreedId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>divarena_db.spells.ap</code>.
     */
    public void setAp(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>divarena_db.spells.ap</code>.
     */
    public Byte getAp() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>divarena_db.spells.cast_per_player</code>.
     */
    public void setCastPerPlayer(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>divarena_db.spells.cast_per_player</code>.
     */
    public Byte getCastPerPlayer() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>divarena_db.spells.cast_per_turn</code>.
     */
    public void setCastPerTurn(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>divarena_db.spells.cast_per_turn</code>.
     */
    public Byte getCastPerTurn() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>divarena_db.spells.interval</code>.
     */
    public void setInterval(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>divarena_db.spells.interval</code>.
     */
    public Byte getInterval() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>divarena_db.spells.test_los</code>.
     */
    public void setTestLos(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>divarena_db.spells.test_los</code>.
     */
    public Byte getTestLos() {
        return (Byte) get(8);
    }

    /**
     * Setter for <code>divarena_db.spells.test_free</code>.
     */
    public void setTestFree(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>divarena_db.spells.test_free</code>.
     */
    public Byte getTestFree() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>divarena_db.spells.only_line</code>.
     */
    public void setOnlyLine(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>divarena_db.spells.only_line</code>.
     */
    public Byte getOnlyLine() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>divarena_db.spells.range_min</code>.
     */
    public void setRangeMin(Byte value) {
        set(11, value);
    }

    /**
     * Getter for <code>divarena_db.spells.range_min</code>.
     */
    public Byte getRangeMin() {
        return (Byte) get(11);
    }

    /**
     * Setter for <code>divarena_db.spells.range_max</code>.
     */
    public void setRangeMax(Byte value) {
        set(12, value);
    }

    /**
     * Getter for <code>divarena_db.spells.range_max</code>.
     */
    public Byte getRangeMax() {
        return (Byte) get(12);
    }

    /**
     * Setter for <code>divarena_db.spells.ai_target_id</code>.
     */
    public void setAiTargetId(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>divarena_db.spells.ai_target_id</code>.
     */
    public Integer getAiTargetId() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>divarena_db.spells.script_id</code>.
     */
    public void setScriptId(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>divarena_db.spells.script_id</code>.
     */
    public Integer getScriptId() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>divarena_db.spells.use_automatic_description</code>.
     */
    public void setUseAutomaticDescription(Byte value) {
        set(15, value);
    }

    /**
     * Getter for <code>divarena_db.spells.use_automatic_description</code>.
     */
    public Byte getUseAutomaticDescription() {
        return (Byte) get(15);
    }

    /**
     * Setter for <code>divarena_db.spells.criterion</code>.
     */
    public void setCriterion(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>divarena_db.spells.criterion</code>.
     */
    public String getCriterion() {
        return (String) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, String, Integer, Integer, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Integer, Integer, Byte, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    @Override
    public Row17<Integer, String, Integer, Integer, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Byte, Integer, Integer, Byte, String> valuesRow() {
        return (Row17) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Spells.SPELLS.ID;
    }

    @Override
    public Field<String> field2() {
        return Spells.SPELLS.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return Spells.SPELLS.VALUE;
    }

    @Override
    public Field<Integer> field4() {
        return Spells.SPELLS.BREED_ID;
    }

    @Override
    public Field<Byte> field5() {
        return Spells.SPELLS.AP;
    }

    @Override
    public Field<Byte> field6() {
        return Spells.SPELLS.CAST_PER_PLAYER;
    }

    @Override
    public Field<Byte> field7() {
        return Spells.SPELLS.CAST_PER_TURN;
    }

    @Override
    public Field<Byte> field8() {
        return Spells.SPELLS.INTERVAL;
    }

    @Override
    public Field<Byte> field9() {
        return Spells.SPELLS.TEST_LOS;
    }

    @Override
    public Field<Byte> field10() {
        return Spells.SPELLS.TEST_FREE;
    }

    @Override
    public Field<Byte> field11() {
        return Spells.SPELLS.ONLY_LINE;
    }

    @Override
    public Field<Byte> field12() {
        return Spells.SPELLS.RANGE_MIN;
    }

    @Override
    public Field<Byte> field13() {
        return Spells.SPELLS.RANGE_MAX;
    }

    @Override
    public Field<Integer> field14() {
        return Spells.SPELLS.AI_TARGET_ID;
    }

    @Override
    public Field<Integer> field15() {
        return Spells.SPELLS.SCRIPT_ID;
    }

    @Override
    public Field<Byte> field16() {
        return Spells.SPELLS.USE_AUTOMATIC_DESCRIPTION;
    }

    @Override
    public Field<String> field17() {
        return Spells.SPELLS.CRITERION;
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
    public Integer component3() {
        return getValue();
    }

    @Override
    public Integer component4() {
        return getBreedId();
    }

    @Override
    public Byte component5() {
        return getAp();
    }

    @Override
    public Byte component6() {
        return getCastPerPlayer();
    }

    @Override
    public Byte component7() {
        return getCastPerTurn();
    }

    @Override
    public Byte component8() {
        return getInterval();
    }

    @Override
    public Byte component9() {
        return getTestLos();
    }

    @Override
    public Byte component10() {
        return getTestFree();
    }

    @Override
    public Byte component11() {
        return getOnlyLine();
    }

    @Override
    public Byte component12() {
        return getRangeMin();
    }

    @Override
    public Byte component13() {
        return getRangeMax();
    }

    @Override
    public Integer component14() {
        return getAiTargetId();
    }

    @Override
    public Integer component15() {
        return getScriptId();
    }

    @Override
    public Byte component16() {
        return getUseAutomaticDescription();
    }

    @Override
    public String component17() {
        return getCriterion();
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
    public Integer value3() {
        return getValue();
    }

    @Override
    public Integer value4() {
        return getBreedId();
    }

    @Override
    public Byte value5() {
        return getAp();
    }

    @Override
    public Byte value6() {
        return getCastPerPlayer();
    }

    @Override
    public Byte value7() {
        return getCastPerTurn();
    }

    @Override
    public Byte value8() {
        return getInterval();
    }

    @Override
    public Byte value9() {
        return getTestLos();
    }

    @Override
    public Byte value10() {
        return getTestFree();
    }

    @Override
    public Byte value11() {
        return getOnlyLine();
    }

    @Override
    public Byte value12() {
        return getRangeMin();
    }

    @Override
    public Byte value13() {
        return getRangeMax();
    }

    @Override
    public Integer value14() {
        return getAiTargetId();
    }

    @Override
    public Integer value15() {
        return getScriptId();
    }

    @Override
    public Byte value16() {
        return getUseAutomaticDescription();
    }

    @Override
    public String value17() {
        return getCriterion();
    }

    @Override
    public SpellsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public SpellsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public SpellsRecord value3(Integer value) {
        setValue(value);
        return this;
    }

    @Override
    public SpellsRecord value4(Integer value) {
        setBreedId(value);
        return this;
    }

    @Override
    public SpellsRecord value5(Byte value) {
        setAp(value);
        return this;
    }

    @Override
    public SpellsRecord value6(Byte value) {
        setCastPerPlayer(value);
        return this;
    }

    @Override
    public SpellsRecord value7(Byte value) {
        setCastPerTurn(value);
        return this;
    }

    @Override
    public SpellsRecord value8(Byte value) {
        setInterval(value);
        return this;
    }

    @Override
    public SpellsRecord value9(Byte value) {
        setTestLos(value);
        return this;
    }

    @Override
    public SpellsRecord value10(Byte value) {
        setTestFree(value);
        return this;
    }

    @Override
    public SpellsRecord value11(Byte value) {
        setOnlyLine(value);
        return this;
    }

    @Override
    public SpellsRecord value12(Byte value) {
        setRangeMin(value);
        return this;
    }

    @Override
    public SpellsRecord value13(Byte value) {
        setRangeMax(value);
        return this;
    }

    @Override
    public SpellsRecord value14(Integer value) {
        setAiTargetId(value);
        return this;
    }

    @Override
    public SpellsRecord value15(Integer value) {
        setScriptId(value);
        return this;
    }

    @Override
    public SpellsRecord value16(Byte value) {
        setUseAutomaticDescription(value);
        return this;
    }

    @Override
    public SpellsRecord value17(String value) {
        setCriterion(value);
        return this;
    }

    @Override
    public SpellsRecord values(Integer value1, String value2, Integer value3, Integer value4, Byte value5, Byte value6, Byte value7, Byte value8, Byte value9, Byte value10, Byte value11, Byte value12, Byte value13, Integer value14, Integer value15, Byte value16, String value17) {
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
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SpellsRecord
     */
    public SpellsRecord() {
        super(Spells.SPELLS);
    }

    /**
     * Create a detached, initialised SpellsRecord
     */
    public SpellsRecord(Integer id, String name, Integer value, Integer breedId, Byte ap, Byte castPerPlayer, Byte castPerTurn, Byte interval, Byte testLos, Byte testFree, Byte onlyLine, Byte rangeMin, Byte rangeMax, Integer aiTargetId, Integer scriptId, Byte useAutomaticDescription, String criterion) {
        super(Spells.SPELLS);

        set(0, id);
        set(1, name);
        set(2, value);
        set(3, breedId);
        set(4, ap);
        set(5, castPerPlayer);
        set(6, castPerTurn);
        set(7, interval);
        set(8, testLos);
        set(9, testFree);
        set(10, onlyLine);
        set(11, rangeMin);
        set(12, rangeMax);
        set(13, aiTargetId);
        set(14, scriptId);
        set(15, useAutomaticDescription);
        set(16, criterion);
    }
}
