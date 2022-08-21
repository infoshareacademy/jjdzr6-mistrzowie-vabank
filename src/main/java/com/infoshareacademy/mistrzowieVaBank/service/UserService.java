package com.infoshareacademy.mistrzowieVaBank.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserService {

    public void showOptionMenu(){
        System.out.println("Witaj w panelu hurtowni win VaBank,");
        System.out.println("Wybierz użytkownika\n");
    }

    static Scanner scanner = new Scanner(System.in);
    static String[] menuOptionArray = {"1. Wyjdź z hurtowni", "2. Klient", "3. Magazynier"};
    private WarehouseUserService warehousemanPanel = new WarehouseUserService();

    public void showMenu() throws IOException {
        int caseNumber = 0;
        while (caseNumber != 1){
            showOptionMenu();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(menuOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> close();
                    case 2 -> showClientPanel();
                    case 3 -> warehousemanPanel.showWarehousemanPanel();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }

    public void showClientOption(){
        System.out.println("Jesteś na profilu klienta");
    }


        static String[] clientOptionArray = {"1. Powrót", "2. Lista win", "3. Koszyk"};
       // static Scanner scanner = new Scanner(System.in);
        private OrderService orderService = new OrderService();
        private WineService wineService = new WineService();

        public void showClientPanel() throws IOException {
            int caseNumber = 0;
            while (caseNumber != 1) {
                showClientOption();
                scanner = new Scanner(System.in);
                try {
                    System.out.println(Arrays.toString(clientOptionArray));
                    caseNumber = scanner.nextInt();
                    switch (caseNumber) {
                        case 1 -> System.out.println("Powrót");
                        case 2 -> wineService.showWineList();
                        case 3 -> orderService.showShoppingCart();
                        default -> System.out.println("\nWybierz właściwą opcję!\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nMusisz podać liczbę całkowitą!\n");
                }
            }
        }

    public void close(){
        System.out.println("Opuszczanie hurtowni, do następnego razu!");
    }

}
