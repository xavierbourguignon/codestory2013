package net.codestory2013;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import static java.lang.Integer.parseInt;

public class CodeStoryApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        MailerFilter mailerFilter1 = new MailerFilter(getContext());
        mailerFilter1.setNext(QuestionsResource.class);

        MailerFilter mailerFilter2 = new MailerFilter(getContext());
        mailerFilter2.setNext(ScalaskelResource.class);

        router.attach("/", mailerFilter1);
        router.attach("/scalaskel/change/{number}", mailerFilter2);
        return router;
    }

}
