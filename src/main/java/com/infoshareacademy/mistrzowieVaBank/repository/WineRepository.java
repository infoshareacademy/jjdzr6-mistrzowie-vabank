package com.infoshareacademy.mistrzowieVaBank.repository;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.mistrzowieVaBank.domain.Wine;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Repository
public class WineRepository {

    private Wine[] wines;
    public Wine[] ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        return gson.fromJson(reader, Wine[].class);
    }
}
