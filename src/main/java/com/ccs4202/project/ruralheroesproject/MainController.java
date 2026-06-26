package com.ccs4202.project.ruralheroesproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String CSV_FILE_PATH = "items.csv";

    @FXML private TextField capacityField;
    @FXML private TextField nameField;
    @FXML private TextField weightField;
    @FXML private TextField benefitField;
    @FXML private Label csvStatusLabel;

    @FXML private ListView<Item> itemsListView;
    @FXML private ListView<String> outputListView;

    @FXML private Label totalWeightLabel;
    @FXML private Label maxBenefitLabel;
    @FXML private Label timeTakenLabel;

    private final ObservableList<Item> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsListView.setItems(items);
        itemsListView.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName() + "  |  weight: " + item.getWeight()
                            + "  |  benefit: " + item.getBenefit());
                }
            }
        });

        loadFromCsvIfPresent();
    }

    private void loadFromCsvIfPresent() {
        File csvFile = new File(CSV_FILE_PATH);

        if (!csvFile.exists()) {
            csvStatusLabel.setText("No items.csv found - add items manually below.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line = reader.readLine(); // skip header row
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    continue;
                }
                String name = parts[0].trim();
                int weight = Integer.parseInt(parts[1].trim());
                int benefit = Integer.parseInt(parts[2].trim());
                items.add(new Item(name, weight, benefit));
                count++;
            }

            csvStatusLabel.setText("Loaded " + count + " items from items.csv");
        } catch (IOException | NumberFormatException e) {
            csvStatusLabel.setText("Could not read items.csv (" + e.getMessage() + ") - add items manually.");
        }
    }

    @FXML
    private void handleAddItem() {
        String name = nameField.getText().trim();
        String weightText = weightField.getText().trim();
        String benefitText = benefitField.getText().trim();

        if (name.isEmpty() || weightText.isEmpty() || benefitText.isEmpty()) {
            showAlert("Please fill in Name, Weight, and Benefit before adding an item.");
            return;
        }

        try {
            int weight = Integer.parseInt(weightText);
            int benefit = Integer.parseInt(benefitText);

            if (weight <= 0 || benefit <= 0) {
                showAlert("Weight and Benefit must be positive numbers.");
                return;
            }

            items.add(new Item(name, weight, benefit));

            nameField.clear();
            weightField.clear();
            benefitField.clear();

        } catch (NumberFormatException e) {
            showAlert("Weight and Benefit must be valid whole numbers.");
        }
    }

    @FXML
    private void handleBruteForce() {
        runSolver(new BruteForce(), "Brute Force");
    }

    @FXML
    private void handleGreedy() {
        runSolver(new Greedy(), "Greedy");
    }

    @FXML
    private void handleDynamicProgramming() {
        runSolver(new DynamicProgramming(), "Dynamic Programming");
    }

    private void runSolver(Solver solver, String label) {
        if (items.isEmpty()) {
            showAlert("Add at least one item before running optimization.");
            return;
        }

        int capacity;
        try {
            capacity = Integer.parseInt(capacityField.getText().trim());
            if (capacity <= 0) {
                showAlert("Truck capacity must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid truck capacity (kg).");
            return;
        }

        long start = System.nanoTime();
        Solution solution = solver.solve(items, capacity);
        long elapsedNanos = System.nanoTime() - start;
        double elapsedMillis = elapsedNanos / 1_000_000.0;

        displayResult(solution, label, elapsedMillis);
    }

    private void displayResult(Solution solution, String label, double elapsedMillis) {
        outputListView.getItems().clear();
        for (Item item : solution.getChosenItems()) {
            outputListView.getItems().add(item.getName() + "  (weight: " + item.getWeight()
                    + ", benefit: " + item.getBenefit() + ")");
        }

        totalWeightLabel.setText("Total weight used: " + solution.getTotalWeight());
        maxBenefitLabel.setText("Maximum benefit: " + solution.getTotalBenefit());
        timeTakenLabel.setText("Time taken (" + label + "): " + String.format("%.3f", elapsedMillis) + " ms");
    }

    @FXML
    private void handleResetSolution() {
        outputListView.getItems().clear();
        totalWeightLabel.setText("Total weight used: -");
        maxBenefitLabel.setText("Maximum benefit: -");
        timeTakenLabel.setText("Time taken: -");
    }

    @FXML
    private void handleResetAll() {
        handleResetSolution();
        items.clear();
        capacityField.clear();
        nameField.clear();
        weightField.clear();
        benefitField.clear();
        csvStatusLabel.setText("");
        loadFromCsvIfPresent();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
