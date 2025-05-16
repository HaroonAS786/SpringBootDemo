package com.edigest.myFisrtProject.dependencyInjection;

import com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise.OrderService;
import com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise.PaymentService;
import com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise.PaypalPaymentService;
import com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise.StripePaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${paymentGateway}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService payPal() {
        return new PaypalPaymentService();
    }

    @Bean
//    @Lazy    this is only use when you feel your object is costly and you want to use only when it is needed
//    @Scope("singleton")
    public OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        }
        return new OrderService(payPal());
    }

    @PostConstruct
    public void init() {
        System.out.println("Order Service Post construct");
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Order Service Pre destroy");
    }

}
