package Presentation.patternCommands;

import Domains.quiz.IrregularsQuiz;
import Domains.quiz.VocabQuiz;
import Domains.storages.Storage;
import Presentation.MainPresenter;
import Presentation.patternCommands.commands.IrregularsCommand;
import Presentation.patternCommands.commands.VocabularyCommand;

import java.util.Scanner;

public class Register {

    private final CommandsHandler commandsHandler;
    private final MainPresenter presenter;
    private final Storage storage;

    public Register(CommandsHandler commandsHandler, MainPresenter presenter, Storage storage) {
        this.commandsHandler = commandsHandler;
        this.presenter = presenter;

        this.storage = storage;
    }

    public void registerCommands(Scanner scanner, VocabQuiz vocabQuiz, IrregularsQuiz irregularsQuiz) {
        commandsHandler.register(1, new VocabularyCommand(vocabQuiz));
        commandsHandler.register(2, new IrregularsCommand(irregularsQuiz, storage, scanner));
        commandsHandler.register(3, () -> {
            presenter.setRunning(false);
            System.out.println("Au revoir !");
        });
    }
}
