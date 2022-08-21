package com.infoshareacademy.menu.warehouseman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunnerOutProducts {

    static Scanner scanner = new Scanner(System.in);
    public void showProductsRunningOut(){
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
