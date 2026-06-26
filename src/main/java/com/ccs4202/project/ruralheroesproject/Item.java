package com.ccs4202.project.ruralheroesproject;

public class Item {
    private final String name;
    private final int weight;
    private final int benefit;

    public Item(String name, int weight, int benefit){
        this.name = name;
        this.weight = weight;
        this.benefit = benefit;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getBenefit() {
        return benefit;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", benefit=" + benefit +
                '}';
    }
}
