package org.example.group_project_csc311;

import javafx.animation.AnimationTimer;
import javafx.fxml.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AutosolveHandler {

    protected int step;
    @FXML
    private ImageView image;

    @FXML
    private AnchorPane scene;

    @FXML
    private ImageView mazeImage;

    AnimationTimer timer = new AnimationTimer() {
        public void handle(long now) {
            switch (step) {
                case 0:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 40) {
                        step++;
                    }
                    break;
                case 1:
                    image.setLayoutY(image.getLayoutY() - 2);
                    if (image.getLayoutY() < 150) {
                        step++;
                    }
                    break;
                case 2:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 260) {
                        step++;
                    }
                    break;
                case 3:
                    image.setLayoutY(image.getLayoutY() - 2);
                    if (image.getLayoutY() < 95) {
                        step++;
                    }
                    break;
                case 4:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 320) {
                        step++;
                    }
                    break;
                case 5:
                    image.setLayoutY(image.getLayoutY() + 2);
                    if (image.getLayoutY() > 315) {
                        step++;
                    }
                    break;
                case 6:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 370) {
                        step++;
                    }
                    break;
                case 7:
                    image.setLayoutY(image.getLayoutY() - 2);
                    if (image.getLayoutY() < 210) {
                        step++;
                    }
                    break;
                case 8:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 480) {
                        step++;
                    }
                    break;
                case 9:
                    image.setLayoutY(image.getLayoutY() - 2);
                    if (image.getLayoutY() < 100) {
                        step++;
                    }
                    break;
                case 10:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 540) {
                        step++;
                    }
                    break;
                case 11:
                    image.setLayoutY(image.getLayoutY() + 2);
                    if (image.getLayoutY() > 240) {
                        step++;
                    }
                    break;
                case 12:
                    image.setLayoutX(image.getLayoutX() + 2);
                    if (image.getLayoutX() > 570) {
                        step++;
                    }
                    break;
            }
        }
    };


    public void robotSolve(ImageView image) {
        this.image = image;
        image.setLayoutY(260.0);
        image.setLayoutX(10.0);
        step = 0;

        timer.start();

    }
}
