package com.infoshareacademy.mistrzowieVaBank.dao;


import com.infoshareacademy.mistrzowieVaBank.dto.*;
import com.infoshareacademy.mistrzowieVaBank.entity.Order;
import com.infoshareacademy.mistrzowieVaBank.entity.OrderDetail;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.OrderDetailRepository;
import com.infoshareacademy.mistrzowieVaBank.repository.OrderRepository;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import com.infoshareacademy.mistrzowieVaBank.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderDao {

    private final OrderRepository orderRepository;

    private final WineRepository wineRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final OrderMapper orderMapper;


    public OrderDao(OrderRepository orderRepository, WineRepository wineRepository, OrderDetailRepository orderDetailRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.wineRepository = wineRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderMapper = orderMapper;
    }

    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
       TypedQuery<Integer> query1 = entityManager.createQuery(sql, Integer.class);


        Integer value = query1.getSingleResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Transactional
    public void saveOrder(CartInfo cartInfo) {


        int orderNum = this.getMaxOrderNum() + 1;
        Order order = new Order();

        order.setId(UUID.randomUUID().getMostSignificantBits());
        order.setOrderNum(orderNum);
        order.setOrderDate(LocalDate.now());
        order.setAmount(cartInfo.getAmountTotal());
        order.setRealized(false);

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerPhone(customerInfo.getPhone());
        order.setCustomerAddress(customerInfo.getAddress());

        orderRepository.save(order);

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setId(UUID.randomUUID().getMostSignificantBits());
            detail.setOrder(order);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getWineInfo().getPrice());
            detail.setQuantity(line.getQuantity());

            Long id = line.getWineInfo().getId();
            Wine wine = wineRepository.findById(id).orElse(null);
            detail.setWine(wine);

            orderDetailRepository.save(detail);
        }

        // Order Number!
        cartInfo.setOrderNum(orderNum);

    }


    public Order findOrder(long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }


    public OrderInfo getOrderInfo(int orderId) {
        Order order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(), //
                order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
                order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone(), order.getRealized());
    }

    public List<OrderDetailInfo> listOrderDetailInfos(Long orderId) {
        List<OrderDetail> orderDetail = orderDetailRepository.findByOrderId(orderId);
        List<OrderDetailInfo> orderDetailList = new ArrayList<>();
        for (OrderDetail detail : orderDetail) {
            OrderDetailInfo orderDetailInfo = orderMapper.toEntity(detail);
            orderDetailList.add(orderDetailInfo);
        }
        return orderDetailList;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderByOrderNum(int orderNum) {
        this.orderRepository.deleteOrderByOrderNum(orderNum);
    }

    public void setOrderAsRealized(int orderNum) {
        this.orderRepository.setOrderAsRealized(orderNum);
    }

    public List<Order> findAllByOrderNum(int orderNum) {
        return orderRepository.findAllByOrderNum(orderNum);
    }

}