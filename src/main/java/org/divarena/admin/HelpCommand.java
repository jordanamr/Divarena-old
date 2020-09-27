package org.divarena.admin;

import org.divarena.network.ArenaClient;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.command = "help";
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        trace(client, "Liste des commandes serveur: help, save");
        //TODO
    }
}
