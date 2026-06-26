package com.ccs4202.project.ruralheroesproject;

import java.util.ArrayList;
import java.util.List;

public class BruteForce implements Solver{

    @Override
    public Solution solve(List<Item> items, int capacity) {
        return bruteForceRecursive(items, items.size(), capacity);
    }

    private Solution bruteForceRecursive(List<Item> items, int i, int remainingCapacity) {
        if (i == 0 || remainingCapacity == 0) {
            return new Solution(new ArrayList<>(), 0, 0);
        }

        Item currentItem = items.get(i - 1);

        // Option 1: skip current item
        Solution without = bruteForceRecursive(items, i - 1, remainingCapacity);

        // Option 2: take current item, if it fits
        Solution with = null;
        if (currentItem.getWeight() <= remainingCapacity) {
            Solution sub = bruteForceRecursive(items, i - 1, remainingCapacity - currentItem.getWeight());

            List<Item> newChosen = new ArrayList<>(sub.getChosenItems());
            newChosen.add(currentItem);

            int newWeight = sub.getTotalWeight() + currentItem.getWeight();
            int newBenefit = sub.getTotalBenefit() + currentItem.getBenefit();

            with = new Solution(newChosen, newWeight, newBenefit);
        }

        if (with != null && with.getTotalBenefit() > without.getTotalBenefit()) {
            return with;
        } else {
            return without;
        }
    }
}
