package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import org.divarena.protocol.Message;

public @Data class ClientAuthenticationResultsMessage extends Message {

    private byte resultCode;

    public ClientAuthenticationResultsMessage() {
        this.id = 1024;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(resultCode);
        return packet;
    }

    public enum ResultCode {
        SUCCESS((byte) 0),
        INVALID_LOGIN((byte) 1),
        ALREADY_CONNECTED((byte) 3),
        SAVE_IN_PROGRESS((byte) 4),
        CLOSED_BETA((byte) 127);

        @Getter
        private final byte code;

        ResultCode(byte code) {
            this.code = code;
        }
    }
}
