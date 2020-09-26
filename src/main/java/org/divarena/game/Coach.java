package org.divarena.game;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import org.divarena.database.DivarenaDatabase;
import org.divarena.database.generated.tables.pojos.Coaches;
import org.divarena.network.ArenaClient;

import java.io.ByteArrayOutputStream;

import static org.divarena.database.generated.tables.Coaches.COACHES;

public @Data class Coach {

    private ArenaClient client;
    private int id;
    private String name;
    private byte skinColor;
    private byte hairColor;
    private byte sex;
    private int x;
    private int y;
    private int z;

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
    }

    public void save() {
        DivarenaDatabase.getInstance().getDsl()
                .update(COACHES)
                .set(COACHES.X, x)
                .set(COACHES.Y, y)
                .set(COACHES.Z, z)
                .where(COACHES.ID.eq(id))
                .execute();
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
            packet.putShort(0); //TODO
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
            packet.putShort(15); //TODO

            ByteArrayOutputStream buf = new ByteArrayOutputStream();

            packet.putInt(106);
            packet.putLong(1);
            packet.putByte(0);
            packet.putShort(1);
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
