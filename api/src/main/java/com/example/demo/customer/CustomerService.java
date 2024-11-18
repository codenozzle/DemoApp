package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDAO dashboardDAO;

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
        return dashboardDAO.getTransactionAmountHistory();
    }

    public List<TransactionCountHistory> getTransactionCountHistory() {
        return dashboardDAO.getTransactionCountHistory();
    }

}
