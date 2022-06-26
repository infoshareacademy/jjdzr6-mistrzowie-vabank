package com.infoshareacademy.menu.lists.wine;
import com.infoshareacademy.readers.WineJson;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WineList {
    private WineJson wineJson = new WineJson();
    static Scanner scanner = new Scanner(System.in);
    private SearcherById searcherById = new SearcherById();
    private SearcherByFlavour searcherByFlavour = new SearcherByFlavour();
    public void showWineList() throws IOException {
        int nr = 0;
        while(nr != 1){
            wineJson.ReadingWineToJson();
            System.out.println("1. Powrót");
            System.out.println("2. Wyszukiwanie win po ID");
            System.out.println("3. Wyszukiwanie win po smaku");
            scanner = new Scanner(System.in);
            try{
                nr = scanner.nextInt();
                switch(nr){
                    case 1 -> System.out.println("Powrót");
                    case 2 -> searcherById.searchWineById();
                    case 3 -> searcherByFlavour.searchWineByFlavour();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }
}
