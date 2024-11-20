package com.example.demo.transaction;

import com.example.demo.customer.CustomerDetail;
import com.example.demo.customer.TransactionAmountHistory;
import com.example.demo.customer.TransactionCountHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}