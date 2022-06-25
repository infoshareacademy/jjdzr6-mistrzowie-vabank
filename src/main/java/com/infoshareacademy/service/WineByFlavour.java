package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.FileReader;
import java.io.IOException;

public class WineByFlavour {
    private Wine[] wines;
    //private Wine[] wines2;

    public void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        wines = gson.fromJson(reader, Wine[].class);
    }

    public Wine[] getWineByFlavour2(String flavour) {
        int count = 0;
        for (Wine wine : wines) {
            // System.out.println(wine);
            if (wine.getWineFlavour().equals(flavour)) {
                wines[count++] = wine;
            }
        }
        return wines;
    }

    public Wine[] getWineByFlavour(String flavour) {
        Wine[] wines2 = new Wine[wines.length];
        int count = 0;
        for (int i = 0; i < wines.length; i++) {
            // System.out.println(wine);
            if (wines[i].getWineFlavour().equals(flavour)) {
                    wines2[count++] = wines[i];
            }
        }
        return wines2;
    }
}
