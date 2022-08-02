package com.infoshareacademy.menu.client;

import com.infoshareacademy.service.WineService;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ClientPanel {
    static String[] clientOptionArray = {"1. Powrót", "2. Lista win", "3. Koszyk"};
    static Scanner scanner = new Scanner(System.in);
    private ClientOption clientOption = new ClientOption();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private WineService wineService = new WineService();
    public void showClientPanel() throws IOException {
        int caseNumber = 0;
        while(caseNumber != 1){
            clientOption.showClientOption();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(clientOptionArray));
                caseNumber = scanner.nextInt();
                switch(caseNumber){
                    case 1 -> System.out.println("Powrót");
                    case 2 -> wineService.showWineList();
                    case 3 -> shoppingCart.showShoppingCart();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }
}
