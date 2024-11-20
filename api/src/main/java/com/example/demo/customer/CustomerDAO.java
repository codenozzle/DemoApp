package com.example.demo.customer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.demo.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
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


    public Customer getCustomerById(Long customerId) {
        String sql = """
                select * from customer c where c.id = :customerId
                """;
        SqlParameterSource params = new MapSqlParameterSource("customerId", customerId);
        return getTemplate().queryForObject(sql, params, (rs, rowNum) -> SqlMapper.mapCustomer(rs));
    }
}
