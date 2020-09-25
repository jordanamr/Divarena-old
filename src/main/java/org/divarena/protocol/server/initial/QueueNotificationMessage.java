package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class QueueNotificationMessage extends Message {

    private int position = -1;

    public QueueNotificationMessage() {
        this.id = 8192;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putInt(position);
        return packet;
    }
}
