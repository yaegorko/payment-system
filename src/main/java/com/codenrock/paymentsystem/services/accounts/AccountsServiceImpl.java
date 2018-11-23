package com.codenrock.paymentsystem.services.accounts;

import com.codenrock.paymentsystem.repositories.accounts.AccountsRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountsServiceImpl implements AccountsServiceInterface {

    private final AccountsRepositoryInterface accountsRepository;

    @Autowired
    public AccountsServiceImpl(AccountsRepositoryInterface accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public void addNewAccount() {
        accountsRepository.addNewAccount();
    }

    @Override
    public void addNewAccount(BigDecimal amount) {
        accountsRepository.addNewAccount(amount);
    }
}
