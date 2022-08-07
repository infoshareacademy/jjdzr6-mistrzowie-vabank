package com.infoshareacademy.service;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WarehouseUserService {
    private String[] warehousemanOptionArray = {"1. Powrót", "2. Lista win", "3. Lista zamówień", "4. Produkty na wyczerpaniu"};
    private WineService wineService = new WineService();
    private OrderService orderService = new OrderService();


    static Scanner scanner = new Scanner(System.in);

    public void showWarehousemanOption(){
        System.out.println("Jesteś na profilu magazyniera");
    }

    public void showWarehousemanPanel() throws IOException {
        int caseNumber = 0;
        while(caseNumber != 1){
            showWarehousemanOption();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(warehousemanOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> System.out.println("Powrót");
                    case 2 -> wineService.showWineList();
                    case 3 -> orderService.showOrders();
                    case 4 -> showProductsRunningOut();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }

    public void showProductsRunningOut(){
      //  Scanner scanner = new Scanner(System.in);
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
