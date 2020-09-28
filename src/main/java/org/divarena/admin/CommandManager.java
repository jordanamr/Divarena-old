package org.divarena.admin;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static CommandManager instance = null;

    public static CommandManager getInstance() {
        if (instance == null) instance = new CommandManager();
        return instance;
    }

    @Getter
    private final Map<String, Command> commands;

    public CommandManager() {
        this.commands = Collections.synchronizedMap(new HashMap<>());
        commands.put("help", new HelpCommand("help"));
        commands.put("save", new SaveCommand("save"));
        commands.put("tp", new TpCommand("tp"));
        commands.put("tphere", new TpHereCommand("tphere"));
        commands.put("tppos", new TpPosCommand("tppos"));
        commands.put("givecard", new GiveCardCommand("givecard"));
        commands.put("list", new ListCommand("list"));
    }

    public Command getCommand(String alias) {
        return commands.get(alias);
    }
}
