package App;

import Domains.Storages.Storage;
import Infrastructure.FileReader;
import Presentation.QuizController;

import java.nio.file.Path;
import java.util.Scanner;

public class App {

    private static final Path FILE_PATH = Path.of("src/main/resources/verbsIrregular.txt");

    public static void main(String[] args) {
        FileReader fileReader = new FileReader(FILE_PATH);
        Storage storage = new Storage(fileReader);
        Scanner scanner = new Scanner(System.in);

        QuizController quizController = new QuizController(storage, scanner);
        quizController.start();
    }

}
