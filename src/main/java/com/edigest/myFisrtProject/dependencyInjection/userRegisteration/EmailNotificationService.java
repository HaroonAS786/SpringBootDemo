package com.edigest.myFisrtProject.dependencyInjection.userRegisteration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {

    @Value("${userRegisteration.host}")
    private String host;
    @Value("${userRegisteration.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Email: " + recipientEmail);
        System.out.println("Message: " + message);
        System.out.println("Port: " + port);
        System.out.println("Host: " + host);
    }
}
