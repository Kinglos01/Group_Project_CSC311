package org.example.group_project_csc311;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.KeyListener;


public class KeyLogger {


    boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
     * Sets key pressed to true
     *
     * @KeyEvent the key being pressed
     **/
    public void keyPressed(KeyEvent e) {

        if (e.getCode() == KeyCode.UP) {
            upPressed = true;
        }
        if (e.getCode() == KeyCode.DOWN) {
            downPressed = true;
        }
        if (e.getCode() == KeyCode.LEFT) {
            leftPressed = true;
        }
        if (e.getCode() == KeyCode.RIGHT) {
            rightPressed = true;
        }

    }

    /**
     * Sets key pressed to false
     *
     * @KeyEvent the key being pressed
     */
    public void keyReleased() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

    }
}
