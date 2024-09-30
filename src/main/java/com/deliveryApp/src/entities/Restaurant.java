package main.java.com.deliveryApp.src.entities;

import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private List<Product> menu;

    public Restaurant(String name, String address, List<Product> menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<Product> getMenu() {
        return menu;
    }
}