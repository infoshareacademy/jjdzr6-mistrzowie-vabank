package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.FileReader;
import java.io.IOException;

public class WineById {

    private Wine[] wines;

    public void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("/Users/miko/Desktop/jjdzr6-mistrzowie-vabank-JJDZR6MV-18/jjdzr6-mistrzowie-vabank-JJDZR6MV-18/src/main/resources/Wine.json"));
        wines = gson.fromJson(reader, Wine[].class);
    }

    public Wine getWineById(int id) {
        for (Wine wine : wines) {
            //System.out.println(wine);
            if (wine.getWineId() == id) {
                return wine;
            }
        }
        throw new IllegalArgumentException();
    }
}
