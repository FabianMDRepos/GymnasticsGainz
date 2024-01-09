package com.gymnasthub.gymnasticsgainz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;


public class GainsGuiController {

    @FXML
    public TextArea description;
    public Label difficulty_label;
    @FXML
    private Button generateButton;
    @FXML
    private ChoiceBox<String> difficultyChoiceBox;
    @FXML
    private TableView<Exercise> exerciseTable;
    @FXML
    private TableColumn<Exercise, String> nameColumn;
    @FXML
    private TableColumn<Exercise, String> muscleGroupColumn;
    @FXML
    private TableColumn<Exercise, String> bodyPartColumn;
    @FXML
    private TableColumn<Exercise, String> directionColumn;
    @FXML
    private TableColumn<Exercise, String> equipmentColumn;
    @FXML
    private TableColumn<Exercise, String> difficultyColumn;
    @FXML
    private TableColumn<Exercise, Integer> setsColumn;
    @FXML
    private TableColumn<Exercise, Integer> repsColumn;


    @FXML
    public void initialize() {
        // Initialize ExerciseManager
        ExerciseManager exerciseManager = new ExerciseManager();

        // Set up the columns in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseName"));
        muscleGroupColumn.setCellValueFactory(new PropertyValueFactory<>("muscleGroup"));
        bodyPartColumn.setCellValueFactory(new PropertyValueFactory<>("bodyPart"));
        directionColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseDirection"));
        equipmentColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseEquipment"));
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseDifficulty"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<>("Sets"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<>("Repetitions"));

        // Set up difficulty choice box
        difficultyChoiceBox.getItems().addAll("1-Deload", "2-Maintain", "3-Build-up", "4-Peak");

        generateButton.setOnAction(this::handleGenerateAction);
        //difficultyChoiceBox.set TODO create handler to change label back to black when option is selected
        //exerciseTable.setOnMouseClicked();
        initializeTableFactory();

    }

    @FXML
    private void handleGenerateAction(ActionEvent event) {
        // Handle generate button click
        String selectedDifficulty = difficultyChoiceBox.getValue();

        difficulty_label.setTextFill(selectedDifficulty != null ? Color.BLACK : Color.RED);
        if (selectedDifficulty != null) {
            description.clear();
            Workout workout = new Workout();
            workout.generateWorkout(selectedDifficulty);
            ObservableList<Exercise> generatedExercises = FXCollections.observableArrayList(workout.getGeneratedExercises());
            exerciseTable.setItems(generatedExercises);
        }
    }


    private void initializeTableFactory() {
        exerciseTable.setRowFactory(tv -> {
            TableRow<Exercise> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Exercise exercise = row.getItem();
                    if (exercise != null) {
                        String exerciseDetails = exercise.displayDescription();
                        description.setText(exerciseDetails);
                    }
                }else {
                    description.clear();
                    exerciseTable.getSelectionModel().clearSelection();
                }
            });
            return row;
        });
    }

    public void showDescription(MouseEvent event) {
        if (event.getClickCount() == 1) { // Check for a single click
            Exercise selectedExercise = exerciseTable.getSelectionModel().getSelectedItem();
            if (selectedExercise != null) {
                // Get the exercise details as a String
                String exerciseDetails = selectedExercise.toString();

                // Set the text of the TextArea to the exercise details
                description.setText(exerciseDetails);
            }
        }
    }

    // Getters for testing TODO Consider inheritance to mask
    public TextArea getDescription() {return description;}
    public Label getDifficultyLabel() {return difficulty_label;}
    public TableView<Exercise> getExerciseTable() {return exerciseTable;}


}
