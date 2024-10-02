package com.example.dao.Model;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String productName;

    public Order(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                '}';
    }


}
