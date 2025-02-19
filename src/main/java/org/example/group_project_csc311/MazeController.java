package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.*;
public class MazeController {

    @FXML
    private ImageView maze;

    KeyLogger keyLog = new KeyLogger();

    @FXML
    private ImageView robot;

    /**

    Updates the current position of the robot**/

    @FXML
    protected void positionUpdate(KeyEvent e) {

        keyLog.keyPressed(e);

        int robotSpeed = 10;

        if(!(pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY(), e))) {

            if (e.getCode() == KeyCode.W) {
                robot.translateXProperty().set(robotSpeed);
                //robot.setLayoutY(robot.getLayoutY() - robotSpeed);
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
    }

    /**

    Checks the pixel color
    @return true if the maze wall is in the way and false if it is not*/
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

    private boolean pixelColor(int x, int y) {
        Image mazeImage = maze.getImage();
        PixelReader p = mazeImage.getPixelReader();
        Color color = p.getColor(x, y);
        return color.toString().equals("0x005399ff");
    }
    /**

     Autoplay the robot*/
    @FXML
    protected void autoMove(Direction d) {
        if (d == Direction.left) {
            robot.translateXProperty().set(10);
        }
        else if (d == Direction.right) {
            robot.translateXProperty().set(-10);
        }
        else if (d == Direction.up) {
            robot.translateYProperty().set(10);
        }
        else {
            robot.translateYProperty().set(-10);
        }
    }
    @FXML
    protected void autoplay() {
        Random rnd = new Random();
        Direction[] savedMoves = new Direction[100];
        Direction[] possibleMoves = new Direction[4];
        Direction lastMove = Direction.left;
        int chosenMove;
        boolean atEnd = false;
        int index1 = 0;
        int index2 = 0;
        while (robot.getX() != 700) {
            System.out.println(index1);
            if (pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY() + 12)) {
                possibleMoves[index1] = Direction.up;
                index1++;
            }
            System.out.println(index1);
            if (pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY() - 12)) {
                possibleMoves[index1] = Direction.down;
                index1++;
            }
            System.out.println(index1);
            /*if (pixelColor((int) robot.getLayoutX() - 2, (int) robot.getLayoutY())) {
                possibleMoves[index1] = Direction.left;
                index1++;
            }*/
            System.out.println(index1);
            if (pixelColor((int) robot.getLayoutX() + 12, (int) robot.getLayoutY())) {
                possibleMoves[index1] = Direction.right;
                index1++;
            }
            System.out.println("made it thru the color check");
            if (index1 == 1 && possibleMoves[0] == lastMove) {
                while (index2 != 0) {
                    autoMove(savedMoves[index2]);
                    index2--;
                }
            } else if (index1 == 1) {
                autoMove(possibleMoves[index1]);
            } else if (index1 > 1) {
                chosenMove = rnd.nextInt(4);
                savedMoves[index2] = possibleMoves[chosenMove];
                autoMove(possibleMoves[chosenMove]);
                index2++;
            }
            index1 = 0;
            System.out.println("made it through the automove");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    @FXML
    protected void stop() {
        keyLog.keyReleased();
    }
}
