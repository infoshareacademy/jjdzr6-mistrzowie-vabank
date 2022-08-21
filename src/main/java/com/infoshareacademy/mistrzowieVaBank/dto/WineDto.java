package com.infoshareacademy.mistrzowieVaBank.dto;

public class WineDto {

    private String name;

    public WineDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WineDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
