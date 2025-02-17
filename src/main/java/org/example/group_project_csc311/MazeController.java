package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MazeController {
    
    @FXML
    private ImageView maze;

    @FXML
    private ImageView robot;

    Keylogger KeyLog = new Keylogger();
    int RobotSpeed = 1;
    int RobotY;
    int RobotX;

    public void PostionUpdate() {
        if(KeyLog.upPressed == true) {
            RobotY =- RobotSpeed;
        }
        if(KeyLog.downPressed == true) {
            RobotY =+ RobotSpeed;
        }
        if(KeyLog.leftPressed == true) {
            RobotX =- RobotSpeed;
        }
        if(KeyLog.rightPressed == true) {
            RobotX =+ RobotSpeed;
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }
}