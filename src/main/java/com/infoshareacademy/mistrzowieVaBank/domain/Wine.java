package com.infoshareacademy.mistrzowieVaBank.domain;

import java.math.BigDecimal;

public class Wine {
    private int wineId;
    private String wineName;
    private String wineFlavour;
    private String wineType;
    private int wineDivision;
    private String wineOrigin;
    private BigDecimal winePrice;
    public Wine(int WineId, String wineName, String wineFlavour, String wineType, int wineDivision, String wineOrigin, BigDecimal winePrice) {
        this.wineId = WineId;
        this.wineName = wineName;
        this.wineFlavour = wineFlavour;
        this.wineType = wineType;
        this.wineDivision = wineDivision;
        this.wineOrigin = wineOrigin;
        this.winePrice = winePrice;

    }
    @Deprecated
    public Wine(String wineName) {
        this.wineName = wineName;
    }

    @Deprecated
    public Wine(String wineName, String wineFlavour){this.wineName = wineName;
    this.wineFlavour = wineFlavour;}

    public int getWineId() {
        return wineId;
    }

    public void setWineId(int wineId) {
        this.wineId = wineId;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineFlavour() {
        return wineFlavour;
    }

    public void setWineFlavour(String wineFlavour) {
        this.wineFlavour = wineFlavour;
    }

    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    public int getWineDivision() {
        return wineDivision;
    }

    public void setWineDivision(int wineDivision) {
        this.wineDivision = wineDivision;
    }

    public String getWineOrigin() {
        return wineOrigin;
    }

    public void setWineOrigin(String wineOrigin) {
        this.wineOrigin = wineOrigin;
    }

    public BigDecimal getWinePrice() {
        return winePrice;
    }

    public void setWinePrice(BigDecimal winePrice) {
        this.winePrice = winePrice;
    }

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
}
