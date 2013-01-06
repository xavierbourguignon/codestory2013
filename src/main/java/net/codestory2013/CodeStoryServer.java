package net.codestory2013;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import static java.lang.Integer.parseInt;

public class CodeStoryServer extends ServerResource {

    public static void main(String... args) throws Exception {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        new Server(Protocol.HTTP, parseInt(webPort), CodeStoryServer.class).start();
    }

    @Get
    public String toString() {
        return "xavierbourguignon@gmail.com";
    }
}
