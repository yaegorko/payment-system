package com.codenrock.paymentsystem.services.transactions;

import java.math.BigDecimal;

public interface TransactionsServiceInterface {
    void makeTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
