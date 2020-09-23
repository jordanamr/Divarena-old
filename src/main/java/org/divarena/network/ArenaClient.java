package org.divarena.network;

import com.github.simplenet.Client;
import com.github.simplenet.packet.Packet;
import lombok.extern.slf4j.Slf4j;
import org.divarena.network.frames.InitialFrame;
import org.divarena.protocol.Message;
import org.divarena.protocol.MessageDecoder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ArenaClient {

    private final Client netClient;
    private final String clientIp;
    private final List<Frame> registeredFrames;

    public ArenaClient(Client netClient, String clientIp) {
        this.netClient = netClient;
        this.clientIp = clientIp;
        this.registeredFrames = Collections.synchronizedList(new ArrayList<>());
        this.registeredFrames.add(new InitialFrame(this));

        log("connected!");
        netClient.postDisconnect(() -> log("disconnected!"));

        netClient.readBytesAlways(5, header -> {
            ByteBuffer headerBuf = ByteBuffer.wrap(header);
            short msgSize = headerBuf.getShort();
            if (msgSize < 5) {
                log("Invalid message size. Full header: " + Collections.singletonList(header));
                disconnect();
                return;
            }
            byte target = headerBuf.get();
            if (target < 0 || target > 4) {
                log("Invalid target. Target: " + target);
                disconnect();
                return;
            }
            short msgId = headerBuf.getShort();
            log("New message ID " + msgId + ", Size: " + msgSize + ", Target: " + target + ", waiting for all bytes...");
            netClient.readBytes(msgSize - 5, data -> {
                Message message = MessageDecoder.getInstance().decode(this, msgId, data);
                if (message == null) {
                    disconnect();
                    return;
                }
                boolean handled = false;
                for (Frame frame : registeredFrames) {
                    handled = frame.handle(message);
                    if (handled) break;
                }
                if (!handled) {
                    log("Unhandled message. Full header: " + Arrays.toString(header) + " Message: " + Arrays.toString(data));
                    disconnect();
                }
            });
        });
    }

    public void sendMessage(Message message) {
        sendMessage(message, false);
    }

    public void sendMessage(Message message, boolean thenClose) {
        Packet packet = message.encode();
        packet.prepend(prepend -> {
            prepend.putShort(packet.getSize() + 4);
            prepend.putShort(message.getId());
        });
        packet.queueAndFlush(netClient);
        if (thenClose) {
            try {
                Thread.sleep(200); // https://github.com/jhg023/SimpleNet/issues/21
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            netClient.close();
        }
    }

    public void disconnect() {
        netClient.close();
    }

    public void log(String message) {
        log.info("[" + clientIp + "] " + message);
    }
}
