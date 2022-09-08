package com.infoshareacademy.mistrzowieVaBank.service;

import com.infoshareacademy.mistrzowieVaBank.dto.OrderDto;
import com.infoshareacademy.mistrzowieVaBank.entity.Order;
import com.infoshareacademy.mistrzowieVaBank.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<OrderDto> findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.stream().findFirst().map(this::map);
    }

    public List<OrderDto> findByUsername(String username) {
        Set<Order> orders = orderRepository.findByUsername(username);
        return orders.stream().map(this::map).collect(Collectors.toList());
    }

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    private OrderDto map(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setComment(order.getComment());
        dto.setBookTitle(order.getBookTitle());
        dto.setPrice(order.getPrice());
        return dto;
    }
}

