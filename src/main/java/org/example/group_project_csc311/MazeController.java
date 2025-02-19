package org.example.group_project_csc311;

import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import java.awt.event.KeyEvent;
import javafx.scene.paint.Color;

public class MazeController {
    
    @FXML
    private ImageView maze;

    @FXML
    private ImageView robot;

    /**
     * Updates the current position of the robot
     */
    @FXML
    protected void positionUpdate() {
        KeyLogger keyLog = new KeyLogger();

        int robotSpeed = 10;

        if(!(pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY(), keyLog))) {
            if (keyLog.upPressed) {
                robot.setLayoutY(robot.getLayoutY() - robotSpeed);
            }
            if (keyLog.downPressed) {
                robot.setLayoutY(robot.getLayoutY() + robotSpeed);
            }
            if (keyLog.leftPressed) {
                robot.setLayoutX(robot.getLayoutX() - robotSpeed);
            }
            if (keyLog.rightPressed) {
                robot.setLayoutX(robot.getLayoutX() + robotSpeed);
            }
        }
    }

    /**
     * Checks the pixel color
     * @return true if the maze wall is in the way and false if it is not
     */
    @FXML
    private boolean pixelColor(int x, int y, KeyLogger keyLog) {
        Image mazeImage = maze.getImage();
        PixelReader p = mazeImage.getPixelReader();
        int posX = (x + 12);
        int posY = (y + 12);

        if(keyLog.upPressed) {
            posY -= 25;
        }
        if(keyLog.downPressed) {
            posY += 25;
        }
        if(keyLog.leftPressed) {
            posX -= 25;
        }
        if(keyLog.rightPressed) {
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
