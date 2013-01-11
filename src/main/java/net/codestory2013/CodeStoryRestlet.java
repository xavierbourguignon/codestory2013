package net.codestory2013;

import com.google.inject.Inject;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Form;

import java.util.HashSet;
import java.util.Set;

import static org.restlet.data.MediaType.TEXT_PLAIN;

public class CodeStoryRestlet extends Restlet {

    private final Mailer mailer;

    final static String QUESTION_1 = "Quelle est ton adresse email";
    final static String QUESTION_2 = "Es tu abonne a la mailing list(OUI/NON)";
    final static String QUESTION_3 = "Es tu heureux de participer(OUI/NON)";
    final static String QUESTION_4 = "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)";
    final static String QUESTION_5 = "Est ce que tu reponds toujours oui(OUI/NON)";
    final static String QUESTION_6 = "As tu bien recu le premier enonce(OUI/NON)";
    final static String QUESTION_7 = "1 1";

    final static Set<String> YES_QUESTIONS = new HashSet<String>() {{
        add(QUESTION_2);
        add(QUESTION_3);
        add(QUESTION_4);
        add(QUESTION_6);
    }};

    @Inject
    public CodeStoryRestlet(Mailer mailer) {
        this.mailer = mailer;
    }

    @Override
    public void handle(Request request, Response response) {
        mailer.sendRequest(request);
        Form form = request.getResourceRef().getQueryAsForm();
        String question = form.getValues("q");
        String answer = "xavierbourguignon@gmail.com";

        if (!QUESTION_1.equals(question)) {
            answer = YES_QUESTIONS.contains(question) ? "OUI" : "NON";
        }

        if (QUESTION_7.equals(question)) {
            answer = "2";
        }

        response.setEntity(answer, TEXT_PLAIN);
    }
}
