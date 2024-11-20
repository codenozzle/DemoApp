package com.example.demo.customer;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDAO dashboardDAO;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerDAO customerDAO;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<CustomerHistory> getCustomerHistory() {
        return dashboardDAO.getCustomerHistory();
    }

    public List<TransactionAmountHistory> getTransactionAmountHistory() {
        return transactionService.getTransactionAmountHistory();
    }

    public List<TransactionCountHistory> getTransactionCountHistory() {
        return transactionService.getTransactionCountHistory();
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer customerToUpdate = customerRepository.getReferenceById(customerId);
        customerToUpdate.setName(customer.getName());
        return customerRepository.save(customerToUpdate);
    }

    public CustomerDetail getCustomerDetail(Long customerId) {
        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        List<Transaction> transactions = transactionService.getTransactionsByCustomerId(customerId);
        Double totalBalance = accounts.stream().mapToDouble(Account::getBalance).sum();
        Double totalSpendingLimit = accounts.stream().mapToDouble(Account::getSpendingLimit).sum();
        Customer customer = customerDAO.getCustomerById(customerId);

        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setCustomer(customer);
        customerDetail.setAccounts(accounts);
        customerDetail.setTransactions(transactions);
        customerDetail.setNumberOfTransactions(transactions.size());
        customerDetail.setNumberOfAccounts(accounts.size());
        customerDetail.setTotalBalance(totalBalance);
        customerDetail.setTotalSpendingLimit(totalSpendingLimit);
        customerDetail.setCreditRatio(totalBalance/totalSpendingLimit);
        return customerDetail;
    }
}
