# Rural Heroes Project

**CCS4202 - Design and Analysis of Algorithms — Group Project**

An online portfolio documenting the design, analysis, and implementation of a 0/1 Knapsack
solution for a simulated disaster relief scenario in Kapit, Sarawak.

🔗 **Live site:** https://yadwajd.github.io/rural-heroes-project/

---

## About the Project

A landslide has cut off a rural village in Kapit, Sarawak, and the Malaysian Relief Agency (MRA)
can send only a single supply truck with a 200 kg capacity. With more candidate supply items than
the truck can carry, the relief team must choose the combination of items that delivers the
greatest benefit to the village — a classic **0/1 Knapsack Problem**.

This repository contains the full project report, presented as an interactive single-page website
rather than a static document, alongside the Java/JavaFX application that implements and compares
three algorithms for solving the problem: **Brute Force**, **Greedy**, and **Dynamic Programming**.

## Portfolio Sections

The sidebar navigates between the following report sections, all rendered on a single page
(`index.html`) without reloading.

### Home
Project header (course code, logo, group name), followed by profile cards for each group member
with their name, photo, and role.

### Problem Definition
Sets up the scenario: a landslide has cut off a village in Kapit, Sarawak, leaving it short on
food, water, baby products, and medicine. The Malaysian Relief Agency (MRA) can send only one
truck, capped at 200 kg, and must choose which supply items to load for maximum benefit. This
section explains why the situation is modelled as a **0/1 Knapsack Problem** — items cannot be
split, so simple ratio-based selection can fall short of the best possible outcome — and includes
a map illustrating the village's location and the blocked road.

### Model Development
Formalises the scenario into a mathematical model: the variables (`n`, `W`, `items[i]`, `dp[i][c]`,
`selected[]`), the objective function (maximise total benefit subject to the 200 kg capacity), and
the modelling assumptions (e.g. items are indivisible, only one truck/trip, weight is the only
constraint considered). Includes an input-process-output diagram and the full 20-item dataset with
each item's weight and benefit score.

### Algorithm Specification
Reviews six candidate approaches — Sorting, Divide and Conquer, Greedy, Dynamic Programming, Graph
Algorithms, and Brute Force — assessing each for suitability against the 0/1 Knapsack problem.
Concludes with a justification for choosing **Dynamic Programming**, including why the problem is
NP-hard in general but solvable here in practical pseudo-polynomial time, O(n × W).

### Algorithm Design
Provides the recurrence relation for the Dynamic Programming solution, full pseudocode for all
three implemented algorithms (Dynamic Programming, Greedy, and Brute Force), the backtracking
method used to recover which items were selected, and a flowchart illustrating the DP algorithm's
overall logic.

### Algorithm Correctness
Proves that the Dynamic Programming algorithm always produces the true optimal solution. Covers
the recurrence's bounded, terminating behaviour; a proof of optimal substructure using a
cut-and-paste argument; a full proof by mathematical induction; and empirical verification by
comparing DP's output against Brute Force's exhaustive search on the same dataset.

### Implementation & Demonstration
Documents the JavaFX desktop application that implements all three algorithms, including its file
structure, key classes and methods, and how a run flows from button click to displayed result.
Walks through the application step by step with screenshots — loading the dataset, entering truck
capacity, and running Brute Force, Greedy, and Dynamic Programming — followed by a results summary
comparing all three outputs side by side.

### Algorithm Analysis
Breaks down the time and space complexity of each algorithm, including best/average/worst case
analysis, then compares these theoretical expectations against the actual benefit scores and
runtimes captured in the Demonstration section.

### Conclusion
Summarises the project's findings: Dynamic Programming matched Brute Force's optimal result while
running far faster, and outperformed Greedy's sub-optimal solution — confirming it as the most
practical algorithm for this scenario.

### References
Lists all sources cited throughout the report, referenced inline as numbered superscript links
(e.g. `[1]`) that jump directly to the corresponding entry.

## Repository Structure

```
.
├── index.html              # Main report — all sections live here
├── css/
│   └── styles.css          # Bootstrap 5 + custom styling
├── js/
│   └── scripts.js          # Sidebar toggle + section switching logic
├── assets/                 # Images: logo, member photos, diagrams, screenshots
└── README.md
```

> This site is built on the [Simple Sidebar](https://startbootstrap.com/template/simple-sidebar)
> template by Start Bootstrap, customised for this report.

## Viewing the Portfolio Locally

No build step or server is required — it's a static site.

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/<repo-name>.git
   cd <repo-name>
   ```
2. Open `index.html` directly in a browser, **or** serve it locally:
   ```bash
   python3 -m http.server 8080
   ```
   then visit `http://localhost:8080`.

## The Knapsack Application

The accompanying desktop application (source included separately / linked below) implements all
three algorithms discussed in the report:

- **Language:** Java (JavaFX)
- **Entry point:** `MainApp.java`
- **Interface layout:** `MainView.fxml`
- **Dataset:** `items.csv`

See the **Implementation & Demonstration** and **Algorithm Design** sections of the portfolio for
full pseudocode, class breakdowns, and compile/run instructions.

## Group Members

See the **Home** page of the portfolio for member names, roles, and photos.

## Course Information

- **Course:** CCS4202 - Design and Analysis of Algorithms
- **Project type:** Group Project
- **Lecturer:** [Lecturer's Name]

## License

This project is built on the Simple Sidebar template, which is licensed under the
[MIT License](https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE).
Report content and application source code are the original work of the group members listed above.
