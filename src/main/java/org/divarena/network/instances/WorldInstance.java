package org.divarena.network.instances;

import org.divarena.protocol.client.coach.CoachActorMovementRequestMessage;
import org.divarena.protocol.server.coach.ActorMovementMessage;

import java.util.TreeMap;

public class WorldInstance extends Instance {

    public WorldInstance(int id) {
        super();
        this.id = id;
    }

    public void broadcastMovement(long coachId, TreeMap<Integer, CoachActorMovementRequestMessage.PathStep> movement) {
        ActorMovementMessage message = new ActorMovementMessage(coachId, movement);
        members.forEach(coach -> coach.getClient().sendMessage(message));
    }
}
