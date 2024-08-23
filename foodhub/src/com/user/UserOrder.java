package com.user;

import com.admin.Item;
import com.user.InsertData;
import com.user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UserOrder {
    private ArrayList<Item> items;
    private Scanner sc;
    private InsertData insertData;

    public UserOrder(ArrayList<Item> items, Scanner sc) {
        this.items = items;
        this.sc = sc;
        this.insertData = new InsertData();
    }

    public void orderItems(User user) {
        ArrayList<Item> orderedItems = new ArrayList<>();
        double totalPrice = 0.0;

        // Display available items
        System.out.println("Available items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getPrice());
        }

        // Ask for order items
        System.out.println("Enter the numbers of the items you want to order (type '0' to finish):");
        while (true) {
            int itemNumber = sc.nextInt();
            sc.nextLine(); // Consume newline
            if (itemNumber == 0) {
                break;
            }
            if (itemNumber > 0 && itemNumber <= items.size()) {
                Item item = items.get(itemNumber - 1);
                orderedItems.add(item);
                totalPrice += item.getPrice();
            } else {
                System.out.println("Invalid item number. Please try again.");
            }
        }

        System.out.println("Order placed. Total price: " + totalPrice);
        insertData.storeOrder(user.getUsername(), user.getPhoneNumber(), totalPrice);
    }
}
