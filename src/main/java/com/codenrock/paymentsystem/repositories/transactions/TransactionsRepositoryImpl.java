package com.codenrock.paymentsystem.repositories.transactions;

import com.codenrock.paymentsystem.models.Transaction;
import com.codenrock.paymentsystem.services.system.PaymentSystemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionsRepositoryImpl implements TransactionsRepositoryInterface{

    @Autowired
    PaymentSystemServiceInterface paymentSystemService;

    @Override
    public void saveTransaction(Transaction transaction) {
        paymentSystemService.saveTransaction(transaction);
    }
}
