package org.divarena.network.frames;

import com.typesafe.config.Config;
import org.divarena.Divarena;
import org.divarena.database.DivarenaDatabase;
import org.divarena.database.generated.tables.pojos.Coaches;
import org.divarena.network.ArenaClient;
import org.divarena.network.Coach;
import org.divarena.network.Frame;
import org.divarena.network.instances.Instance;
import org.divarena.protocol.Message;
import org.divarena.protocol.client.initial.CoachCreationMessage;
import org.divarena.protocol.server.world.PlayerStatisticsReportMessage;
import org.divarena.protocol.server.initial.CoachCreationResultMessage;
import org.divarena.protocol.server.initial.QueueNotificationMessage;
import org.divarena.util.StringUtils;

import static org.divarena.database.generated.tables.Coaches.COACHES;

public class CoachCreationFrame extends Frame {

    public CoachCreationFrame(ArenaClient client) {
        super(client);
    }

    public boolean handle(Message message) {
        switch (message.getId()) {
            case 2049: {
                CoachCreationMessage msg = (CoachCreationMessage) message;
                CoachCreationResultMessage response = new CoachCreationResultMessage();
                if (!StringUtils.isValidCoachName(msg.getName())) {
                    response.setResultCode(CoachCreationResultMessage.Code.INVALID_NAME.getCode());
                    client.sendMessage(response);
                    return true;
                }
                boolean invalidData = false;
                if (msg.getSkinColorIndex() < 0 || msg.getSkinColorIndex() > 15) {
                    invalidData = true;
                }
                if (msg.getHairColorIndex() < 0 || msg.getHairColorIndex() > 15) {
                    invalidData = true;
                }
                if (msg.getSex() != 0 && msg.getSex() != 1) {
                    invalidData = true;
                }
                if (invalidData) {
                    response.setResultCode(CoachCreationResultMessage.Code.ERROR.getCode());
                    client.sendMessage(response);
                    return true;
                }
                if (DivarenaDatabase.getInstance().getDsl().select(COACHES.ID).from(COACHES).where(COACHES.NAME.eq(msg.getName())).fetchOne() != null) {
                    response.setResultCode(CoachCreationResultMessage.Code.INVALID_NAME.getCode());
                    client.sendMessage(response);
                    return true;
                }
                if (DivarenaDatabase.getInstance().getDsl().select(COACHES.ID).from(COACHES).where(COACHES.ACCOUNT_ID.eq(client.getAccountId())).fetchOne() != null) {
                    response.setResultCode(CoachCreationResultMessage.Code.ERROR.getCode());
                    client.sendMessage(response, true);
                    return true;
                }

                Config config = Divarena.getInstance().getConfig();
                Coaches coachPojo = new Coaches();
                coachPojo.setName(msg.getName());
                coachPojo.setSkinColor(msg.getSkinColorIndex());
                coachPojo.setHairColor(msg.getHairColorIndex());
                coachPojo.setSex(msg.getSex());
                coachPojo.setAccountId(client.getAccountId());
                coachPojo.setInstance(config.getInt("start.instanceId"));
                coachPojo.setX(config.getInt("start.x"));
                coachPojo.setY(config.getInt("start.y"));
                coachPojo.setZ(config.getInt("start.z"));
                DivarenaDatabase.getInstance().getCoachesDao().insert(coachPojo);

                response.setResultCode(CoachCreationResultMessage.Code.SUCCESS.getCode());
                client.sendMessage(response);

                client.setCoach(new Coach(client, coachPojo));
                client.sendMessage(new PlayerStatisticsReportMessage()); //TODO
                client.sendMessage(new QueueNotificationMessage());

                Instance instance = Divarena.getInstance().getWorldInstance(coachPojo.getInstance()); //TODO
                client.enterInstance(instance);
                client.registerFrame(new ChatFrame(client));
                return true;
            }
        }
        return false;
    }
}
