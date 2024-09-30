package main.java.com.deliveryApp.src.repositories;

import main.java.com.deliveryApp.src.entities.Cart;

public interface CartRepository {
    void save(Cart cart);
    Cart load();
}