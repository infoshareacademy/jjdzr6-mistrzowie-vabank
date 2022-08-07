package com.infoshareacademy.mistrzowieVaBank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexRepository {
    @GetMapping("/main")
    public String getIndex(){
        return "templates/index.html";
    }
}
