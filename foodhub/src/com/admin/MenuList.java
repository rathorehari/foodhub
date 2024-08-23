package com.admin;

import com.order.UserOrder;
import com.user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuList {
    private ArrayList<Item> items;
    private Scanner sc;
    private UserOrder userOrder;

    public MenuList() {
        items = new ArrayList<>();
        sc = new Scanner(System.in);
        this.userOrder = new UserOrder(items, sc);
    }

    private void addItem() {
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline
        items.add(new Item(name, price));
        System.out.println("Item added.");
    }

    private void viewItems() {
        System.out.println("Items in the list:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private void setItemPrice() {
        System.out.print("Enter item name to set price: ");
        String itemName = sc.nextLine();
        boolean found = false;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.print("Enter new price: ");
                double price = sc.nextDouble();
                sc.nextLine(); // Consume newline
                item.setPrice(price);
                System.out.println("Price updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    private void removeItem() {
        System.out.print("Enter item name to remove: ");
        String itemName = sc.nextLine();
        boolean found = false;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                System.out.println("Item removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void runMenu() {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();
        User user = new User(username, phoneNumber);

        String option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add item");
            System.out.println("2. View items");
            System.out.println("3. Set item price");
            System.out.println("4. Remove item");
            System.out.println("5. Order items");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    addItem();
                    break;
                case "2":
                    viewItems();
                    break;
                case "3":
                    setItemPrice();
                    break;
                case "4":
                    removeItem();
                    break;
                case "5":
                    userOrder.orderItems(user);
                    break;
                case "6":
                    System.out.println("Thank You for using our service...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!option.equals("6"));

        sc.close();
    }

}
