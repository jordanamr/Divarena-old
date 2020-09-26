package org.divarena.protocol.server.chat;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

import java.nio.charset.StandardCharsets;

public @Data class UserNotFoundMessage extends Message {

    private String username;

    public UserNotFoundMessage(String username) {
        this.id = 3204;
        this.username = username;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        byte[] username = this.username.getBytes(StandardCharsets.UTF_8);
        packet.putByte(username.length);
        packet.putBytes(username);
        return packet;
    }
}
