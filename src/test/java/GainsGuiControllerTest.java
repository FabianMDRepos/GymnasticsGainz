import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.TableViewMatchers;


import java.io.IOException;


import com.gymnasthub.gymnasticsgainz.*;

public class GainsGuiControllerTest extends ApplicationTest {

    private GainsGuiController controller;

    @Override
    public void start(Stage stage) {
        // Load your main FXML file and set up the scene as you do in the StageController class
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GymnasticsGains.class.getResource("GainsGui.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();

            // Get the controller instance from the FXMLLoader
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        FxToolkit.hideStage(); // This closes the JavaFX application after testing
        release(new KeyCode[]{}); // Release any keys that might be pressed to prevent issues
        release(new MouseButton[]{}); // Release any mouse buttons to prevent issues
    }


    @Test
    public void testGenerateButtonAction() {
        clickOn("#difficultyChoiceBox").clickOn("3-Build-up");
        clickOn("#generateButton");

        // Verify that the exerciseTable is not empty
        TableView<Exercise> exerciseTable = controller.getExerciseTable();
        ObservableList<Exercise> items = exerciseTable.getItems();
        assertFalse(items.isEmpty());

        // Verify that the description TextArea is empty
        TextArea descriptionTextArea = controller.getDescription();
        assertTrue(descriptionTextArea.getText().isEmpty());
    }

    @Test
    public void testDescriptionTextAreaOnClick() {
        clickOn("#difficultyChoiceBox").clickOn("3-Build-up");
        clickOn("#generateButton");

        TableView<Exercise> exerciseTable = controller.getExerciseTable();
        ObservableList<Exercise> items = exerciseTable.getItems();

        // Click on a row in the exerciseTable
        clickOn(TableViewMatchers.hasTableCell(items.get(0).getExerciseName()));

        // Verify that the description TextArea displays the exercise details
        TextArea descriptionTextArea = controller.getDescription();
        String exerciseDetails = descriptionTextArea.getText();
        assertFalse(exerciseDetails.isEmpty());
    }

    @Test
    public void testClearDescriptionTextAreaOnClick() {
        clickOn("#difficultyChoiceBox").clickOn("3-Build-up");
        clickOn("#generateButton");

        TableView<Exercise> exerciseTable = controller.getExerciseTable();

        // Click on a row in the exerciseTable (choose the first row, for example)
        int randomRowIndex = (int) (Math.random() * exerciseTable.getItems().size());
        clickOn(TableViewMatchers.hasTableCell(exerciseTable.getItems().get(randomRowIndex).getExerciseName()));

        // Verify that the description TextArea displays the exercise details
        TextArea descriptionTextArea = controller.getDescription();
        //assertFalse(descriptionTextArea.getText().isEmpty());

        // Click on a row in the exerciseTable (choose the last row)
        int lastIndex = exerciseTable.getItems().size() - 1;
        clickOn(TableViewMatchers.hasTableCell(exerciseTable.getItems().get(lastIndex).getExerciseName()));

        // Verify that the description TextArea is cleared
        assertTrue(descriptionTextArea.getText().isEmpty());
    }
    @Test
    public void testClearDescriptionTextAreaOnGenerate() {
        clickOn("#difficultyChoiceBox").clickOn("3-Build-up");
        clickOn("#generateButton");

        TableView<Exercise> exerciseTable = controller.getExerciseTable();

        // Click on a row in the exerciseTable (choose the first row, for example)
        int randomRowIndex = (int) (Math.random() * exerciseTable.getItems().size());
        clickOn(TableViewMatchers.hasTableCell(exerciseTable.getItems().get(randomRowIndex).getExerciseName()));

        // Verify that the description TextArea displays the exercise details
        TextArea descriptionTextArea = controller.getDescription();
        assertFalse(descriptionTextArea.getText().isEmpty());

        // Generate a new workout
        clickOn("#generateButton");

        // Verify that the description TextArea is cleared
        assertTrue(descriptionTextArea.getText().isEmpty());
    }


    @Test
    public void testGenerateButtonInvalidDifficulty() {
        clickOn("#generateButton");

        // Verify that the difficulty_label is set to red
        Label difficultyLabel = controller.getDifficultyLabel();
        assertEquals(Color.RED, difficultyLabel.getTextFill());
    }

    @Test
    public void testGenerateButtonValidDifficulty() {
        clickOn("#difficultyChoiceBox").clickOn("3-Build-up");
        clickOn("#generateButton");

        // Verify that the difficulty_label is set to black
        Label difficultyLabel = controller.getDifficultyLabel();
        assertEquals(Color.BLACK, difficultyLabel.getTextFill());
    }

    @Test
    public void testInitializeTableColumns() {
        TableView<Exercise> exerciseTable = controller.getExerciseTable();

        // Verify that the table columns are correctly initialized
        assertNotNull(exerciseTable.getColumns().get(0));
        assertNotNull(exerciseTable.getColumns().get(1));
        assertNotNull(exerciseTable.getColumns().get(2));
        assertNotNull(exerciseTable.getColumns().get(3));
        assertNotNull(exerciseTable.getColumns().get(4));
        assertNotNull(exerciseTable.getColumns().get(5));
        assertNotNull(exerciseTable.getColumns().get(6));
        assertNotNull(exerciseTable.getColumns().get(7));
    }
}

