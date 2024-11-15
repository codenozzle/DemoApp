package com.example.demo.customer;

import com.example.demo.account.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts;

    // Getters, Setters, Constructors

}
