package App;

import Presentation.views.View;
import Views.main.MainView;

import java.nio.file.Path;

public class App {

    private static final Path FILE_PATH_VERBS = Path.of("src/main/resources/englishVerbsList.txt");
    private static final Path FILE_PATH_VOCAB = Path.of("src/main/resources/englishVocabularies.txt");

    public static void main(String[] args) {
        View view = new MainView();
        view.launch();
    }

}

////        VocabReader vocabReader = new VocabReader(FILE_PATH_VOCAB);
////        VerbsIrregularReader verbsIrregularReader = new VerbsIrregularReader(FILE_PATH_VERBS);
////        Storage storage = new Storage(verbsIrregularReader, vocabReader);
////        Scanner scanner = new Scanner(System.in);
////
////        QuizPresenter quizController = new QuizPresenter(storage, scanner);
////        quizController.start();