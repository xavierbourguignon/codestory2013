package net.codestory2013;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CodeStoryRestletTest {

    private static QuestionsResource getQuestionsResource(String question) {
        QuestionsResource questionsResource = mock(QuestionsResource.class);
        when(questionsResource.getQueryValue("q")).thenReturn(question);
        when(questionsResource.answer()).thenCallRealMethod();
        return questionsResource;
    }

    @Test
    public void shouldReplyByMailtoQuelle_est_ton_adresse_email() {
        QuestionsResource questionsResource = getQuestionsResource("Quelle est ton adresse email");
        assertThat(questionsResource.answer()).isEqualTo("xavierbourguignon@gmail.com");
    }

    @Test
    public void shouldReplyByOUItoEs_tu_abonne_a_la_mailing_list_OUI_NON() {
        QuestionsResource questionsResource = getQuestionsResource("Es tu abonne a la mailing list(OUI/NON)");
        assertThat(questionsResource.answer()).isEqualTo("OUI");
    }

    @Test
    public void shouldReplyByOUItoEs_tu_heureux_de_participer_OUI_NON() {
        QuestionsResource questionsResource = getQuestionsResource("Es tu heureux de participer(OUI/NON)");
        assertThat(questionsResource.answer()).isEqualTo("OUI");
    }

    @Test
    public void shouldReplyByOUItoEs_tu_pret_a_recevoir_une_enonce_au_format_markdown_par_http_post_OUI_NON() {
        QuestionsResource questionsResource = getQuestionsResource("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)");
        assertThat(questionsResource.answer()).isEqualTo("OUI");
    }

    @Test
    public void shouldReplyByOUItoAs_tu_bien_recu_le_premier_enonce_OUI_NON() {
        QuestionsResource questionsResource = getQuestionsResource("As tu bien recu le premier enonce(OUI/NON)");
        assertThat(questionsResource.answer()).isEqualTo("OUI");
    }

    @Test
    public void shouldReplyByNONtoEst_ce_que_tu_reponds_toujours_oui_OUI_NON() {
        QuestionsResource questionsResource = getQuestionsResource("Est ce que tu reponds toujours oui(OUI/NON)");
        assertThat(questionsResource.answer()).isEqualTo("NON");
    }

    @Test
    public void shouldReply2to1plus1() {
        QuestionsResource questionsResource = getQuestionsResource("1 1");
        assertThat(questionsResource.answer()).isEqualTo("2");
    }

    @Test
    public void shouldReply4to2plus2() {
        QuestionsResource questionsResource = getQuestionsResource("2 2");
        assertThat(questionsResource.answer()).isEqualTo("4");
    }
}
