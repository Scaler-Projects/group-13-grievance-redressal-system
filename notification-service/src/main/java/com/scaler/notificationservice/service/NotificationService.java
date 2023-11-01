package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService implements NotificationOperation {

    private final NotificationUpdateRepository repository;

    private  EmailService emailService;

    private  SMSService smsService;
    @Autowired
    public NotificationService(NotificationUpdateRepository repository, EmailService emailService, SMSService smsService) {
        this.repository = repository;
        this.emailService = emailService;
        this.smsService = smsService;
    }


    public void sendNotification(NotificationMessageRequest message) {
        emailService.fetchEmailFromDbAndSend(message);
        smsService.fetchNumberFromDbAndSend(message);
        saveNotificationValueToDatabase(message);

    }

    private void saveNotificationValueToDatabase(NotificationMessageRequest message) {
        Notification notification = new Notification();
        notification.setGrievanceId(message.getGrievanceId());
        notification.setNotificationTime(message.getNotificationTime());
        notification.setNotifiedUser(message.getNotifiedUser());
        notification.setNewState(message.getNewState());
        notification.setPrevState(message.getPrevState());
        notification.setUpdatedBy(message.getUpdatedBy());

        repository.save(notification);



    }
}
