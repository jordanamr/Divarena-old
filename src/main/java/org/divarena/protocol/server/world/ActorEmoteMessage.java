package org.divarena.protocol.server.world;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

import java.nio.charset.StandardCharsets;

public @Data class ActorEmoteMessage extends Message {

    private long coachId;
    private String emote;

    public ActorEmoteMessage() {
        this.id = 4700;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putLong(coachId);
        byte[] emoteArr = emote.getBytes(StandardCharsets.UTF_8);
        packet.putByte(emoteArr.length);
        packet.putBytes(emoteArr);
        return packet;
    }
}
