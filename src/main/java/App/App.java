package App;

import Domains.storages.Storage;
import Infrastructure.VerbsIrregularReader;
import Infrastructure.VocabReader;
import Presentation.QuizController;

import java.nio.file.Path;
import java.util.Scanner;

public class App {

    private static final Path FILE_PATH_VERBS = Path.of("src/main/resources/englishVerbsList.txt");
    private static final Path FILE_PATH_VOCAB = Path.of("src/main/resources/englishVocabularies.txt");

    public static void main(String[] args) {

        VocabReader vocabReader = new VocabReader(FILE_PATH_VOCAB);
        VerbsIrregularReader verbsIrregularReader = new VerbsIrregularReader(FILE_PATH_VERBS);
        Storage storage = new Storage(verbsIrregularReader, vocabReader);
        Scanner scanner = new Scanner(System.in);

        QuizController quizController = new QuizController(storage, scanner);
        quizController.start();
    }

}
