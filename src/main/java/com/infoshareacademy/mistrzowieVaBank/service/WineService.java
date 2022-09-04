package com.infoshareacademy.mistrzowieVaBank.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.mistrzowieVaBank.domain.Wine;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class WineService {
    private Wine[] wines;
    WineRepository wineRepository = new WineRepository();

    public List<Wine> getWineByFlavour(String flavour) {
        List<Wine> wineList = new ArrayList<>();
        wineList.add(new Wine("Chianti", "wytrawne"));
        wineList.add(new Wine("Schol", "słodkie"));
        List<Wine> result = new ArrayList<>();

        for (Wine value : wineList) {
            if (value.getWineFlavour().toLowerCase().equals(flavour.toLowerCase())) {
                result.add(value);
            }
        }
        return result;
    }

    public Wine searchWineByFlavour(String flavour) {
            try {
                wineRepository.ReadingWineToJson();

                for (Wine wine : getWineByFlavour(flavour)) {
                    System.out.println(wine);
                }

            } catch (InputMismatchException | IllegalArgumentException | IOException e) {
                System.out.println("Podaj smak! Słodkie/Półsłodkie/Wytrawne/Półwytrawne");
            }
        return new Wine("Chianti");
    }

    public Wine searchWine(){

        return new Wine("Chianti");
    }
}
