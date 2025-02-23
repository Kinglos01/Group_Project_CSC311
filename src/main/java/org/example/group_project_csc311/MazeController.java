package org.example.group_project_csc311;

import javafx.animation.Transition;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MazeController {

    @FXML
    private ImageView maze;

    @FXML
    private AnchorPane mazePane1;

    @FXML
    private ImageView robot;

    @FXML
    private Button autoplay;

    @FXML
    private TabPane tabPane;

    @FXML
    private ImageView robot2;

    @FXML
    private AnchorPane mazePane2;

    @FXML
    private ImageView maze2;

    Car keyLog = new Car();

    /**
     * Moves the robot
     */
    public void positionUpdate() {
        //autoplay.setFocusTraversable(false);
       // tabPane.addEventFilter(KeyEvent.ANY, Event::consume);
        keyLog.movementController(robot, maze, mazePane1);
    }

    /**
     * Moves the robot
     */
    public void positionUpdate2() {
       // autoplay.addEventFilter(KeyEvent.ANY, Event::consume);
        keyLog.movementController(robot2, maze2, mazePane2);
    }

    /**
     * Autoplay the robot
     */
    @FXML
    protected void autoplay() {

    }
}
