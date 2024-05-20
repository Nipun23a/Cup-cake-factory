package com.example.cupcakefactory.entity;

import java.util.ArrayList;

public class Cake {
    private String CakeName;
    private String CakeQuantity;
    private String CakePrice;

    private static ArrayList<Cake> allCakeList;

    public Cake() {
    }

    public Cake(String cakeName, String cakeQuantity, String cakePrice) {
        CakeName = cakeName;
        CakeQuantity = cakeQuantity;
        CakePrice = cakePrice;
    }

    public String getCakeName() {
        return CakeName;
    }

    public void setCakeName(String cakeName) {
        CakeName = cakeName;
    }

    public String getCakeQuantity() {
        return CakeQuantity;
    }

    public void setCakeQuantity(String cakeQuantity) {
        CakeQuantity = cakeQuantity;
    }

    public String getCakePrice() {
        return CakePrice;
    }

    public void setCakePrice(String cakePrice) {
        CakePrice = cakePrice;
    }

    public static ArrayList<Cake> getAllCakeList() {
        return allCakeList;
    }
    public void addCake(Cake cake){
        allCakeList.add(cake);
    }
}
