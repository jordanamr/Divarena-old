package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.network.instances.WorldInstance;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.world.CoachActorMovementRequestMessage;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class WorldFrame extends Frame {

    public WorldFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 4501: {
                CoachActorMovementRequestMessage msg = (CoachActorMovementRequestMessage) message;

                // TODO Wesh?
                TreeMap<Integer, CoachActorMovementRequestMessage.PathStep> newSteps = new TreeMap<>();
                newSteps.put(0, new CoachActorMovementRequestMessage.PathStep(client.getCoach().getX(), client.getCoach().getY(), (short) client.getCoach().getZ()));
                for (Map.Entry<Integer, CoachActorMovementRequestMessage.PathStep> entry : msg.getSteps().entrySet()) {
                    newSteps.put(entry.getKey() + 1, entry.getValue());
                }

                WorldInstance instance = (WorldInstance) client.getInstance();
                instance.broadcastMovement(client.getCoach().getId(), newSteps);
                CoachActorMovementRequestMessage.PathStep lastStep = newSteps.lastEntry().getValue();
                client.getCoach().setX(lastStep.getX());
                client.getCoach().setY(lastStep.getY());
                client.getCoach().setZ(lastStep.getZ());
                return true;
            }
        }
        return false;
    }
}
