package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @Secured("ROLE_USER")
    @GetMapping("/orders")
    public String users(HttpServletRequest request, Model model) {
        String username = request.getUserPrincipal().getName();
        model.addAttribute("orders", orderService.findByUsername(username));
        return "orders";
    }
}

