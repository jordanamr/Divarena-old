package org.divarena.protocol.client.initial;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;

public class CoachCreationMessage extends Message {

    @Getter
    private String name;
    @Getter
    private byte skinColorIndex;
    @Getter
    private byte hairColorIndex;
    @Getter
    private byte sex;

    public CoachCreationMessage() {
        this.id = 2049;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte nameSize = buf.get();
        byte[] name = new byte[nameSize];
        buf.get(name);
        this.name = new String(name);
        this.skinColorIndex = buf.get();
        this.hairColorIndex = buf.get();
        this.sex = buf.get();
        return true;
    }
}
