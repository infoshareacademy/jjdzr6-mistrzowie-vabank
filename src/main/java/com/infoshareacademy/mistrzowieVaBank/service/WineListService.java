package com.infoshareacademy.mistrzowieVaBank.service;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class WineListService {

    @Autowired
    JdbcTemplate template;

    @Autowired
    WineRepository wineRepository;

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

    public Page<Wine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        if(sortField == null){
            sortField = "name";
        }

        if(sortDirection == null){
            sortDirection = "asc";
        }


        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();


        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.wineRepository.findAll(pageable);
    }


    public Boolean ifExist(String name){
        Wine wine = wineRepository.findExistByName(name);
        return wine != null;
    }
}
