package org.divarena.protocol.client.world;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class CoachActorEmoteRequestMessage extends Message {

    @Getter
    private String emote;
    @Getter
    private int cardId;

    public CoachActorEmoteRequestMessage() {
        this.id = 4701;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte[] emoteArr = new byte[buf.get()];
        buf.get(emoteArr);
        emote = new String(emoteArr, StandardCharsets.UTF_8);
        cardId = buf.getInt();
        return true;
    }
}
