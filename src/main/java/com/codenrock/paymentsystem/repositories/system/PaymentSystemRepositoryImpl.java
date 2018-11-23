package com.codenrock.paymentsystem.repositories.system;

import com.codenrock.paymentsystem.models.Account;
import com.codenrock.paymentsystem.models.PaymentSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class PaymentSystemRepositoryImpl implements PaymentSystemRepositoryInterface {

    private static final Logger logger = LoggerFactory.getLogger(PaymentSystemRepositoryImpl.class);

    private PaymentSystem paymentSystem;
    private Long accountId = 0L;

    private PaymentSystem createPaymentSystem() {
        logger.info("Payment System created");
        return this.paymentSystem = new PaymentSystem();
    }

    @Override
    public Optional<PaymentSystem> getPaymentSystem() {
        if (paymentSystem == null) {
            createPaymentSystem();
            getPaymentSystem();
        }
        return Optional.of(paymentSystem);
    }

    @Override
    public void addAccount() {
        paymentSystem.getAccounts().put(accountId, new Account(accountId));
        logger.info("Create Account with id: " + accountId++ + ", start balance = 0");
    }

    @Override
    public void addAccount(BigDecimal amount) {
        paymentSystem.getAccounts().put(accountId, new Account(accountId, amount));
        logger.info("Create Account with id: " + accountId++ + ", start balance = " + amount);
    }
}
