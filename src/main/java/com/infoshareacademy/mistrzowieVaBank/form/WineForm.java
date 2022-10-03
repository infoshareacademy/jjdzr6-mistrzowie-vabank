package com.infoshareacademy.mistrzowieVaBank.form;

import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class WineForm {

    //TODO rozszerzyć
    private Long id;
    private String name;
    private BigDecimal price;
 
    private boolean newProduct = false;
 
    // Upload file.
    private MultipartFile fileData;
 
    public WineForm() {
        this.newProduct= true;
    }
 
    public WineForm(Wine wine) {
        this.id = wine.getId();
        this.name = wine.getName();
        this.price = wine.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}
