package com.example.demo.account;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PutMapping(path = "/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, account));
    }
}
