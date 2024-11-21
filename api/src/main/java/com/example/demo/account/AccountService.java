package com.example.demo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountDAO accountDAO;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountDAO.getAccountsByCustomerId(customerId);
    }

    public Account updateAccount(Long accountId, Account account) {
        Account accountToUpdate = accountRepository.getReferenceById(accountId);
        accountToUpdate.setBalance(account.getBalance());
        accountToUpdate.setCreditCardNumber(account.getCreditCardNumber());
        accountToUpdate.setCreditCardType(account.getCreditCardType());
        accountToUpdate.setSpendingLimit(account.getSpendingLimit());
        return accountRepository.save(accountToUpdate);
    }
}