package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.NotificationMessageRequest;

public interface NotificationOperation {
    void sendNotification(NotificationMessageRequest notificationMessageRequest);
}
