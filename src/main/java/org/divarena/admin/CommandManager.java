package org.divarena.admin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static CommandManager instance = null;

    public static CommandManager getInstance() {
        if (instance == null) instance = new CommandManager();
        return instance;
    }

    private final Map<String, Command> commands;

    public CommandManager() {
        this.commands = Collections.synchronizedMap(new HashMap<>());
        commands.put("help", new HelpCommand());
        commands.put("save", new SaveCommand());
    }

    public Command getCommand(String alias) {
        return commands.get(alias);
    }
}
