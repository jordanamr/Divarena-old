package org.divarena.network.instances;

import org.divarena.network.Coach;
import org.divarena.protocol.server.coach.ActorDespawnMessage;
import org.divarena.protocol.server.coach.ActorSpawnMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Instance {

    protected int id;
    protected final List<Coach> members;

    protected Instance() {
        members = Collections.synchronizedList(new ArrayList<>());
    }

    public void addMember(Coach coach) {
        coach.getClient().sendMessage(new ActorSpawnMessage(members.toArray(new Coach[0])));
        members.forEach(coaches -> coaches.getClient().sendMessage(new ActorSpawnMessage(coach)));
        members.add(coach);
    }

    public void removeMember(Coach coach) {
        members.remove(coach);
        members.forEach(coaches -> coaches.getClient().sendMessage(new ActorDespawnMessage(coach)));
        //TODO Despawn
    }

    public boolean containsMember(Coach coach) {
        return members.contains(coach);
    }
}
