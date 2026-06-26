package com.ccs4202.project.ruralheroesproject;

import java.util.List;

public class Solution {
    private final List<Item> chosenItems;
    private final int totalWeight;
    private final int totalBenefit;

    public Solution(List<Item> chosenItems, int totalWeight, int totalBenefit) {
        this.chosenItems = chosenItems;
        this.totalWeight = totalWeight;
        this.totalBenefit = totalBenefit;
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public List<Item> getChosenItems() {
        return chosenItems;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "chosenItems=" + chosenItems +
                ", totalWeight=" + totalWeight +
                ", totalBenefit=" + totalBenefit +
                '}';
    }
}
