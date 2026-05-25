package com.sumair.gradetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GradeTrackerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GradeTrackerApp.class.getResource("gradetracker-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 620);
        stage.setMinWidth(660);
        stage.setMinHeight(650);
        stage.setTitle("GRADE TRACKER");
        stage.setScene(scene);
        stage.show();
    }
}
