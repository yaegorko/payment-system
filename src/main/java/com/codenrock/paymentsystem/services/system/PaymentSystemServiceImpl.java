package com.codenrock.paymentsystem.services.system;

import com.codenrock.paymentsystem.models.PaymentSystem;
import com.codenrock.paymentsystem.models.Transaction;
import com.codenrock.paymentsystem.repositories.system.PaymentSystemRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentSystemServiceImpl implements PaymentSystemServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(PaymentSystemServiceImpl.class);

    private final PaymentSystemRepositoryInterface paymentSystemRepository;

    @Autowired
    public PaymentSystemServiceImpl(PaymentSystemRepositoryInterface paymentSystemRepository) {
        this.paymentSystemRepository = paymentSystemRepository;
    }

    @Override
    public PaymentSystem getPaymentSystem() {
       Optional<PaymentSystem> paymentSystem = paymentSystemRepository.getPaymentSystem();
       if (paymentSystem.isPresent()) {
           return paymentSystem.get();
       } else {
         throw new RuntimeException();
       }
    }

    @Override
    public void addAccount() {
        paymentSystemRepository.addAccount();
    }

    @Override
    public void addAccount(BigDecimal amount) {
        paymentSystemRepository.addAccount(amount);
    }

    @Override
    public BigDecimal getAccountBalanceById(Long accountId) {
        return paymentSystemRepository.getAccountById(accountId).getBalance();
    }

    @Override
    public void setNewBalanceToAccount(Long accountId, BigDecimal newBalance) {
        paymentSystemRepository.getAccountById(accountId).setBalance(newBalance);
    }

    @Override
    public Long getIdForNewTransaction() {
        return paymentSystemRepository.getIdForNewTransaction();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        paymentSystemRepository.saveTransaction(transaction);
    }
}
