package com.codenrock.paymentsystem.services.system;

import com.codenrock.paymentsystem.models.PaymentSystem;

import java.math.BigDecimal;

public interface PaymentSystemServiceInterface {

    PaymentSystem getPaymentSystem();
    void addAccount();
    void addAccount(BigDecimal amount);

}

