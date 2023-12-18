package com.gymnasthub.gymnasticsgainz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GainsGui.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("/path/to/your/fxmlfile.fxml")); // Update the path to your FXML file
            Scene scene = new Scene(fxmlLoader.load());
            // Set the scene and show the stage
            //primaryStage.setScene(new Scene(fxmlLoader));
            stage.setTitle("Gymnast Gainz Application"); // Set the title of the window
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}