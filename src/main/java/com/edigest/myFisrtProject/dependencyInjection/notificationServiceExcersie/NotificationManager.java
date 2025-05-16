package com.edigest.myFisrtProject.dependencyInjection.notificationServiceExcersie;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager(@Qualifier("EmailNotify") NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void sendNotification(String message) {
        notificationService.sendNotification(message);
    }
}
