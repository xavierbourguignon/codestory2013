package net.codestory2013;

import org.restlet.Component;
import org.restlet.Server;

import static java.lang.Integer.parseInt;
import static org.restlet.data.Protocol.HTTP;

public class CodeStoryComponent extends Component {

    public static void main(String... args) throws Exception {
        new CodeStoryComponent().start();
    }

    public CodeStoryComponent() {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        Server server = getServers().add(HTTP, parseInt(webPort));
        getDefaultHost().attachDefault(new CodeStoryApplication());
    }
}
