package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class CoachCreationRequestMessage extends Message {

    public CoachCreationRequestMessage() {
        this.id = 2048;
    }

    @Override
    public Packet encode() {
        return Packet.builder();
    }
}
