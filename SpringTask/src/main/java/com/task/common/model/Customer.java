package com.task.common.model;

import java.util.List;

/**
 * Created by Musin on 26.02.2015.
 */
public class Customer {
    private Integer id;
    private String name;
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Double getOrdersAmount() {
        double total = 0;
        if (orders != null) {
            for (Order o: orders) {
                if (o.getOrderAmount() == null)
                    return null;
                total += o.getOrderAmount();
            }
        }
        return total;
    }

    public String toString() {
        return name;
    }

    public int getOrdersCount() {
        if (orders!=null) {
            return orders.size();
        }
        else return 0;
    }
}
