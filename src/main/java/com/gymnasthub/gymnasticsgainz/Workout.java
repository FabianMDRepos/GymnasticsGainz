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

    public Workout() { //TODO add logic so creating a workout object auto generates the workout exercises.

    }

    // TODO Generate workouts if empty
    public List<Exercise> getGeneratedExercises() {
        return generated_exercises;
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
        //displayWorkout(workoutExercises);
    }

    public void generateRepetitions(Exercise e) {
        int reps;
        boolean is_timed = (e.getExerciseDirection().equals("Timed"));

        reps = switch (e.getExerciseEquipment()) {
            case "Barbell" -> calculateIntermediateReps(5, 10, e.getExerciseDifficulty());
            case "Dumbbell" -> is_timed ? calculateIntermediateReps(5, 10, e.getExerciseDifficulty()) : calculateIntermediateReps(10, 15, e.getExerciseDifficulty());
            case "Cable" -> calculateIntermediateReps(10, 15, e.getExerciseDifficulty());
            case "Bodyweight" -> is_timed ? calculateIntermediateReps(30, 60, e.getExerciseDifficulty()) : calculateIntermediateReps(10, 20, e.getExerciseDifficulty());
            case "Banded" -> calculateIntermediateReps(15, 20, e.getExerciseDifficulty());
            default -> calculateIntermediateReps(10, 20, e.getExerciseDifficulty());
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


    public void generateSets(Exercise e, String inputString) {
        String workoutDifficulty = inputString.substring(inputString.indexOf('-') + 1);
        int sets = switch (workoutDifficulty) {
            case "Build-up" -> 3;
            case "Peak" -> 4;
            case "Maintain" -> 2;
            case "Deload" -> 1;
            default -> 0;
        };

        // TODO make sure this is always at least 1
        if (e.getExerciseDifficulty().equals("Beginner")) {
            sets += 1;
        } else if (e.getExerciseDifficulty().equals("Advanced")) {
            sets = (sets > 1) ? (sets - 1) : 1;
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

}
