package com.codenrock.paymentsystem.services.system;

import com.codenrock.paymentsystem.models.PaymentSystem;
import com.codenrock.paymentsystem.models.Transaction;

import java.math.BigDecimal;

public interface PaymentSystemServiceInterface {

    PaymentSystem getPaymentSystem();
    void addAccount();
    void addAccount(BigDecimal amount);
    BigDecimal getAccountBalanceById(Long accountId);
    void setNewBalanceToAccount (Long accountId, BigDecimal newBalance);
    Long getIdForNewTransaction();
    void saveTransaction(Transaction transaction);
}

