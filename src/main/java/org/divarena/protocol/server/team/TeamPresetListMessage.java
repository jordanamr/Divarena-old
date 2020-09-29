package org.divarena.protocol.server.team;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class TeamPresetListMessage extends Message {

    public TeamPresetListMessage() {
        this.id = 6030;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(0);
        return packet;
    }
}
