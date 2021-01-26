package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Objects.Email;
import com.vaibhav.Agora.Common.Utils.EmailUtilities;
import com.vaibhav.Agora.Service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendEmail(String recepient, String subject, String body) {
        Email email = new Email("sonofkryptonthesuperman@gmail.com", recepient, subject, body);
        try {
            EmailUtilities.sendMail(email);
            System.out.println("mail sent successfully");
        } catch (Exception e) {
            System.out.println("mail failed");
        }
    }
}
