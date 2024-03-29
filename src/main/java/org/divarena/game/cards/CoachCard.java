package org.divarena.game.cards;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

public class CoachCard extends AbstractCard {

    @Getter
    private final float[] typeParameters;
    @Getter
    private final int requiredLevel;
    @Getter @Setter
    private long uid;
    @Getter @Setter
    private byte flags;


    public CoachCard(int id, String name, int type, int value, float[] typeParameters, int requiredLevel) {
        super(id, name, type, value);
        this.typeParameters = typeParameters;
        this.requiredLevel = requiredLevel;
    }

    public byte[] serialize() {
        ByteBuffer buffer = ByteBuffer.allocate(13);
        buffer.putInt(id);
        buffer.putLong(uid);
        buffer.put(flags);
        return buffer.array();
    }

    public CoachCard clone() {
        return new CoachCard(id, name, type, value, typeParameters, requiredLevel);
    }
}
