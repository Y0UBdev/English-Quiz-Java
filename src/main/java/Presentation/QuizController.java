package Presentation;

import Domains.quiz.IrregularsQuiz;
import Domains.storages.Storage;
import Domains.quiz.VocabQuiz;
import Presentation.patternCommands.CommandesHandlerImpl;
import Presentation.patternCommands.CommandsHandler;
import Presentation.patternCommands.Register;

import java.util.Scanner;

public class QuizController implements MainPresenter {

    private final IrregularsQuiz verbsQuiz;
    private final VocabQuiz vocabQuiz;

    private final Storage storage;

    private final Scanner scanner;

    private final CommandsHandler commandHandler = new CommandesHandlerImpl();

    private boolean running;

    public QuizController(Storage storage, Scanner scanner) {
        this.storage = storage;
        this.verbsQuiz = new IrregularsQuiz(storage.getVerbsMap(), scanner);
        this.vocabQuiz = new VocabQuiz(storage.getVocabularyMap(), scanner);
        this.scanner = scanner;
        this.running = true;
        registerCommands();
    }


    @Override
    public void start() {
        while (running) {
            int choice = displayMenu();
            commandHandler.executeCommand(choice);
        }
    }

    private void registerCommands() {
        Register commandRegisters = new Register(commandHandler, this, storage);
        commandRegisters.registerCommands(scanner, vocabQuiz, verbsQuiz);
    }

    private int displayMenu() {
        int choice;
        do {
            System.out.println("\nMenu : ");
            System.out.println("1. Vocabulaire");
            System.out.println("2. Verbes Irréguliers");
            System.out.println("3. Quitter");
            System.out.print("Choix ? ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
                choice = -1;
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }

    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }
}