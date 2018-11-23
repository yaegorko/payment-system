package com.codenrock.paymentsystem.controllers.rest;

import com.codenrock.paymentsystem.services.accounts.AccountsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountsRestController {

    private final AccountsServiceInterface accountsService;

    @Autowired
    public AccountsRestController(AccountsServiceInterface accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/create")
    public ResponseEntity createAccount() {
        accountsService.addNewAccount();
        return ResponseEntity.ok("Ок");
    }

    @PostMapping("/create/balance")
    public ResponseEntity createAccountWithStartBalance(@RequestParam("amount") BigDecimal amount) {
        accountsService.addNewAccount(amount);
        return ResponseEntity.ok("Ok");
    }

}
