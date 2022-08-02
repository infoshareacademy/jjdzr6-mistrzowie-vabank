package com.infoshareacademy.menu.warehouseman;

import com.infoshareacademy.menu.client.ClientPanel;
import com.infoshareacademy.menu.lists.OrderList;
import com.infoshareacademy.service.WineService;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WarehousemanPanel {
    private String[] warehousemanOptionArray = {"1. Powrót", "2. Lista win", "3. Lista zamówień", "4. Produkty na wyczerpaniu"};
    static Scanner scanner = new Scanner(System.in);
    private ClientPanel clientPanel = new ClientPanel();
    private WarehousemanOptioner warehousemanOptioner = new WarehousemanOptioner();
    private WineService wineService = new WineService();
    private OrderList orderList = new OrderList();
    private RunnerOutProducts runnerOutProducts = new RunnerOutProducts();
    public void showWarehousemanPanel() throws IOException {
        int caseNumber = 0;
        while(caseNumber != 1){
            warehousemanOptioner.showWarehousemanOption();
            scanner = new Scanner(System.in);
            try {
                System.out.println(Arrays.toString(warehousemanOptionArray));
                caseNumber = scanner.nextInt();
                switch (caseNumber) {
                    case 1 -> System.out.println("Powrót");
                    case 2 -> wineService.showWineList();
                    case 3 -> orderList.showOrders();
                    case 4 -> runnerOutProducts.showProductsRunningOut();
                    default -> System.out.println("\nWybierz właściwą opcję!\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nMusisz podać liczbę całkowitą!\n");
            }
        }
    }

}
