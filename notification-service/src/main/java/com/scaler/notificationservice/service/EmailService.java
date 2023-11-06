package com.scaler.notificationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.model.UsersEntity;
import com.scaler.notificationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;

    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("razamustafa.8@gmail.com");
        message.setSubject("subject");
        message.setText(text);
        javaMailSender.send(message);
    }

    public void fetchEmailFromDbAndSend(NotificationMessageRequest message)  {

        String userName = message.getNotifiedUser();
        UsersEntity user = userRepository.findByUsername(userName);
        String email="";
        String phNo="";
        if(Objects.nonNull(user)) {
            email = user.getEmail();
            phNo = user.getPhone_number();
        }

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("newState", message.getNewState());
        mapBody.put("prevState", message.getPrevState());
        mapBody.put("updatedBy", message.getUpdatedBy());
        String body="";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            body= objectMapper.writeValueAsString(mapBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



        sendEmail(email, phNo, body);


    }

}

