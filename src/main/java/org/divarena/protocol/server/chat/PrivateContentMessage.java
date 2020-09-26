package org.divarena.protocol.server.chat;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

import java.nio.charset.StandardCharsets;

public @Data class PrivateContentMessage extends Message {

    private String memberTalking;
    private long memberID;
    private String messageContent;

    public PrivateContentMessage() {
        this.id = 3154;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();

        byte[] memberTalking = this.memberTalking.getBytes(StandardCharsets.UTF_8);
        packet.putByte(memberTalking.length);
        packet.putBytes(memberTalking);

        packet.putLong(memberID);

        byte[] messageContent = this.messageContent.getBytes(StandardCharsets.UTF_8);
        packet.putByte(messageContent.length);
        packet.putBytes(messageContent);

        return packet;
    }
}
