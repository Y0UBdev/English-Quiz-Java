package Domains.quiz;

import java.util.*;

public class VocabQuiz {

    private final Map<String, List<String>> vocabulary;
    private final Scanner scanner;

    public VocabQuiz(Map<String, List<String>> vocabulary, Scanner scanner) {
        this.vocabulary = vocabulary;
        this.scanner = scanner;
    }

    public void startQuiz() {
        System.out.println("\nSur quelle partie voulez-vous vous entraîner ?");
        System.out.println("0. Tous");
        List<String> categories = new ArrayList<>(vocabulary.keySet());

        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        System.out.print("Choix ? ");

        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 0) {
            startCategoryQuiz("Tous");
        } else if (choice > 0 && choice <= categories.size()) {
            String category = categories.get(choice - 1);
            startCategoryQuiz(category);
        } else {
            System.out.println("Choix invalide !");
        }
    }

    private void startCategoryQuiz(String category) {
        List<String> words = category.equals("Tous")
                ? new ArrayList<>(vocabulary.values().stream().flatMap(List::stream).toList())
                : new ArrayList<>(vocabulary.get(category));

        Collections.shuffle(words);
        int score = 0;

        for (String wordPair : words) {
            if (!wordPair.contains(" - ")) {
                System.out.printf("Erreur de format dans : %s. Ignoré.%n", wordPair);
                continue;
            }

            String[] pair = wordPair.split(" - ");
            String english = pair[0].trim();
            String french = pair[1].trim();

            System.out.println("\nVocabulaire : " + french);
            System.out.print("Réponse ? ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(english)) {
                System.out.println("Correct !");
                score++;
            } else {
                System.out.printf("Faux ! La bonne réponse était : %s%n", english);
            }
        }

        System.out.println("\nScore : " + score + "/" + words.size());
    }

}