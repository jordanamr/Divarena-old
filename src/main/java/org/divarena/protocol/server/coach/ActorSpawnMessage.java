package org.divarena.protocol.server.coach;

import com.github.simplenet.packet.Packet;
import org.divarena.network.Coach;
import org.divarena.protocol.Message;

import java.util.Arrays;
import java.util.Collection;

public class ActorSpawnMessage extends Message {

    private final Collection<Coach> coaches;

    public ActorSpawnMessage(Coach... coaches) {
        this.id = 4096;
        this.coaches = Arrays.asList(coaches);
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putInt(coaches.size());

        // BUFFER
        coaches.forEach(coach -> {
            packet.putByte(1); // Coach
            coach.serialize(packet, 11);
        });

        return packet;
    }
}
