package com.example.demo.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public Customer createCustomer(Customer customer) {
        return customer;
    }
}
