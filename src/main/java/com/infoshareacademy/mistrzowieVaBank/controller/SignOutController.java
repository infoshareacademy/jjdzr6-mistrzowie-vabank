package com.infoshareacademy.mistrzowieVaBank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignOutController {

    @GetMapping("/sign-out")
    public String signOut() {
        return "signout";
    }
}

