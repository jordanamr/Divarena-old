package org.divarena.external;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import org.divarena.database.DivarenaDatabase;
import org.divarena.util.StringUtils;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.divarena.database.generated.tables.CoachCards.COACH_CARDS;
import static org.divarena.database.generated.tables.FighterCards.FIGHTER_CARDS;

public class CardsImporter {

    private static boolean displayOnly = false;
    private static Config config;
    private static DivarenaDatabase database;

    public static void main(String[] args) throws Exception {
        config = ConfigFactory.parseFile(new File("divarena.conf"));
        if (!displayOnly) {
            database = new DivarenaDatabase(config.getString("database.address"), config.getString("database.username"),
                    config.getString("database.password"), config.getString("database.name"), config.getInt("database.poolSize"));
            database.connect();
        }

        I18NReader i18n = new I18NReader();
        ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(Path.of("./data/cards.dat")));
        int coachCardCount = buffer.getInt();
        System.out.println("CoachCard count: " + coachCardCount);
        if (!displayOnly) database.getDsl().truncateTable(COACH_CARDS).execute();
        for (int i = 0; i < coachCardCount; ++i) {
            int cardId = buffer.getInt();
            int cardType = buffer.getInt();
            float[] cardTypeParameters = readFloatArray(buffer);
            int cardValue = buffer.getInt();
            int cardSet = buffer.getInt();
            int cardRequiredLevel = buffer.getInt();
            String cardName = i18n.getString(I18NReader.DataType.COACH_CARD_NAME, "" + cardId);
            System.out.println("----- COACH CARD ID " + cardId + " -----");
            System.out.println("Name: " + cardName);
            System.out.println("Type: " + cardType + " (" + CoachCardType.fromId(cardType).getName() + ")");
            System.out.println("Type Parameters: " + StringUtils.fromFloatArray(cardTypeParameters));
            System.out.println("Value: " + cardValue);
            System.out.println("Set: " + cardSet);
            System.out.println("Required Level: " + cardRequiredLevel);
            if (!displayOnly) database.getDsl().insertInto(COACH_CARDS)
                    .set(COACH_CARDS.ID, cardId)
                    .set(COACH_CARDS.NAME, cardName)
                    .set(COACH_CARDS.TYPE, cardType)
                    .set(COACH_CARDS.TYPE_PARAMETERS, StringUtils.fromFloatArray(cardTypeParameters))
                    .set(COACH_CARDS.VALUE, cardValue)
                    .set(COACH_CARDS.SET, cardSet)
                    .set(COACH_CARDS.REQUIRED_LEVEL, cardRequiredLevel)
                    .execute();
        }
        System.out.println("");
        System.out.println("");
        int fighterCardCount = buffer.getInt();
        System.out.println("FighterCard count: " + coachCardCount);
        if (!displayOnly) database.getDsl().truncateTable(FIGHTER_CARDS).execute();
        for (int i = 0; i < fighterCardCount; ++i) {
            int cardId = buffer.getInt();
            byte cardType = buffer.get();
            byte cardWeaponActionPoints = buffer.get();
            boolean cardOnlyLine = buffer.get() == (byte) 1;
            int cardWeaponRangeMin = buffer.getInt();
            int cardWeaponRangeMax = buffer.getInt();
            boolean cardWeaponTestLos = buffer.get() == (byte) 1;
            boolean cardWeaponTestFreeCell = buffer.get() == (byte) 1;
            int cardValue = buffer.getInt();
            boolean cardWeaponAllowedWhenCarried = buffer.get() == (byte) 1;
            boolean cardWeaponAllowedWhenCarrying = buffer.get() == (byte) 1;
            int cardScriptId = buffer.getInt();
            int cardSubType = buffer.getInt();
            String cardName = i18n.getString(I18NReader.DataType.FIGHTER_CARD_NAME, "" + cardId);
            System.out.println("----- FIGHTER CARD ID " + cardId + " -----");
            System.out.println("Name: " + cardName);
            System.out.println("Type: " + cardType + " (" + FighterCardType.fromIndex(cardType).getDescription() + ")");
            System.out.println("SubType: " + cardSubType + " (" + (cardType == (byte) 1 ? FighterCardSubType.fromId(cardSubType).getName() : "Non representatif") + ")");
            System.out.println("Value: " + cardValue);
            System.out.println("Action Points: " + cardWeaponActionPoints);
            System.out.println("Only Line: " + cardOnlyLine);
            System.out.println("Range Min: " + cardWeaponRangeMin);
            System.out.println("Range Max: " + cardWeaponRangeMax);
            System.out.println("Test Line of Sight: " + cardWeaponTestLos);
            System.out.println("Test Free Cell: " + cardWeaponTestFreeCell);
            System.out.println("Allowed When Carried: " + cardWeaponAllowedWhenCarried);
            System.out.println("Allowed When Carrying: " + cardWeaponAllowedWhenCarrying);
            System.out.println("Script ID: " + cardScriptId);
            if (!displayOnly) database.getDsl().insertInto(FIGHTER_CARDS)
                    .set(FIGHTER_CARDS.ID, cardId)
                    .set(FIGHTER_CARDS.NAME, cardName)
                    .set(FIGHTER_CARDS.TYPE, cardType)
                    .set(FIGHTER_CARDS.SUB_TYPE, cardSubType)
                    .set(FIGHTER_CARDS.VALUE, cardValue)
                    .set(FIGHTER_CARDS.ACTION_POINTS, cardWeaponActionPoints)
                    .set(FIGHTER_CARDS.ONLY_LINE, cardOnlyLine ? (byte) 1 : (byte) 0)
                    .set(FIGHTER_CARDS.RANGE_MIN, cardWeaponRangeMin)
                    .set(FIGHTER_CARDS.RANGE_MAX, cardWeaponRangeMax)
                    .set(FIGHTER_CARDS.TEST_LOS, cardWeaponTestLos ? (byte) 1 : (byte) 0)
                    .set(FIGHTER_CARDS.TEST_FREE, cardWeaponTestFreeCell ? (byte) 1 : (byte) 0)
                    .set(FIGHTER_CARDS.ALLOW_CARRIED, cardWeaponAllowedWhenCarried ? (byte) 1 : (byte) 0)
                    .set(FIGHTER_CARDS.ALLOW_CARRYING, cardWeaponAllowedWhenCarrying ? (byte) 1 : (byte) 0)
                    .set(FIGHTER_CARDS.SCRIPT_ID, cardScriptId)
                    .execute();
        }
        /*System.out.println("");
        System.out.println("");
        int effectCount = buffer.getInt();
        System.out.println("Effect count: " + effectCount);
        for (int i = 0; i < effectCount; ++i) {
            int effectId = buffer.getInt();
            System.out.println(effectId);
            String effectParentType = readString(buffer);
            int effectParentId = buffer.getInt();
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
            int[] effectEndTriggers = null; //TODO Not needed on cards
            boolean affectedByLocalisation = buffer.get() == (byte) 1;
        }*/
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

