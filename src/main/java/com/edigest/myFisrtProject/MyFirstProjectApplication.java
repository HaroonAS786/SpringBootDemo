package com.edigest.myFisrtProject;

import com.edigest.myFisrtProject.models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstProjectApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyFisrtProjectApplication.class, args);
//        ApplicationContext applicationContext = SpringApplication.run(MyFirstProjectApplication.class, args);
//        var notifyService = applicationContext.getBean(NotificationManager.class);
//        var orderService = applicationContext.getBean(OrderService.class);
//        var orderService2 = applicationContext.getBean(OrderService.class);
//        var order = new OrderService(new StripePaymentService());
//        var order = new OrderService();
//        order.setPaymentService(new StripePaymentService());
//        order.setPaymentService(new PaypalPaymentService());
//        notifyService.sendNotification("Hello World!");
//        applicationContext.close();

//        ApplicationContext applicationContext = SpringApplication.run(MyFirstProjectApplication.class, args);
//        var userService = applicationContext.getBean(UserService.class);
//        userService.registerUser(new User(1L, "haroon.asif@gmail.com", "1234", "Haroon"));
//        userService.registerUser(new User(2L, "haroon.asif@gmail.com", "1234", "Haroon"));

//        var user = new User(1L,"haroon","haroon","haroon@edigest.com");
//        user.setName("haroon");
//        user.setEmail("haroon@edigest.com");
//        user.setPassword("haroon");

        var user = User.builder()
                .name("Edigest")
                .email("edigest@edigest.com")
                .password("edigest")
                .build();

        user.addTag("tag1");
//        user.addTag("tag2");
//        user.addTag("tag3");

        System.out.println(user);
        user.removeTag("tag1");
        System.out.println(user);

//        var address = Address.builder()
//                .street("B1 township lahore")
//                .zip("54000")
//                .city("Lahore")
//                .build();
//
//        var address2 = Address.builder()
//                .street("B2 township lahore")
//                .zip("54000")
//                .city("Karachi")
//                .build();


    }


}

