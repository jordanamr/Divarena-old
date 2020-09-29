/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Spells implements Serializable {

    private static final long serialVersionUID = -1260595839;

    private Integer id;
    private String  name;
    private Integer value;
    private Integer breedId;
    private Byte    ap;
    private Byte    castPerPlayer;
    private Byte    castPerTurn;
    private Byte    interval;
    private Byte    testLos;
    private Byte    testFree;
    private Byte    onlyLine;
    private Byte    rangeMin;
    private Byte    rangeMax;
    private Integer aiTargetId;
    private Integer scriptId;
    private Byte    useAutomaticDescription;
    private String  criterion;

    public Spells() {}

    public Spells(Spells value) {
        this.id = value.id;
        this.name = value.name;
        this.value = value.value;
        this.breedId = value.breedId;
        this.ap = value.ap;
        this.castPerPlayer = value.castPerPlayer;
        this.castPerTurn = value.castPerTurn;
        this.interval = value.interval;
        this.testLos = value.testLos;
        this.testFree = value.testFree;
        this.onlyLine = value.onlyLine;
        this.rangeMin = value.rangeMin;
        this.rangeMax = value.rangeMax;
        this.aiTargetId = value.aiTargetId;
        this.scriptId = value.scriptId;
        this.useAutomaticDescription = value.useAutomaticDescription;
        this.criterion = value.criterion;
    }

    public Spells(
        Integer id,
        String  name,
        Integer value,
        Integer breedId,
        Byte    ap,
        Byte    castPerPlayer,
        Byte    castPerTurn,
        Byte    interval,
        Byte    testLos,
        Byte    testFree,
        Byte    onlyLine,
        Byte    rangeMin,
        Byte    rangeMax,
        Integer aiTargetId,
        Integer scriptId,
        Byte    useAutomaticDescription,
        String  criterion
    ) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.breedId = breedId;
        this.ap = ap;
        this.castPerPlayer = castPerPlayer;
        this.castPerTurn = castPerTurn;
        this.interval = interval;
        this.testLos = testLos;
        this.testFree = testFree;
        this.onlyLine = onlyLine;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.aiTargetId = aiTargetId;
        this.scriptId = scriptId;
        this.useAutomaticDescription = useAutomaticDescription;
        this.criterion = criterion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getBreedId() {
        return this.breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    public Byte getAp() {
        return this.ap;
    }

    public void setAp(Byte ap) {
        this.ap = ap;
    }

    public Byte getCastPerPlayer() {
        return this.castPerPlayer;
    }

    public void setCastPerPlayer(Byte castPerPlayer) {
        this.castPerPlayer = castPerPlayer;
    }

    public Byte getCastPerTurn() {
        return this.castPerTurn;
    }

    public void setCastPerTurn(Byte castPerTurn) {
        this.castPerTurn = castPerTurn;
    }

    public Byte getInterval() {
        return this.interval;
    }

    public void setInterval(Byte interval) {
        this.interval = interval;
    }

    public Byte getTestLos() {
        return this.testLos;
    }

    public void setTestLos(Byte testLos) {
        this.testLos = testLos;
    }

    public Byte getTestFree() {
        return this.testFree;
    }

    public void setTestFree(Byte testFree) {
        this.testFree = testFree;
    }

    public Byte getOnlyLine() {
        return this.onlyLine;
    }

    public void setOnlyLine(Byte onlyLine) {
        this.onlyLine = onlyLine;
    }

    public Byte getRangeMin() {
        return this.rangeMin;
    }

    public void setRangeMin(Byte rangeMin) {
        this.rangeMin = rangeMin;
    }

    public Byte getRangeMax() {
        return this.rangeMax;
    }

    public void setRangeMax(Byte rangeMax) {
        this.rangeMax = rangeMax;
    }

    public Integer getAiTargetId() {
        return this.aiTargetId;
    }

    public void setAiTargetId(Integer aiTargetId) {
        this.aiTargetId = aiTargetId;
    }

    public Integer getScriptId() {
        return this.scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public Byte getUseAutomaticDescription() {
        return this.useAutomaticDescription;
    }

    public void setUseAutomaticDescription(Byte useAutomaticDescription) {
        this.useAutomaticDescription = useAutomaticDescription;
    }

    public String getCriterion() {
        return this.criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Spells (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(value);
        sb.append(", ").append(breedId);
        sb.append(", ").append(ap);
        sb.append(", ").append(castPerPlayer);
        sb.append(", ").append(castPerTurn);
        sb.append(", ").append(interval);
        sb.append(", ").append(testLos);
        sb.append(", ").append(testFree);
        sb.append(", ").append(onlyLine);
        sb.append(", ").append(rangeMin);
        sb.append(", ").append(rangeMax);
        sb.append(", ").append(aiTargetId);
        sb.append(", ").append(scriptId);
        sb.append(", ").append(useAutomaticDescription);
        sb.append(", ").append(criterion);

        sb.append(")");
        return sb.toString();
    }
}
