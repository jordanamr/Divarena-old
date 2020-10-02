package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.network.ArenaClient;

import java.util.Iterator;

public class ListCommand extends Command {

    public ListCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        StringBuilder builder = new StringBuilder("Joueurs en ligne (" + Divarena.getInstance().getClients().size() + "): ");
        Iterator<ArenaClient> it = Divarena.getInstance().getClients().iterator();
        while (it.hasNext()) {
            ArenaClient onlineClient = it.next();
            if (onlineClient.getAccountName() == null) continue;
            builder.append(onlineClient.getCoachName());
            builder.append(" (");
            builder.append(onlineClient.getAccountName());
            builder.append(")");
            if (it.hasNext()) builder.append(", ");
        }
        log(client, builder.toString());
    }
}
