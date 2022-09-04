package com.infoshareacademy.mistrzowieVaBank.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.mistrzowieVaBank.domain.Wine;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WineJson {

    List<Wine> vines = Arrays.asList(
            new Wine(0, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", BigDecimal.valueOf(560)),
            new Wine(1, "Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial", "Słodkie", "Białe", 2017, "Węgry", BigDecimal.valueOf(100)),
            new Wine(2, "Château Lafite Rothschild Premiere Cru Classe Pauillac", "Wytrwane", "Czerwone", 2010, "Francja", BigDecimal.valueOf(8550)),
            new Wine(3, "Chateau Mouton Rothschild 1-er Cru Classe", "Wytrawne", "Czerwone", 2011, "Francja", BigDecimal.valueOf(4650)),
            new Wine(4, "Catena Zapata Adrianna Vineyard „River Stones Malbec", "Wytrawne", "Czerwone", 2018, "Argentyna", BigDecimal.valueOf(699)),
            new Wine(5, "Muscaris Kojder", "Półsłodkie", "Białe", 2020, "Polska", BigDecimal.valueOf(89)),
            new Wine(6, "Araldica Moscato d'Asti", "Półsłodkie", "Musujące", 2020, "Włochy", BigDecimal.valueOf(55)),
            new Wine(7, "Tamada Kindzmarauli", "Półsłodkie", "Czerwone", 2019, "Gruzja", BigDecimal.valueOf(49)),
            new Wine(8, "Dominio de Pingus Pingus Ribera Del Duero DO", "Wytrawne", "Czerwone", 2018, "Hiszpania", BigDecimal.valueOf(5549)),
            new Wine(9, "Bestheim Pinot Gris Classic Alsace", "Półwytrawne", "Białe", 2019, "Francja", BigDecimal.valueOf(65)),
            new Wine(10, "Carmenere Gran Reserva Vina Falernia", "Półwytrawne", "Czerwone", 2018, "Chile", BigDecimal.valueOf(79)),
            new Wine(11, "Soley Winnica Słońce i Wiatr", "Półwytrawne", "Białe", 2020, "Polska", BigDecimal.valueOf(79))
    );

    public void WritingVineToJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Mikolaj.gurgul\\IdeaProjects\\jjdzr6-mistrzowie-vabank-JJDZR6MV-18\\jjdzr6-mistrzowie-vabank-JJDZR6MV-18\\src\\main\\resources/Wine.json"));
        gson.toJson(vines, writer);

        writer.close();
    }
}