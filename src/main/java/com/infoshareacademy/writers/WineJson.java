package com.infoshareacademy.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WineJson {

    public static void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        Wine[] wine = gson.fromJson(reader, Wine[].class);
        for (Wine wine1: wine) {
            System.out.println(wine1);
        }


    }
}