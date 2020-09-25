package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import org.divarena.protocol.Message;

public class CoachCreationRequestMessage extends Message {

    public CoachCreationRequestMessage() {
        this.id = 2048;
    }

    @Override
    public Packet encode() {
        return Packet.builder();
    }
}
