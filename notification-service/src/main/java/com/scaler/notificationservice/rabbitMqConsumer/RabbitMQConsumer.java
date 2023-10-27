package com.scaler.notificationservice.rabbitMqConsumer;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import com.scaler.notificationservice.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RabbitMQConsumer {
    @Autowired
    private NotificationUpdateRepository repository;
    @Autowired
    private NotificationService notificationService;

   @RabbitListener(queues = "your-queue-name")
    public void receiveMessage(NotificationMessageRequest message) {
        if(Objects.nonNull(message)){
            notificationService.sendNotification(message);
        }
        else {
            throw new IllegalArgumentException("Received a null message. The message is required for processing.");
        }


    }


}
