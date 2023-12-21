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
        StageController initialize_stage = new StageController(stage);
    }

    public static void main(String[] args) {
        launch();
        // Creating an ArrayList to store the exercise objects
        //ArrayList<app.gymnastgainz.Exercise> gymnasticsExercises = new ArrayList<>();

        ExerciseManager CSVExercises = new ExerciseManager();

        String csvFile = "src\\main\\java\\com\\gymnasthub\\gymnasticsgainz\\Exercise_test_list.csv"; // Replace with your CSV file's path
        String line;
        String csvSplitBy = ","; // Use the appropriate delimiter if different (e.g., "\t" for tab-separated)

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                CSVExercises.addExercise( new Exercise(data[0], data[1], data[2], data[3], data[4], data[5], data[6]) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVExercises.displayAllExercisesInfo();

    }
}
