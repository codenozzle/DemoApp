package com.example.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class BaseDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected NamedParameterJdbcTemplate getTemplate() {
        return namedParameterJdbcTemplate;
    }

    public int update(String sql, SqlParameterSource params) {
        return getTemplate().update(sql, params);
    }

    public MapSqlParameterSource paramMap() {
        return new MapSqlParameterSource();
    }

}
