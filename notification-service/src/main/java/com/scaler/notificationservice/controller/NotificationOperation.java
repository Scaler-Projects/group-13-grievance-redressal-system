package com.scaler.notificationservice.controller;

import com.scaler.notificationservice.model.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface NotificationOperation {
    @PostMapping
    ResponseEntity<Notification> sendNotification();
    @GetMapping("/{id}")
    ResponseEntity<Notification> getNotificationHistoryById(@PathVariable Long id);
}
