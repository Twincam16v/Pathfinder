package com.company;

import static java.lang.Math.abs;

public class Location {

    private int x;
    private int y;
    private String value;
    private int cost;
    private int heuristic;
    private int totalCost;


    public Location(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
        heuristic = 100;
        cost = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void calculateHeuristic(int end_x, int end_y)
    {
        heuristic = abs(end_x - x) + abs(end_y - y);
    }

    public void updateCost()
    {
        cost++;
    }

}
