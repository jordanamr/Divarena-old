package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.world.EnterInstanceMessage;

public class TpPosCommand extends Command {

    public TpPosCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        if (args.length < 3) {
            log(client, "Utilisation: tppos [x] [y] [z]");
            return;
        }
        if (args[0].equalsIgnoreCase("start")) {
            int x = Divarena.getInstance().getConfig().getInt("start.x");
            int y = Divarena.getInstance().getConfig().getInt("start.y");
            int z = Divarena.getInstance().getConfig().getInt("start.z");
            client.getInstance().removeMember(client.getCoach());
            client.getCoach().setX(x);
            client.getCoach().setY(y);
            client.getCoach().setZ(z);
            client.sendMessage(new EnterInstanceMessage(client.getCoach()));
            client.getInstance().addMember(client.getCoach());
            log(client,"Vous vous êtes téléporté aux coordonnées " + x + ", " + y + ", " + z);
            return;
        }
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);
            client.getInstance().removeMember(client.getCoach());
            client.getCoach().setX(x);
            client.getCoach().setY(y);
            client.getCoach().setZ(z);
            client.sendMessage(new EnterInstanceMessage(client.getCoach()));
            client.getInstance().addMember(client.getCoach());
            log(client,"Vous vous êtes téléporté aux coordonnées " + x + ", " + y + ", " + z);
        } catch (NumberFormatException ex) {
            error(client, "Arguments invalide.");
        }
    }
}
