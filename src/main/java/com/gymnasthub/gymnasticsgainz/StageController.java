package com.gymnasthub.gymnasticsgainz;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StageController {

    public StageController(Stage stage) {

        try {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(GymnasticsGains.class.getResource("GainsGui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image( "file:Logo.png" ));
        scene.getStylesheets().add(getClass().getResource("DesktopStyleSheet.css").toExternalForm());
        // Set the scene and show the stage
        stage.setTitle("Gymnast Gainz Application"); // Set the title of the window
        stage.setScene(scene);


        stage.setWidth(1160);
        stage.setHeight(600);

        stage.setMinWidth(1160);
        stage.setMinHeight(600);

        stage.setMaxWidth(1160);
        stage.setMaxHeight(600);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}