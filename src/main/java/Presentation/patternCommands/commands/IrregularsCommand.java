package Presentation.patternCommands.commands;

import Domains.quiz.IrregularsQuiz;
import Domains.storages.Storage;

import java.util.Scanner;

public class IrregularsCommand implements Command {
    private final IrregularsQuiz irregularsQuiz;

    private final Storage storage;

    private final Scanner scanner;

    public IrregularsCommand(IrregularsQuiz irregularsQuiz, Storage storage, Scanner scanner) {
        this.irregularsQuiz = irregularsQuiz;
        this.storage = storage;
        this.scanner = scanner;
    }

    public void execute() {
        int[] range = range();
        irregularsQuiz.startQuiz(range[0], range[1]);
    }

    private int[] range() {
        String size = String.format("(1-%d)", storage.getVerbsMap().size());
        System.out.printf("\nSur quelle partie voulez-vous être testée ? %s : ", size);

        String input = scanner.nextLine();
        String[] range = input.split("-");

        int startRange = Integer.parseInt(range[0].trim());
        int endRange = Integer.parseInt(range[1].trim());

        while (startRange > endRange
                || startRange < 1
                || endRange > storage.getVerbsMap().size()) {
            System.out.print("\nPlage invalide ! Veuillez re-encoder une valable : ");
            input = scanner.nextLine();
            range = input.split("-");

            startRange = Integer.parseInt(range[0].trim());
            endRange = Integer.parseInt(range[1].trim());
        }
        return new int[] { startRange, endRange };
    }
}