    public enum CoachCardType {
        SMILEY(0, "Smiley", new short[]{-1}),
        EMOTE(1, "Emote", new short[]{-1}),
        PANT(2, "Culotte", new short[]{5}),
        HAIRS(3, "Coiffure", new short[]{2}),
        TATOO(4, "Tatouages", new short[]{1}),
        ARMBAND(5, "Brassard", new short[]{4, 12}),
        SHOES(6, "Bottes", new short[]{10}),
        SHOULDERPAD(7, "Epaulette", new short[]{3, 13}),
        CLOAK(8, "Cape", new short[]{8}),
        TROUSERS(9, "Pantalon", new short[]{6}),
        SHIRT(10, "Chemise", new short[]{11}),
        HAT(11, "Chapeau", new short[1]),
        SASHIMONO(12, "Bâton", new short[]{7}),
        PET(13, "Familier", new short[]{9}),
        CURSE(14, "Malediction", new short[]{-1}),
        PET_HEART(15, "Familier - Coeur", new short[]{-1}),
        PET_MEMBER(16, "Familier - Membre", new short[]{-1}),
        PET_HEAD(17, "Familier - Tête", new short[]{-1}),
        PET_BODY(18, "Familier - Tronc", new short[]{-1}),
        PET_ACCESSORY(19, "Familier - Accessoire", new short[]{-1}),
        ZAAP(20, "Zaap", new short[]{-1});

        @Getter
        private final int id;
        @Getter
        private final String name;
        @Getter
        private final short[] inventoryPositions;

        CoachCardType(int id, String name, short[] inventoryPositions) {
            this.id = id;
            this.name = name;
            this.inventoryPositions = inventoryPositions;
        }

        public static CoachCardType fromId(int id) {
            return Arrays.stream(CoachCardType.values()).filter(t -> t.getId() == id).findAny().get();
        }
    }

    public enum FighterCardType {
        WEAPON((byte) 1, "Arme", (short) 0),
        PET((byte) 2, "Familier", (short) 1),
        CLOAK((byte) 3, "Cape", (short) 2),
        HAT((byte) 4, "Chapeau", (short) 3),
        DOFUS((byte) 5, "Dofus", (short) 4);

        @Getter
        private final byte index;
        @Getter
        private final String description;
        @Getter
        private final short inventoryPosition;

        FighterCardType(byte index, String description, short inventoryPosition) {
            this.index = index;
            this.description = description;
            this.inventoryPosition = inventoryPosition;
        }

        public static FighterCardType fromIndex(byte index) {
            return Arrays.stream(FighterCardType.values()).filter(t -> t.getIndex() == index).findAny().get();
        }
    }

    public enum FighterCardSubType {
        SWORD(1, "Epee"),
        DAGGER(2, "Dague"),
        BOW(3, "Arc"),
        STAFF(4, "Baguette"),
        STICK(5, "Baton"),
        HAMMER(6, "Marteau"),
        SPADE(7, "Pelle");

        @Getter
        private final int id;
        @Getter
        private final String name;

        FighterCardSubType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static FighterCardSubType fromId(int id) {
            return Arrays.stream(FighterCardSubType.values()).filter(t -> t.getId() == id).findAny().get();
        }
    }
}
