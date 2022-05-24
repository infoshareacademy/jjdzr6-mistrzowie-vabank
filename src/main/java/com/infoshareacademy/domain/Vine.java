package com.infoshareacademy.domain;

public class Vine {
    private int vineId;
    private String vineName;
    private String vineFlavour;
    private String vineType;
    private int vineDivision;
    private String vineOrigin;
    private int vinePrice;

    @Override
    public String toString() {
        return "Vine{" +
                "vineId=" + vineId +
                ", vineName='" + vineName + '\'' +
                ", vineVintage=" + vineFlavour +
                ", vineType='" + vineType + '\'' +
                ", vineDivision='" + vineDivision + '\'' +
                ", vineOrigin='" + vineOrigin + '\'' +
                ", vinePrice=" + vinePrice +
                '}';
    }

    public Vine(int vineId, String vineName, String vineFlavour, String vineType, int vineDivision, String vineOrigin, int vinePrice) {
        this.vineId = vineId;
        this.vineName = vineName;
        this.vineFlavour = vineFlavour;
        this.vineType = vineType;
        this.vineDivision = vineDivision;
        this.vineOrigin = vineOrigin;
        this.vinePrice = vinePrice;

    }
}
