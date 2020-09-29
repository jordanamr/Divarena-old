package org.divarena.protocol.server.coach;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.game.cards.CoachCard;
import org.divarena.protocol.Message;

import java.util.*;

public @Data class CoachInventoryUpdateMessage extends Message {

    private Map<Short, CoachCard> equipmentAddedItems;
    private List<Short> equipmentRemovedItems;
    private Map<CoachCard, Short> inventoryAddedItems;
    private List<Long> inventoryRemovedItems;
    private List<Integer> inventoryUnlockedSets;
    private List<Integer> inventoryLockedSets;

    public CoachInventoryUpdateMessage() {
        this.id = 5200;
        this.equipmentAddedItems = Collections.synchronizedMap(new HashMap<>());
        this.equipmentRemovedItems = Collections.synchronizedList(new ArrayList<>());
        this.inventoryAddedItems = Collections.synchronizedMap(new HashMap<>());
        this.inventoryRemovedItems = Collections.synchronizedList(new ArrayList<>());
        this.inventoryUnlockedSets = Collections.synchronizedList(new ArrayList<>());
        this.inventoryLockedSets = Collections.synchronizedList(new ArrayList<>());
    }

    public boolean hasChanges() {
        return !equipmentAddedItems.isEmpty() || !equipmentRemovedItems.isEmpty() || !inventoryAddedItems.isEmpty()
                || !inventoryRemovedItems.isEmpty() || !inventoryUnlockedSets.isEmpty() || !inventoryLockedSets.isEmpty();
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();

        packet.putShort(equipmentAddedItems.size());
        equipmentAddedItems.forEach((position, card) -> {
            packet.putShort(position);
            packet.putBytes(card.serialize());
        });

        packet.putShort(equipmentRemovedItems.size());
        equipmentRemovedItems.forEach(packet::putShort);

        packet.putShort(inventoryAddedItems.size());
        inventoryAddedItems.forEach((card, quantity) -> {
            packet.putBytes(card.serialize());
            packet.putShort(quantity);
        });

        packet.putShort(inventoryRemovedItems.size());
        inventoryRemovedItems.forEach(packet::putLong);

        packet.putShort(inventoryUnlockedSets.size());
        inventoryUnlockedSets.forEach(packet::putInt);

        packet.putShort(inventoryLockedSets.size());
        inventoryLockedSets.forEach(packet::putInt);

        return packet;
    }
}
