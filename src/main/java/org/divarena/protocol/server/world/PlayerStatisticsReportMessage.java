package org.divarena.protocol.server.world;

import com.github.simplenet.packet.Packet;
import lombok.Data;
import lombok.Getter;
import org.divarena.protocol.Message;

public @Data class PlayerStatisticsReportMessage extends Message {

    public PlayerStatisticsReportMessage() {
        this.id = 2400;
    }

    @Override
    public Packet encode() {
        Packet packet = Packet.builder();
        packet.putShort(1); // Model ID
        packet.putLong(1); // Report ID
        packet.putShort(8); //NB Entries

        //BUFFER
        packet.putShort(1); //id = total play time
        packet.putByte(StatisticType.TYPE_LONG.getId()); //Data type
        packet.putLong(0L);

        packet.putShort(2); //id = total fight time
        packet.putByte(StatisticType.TYPE_LONG.getId()); //Data type
        packet.putLong(0L);

        packet.putShort(3); //id = total fights
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.putShort(4); //id = total fights won
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.putShort(5); //id = total fights lost
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.putShort(6); //id = 1vs1 ladder player strength
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.putShort(7); //id = consecutive wins
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.putShort(8); //id = consecutive loses
        packet.putByte(StatisticType.TYPE_INT.getId()); //Data type
        packet.putInt(0);

        packet.prepend(prepend -> packet.putShort(packet.getSize()));

        return packet;
    }

    public enum StatisticType {
        TYPE_INT((byte) 1, (byte) 4),
        TYPE_LONG((byte) 2, (byte) 8),
        TYPE_FLOAT((byte) 3, (byte) 4);

        @Getter
        private final byte id;
        @Getter
        private final byte size;

        StatisticType(byte id, byte size) {
            this.id = size;
            this.size = size;
        }
    }
}
