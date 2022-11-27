package com.infoshareacademy.mistrzowieVaBank.repositor;

import com.infoshareacademy.mistrzowieVaBank.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(value = "select o from OrderDetail o where o.order.id = :orderId")
    List<OrderDetail> findByOrderId(Long orderId);
}
