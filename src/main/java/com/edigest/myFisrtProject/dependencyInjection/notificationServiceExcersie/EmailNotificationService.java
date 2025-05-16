package com.edigest.myFisrtProject.dependencyInjection.notificationServiceExcersie;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("EmailNotify")
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email Notification :" + " " + message);
    }
}
