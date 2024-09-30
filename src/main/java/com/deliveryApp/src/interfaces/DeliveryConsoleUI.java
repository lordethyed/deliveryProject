package main.java.com.deliveryApp.src.interfaces;

import main.java.com.deliveryApp.src.entities.Cart;
import main.java.com.deliveryApp.src.entities.Product;
import main.java.com.deliveryApp.src.entities.Restaurant;
import main.java.com.deliveryApp.src.usecases.CartService;
import main.java.com.deliveryApp.src.usecases.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryConsoleUI {
    private CartService cartService;
    private List<Restaurant> restaurants;

    public DeliveryConsoleUI(CartService cartService) {
        this.cartService = cartService;
        this.restaurants = new ArrayList<>();
        loadRestaurants();
    }

    private void loadRestaurants() {
        List<Product> menu1 = List.of(new Product("Burger", 8.99), new Product("Fries", 2.99));
        List<Product> menu2 = List.of(new Product("Pizza", 12.99), new Product("Pasta", 10.99));
        restaurants.add(new Restaurant("Fast Food Place", "123 Fast St", menu1));
        restaurants.add(new Restaurant("Italian Restaurant", "456 Italian Ave", menu2));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("1. View Restaurants and Menu");
            System.out.println("2. View Cart");
            System.out.println("3. Confirm Order");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayRestaurants();
                    System.out.println("Select a restaurant by number:");
                    int restaurantChoice = scanner.nextInt();
                    scanner.nextLine();
                    Restaurant selectedRestaurant = restaurants.get(restaurantChoice - 1);
                    displayMenu(selectedRestaurant);
                    System.out.println("Select an item by number:");
                    int productChoice = scanner.nextInt();
                    scanner.nextLine();
                    Product selectedProduct = selectedRestaurant.getMenu().get(productChoice - 1);
                    cartService.addProductToCart(cart, selectedProduct);
                    System.out.println(selectedProduct.getName() + " added to cart.");
                    break;
                case 2:
                    displayCart(cart);
                    break;
                case 3:
                    confirmOrder(cart, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the delivery app!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayRestaurants() {
        System.out.println("Restaurants:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }
    }

    private void displayMenu(Restaurant restaurant) {
        System.out.println("Menu for " + restaurant.getName() + ":");
        for (int i = 0; i < restaurant.getMenu().size(); i++) {
            Product product = restaurant.getMenu().get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }
    }

    private void displayCart(Cart cart) {
        System.out.println("Your Cart:");
        for (Product item : cart.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Delivery Fee: $" + Cart.getDeliveryFee());
        System.out.println("Total Price: $" + cart.calculateTotalPrice());
    }

    private void confirmOrder(Cart cart, Scanner scanner) {
        System.out.println("Enter your delivery address:");
        String deliveryAddress = scanner.nextLine();
        OrderService orderService = new OrderService

                (cart, deliveryAddress);
        orderService.generateReceipt();
    }
}