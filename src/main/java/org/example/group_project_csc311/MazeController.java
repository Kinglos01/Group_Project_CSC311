package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MazeController {

    @FXML
    private ImageView maze;

    @FXML
    private AnchorPane mazePane1;

    @FXML
    private ImageView robot;

    @FXML
    private ImageView robot2;

    @FXML
    private AnchorPane mazePane2;

    @FXML
    private ImageView maze2;

    Car keyLog = new Car();
    Car keyLog2 = new Car();

    /**
     * Moves the robot
     */
    public void positionUpdate() {
        keyLog.movementController(robot, maze, mazePane1, true);
    }

    /**
     * Moves the robot
     */
    public void positionUpdate2() {
        keyLog2.movementController(robot2, maze2, mazePane2, false);
    }

    /**
     * Autoplay the robot
     */
    @FXML
    protected void autoplay() {

    }
}