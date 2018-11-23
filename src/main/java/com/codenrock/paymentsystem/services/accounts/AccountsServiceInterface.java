package com.codenrock.paymentsystem.services.accounts;

import java.math.BigDecimal;

public interface AccountsServiceInterface {
    void addNewAccount();
    void addNewAccount(BigDecimal amount);
}
