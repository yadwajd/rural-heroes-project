# Rural Heroes Project

**CCS4202 - Design and Analysis of Algorithms — Group Project**

An online portfolio documenting the design, analysis, and implementation of a 0/1 Knapsack
solution for a simulated disaster relief scenario in Kapit, Sarawak.

🔗 **Live site:** add your GitHub Pages link here once deployed
(e.g. `https://<your-username>.github.io/<repo-name>/`)

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
(`index.html`) without reloading:

| Section | Contents |
|---|---|
| Home | Project title, logo, and group member profiles |
| Problem Definition | The disaster relief scenario and why it is modelled as a 0/1 Knapsack problem |
| Model Development | Variables, objective function, constraints, assumptions, and the full dataset |
| Algorithm Specification | Review of candidate algorithms and justification for choosing Dynamic Programming |
| Algorithm Design | Recurrence relation, pseudocode, backtracking, and flowchart for all three algorithms |
| Algorithm Correctness | Proof of optimal substructure, proof by induction, and empirical verification |
| Implementation & Demonstration | Application structure, key classes, and a walkthrough of the working program |
| Algorithm Analysis | Time/space complexity, best/worst/average case, and theoretical vs. empirical results |
| Conclusion | Summary of findings and final recommendation |
| References | Sources cited throughout the report |

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
