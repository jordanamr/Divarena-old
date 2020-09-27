package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.admin.ConsoleAdminCommandResultMessage;

public class SaveCommand extends Command {

    public SaveCommand() {
        this.command = "save";
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        ConsoleAdminCommandResultMessage response1 = new ConsoleAdminCommandResultMessage();
        response1.setType(ConsoleAdminCommandResultMessage.Type.TRACE);
        response1.setMessage("Sauvegarde du serveur en cours...");
        client.sendMessage(response1);

        long startTime = System.currentTimeMillis();
        Divarena.getInstance().save();
        long endTime = System.currentTimeMillis();

        ConsoleAdminCommandResultMessage response2 = new ConsoleAdminCommandResultMessage();
        response2.setType(ConsoleAdminCommandResultMessage.Type.LOG);
        response2.setMessage("Serveur et coachs sauvegardés en " + (endTime - startTime) + "ms !");
        client.sendMessage(response2);
        //TODO
    }
}
