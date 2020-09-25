package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.network.instances.WorldInstance;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.coach.CoachActorMovementRequestMessage;

@Slf4j
public class WorldFrame extends Frame {

    public WorldFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 4501: {
                CoachActorMovementRequestMessage msg = (CoachActorMovementRequestMessage) message;
                WorldInstance instance = (WorldInstance) client.getInstance();
                instance.broadcastMovement(client.getCoach().getId(), msg.getSteps());
                CoachActorMovementRequestMessage.PathStep lastStep = msg.getSteps().lastEntry().getValue();
                client.getCoach().setX(lastStep.getX());
                client.getCoach().setY(lastStep.getY());
                client.getCoach().setZ(lastStep.getZ());
                return true;
            }
        }
        return false;
    }
}
