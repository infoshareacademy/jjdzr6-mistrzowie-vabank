package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WineByFlavour {
    private Wine[] wines;
    //private Wine[] wines2;

    public void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        wines = gson.fromJson(reader, Wine[].class);
    }

    public List<Wine> getWineByFlavour(String flavour) {
        List<Wine> wineList = new ArrayList<>();
        for (Wine value : wines) {
            if (value.getWineFlavour().toLowerCase().equals(flavour.toLowerCase())) {
                wineList.add(value);
            }
        }
        return wineList;
    }
}
