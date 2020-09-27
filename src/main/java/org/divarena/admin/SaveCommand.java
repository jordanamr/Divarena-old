package org.divarena.admin;

import org.divarena.Divarena;
import org.divarena.network.ArenaClient;

public class SaveCommand extends Command {

    public SaveCommand() {
        this.command = "save";
    }

    @Override
    public void execute(ArenaClient client, String[] args) {
        trace(client, "Sauvegarde du serveur en cours...");
        long startTime = System.currentTimeMillis();
        Divarena.getInstance().save();
        long endTime = System.currentTimeMillis();
        log(client, "Serveur et coachs sauvegardés en " + (endTime - startTime) + "ms !");
        //TODO
    }
}
