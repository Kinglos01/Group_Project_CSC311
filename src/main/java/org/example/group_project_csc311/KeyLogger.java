package org.example.group_project_csc311;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class KeyLogger {


    @FXML
    private ImageView image;

    @FXML
    private AnchorPane scene;

    @FXML
    private ImageView mazeImage;

    private BooleanProperty upPressed = new SimpleBooleanProperty();
    private BooleanProperty downPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();
    private BooleanProperty rightPressed = new SimpleBooleanProperty();

    private BooleanBinding findKeyPressed = upPressed.or(downPressed).or(leftPressed).or(rightPressed);



    public void movementController(ImageView image, ImageView mazeImage, AnchorPane scene) {
        this.image = image;
        this.scene = scene;
        this.mazeImage = mazeImage;

        keyPressed();

        findKeyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
            } else {
                timer.stop();
            }
        }));
    }

    /**
     * Checks whether the key pressed or not
     */
    private void keyPressed() {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                upPressed.set(true);
            }
            if (e.getCode() == KeyCode.S) {
                downPressed.set(true);
            }
            if (e.getCode() == KeyCode.A) {
                leftPressed.set(true);
            }
            if (e.getCode() == KeyCode.D) {
                rightPressed.set(true);
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W) {
                upPressed.set(false);
            }
            if (e.getCode() == KeyCode.S) {
                downPressed.set(false);
            }
            if (e.getCode() == KeyCode.A) {
                leftPressed.set(false);
            }
            if (e.getCode() == KeyCode.D) {
                rightPressed.set(false);
            }
        });
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            if(upPressed.get()) {
                image.setLayoutY(image.getLayoutY() - 2);
            }

            if(downPressed.get()){
                image.setLayoutY(image.getLayoutY() + 2);
            }

            if(leftPressed.get()){
                image.setLayoutX(image.getLayoutX() - 2);
            }

            if(rightPressed.get()){
                image.setLayoutX(image.getLayoutX() + 2);
            }
        }
    };

}
