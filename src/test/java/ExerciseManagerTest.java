import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import com.gymnasthub.gymnasticsgainz.ExerciseManager;
import com.gymnasthub.gymnasticsgainz.Exercise;

public class ExerciseManagerTest {

    private ExerciseManager exerciseManager;

    @BeforeEach
    public void setUp() {
        exerciseManager = new ExerciseManager("src\\main\\java\\com\\gymnasthub\\gymnasticsgainz\\Exercise_test_list.csv", ",");
    }

    @Test
    public void testAddExercise() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        exerciseManager.addExercise(exercise);

        Map<String, Exercise> exercisesByName = exerciseManager.getExercisesByName();
        assertNotNull(exercisesByName.get("TestExercise"));

        List<Exercise> exercisesByMuscleRegion = exerciseManager.getExercisesByMuscleRegion("Upper Body");
        assertTrue(exercisesByMuscleRegion.contains(exercise));

        List<Exercise> exercisesByDirection = exerciseManager.getExercisesByDirection("Push");
        assertTrue(exercisesByDirection.contains(exercise));
    }

    @Test
    public void testGetExercisesByName() {
        List<Exercise> exercises = ExerciseManager.getExercisesByName("TestExercise");
        assertTrue(exercises.isEmpty());

        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        exerciseManager.addExercise(exercise);

        exercises = ExerciseManager.getExercisesByName("TestExercise");
        assertEquals(1, exercises.size());
        assertEquals("TestExercise", exercises.get(0).getExerciseName());
    }

    @Test
    public void testGetExercisesByMuscleRegion() {
        List<Exercise> exercises = exerciseManager.getExercisesByMuscleRegion("Upper Body");
        assertFalse(exercises.isEmpty());

        exercises = exerciseManager.getExercisesByMuscleRegion("NonExistentRegion");
        assertTrue(exercises.isEmpty());

        exercises = exerciseManager.getExercisesByMuscleRegion("Upper Body", 2);
        assertEquals(2, exercises.size());
    }

    @Test
    public void testGetExercisesByDirection() {
        List<Exercise> exercises = exerciseManager.getExercisesByDirection("Push");
        assertFalse(exercises.isEmpty());

        exercises = exerciseManager.getExercisesByDirection("NonExistentDirection");
        assertTrue(exercises.isEmpty());

        exercises = exerciseManager.getExercisesByDirection("Push", 2);
        assertEquals(2, exercises.size());
    }

    @Test
    public void testExtractNames() {
        Exercise exercise1 = new Exercise("TestExercise1", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        Exercise exercise2 = new Exercise("TestExercise2", "Lower Body", "Legs", "Push", "Barbell", "Beginner", "Test Description");
        List<Exercise> exercises = List.of(exercise1, exercise2);

        List<String> exerciseNames = ExerciseManager.extractNames(exercises);
        assertTrue(exerciseNames.contains("TestExercise1"));
        assertTrue(exerciseNames.contains("TestExercise2"));
    }

    @Test
    public void testDisplayAllExercisesInfo() {
        // This method just prints to the console, so we can't easily test its output.
        // We can call it to ensure it doesn't throw exceptions.
        ExerciseManager.displayAllExercisesInfo();
    }
}
