package com.infoshareacademy.mistrzowieVaBank.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cardName;

    private String cardNumber;

    private int cardExpiryMonth;

    private int cardExpiryYear;

    private String holderName;

    private double amount;





}
