package org.divarena.protocol.client.chat;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UserPrivateContentMessage extends Message {

    @Getter
    private String username;
    @Getter
    private String messageContent;

    public UserPrivateContentMessage() {
        this.id = 3155;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);

        byte[] username = new byte[buf.get()];
        buf.get(username);
        this.username = new String(username, StandardCharsets.UTF_8);

        byte[] messageContent = new byte[buf.get()];
        buf.get(messageContent);
        this.messageContent = new String(messageContent, StandardCharsets.UTF_8);

        return true;
    }
}
