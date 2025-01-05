package Domains.quiz;

import Domains.entities.Verbs;

import java.util.*;

public class IrregularsQuiz {

    private final Map<Integer, Verbs> verbs;

    private List<Verbs> errors;

    private final Scanner scanner;

    private float score;

    public IrregularsQuiz(Map<Integer, Verbs> verbs, Scanner scanner) {
        this.verbs = verbs;
        this.scanner = scanner;
        this.errors = new ArrayList<>();
        this.score = 0;
    }

    public void startQuiz(int start, int end) {
        List<Integer> keys = new ArrayList<>(verbs.keySet());
        keys.removeIf(key -> start > key || key > end);
        Collections.shuffle(keys);

        for (Integer key : keys) {
            Verbs verb = verbs.get(key);
            System.out.println("\nVerbes : (" + key + ") " + verb.infinitive());

            System.out.print("Le prétérit ? ");
            String preterite = scanner.nextLine();

            System.out.print("Le part. passée ? ");
            String pastParticiple = scanner.nextLine();

            verify(preterite, pastParticiple, verb);
        }

        System.out.println("\nVotre score : " + score + "/" + keys.size());
        System.out.println("\nLes erreurs : ");
        if (!errors.isEmpty()) errors.forEach(System.out::println);
            else System.out.print("Aucune erreur !");
    }

    private void verify(String preterite, String pastParticiple, Verbs verb) {
        boolean preteriteRequest      = preterite.equalsIgnoreCase(verb.past());
        boolean pastParticipleRequest = pastParticiple.equalsIgnoreCase(verb.participle());
        if (!preteriteRequest && !pastParticipleRequest) {
            errors.add(verb);
            System.out.printf("\nMauvaise Réponse, la bonne réponse était : %s, %s%n", verb.past(), verb.participle());
        } else if (preteriteRequest && pastParticipleRequest) {
            System.out.println("\nVous avez la bonne réponse !");
            score+=1;
        } else {
            errors.add(verb);
            String error;
            if (!preteriteRequest) error = messageError("preterit", verb.past());
            else error = messageError("participe passée", verb.participle());
            System.out.println(error);
            score+= 0.5F;
        }
    }

    private String messageError(String type, String request) {
        return String.format("\nLe %s n'est pas bon, la bonne réponse était : %s%n", type, request);
    }

    public void reset() {
        score = 0;
        errors = new ArrayList<>();
    }
}