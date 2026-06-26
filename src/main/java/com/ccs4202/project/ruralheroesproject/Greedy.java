package com.ccs4202.project.ruralheroesproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Greedy implements Solver{

    @Override
    public Solution solve(List<Item> items, int capacity) {
        List<Item> sortedItems = new ArrayList<>(items);
        sortedItems.sort(Comparator.comparingDouble(
                (Item item) -> (double) item.getBenefit() / item.getWeight()
        ).reversed());

        List<Item> chosenItems = new ArrayList<>();
        int totalWeight = 0;
        int totalBenefit = 0;
        int remainingCapacity = capacity;

        for (Item item : sortedItems) {
            if (item.getWeight() <= remainingCapacity) {
                chosenItems.add(item);
                totalWeight += item.getWeight();
                totalBenefit += item.getBenefit();
                remainingCapacity -= item.getWeight();
            }
        }

        return new Solution(chosenItems, totalWeight, totalBenefit);
    }
}
