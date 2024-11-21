package com.example.demo.transaction;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping(path = "/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable Long transactionId) {
        return ResponseEntity.ok(transactionService.updateTransaction(transactionId, transaction));
    }

    @PostMapping(path = "/{accountId}/import")
    public ResponseEntity importTransactions(@PathVariable Long accountId) {
        transactionService.importTransactions(accountId);
        return ResponseEntity.ok(true);
    }
}
