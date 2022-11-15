package com.infoshareacademy.mistrzowieVaBank.dto;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
public class NewWineInfo {

    @NotBlank(message = "Name cannot be empty")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "Flavour cannot be empty")
    private String flavour;
    @NotBlank(message = "Type cannot be empty")
    private String type;
    @Max(value = 2022)
    @NotNull
    private int year;
    @NotBlank(message = "Origin cannot be empty")
    private String origin;
    @Min(value = 1, message = "Price cannot be lower then 1")
    @NotNull
    private BigDecimal price;
    @Min(value = 1, message = "Quantity cannot be lower then 1")
    @NotNull
    private int quantity;
    @NotBlank(message = "Specification cannot be empty")
    private String spec;

    @Column(name = "file")
    @Lob
    private byte[] file;

    public NewWineInfo(String name, String flavour, String type, int year, String origin, BigDecimal price, int quantity, String spec, byte[] file) {
        this.name = name;
        this.flavour = flavour;
        this.type = type;
        this.year = year;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
        this.spec = spec;
        this.file = file;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "NewWineInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
