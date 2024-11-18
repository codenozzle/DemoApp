package com.example.demo.core;

import com.example.demo.customer.CustomerHistory;
import com.example.demo.customer.TransactionAmountHistory;
import com.example.demo.customer.TransactionCountHistory;

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
}
