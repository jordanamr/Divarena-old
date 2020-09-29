package org.divarena.game.teams;

import lombok.Data;

import java.nio.ByteBuffer;

public @Data class Fighter {

    private long uid;
    private byte breedId;
    private String name;
    private byte skinIndex;
    private byte sex;
    private byte[] spellsInventory = new byte[6]; //TODO
    private byte[] cardsInventory = new byte[5]; //TODO
    private short budget;

    public void deserialize(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte version = buf.get(); //FighterInformation model version - SHOULD BE 1 ON 2.04
        budget = buf.getShort();
        breedId = buf.get();
        byte[] nameArr = new byte[buf.get()];
        buf.get(nameArr);
        name = new String(nameArr);
        sex = buf.get();
        skinIndex = buf.get();

        // Optional - Spells Inventory
        byte[] spellsInventoryArr = new byte[buf.getShort()];
        if (spellsInventoryArr.length != 0) {
            buf.get(spellsInventoryArr);
            //TODO Unserialize spells inventory
        }

        // Optional - Cards Inventory
        byte[] cardsInventoryArr = new byte[buf.getShort()];
        if (cardsInventoryArr.length != 0) {
            buf.get(cardsInventoryArr);
            //TODO Unserialize cards inventory
        }
    }

    public byte[] serialize() {
        byte[] nameArr = name.getBytes();

        ByteBuffer buf = ByteBuffer.allocate(11 + nameArr.length + spellsInventory.length + cardsInventory.length);
        buf.put((byte) 1); // Model version
        buf.putShort(budget);
        buf.put(breedId);
        buf.put((byte) nameArr.length);
        buf.put(nameArr);
        buf.put(sex);
        buf.put(skinIndex);

        buf.putShort((short) spellsInventory.length);
        buf.put(spellsInventory);

        buf.putShort((short) cardsInventory.length);
        buf.put(cardsInventory);

        return buf.array();
    }
}
