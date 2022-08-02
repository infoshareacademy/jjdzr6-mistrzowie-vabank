/*package com.infoshareacademy.menu.lists.wine;

import com.infoshareacademy.domain.Wine;
import com.infoshareacademy.service.WineById;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearcherById {
    private WineById wineById = new WineById();
    static Scanner scanner = new Scanner(System.in);
    public void searchWineById(){
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        while(nr != 1) {
            System.out.println("\nPodaj id wina: ");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try {
                nr = scanner.nextInt();
                wineById.ReadingWineToJson();
                Wine wine = wineById.getWineById(nr);
                System.out.println(wine);
            } catch (InputMismatchException | IOException e) {
                System.out.println("Podaj liczbę całkowitą!");
            }
        }
    }
}*/
