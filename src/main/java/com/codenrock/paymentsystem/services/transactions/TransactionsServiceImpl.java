package com.codenrock.paymentsystem.services.transactions;

import com.codenrock.paymentsystem.exceptions.TransactionAmountMoreTnanBallance;
import com.codenrock.paymentsystem.models.Transaction;
import com.codenrock.paymentsystem.repositories.transactions.TransactionsRepositoryInterface;
import com.codenrock.paymentsystem.services.accounts.AccountsServiceInterface;
import com.codenrock.paymentsystem.services.system.PaymentSystemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionsServiceImpl implements TransactionsServiceInterface {

    private final AccountsServiceInterface accountsService;
    private final TransactionsRepositoryInterface transactionsRepository;
    private final PaymentSystemServiceInterface paymentSystemService;

    @Autowired
    public TransactionsServiceImpl(AccountsServiceInterface accountsService,
                                   TransactionsRepositoryInterface transactionsRepository,
                                   PaymentSystemServiceInterface paymentSystemService) {
        this.accountsService = accountsService;
        this.transactionsRepository = transactionsRepository;
        this.paymentSystemService = paymentSystemService;
    }

    private Transaction createTransaction(Long fromAccountId,
                                          Long toAccountId,
                                          BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDateTime.now());
        transaction.setTransactionId(paymentSystemService.getIdForNewTransaction());
        transaction.setFromAccountId(fromAccountId);
        transaction.setToAccountId(toAccountId);
        transaction.setAmount(amount);
        return new Transaction();
    }

    @Override
    public void makeTransaction(Long fromAccountId,
                                Long toAccountId,
                                BigDecimal amount) throws TransactionAmountMoreTnanBallance {
        Transaction transaction = createTransaction(fromAccountId, toAccountId, amount);
        BigDecimal balanceFrom = accountsService.getAccountBalanceById(fromAccountId);
        BigDecimal balanceTo = accountsService.getAccountBalanceById(toAccountId);
        if (amount.compareTo(balanceFrom) == -1) {
            transaction.setComplete(false);
            transaction.setComment("Transaction canceled, not enough money on account");
            transactionsRepository.saveTransaction(transaction);
            throw new TransactionAmountMoreTnanBallance();
        } else {
            accountsService.setNewBalanceToAccount(fromAccountId, balanceFrom.subtract(amount));
            accountsService.setNewBalanceToAccount(toAccountId, balanceTo.add(amount));
            transaction.setComplete(true);
            transaction.setComment("Transaction complete");
            transactionsRepository.saveTransaction(transaction);
        }
    }
}
