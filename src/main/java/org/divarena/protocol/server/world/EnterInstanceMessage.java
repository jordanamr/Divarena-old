package org.divarena.protocol.server.world;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.network.Coach;
import org.divarena.protocol.Message;

public @Data class EnterInstanceMessage extends Message {

    private final Coach coach;

    public EnterInstanceMessage(Coach coach) {
        this.id = 4600;
        this.coach = coach;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putFloat(coach.getX()); // x
        packet.putFloat(coach.getY()); // y
        packet.putShort(coach.getZ()); // z
        packet.putShort(0); // TODO instance id ?
        packet.putBoolean(false); // Dynamic, true = combat?, false = world?
        return packet;
    }
}
