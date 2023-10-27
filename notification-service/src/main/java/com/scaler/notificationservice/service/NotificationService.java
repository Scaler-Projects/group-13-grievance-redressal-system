package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.rabbitMqConsumer.RabbitMQConsumer;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class NotificationService implements NotificationOperation {
    @Autowired
    private NotificationUpdateRepository repository;
    @Override
    public void sendNotification(NotificationMessageRequest message) {
        Notification notification= new Notification();
        Optional<Notification> existingRecord = repository.findByGrievanceId(message.getGrievance_id());
        saveNotificationValueToDatabase(existingRecord, notification, message);

    }

    private void saveNotificationValueToDatabase(Optional<Notification> existingRecord, Notification notification, NotificationMessageRequest message) {
        if (existingRecord.isPresent()) {
            notification.setNew_state(message.getNew_state());
            notification.setPrev_state(message.getPrev_state());
            notification.setUpdated_by(message.getUpdated_by());
            repository.save(notification);
        }else {
            notification.setGrievance_id(message.getGrievance_id());
            notification.setNew_state(message.getNew_state());
            notification.setPrev_state(message.getPrev_state());
            notification.setUpdated_by(message.getUpdated_by());
            notification.setNotification_time(message.getNotification_time());
            repository.save(notification);
        }
    }
}
