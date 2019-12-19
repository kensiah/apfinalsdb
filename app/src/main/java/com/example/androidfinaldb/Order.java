package com.example.androidfinaldb;

public class Order {
    public static String TABLE_NAME = "order";
    public static String COLUMN_ID = "id";
    public static String COLUMN_USER = "user";
    public static String COLUMN_PRICE = "price";

    private int id;
    private double price;
    private String user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
