package Presentation.patternCommands.commands;

import Domains.quiz.VocabQuiz;

public class VocabularyCommand implements Command {
    private final VocabQuiz vocabQuiz;

    public VocabularyCommand(VocabQuiz vocabQuiz) {
        this.vocabQuiz = vocabQuiz;
    }

    public void execute() {
        vocabQuiz.startQuiz();
    }
}
