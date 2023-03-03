package emailPractise;

/*
library
[1] javax.mail.jar https://github.com/javaee/javamail/releases
[2] javax.activation-12.0.jar http://www.java2s.com/example/jar/j/download-javaxactivation120jar-file.html#google_vignette
* */

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private String recipient = "seong5763@gmail.com";

    private final String user = "seong5763@gmail.com";
    private final String password = "2차 앱 비밀번호";
    Properties properties;
    public Email() {
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(user, password);
           }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("this is a subject part");
            message.setText("This is a text part\nHello World!! How are you today?");
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
