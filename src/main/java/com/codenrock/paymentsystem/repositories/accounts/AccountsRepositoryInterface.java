package com.codenrock.paymentsystem.repositories.accounts;

import java.math.BigDecimal;

public interface AccountsRepositoryInterface {
    void addNewAccount();
    void addNewAccount(BigDecimal amount);
}
