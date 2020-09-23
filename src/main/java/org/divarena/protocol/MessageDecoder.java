package org.divarena.protocol;

import lombok.extern.slf4j.Slf4j;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.client.ClientAuthenticationMessage;
import org.divarena.protocol.client.ClientVersionMessage;

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
            case 7: {
                msg = new ClientVersionMessage();
                break;
            }
            case 1025: {
                msg = new ClientAuthenticationMessage();
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
