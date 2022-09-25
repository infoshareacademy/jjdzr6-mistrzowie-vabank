package com.infoshareacademy.mistrzowieVaBank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductListController {

    @GetMapping("/winelist")
    public String productList(){
        return "winelist";
    }
}

