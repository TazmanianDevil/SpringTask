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

    public Double getOrderAmount() {
        double total = 0;
        if (positions != null) {
            for (Position p: positions) {
                if (p.getPositionAmount() == null)
                    return null;
                total += p.getPositionAmount();
            }
        }
        return total;
    }

    public String toString() {
        return id.toString();
    }

    public Double getAverageAmount() {
        if (positions != null) {
            if (getOrderAmount() == null)
                return null;
            return getOrderAmount() / positions.size();
        }
        else return null;
    }
}
