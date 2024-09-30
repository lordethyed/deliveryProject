package main.java.com.deliveryApp.src.entities;

import main.java.com.deliveryApp.src.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    private static final double DELIVERY_FEE = 20.00;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateTotalPrice() {
        double total = items.stream().mapToDouble(Product::getPrice).sum();
        return total + DELIVERY_FEE;
    }

    public List<Product> getItems() {
        return items;
    }

    public static double getDeliveryFee() {
        return DELIVERY_FEE;
    }
}