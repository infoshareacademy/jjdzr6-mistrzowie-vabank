package com.infoshareacademy.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.domain.Wine;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WineJson {
    Scanner id = new Scanner(System.in);
    Scanner name = new Scanner(System.in);
    Scanner flavour = new Scanner(System.in);
    Scanner type = new Scanner(System.in);
    Scanner division = new Scanner(System.in);
    Scanner origin = new Scanner(System.in);
    Scanner price = new Scanner(System.in);
    List<Wine> wines = Arrays.asList(
            new Wine(0, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", 560),
            new Wine(1, "Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial", "Słodkie", "Białe", 2017, "Węgry", 100),
            new Wine(2, "Château Lafite Rothschild Premiere Cru Classe Pauillac", "Wytrwane", "Czerwone", 2010, "Francja", 8550),
            new Wine(3, "Chateau Mouton Rothschild 1-er Cru Classe", "Wytrawne", "Czerwone", 2011, "Francja", 4650),
            new Wine(4, "Catena Zapata Adrianna Vineyard „River Stones Malbec", "Wytrawne", "Czerwone", 2018, "Argentyna", 699),
            new Wine(5, "Muscaris Kojder", "Półsłodkie", "Białe", 2020, "Polska", 89),
            new Wine(6, "Araldica Moscato d'Asti", "Półsłodkie", "Musujące", 2020, "Włochy", 55),
            new Wine(7, "Tamada Kindzmarauli", "Półsłodkie", "Czerwone", 2019, "Gruzja", 49),
            new Wine(8, "Dominio de Pingus Pingus Ribera Del Duero DO", "Wytrawne", "Czerwone", 2018, "Hiszpania", 5549),
            new Wine(9, "Bestheim Pinot Gris Classic Alsace", "Półwytrawne", "Białe", 2019, "Francja", 65),
            new Wine(10, "Carmenere Gran Reserva Vina Falernia", "Półwytrawne", "Czerwone", 2018, "Chile", 79),
            new Wine(11, "Soley Winnica Słońce i Wiatr", "Półwytrawne", "Białe", 2020, "Polska", 79),
            new Wine(id.nextInt(), name.nextLine(), flavour.nextLine(), type.nextLine(), division.nextInt(), origin.nextLine(), price.nextInt())
    );

    public void WritingVineToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/Wine.json"));
        gson.toJson(wines, writer);

        writer.close();
    }
}