package org.divarena.game;

import org.divarena.Divarena;
import org.divarena.game.cards.CoachCard;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoachInventory {

    private final Map<CoachCard, Short> contents;

    public CoachInventory(byte[] inventory) {
        this.contents = Collections.synchronizedMap(new HashMap<>());
        deserialize(inventory);
    }

    public void add(CoachCard card) {
        contents.put(card, (short) 1);
    }

    public void remove(CoachCard card) {
        contents.remove(card);
    }

    private void deserialize(byte[] inventory) {
        ByteBuffer buffer = ByteBuffer.wrap(inventory);
        while (buffer.hasRemaining()) {
            int id = buffer.getInt();
            long uid = buffer.getLong();
            byte flags = buffer.get();
            short quantity = buffer.getShort();
            CoachCard card = Divarena.getInstance().getNewCoachCard(id);
            card.setUid(uid);
            card.setFlags(flags);
            contents.put(card, quantity);
        }
    }

    public byte[] serialize() {
        ByteBuffer buffer = ByteBuffer.allocate(contents.size() * 15);
        contents.forEach((card, quantity) -> {
            buffer.putInt(card.getId());
            buffer.putLong(card.getUid());
            buffer.put(card.getFlags());
            buffer.putShort(quantity);
        });
        return buffer.array();
    }
}
