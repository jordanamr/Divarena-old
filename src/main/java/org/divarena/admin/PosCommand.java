package org.divarena.admin;

import org.divarena.network.ArenaClient;

public class PosCommand extends Command {

    public PosCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        int x = client.getCoach().getX();
        int y = client.getCoach().getY();
        int z = client.getCoach().getZ();
        trace(client, x + ", " + y + ", " + z);
    }
}
