package com.task.common.model;

import com.task.common.model.Customer;
import com.task.common.model.Order;
import com.task.common.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Musin on 26.02.2015.
 */
public class Customers {
    List<Customer> customers;

    public Customers() {
        customers = new ArrayList<Customer>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
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


    public Double getTotalAmount() {
        double total = 0;
        for (Customer c: customers) {
            if (c.getOrdersAmount() == null)
                return null;
            total += c.getOrdersAmount();
            }
        return total;
    }

    public Customer getMaxOrderCustomer() {
        Customer customer = null;
        if ((customers!= null) &&(customers.size() > 0)) {
            customer = customers.get(0);
            for (Customer c: customers) {
                if ((c.getOrdersAmount() != null) &&(customer.getOrdersAmount() != null))
                    if (customer.getOrdersAmount() < c.getOrdersAmount())
                        customer = c;
                else if (customer.getOrdersAmount() == null)
                        customer = c;
                else if (c.getOrdersAmount() == null)
                        continue;
                else if ((c.getOrdersAmount() == null) && (customer.getOrdersAmount() == null))
                        return null;
            }
        }
        return customer;
    }

    public Double getMaxOrderAmount() {
        Double total = Double.MIN_VALUE;
        if ((customers!= null) &&(customers.size() > 0)) {
            for (Customer c: customers) {
                for (Order o: c.getOrders()) {
                    if (o.getOrderAmount() != null)
                    if (o.getOrderAmount() > total)
                        total = o.getOrderAmount();
                }
            }
        }
        return total;
    }

    public Double getMinOrderAmount() {
        double total = Double.MAX_VALUE;
        if ((customers!= null) &&(customers.size() > 0)) {

            for (Customer c: customers) {
                for (Order o: c.getOrders()) {
                    if (o.getOrderAmount() == null)
                        continue;
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
