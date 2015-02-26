package com.task.common.model;

import java.util.List;

/**
 * Created by Musin on 26.02.2015.
 */
public class Order {
    private Integer id;
    private List<Position> positions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public double getOrderAmount() {
        double total = 0;
        if (positions != null) {
            for (Position p: positions) {
                total += p.getPositionAmount();
            }
        }
        return total;
    }

    public String toDouble() {
        return id.toString();
    }

    public double getAverageAmount() {
        if (positions != null)
            return getOrderAmount()/positions.size();
        else return 0;
    }
}
