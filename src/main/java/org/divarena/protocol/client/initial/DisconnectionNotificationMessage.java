package org.divarena.protocol.client.initial;

import org.divarena.protocol.Message;

public class DisconnectionNotificationMessage extends Message {

    public DisconnectionNotificationMessage() {
        this.id = 1;
    }

    @Override
    public boolean decode(byte[] data) {
        return true;
    }
}
