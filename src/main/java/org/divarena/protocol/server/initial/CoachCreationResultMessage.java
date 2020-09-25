package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import org.divarena.protocol.Message;

public @Data class CoachCreationResultMessage extends Message {

    private byte resultCode;

    public CoachCreationResultMessage() {
        this.id = 2050;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(resultCode);
        return packet;
    }

    public enum ResultCode {
        SUCCESS((byte) 0),
        INVALID_NAME((byte) 12),
        ERROR((byte) 13);

        @Getter
        private final byte code;

        ResultCode(byte code) {
            this.code = code;
        }
    }
}
