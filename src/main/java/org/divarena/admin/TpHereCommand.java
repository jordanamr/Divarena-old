package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.game.Coach;
import org.divarena.game.instances.Instance;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.world.EnterInstanceMessage;

import java.util.Optional;

public class TpHereCommand extends Command {

    public TpHereCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        if (args.length == 0) {
            log(client, "Utilisation: tphere <coach>");
            return;
        }
        Optional<ArenaClient> target = Divarena.getInstance().getClientByCoachName(args[0]);
        if (target.isEmpty()) {
            error(client, "Coach '" + args[0] + "' introuvable ou déconnecté");
            return;
        }
        Coach targetCoach = target.get().getCoach();
        Instance targetInstance = target.get().getInstance();
        targetInstance.removeMember(targetCoach);
        targetCoach.setX(client.getCoach().getX());
        targetCoach.setY(client.getCoach().getY());
        targetCoach.setZ(client.getCoach().getZ());
        target.get().sendMessage(new EnterInstanceMessage(targetCoach)); //TODO Better way?
        client.getInstance().addMember(targetCoach);
        log(client, args[0] + " a été téléporté vers vous.");
    }
}
