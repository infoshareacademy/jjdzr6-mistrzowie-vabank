package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshareacademy.menu.ClientPanel.fileReader;
import static com.infoshareacademy.menu.Menu.scanner;

public class WarehousemanPanel {
    static String[] warehousemanOptionArray = {"1. Lista win", "2. Lista zamówień", "3. Produkty na wyczerpaniu", "4. Powrót"};

    static void showCarehousemanPanel() throws IOException {
        int caseNumber = 0;
        while(caseNumber != 4){
            showWarehousemanOption();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(warehousemanOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> showVineList();
                    case 2 -> showOrders();
                    case 3 -> showProductsRunningOut();
                    case 4 -> System.out.println("Powrót");
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }
    static void showWarehousemanOption(){
        System.out.println("Jesteś na profilu magazyniera");
    }

    static void showVineList() throws IOException {
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

    static void showOrders(){
        int nr = 0;
        while (nr != 1){
            System.out.println("Zamówienia klientów: ");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try{
                nr = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }

    static void showProductsRunningOut(){
        int nr = 0;
        while(nr != 1){
            System.out.println("Produkty bliskie wyczerpaniu: ");
            System.out.println("1. Powrót");
            scanner = new Scanner(System.in);
            try{
                nr = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nPodaj liczbę całkowitą!\n");
            }
        }
    }
}
