package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.domain.Wine;
import com.infoshareacademy.mistrzowieVaBank.dto.WineDto;
import com.infoshareacademy.mistrzowieVaBank.service.WineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WineController {
    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/wines/{id}")
    public String getWine(@PathVariable Integer id, Model model) {
        Wine wine = wineService.searchWine();
        WineDto dto = new WineDto(wine.getWineName());
        model.addAttribute("wine", dto);
        return "wine";
    }

    @GetMapping("/wines/new")
    public String getWineForm(Model model) {
        model.addAttribute("wine", new WineDto(null));
        return "wine-form";
    }

    @PostMapping("/wines/new")
    public String sendWine(@ModelAttribute("wine") WineDto dto) {
        System.out.printf(dto.toString());
        return "wine";
    }

    @GetMapping("/product")
    public String getProduct(){
        return "product-form";
    }
}
