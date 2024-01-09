package com.gymnasthub.gymnasticsgainz;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ExerciseManager {
    private static Map<String, Exercise> exercisesByName = new HashMap<>();
    private static Map<String, List<Exercise>> exercisesByMuscleRegion = new HashMap<>();
    private static Map<String, List<Exercise>> exercisesByDirection = new HashMap<>();


    public Map<String, Exercise> getExercisesByName() { return exercisesByName;}
    public Map<String, List<Exercise>> getExercisesByMuscleRegion() { return exercisesByMuscleRegion;}
    public Map<String, List<Exercise>> getExercisesByDirection() { return exercisesByDirection;}


    // TODO Method to pull all exercises from csv
    public ExerciseManager(String fileName, String delimiter) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);

                this.addExercise( new Exercise(data[0], data[1], data[2], data[3], data[4], data[5],data[6]) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ExerciseManager(){
        String csvFile = "src\\main\\java\\com\\gymnasthub\\gymnasticsgainz\\Exercise_test_list.csv";
        String csvSplitBy = ",";
        new ExerciseManager(csvFile, csvSplitBy);
    }



    public void addExercise(Exercise exercise) {
        exercisesByName.put(exercise.getExerciseName(), exercise);

        // Update or create lists in exercisesByMuscleRegion
        exercisesByMuscleRegion.computeIfAbsent(exercise.getMuscleGroup(), k -> new ArrayList<>()).add(exercise);

        // Update or create lists in exercisesByDirection
        exercisesByDirection.computeIfAbsent(exercise.getExerciseDirection(), k -> new ArrayList<>()).add(exercise);
    }


    public static List<Exercise> getExercisesByName(String name) { //TODO eventually modify to search for presence instead of match
        return Optional.ofNullable(exercisesByName.get(name)).map(Collections::singletonList).orElse(Collections.emptyList());
    }
    public static List<Exercise> getExercisesByName(List<Exercise> exercises, String name) {

        return exercises.stream()
                .filter(exercise -> name.equalsIgnoreCase(exercise.getExerciseName()))
                .collect(Collectors.toList());
    }
    // Helper method to extract names from a list of exercises
    public static List<String> extractNames(List<Exercise> exercises) {
        return exercises.stream()
                .map(Exercise::getExerciseName)
                .collect(Collectors.toList());
    }


    public static List<Exercise> getExercisesByMuscleRegion(String muscleRegion) {
        return getExercisesByMuscleRegion(muscleRegion, 0);
    }
    public static List<Exercise> getExercisesByMuscleRegion(String muscleRegion, int number) {
        if (0 == number) {
            return exercisesByMuscleRegion.getOrDefault(muscleRegion, Collections.emptyList());
        }
        List<Exercise> nExercises = exercisesByMuscleRegion.getOrDefault(muscleRegion, Collections.emptyList());
        Collections.shuffle(nExercises);
        // Take the first n elements from the shuffled list
        return nExercises.subList(0, Math.min(number, nExercises.size()));
    }
    public static List<Exercise> getExercisesByMuscleRegion(String muscleRegion,List<Exercise> exercises) {
        return getExercisesByMuscleRegion(muscleRegion,0,exercises);
    }
    public static List<Exercise> getExercisesByMuscleRegion(String muscleRegion, int number,List<Exercise> exercises) {
        Collections.shuffle(exercises);
        if (0 == number) {
            return exercises.stream()
                    .filter(exercise -> muscleRegion.equalsIgnoreCase(exercise.getMuscleGroup()))
                    .collect(Collectors.toList());
        }
        return exercises.stream()
                .filter(exercise -> muscleRegion.equalsIgnoreCase(exercise.getMuscleGroup()))
                .limit(number)
                .collect(Collectors.toList());
    }





    public static List<Exercise> getExercisesByDirection(String direction) {
        return getExercisesByDirection(direction,0);
    }
    public static List<Exercise> getExercisesByDirection(String direction, int number) {
        if (0 == number) {
            return exercisesByDirection.getOrDefault(direction, Collections.emptyList());
        }
        List<Exercise> nExercises = exercisesByDirection.getOrDefault(direction, Collections.emptyList());
        Collections.shuffle(nExercises);
        // Take the first n elements from the shuffled list
        return nExercises.subList(0, Math.min(number, nExercises.size()));
    }
    public static List<Exercise> getExercisesByDirection(String direction,List<Exercise> exercises) {
        return getExercisesByDirection(direction, 0, exercises);
    }
    public static List<Exercise> getExercisesByDirection(String direction, int number, List<Exercise> exercises) {
        Collections.shuffle(exercises);
        if (0 == number) {
            return exercises.stream()
                    .filter(exercise -> direction.equalsIgnoreCase(exercise.getExerciseDirection()))
                    .collect(Collectors.toList());
        }
        return exercises.stream()
                .filter(exercise -> direction.equalsIgnoreCase(exercise.getExerciseDirection()))
                .limit(number)
                .collect(Collectors.toList());
    }

    //TODO add method to get exercise by body part
    //TODO add method to get exercise by equipment
    //TODO add method to get exercise by difficulty


    public static void displayAllExercisesInfo() {
        Set<Exercise> displayedExercises = new HashSet<>();

        System.out.println("Displaying information for all exercises:");

        // Iterate through exercisesByName map
        for (Exercise exercise : exercisesByName.values()) {
            exercise.displayInfo();
            System.out.println();
        }
    }

}