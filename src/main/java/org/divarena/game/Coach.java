package org.divarena.game;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.divarena.Divarena;
import org.divarena.database.DivarenaDatabase;
import org.divarena.database.generated.tables.pojos.Coaches;
import org.divarena.game.cards.CoachCard;
import org.divarena.network.ArenaClient;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.divarena.database.generated.tables.Coaches.COACHES;

public class Coach {

    @Getter
    private final ArenaClient client;
    @Getter
    private final int id;
    @Getter
    private final String name;
    private final byte skinColor;
    private final byte hairColor;
    private final byte sex;
    @Getter @Setter
    private int x;
    @Getter @Setter
    private int y;
    @Getter @Setter
    private int z;
    @Getter
    private final CoachInventory inventory;
    @Getter
    private final Map<Short, CoachCard> equipment;

    public Coach(ArenaClient client, Coaches coachPojo) {
        this.client = client;
        this.id = coachPojo.getId();
        this.name = coachPojo.getName();
        this.skinColor = coachPojo.getSkinColor();
        this.hairColor = coachPojo.getHairColor();
        this.sex = coachPojo.getSex();
        this.x = coachPojo.getX();
        this.y = coachPojo.getY();
        this.z = coachPojo.getZ();
        this.inventory = new CoachInventory(coachPojo.getInventory());
        this.equipment = deserializeEquipment(coachPojo.getEquipment());
    }

    public void save() {
        DivarenaDatabase.getInstance().getDsl()
                .update(COACHES)
                .set(COACHES.X, x)
                .set(COACHES.Y, y)
                .set(COACHES.Z, z)
                .set(COACHES.INVENTORY, inventory.serialize())
                .set(COACHES.EQUIPMENT, serializeEquipment())
                .where(COACHES.ID.eq(id))
                .execute();
    }

    public Map<Short, CoachCard> deserializeEquipment(byte[] data) {
        Map<Short, CoachCard> map = Collections.synchronizedMap(new HashMap<>());

        ByteBuffer buf = ByteBuffer.wrap(data);
        while (buf.hasRemaining()) {
            short position = buf.getShort();
            int cardId = buf.getInt();
            long uniqueId = buf.getLong();
            byte flags = buf.get();
            CoachCard card = Divarena.getInstance().getNewCoachCard(cardId);
            card.setUid(uniqueId);
            card.setFlags(flags);
            map.put(position, card);
        }

        return map;
    }

    public byte[] serializeEquipment() {
        ByteBuffer buf = ByteBuffer.allocate(equipment.size() * 15);

        equipment.forEach((position, card) -> {
            buf.putShort(position);
            buf.putInt(card.getId());
            buf.putLong(card.getUid());
            buf.put(card.getFlags());
        });

        return buf.array();
    }

    public void serialize(Packet packet, int options) {
        //unserializeIdAndName
        packet.putLong(id);
        packet.putByte(name.length());
        packet.putBytes(name.getBytes());

        //unserializePosition
        if ((options & 1) == 1) {
            packet.putInt(x);
            packet.putInt(y);
            packet.putShort(z);
            packet.putByte(1); //TODO Direction8
        }

        //unserializeLook
        packet.putByte(skinColor);
        packet.putByte(hairColor);
        packet.putByte(sex);

        //unserializeEquipment
        // ????
        // short > taille du prochain buffer qui contient l'équipement
        // ---BUFFER---  EquipedCoachCard
        // short -> position?
        // int -> cardId
        // long -> unique ID?
        // byte -> flags?
        if ((options & 2) == 2) {
            byte[] equipData = serializeEquipment();
            packet.putShort(equipData.length);
            if (equipData.length != 0) {
                packet.putBytes(equipData);
            }
        }

        //unserializeCardInventory (StackInventory#unserialize -> AbstractCoachCard#unserialize)
        // ????
        // short > taille du prochain buffer qui contient l'équipement
        // ---BUFFER---  CoachCard
        // int -> cardId
        // long -> unique ID?
        // byte -> flags? (locked, cursed?)
        // short -> quantity?
        if ((options & 4) == 4) {
            byte[] inv = inventory.serialize();
            packet.putShort(inv.length);
            packet.putBytes(inv);
        }

        //unserializeLockedSet - panoplies qui sont cadenassées
        // ????
        // short > taille du prochain buffer
        // ---BUFFER---
        // int -> setId
        if ((options & 0x10) == 16) {
            packet.putShort(0); //TODO
        }

        //unserializeLaddersStrength
        // ????
        // short -> nombres de "laddersStrength" ?
        // ---BUFFER---
        // byte -> ladderId?
        // short -> strength?
        if ((options & 8) == 8) {
            packet.putShort(1); //TODO
            packet.putByte(1);
            packet.putShort(1);
        }
    }
}
