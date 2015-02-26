package com.task.common.model;

/**
 * Created by Musin on 26.02.2015.
 */
public class Position {
    private Integer id;
    private Double price;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getPositionAmount() {
        return price * count;
    }
    public String toString() {
        return id + " " + price + " " + count;
    }
}
