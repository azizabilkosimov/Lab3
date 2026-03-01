/**
 * Project: Lab 3 - MySQL and MongoDB CRUD
 * Purpose Details: Customer class used for a retail shopping store and written to both databases.
 * Course: IST242
 * Author: Aziz Abilkosimov
 * Date Developed: 03/01/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */
package com.lab3;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int loyaltyPoints;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String email,
                    String phone, String address, int loyaltyPoints) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    public boolean isVip() {
        return loyaltyPoints >= 1000;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}