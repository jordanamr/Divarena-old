package org.divarena.admin;

import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.admin.ConsoleAdminCommandResultMessage;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.command = "help";
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        ConsoleAdminCommandResultMessage response = new ConsoleAdminCommandResultMessage();
        response.setType(ConsoleAdminCommandResultMessage.Type.TRACE);
        response.setMessage("Liste des commandes serveur: help, save");
        client.sendMessage(response);
        //TODO
    }
}
