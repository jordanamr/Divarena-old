package org.divarena.network.frames;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.divarena.Divarena;
import org.divarena.database.DivarenaDatabase;
import org.divarena.database.generated.tables.pojos.Accounts;
import org.divarena.database.generated.tables.pojos.Coaches;
import org.divarena.network.ArenaClient;
import org.divarena.game.Coach;
import org.divarena.network.Frame;
import org.divarena.game.instances.Instance;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.initial.ClientAuthenticationMessage;
import org.divarena.protocol.client.initial.ClientVersionMessage;
import org.divarena.protocol.server.world.PlayerStatisticsReportMessage;
import org.divarena.protocol.server.initial.*;

import static org.divarena.database.generated.tables.Coaches.COACHES;

public class InitialFrame extends Frame {

    public InitialFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 7: {
                ClientVersionMessage msg = (ClientVersionMessage) message;
                if (msg.getMajor() != 2 || msg.getMinor() != 13) {
                    InvalidClientVersionMessage response = new InvalidClientVersionMessage();
                    response.setRequiredMajor((byte) 2);
                    response.setRequiredMinor((short) 13);
                    client.sendMessage(response, true);
                }
                return true;
            }
            case 1025: {
                ClientAuthenticationMessage msg = (ClientAuthenticationMessage) message;
                Accounts accountPojo = DivarenaDatabase.getInstance().getAccountsDao().fetchOneByUsername(msg.getUsername());
                ClientAuthenticationResultsMessage response = new ClientAuthenticationResultsMessage();

                if (accountPojo == null || !BCrypt.verifyer(BCrypt.Version.VERSION_2A).verify(msg.getPassword().toCharArray(), accountPojo.getPassword()).verified) {
                    response.setResultCode(ClientAuthenticationResultsMessage.ResultCode.INVALID_LOGIN.getCode());
                    client.sendMessage(response);
                    return true;
                }

                client.setAccountId(accountPojo.getId());
                client.setAccountName(accountPojo.getUsername());

                response.setResultCode(ClientAuthenticationResultsMessage.ResultCode.SUCCESS.getCode());
                client.sendMessage(response);
                client.unregisterFrame(InitialFrame.class);
                Coaches coachPojo = DivarenaDatabase.getInstance().getCoachesDao().fetchOne(COACHES.ACCOUNT_ID, client.getAccountId());
                if (coachPojo != null) {
                    client.setCoach(new Coach(client, coachPojo));
                    client.sendMessage(new PlayerStatisticsReportMessage()); //TODO
                    client.sendMessage(new QueueNotificationMessage());

                    Instance instance = Divarena.getInstance().getWorldInstance(coachPojo.getInstance()); //TODO
                    client.enterInstance(instance);
                    client.registerFrame(new ChatFrame(client));
                } else {
                    client.sendMessage(new CoachCreationRequestMessage());
                    client.sendMessage(new QueueNotificationMessage());
                    client.registerFrame(new CoachCreationFrame(client));
                }
                return true;
            }
        }
        return false;
    }
}
