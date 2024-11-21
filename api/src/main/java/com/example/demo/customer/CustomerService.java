package com.example.demo.customer;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.account.AccountService;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AccountRepository accountRepository;

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
        Double totalBalance = transactions.stream().mapToDouble(Transaction::getAmount).sum();
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

    @Transactional
    public CustomerWizard onboardCustomer(CustomerWizard customerWizard) {
        // Create the Customer object first
        Customer newCustomer = generateCustomerFromWizard(customerWizard);

        // Create the Account object second
        Account newAccount = generateAccountFromWizard(customerWizard);

        // Link the Customer and Account objects
        customerDAO.linkCustomerAndAccount(newCustomer.getId(), newAccount.getId());
        customerWizard.setCustomerId(newCustomer.getId());
        return customerWizard;
    }

    private Account generateAccountFromWizard(CustomerWizard customerWizard) {
        Account account = new Account();
        account.setCreditCardNumber(customerWizard.getCreditCardNumber());
        account.setCreditCardType(customerWizard.getCreditCardType());
        account.setBalance(customerWizard.getBalance());
        account.setSpendingLimit(customerWizard.getSpendingLimit());
        return accountRepository.save(account);
    }

    private Customer generateCustomerFromWizard(CustomerWizard customerWizard) {
        Customer customer = new Customer();
        customer.setName(customerWizard.getName());
        return customerRepository.save(customer);
    }
}
