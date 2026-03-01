/**
 * Project: Lab 3 - MySQL and MongoDB CRUD
 * Purpose Details: MongoDB CRUD operations for Customer documents.
 * Course: IST242
 * Author: Aziz Abilkosimov
 * Date Developed: 03/01/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */

package com.lab3;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoCustomerCRUD {

    private static final String MONGO_URI = "mongodb://localhost:27017";
    private static final String DB_NAME = "Lab3Aziz";
    private static final String COLLECTION_NAME = "customers";

    private MongoCollection<Document> getCollection() {
        MongoClient client = MongoClients.create(MONGO_URI);
        MongoDatabase db = client.getDatabase(DB_NAME);
        return db.getCollection(COLLECTION_NAME);
    }

    public void createCustomer(Customer c) {
        Document doc = new Document("customerId", c.getCustomerId())
                .append("firstName", c.getFirstName())
                .append("lastName", c.getLastName())
                .append("email", c.getEmail())
                .append("phone", c.getPhone())
                .append("address", c.getAddress())
                .append("loyaltyPoints", c.getLoyaltyPoints());

        getCollection().insertOne(doc);
    }

    public List<String> readAllCustomers() {
        List<String> results = new ArrayList<>();
        for (Document doc : getCollection().find()) {
            results.add(doc.toJson());
        }
        return results;
    }

    public void updateCustomerEmail(int customerId, String newEmail) {
        getCollection().updateOne(eq("customerId", customerId), set("email", newEmail));
    }

    public void deleteCustomer(int customerId) {
        getCollection().deleteOne(eq("customerId", customerId));
    }
}