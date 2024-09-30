package main.java.com.deliveryApp.src.usecases;

import main.java.com.deliveryApp.src.entities.Cart;
import main.java.com.deliveryApp.src.entities.Product;
import main.java.com.deliveryApp.src.repositories.CartRepository;

public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addProductToCart(Cart cart, Product product) {
        cart.addItem(product);
        cartRepository.save(cart);
    }

    public Cart getCart() {
        return cartRepository.load();
    }
}