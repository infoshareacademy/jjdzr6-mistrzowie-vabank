package com.infoshareacademy.menu.collaborative;

import com.infoshareacademy.menu.client.ClientPanel;
import com.infoshareacademy.menu.warehouseman.WarehousemanPanel;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
    private ClientPanel clientPanel = new ClientPanel();
    static Scanner scanner = new Scanner(System.in);
    static String[] menuOptionArray = {"1. Wyjdź z hurtowni", "2. Klient", "3. Magazynier"};
    private WarehousemanPanel warehousemanPanel = new WarehousemanPanel();
    private MenuOption menuOption = new MenuOption();
    private OuterPanel outerPanel = new OuterPanel();
    public void showMenu() throws IOException {
        int caseNumber = 0;
        while (caseNumber != 1){
            menuOption.showOptionMenu();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(menuOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> outerPanel.close();
                    case 2 -> clientPanel.showClientPanel();
                    case 3 -> warehousemanPanel.showWarehousemanPanel();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }
}
