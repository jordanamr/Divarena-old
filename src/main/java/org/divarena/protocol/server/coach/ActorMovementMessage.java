package org.divarena.protocol.server.coach;

import com.github.simplenet.packet.Packet;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.coach.CoachActorMovementRequestMessage;

import java.util.Map;

public class ActorMovementMessage extends Message {

    private final long actorId;
    private final Map<Integer, CoachActorMovementRequestMessage.PathStep> movement;

    public ActorMovementMessage(long actorId, Map<Integer, CoachActorMovementRequestMessage.PathStep> movement) {
        this.id = 4500;
        this.actorId = actorId;
        this.movement = movement;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putLong(actorId);
        movement.values().forEach(pathStep -> {
            packet.putInt(pathStep.getX());
            packet.putInt(pathStep.getY());
            packet.putShort(pathStep.getZ());
        });
        return packet;
    }
}
