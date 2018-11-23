package com.codenrock.paymentsystem.init;

import com.codenrock.paymentsystem.services.system.PaymentSystemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentSystemInitializer {

    @Autowired
    PaymentSystemServiceInterface paymentSystemService;

    private void init() {
        paymentSystemService.getPaymentSystem();
    }
}
