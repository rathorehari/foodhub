package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import service.EasyConnection;

public class InsertData {
    public void storeOrder(String userName, String phoneNumber, double totalPrice) {
        String query = "INSERT INTO orders (username, phone_number, total_price) VALUES (?, ?, ?)";
        try (Connection con = EasyConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, userName);
            stmt.setString(2, phoneNumber);
            stmt.setDouble(3, totalPrice);
            stmt.executeUpdate();
            System.out.println("Order stored in database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
