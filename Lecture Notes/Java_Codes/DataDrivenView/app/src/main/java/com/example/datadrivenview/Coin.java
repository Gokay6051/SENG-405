package com.example.datadrivenview;

public class Coin {

    private String name;
    private String image;
    private Double currentPrice;

    public Coin(String name, String image, Double currentPrice) {
        this.name = name;
        this.image = image;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
