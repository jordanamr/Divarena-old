package org.divarena.protocol.client.chat;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UserVicinityContentMessage extends Message {

    @Getter
    private String message;

    public UserVicinityContentMessage() {
        this.id = 3153;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte[] message = new byte[buf.getShort()];
        buf.get(message);
        this.message = new String(message, StandardCharsets.UTF_8);
        return true;
    }
}
