package org.divarena.protocol.client.initial;

import lombok.Getter;
import org.divarena.protocol.Message;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ClientAuthenticationMessage extends Message {

    @Getter
    private String username;
    @Getter
    private String password;

    public ClientAuthenticationMessage() {
        this.id = 1025;
    }

    @Override
    public boolean decode(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        byte usernameLength = buf.get();
        byte[] username = new byte[usernameLength];
        buf.get(username);
        this.username = new String(username, StandardCharsets.UTF_8);
        byte passwordLength = buf.get();
        byte[] password = new byte[passwordLength];
        buf.get(password);
        this.password = new String(password, StandardCharsets.UTF_8);
        return true;
    }
}
