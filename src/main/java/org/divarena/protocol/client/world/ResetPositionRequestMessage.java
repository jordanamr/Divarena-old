package org.divarena.protocol.client.world;

import org.divarena.protocol.Message;

public class ResetPositionRequestMessage extends Message {

    //TODO ???????
    public ResetPositionRequestMessage() {
        this.id = 4514;
    }

    @Override
    public boolean decode(byte[] data) {
        return true;
    }
}
