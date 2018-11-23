package com.codenrock.paymentsystem.repositories.system;

import com.codenrock.paymentsystem.models.PaymentSystem;

import java.math.BigDecimal;
import java.util.Optional;

public interface PaymentSystemRepositoryInterface {
    Optional<PaymentSystem> getPaymentSystem();
    void addAccount();
    void addAccount(BigDecimal amount);
}
