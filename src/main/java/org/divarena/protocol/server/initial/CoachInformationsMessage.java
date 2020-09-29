package org.divarena.protocol.server.initial;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.game.Coach;
import org.divarena.protocol.Message;

public @Data class CoachInformationsMessage extends Message {

    private final Coach coach;

    public CoachInformationsMessage(Coach coach) {
        this.id = 2052;
        this.coach = coach;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        coach.serialize(packet, 30);
        return packet;
    }
}
