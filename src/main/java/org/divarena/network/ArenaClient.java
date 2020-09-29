package org.divarena.network;

import com.github.simplenet.Client;
import com.github.simplenet.packet.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.divarena.Divarena;
import org.divarena.game.Coach;
import org.divarena.network.frames.InitialFrame;
import org.divarena.network.frames.TeamFrame;
import org.divarena.network.frames.WorldFrame;
import org.divarena.game.instances.Instance;
import org.divarena.game.instances.WorldInstance;
import org.divarena.protocol.Message;
import org.divarena.protocol.MessageDecoder;
import org.divarena.protocol.server.world.EnterInstanceMessage;
import org.divarena.protocol.server.initial.CoachInformationsMessage;

import java.nio.ByteBuffer;
import java.util.*;

@Slf4j
public class ArenaClient {

    private final Client netClient;
    private final String clientIp;

    @Getter @Setter
    private int accountId;
    @Getter @Setter
    private String accountName;
    @Getter
    private Coach coach;
    @Getter
    private Instance instance;

    private final List<Frame> registeredFrames;

    public ArenaClient(Client netClient, String clientIp) {
        this.netClient = netClient;
        this.clientIp = clientIp;
        this.registeredFrames = Collections.synchronizedList(new ArrayList<>());
        this.registerFrame(new InitialFrame(this));

        log("connected!");
        netClient.preDisconnect(() -> {
            log("disconnecting...");
            Divarena.getInstance().removeClient(this);
            if (coach == null) return;
            log("saving coach...");
            coach.save();
            if (instance == null) return;
            log("leaving instance...");
            instance.removeMember(coach);
        });
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
                log("Handled message : " + message.getClass().getSimpleName());
            });
        });
    }

    public void sendMessage(Message message) {
        sendMessage(message, false);
    }

    public void sendMessage(Message message, boolean thenClose) {
        log("Sending message : " + message.getClass().getSimpleName());
        Packet packet = message.encode();
        packet.prepend(prepend -> {
            prepend.putShort(packet.getSize() + 4);
            prepend.putShort(message.getId());
        });
        packet.queueAndFlush(netClient);
        if (thenClose) disconnect();
    }

    public void save() {
        if (coach != null) coach.save();
    }

    public String getCoachName() {
        if (coach == null) return null;
        return coach.getName();
    }

    public void disconnect() {
        try {
            Thread.sleep(200); // https://github.com/jhg023/SimpleNet/issues/21
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        netClient.close();
    }

    public void log(String message) {
        log.info("[" + clientIp + (coach == null ? "" : " - " + coach.getName()) + "] " + message);
    }

    public void registerFrame(Frame frame) {
        this.registeredFrames.add(frame);
    }

    public void unregisterFrame(Class<? extends Frame> frame) {
        this.registeredFrames.removeIf(curFrame -> curFrame.getClass().equals(frame));
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
        sendMessage(new CoachInformationsMessage(coach));
    }

    public void enterInstance(Instance instance) {
        if (instance instanceof WorldInstance) {
            this.instance = instance;
            sendMessage(new EnterInstanceMessage(coach));
            instance.addMember(coach);
            registerFrame(new WorldFrame(this)); //TODO
            registerFrame(new TeamFrame(this)); //TODO
        }
    }
}
