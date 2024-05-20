package com.example.cupcakefactory.entity;

public class CartItem {
    private  String  itemName;
    private int quantity;
    private double price;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CartItem(String itemName, int quantity, double price, String imageUrl) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public CartItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
