package org.divarena.protocol.client.admin;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;

public class ConsoleAdminCommandMessage extends Message {

    @Getter
    private String command;

    public ConsoleAdminCommandMessage() {
        this.id = 8193;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte[] cmdData = new byte[buf.get()];
        buf.get(cmdData);
        this.command = new String(cmdData);
        return true;
    }
}
