package com.ccs4202.project.ruralheroesproject;

import java.util.List;

public interface Solver {
    Solution solve(List<Item> items, int capacity);
}
