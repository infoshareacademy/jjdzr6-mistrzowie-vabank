package com.infoshareacademy.mistrzowieVaBank.repositor;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    List<Wine> findWineByName(String name);

    @Query("select a from Wine a where a.name = :name")
    Wine findExistByName(String name);



}
