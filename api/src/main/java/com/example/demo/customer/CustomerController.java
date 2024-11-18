package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping(path = "/history")
    public List<CustomerHistory> getCustomerHistory() {
        return customerService.getCustomerHistory();
    }

    @GetMapping(path = "/countHistory")
    public List<TransactionCountHistory> getTransactionCountHistory() {
        return customerService.getTransactionCountHistory();
    }

    @GetMapping(path = "/amountHistory")
    public List<TransactionAmountHistory> getTransactionAmountHistory() {
        return customerService.getTransactionAmountHistory();
    }
}
