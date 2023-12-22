import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.gymnasthub.gymnasticsgainz.Exercise;

public class ExerciseTest {

    @Test
    public void testGetExerciseName() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("TestExercise", exercise.getExerciseName());
    }

    @Test
    public void testGetMuscleGroup() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("Upper Body", exercise.getMuscleGroup());
    }

    @Test
    public void testGetBodyPart() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("Chest", exercise.getBodyPart());
    }

    @Test
    public void testGetExerciseDirection() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("Push", exercise.getExerciseDirection());
    }

    @Test
    public void testGetExerciseEquipment() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("Barbell", exercise.getExerciseEquipment());
    }

    @Test
    public void testGetExerciseDifficulty() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("Intermediate", exercise.getExerciseDifficulty());
    }

    @Test
    public void testGetRepetitions() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        exercise.setRepetitions(10);
        assertEquals(10, exercise.getRepetitions());
    }

    @Test
    public void testGetSets() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        exercise.setSets(3);
        assertEquals(3, exercise.getSets());
    }

    @Test
    public void testDisplayDescription() {
        Exercise exercise = new Exercise("TestExercise", "Upper Body", "Chest", "Push", "Barbell", "Intermediate", "Test Description");
        assertEquals("TestExercise:\nTest Description", exercise.displayDescription());
    }
}
