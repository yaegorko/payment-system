package com.codenrock.paymentsystem.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PaymentSystem {

    private Map<Long, Account> accounts;
    private Long accountId;
    private List<Transaction> transactions;
    private Long transactionId;

    public PaymentSystem() {
        this.accounts = new HashMap<>();
        this.accountId = 0L;
        this.transactions = new ArrayList<>();
        this.transactionId = 0L;
    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
