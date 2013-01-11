package net.codestory2013;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.HashSet;
import java.util.Set;

public class QuestionsResource extends ServerResource {

    final static String QUESTION_1 = "Quelle est ton adresse email";
    final static String QUESTION_2 = "Es tu abonne a la mailing list(OUI/NON)";
    final static String QUESTION_3 = "Es tu heureux de participer(OUI/NON)";
    final static String QUESTION_4 = "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)";
    final static String QUESTION_5 = "Est ce que tu reponds toujours oui(OUI/NON)";
    final static String QUESTION_6 = "As tu bien recu le premier enonce(OUI/NON)";
    final static String QUESTION_7 = "1 1";
    final static String QUESTION_8 = "2 2";

    final static Set<String> YES_QUESTIONS = new HashSet<String>() {{
        add(QUESTION_2);
        add(QUESTION_3);
        add(QUESTION_4);
        add(QUESTION_6);
    }};

    @Get("txt")
    public String answer() {
        String answer = "xavierbourguignon@gmail.com";
        String question = getQueryValue("q");

        if (!QUESTION_1.equals(question)) {
            answer = YES_QUESTIONS.contains(question) ? "OUI" : "NON";
        }

        if (QUESTION_7.equals(question)) {
            answer = "2";
        }

        if (QUESTION_8.equals(question)) {
            answer = "4";
        }

        return answer;
    }
}
