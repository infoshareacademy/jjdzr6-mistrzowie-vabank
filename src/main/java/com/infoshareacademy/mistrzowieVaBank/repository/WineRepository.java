package com.infoshareacademy.mistrzowieVaBank.repository;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {






}
