package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.*;
public class MazeController {

    @FXML
    private ImageView maze;

    KeyLogger keyLog = new KeyLogger();

    @FXML
    private ImageView robot;

    final int robotSpeed = 25;
    /**

    Updates the current position of the robot**/

    @FXML
    protected void positionUpdate(KeyEvent e) {

        keyLog.keyPressed(e);



        if(!(pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY(), e))) {

            if (e.getCode() == KeyCode.W) {
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
        Color color = null;
        try {
            color = p.getColor(x, y);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds!");
            return false;
        }
        return color.toString().equals("0x005399ff");
    }
    /**

     Autoplay the robot*/
    @FXML
    protected void autoMove(Direction d) {
        switch (d) {
            case left:
                robot.setLayoutX(robot.getLayoutX() - robotSpeed);
                System.out.println("moved left");
                break;
            case right:
                robot.setLayoutX(robot.getLayoutX() + robotSpeed);
                System.out.println("moved right");
                break;
            case up:
                robot.setLayoutY(robot.getLayoutY() - robotSpeed);
                System.out.println("moved up");
                break;
            case down:
                robot.setLayoutY(robot.getLayoutY() + robotSpeed);
                System.out.println("moved down");
                break;
            default:
                System.out.println("automove failed!");
        }
        System.out.println("automove done");
    }

    @FXML
    protected Direction oppositeMove(Direction d) {
        switch (d) {
            case left:
                return Direction.right;
            case right:
                return Direction.left;
            case up:
                return Direction.down;
            case down:
                return Direction.up;
            default:
                return null;
        }
    }
    @FXML
    protected void autoplay() {
        Random rnd = new Random();
        Direction[] savedMoves = new Direction[100];
        Direction[] possibleMoves = new Direction[4];
        Direction lastMove = Direction.left;
        int chosenMove;
        boolean travellingState = false;
        boolean atEnd = false;
        Direction nextMove;
        int index1 = 0;
        int index2 = 0;
        boolean done = false;
        while (robot.getX() <= 700 && !done) {
            if (pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY() - 20)) {
                possibleMoves[index1] = Direction.up;
                index1++;
            };
            if (pixelColor((int) robot.getLayoutX(), (int) robot.getLayoutY() + 20)) {
                possibleMoves[index1] = Direction.down;
                index1++;
            }
            if (pixelColor((int) robot.getLayoutX() - 20, (int) robot.getLayoutY() - 16)) {
                possibleMoves[index1] = Direction.left;
                index1++;
            }
            if (pixelColor((int) robot.getLayoutX() + 20, (int) robot.getLayoutY() - 16)) {
                possibleMoves[index1] = Direction.right;
                index1++;
            }

            System.out.println("possible moves: " + index1);

            if (index1 == 1) {
                if (lastMove == possibleMoves[0]) {
                    travellingState = false;
                    while (index2 != 0) {
                        index2--;
                    }
                }
                else {
                    lastMove = possibleMoves[0];
                    autoMove(possibleMoves[0]);
                    if (travellingState == true) {
                        savedMoves[index2] = lastMove;
                        index2++;
                    }
                }

            }
            else if (index1 > 1) {
                do {
                    nextMove = possibleMoves[rnd.nextInt(index1)];
                } while (nextMove == lastMove);
                lastMove = nextMove;
                autoMove(nextMove);
            }
            index1 = 0;

            done = true;
        }
    }

    @FXML
    protected void stop() {
        keyLog.keyReleased();
    }
}
