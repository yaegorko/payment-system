package com.codenrock.paymentsystem.repositories.system;

import com.codenrock.paymentsystem.models.Account;
import com.codenrock.paymentsystem.models.PaymentSystem;
import com.codenrock.paymentsystem.models.Transaction;

import java.math.BigDecimal;
import java.util.Optional;

public interface PaymentSystemRepositoryInterface {
    Optional<PaymentSystem> getPaymentSystem();
    void addAccount();
    void addAccount(BigDecimal amount);
    Account getAccountById(Long accountId);
    Long getIdForNewTransaction();
    void saveTransaction(Transaction transaction);
}
