package com.example.androidfinaldb;

public class Car {
    public static final String TABLE_NAME = "cars";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_VARIANT = "variant";
    public static final String COLUMN_PRICE = "price";

    private int id;
    private double price;
    private String model,variant;

    public Car(){

    }

    public Car(int id,String model,String variant,double price){
        this.id = id;
        this.price = price;
        this.model = model;
        this.variant = variant;
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }



}
