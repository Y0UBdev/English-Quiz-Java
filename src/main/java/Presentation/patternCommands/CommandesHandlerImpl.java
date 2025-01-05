package Presentation.patternCommands;

import Presentation.patternCommands.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandesHandlerImpl implements CommandsHandler {

    private final Map<Integer, Command> registers = new HashMap<>();

    @Override
    public void register(int choice, Command command) {
        registers.put(choice, command);
    }

    @Override
    public void executeCommand(int choice) {
        Command command = registers.get(choice);
        if (command != null) {
            command.execute();
        }
    }
}
