package com.example.demo.customer;

import org.springframework.stereotype.Repository;
import com.example.demo.core.*;

import java.util.List;

@Repository
public class CustomerDAO extends BaseDAO {

    public List<CustomerHistory> getCustomerHistory() {
        String sql = """
                select c.name, a.credit_card_type, a.credit_card_number, count(t.id) as num_of_transactions, sum(t.amount) as total
                from
                    customer_account ca
                    join account a on ca.account_id = a.id
                    join customer c on ca.customer_id = c.id
                    join transaction t on a.id = t.account_id
                group by
                    c.name, a.credit_card_type, a.credit_card_number
                order by
                    c.name
                """;
        return getTemplate().query(sql, SqlMapper::mapCustomerHistory);
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
