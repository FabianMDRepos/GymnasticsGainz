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
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GainsGui.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            // Set the scene and show the stage
            stage.setTitle("Gymnast Gainz Application"); // Set the title of the window
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

                CSVExercises.addExercise( new Exercise(data[0], data[1], data[2], data[3], data[4], data[5]) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVExercises.displayAllExercisesInfo();


        ExerciseManager gymnasticsExercises = new ExerciseManager();

        gymnasticsExercises.addExercise(new Exercise("Tire flip", "Lower Body", "Quadriceps", "Push", "Other", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Clean Deadlift", "Lower Body", "Hamstrings", "Pull", "Barbell", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Elbow plank", "Core", "Abdominals", "Static", "Body Only", "Beginner"));
        gymnasticsExercises.addExercise(new Exercise("Bottoms Up", "Core", "Abdominals", "Static", "Body Only", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Barbell back squat to box", "Lower Body", "Quadriceps", "Push", "Barbell", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Clean and jerk", "Upper Body", "Shoulders", "Push", "Barbell", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Single-arm kettlebell push-press", "Upper Body", "Shoulders", "Push", "Kettlebells", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Push-press", "Lower Body", "Quadriceps", "Push", "Barbell", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Suspended ab fall-out", "Core", "Abdominals", "Static", "Other", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Military press", "Upper Body", "Shoulders", "Push", "Barbell", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Power snatch", "Lower Body", "Quadriceps", "Push", "Barbell", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Sumo deadlift", "Lower Body", "Hamstrings", "Pull", "Barbell", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Hang Clean", "Lower Body", "Quadriceps", "Push", "Barbell", "Advanced"));
        gymnasticsExercises.addExercise(new Exercise("Dumbbell V-Sit Cross Jab", "Core", "Abdominals", "Push", "Dumbbell", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Reverse Band Box Squat", "Lower Body", "Quadriceps", "Push", "Bands", "Intermediate"));
        gymnasticsExercises.addExercise(new Exercise("Standing palms-in shoulder press", "Upper Body", "Shoulders", "Push", "Dumbbell", "Intermediate"));



        String search_parameter;
        // Example usage
        search_parameter = "Hang Clean";
        List<Exercise> searchByName = ExerciseManager.getExercisesByName(search_parameter);
        System.out.println("Search by Name: ("+ search_parameter + ") " + ExerciseManager.extractNames(searchByName));

        search_parameter = "Lower Body";
        List<Exercise> searchByMuscleRegion = ExerciseManager.getExercisesByMuscleRegion(search_parameter,3);
        System.out.println("Search by Muscle Region: ("+ search_parameter + ") " + ExerciseManager.extractNames(searchByMuscleRegion));

        search_parameter = "Pull";
        List<Exercise> searchByDirection = ExerciseManager.getExercisesByDirection(search_parameter,2);
        System.out.println("Search by Direction: ("+ search_parameter + ") " + ExerciseManager.extractNames(searchByDirection));

        search_parameter = "Push";
        searchByDirection = ExerciseManager.getExercisesByDirection(search_parameter,2);
        System.out.println("Search by Direction: ("+ search_parameter + ") " + ExerciseManager.extractNames(searchByDirection));

        search_parameter = "Lower-Push";
        System.out.println("Search by Muscle Region and Direction: ("+ search_parameter + ") " + ExerciseManager.extractNames(
                ExerciseManager.getExercisesByDirection("Push",searchByMuscleRegion)));


        System.out.println();
        //app.gymnastgainz.ExerciseManager.displayAllExercisesInfo();

        Workout TestWorkout = new Workout();
        TestWorkout.loadExercises();

        TestWorkout.generateWorkout("Build-up");
    }
}
