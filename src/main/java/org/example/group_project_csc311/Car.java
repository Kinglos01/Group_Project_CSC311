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

    boolean flip;

    private BooleanProperty upPressed = new SimpleBooleanProperty();
    private BooleanProperty downPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();
    private BooleanProperty rightPressed = new SimpleBooleanProperty();

    private BooleanBinding findKeyPressed = upPressed.or(downPressed).or(leftPressed).or(rightPressed);



    public void movementController(ImageView image, ImageView mazeImage, AnchorPane scene, boolean flip) {
        this.image = image;
        this.scene = scene;
        this.mazeImage = mazeImage;
        this.flip = flip;

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
                if(!checkPixelColorUp()) {
                    image.setRotate(270);
                    image.setLayoutY(image.getLayoutY() - 2);
                }
            }

            if(downPressed.get()){
                if(!checkPixelColorDown()) {
                    image.setRotate(90);
                    image.setLayoutY(image.getLayoutY() + 2);
                }
            }

            if(leftPressed.get()){
                if(!checkPixelColorLeft()) {
                    image.setRotate(180);
                    image.setLayoutX(image.getLayoutX() - 2);
                }
            }

            if(rightPressed.get()){
                if(!checkPixelColorRight()) {
                    image.setRotate(0);
                    image.setLayoutX(image.getLayoutX() + 2);
                }
            }
        }
    };

    private boolean checkPixelColorUp() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(270);
        try {
            if(flip) {
                int posX = ((int) image.getLayoutX()) + 25;
                int posY = ((int) image.getLayoutY()) - 15;

                Color color = p.getColor(posX, posY);

                if (color.toString().equals("0x005399ff")) {
                    image.setRotate(org);
                    return true;
                }

            } else {
                int posX = ((int) image.getLayoutX() + 25);
                int posY = ((int) image.getLayoutY() - 20);

                Color color = p.getColor(posX, posY);

                System.out.println(color);

                if (color.toString().equals("0x003fffff")) {
                    image.setRotate(org);
                    return true;
                }
            }
        } catch(IndexOutOfBoundsException e) { }

        return false;
    }

    private boolean checkPixelColorDown() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(0);

        try {
            if(flip) {
                int posX = ((int) image.getLayoutX()) + 15;
                int posY = ((int) image.getLayoutY()) + 28;
                Color color = p.getColor(posX, posY);

                if (color.toString().equals("0x005399ff")) {
                    image.setRotate(org);
                    return true;
                }

            } else {
                int posX = ((int) image.getLayoutX() + 5);
                int posY = ((int) image.getLayoutY() + 35);

                Color color = p.getColor(posX, posY);

                System.out.println(color);

                if (color.toString().equals("0x003fffff")) {
                    image.setRotate(org);
                    return true;
                }
            }
        } catch(IndexOutOfBoundsException e) { }

        return false;
    }

    private boolean checkPixelColorLeft() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(0);

        try {
            if (flip) {

                int posX = ((int) image.getLayoutX());
                int posY = ((int) image.getLayoutY()) + 15;

                Color color = p.getColor(posX, posY);

                if (color.toString().equals("0x005399ff")) {
                    image.setRotate(org);
                    return true;
                }

            } else {
                int posX = ((int) image.getLayoutX());
                int posY = ((int) image.getLayoutY() + 10);

                Color color = p.getColor(posX, posY);

                if (color.toString().equals("0x003fffff")) {
                    image.setRotate(org);
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e) { }

        return false;
    }

    private boolean checkPixelColorRight() {
        Image maze = mazeImage.getImage();
        PixelReader p = maze.getPixelReader();
        double org = image.getRotate();

        image.setRotate(0);
        try {
            if(flip) {
                int posX = ((int) image.getLayoutX()) + 40;
                int posY = ((int) image.getLayoutY()) + 5;

                Color color = p.getColor(posX, posY);

                if (color.toString().equals("0x005399ff")) {
                    image.setRotate(org);
                    return true;
                }
            } else {
                int posX = ((int) image.getLayoutX() + 55);
                int posY = ((int) image.getLayoutY() + 5);

                Color color = p.getColor(posX, posY);

                System.out.println(color);

                if (color.toString().equals("0x003fffff")) {
                    image.setRotate(org);
                    return true;
                }
            }
        } catch(IndexOutOfBoundsException e) { }
        return false;
    }

}