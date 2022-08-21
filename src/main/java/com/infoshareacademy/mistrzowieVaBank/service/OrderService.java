package com.infoshareacademy.mistrzowieVaBank.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderService {

    public void showOrders(){
        Scanner scanner = new Scanner(System.in);
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

    public void showShoppingCart(){
        Scanner scanner = new Scanner(System.in);
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
