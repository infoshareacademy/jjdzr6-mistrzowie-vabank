package com.infoshareacademy.menu.client;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ShoppingCart {
    static Scanner scanner = new Scanner(System.in);

    public void showShoppingCart(){
        int nr = 0;
        while(nr != 1){
            System.out.println("Twoje produkty: ");
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
