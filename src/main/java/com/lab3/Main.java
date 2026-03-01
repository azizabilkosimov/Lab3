/**
 * Project: Lab 3 - MySQL and MongoDB CRUD
 * Purpose Details: Creates three Customer objects and performs CRUD in both MySQL and MongoDB.
 * Course: IST242
 * Author: Aziz Abilkosimov
 * Date Developed: 03/01/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */
package com.lab3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        MySqlCustomerCRUD mySql = new MySqlCustomerCRUD();
        MongoCustomerCRUD mongo = new MongoCustomerCRUD();

        Customer c1 = new Customer(1, "John", "Doe", "john@example.com", "215-111-1111", "10 Main St", 120);
        Customer c2 = new Customer(2, "Mary", "Smith", "mary@example.com", "215-222-2222", "20 Oak Ave", 450);
        Customer c3 = new Customer(3, "Alex", "Brown", "alex@example.com", "215-333-3333", "30 Pine Rd", 980);

        mySql.createCustomer(c1);
        mySql.createCustomer(c2);
        mySql.createCustomer(c3);

        mongo.createCustomer(c1);
        mongo.createCustomer(c2);
        mongo.createCustomer(c3);

        List<Customer> mysqlCustomers = mySql.readAllCustomers();
        mysqlCustomers.forEach(System.out::println);

        mongo.readAllCustomers().forEach(System.out::println);

        mySql.updateCustomerEmail(2, "mary.updated@example.com");
        mongo.updateCustomerEmail(2, "mary.updated@example.com");

        //mySql.deleteCustomer(1);
        //mySql.deleteCustomer(2);
        //mySql.deleteCustomer(3);

        //mongo.deleteCustomer(1);
        //mongo.deleteCustomer(2);
        //mongo.deleteCustomer(3);
    }
}