package net.codestory2013;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.restlet.Server;
import org.restlet.resource.ServerResource;

import static java.lang.Integer.parseInt;
import static org.restlet.data.Protocol.HTTP;

public class CodeStoryServer extends ServerResource {

    public static void main(String... args) throws Exception {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        Server server = new Server(HTTP, parseInt(webPort));
        Injector injector = Guice.createInjector(new CodeStoryModule());
        CodeStoryApplication application = injector.getInstance(CodeStoryApplication.class);
        server.setNext(application);
        server.start();
    }
}
