package Domains;

import Domains.Entities.Verbs;

import java.util.*;

public class Quiz {

    private final Map<Integer, Verbs> verbs;
    private final Scanner scanner;

    public Quiz(Map<Integer, Verbs> verbs, Scanner scanner) {
        this.verbs = verbs;
        this.scanner = scanner;
    }

    public void startQuiz(int range) {
        List<Integer> keys = new ArrayList<>(verbs.keySet());
        keys.removeIf(key -> key > range);
        Collections.shuffle(keys);

        int score = 0;

        for (Integer key : keys) {
            Verbs verb = verbs.get(key);
            System.out.println("\nVerbes : " + verb.infinitive());

            System.out.print("Le prétérit ? ");
            String preterite = scanner.nextLine();

            System.out.print("Le part. passée ? ");
            String pastParticiple = scanner.nextLine();

            if (preterite.equalsIgnoreCase(verb.past())
                    && pastParticiple.equalsIgnoreCase(verb.participle())) {
                System.out.println("\nVous avez la bonne réponse !");
                score++;
            } else {
                System.out.printf("\nMauvaise Réponse, la bonne réponse était : %s, %s%n", verb.past(), verb.participle());
            }
        }

        System.out.println("\nVotre score : " + score + "/" + keys.size());
    }
}