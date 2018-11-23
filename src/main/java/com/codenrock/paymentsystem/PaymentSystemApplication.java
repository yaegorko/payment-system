package com.codenrock.paymentsystem;

import com.codenrock.paymentsystem.init.PaymentSystemInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentSystemApplication.class, args);
    }

    @Bean(initMethod = "init")
    public PaymentSystemInitializer initPaymentSystem() {
        return new PaymentSystemInitializer();
    }
}
