package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.Divarena;
import org.divarena.admin.Command;
import org.divarena.admin.CommandManager;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.admin.ConsoleAdminCommandMessage;
import org.divarena.protocol.client.chat.UserPrivateContentMessage;
import org.divarena.protocol.client.chat.UserVicinityContentMessage;
import org.divarena.protocol.server.admin.ConsoleAdminCommandResultMessage;
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
            case 8193: {
                ConsoleAdminCommandMessage msg = (ConsoleAdminCommandMessage) message;
                String[] text = msg.getCommand().split(" ");
                Command command = CommandManager.getInstance().getCommand(text[0].toLowerCase());
                if (command == null) {
                    ConsoleAdminCommandResultMessage response = new ConsoleAdminCommandResultMessage();
                    response.setType(ConsoleAdminCommandResultMessage.Type.ERROR);
                    response.setMessage("Commande '" + text[0] + "' introuvable. Tapez 'help' pour obtenir la liste des commandes.");
                    client.sendMessage(response);
                    return true;
                }
                if (text.length <= 1) {
                    command.execute(client, new String[]{});
                } else {
                    String[] args = new String[text.length - 1];
                    System.arraycopy(text,1, args,0, text.length - 1);
                    command.execute(client, args);
                }
                return true;
            }
        }
        return false;
    }
}
