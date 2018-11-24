package com.codenrock.paymentsystem.repositories.system;

import com.codenrock.paymentsystem.models.Account;
import com.codenrock.paymentsystem.models.PaymentSystem;
import com.codenrock.paymentsystem.models.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PaymentSystemRepositoryImpl implements PaymentSystemRepositoryInterface {

    private static final Logger logger = LoggerFactory.getLogger(PaymentSystemRepositoryImpl.class);

    private PaymentSystem paymentSystem;
    private Long accountId;

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
        accountId = paymentSystem.getAccountId();
        paymentSystem.getAccounts().put(accountId, new Account(accountId));
        logger.info("Create Account with id: " + accountId++ + ", start balance = 0");
        paymentSystem.setAccountId(accountId);
    }

    @Override
    public void addAccount(BigDecimal amount) {
        accountId = paymentSystem.getAccountId();
        paymentSystem.getAccounts().put(accountId, new Account(accountId, amount));
        logger.info("Create Account with id: " + accountId++ + ", start balance = " + amount);
        paymentSystem.setAccountId(accountId);
    }

    @Override
    public Account getAccountById(Long accountId) {
        return paymentSystem.getAccounts().get(accountId);
    }

    @Override
    public Long getIdForNewTransaction() {
        Long idForNewTransaction = paymentSystem.getTransactionId();
        Long nextTransactionId = idForNewTransaction + 1;
        paymentSystem.setTransactionId(nextTransactionId);
        return idForNewTransaction;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        List<Transaction> transactions = paymentSystem.getTransactions();
        transactions.add(transaction);
    }
}
