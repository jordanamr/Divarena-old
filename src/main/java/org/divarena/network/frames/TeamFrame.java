package org.divarena.network.frames;

import lombok.extern.slf4j.Slf4j;
import org.divarena.network.ArenaClient;
import org.divarena.network.Frame;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.team.CreateFighterInformationRequestMessage;
import org.divarena.protocol.server.team.CreationFighterInformationMessage;
import org.divarena.protocol.server.team.FighterInformationListMessage;
import org.divarena.protocol.server.team.TeamPresetListMessage;

@Slf4j
public class TeamFrame extends Frame {

    public TeamFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 6005: { // FighterInformationListRequestMessage
                FighterInformationListMessage response = new FighterInformationListMessage();
                client.sendMessage(response);
                return true;
            }
            case 6031: { // TeamPresetListRequestMessage
                TeamPresetListMessage response = new TeamPresetListMessage();
                client.sendMessage(response);
                return true;
            }
            case 6001: {
                CreateFighterInformationRequestMessage msg = (CreateFighterInformationRequestMessage) message;
                CreationFighterInformationMessage response = new CreationFighterInformationMessage();
                response.setCode(CreationFighterInformationMessage.Code.SUCCESS);
                response.setFighter(msg.getFighterInformation());
                client.sendMessage(response);
                return true;
            }
        }
        return false;
    }
}
