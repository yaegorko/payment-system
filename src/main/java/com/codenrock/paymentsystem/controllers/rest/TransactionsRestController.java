package com.codenrock.paymentsystem.controllers.rest;

import com.codenrock.paymentsystem.models.Account;
import com.codenrock.paymentsystem.services.transactions.TransactionsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionsRestController {

    private final TransactionsServiceInterface transactionsService;

    @Autowired
    public TransactionsRestController(TransactionsServiceInterface transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public ResponseEntity makeTransaction(@RequestParam("from") Long accountIdFrom,
                                          @RequestParam("to") Long accountIdTo,
                                          @RequestParam("amount") BigDecimal amount) {
        transactionsService.makeTransaction(accountIdFrom, accountIdTo, amount);
        return ResponseEntity.ok("Ok");
    }

}
