package com.infoshareacademy.mistrzowieVaBank.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wine")
public class Wine {

    @Id
    @GeneratedValue
    private int wineId;
    @Column(unique = true)
    private String name;
    private String flavour;
    private String type;
    private int year;
    private String origin;
    private BigDecimal price;
    private int quantity;

    public int getWineId() {
        return wineId;
    }

    public void setWineId(int wineId) {
        this.wineId = wineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
