package org.divarena.network;

import org.divarena.protocol.Message;

public abstract class Frame {

    protected ArenaClient client;

    protected Frame(ArenaClient client) {
        this.client = client;
    }

    protected boolean handle(Message message) {
        throw new UnsupportedOperationException();
    }
}
