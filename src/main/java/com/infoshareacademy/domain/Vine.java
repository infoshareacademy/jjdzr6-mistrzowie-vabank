package com.infoshareacademy.domain;

public class Vine {
    private int vineId;
    private String vineName;
    private int vineVintage;
    private String vineType;
    private String vineDivision;
    private String vineOrigin;
    private int vinePrice;

    @Override
    public String toString() {
        return "Vine{" +
                "vineId=" + vineId +
                ", vineName='" + vineName + '\'' +
                ", vineVintage=" + vineVintage +
                ", vineType='" + vineType + '\'' +
                ", vineDivision='" + vineDivision + '\'' +
                ", vineOrigin='" + vineOrigin + '\'' +
                ", vinePrice=" + vinePrice +
                '}';
    }

    public Vine(int vineId, String vineName, int vineVintage, String vineType, String vineDivision, String vineOrigin, int vinePrice) {
        this.vineId = vineId;
        this.vineName = vineName;
        this.vineVintage = vineVintage;
        this.vineType = vineType;
        this.vineDivision = vineDivision;
        this.vineOrigin = vineOrigin;
        this.vinePrice = vinePrice;

    }
}
