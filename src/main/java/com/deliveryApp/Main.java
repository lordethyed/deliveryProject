package main.java.com.deliveryApp;

import main.java.com.deliveryApp.src.interfaces.DeliveryConsoleUI;
import main.java.com.deliveryApp.src.repositories.CartRepository;
import main.java.com.deliveryApp.src.repositories.InMemoryCartRepository;
import main.java.com.deliveryApp.src.usecases.CartService;

public class Main {
    public static void main(String[] args) {
        CartRepository cartRepository = new InMemoryCartRepository();
        CartService cartService = new CartService(cartRepository);

        DeliveryConsoleUI ui = new DeliveryConsoleUI(cartService);
        ui.start();
    }
}
