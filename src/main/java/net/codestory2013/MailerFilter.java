package net.codestory2013;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.routing.Filter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static java.lang.System.err;
import static javax.mail.Message.RecipientType.TO;

public class MailerFilter extends Filter {

    private Properties props = new Properties() {{
        put("mail.smtp.auth", "true");
        put("mail.smtp.starttls.enable", "true");
        put("mail.smtp.host", "smtp.gmail.com");
        put("mail.smtp.port", "587");
    }};

    private Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(System.getenv("GMAIL_USERNAME"), System.getenv("GMAIL_PASSWORD"));
                }
            });

    public MailerFilter(Context context) {
        super(context);
    }

    @Override
    protected int beforeHandle(Request request, Response response) {
        String text = "New request on code story Server:" +
                " \nMethod       : " + request.getMethod()
                + "\nResource URI : " + request.getResourceRef()
                + "\nRequest Body: " + request.getEntityAsText();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xavierbourguignon@gmail.com"));
            message.setRecipients(TO, InternetAddress.parse("xavierbourguignon@gmail.com"));
            message.setSubject("New Request on code story Server");
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            err.println("Unable to send message");
        }

        return CONTINUE;
    }
}
