package com.infoshareacademy.wine;

import com.infoshareacademy.service.WineByFlavour;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class SearcherByFlavour {
    static Scanner scanner = new Scanner(System.in);
    private WineByFlavour wineByFlavour = new WineByFlavour();

    public void searchWineByFlavour() {
        String nr = "";
        while (!Objects.equals(nr, "1")) {
            System.out.println("\nPodaj smak wina");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try {
                nr = scanner.nextLine();
                wineByFlavour.ReadingWineToJson();
                System.out.println(Arrays.toString(wineByFlavour.getWineByFlavour(nr)));
            } catch (InputMismatchException | IllegalArgumentException | IOException e) {
                System.out.println("Podaj smak! Słodkie/Półsłodkie/Wytrawne/Półwytrawne");
            }
        }
    }
}
