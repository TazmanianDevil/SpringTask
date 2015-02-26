package com.task.common.controller;

import com.task.common.model.Customer;
import com.task.common.model.Order;
import com.task.common.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Musin on 26.02.2015.
 */
public class Customers {
    ArrayList<Customer> customers;

    public Customers() {
        customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer (Customer c) {
        customers.add(c);
    }

    public Customer getCustomer(int index) {
        if ((customers.size() > 0) && (index > -1) &&(index < customers.size()))
            return customers.get(index);
        else return null;
    }


    public double getTotalAmount() {
        double total = 0;
        for (Customer c: customers) {
            total += c.getOrdersAmount();
            }
        return total;
    }

    public Customer getMaxOrderCustomer() {
        Customer customer = null;
        if ((customers!= null) &&(customers.size() > 0)) {
            customer = customers.get(0);
            for (Customer c: customers) {
                if (customer.getOrdersAmount() < c.getOrdersAmount())
                    customer = c;
            }
        }
        return customer;
    }

    public double getMaxOrderAmount() {
        double total = Double.MIN_VALUE;
        if ((customers!= null) &&(customers.size() > 0)) {

            for (Customer c: customers) {
                for (Order o: c.getOrders()) {
                    if (o.getOrderAmount() > total)
                        total = o.getOrderAmount();
                }
            }
        }
        return total;
    }

    public double getMinOrderAmount() {
        double total = Double.MAX_VALUE;
        if ((customers!= null) &&(customers.size() > 0)) {

            for (Customer c: customers) {
                for (Order o: c.getOrders()) {
                    if (o.getOrderAmount() < total)
                            total = o.getOrderAmount();
                }
            }
        }
        return total;
    }

    public int getTotalOrdersCount() {
        int total = 0;
        if (customers != null) {
            for (Customer c: customers) {
                total += c.getOrdersCount();
            }

        }
        return total;
    }
}
