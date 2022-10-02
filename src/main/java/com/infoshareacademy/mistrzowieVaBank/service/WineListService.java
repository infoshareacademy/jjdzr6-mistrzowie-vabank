package com.infoshareacademy.mistrzowieVaBank.service;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
@NoArgsConstructor
public class WineListService {

    @Autowired
    JdbcTemplate template;

    public List<Wine> findAll() {
        String sql = "select * from wine";
        RowMapper<Wine> rm = new RowMapper<Wine>() {
            @Override
            public Wine mapRow(ResultSet result, int i) throws SQLException {
                Wine wine = new Wine(result.getLong("id"),
                        result.getString("flavour"),
                        result.getString("name"),
                        result.getString("origin"),
                        result.getBigDecimal("price"),
                        result.getString("type"),
                        result.getInt("year"),
                        result.getInt("quantity"),
                        result.getString("spec"));

                return wine;
            }
        };

        return template.query(sql, rm);
    }
}
