package com.edigest.myFisrtProject.dependencyInjection.notificationServiceExcersie;

import org.springframework.stereotype.Service;

@Service("SMSNotify")
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS Notification :" + " " + message);
    }
}
