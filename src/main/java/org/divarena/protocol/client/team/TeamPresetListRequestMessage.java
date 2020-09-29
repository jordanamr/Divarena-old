package org.divarena.protocol.client.team;

import org.divarena.protocol.Message;

public class TeamPresetListRequestMessage extends Message {

    public TeamPresetListRequestMessage() {
        this.id = 6031;
    }

    @Override
    public boolean decode(byte[] data) {
        return true;
    }
}
