package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.game.CoachInventory;
import org.divarena.game.cards.CoachCard;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.game.instances.WorldInstance;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.coach.CoachEquipmentUpdateRequestMessage;
import org.divarena.protocol.client.world.CoachActorMovementRequestMessage;
import org.divarena.protocol.server.coach.CoachEquipmentUpdateMessage;
import org.divarena.protocol.server.coach.CoachInventoryUpdateMessage;

import java.util.Arrays;
import java.util.Collections;
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
            case 5201: {
                CoachEquipmentUpdateRequestMessage msg = (CoachEquipmentUpdateRequestMessage) message;
                CoachInventoryUpdateMessage updateMsg = new CoachInventoryUpdateMessage();
                CoachInventory inv = client.getCoach().getInventory();
                long[] equipArr = msg.getEquipmentArray(); //Equipment slots mapped to items UID
                for (int i = 0; i < equipArr.length; ++i) {
                    long uid = equipArr[i];
                    CoachCard curEquip = client.getCoach().getEquipment().get((short) i);
                    if (curEquip == null && uid == 0L || (curEquip != null && curEquip.getUid() == uid)) continue; // No change
                    if (curEquip == null) { // Equip item to empty slot
                        CoachCard removed = inv.remove(uid);
                        if (removed == null) {
                            client.log("ALERT! Trying to equip a card not in inventory (During equip to empty)");
                            client.disconnect();
                            break;
                        }
                        client.getCoach().getEquipment().put((short) i, removed);
                        updateMsg.getInventoryRemovedItems().add(uid);
                        updateMsg.getEquipmentAddedItems().put((short) i, removed);
                        continue;
                    }
                    if (uid == 0L) { // Desequip current slot
                        CoachCard removed = client.getCoach().getEquipment().get((short) i);
                        client.getCoach().getEquipment().remove((short) i);
                        inv.add(removed);
                        updateMsg.getInventoryAddedItems().put(removed, (short) 1); //TODO Quantity?
                        updateMsg.getEquipmentRemovedItems().add((short) i);
                        continue;
                    }
                    // Swap items
                    CoachCard removedFromInv = inv.remove(uid);
                    if (removedFromInv == null) {
                        client.log("ALERT! Trying to equip a card not in inventory (During swap)");
                        client.disconnect();
                        break;
                    }

                    CoachCard removedFromEquip = client.getCoach().getEquipment().get((short) i);
                    client.getCoach().getEquipment().remove((short) i);
                    inv.add(removedFromEquip);
                    updateMsg.getInventoryAddedItems().put(removedFromEquip, (short) 1); //TODO Quantity?
                    updateMsg.getEquipmentRemovedItems().add((short) i);

                    client.getCoach().getEquipment().put((short) i, removedFromInv);
                    updateMsg.getInventoryRemovedItems().add(removedFromInv.getUid());
                    updateMsg.getEquipmentAddedItems().put((short) i, removedFromInv);
                }
                client.sendMessage(updateMsg);
                CoachEquipmentUpdateMessage broadcastMsg = new CoachEquipmentUpdateMessage(client.getCoach());
                client.getInstance().getMembers().forEach(coaches -> {
                    if (coaches.getId() == client.getCoach().getId()) return;
                    coaches.getClient().sendMessage(broadcastMsg);
                });
                return true;
            }
        }
        return false;
    }
}
