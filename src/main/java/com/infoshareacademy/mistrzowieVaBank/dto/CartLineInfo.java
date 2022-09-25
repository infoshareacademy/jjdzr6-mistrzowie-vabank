package com.infoshareacademy.mistrzowieVaBank.dto;

import java.math.BigDecimal;

public class CartLineInfo {
	  
    private WineInfo wineInfo;
    private int quantity;
  
    public CartLineInfo() {
        this.quantity = 0;
    }
  
    public WineInfo getWineInfo() {
        return wineInfo;
    }
  
    public void setProductInfo(WineInfo wineInfo) {
        this.wineInfo = wineInfo;
    }
  
    public int getQuantity() {
        return quantity;
    }
  
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
    public BigDecimal getAmount() {
        return this.wineInfo.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }
     
}