package org.divarena.game.instances;

import org.divarena.protocol.client.world.CoachActorMovementRequestMessage;
import org.divarena.protocol.server.world.ActorMovementMessage;

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
