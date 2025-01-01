package Presentation;

import Domains.Quiz;
import Domains.Storage;

import java.util.Scanner;

public class QuizController {

    private final Quiz quiz;
    private final Storage storage;

    public QuizController(Storage storage, Scanner scanner) {
        this.quiz = new Quiz(storage.getVerbsMap(), scanner);
        this.storage = storage;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueQuiz = false;

        do {
            String size = String.format("(1-%d)", storage.getVerbsMap().size());
            System.out.printf("Sur quelle partie voulez-vous être testée ? %s : ", size);
            String input = scanner.nextLine();
            String[] range = input.split("-");
            int startRange = Integer.parseInt(range[0].trim());
            int endRange = Integer.parseInt(range[1].trim());

            if (startRange > endRange
                    || startRange < 1 || endRange > storage.getVerbsMap().size()) {
                System.out.println("Plage invalide ! Assurez-vous que le premier nombre est inférieur ou égal au second.");
                continue;
            }

            quiz.startQuiz(endRange);

            System.out.print("Voulez-vous continuer (O/N) ? ");
            continueQuiz = scanner.nextLine().equalsIgnoreCase("O");
        } while (continueQuiz);
    }
}
