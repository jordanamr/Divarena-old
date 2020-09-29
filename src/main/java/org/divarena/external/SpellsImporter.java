package org.divarena.external;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.divarena.database.DivarenaDatabase;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.divarena.database.generated.tables.Spells.SPELLS;

public class SpellsImporter {

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
        database.getDsl().truncateTable(SPELLS).execute();
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
            database.getDsl().insertInto(SPELLS)
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
        for (int i = 0; i < effectCount; ++i) {
            int effectId = buffer.getInt();
            String effectParentType = readString(buffer);
            int effectParentId = buffer.getInt();
            short ___UNUSED___ = buffer.getShort(); //TODO Unused ?
            System.out.println("Effect ID: " + effectId + " Unused: " + ___UNUSED___);
            int[] effectDuration = readIntArray(buffer);
            int effectActionId = buffer.getInt();
            boolean effectIsCritical = buffer.get() == (byte) 1;
            float[] effectParams = readFloatArray(buffer);
            short effectAreaShape = buffer.getShort();
            int[] effectAreaSize = readIntArray(buffer);
            int[] effectTargets = readIntArray(buffer);
            int[] effectTriggersAfter = readIntArray(buffer);
            int[] effectTriggersBefore = readIntArray(buffer);
            int[] effectEndTriggers = null; //TODO Not needed on cards
            boolean affectedByLocalisation = buffer.get() == (byte) 1;
        }
        //TODO La flemme bordel de merde je suis fatigué et dépressif
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
