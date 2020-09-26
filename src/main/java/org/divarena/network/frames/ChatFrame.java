package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.Divarena;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.chat.UserPrivateContentMessage;
import org.divarena.protocol.client.chat.UserVicinityContentMessage;
import org.divarena.protocol.server.chat.PrivateContentMessage;
import org.divarena.protocol.server.chat.TargetIsYourselfMessage;
import org.divarena.protocol.server.chat.UserNotFoundMessage;

import java.util.Optional;


@Slf4j
public class ChatFrame extends Frame {

    public ChatFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 3153: {
                UserVicinityContentMessage msg = (UserVicinityContentMessage) message;
                client.getInstance().broadcastMessage(client.getCoach(), msg.getMessage());
                return true;
            }
            case 3155: {
                UserPrivateContentMessage msg = (UserPrivateContentMessage) message;
                Optional<ArenaClient> target = Divarena.getInstance().getClientByCoachName(msg.getUsername());
                if (target.isPresent()) {
                    if (target.get().getAccountId() == client.getAccountId()) {
                        client.sendMessage(new TargetIsYourselfMessage());
                        return true;
                    }
                    PrivateContentMessage privateMessage = new PrivateContentMessage();
                    privateMessage.setMemberID(client.getCoach().getId());
                    privateMessage.setMemberTalking(client.getCoachName());
                    privateMessage.setMessageContent(msg.getMessageContent());
                    target.get().sendMessage(privateMessage);
                } else {
                    client.sendMessage(new UserNotFoundMessage(msg.getUsername()));
                }
                return true;
            }
        }
        return false;
    }
}
