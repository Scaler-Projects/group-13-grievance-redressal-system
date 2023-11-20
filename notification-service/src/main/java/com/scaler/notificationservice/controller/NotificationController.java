package com.scaler.notificationservice.controller;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.rabbitMqConsumer.MessageSender;
import com.scaler.notificationservice.rabbitMqConsumer.RabbitMQConsumer;
import com.scaler.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/notifications")
public class NotificationController implements NotificationOperation {
   private RabbitMQConsumer rabbitMQConsumer;
   private MessageSender messageSender;

   private NotificationService notificationService;
    @Autowired
    public NotificationController(RabbitMQConsumer rabbitMQConsumer,MessageSender messageSender,NotificationService notificationService) {
        this.rabbitMQConsumer = rabbitMQConsumer;
        this.messageSender=messageSender;
        this.notificationService=notificationService;
    }

    @Override
    public ResponseEntity<Notification> getNotificationHistoryById(Long id) {
      System.out.println("Notification Class");
        NotificationMessageRequest notificationMessageRequest = new NotificationMessageRequest();

        notificationMessageRequest.setNotificationTime(System.currentTimeMillis());
        notificationMessageRequest.setGrievanceId(id);
        notificationMessageRequest.setNewState("U-Test start-3");
        notificationMessageRequest.setPrevState("U-Test start-2");
        notificationMessageRequest.setUpdatedBy("Admin");
        notificationMessageRequest.setNotifiedUser("keerti");
        rabbitMQConsumer.receiveMessage(notificationMessageRequest);


       return new ResponseEntity<>(new Notification(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity sendNotification(NotificationMessageRequest message) {
        messageSender.sendMessage(message);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Notification>> getAllNotificationHistory() {
        List<Notification> notification=notificationService.getAllNotificationHistory();
        return new ResponseEntity<>(notification,HttpStatus.OK);
    }

}
