package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MazeController {
    
    @FXML
    private ImageView maze;

    @FXML
    private ImageView robot;

    @FXML
    protected void positionUpdate() {

        KeyLogger keyLog = new KeyLogger();

        int RobotSpeed = 10;

        if(keyLog.upPressed) {
            robot.setY(robot.getY() + RobotSpeed);
        }
        if(keyLog.downPressed) {
            robot.setY(robot.getY() - RobotSpeed);
        }
        if(keyLog.leftPressed) {
            robot.setX(robot.getX() - RobotSpeed);
        }
        if(keyLog.rightPressed) {
            robot.setX(robot.getX() + RobotSpeed);
        }
    }
}