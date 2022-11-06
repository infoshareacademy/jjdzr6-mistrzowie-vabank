package com.infoshareacademy.mistrzowieVaBank.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WineDto {

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

    private byte[] image;

    private LocalDate createDate;
}

