package net.codestory2013;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.restlet.Request;
import org.restlet.Response;

import static org.mockito.Mockito.verify;
import static org.restlet.data.MediaType.TEXT_PLAIN;

@RunWith(MockitoJUnitRunner.class)
public class CodeStoryRestletTest {

    @Mock
    Mailer mailer;

    @Mock
    Request request;

    @Mock
    Response response;

    @InjectMocks
    CodeStoryRestlet restlet;

    @Test
    public void shouldReplyByMail() {
        restlet.handle(request, response);
        verify(response).setEntity("xavierbourguignon@gmail.com", TEXT_PLAIN);
    }
}
