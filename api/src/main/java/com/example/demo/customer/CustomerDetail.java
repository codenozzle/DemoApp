package com.example.demo.customer;

import com.example.demo.account.Account;
import com.example.demo.transaction.Transaction;

import java.util.List;

public class CustomerDetail {

    private Customer customer;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private int numberOfTransactions;
    private int numberOfAccounts;
    private Double totalBalance;
    private Double totalSpendingLimit;
    private Double creditRatio;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Double getTotalSpendingLimit() {
        return totalSpendingLimit;
    }

    public void setTotalSpendingLimit(Double totalSpendingLimit) {
        this.totalSpendingLimit = totalSpendingLimit;
    }

    public Double getCreditRatio() {
        return creditRatio;
    }

    public void setCreditRatio(Double creditRatio) {
        this.creditRatio = creditRatio;
    }
}
