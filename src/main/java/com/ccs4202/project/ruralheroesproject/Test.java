package com.ccs4202.project.ruralheroesproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        String csvFilePath = "items.csv"; // adjust path as needed
        int capacity = 200;

        List<Item> items = loadItemsFromCsv(csvFilePath);

        if (items.isEmpty()) {
            System.out.println("No items loaded - check your CSV file path/format.");
            return;
        }

        System.out.println("Loaded " + items.size() + " items from " + csvFilePath);
        System.out.println();

        System.out.println("===== Correctness Check =====");
        runAndPrint("Brute Force", new BruteForce(), items, capacity);
        runAndPrint("Greedy", new Greedy(), items, capacity);
        runAndPrint("Dynamic Programming", new DynamicProgramming(), items, capacity);

        System.out.println();
        verifySolutions(items, capacity);

        System.out.println();
        System.out.println("===== Timing Benchmark (with JVM warmup) =====");
        benchmark("Brute Force", new BruteForce(), items, capacity);
        benchmark("Greedy", new Greedy(), items, capacity);
        benchmark("Dynamic Programming", new DynamicProgramming(), items, capacity);
    }

    /**
     * Loads items from a CSV file with format: item,weight,benefit
     * Assumes the first line is a header row and skips it.
     */
    private static List<Item> loadItemsFromCsv(String filePath) {
        List<Item> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // skip header row

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String name = parts[0].trim();
                int weight = Integer.parseInt(parts[1].trim());
                int benefit = Integer.parseInt(parts[2].trim());

                items.add(new Item(name, weight, benefit));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing weight/benefit as integers: " + e.getMessage());
        }

        return items;
    }

    private static void runAndPrint(String label, Solver solver, List<Item> items, int capacity) {
        Solution solution = solver.solve(items, capacity);
        System.out.println(label + " -> " + solution);
    }

    private static void verifySolutions(List<Item> items, int capacity) {
        Solution greedy = new Greedy().solve(items, capacity);
        Solution dp = new DynamicProgramming().solve(items, capacity);
        Solution bruteForce = new BruteForce().solve(items, capacity);

        System.out.println("===== Sanity Checks =====");

        if (dp.getTotalBenefit() == bruteForce.getTotalBenefit()) {
            System.out.println("PASS: DP matches Brute Force optimal benefit (" + dp.getTotalBenefit() + ")");
        } else {
            System.out.println("FAIL: DP (" + dp.getTotalBenefit() + ") != Brute Force ("
                    + bruteForce.getTotalBenefit() + ")");
        }

        if (greedy.getTotalBenefit() < dp.getTotalBenefit()) {
            System.out.println("CONFIRMED: Greedy (" + greedy.getTotalBenefit()
                    + ") is suboptimal compared to DP/Brute Force (" + dp.getTotalBenefit() + ")");
        } else if (greedy.getTotalBenefit() == dp.getTotalBenefit()) {
            System.out.println("NOTE: Greedy matched the optimal in this run (" + greedy.getTotalBenefit() + ")");
        }

        for (Solution s : List.of(greedy, dp, bruteForce)) {
            if (s.getTotalWeight() > capacity) {
                System.out.println("FAIL: A solution exceeded capacity! Weight=" + s.getTotalWeight());
            }
        }
    }

    private static void benchmark(String label, Solver solver, List<Item> items, int capacity) {
        // Warmup: 10 untimed iterations to let the JVM JIT-compile hot paths
        for (int i = 0; i < 10; i++) {
            solver.solve(items, capacity);
        }

        // Timed run (11th call)
        long start = System.nanoTime();
        Solution result = solver.solve(items, capacity);
        long elapsed = System.nanoTime() - start;

        System.out.println(label + ": " + elapsed + " ns | benefit=" + result.getTotalBenefit()
                + ", weight=" + result.getTotalWeight());
    }
}