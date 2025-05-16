package com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }
    //    public void placeOrder() {
    //        var order = new StripePaymentService();
    //        order.processPayment(10);
    //    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
