package org.divarena.protocol.server.team;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class FighterInformationListMessage extends Message {

    public FighterInformationListMessage() {
        this.id = 6006;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(0);
        return packet;
    }
}
