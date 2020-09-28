package org.divarena.protocol.server.coach;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.game.Coach;
import org.divarena.protocol.Message;

public @Data class CoachEquipmentUpdateMessage extends Message {

    private Coach coach;

    public CoachEquipmentUpdateMessage(Coach coach) {
        this.id = 5202;
        this.coach = coach;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putLong(coach.getId());
        byte[] equipment = coach.serializeEquipment();
        packet.putShort(equipment.length);
        if (equipment.length != 0) {
            packet.putBytes(equipment);
        }
        return packet;
    }
}
