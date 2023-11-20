package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;

import java.util.List;

public interface NotificationOperation {
    void sendNotification(NotificationMessageRequest notificationMessageRequest);

    List<Notification> getAllNotificationHistory();

}
