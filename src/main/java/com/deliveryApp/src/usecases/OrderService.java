package main.java.com.deliveryApp.src.usecases;

import main.java.com.deliveryApp.src.entities.Cart;
import main.java.com.deliveryApp.src.entities.Product;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class OrderService {
    private Cart cart;
    private String deliveryAddress;

    public OrderService(Cart cart, String deliveryAddress) {
        this.cart = cart;
        this.deliveryAddress = deliveryAddress;
    }

    public String generateOrderNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void generateReceipt() {
        String orderNumber = generateOrderNumber();
        String userHome = System.getProperty("user.home");
        String downloadsFolderPath = userHome + File.separator + "Downloads";
        String receiptFileName = downloadsFolderPath + File.separator + "receipt_" + orderNumber + ".txt";
        String receiptContent = "Order Number: " + orderNumber + "\n" +
                "Delivery Address: " + deliveryAddress + "\n" +
                "Items:\n";
        for (Product product : cart.getItems()) {
            receiptContent += product.getName() + " - $" + product.getPrice() + "\n";
        }
        receiptContent += "Delivery Fee: $" + Cart.getDeliveryFee() + "\n";
        receiptContent += "Total Price: $" + cart.calculateTotalPrice() + "\n";

        try (FileWriter writer = new FileWriter(receiptFileName)) {
            writer.write(receiptContent);
            System.out.println("Your order by number #" + orderNumber + " has been accepted, the food will be in 30 minutes");

            openReceiptFile(receiptFileName);
        } catch (IOException e) {
            System.out.println("Error to order, try later");
        }
    }

    private void openReceiptFile(String receiptFileName) {
        try {
            File receiptFile = new File(receiptFileName);
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (receiptFile.exists()) {
                    desktop.open(receiptFile);
                }
            } else {
                System.out.println("Opening files is not supported on this system.");
            }
        } catch (IOException e) {
            System.out.println("Error opening the receipt file: " + e.getMessage());
        }
    }
}