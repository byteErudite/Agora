package com.vaibhav.Agora.Common.Utils;

import com.vaibhav.Agora.Common.Objects.Email;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

public class EmailUtilities {
    public static void sendMail(Email email) throws Exception{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = email.getSenderEmail();
        String password = "jaiganesh@1234";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, new Email(myAccountEmail, email.getReceipientEmail(),
                email.getSubject(), email.getBody()));
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, Email email) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getSenderEmail()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getReceipientEmail()));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            return  message;
        } catch (MessagingException e) {
            return null;
        }
    }

}
