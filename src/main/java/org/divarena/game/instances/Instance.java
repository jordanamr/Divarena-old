package org.divarena.game.instances;

import lombok.Getter;
import org.divarena.game.Coach;
import org.divarena.protocol.Message;
import org.divarena.protocol.server.world.ActorDespawnMessage;
import org.divarena.protocol.server.world.ActorSpawnMessage;
import org.divarena.protocol.server.chat.VicinityContentMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Instance {

    protected int id;
    @Getter
    protected final List<Coach> members;

    protected Instance() {
        members = Collections.synchronizedList(new ArrayList<>());
    }

    public void addMember(Coach coach) {
        if (!members.isEmpty()) coach.getClient().sendMessage(new ActorSpawnMessage(members.toArray(new Coach[0])));
        members.forEach(coaches -> coaches.getClient().sendMessage(new ActorSpawnMessage(coach)));
        members.add(coach);
    }

    public void removeMember(Coach coach) {
        if (members.contains(coach)) {
            members.remove(coach);
            members.forEach(coaches -> coaches.getClient().sendMessage(new ActorDespawnMessage(coach)));
            //TODO Despawn
        }
    }

    public boolean containsMember(Coach coach) {
        return members.contains(coach);
    }

    public void chat(Coach coach, String message) {
        VicinityContentMessage msg = new VicinityContentMessage();
        msg.setMemberTalking(coach.getName());
        msg.setMemberID(coach.getId());
        msg.setMessageContent(message);
        members.forEach(coaches -> {
            if (coaches.getId() == msg.getMemberID()) return;
            coaches.getClient().sendMessage(msg);
        });
    }

    public void broadcast(Message message) {
        members.forEach(coaches -> coaches.getClient().sendMessage(message));
    }
}
