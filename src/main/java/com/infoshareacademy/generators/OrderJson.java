package com.infoshareacademy.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.domain.Order;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.domain.Wine;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class OrderJson {
    User user1 = new User(0, "Janek", "Password", "Jan", "Kowalski", "jankowalski@yahoo.com", "123456789");
    User user2 = new User(1, "Matiu", "Haslo", "Mateusz", "Jankowski", "mateuszjankowski@yahoo.com", "789456123");
    User user3 = new User(2, "Casi", "qwerty", "Kasia", "Solecka", "kasiasolecka@yahoo.com", "456789321");
    User user4 = new User(3, "Marti", "asdfgh", "Martyna", "Elska", "martynaelska@yahoo.com", "357891264");

    Wine wine1 = new Wine(0, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", BigDecimal.valueOf(560));
    Wine wine2 = new Wine(1, "Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial", "Słodkie", "Białe", 2017, "Węgry", BigDecimal.valueOf(100));
    Wine wine3 = new Wine(2, "Château Lafite Rothschild Premiere Cru Classe Pauillac", "Wytrwane", "Czerwone", 2010, "Francja", BigDecimal.valueOf(8550));
    Wine wine4 = new Wine(3, "Chateau Mouton Rothschild 1-er Cru Classe", "Wytrawne", "Czerwone", 2011, "Francja", BigDecimal.valueOf(4650));
    Wine wine5 = new Wine(4, "Catena Zapata Adrianna Vineyard „River Stones Malbec", "Wytrawne", "Czerwone", 2018, "Argentyna", BigDecimal.valueOf(699));
    Wine wine6 = new Wine(5, "Muscaris Kojder", "Półsłodkie", "Białe", 2020, "Polska", BigDecimal.valueOf(89));
    Wine wine7 = new Wine(6, "Araldica Moscato d'Asti", "Półsłodkie", "Musujące", 2020, "Włochy", BigDecimal.valueOf(55));
    Wine wine11 = new Wine(10, "Carmenere Gran Reserva Vina Falernia", "Półwytrawne", "Czerwone", 2018, "Chile", BigDecimal.valueOf(79));
    Wine wine12 = new Wine(11, "Soley Winnica Słońce i Wiatr", "Półwytrawne", "Białe", 2020, "Polska", BigDecimal.valueOf(79));

    LocalDate date1 = LocalDate.of(2022, 6, 12);
    LocalDate date2 = LocalDate.of(2022, 5, 20);
    LocalDate date3 = LocalDate.of(2022, 3, 1);
    LocalDate date4 = LocalDate.of(2022, 6, 30);
    LocalDate date5 = LocalDate.of(2022, 1, 16);
    LocalDate date6 = LocalDate.of(2022, 12, 24);
    LocalDate date7 = LocalDate.of(2022, 7, 5);
    LocalDate date8 = LocalDate.of(2022, 8, 9);
    LocalDate date9 = LocalDate.of(2022, 5, 11);

    List<Order> orders = Arrays.asList(
            new Order(0, wine1, user1, date1),
            new Order(1, wine6, user1, date2),
            new Order(2, wine4, user4, date3),
            new Order(3, wine3, user3, date4),
            new Order(4, wine11, user3, date5),
            new Order(5, wine7, user3, date6),
            new Order(6, wine12, user2, date7),
            new Order(7, wine2, user2, date8),
            new Order(8, wine5, user4, date9)
    );
    public void WritingOrderToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Mikolaj.gurgul\\IdeaProjects\\jjdzr6-mistrzowie-vabank-JJDZR6MV-18\\jjdzr6-mistrzowie-vabank-JJDZR6MV-18\\src\\main\\resources/Order.json"));
        gson.toJson(orders, writer);

        writer.close();
    }
}
