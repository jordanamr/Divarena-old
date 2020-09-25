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
import org.divarena.protocol.server.coach.PlayerStatisticsReportMessage;
import org.divarena.protocol.server.initial.CoachCreationResultMessage;
import org.divarena.protocol.server.initial.CoachInformationsMessage;
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
                    response.setResultCode(CoachCreationResultMessage.ResultCode.INVALID_NAME.getCode());
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
                    response.setResultCode(CoachCreationResultMessage.ResultCode.ERROR.getCode());
                    client.sendMessage(response);
                    return true;
                }
                if (DivarenaDatabase.getInstance().getDsl().select(COACHES.ID).from(COACHES).where(COACHES.NAME.eq(msg.getName())).fetchOne() != null) {
                    response.setResultCode(CoachCreationResultMessage.ResultCode.INVALID_NAME.getCode());
                    client.sendMessage(response);
                    return true;
                }
                if (DivarenaDatabase.getInstance().getDsl().select(COACHES.ID).from(COACHES).where(COACHES.ACCOUNT_ID.eq(client.getAccountId())).fetchOne() != null) {
                    response.setResultCode(CoachCreationResultMessage.ResultCode.ERROR.getCode());
                    client.sendMessage(response, true);
                    return true;
                }
                Config config = Divarena.getInstance().getConfig();
                DivarenaDatabase.getInstance().getDsl().insertInto(COACHES).set(COACHES.NAME, msg.getName())
                        .set(COACHES.SKIN_COLOR, msg.getSkinColorIndex()).set(COACHES.HAIR_COLOR, msg.getHairColorIndex())
                        .set(COACHES.SEX, msg.getSex()).set(COACHES.ACCOUNT_ID, client.getAccountId())
                        .set(COACHES.INSTANCE, config.getInt("start.instanceId"))
                        .set(COACHES.X, config.getInt("start.x"))
                        .set(COACHES.Y, config.getInt("start.y"))
                        .set(COACHES.Z, config.getInt("start.z"))
                        .execute();
                response.setResultCode(CoachCreationResultMessage.ResultCode.SUCCESS.getCode());
                client.sendMessage(response);

                Coaches coachPojo = DivarenaDatabase.getInstance().getCoachesDao().fetchOne(COACHES.ACCOUNT_ID, client.getAccountId());
                client.setCoach(new Coach(client, coachPojo));
                client.sendMessage(new PlayerStatisticsReportMessage()); //TODO
                client.sendMessage(new QueueNotificationMessage());

                Instance instance = Divarena.getInstance().getWorldInstance(coachPojo.getInstance()); //TODO
                client.enterInstance(instance);
                return true;
            }
        }
        return false;
    }
}
