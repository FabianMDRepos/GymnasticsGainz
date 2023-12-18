package com.gymnasthub.gymnasticsgainz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GainsGuiController {


        @FXML
        private Button generateButton;

        @FXML
        private ChoiceBox<String> difficultyChoiceBox;

        @FXML
        private Label titleLabel;

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

        private ExerciseManager exerciseManager;
        private Workout workout;

    @FXML
    public void initialize() {
        // Initialize ExerciseManager
        exerciseManager = new ExerciseManager();

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
    }

    @FXML
    private void handleGenerateAction(ActionEvent event) {
        // Handle generate button click
        String selectedDifficulty = difficultyChoiceBox.getValue();
        if (selectedDifficulty != null) {
            Workout workout = new Workout();
            workout.generateWorkout(selectedDifficulty);
            ObservableList<Exercise> generatedExercises = FXCollections.observableArrayList(workout.getGeneratedExercises());
            exerciseTable.setItems(generatedExercises);
        }
    }
    }
