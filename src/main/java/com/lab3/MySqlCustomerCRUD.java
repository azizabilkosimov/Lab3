/**
 * Project: Lab 3 - MySQL and MongoDB CRUD
 * Purpose Details: MySQL CRUD operations for the Customer table using JDBC.
 * Course: IST242
 * Author: Aziz Abilkosimov
 * Date Developed: 03/01/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */

package com.lab3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerCRUD {

    private static final String URL = "jdbc:mysql://localhost:3306/Lab3Aziz";
    private static final String USER = "root";
    private static final String PASS = "IST888IST888";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void createCustomer(Customer c) {
        String sql = "INSERT INTO Customer (customerId, firstName, lastName, email, phone, address, loyaltyPoints) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getCustomerId());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPhone());
            ps.setString(6, c.getAddress());
            ps.setInt(7, c.getLoyaltyPoints());

            ps.executeUpdate();
            System.out.println("[MySQL] Inserted: " + c.getCustomerId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Customer> readAllCustomers() {
        List<Customer> results = new ArrayList<>();
        String sql = "SELECT customerId, firstName, lastName, email, phone, address, loyaltyPoints FROM Customer";

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                results.add(new Customer(
                        rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("loyaltyPoints")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return results;
    }

    public void updateCustomerEmail(int customerId, String newEmail) {
        String sql = "UPDATE Customer SET email = ? WHERE customerId = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newEmail);
            ps.setInt(2, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE customerId = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}