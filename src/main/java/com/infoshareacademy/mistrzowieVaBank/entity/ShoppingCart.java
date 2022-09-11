package com.infoshareacademy.mistrzowieVaBank.entity;

import java.util.List;

public class ShoppingCart {

    private Long id;
    private List<Order> orderList;
    private double orderValue;
    private int quantity;
    private User user;
    private boolean isAccepted;
    private Payment payment;
    private Shipping shipping;



    //todo
//    relacja adresu z userem
// czy koszyk juz istnieje / jest aktywny? boolean
    //rejestracja lub bez / adres z konta lub z palca
    //dobieranie pomimo wypelnienia koszyka
    //dynamiczne przeliczanie cenw koszyku
    // po kliknieciu add to cart dodajemy do koszyka - tworzy sie wpis do db z nowym koszykiem
    //mozna usunac koszyk wtedy usuwamy go z bazy
    //user bez rejestracji musi byc nullem
    //walidacja po stronie koszyka

}
