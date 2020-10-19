package org.divarena.protocol.server.team;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.protocol.Message;

public @Data class TeamPresetListMessage extends Message {

    public TeamPresetListMessage() {
        this.id = 6030;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(0);

        /*packet.putShort(10); //Flag?

        //preset ID if flag == -1
        //packet.putShort(50);
        //else ID = flag

        byte[] name = "test".getBytes();
        packet.putByte(name.length);
        packet.putBytes(name);

        packet.putByte(0); //TeamNumber (count?)
        //packet.putLong(0L); //FighterInformationID ?

        //if flag == -1;*/

        return packet;
    }
}
