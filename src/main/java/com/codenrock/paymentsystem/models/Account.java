package com.codenrock.paymentsystem.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Long id;

    private BigDecimal balance;

    public Account(Long id) {
        this.id = id;
        this.balance = BigDecimal.valueOf(0);
    }

    public Account(Long id, BigDecimal amount) {
        this.id = id;
        this.balance = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance);
    }
}
