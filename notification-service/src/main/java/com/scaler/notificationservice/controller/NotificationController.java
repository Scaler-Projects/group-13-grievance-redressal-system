package com.scaler.notificationservice.controller;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.service.EmailService;
import com.scaler.notificationservice.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/notifications")
public class NotificationController implements NotificationOperation {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SMSService smsService;


    @Override
    public ResponseEntity<Notification> sendNotification() {
        emailService.fetchEmailFromDbAndSend();
        smsService.fetchNumberFromDbAndSend();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Notification> getNotificationHistoryById(Long id) {
        //TODO Implement Notification History
       return null;
    }
}
