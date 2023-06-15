package com.example.test00_vendingmachine;

public class MainDTO {
    private String name;
    private int cost, cnt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public MainDTO(String name, int cost, int cnt) {
        this.name = name;
        this.cost = cost;
        this.cnt = cnt;
    }

    public MainDTO(int cnt) {
        this.cnt = cnt;
    }
}
