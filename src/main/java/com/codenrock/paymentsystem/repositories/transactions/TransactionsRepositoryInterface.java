package com.codenrock.paymentsystem.repositories.transactions;

import com.codenrock.paymentsystem.models.Transaction;

public interface TransactionsRepositoryInterface {
    void saveTransaction(Transaction transaction);
}

