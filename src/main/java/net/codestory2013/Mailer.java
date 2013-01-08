package net.codestory2013;

import org.restlet.Request;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;

public class Mailer {

    Properties props = new Properties() {{
        put("mail.smtp.auth", "true");
        put("mail.smtp.starttls.enable", "true");
        put("mail.smtp.host", "smtp.gmail.com");
        put("mail.smtp.port", "587");
    }};

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(System.getenv("GMAIL_USERNAME"), System.getenv("GMAIL_PASSWORD"));
                }
            });

    public void sendRequest(Request request) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xavierbourguignon@gmail.com"));
            message.setRecipients(TO, InternetAddress.parse("xavierbourguignon@gmail.com"));
            message.setSubject("New Request on code story Server");
            message.setText("New request on code story Server:" +
                    " \nMethod       : " + request.getMethod()
                    + "\nResource URI : " + request.getResourceRef()
                    + "\nIP address   : " + request.getClientInfo().getAddress()
                    + "\nAgent name   : " + request.getClientInfo().getAgentName()
                    + "\nAgent version: " + request.getClientInfo().getAgentVersion());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
