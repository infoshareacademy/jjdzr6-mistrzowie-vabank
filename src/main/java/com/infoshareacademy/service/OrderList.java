package com.infoshareacademy.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.domain.Wine;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderList {
    private Wine[] wines;

    public void ReadingOrderListToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Order.json"));
        wines = gson.fromJson(reader, Wine[].class);
    }

    public List<Wine> getOrderList() {
        List<Wine> wineList = new ArrayList<>();
        Collections.addAll(wineList, wines);
        return wineList;
    }
}