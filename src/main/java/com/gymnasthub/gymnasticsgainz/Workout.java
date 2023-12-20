package com.gymnasthub.gymnasticsgainz;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Workout {

    // When generating a workout, based on the difficulty of training generate sets, reps, and exercise
    // Generated during a workout ////////////////
    private int repetitions;
    private int sets;
    private String difficulty;
    private ExerciseManager exercise_manager = new ExerciseManager();
    private List<Exercise> generated_exercises;

    //private int volume =  sum( app.gymnastgainz.Exercise: sets * repetitions * (some difficulty scale)); Have a string value for this as well for display
    /////////////////////////////////////////////////

    private static String[] MuscleRegions = {"Upper Body", "Lower Body", "Core"};
    private static String[] DirectionOfExercise = {"Push", "Pull", "Static", "Multi"};
    private static String[] WorkoutDifficulties = {"Build-up", "Deload", "Maintain", "Peak"};

    public Workout() {}

    public List<Exercise> getGeneratedExercises() {
        return generated_exercises;
    }

    public void loadExercises() {
        String csvFile = "src\\main\\java\\com\\gymnasthub\\gymnasticsgainz\\Exercise_test_list.csv"; // Replace with your CSV file's path
        String line;
        String csvSplitBy = ","; // Use the appropriate delimiter if different (e.g., "\t" for tab-separated)

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                exercise_manager.addExercise(new Exercise(data[0], data[1], data[2], data[3], data[4], data[5],data[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateWorkout(String workout_difficulty) { // TODO Prevent duplicates.
        List<Exercise> workoutExercises = new ArrayList<>();
        // Get upper body exercises
        List<Exercise> upperBody = exercise_manager.getExercisesByMuscleRegion("Upper Body");
            // Get 2 push
            workoutExercises.addAll(exercise_manager.getExercisesByDirection("Push", 2, upperBody));
            // Get 2 pull
            workoutExercises.addAll(exercise_manager.getExercisesByDirection("pull", 2, upperBody));
        // Get lower body exercises
        List<Exercise> lowerBody = exercise_manager.getExercisesByMuscleRegion("Lower Body");
            // Get 1 push
            workoutExercises.addAll(exercise_manager.getExercisesByDirection("Push", 1, lowerBody));
            // Get 1 pull
            workoutExercises.addAll(exercise_manager.getExercisesByDirection("Pull", 1, lowerBody));

        // Get 3 core exercises
        workoutExercises.addAll(exercise_manager.getExercisesByMuscleRegion("Core", 3));

        for (Exercise exercise : workoutExercises) {
            generateRepetitions(exercise);
            generateSets(exercise, workout_difficulty);
        }

        generated_exercises = workoutExercises;
        // Display workout
        displayWorkout(workoutExercises);
    }

    public void generateRepetitions(Exercise e) {
        int reps;
        boolean is_timed = (e.getExerciseDirection().equals("Timed"));

        reps = switch (e.getEquipment()) {
            case "Barbell" -> calculateIntermediateReps(5, 10, e.getDifficulty());
            case "Dumbbell" -> is_timed ? calculateIntermediateReps(5, 10, e.getDifficulty()) : calculateIntermediateReps(10, 15, e.getDifficulty());
            case "Cable" -> calculateIntermediateReps(10, 15, e.getDifficulty());
            case "Bodyweight" -> is_timed ? calculateIntermediateReps(30, 60, e.getDifficulty()) : calculateIntermediateReps(10, 20, e.getDifficulty());
            case "Banded" -> calculateIntermediateReps(15, 20, e.getDifficulty());
            default -> calculateIntermediateReps(10, 20, e.getDifficulty());
        };

        e.setRepetitions(reps);
    }
    private static int calculateIntermediateReps(int min, int max, String exerciseDifficulty) {
        if (exerciseDifficulty.equals("Intermediate")) {
            return (int) Math.round((min + max) / 2.0);
        } else if (exerciseDifficulty.equals("Beginner")) {
            return max;
        } else {
            return min;
        }
    }


    public void generateSets(Exercise e, String workoutDifficulty) {
        int sets = switch (workoutDifficulty) {
            case "Build-up" -> 3;
            case "Peak" -> 4;
            case "Maintain" -> 2;
            case "Deload" -> 1;
            default -> 0;
        };

        // TODO make sure this is always at least 1
        if (e.getDifficulty().equals("Beginner")) {
            sets += 1;
        } else if (e.getDifficulty().equals("Advanced")) {
            sets -= 1;
        }
        e.setSets(sets);
    }

    public void displayWorkout(List<Exercise> workout) {
        System.out.println("New Workout:");
        for (int i = 0; i < workout.size(); i++) {
            System.out.print((i+1) + ".) ");
            workout.get(i).displayInLine();
        }
    }

    //public List<String>

}
