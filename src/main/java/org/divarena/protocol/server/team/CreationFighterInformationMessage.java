package org.divarena.protocol.server.team;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import org.divarena.game.teams.Fighter;
import org.divarena.protocol.Message;

public @Data class CreationFighterInformationMessage extends Message {

    private Code code;
    private Fighter fighter;

    public CreationFighterInformationMessage() {
        this.id = 6000;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(code.getId());
        if (code != Code.SUCCESS) return packet;
        long id = 0L; // Fighter UID?
        packet.putLong(id);
        byte[] fighterData = fighter.serialize();
        packet.putShort(fighterData.length);
        packet.putBytes(fighterData);
        return packet;
    }

    public enum Code {
        SUCCESS((byte) 0),
        NO_MORE_ROOM((byte) 20),
        ERROR((byte) -1);

        @Getter
        private final byte id;

        Code(byte id) {
            this.id = id;
        }
    }
}
