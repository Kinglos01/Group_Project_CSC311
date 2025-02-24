package org.example.group_project_csc311;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.io.IOException;

public class MazeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MazeApplication.class.getResource("robot-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500 );
        stage.setTitle("Maze");

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


}