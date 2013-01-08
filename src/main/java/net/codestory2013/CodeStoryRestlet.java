package net.codestory2013;

import com.google.inject.Inject;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;

import static org.restlet.data.MediaType.TEXT_PLAIN;

public class CodeStoryRestlet extends Restlet {

    private final Mailer mailer;

    @Inject
    public CodeStoryRestlet(Mailer mailer) {
        this.mailer = mailer;
    }

    @Override
    public void handle(Request request, Response response) {
        mailer.sendRequest(request);
        response.setEntity("xavierbourguignon@gmail.com", TEXT_PLAIN);
    }

}
