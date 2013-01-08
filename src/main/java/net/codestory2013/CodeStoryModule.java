package net.codestory2013;

import com.google.inject.AbstractModule;

public class CodeStoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Mailer.class);
        bind(CodeStoryRestlet.class);
        bind(CodeStoryApplication.class);
    }
}
