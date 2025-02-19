package org.example.group_project_csc311;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLogger implements KeyListener {


    boolean upPressed, downPressed, leftPressed, rightPressed;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Sets key pressed to true
     * @KeyEvent the key being pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

    }

    /**
     * Sets key pressed to false
     * @KeyEvent the key being pressed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

    }
}
