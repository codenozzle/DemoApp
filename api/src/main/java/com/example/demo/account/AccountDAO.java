package com.example.demo.account;

import com.example.demo.core.BaseDAO;
import com.example.demo.core.SqlMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO extends BaseDAO {

    public List<Account> getAccountsByCustomerId(Long customerId) {
        String sql = """
                select a.*
                from customer_account ca join account a on ca.account_id = a.id
                where ca.customer_id = :customer_id
                """;
        SqlParameterSource params = new MapSqlParameterSource("customer_id", customerId);
        return getTemplate().query(sql, params, SqlMapper::mapAccount);
    }
}
