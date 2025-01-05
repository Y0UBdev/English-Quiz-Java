package Presentation.patternCommands;

import Presentation.patternCommands.commands.Command;

public interface CommandsHandler {
    /**
     * Register the command
     * @param choice {@code int} - The choice
     * @param command {@code Command} - The command
     */
    void register(int choice, Command command);

    /**
     * Execute the command
     * @param choice {@code int} - The choice
     */
    void executeCommand(int choice);
}
