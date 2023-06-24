package com.backend.server.model;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Order")
public class Order {
    @Id
    private String id;
    private String orderName;
    private String orderDescription;

    public Order() {
    }

    public Order(String id, String orderName, String orderDescription) {
        this.id = id;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
