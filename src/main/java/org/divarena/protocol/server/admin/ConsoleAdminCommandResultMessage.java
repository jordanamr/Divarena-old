package org.divarena.protocol.server.admin;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.charset.StandardCharsets;

public @Data class ConsoleAdminCommandResultMessage extends Message {

    private Type type;
    private String message;

    public ConsoleAdminCommandResultMessage() {
        this.id = 102;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(type.getId());
        packet.putShort(message.length());
        packet.putBytes(message.getBytes(StandardCharsets.UTF_8));
        return packet;
    }

    public enum Type {
        TRACE((byte) 0),
        LOG((byte) 1),
        ERROR((byte) 2);

        @Getter
        private final byte id;

        Type(byte id) {
            this.id = id;
        }
    }
}
