package com.codenrock.paymentsystem.repositories.accounts;

import com.codenrock.paymentsystem.models.Account;
import com.codenrock.paymentsystem.models.PaymentSystem;
import com.codenrock.paymentsystem.services.system.PaymentSystemServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountsRepositoryImpl implements AccountsRepositoryInterface {

    private static final Logger logger = LoggerFactory.getLogger(AccountsRepositoryImpl.class);

    private final PaymentSystemServiceInterface paymentSystemService;

    @Autowired
    public AccountsRepositoryImpl(PaymentSystemServiceInterface paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    @Override
    public void addNewAccount() {
        paymentSystemService.addAccount();
    }

    @Override
    public void addNewAccount(BigDecimal amount) {
        paymentSystemService.addAccount(amount);
    }

    @Override
    public BigDecimal getAccountBalanceById(Long accountId) {
        return paymentSystemService.getAccountBalanceById(accountId);
    }

    @Override
    public void setNewBalanceToAccount(Long accountId, BigDecimal newBalance) {
        paymentSystemService.setNewBalanceToAccount(accountId, newBalance);
    }
}
