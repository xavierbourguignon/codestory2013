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
    public void shouldReplyByMailtoQuelle_est_ton_adresse_email() {
        Request request = prepareMockRequest("Quelle est ton adresse email");
        restlet.handle(request, response);
        verify(response).setEntity("xavierbourguignon@gmail.com", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByOUItoEs_tu_abonne_a_la_mailing_list_OUI_NON() {
        Request request = prepareMockRequest("Es tu abonne a la mailing list(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("OUI", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByOUItoEs_tu_heureux_de_participer_OUI_NON() {
        Request request = prepareMockRequest("Es tu heureux de participer(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("OUI", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByOUItoEs_tu_pret_a_recevoir_une_enonce_au_format_markdown_par_http_post_OUI_NON() {
        Request request = prepareMockRequest("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("OUI", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByOUItoAs_tu_bien_recu_le_premier_enonce_OUI_NON() {
        Request request = prepareMockRequest("As tu bien recu le premier enonce(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("OUI", TEXT_PLAIN);
    }

    @Test
    public void shouldReplyByNONtoEst_ce_que_tu_reponds_toujours_oui_OUI_NON() {
        Request request = prepareMockRequest("Est ce que tu reponds toujours oui(OUI/NON)");
        restlet.handle(request, response);
        verify(response).setEntity("NON", TEXT_PLAIN);
    }

    @Test
    public void shouldReply2to1plus1() {
        Request request = prepareMockRequest("1 1");
        restlet.handle(request, response);
        verify(response).setEntity("2", TEXT_PLAIN);
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
