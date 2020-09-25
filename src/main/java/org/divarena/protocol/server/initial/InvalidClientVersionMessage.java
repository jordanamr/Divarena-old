package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class InvalidClientVersionMessage extends Message {

    private byte requiredMajor;
    private short requiredMinor;

    public InvalidClientVersionMessage() {
        this.id = 8;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(requiredMajor);
        packet.putShort(requiredMinor);
        return packet;
    }
}
