package com.infoshareacademy.readers;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.FileReader;
import java.io.IOException;

public class WineJson {

    public void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        Wine[] wines = gson.fromJson(reader, Wine[].class);
        for (Wine wine : wines) {
            System.out.println(wine);
        }
    }
}