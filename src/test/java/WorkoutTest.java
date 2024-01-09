import static org.junit.jupiter.api.Assertions.*;

import com.gymnasthub.gymnasticsgainz.ExerciseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import com.gymnasthub.gymnasticsgainz.Workout;
import com.gymnasthub.gymnasticsgainz.Exercise;
public class WorkoutTest {

    private Workout workout;

    @BeforeEach
    public void setUp() {
        workout = new Workout();
    }


    @Test
    public void testGenerateRepetitions() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        workout.generateRepetitions(exercise);
        int repetitions = exercise.getRepetitions();
        assertTrue(repetitions >= 5 && repetitions <= 10);
    }

    @Test
    public void testGenerateSets() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        workout.generateSets(exercise, "3-Build-up");
        int sets = exercise.getSets();
        assertEquals(3, sets);

        workout.generateSets(exercise, "4-Peak");
        sets = exercise.getSets();
        assertEquals(4, sets);

        workout.generateSets(exercise, "2-Maintain");
        sets = exercise.getSets();
        assertEquals(2, sets);

        workout.generateSets(exercise, "1-Deload");
        sets = exercise.getSets();
        assertEquals(1, sets);

        workout.generateSets(exercise, "5-Invalid"); // Invalid input, should default to 0
        sets = exercise.getSets();
        assertEquals(0, sets);

        exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Beginner", "Test Description");

        //exercise.setExerciseDifficulty("Beginner");
        workout.generateSets(exercise, "3-Build-up");
        sets = exercise.getSets();
        assertEquals(4, sets); // Beginners add 1

        exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Advanced", "Test Description");

        //exercise.setExerciseDifficulty("Advanced");
        workout.generateSets(exercise, "3-Build-up");
        sets = exercise.getSets();
        assertEquals(2, sets); // Advanced subtracts 1

        workout.generateSets(exercise, "1-Deload");
        sets = exercise.getSets();
        assertEquals(1, sets); // Minimum of 1
    }

    @Test
    public void testGenerateWorkout() {
        ExerciseManager exercise_manager = new ExerciseManager();
        workout.generateWorkout("Build-up");
        List<Exercise> generatedExercises = workout.getGeneratedExercises();
        assertNotNull(generatedExercises);
        assertFalse(generatedExercises.isEmpty());
    }
}
