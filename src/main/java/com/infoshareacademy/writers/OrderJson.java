/*package com.infoshareacademy.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.domain.Order;
import com.infoshareacademy.domain.Wine;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.infoshareacademy.writers.UserJson.users;
import static com.infoshareacademy.writers.WineJson.wines;

public class OrderJson {
    List<Order> orders = Arrays.asList(
            new Order(0, wines.get(0), users.get(1)),
            new Order(1, wines.get(5), users.get(0)),
            new Order(1, wines.get(3), users.get(3)),
            new Order(1, wines.get(2), users.get(2)),
            new Order(1, wines.get(10), users.get(2)),
            new Order(1, wines.get(6), users.get(2)),
            new Order(1, wines.get(11), users.get(1)),
            new Order(1, wines.get(1), users.get(1)),
            new Order(1, wines.get(4), users.get(3))
    );
    public void WritingOrderToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/Order.json"));
        gson.toJson(orders, writer);

        writer.close();
    }
}*/
