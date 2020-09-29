package org.divarena.protocol;

import lombok.extern.slf4j.Slf4j;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.client.initial.*;
import org.divarena.protocol.client.world.*;
import org.divarena.protocol.client.chat.*;
import org.divarena.protocol.client.admin.*;
import org.divarena.protocol.client.coach.*;
import org.divarena.protocol.client.team.*;

import java.util.Arrays;

@Slf4j
public class MessageDecoder {

    private static MessageDecoder instance = null;

    public static MessageDecoder getInstance() {
        if (instance == null) {
            instance = new MessageDecoder();
        }
        return instance;
    }

    public Message decode(ArenaClient client, short id, byte[] data) {
        Message msg = null;
        switch (id) {
            case 1: {
                msg = new DisconnectionNotificationMessage();
                client.disconnect();
                return null;
            }
            case 7: {
                msg = new ClientVersionMessage();
                break;
            }
            case 1025: {
                msg = new ClientAuthenticationMessage();
                break;
            }
            case 2049: {
                msg = new CoachCreationMessage();
                break;
            }
            case 4501: {
                msg = new CoachActorMovementRequestMessage();
                break;
            }
            case 3153: {
                msg = new UserVicinityContentMessage();
                break;
            }
            case 3155: {
                msg = new UserPrivateContentMessage();
                break;
            }
            case 101: {
                msg = new ConsoleAdminCommandMessage();
                break;
            }
            case 5201: {
                msg = new CoachEquipmentUpdateRequestMessage();
                break;
            }
            case 6005: {
                msg = new FighterInformationListRequestMessage();
                break;
            }
            case 6031: {
                msg = new TeamPresetListRequestMessage();
                break;
            }
            case 6001: {
                msg = new CreateFighterInformationRequestMessage();
                break;
            }
        }
        if (msg == null) {
            client.log("Unknown message id " + id + ", full message: " + Arrays.toString(data));
            return null;
        }
        try {
            if (!msg.decode(data)) {
                client.log("Decoding error for message id " + id + ", full message: " + Arrays.toString(data));
                return null;
            }
        } catch (Exception ex) {
            client.log("Invalid message id " + id + ", full message: " + Arrays.toString(data));
            return null;
        }
        return msg;
    }
}
