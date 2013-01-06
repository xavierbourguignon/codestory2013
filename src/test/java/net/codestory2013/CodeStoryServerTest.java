package net.codestory2013;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CodeStoryServerTest {

    CodeStoryServer codeStoryServer = new CodeStoryServer();

    @Test
    public void shouldReplyByMail() {
        assertThat(codeStoryServer.toString()).isEqualTo("xavierbourguignon@gmail.com");
    }
}
