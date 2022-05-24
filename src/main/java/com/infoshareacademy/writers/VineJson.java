package com.infoshareacademy.writers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.domain.Vine;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VineJson {
    Scanner id = new Scanner(System.in);
    Scanner name = new Scanner(System.in);
    Scanner flavour = new Scanner(System.in);
    Scanner type = new Scanner(System.in);
    Scanner division = new Scanner(System.in);
    Scanner origin = new Scanner(System.in);
    Scanner price = new Scanner(System.in);
    List<Vine> vines = Arrays.asList(
            new Vine(0, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", 560),
            new Vine(1, "Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial", "Słodkie", "Białe", 2017, "Węgry", 100),
            new Vine(2, "Château Lafite Rothschild Premiere Cru Classe Pauillac", "Wytrwane", "Czerwone", 2010, "Francja", 8550),
            new Vine(3, "Chateau Mouton Rothschild 1-er Cru Classe", "Wytrawne", "Czerwone", 2011, "Francja", 4650),
            new Vine(4, "Catena Zapata Adrianna Vineyard „River Stones Malbec", "Wytrawne", "Czerwone", 2018, "Argentyna", 699),
            new Vine(5, "Muscaris Kojder", "Półsłodkie", "Białe", 2020, "Polska", 89),
            new Vine(6, "Araldica Moscato d'Asti", "Półsłodkie", "Musujące", 2020, "Włochy", 55),
            new Vine(7, "Tamada Kindzmarauli", "Półsłodkie", "Czerwone", 2019, "Gruzja", 49),
            new Vine(8, "Dominio de Pingus Pingus Ribera Del Duero DO", "Wytrawne", "Czerwone", 2018, "Hiszpania", 5549),
            new Vine(9, "Bestheim Pinot Gris Classic Alsace", "Półwytrawne", "Białe", 2019, "Francja", 65),
            new Vine(10, "Carmenere Gran Reserva Vina Falernia", "Półwytrawne", "Czerwone", 2018, "Chile", 79),
            new Vine(11, "Soley Winnica Słońce i Wiatr", "Półwytrawne", "Białe", 2020, "Polska", 79),
            new Vine(id.nextInt(), name.nextLine(), flavour.nextLine(), type.nextLine(), division.nextInt(), origin.nextLine(), price.nextInt())
    );

    public void WritingVineToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/Vine.json"));
        gson.toJson(vines, writer);

        writer.close();
    }
}