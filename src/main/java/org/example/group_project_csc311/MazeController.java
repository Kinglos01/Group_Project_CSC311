package org.example.group_project_csc311;

import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class MazeController {
    
    @FXML
    private ImageView maze;

    KeyLogger keyLog = new KeyLogger();

    @FXML
    private ImageView robot;

    /**
     * Updates the current position of the robot
     */
    @FXML
    protected void positionUpdate(KeyEvent e) {

        keyLog.keyPressed(e);

        int robotSpeed = 10;

        try {
            if (!(pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY(), e))) {

                if (e.getCode() == KeyCode.W) {
                    keyLog.keyPressed(e);
                    robot.setLayoutY(robot.getLayoutY() - robotSpeed);
                }
                if (e.getCode() == KeyCode.S) {
                    robot.setLayoutY(robot.getLayoutY() + robotSpeed);
                }
                if (e.getCode() == KeyCode.A) {
                    robot.setLayoutX(robot.getLayoutX() - robotSpeed);
                }
                if (e.getCode() == KeyCode.D) {
                    robot.setLayoutX(robot.getLayoutX() + robotSpeed);
                }
            }
        } catch(IndexOutOfBoundsException error) { }
    }

    /**
     * Checks the pixel color
     * @return true if the maze wall is in the way and false if it is not
     */
    @FXML
    private boolean pixelColor(int x, int y, KeyEvent e) {
        Image mazeImage = maze.getImage();
        PixelReader p = mazeImage.getPixelReader();
        int posX = (x + 12);
        int posY = (y + 12);

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

    @FXML
    protected void stop() {
        keyLog.keyReleased();
    }
}
