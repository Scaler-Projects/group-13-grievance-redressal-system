package com.scaler.notificationservice.controller;

import com.scaler.notificationservice.model.Notification;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface NotificationOperation {

    @GetMapping("/{id}")
    ResponseEntity<Notification> getNotificationHistoryById(@PathVariable Long id);
    @PostMapping("/send-notification")
    ResponseEntity sendNotification(@RequestBody NotificationMessageRequest message);

    @GetMapping("/notification-History")
    ResponseEntity<List<Notification>> getAllNotificationHistory();
}
