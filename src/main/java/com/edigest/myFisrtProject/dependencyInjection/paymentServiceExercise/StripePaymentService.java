package com.edigest.myFisrtProject.dependencyInjection.paymentServiceExercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {

    // Externalizing Configuration
    @Value("${stripe.apiUrl}")
    private String stripeUrl;
    @Value("${stripe.enabled}")
    private boolean stripeEnabled;
    @Value("${stripe.timeout}")
    private int timeout;
    @Value("${stripe.supported-currencies}")
    private List<String> currencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe Url" + " " + stripeUrl);
        System.out.println("Stripe enabled" + " " + stripeEnabled);
        System.out.println("Stripe timeout" + " " + timeout);
        System.out.println("Stripe currencies" + " " + currencies);
        System.out.println("********* Payment Checkout........ ********");
        System.out.println("Stripe Amount" + " " + amount);
    }
}
