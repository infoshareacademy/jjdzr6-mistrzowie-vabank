package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.dao.OrderDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OrderController {
    private final OrderDao orderDAO;

    public OrderController(OrderDao orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping("/orderlist")
    public String showOrderList(Model model) {
        model.addAttribute("order", orderDAO.getAllOrders());
        return "orderlist";
    }

    @RequestMapping({"/removeOrder={orderNum}"})
    public String removeOrder(@PathVariable int orderNum) {
        orderDAO.deleteOrderByOrderNum(orderNum);
        return "redirect:/orderlist";
    }

    @RequestMapping({"/setrealized={orderNum}"})
    public String setOrderAsRealized(@PathVariable int orderNum) {
        orderDAO.setOrderAsRealized(orderNum);
        return "redirect:/orderlist";
    }

    @RequestMapping({"/order={orderNum}"})
    public String singleOrderPage(@PathVariable int orderNum, Model model) {
        model.addAttribute("order", orderDAO.findAllByOrderNum(orderNum));
        return "order";
    }

}
