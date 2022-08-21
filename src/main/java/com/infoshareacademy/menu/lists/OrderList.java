package com.infoshareacademy.menu.lists;

import java.util.InputMismatchException;
import java.util.Scanner;


public class OrderList {
    static Scanner scanner = new Scanner(System.in);
    public void showOrders(){
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
}
