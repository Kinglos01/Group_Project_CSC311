package org.example.group_project_csc311;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class KeyLogger {


    boolean upPressed, downPressed, leftPressed, rightPressed;

    /**
     * Sets key pressed to true
     * @KeyEvent the key being pressed
     */
    public void keyPressed(KeyEvent e) {

        if(e.getCode() == KeyCode.W) {
            upPressed = true;
        }
        if(e.getCode() == KeyCode.S) {
            downPressed = true;
        }
        if(e.getCode() == KeyCode.A) {
            leftPressed = true;
        }
        if(e.getCode() == KeyCode.D) {
            rightPressed = true;
        }

    }

    /**
     * Sets key pressed to false
     * @KeyEvent the key being pressed
     */
    public void keyReleased() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

    }


}
