package org.divarena.admin;

import lombok.Getter;
import org.divarena.network.ArenaClient;

public abstract class Command {

    @Getter
    protected String command;

    public void execute(ArenaClient client, String[] args) {
        throw new UnsupportedOperationException();
    }
}
