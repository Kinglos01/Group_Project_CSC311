package org.example.group_project_csc311;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class MazeController {

    public static final int robotSpeed = 25;

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
        keyLog.movementController(robot, maze, mazePane1);
    }

    /**
     * Moves the robot
     */
    public void positionUpdate2() {
        keyLog2.movementController(robot2, maze2, mazePane2);
    }

    /**
     * Autoplay the robot
     */
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

    // old autosolver code just in case i need it
    /*
    Direction lastMove;
    Direction[] savedMoves = new Direction[100];
    Direction[] possibleMoves = new Direction[4];
    Direction nextMove;
    @FXML
    protected void autoplay() {
        Random rnd = new Random();
        boolean travellingState = false;
        int index1;
        int index2 = 0;
        boolean done = false;
        while (robot.getX() <= 700 && !done) {
            index1 = 0;
            if (pixelColor((int) robot.getLayoutX() + 12, (int) robot.getLayoutY() - 10)) {
                possibleMoves[index1] = Direction.up;
                System.out.println("possible move: up");
                index1++;
            }
            if (pixelColor((int) robot.getLayoutX() + 12, (int) robot.getLayoutY() + 36)) {
                possibleMoves[index1] = Direction.down;
                System.out.println("possible move: down");
                index1++;
            }
            if (pixelColor((int) robot.getLayoutX() - 16, (int) robot.getLayoutY() + 12)) {
                possibleMoves[index1] = Direction.left;
                System.out.println("possible move: left");
                index1++;
            }
            if (pixelColor((int) robot.getLayoutX() + 46, (int) robot.getLayoutY() + 12)) {
                possibleMoves[index1] = Direction.right;
                System.out.println("possible move: right");
                index1++;
            }

            System.out.println("possible moves: " + index1);
            if (index1 == 1) {
                lastMove = oppositeMove(possibleMoves[0]);
                autoMove(possibleMoves[0]);
            }
            else {
                nextMove = possibleMoves[rnd.nextInt(index1)];
                while (nextMove == lastMove) {
                    nextMove = possibleMoves[rnd.nextInt(index1)];
                }
                lastMove = oppositeMove(nextMove);
                autoMove(nextMove);

            }
            System.out.println(lastMove);
            done = true;
        }
    }*/
}