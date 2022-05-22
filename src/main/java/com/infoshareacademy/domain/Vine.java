package com.infoshareacademy.domain;

public class Vine {
    static int vineId;
    static String vineName;
    static int vineVintage;
    static String vineType;
    static String vineDivision;
    static String vineOrigin;
    static int vinePrice;

    public static int getVineId() {
        return vineId;
    }

    public void setVineId(int vineId) {
        Vine.vineId = vineId;
    }

    public String getVineName() {
        return vineName;
    }

    public void setVineName(String vineName) {
        Vine.vineName = vineName;
    }

    public int getVineVintage() {
        return vineVintage;
    }

    public void setVineVintage(int vineVintage) {
        Vine.vineVintage = vineVintage;
    }

    public String getVineType() {
        return vineType;
    }

    public void setVineType(String vineType) {
        Vine.vineType = vineType;
    }

    public String getVineDivision() {
        return vineDivision;
    }

    public void setVineDivision(String vineDivision) {
        Vine.vineDivision = vineDivision;
    }

    public String getVineOrigin() {
        return vineOrigin;
    }

    public void setVineOrigin(String vineOrigin) {
        Vine.vineOrigin = vineOrigin;
    }

    public int getVinePrice() {
        return vinePrice;
    }

    public void setVinePrice(int vinePrice) {
        Vine.vinePrice = vinePrice;
    }
}
