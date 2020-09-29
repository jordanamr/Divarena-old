package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.game.instances.Instance;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.world.EnterInstanceMessage;

import java.util.Optional;

public class TpCommand extends Command {

    public TpCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        if (args.length == 0) {
            log(client, "Utilisation: tp [coach]");
            return;
        }
        Optional<ArenaClient> target = Divarena.getInstance().getClientByCoachName(args[0]);
        if (target.isEmpty()) {
            error(client, "Coach '" + args[0] + "' introuvable ou déconnecté");
            return;
        }
        Instance targetInstance = target.get().getInstance();
        client.getInstance().removeMember(client.getCoach());
        targetInstance.removeMember(client.getCoach());
        client.getCoach().setX(target.get().getCoach().getX());
        client.getCoach().setY(target.get().getCoach().getY());
        client.getCoach().setZ(target.get().getCoach().getZ());
        client.sendMessage(new EnterInstanceMessage(client.getCoach())); //TODO Better way?
        targetInstance.addMember(client.getCoach());
        log(client,"Vous vous êtes téléporté à " + args[0]);
    }
}
