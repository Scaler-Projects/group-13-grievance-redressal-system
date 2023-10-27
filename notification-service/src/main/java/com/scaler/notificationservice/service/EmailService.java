package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    NotificationUpdateRepository notificationUpdateRepository;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void fetchEmailFromDbAndSend() {
       // TODO Call Grievence Service to fetch current grivence_id using Rest or Feing
        NotificationMessageRequest message = new NotificationMessageRequest();
        int grievanceId = message.getGrievance_id();
        String prev_state = null;
        String new_state = null;


        // Fetch the notified_user's email address from the database based on the grievance_id
        String email = notificationUpdateRepository.findEmailByGrievanceId(grievanceId);

        Object[] result=notificationUpdateRepository.findFieldsByGrievanceId(grievanceId);
        if (result != null && result.length == 3) {
            prev_state = (String) result[0];
            new_state = (String) result[1];

        }
        // Send Email to recipient
        String messageBody=prev_state + " " +new_state;
        sendEmail(email, "state", messageBody);

    }
}
