package com.infoshareacademy.mistrzowieVaBank.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.infoshareacademy.mistrzowieVaBank.domain.Wine;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class WineService {
    private Wine[] wines;
    Scanner scanner = new Scanner(System.in);

    public void showWineList() throws IOException {
       // Scanner scanner = new Scanner(System.in);
        int nr = 0;
        while (nr != 1) {
            ReadingWineToJson();
            System.out.println("1. Powrót");
            System.out.println("2. Wyszukiwanie win po ID");
            System.out.println("3. Wyszukiwanie win po smaku");
            scanner = new Scanner(System.in);
            try {
                nr = scanner.nextInt();
                switch (nr) {
                    case 1 -> System.out.println("Powrót");
                    case 2 -> searchWineById();
                    case 3 -> searchWineByFlavour();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }

    public void ReadingWineToJson() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/Wine.json"));
        wines = gson.fromJson(reader, Wine[].class);
    }

    public List<Wine> getWineByFlavour(String flavour) {
        List<Wine> wineList = new ArrayList<>();
        for (Wine value : wines) {
            if (value.getWineFlavour().toLowerCase().equals(flavour.toLowerCase())) {
                wineList.add(value);
            }
        }
        return wineList;
    }

    public Wine getWineById(int id) {
        for (Wine wine : wines) {
            //System.out.println(wine);
            if (wine.getWineId() == id) {
                return wine;
            }
        }
        throw new IllegalArgumentException();
    }

    public void searchWineByFlavour() {
     //   Scanner scanner = new Scanner(System.in);
        String nr = "";
        while (!Objects.equals(nr, "1")) {
            System.out.println("\nPodaj smak wina");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try {
                nr = scanner.nextLine();
                ReadingWineToJson();

                for (Wine wine : getWineByFlavour(nr)) {
                    System.out.println(wine);
                }

            } catch (InputMismatchException | IllegalArgumentException | IOException e) {
                System.out.println("Podaj smak! Słodkie/Półsłodkie/Wytrawne/Półwytrawne");
            }
        }
    }

    public void searchWineById() {
     //   Scanner scanner = new Scanner(System.in);
        int nr = 0;
        while (nr != 1) {
            System.out.println("\nPodaj id wina: ");
            System.out.println("1. Powrót");
            try {
                nr = scanner.nextInt();
                ReadingWineToJson();
                Wine wine = getWineById(nr);
                System.out.println(wine);
            } catch (InputMismatchException | IOException e) {
                System.out.println("Podaj liczbę całkowitą!");
            }
        }
    }


    public Wine searchWine(){


        return new Wine("Chianti");
    }
}
