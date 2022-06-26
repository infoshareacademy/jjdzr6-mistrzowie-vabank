package com.infoshareacademy.menu.client;

import com.infoshareacademy.domain.Wine;
import com.infoshareacademy.service.OrderList;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ShoppingCart {
    static Scanner scanner = new Scanner(System.in);

    private OrderList orderList = new OrderList();

    public void showShoppingCart() throws IOException {
        int nr = 0;
        while(nr != 1){
            System.out.println("Twoje produkty: ");
            orderList.ReadingOrderListToJson();
            System.out.println();

            for(Wine wine : orderList.getOrderList()){
                System.out.println(wine);
            }

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
