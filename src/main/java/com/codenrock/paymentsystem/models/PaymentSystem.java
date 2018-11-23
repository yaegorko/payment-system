package com.codenrock.paymentsystem.models;

import java.util.HashMap;
import java.util.Map;


public class PaymentSystem {

    private Map<Long, Account> accounts;
    private Long accountId;

    public PaymentSystem() {
        this.accounts = new HashMap<>();
        this.accountId = 0L;
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
}
