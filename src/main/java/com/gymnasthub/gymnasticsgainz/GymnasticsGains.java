package com.gymnasthub.gymnasticsgainz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;



public class GymnasticsGains extends Application{

    @Override
    public void start(Stage stage) {
        String csvFile = "src\\main\\java\\com\\gymnasthub\\gymnasticsgainz\\Exercise_test_list.csv";
        String csvSplitBy = ",";
        ExerciseManager exercise_manager = new ExerciseManager(csvFile, csvSplitBy);
        StageController initialize_stage = new StageController(stage);
    }

    public static void main(String[] args) {
        launch();

    }
}
