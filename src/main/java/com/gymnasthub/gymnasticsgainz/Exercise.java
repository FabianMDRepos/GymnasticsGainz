package com.gymnasthub.gymnasticsgainz;

import java.util.ArrayList;
public class Exercise {


    // Set by constructor /////////////////////
    public Exercise(String name, String group, String part, String direction,String equipment,
                    String difficulty, String description) {
        exercise_name = name;
        muscle_group = group;
        body_part = part;
        exercise_direction = direction;
        exercise_equipment = equipment;
        exercise_difficulty = difficulty;
        exercise_description = description;
    }
    private final String exercise_name;
    private final String muscle_group;
    private final String body_part;
    private final String exercise_direction;
    private final String exercise_equipment;
    private final String exercise_difficulty;
    private final String exercise_description;
    ////////////////////////////////////////////


    //// Set at runtime ///////////////////////
    private int repetitions;
    private int sets;
    /////////////////////////////////////////


    // Setting Methods  //////////////////////////////
    public void setRepetitions(int rep_value) { repetitions = rep_value; }
    public void setSets(int set_value) { sets = set_value; }
    //////////////////////////////////////////////////


    // Getting Methods  //////////////////////////////
    public String getExerciseName() { return exercise_name; }
    public String getMuscleGroup() {return muscle_group;}
    public String getBodyPart() {return body_part;}
    public String getExerciseDirection() {return exercise_direction;}

    public String getEquipment() { return exercise_equipment; }
    public String getDifficulty() { return exercise_difficulty; }


    public String getExerciseEquipment() { return exercise_equipment; }
    public String getExerciseDifficulty() { return exercise_difficulty; }
    public String getExerciseDescription() { return exercise_description; }


    public int getRepetitions() { return repetitions; }
    public int getSets() { return sets; }
    ///////////////////////////////////////////////////


    // Method to display all non-static variables
    public void displayInfo() {
        System.out.println("Name: " + exercise_name);
        System.out.println("Muscle Group: " + muscle_group);
        System.out.println("Body Part: " + body_part);
        System.out.println("Direction: " + exercise_direction);
        System.out.println("Equipment: " + exercise_equipment);
        System.out.println("Difficulty: " + exercise_difficulty);
    }
    public void displayInLine() {
        System.out.println(sets + "x" + repetitions + " - " +exercise_name + ": " + muscle_group + " - " + body_part + " - " + exercise_direction
                + " - " +exercise_equipment + " - " + exercise_difficulty);
    }

    public String displayDescription() {
        return exercise_name + ":\n" + exercise_description;
        //System.out.println(exercise_description);
    }
}
