package com.codenrock.paymentsystem.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long transactionId;
    private LocalDateTime date;
    private Account fromAccount;
    private Account toAccount;
    private BigDecimal amount;
    private boolean isComplite;
    private String comment;
}
