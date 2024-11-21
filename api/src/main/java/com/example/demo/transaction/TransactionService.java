package com.example.demo.transaction;

import com.example.demo.customer.TransactionAmountHistory;
import com.example.demo.customer.TransactionCountHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionDAO transactionDAO;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByCustomerId(Long customerId) {
        return transactionDAO.getTransactionsByCustomerId(customerId);
    }

    public List<TransactionAmountHistory> getTransactionAmountHistory() {
        return transactionDAO.getTransactionAmountHistory();
    }

    public List<TransactionCountHistory> getTransactionCountHistory() {
        return transactionDAO.getTransactionCountHistory();
    }

    public void importTransactions(Long accountId) {
        simulateTransactionImport(accountId, "Utility Bill", 15.70, randomDate());
        simulateTransactionImport(accountId, "Home Improvement", 513.86, randomDate());
        simulateTransactionImport(accountId, "Grocery Purchase", 107.43, randomDate());
        simulateTransactionImport(accountId, "Online Shopping", 831.44, randomDate());
        simulateTransactionImport(accountId, "Pharmacy", 178.98, randomDate());
        simulateTransactionImport(accountId, "Electronics Purchase", 335.78, randomDate());
        simulateTransactionImport(accountId, "Travel Booking", 1756.31, randomDate());
        simulateTransactionImport(accountId, "Hotel Stay", 700.14, randomDate());
    }

    private void simulateTransactionImport(Long accountId, String description, double amount, LocalDateTime timestamp) {
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setTimestamp(timestamp);
        transaction.setAccountId(accountId);
        transactionRepository.save(transaction);
    }

    public LocalDateTime randomDate() {
        long offset = Timestamp.valueOf("2024-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2024-10-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp date = new Timestamp(offset + (long) (Math.random() * diff));
        return date.toLocalDateTime();
    }
}