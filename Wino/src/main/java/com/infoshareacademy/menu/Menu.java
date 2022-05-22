package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshareacademy.menu.ClientPanel.showClientPanel;
import static com.infoshareacademy.menu.WarehousemanPanel.showCarehousemanPanel;

public class Menu{
    static Scanner scanner = new Scanner(System.in);
    static String[] menuOptionArray = {"1. Klient", "2. Magazynier", "3. Wyjdź z hurtowni"};
    public static void menu() throws IOException {
        int caseNumber = 0;
        while (caseNumber != 3){
            showMenu();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(menuOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> showClientPanel();
                    case 2 -> showCarehousemanPanel();
                    case 3 -> close();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }

    static void showMenu(){
        System.out.println("Witaj w panelu hurtowni win VaBank,");
        System.out.println("Wybierz użytkownika\n");
    }

    static void close(){
        System.out.println("Opuszczanie hurtowni, do następnego razu!");
    }
}
