package org.divarena.external;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.divarena.database.DivarenaDatabase;
import org.divarena.util.StringUtils;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.divarena.database.generated.tables.Effects.EFFECTS;
import static org.divarena.database.generated.tables.Spells.SPELLS;

public class SpellsImporter {

    private static boolean displayOnly = false;
    private static Config config;
    private static DivarenaDatabase database;

    public static void main(String[] args) throws Exception {
        config = ConfigFactory.parseFile(new File("divarena.conf"));
        database = new DivarenaDatabase(config.getString("database.address"), config.getString("database.username"),
                config.getString("database.password"), config.getString("database.name"), config.getInt("database.poolSize"));
        database.connect();

        I18NReader i18n = new I18NReader();
        ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(Path.of("./data/spells.dat")));
        int spellsCount = buffer.getInt();
        System.out.println("Spell count: " + spellsCount);
        if (!displayOnly) database.getDsl().truncateTable(SPELLS).execute();
        for (int i = 0; i < spellsCount; ++i) {
            int spellId = buffer.getInt();
            byte spellActionPoints = buffer.get();
            byte spellCastFrequencyMaxPerPlayer = buffer.get();
            byte spellCastFrequencyMaxPerTurn = buffer.get();
            byte spellCastFrequencyMinInterval = buffer.get();
            boolean spellCastTestLos = buffer.get() == (byte) 1;
            boolean spellCastOnlyLine = buffer.get() == (byte) 1;
            byte spellCastRangeMin = buffer.get();
            byte spellCastRangeMax = buffer.get();
            int spellValue = buffer.getInt();
            int spellAiTargetId = buffer.getInt();
            boolean testFreeCell = buffer.get() == (byte) 1;
            int spellScriptId = buffer.getInt();
            int breedId = buffer.getInt();
            String criterionString = readString(buffer);
            boolean useAutomaticDescription = buffer.get() == (byte) 1;
            String spellName = i18n.getString(I18NReader.DataType.SPELL_NAME, "" + spellId);
            System.out.println("----- SPELL ID " + spellId + " -----");
            System.out.println("Name: " + spellName);
            System.out.println("AP: " + spellActionPoints);
            System.out.println("Player Frequency: " + spellCastFrequencyMaxPerPlayer);
            System.out.println("Turn Frequency: " + spellCastFrequencyMaxPerTurn);
            System.out.println("Min Interval: " + spellCastFrequencyMinInterval);
            System.out.println("Test LOS: " + spellCastTestLos);
            System.out.println("Only Line: " + spellCastOnlyLine);
            System.out.println("Range Min: " + spellCastRangeMin);
            System.out.println("Range Max: " + spellCastRangeMax);
            System.out.println("Value: " + spellValue);
            System.out.println("AI Target ID: " + spellAiTargetId);
            System.out.println("Test Free Cell: " + testFreeCell);
            System.out.println("Script ID: " + spellScriptId);
            System.out.println("Breed ID: " + breedId);
            System.out.println("Criterion: " + criterionString);
            System.out.println("Automatic Description: " + useAutomaticDescription);
            if (!displayOnly) database.getDsl().insertInto(SPELLS)
                    .set(SPELLS.ID, spellId)
                    .set(SPELLS.NAME, spellName)
                    .set(SPELLS.AP, spellActionPoints)
                    .set(SPELLS.CAST_PER_PLAYER, spellCastFrequencyMaxPerPlayer)
                    .set(SPELLS.CAST_PER_TURN, spellCastFrequencyMaxPerTurn)
                    .set(SPELLS.INTERVAL, spellCastFrequencyMinInterval)
                    .set(SPELLS.TEST_LOS, spellCastTestLos ? (byte) 1 : (byte) 0)
                    .set(SPELLS.ONLY_LINE, spellCastOnlyLine ? (byte) 1 : (byte) 0)
                    .set(SPELLS.RANGE_MIN, spellCastRangeMin)
                    .set(SPELLS.RANGE_MAX, spellCastRangeMax)
                    .set(SPELLS.VALUE, spellValue)
                    .set(SPELLS.AI_TARGET_ID, spellAiTargetId)
                    .set(SPELLS.TEST_FREE, testFreeCell ? (byte) 1 : (byte) 0)
                    .set(SPELLS.SCRIPT_ID, spellScriptId)
                    .set(SPELLS.BREED_ID, breedId)
                    .set(SPELLS.CRITERION, criterionString)
                    .set(SPELLS.USE_AUTOMATIC_DESCRIPTION, useAutomaticDescription ? (byte) 1 : (byte) 0)
                    .execute();
        }
        System.out.println("");
        System.out.println("");
        int effectCount = buffer.getInt();
        System.out.println("Effect count: " + effectCount);
        for (int i = 0; i < effectCount; ++i) { // Buffer - EffectContentDocumentLoader
            int effectId = buffer.getInt(); // Effect ID
            String effectParentType = readString(buffer); // Effect Parent type (trigger?) enum
            int effectParentId = buffer.getInt(); // Parent ID (card ID in this case)
            short ___UNUSED___ = buffer.getShort(); //TODO Unused ?
            int[] effectDuration = readIntArray(buffer);
            int effectActionId = buffer.getInt();
            boolean effectIsCritical = buffer.get() == (byte) 1;
            float[] effectParams = readFloatArray(buffer);
            short effectAreaShape = buffer.getShort();
            int[] effectAreaSize = readIntArray(buffer);
            int[] effectTargets = readIntArray(buffer);
            int[] effectTriggersAfter = readIntArray(buffer);
            int[] effectTriggersBefore = readIntArray(buffer);
            int[] effectEndTriggers = null; //TODO Unused ?
            boolean affectedByLocalisation = buffer.get() == (byte) 1;
            System.out.println("----- EFFECT ID " + effectId + " -----");
            System.out.println("Parent Type: " + effectParentType);
            System.out.println("Parent ID: " + effectParentId);
            System.out.println("Duration: " + Arrays.toString(effectDuration));
            System.out.println("Action ID: " + effectActionId);
            System.out.println("Is Critical: " + effectIsCritical);
            System.out.println("Params: " + Arrays.toString(effectParams));
            System.out.println("Area Shape: " + effectAreaShape);
            System.out.println("Area Size: " + Arrays.toString(effectAreaSize));
            System.out.println("Targets: " + Arrays.toString(effectTargets));
            System.out.println("Triggers After: " + Arrays.toString(effectTriggersAfter));
            System.out.println("Triggers Before: " + Arrays.toString(effectTriggersBefore));
            System.out.println("End Triggers: " + Arrays.toString(effectEndTriggers));
            System.out.println("Affected By Localisation: " + affectedByLocalisation);
            if (!displayOnly) database.getDsl().insertInto(EFFECTS)
                    .set(EFFECTS.ID, effectId)
                    .set(EFFECTS.PARENT_TYPE, effectParentType)
                    .set(EFFECTS.PARENT_ID, effectParentId)
                    .set(EFFECTS.DURATION, StringUtils.fromIntArray(effectDuration))
                    .set(EFFECTS.ACTION_ID, effectActionId)
                    .set(EFFECTS.CRITICAL, effectIsCritical ? (byte) 1 : (byte) 0)
                    .set(EFFECTS.PARAMS, StringUtils.fromFloatArray(effectParams))
                    .set(EFFECTS.AREA_SHAPE, effectAreaShape)
                    .set(EFFECTS.AREA_SIZE, StringUtils.fromIntArray(effectAreaSize))
                    .set(EFFECTS.TARGETS, StringUtils.fromIntArray(effectTargets))
                    .set(EFFECTS.TRIGGERS_AFTER, StringUtils.fromIntArray(effectTriggersAfter))
                    .set(EFFECTS.TRIGGERS_BEFORE, StringUtils.fromIntArray(effectTriggersBefore))
                    .set(EFFECTS.END_TRIGGERS, StringUtils.fromIntArray(effectEndTriggers))
                    .set(EFFECTS.AFFECTED_BY_LOCALISATION, affectedByLocalisation ? (byte) 1 : (byte) 0)
                    .execute();
        }
    }

    private static String readString(ByteBuffer buffer) {
        byte[] strArr = new byte[buffer.getInt()];
        buffer.get(strArr);
        return new String(strArr, StandardCharsets.UTF_8);
    }

    private static int[] readIntArray(ByteBuffer buffer) {
        int intArrLength = buffer.getInt();
        int[] intArr = new int[intArrLength];
        for (int i = 0; i < intArrLength; ++i) {
            intArr[i] = buffer.getInt();
        }
        return intArr;
    }

    private static float[] readFloatArray(ByteBuffer buffer) {
        int floatArrLength = buffer.getInt();
        float[] floatArr = new float[floatArrLength];
        for (int i = 0; i < floatArrLength; ++i) {
            floatArr[i] = buffer.getFloat();
        }
        return floatArr;
    }
}
