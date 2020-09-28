package org.divarena.protocol.client.coach;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;

public class CoachEquipmentUpdateRequestMessage extends Message {

    @Getter
    private long[] equipmentArray = new long[14];

    public CoachEquipmentUpdateRequestMessage() {
        this.id = 5201;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        for (int i = 0; i < equipmentArray.length; ++i) {
            equipmentArray[i] = buf.getLong();
        }
        return true;
    }
}
