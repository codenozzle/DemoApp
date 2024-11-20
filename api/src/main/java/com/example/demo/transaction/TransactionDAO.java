package com.example.demo.transaction;

import com.example.demo.core.BaseDAO;
import com.example.demo.core.SqlMapper;
import com.example.demo.customer.TransactionAmountHistory;
import com.example.demo.customer.TransactionCountHistory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAO extends BaseDAO {

    public List<Transaction> getTransactionsByCustomerId(Long customerId) {
        String sql = """
                select t.*
                from
                    customer_account ca
                    join account a on ca.account_id = a.id
                    join customer c on ca.customer_id = c.id
                    join transaction t on a.id = t.account_id
                where ca.customer_id = :customer_id
                order by t.timestamp desc
                """;
        SqlParameterSource params = new MapSqlParameterSource("customer_id", customerId);
        return getTemplate().query(sql, params,SqlMapper::mapTransaction);
    }

    public List<TransactionCountHistory> getTransactionCountHistory() {
        String sql = """
                select a.credit_card_type, count(t.id) as num_of_transactions
                from
                    account a join transaction t on a.id = t.account_id
                group by
                    a.credit_card_type
                order by
                    a.credit_card_type
                """;
        return getTemplate().query(sql, SqlMapper::mapTransactionCountHistory);
    }

    public List<TransactionAmountHistory> getTransactionAmountHistory() {
        String sql = """
                select a.credit_card_type, sum(t.amount) as total
                from
                    account a join transaction t on a.id = t.account_id
                group by
                    a.credit_card_type
                order by
                    a.credit_card_type
                """;
        return getTemplate().query(sql, SqlMapper::mapTransactionAmountHistory);
    }
}
