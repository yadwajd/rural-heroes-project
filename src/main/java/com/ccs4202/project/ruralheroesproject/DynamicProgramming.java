package com.ccs4202.project.ruralheroesproject;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming implements Solver{

    @Override
    public Solution solve(List<Item> items, int capacity) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table
        for (int i = 1; i <= n; i++) {
            Item currentItem = items.get(i - 1);
            for (int w = 0; w <= capacity; w++) {
                if (currentItem.getWeight() > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    int withoutItem = dp[i - 1][w];
                    int withItem = currentItem.getBenefit() + dp[i - 1][w - currentItem.getWeight()];
                    dp[i][w] = Math.max(withoutItem, withItem);
                }
            }
        }

        // Backtrack to find chosen items
        List<Item> chosenItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i >= 1; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item currentItem = items.get(i - 1);
                chosenItems.add(currentItem);
                w -= currentItem.getWeight();
            }
        }

        int totalWeight = 0;
        for (Item item : chosenItems) {
            totalWeight += item.getWeight();
        }
        int totalBenefit = dp[n][capacity];

        return new Solution(chosenItems, totalWeight, totalBenefit);
    }
}
