package org.example.group_project_csc311;

import javafx.animation.Transition;
import javafx.fxml.FXML;

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

    KeyLogger keyLog = new KeyLogger();

    @FXML
    private ImageView robot;

    /**
     * Moves the robot
     */
    public void positionUpdate() {
        keyLog.movementController(robot, mazePane1);
    }

    /**
     * Checks the pixel color
     * @return true if the maze wall is in the way and false if it is not
     */
    @FXML
    private boolean pixelColor(int x, int y, KeyEvent e) {
        Image mazeImage = maze.getImage();
        PixelReader p = mazeImage.getPixelReader();
        //get the middle of the image
        int posX = x + ((int) robot.getFitWidth() / 2);
        int posY = y + ((int) robot.getFitHeight() / 2);

        if(e.getCode() == KeyCode.W) {
            posY -= 25;
        }
        if(e.getCode() == KeyCode.S) {
            posY += 25;
        }
        if(e.getCode() == KeyCode.A) {
            posX -= 25;
        }
        if(e.getCode() == KeyCode.D) {
            posX += 25;
        }

        Color color = p.getColor(posX, posY);

        return (color.toString()).equals("0x005399ff");

    }

    /**
     * Autoplay the robot
     */
    @FXML
    protected void autoplay() {

    }
}
