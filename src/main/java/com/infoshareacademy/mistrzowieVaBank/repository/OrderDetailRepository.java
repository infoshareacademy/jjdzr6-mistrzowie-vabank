package com.infoshareacademy.mistrzowieVaBank.repository;

import com.infoshareacademy.mistrzowieVaBank.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(value = "select o from OrderDetail o where o.order.id = :orderId")
    List<OrderDetail> findByOrderId(Long orderId);
}
