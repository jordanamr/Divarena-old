package org.divarena.protocol.client.coach;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;
import java.util.TreeMap;

public class CoachActorMovementRequestMessage extends Message {

    @Getter
    private TreeMap<Integer, PathStep> steps;

    public CoachActorMovementRequestMessage() {
        this.id = 4501;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        steps = new TreeMap<>();
        int step = 0;
        while (buf.hasRemaining()) {
            int x = buf.getInt();
            int y = buf.getInt();
            short z = buf.getShort();
            steps.put(step, new PathStep(x, y, z));
            step++;
        }
        return true;
    }

    public static class PathStep {

        @Getter
        private final int x;
        @Getter
        private final int y;
        @Getter
        private final short z;

        public PathStep(int x, int y, short z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
