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

    public int getWinePrice() {
        return winePrice;
    }

    public void setWinePrice(int winePrice) {
        this.winePrice = winePrice;
    }
}
