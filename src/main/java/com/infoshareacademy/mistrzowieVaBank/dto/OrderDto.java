package com.infoshareacademy.mistrzowieVaBank.dto;

public class OrderDto {
    private Integer id;
    private String Title;
    private String comment;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return Title;
    }

    public void setBookTitle(String bookTitle) {
        this.Title = bookTitle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}