package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
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

    @PostMapping(path = "/onboard")
    public ResponseEntity<CustomerWizard> onboardCustomer(@RequestBody CustomerWizard customerWizard) {
        return ResponseEntity.ok(customerService.onboardCustomer(customerWizard));
    }

    @PutMapping(path = "/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
    }

    @GetMapping(path = "/{customerId}/details")
    public ResponseEntity<CustomerDetail> getCustomerDetail(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerDetail(customerId));
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
