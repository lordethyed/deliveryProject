package main.java.com.deliveryApp.src.repositories;

import main.java.com.deliveryApp.src.entities.Cart;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCartRepository implements CartRepository {
    private Map<Integer, Cart> cartStorage = new HashMap<>();

    @Override
    public void save(Cart cart) {
        cartStorage.put(1, cart);
    }

    @Override
    public Cart load() {
        return cartStorage.get(1);
    }
}