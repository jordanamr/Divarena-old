package org.divarena.protocol;

import com.github.simplenet.packet.Packet;
import lombok.Getter;

public abstract class Message {

    @Getter
    protected short id;

    public Packet encode() {
        throw new UnsupportedOperationException();
    }

    protected boolean decode(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
