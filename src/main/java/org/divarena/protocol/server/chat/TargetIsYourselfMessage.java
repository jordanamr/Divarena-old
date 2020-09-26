package org.divarena.protocol.server.chat;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class TargetIsYourselfMessage extends Message {

    public TargetIsYourselfMessage() {
        this.id = 3214;
    }

    @Override
    public Packet encode() {
        return Packet.builder();
    }
}
