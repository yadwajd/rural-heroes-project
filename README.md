Rural Heroes — CCS4202 Group Project

Course: CCS4202 – Design and Analysis of Algorithms
Lecturer: Assoc. Prof. Dr. Razali bin Yaakob
Semester: Second Semester, 2025/2026


Group Members / Role
- Muhammad Hairie bin Hazlee / Project Leader, Problem Analyst
- Ariz Amirudin bin Mohammad Tony / Algorithm Designer & Developer
- Muhammad Adam Mustaffa bin Ali / Algorithm Designer & Developer
- Iyad Wajdi bin Mohd Azidan / Analysis & Portfolio Lead


Project Overview

This project models a humanitarian relief scenario in Kapit, Sarawak, where a rural village has been cut off from nearby towns due to a landslide blocking the only road. A single supply truck with a 200 kg capacity must be loaded with the combination of relief supplies that delivers the greatest possible benefit to the affected villagers.

The problem is formally modelled as a 0/1 Knapsack Problem and solved using Dynamic Programming, with Greedy and Brute Force also implemented for comparison and correctness verification.


Program

Language: Java (JavaFX)

File Structure

├── MainApp.java            # Entry point
├── MainController.java     # UI logic and algorithm dispatch
├── MainView.fxml           # JavaFX interface layout
├── Item.java               # Data model: name, weight, benefit score
├── Solution.java           # Data model: selected items, total weight, total benefit
├── Solver.java             # Shared interface for all three algorithms
├── DynamicProgramming.java # DP knapsack solver
├── Greedy.java             # Greedy knapsack solver
├── BruteForce.java         # Brute force knapsack solver
└── items.csv               # Dataset of 20 candidate supply items

How to Run


Ensure you have a JDK and JavaFX installed.
Compile:


bash   javac --module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml *.java


Run:


bash   java --module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml MainApp

items.csv - place in the same directory as the compiled .class files

On launch, items.csv is loaded automatically. Enter a truck capacity (e.g. 200), then click Brute Force, Greedy, or Dynamic Programming to run the selected algorithm and view the results.



Portfolio

The full project portfolio (problem definition, model development, algorithm specification, pseudocode, correctness proof, implementation demo, and analysis) is available at:


[(https://yadwajd.github.io/rural-heroes-project/)]
