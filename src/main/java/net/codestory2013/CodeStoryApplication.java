package net.codestory2013;

import com.google.inject.Inject;
import org.restlet.Application;
import org.restlet.Restlet;

public class CodeStoryApplication extends Application {

    private final CodeStoryRestlet restlet;

    @Inject
    public CodeStoryApplication(CodeStoryRestlet restlet) {
        this.restlet = restlet;
    }

    @Override
    public Restlet createInboundRoot() {
        return restlet;
    }
}
