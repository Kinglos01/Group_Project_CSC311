# Overview

A maze application designed with 2 panes which uses pixel color detection to keep itself within the bounds of the area. The mazes can also be played all as one animation by clicking on the autoplay button. This was acheived by using JavaFX and FXML.

### Movement

The movement of the application is done using KeyEvents through the created KeyLogger class. By detecting when the player holds and lets go of the button the car moves in the direction pressed on a timer.

### Walls Detection

The maze application includes walls detection which is implented through the PixelReader class. By reading the colors of the pixels of the area around the car, the car stays within the bounds of the maze.

### Autoplay

The maze is able to be autoplayed by clicked on the autoplay button in the bottom right corner of both mazes. The autoplay button plays an animation of the car driving from the start to the finish.

### Car

The class that handles both the movement and the special proporities for the playable car image. By extending KeyLogger the Car class keeps all the original movement while also adding calls to turn the heading depending on the direction pushed

## Contributors 

Nathaniel Rivera, Riiel-edu
28 commits, 1,121++, 671--

Aidan Rodriguez, jabaltariq
9 commits, 607++, 173--

Carlos Berio, Kinglos01
4 commits, 887++, 98--
