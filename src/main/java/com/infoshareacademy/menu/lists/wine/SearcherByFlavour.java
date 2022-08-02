/*package com.infoshareacademy.menu.lists.wine;

import com.infoshareacademy.domain.Wine;
import com.infoshareacademy.service.WineService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class SearcherByFlavour {

    private WineService wineByFlavour = new WineService();

    public void searchWineByFlavour() {
        Scanner scanner = new Scanner(System.in);
        String nr = "";
        while (!Objects.equals(nr, "1")) {
            System.out.println("\nPodaj smak wina");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try {
                nr = scanner.nextLine();
                wineByFlavour.ReadingWineToJson();

                for(Wine wine : wineByFlavour.getWineByFlavour(nr)){
                    System.out.println(wine);
                }

            } catch (InputMismatchException | IllegalArgumentException | IOException e) {
                System.out.println("Podaj smak! Słodkie/Półsłodkie/Wytrawne/Półwytrawne");
            }
        }
    }
}*/
