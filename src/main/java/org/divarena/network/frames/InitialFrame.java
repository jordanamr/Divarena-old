package org.divarena.network.frames;

import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.ClientAuthenticationMessage;
import org.divarena.protocol.client.ClientVersionMessage;
import org.divarena.protocol.server.InvalidClientVersionMessage;

public class InitialFrame extends Frame {

    public InitialFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 7: {
                ClientVersionMessage msg = (ClientVersionMessage) message;
                if (msg.getMajor() != 2 || msg.getMinor() != 4) {
                    InvalidClientVersionMessage response = new InvalidClientVersionMessage();
                    response.setRequiredMajor((byte) 2);
                    response.setRequiredMinor((short) 4);
                    client.sendMessage(response, true);
                }
                return true;
            }
            case 1025: {
                ClientAuthenticationMessage msg = (ClientAuthenticationMessage) message;
                // TODO Check credentials
                return true;
            }
        }
        return false;
    }
}
