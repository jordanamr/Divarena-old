/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.records;


import org.divarena.database.generated.tables.Effects;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EffectsRecord extends UpdatableRecordImpl<EffectsRecord> implements Record14<Integer, String, Integer, String, Integer, Byte, String, Short, String, String, String, String, String, Byte> {

    private static final long serialVersionUID = 1583931485;

    /**
     * Setter for <code>divarena_db.effects.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>divarena_db.effects.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>divarena_db.effects.parent_type</code>.
     */
    public void setParentType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>divarena_db.effects.parent_type</code>.
     */
    public String getParentType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>divarena_db.effects.parent_id</code>.
     */
    public void setParentId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>divarena_db.effects.parent_id</code>.
     */
    public Integer getParentId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>divarena_db.effects.duration</code>.
     */
    public void setDuration(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>divarena_db.effects.duration</code>.
     */
    public String getDuration() {
        return (String) get(3);
    }

    /**
     * Setter for <code>divarena_db.effects.action_id</code>.
     */
    public void setActionId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>divarena_db.effects.action_id</code>.
     */
    public Integer getActionId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>divarena_db.effects.critical</code>.
     */
    public void setCritical(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>divarena_db.effects.critical</code>.
     */
    public Byte getCritical() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>divarena_db.effects.params</code>.
     */
    public void setParams(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>divarena_db.effects.params</code>.
     */
    public String getParams() {
        return (String) get(6);
    }

    /**
     * Setter for <code>divarena_db.effects.area_shape</code>.
     */
    public void setAreaShape(Short value) {
        set(7, value);
    }

    /**
     * Getter for <code>divarena_db.effects.area_shape</code>.
     */
    public Short getAreaShape() {
        return (Short) get(7);
    }

    /**
     * Setter for <code>divarena_db.effects.area_size</code>.
     */
    public void setAreaSize(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>divarena_db.effects.area_size</code>.
     */
    public String getAreaSize() {
        return (String) get(8);
    }

    /**
     * Setter for <code>divarena_db.effects.targets</code>.
     */
    public void setTargets(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>divarena_db.effects.targets</code>.
     */
    public String getTargets() {
        return (String) get(9);
    }

    /**
     * Setter for <code>divarena_db.effects.triggers_after</code>.
     */
    public void setTriggersAfter(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>divarena_db.effects.triggers_after</code>.
     */
    public String getTriggersAfter() {
        return (String) get(10);
    }

    /**
     * Setter for <code>divarena_db.effects.triggers_before</code>.
     */
    public void setTriggersBefore(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>divarena_db.effects.triggers_before</code>.
     */
    public String getTriggersBefore() {
        return (String) get(11);
    }

    /**
     * Setter for <code>divarena_db.effects.end_triggers</code>.
     */
    public void setEndTriggers(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>divarena_db.effects.end_triggers</code>.
     */
    public String getEndTriggers() {
        return (String) get(12);
    }

    /**
     * Setter for <code>divarena_db.effects.affected_by_localisation</code>.
     */
    public void setAffectedByLocalisation(Byte value) {
        set(13, value);
    }

    /**
     * Getter for <code>divarena_db.effects.affected_by_localisation</code>.
     */
    public Byte getAffectedByLocalisation() {
        return (Byte) get(13);
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
    public Row14<Integer, String, Integer, String, Integer, Byte, String, Short, String, String, String, String, String, Byte> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<Integer, String, Integer, String, Integer, Byte, String, Short, String, String, String, String, String, Byte> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Effects.EFFECTS.ID;
    }

    @Override
    public Field<String> field2() {
        return Effects.EFFECTS.PARENT_TYPE;
    }

    @Override
    public Field<Integer> field3() {
        return Effects.EFFECTS.PARENT_ID;
    }

    @Override
    public Field<String> field4() {
        return Effects.EFFECTS.DURATION;
    }

    @Override
    public Field<Integer> field5() {
        return Effects.EFFECTS.ACTION_ID;
    }

    @Override
    public Field<Byte> field6() {
        return Effects.EFFECTS.CRITICAL;
    }

    @Override
    public Field<String> field7() {
        return Effects.EFFECTS.PARAMS;
    }

    @Override
    public Field<Short> field8() {
        return Effects.EFFECTS.AREA_SHAPE;
    }

    @Override
    public Field<String> field9() {
        return Effects.EFFECTS.AREA_SIZE;
    }

    @Override
    public Field<String> field10() {
        return Effects.EFFECTS.TARGETS;
    }

    @Override
    public Field<String> field11() {
        return Effects.EFFECTS.TRIGGERS_AFTER;
    }

    @Override
    public Field<String> field12() {
        return Effects.EFFECTS.TRIGGERS_BEFORE;
    }

    @Override
    public Field<String> field13() {
        return Effects.EFFECTS.END_TRIGGERS;
    }

    @Override
    public Field<Byte> field14() {
        return Effects.EFFECTS.AFFECTED_BY_LOCALISATION;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getParentType();
    }

    @Override
    public Integer component3() {
        return getParentId();
    }

    @Override
    public String component4() {
        return getDuration();
    }

    @Override
    public Integer component5() {
        return getActionId();
    }

    @Override
    public Byte component6() {
        return getCritical();
    }

    @Override
    public String component7() {
        return getParams();
    }

    @Override
    public Short component8() {
        return getAreaShape();
    }

    @Override
    public String component9() {
        return getAreaSize();
    }

    @Override
    public String component10() {
        return getTargets();
    }

    @Override
    public String component11() {
        return getTriggersAfter();
    }

    @Override
    public String component12() {
        return getTriggersBefore();
    }

    @Override
    public String component13() {
        return getEndTriggers();
    }

    @Override
    public Byte component14() {
        return getAffectedByLocalisation();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getParentType();
    }

    @Override
    public Integer value3() {
        return getParentId();
    }

    @Override
    public String value4() {
        return getDuration();
    }

    @Override
    public Integer value5() {
        return getActionId();
    }

    @Override
    public Byte value6() {
        return getCritical();
    }

    @Override
    public String value7() {
        return getParams();
    }

    @Override
    public Short value8() {
        return getAreaShape();
    }

    @Override
    public String value9() {
        return getAreaSize();
    }

    @Override
    public String value10() {
        return getTargets();
    }

    @Override
    public String value11() {
        return getTriggersAfter();
    }

    @Override
    public String value12() {
        return getTriggersBefore();
    }

    @Override
    public String value13() {
        return getEndTriggers();
    }

    @Override
    public Byte value14() {
        return getAffectedByLocalisation();
    }

    @Override
    public EffectsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public EffectsRecord value2(String value) {
        setParentType(value);
        return this;
    }

    @Override
    public EffectsRecord value3(Integer value) {
        setParentId(value);
        return this;
    }

    @Override
    public EffectsRecord value4(String value) {
        setDuration(value);
        return this;
    }

    @Override
    public EffectsRecord value5(Integer value) {
        setActionId(value);
        return this;
    }

    @Override
    public EffectsRecord value6(Byte value) {
        setCritical(value);
        return this;
    }

    @Override
    public EffectsRecord value7(String value) {
        setParams(value);
        return this;
    }

    @Override
    public EffectsRecord value8(Short value) {
        setAreaShape(value);
        return this;
    }

    @Override
    public EffectsRecord value9(String value) {
        setAreaSize(value);
        return this;
    }

    @Override
    public EffectsRecord value10(String value) {
        setTargets(value);
        return this;
    }

    @Override
    public EffectsRecord value11(String value) {
        setTriggersAfter(value);
        return this;
    }

    @Override
    public EffectsRecord value12(String value) {
        setTriggersBefore(value);
        return this;
    }

    @Override
    public EffectsRecord value13(String value) {
        setEndTriggers(value);
        return this;
    }

    @Override
    public EffectsRecord value14(Byte value) {
        setAffectedByLocalisation(value);
        return this;
    }

    @Override
    public EffectsRecord values(Integer value1, String value2, Integer value3, String value4, Integer value5, Byte value6, String value7, Short value8, String value9, String value10, String value11, String value12, String value13, Byte value14) {
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
     * Create a detached EffectsRecord
     */
    public EffectsRecord() {
        super(Effects.EFFECTS);
    }

    /**
     * Create a detached, initialised EffectsRecord
     */
    public EffectsRecord(Integer id, String parentType, Integer parentId, String duration, Integer actionId, Byte critical, String params, Short areaShape, String areaSize, String targets, String triggersAfter, String triggersBefore, String endTriggers, Byte affectedByLocalisation) {
        super(Effects.EFFECTS);

        set(0, id);
        set(1, parentType);
        set(2, parentId);
        set(3, duration);
        set(4, actionId);
        set(5, critical);
        set(6, params);
        set(7, areaShape);
        set(8, areaSize);
        set(9, targets);
        set(10, triggersAfter);
        set(11, triggersBefore);
        set(12, endTriggers);
        set(13, affectedByLocalisation);
    }
}
