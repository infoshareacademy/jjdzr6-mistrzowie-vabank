package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
    private ClientPanel clientPanel = new ClientPanel();
    static Scanner scanner = new Scanner(System.in);
    static String[] menuOptionArray = {"1. Klient", "2. Magazynier", "3. Wyjdź z hurtowni"};
    WarehousemanPanel warehousemanPanel = new WarehousemanPanel();
    public void menu() throws IOException {
        int caseNumber = 0;
        while (caseNumber != 3){
            showMenu();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(menuOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> clientPanel.showClientPanel();
                    case 2 -> warehousemanPanel.showCarehousemanPanel();
                    case 3 -> close();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }

    void showMenu(){
        System.out.println("Witaj w panelu hurtowni win VaBank,");
        System.out.println("Wybierz użytkownika\n");
    }

    void close(){
        System.out.println("Opuszczanie hurtowni, do następnego razu!");
    }
}
