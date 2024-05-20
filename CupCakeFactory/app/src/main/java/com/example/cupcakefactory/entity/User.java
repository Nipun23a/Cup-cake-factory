package com.example.cupcakefactory.entity;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;

    private static ArrayList<User> userArrayList = new ArrayList<>();

    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public static void addUser(User user) {
        userArrayList.add(user);
    }
    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
