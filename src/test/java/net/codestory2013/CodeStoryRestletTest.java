package net.codestory2013;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Reference;

import static org.mockito.Mockito.*;
import static org.restlet.data.MediaType.TEXT_PLAIN;

@RunWith(MockitoJUnitRunner.class)
public class CodeStoryRestletTest {

    @Mock
    Mailer mailer;

    @Mock
    Response response;

    @InjectMocks
    CodeStoryRestlet restlet;

    @Test
    public void shouldReplyByMail() {
        Request request = prepareMockRequest("Quelle est ton adresse email");
        restlet.handle(request, response);
        verify(response).setEntity("xavierbourguignon@gmail.com", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByOUI() {
        Request request = prepareMockRequest("Es tu abonne a la mailing list(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("OUI", TEXT_PLAIN);
    }

    private static Request prepareMockRequest(String question) {
        Request request = mock(Request.class);
        Reference reference = mock(Reference.class);
        Form form = mock(Form.class);
        when(request.getResourceRef()).thenReturn(reference);
        when(reference.getQueryAsForm()).thenReturn(form);
        when(form.getValues(anyString())).thenReturn(question);
        return request;
    }
}
