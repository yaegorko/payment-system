package com.codenrock.paymentsystem.services.accounts;

import java.math.BigDecimal;

public interface AccountsServiceInterface {
    void addNewAccount();
    void addNewAccount(BigDecimal amount);
    BigDecimal getAccountBalanceById(Long accountId);
    void setNewBalanceToAccount(Long accountId, BigDecimal newBallance);
}
