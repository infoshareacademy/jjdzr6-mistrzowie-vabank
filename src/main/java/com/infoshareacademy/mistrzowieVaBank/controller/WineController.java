package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.domain.Wine;
import com.infoshareacademy.mistrzowieVaBank.dto.WineDto;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import com.infoshareacademy.mistrzowieVaBank.service.WineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class WineController {
    private final WineService wineService;
    private final WineRepository wineJson;

    public WineController(WineService wineService, WineRepository wineJson) {
        this.wineService = wineService;
        this.wineJson = wineJson;
    }

    @GetMapping("/wines/{id}")
    public String getWine(@PathVariable Integer id, Model model) {
        Wine wine = wineService.searchWine();
        WineDto dto = new WineDto(wine.getWineName());
        model.addAttribute("wine", dto);
        return "wine";
    }

}
