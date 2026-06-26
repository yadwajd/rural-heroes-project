package com.ccs4202.project.ruralheroesproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ccs4202/project/ruralheroesproject/MainView.fxml"));
        Parent root = loader.load();

        stage.setTitle("Rural Area Supplies Optimization System");
        stage.setScene(new Scene(root, 560, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}