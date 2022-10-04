package com.infoshareacademy.mistrzowieVaBank.repository;

import com.infoshareacademy.mistrzowieVaBank.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("delete from Order o where o.orderNum = :orderNum ")
    void deleteOrderByNum(int orderNum);

    @Modifying
    @Query("update Order set realized = 1 where orderNum= :orderNum")
    void setOrderAsRealized(int orderNum);
}

