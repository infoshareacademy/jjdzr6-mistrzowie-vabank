package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshareacademy.menu.Menu.scanner;

public class ClientPanel {
    static String[] clientOptionArray = {"1. Lista win", "2. Koszyk", "3. Powrót"};

    void showClientPanel() throws IOException {
        int caseNumber = 0;
        while(caseNumber != 3){
            showClientOption();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(clientOptionArray));
                caseNumber = scanner.nextInt();
                switch(caseNumber){
                    case 1 -> showVineList();
                    case 2 -> showShoppingCart();
                    case 3 -> System.out.println("Powrót");
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }
    void showClientOption(){
        System.out.println("Jesteś na profilu klienta");
    }

    void showVineList() throws IOException {
        int nr = 0;
        while(nr != 1){
            fileReader();
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try{
                nr = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }

    void showShoppingCart(){
        int nr = 0;
        while(nr != 1){
            System.out.println("Twoje produkty: ");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try{
                nr = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }
    void fileReader() throws IOException {
        WineReader resourceLoader = new WineReader();
        resourceLoader.loadWineAsResource();
    }

}
