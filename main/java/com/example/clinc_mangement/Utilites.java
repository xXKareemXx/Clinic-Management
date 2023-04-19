package com.example.clinc_mangement;

public abstract class Utilites {
    private String product_name;
    private double cost;

    public Utilites(){}

    public Utilites(String product_name, double cost) {
        this.product_name = product_name;
        this.cost = cost;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

