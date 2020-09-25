package org.divarena.protocol.server.coach;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.network.Coach;
import org.divarena.protocol.Message;

import java.util.Arrays;
import java.util.Collection;

public @Data class ActorDespawnMessage extends Message {

    private final Collection<Coach> coaches;

    public ActorDespawnMessage(Coach... coaches) {
        this.id = 4098;
        this.coaches = Arrays.asList(coaches);
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putByte(coaches.size());

        // BUFFER
        coaches.forEach(coach -> packet.putLong(coach.getId()));

        return packet;
    }
}
