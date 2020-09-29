package org.divarena.protocol.client.team;

import org.divarena.protocol.Message;

public class FighterInformationListRequestMessage extends Message {

    public FighterInformationListRequestMessage() {
        this.id = 6005;
    }

    @Override
    public boolean decode(byte[] data) {
        return true;
    }
}
