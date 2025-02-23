package org.example.group_project_csc311;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Car extends KeyLogger {

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
                if(!checkPixelColorUp()) {
                    upPressed.set(true);
                    image.setRotate(270);
                }
            }
            if (e.getCode() == KeyCode.S) {
                if(!checkPixelColorDown()) {
                    downPressed.set(true);
                    image.setRotate(90);
                }
            }
            if (e.getCode() == KeyCode.A) {
                if(!checkPixelColorLeft()) {
                    leftPressed.set(true);
                    image.setRotate(180);
                }
            }
            if (e.getCode() == KeyCode.D) {
                if(!checkPixelColorRight()) {
                    rightPressed.set(true);
                    image.setRotate(0);
                }
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

    private boolean checkPixelColorUp() {

        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(270);

        for(int i = 0; i < 20; i++) {
            int posX = ((int) image.getLayoutX()) + i;
            int posY = ((int) image.getLayoutY()) - 38;

            Color color = p.getColor(posX, posY);

            System.out.println(color);

            if(color.toString().equals("0x005399ff") || color.toString().equals("0x003fffff")) {
                image.setRotate(org);
                return true;
            }
        }
        return false;
    }

    private boolean checkPixelColorDown() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(90);
        for(int i = 0; i < 20; i++) {
            int posX = ((int) image.getLayoutX()) - i;
            int posY = ((int) image.getLayoutY()) + 38;

            Color color = p.getColor(posX, posY);

            System.out.println(color);

            if(color.toString().equals("0x005399ff") || color.toString().equals("0x003fffff")) {
                image.setRotate(org);
                return true;
            }
        }
        return false;
    }

    private boolean checkPixelColorLeft() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(180);
        for(int i = 0; i < 20; i++) {
            int posX = ((int) image.getLayoutX()) - 38;
            int posY = ((int) image.getLayoutY()) - i;

            Color color = p.getColor(posX, posY);

            System.out.println(color);

            if(color.toString().equals("0x005399ff") || color.toString().equals("0x003fffff")) {
                image.setRotate(org);
                return true;
            }
        }
        return false;
    }

    private boolean checkPixelColorRight() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(0);
        for(int i = 0; i < 20; i++) {
            int posX = ((int) image.getLayoutX()) + 38;
            int posY = ((int) image.getLayoutY()) + i;

            Color color = p.getColor(posX, posY);

            System.out.println(color);

            if(color.toString().equals("0x005399ff") || color.toString().equals("0x003fffff")) {
                image.setRotate(org);
                return true;
            }
        }
        return false;
    }

}
