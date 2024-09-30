Delivery App - Java Console Application

This project is a Java console-based food delivery system. The app allows users to select food items from different restaurants, view their cart with a total price (including delivery fees), confirm their order, and receive a receipt. The receipt is automatically downloaded to the user’s “Downloads” folder and opens for review.


Features

	•	Select items from multiple restaurants.
	•	View and manage the cart.
	•	Calculate the total price, including a fixed delivery fee.
	•	Confirm the order and enter a delivery address.
	•	Automatically generate a receipt with the order details.
	•	Save the receipt in the “Downloads” folder and automatically open it for review.
	•	Exit the program after completing the order.


Project Structure

The project follows OOP principles, SOLID principles, and Clean Architecture for maintainability and scalability. The structure is as follows:

/DeliveryApp 
│
├── /src
│   ├── /entities
│   │   ├── Cart.java
│   │   ├── Product.java
│   │   ├── Restaurant.java
│   │
│   ├── /repositories
│   │   ├── CartRepository.java
│   │   ├── InMemoryCartRepository.java
│   │
│   ├── /usecases
│   │   ├── CartService.java
│   │   ├── OrderService.java
│   │
│   ├── /interfaces 
│   │   ├── DeliveryConsoleUI.java
│   │
│   ├
│   --- Main.java


Installation and Setup

Prerequisites

	•	Java Development Kit (JDK): Make sure you have JDK 8 or higher installed.
	•	Build Tools: Optionally, you can use Maven or Gradle for dependency management if needed.

Usage

	1.	When the program starts, you will be prompted with a menu where you can:
	•	View restaurants and select food items.
	•	View your cart with a total price, including a delivery fee.
	•	Confirm your order by entering a delivery address.
	•	After confirmation, a receipt is saved to your “Downloads” folder and automatically opened.
	2.	After the order is placed, the program exits automatically.
Example
Welcome to the Delivery App
1. View Restaurants and Menu
2. View Cart
3. Confirm Order
4. Exit

Select an option: 1

Restaurants:
1. Fast Food Place
2. Italian Restaurant

Select a restaurant by number: 1

Menu for Fast Food Place:
1. Burger - $8.99
2. Fries - $2.99

Select an item by number: 1
Burger added to cart.

When you confirm the order, a receipt is saved in your “Downloads” folder with the following format:

Order Number: abc12345
Delivery Address: 123 Main St
Items:
Burger - $8.99
Delivery Fee: $5.00
Total Price: $13.99
