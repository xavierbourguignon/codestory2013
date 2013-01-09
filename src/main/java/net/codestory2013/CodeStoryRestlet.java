package net.codestory2013;

import com.google.inject.Inject;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Form;

import static org.restlet.data.MediaType.TEXT_PLAIN;

public class CodeStoryRestlet extends Restlet {

    private final Mailer mailer;
    final static String QUESTION_2 = "Es tu abonne a la mailing list(OUI/NON)";
    final static String QUESTION_3 = "Es tu heureux de participer(OUI/NON)";

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

        if (QUESTION_2.equals(question) || QUESTION_3.equals(question)) {
            answer = "OUI";
        }

        response.setEntity(answer, TEXT_PLAIN);
    }
}
