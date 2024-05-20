package com.example.cupcakefactory.entity;

import java.util.ArrayList;

public class Category {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }
    private static ArrayList<Category> categoryArrayList = new ArrayList<>();

    public static ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }
    public static void addCategory(Category category) {
        categoryArrayList.add(category);
    }
}
