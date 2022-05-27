package com.infoshareacademy.domain;

public class Wine {
    private int wineId;
    private String wineName;
    private String wineFlavour;
    private String wineType;
    private int wineDivision;
    private String wineOrigin;
    private int winePrice;

    @Override
    public String toString() {
        return "Vine{" +
                "vineId=" + wineId +
                ", vineName='" + wineName + '\'' +
                ", vineVintage=" + wineFlavour +
                ", vineType='" + wineType + '\'' +
                ", vineDivision='" + wineDivision + '\'' +
                ", vineOrigin='" + wineOrigin + '\'' +
                ", vinePrice=" + winePrice +
                '}';
    }

    public Wine(int WineId, String wineName, String wineFlavour, String wineType, int wineDivision, String wineOrigin, int winePrice) {
        this.wineId = WineId;
        this.wineName = wineName;
        this.wineFlavour = wineFlavour;
        this.wineType = wineType;
        this.wineDivision = wineDivision;
        this.wineOrigin = wineOrigin;
        this.winePrice = winePrice;

    }
}
