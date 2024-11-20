package com.example.demo.core;

import com.example.demo.account.Account;
import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerHistory;
import com.example.demo.customer.TransactionAmountHistory;
import com.example.demo.customer.TransactionCountHistory;
import com.example.demo.transaction.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlMapper {
    public static CustomerHistory mapCustomerHistory(ResultSet rs, int i) throws SQLException {
        CustomerHistory result = new CustomerHistory();
        result.setName(rs.getString("name"));
        result.setCreditCardNumber(rs.getString("credit_card_number"));
        result.setCreditCardType(rs.getString("credit_card_type"));
        result.setNumberOfTransactions(rs.getInt("num_of_transactions"));
        result.setTotal(rs.getDouble("total"));
        return result;
    }

    public static TransactionCountHistory mapTransactionCountHistory(ResultSet rs, int i) throws SQLException {
        TransactionCountHistory result = new TransactionCountHistory();
        result.setCreditCardType(rs.getString("credit_card_type"));
        result.setTransactionCount(rs.getInt("num_of_transactions"));
        return result;
    }

    public static TransactionAmountHistory mapTransactionAmountHistory(ResultSet rs, int i) throws SQLException {
        TransactionAmountHistory result = new TransactionAmountHistory();
        result.setAmount(rs.getDouble("total"));
        result.setCreditCardType(rs.getString("credit_card_type"));
        return result;
    }

    public static Account mapAccount(ResultSet rs, int i) throws SQLException {
        Account result = new Account();
        result.setId(rs.getLong("id"));
        result.setCreditCardNumber(rs.getString("credit_card_number"));
        result.setCreditCardType(rs.getString("credit_card_type"));
        result.setBalance(rs.getDouble("balance"));
        result.setSpendingLimit(rs.getDouble("spending_limit"));
        return result;
    }

    public static Transaction mapTransaction(ResultSet rs, int i) throws SQLException {
        Transaction result = new Transaction();
        result.setId(rs.getLong("id"));
        result.setAmount(rs.getDouble("amount"));
        result.setDescription(rs.getString("description"));
        result.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
        return result;
    }

    public static Customer mapCustomer(ResultSet rs) throws SQLException {
        Customer result = new Customer();
        result.setId(rs.getLong("id"));
        result.setName(rs.getString("name"));
        return result;
    }
}
