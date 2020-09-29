package org.divarena.protocol.client.team;

import lombok.Getter;
import org.divarena.game.teams.Fighter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;

public class CreateFighterInformationRequestMessage extends Message {

    @Getter
    public Fighter fighterInformation;

    public CreateFighterInformationRequestMessage() {
        this.id = 6001;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer dataBuf = ByteBuffer.wrap(data);
        byte[] fighterInfo = new byte[dataBuf.getShort()];
        dataBuf.get(fighterInfo);
        fighterInformation = new Fighter();
        fighterInformation.deserialize(fighterInfo);
        return true;
    }
}
