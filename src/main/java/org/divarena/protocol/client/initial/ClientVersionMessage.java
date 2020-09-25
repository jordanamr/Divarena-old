package org.divarena.protocol.client.initial;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;

public class ClientVersionMessage extends Message {

    @Getter
    private byte major;
    @Getter
    private short minor;
    @Getter
    private String buildDate;

    public ClientVersionMessage() {
        this.id = 7;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        this.major = buf.get();
        this.minor = buf.getShort();
        byte buildDateSize = buf.get();
        byte[] buildDate = new byte[buildDateSize];
        buf.get(buildDate);
        this.buildDate = new String(buildDate);
        return true;
    }
}
