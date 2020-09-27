package org.divarena.admin;

import lombok.Getter;
import org.divarena.network.ArenaClient;
import org.divarena.protocol.server.admin.ConsoleAdminCommandResultMessage;

public abstract class Command {

    @Getter
    protected String command;

    public void execute(ArenaClient client, String[] args) {
        throw new UnsupportedOperationException();
    }

    protected void trace(ArenaClient client, String message) {
        ConsoleAdminCommandResultMessage response = new ConsoleAdminCommandResultMessage();
        response.setType(ConsoleAdminCommandResultMessage.Type.TRACE);
        response.setMessage(message);
        client.sendMessage(response);
    }

    protected void log(ArenaClient client, String message) {
        ConsoleAdminCommandResultMessage response = new ConsoleAdminCommandResultMessage();
        response.setType(ConsoleAdminCommandResultMessage.Type.LOG);
        response.setMessage(message);
        client.sendMessage(response);
    }

    protected void error(ArenaClient client, String message) {
        ConsoleAdminCommandResultMessage response = new ConsoleAdminCommandResultMessage();
        response.setType(ConsoleAdminCommandResultMessage.Type.ERROR);
        response.setMessage(message);
        client.sendMessage(response);
    }
}
