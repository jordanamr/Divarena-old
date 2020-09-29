package org.divarena.admin;

import org.divarena.network.ArenaClient;

import java.util.Iterator;

public class HelpCommand extends Command {

    public HelpCommand(String alias) {
        super(alias);
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        StringBuilder builder = new StringBuilder("Liste des commandes serveur (" + CommandManager.getInstance().getCommands().size() + "): ");
        Iterator<Command> it = CommandManager.getInstance().getCommands().values().iterator();
        while (it.hasNext()) {
            builder.append(it.next().getCommand());
            if (it.hasNext()) builder.append(", ");
        }
        log(client, builder.toString());
    }
}
