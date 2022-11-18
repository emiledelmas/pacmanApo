package com.example.pacmanapo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import java.io.IOException;
import javafx.scene.layout.Pane;
//import random nextint
import java.util.Random;
//import AnimationTimer
import javafx.animation.AnimationTimer;
//import ArcType
import javafx.scene.shape.ArcType;
//import KeyCode
import javafx.scene.input.KeyCode;
//import KeyEvent
import javafx.scene.input.KeyEvent;
//import getKeyEvent from getGraphicsContext2D
import javafx.scene.input.KeyEvent;
public class PacmanMain extends Application {
    GraphicsContext gc;
    @Override
    public void start(Stage stage) throws IOException {
        //Create the board
        Board b = new Board(9, 9);
        //Create the pacman guy
        Pacman p = new Pacman(100, 100, 30, 1, 3, 0, 0, 0, b.getBoard(), b.getWidth(), b.getHeight());
        //Create the ghosts
        Ghost[] g = new Ghost[4];
        //g[0] = new Ghost(200, 200, 10, 1, 3, 0, 0, 0, b.getBoard(), b.getWidth(), b.getHeight());
        //g[1] = new Ghost(200, 200, 10, 1, 3, 0, 0, 0, b.getBoard(), b.getWidth(), b.getHeight());
        //g[2] = new Ghost(200, 200, 10, 1, 3, 0, 0, 0, b.getBoard(), b.getWidth(), b.getHeight());
        //g[3] = new Ghost(200, 200, 10, 1, 3, 0, 0, 0, b.getBoard(), b.getWidth(), b.getHeight());
        var root = new Pane();
        //Draw the board
        Canvas canvas = new Canvas(500, 500);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillRect(0, 0, 500, 500);
        //Draw the pacman in yellow
        gc.setFill(javafx.scene.paint.Color.YELLOW);

        gc.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
        //canvas.getGraphicsContext2D().fillOval(p.getX(), p.getY(), p.getSize(), p.getSize(),);

            //Draw the pacman in yellow
            gc.setFill(javafx.scene.paint.Color.YELLOW);
            gc.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
        System.out.println("HERE");
            //canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
                //System.out.println("Mouse Clicked: " + e.getX() + ", " + e.getY());
                //p.setX((int) e.getX());
                //p.setY((int) e.getY());
            //});
        //handles key arrows on the keyboard
        //canvas.getGraphicsContext2D().fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());

        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                //Declare e as the keyboard current key pressed
                //Random rand = new Random();
                //int randInt = rand.nextInt(500);
                //p.setX(randInt);
                //p.setY(randInt);
                gc.setFill(javafx.scene.paint.Color.BLACK);
                gc.fillRect(0, 0, 500, 500);
                gc.setFill(javafx.scene.paint.Color.YELLOW);
                //gc.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
                //draw ArcType.ROUND for pacman
                if (p.getDirection() == 0){
                    if (p.getY()+p.getSpeed() > 470){
                        //p.setY(485);
                    }
                    else{
                        p.setY(p.getY()+p.getSpeed());
                    }
                    //p.setY(p.getY() + p.getSpeed());

                }
                else if (p.getDirection() == 1){
                    p.setY(p.getY() - p.getSpeed());
                }
                else if (p.getDirection() == 2){
                    if (p.getX() - p.getSpeed() < -15){
                        p.setX(515);
                    }
                    else{
                        p.setX(p.getX() - p.getSpeed());
                    }
                    //p.setX(p.getX() - p.getSpeed());
                }
                else if (p.getDirection() == 3){
                    p.setX(p.getX() + p.getSpeed());
                }
                //p.setX(p.getX() + 2);
                //p.setY(p.getY() + 1);
                //System.out.println("HERE");
                if (p.getDirection() == 3){
                    gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 45, 280, ArcType.ROUND);
                }
                else if (p.getDirection() == 2){
                    gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 225, 280, ArcType.ROUND);
                }
                else if (p.getDirection() == 0){
                    gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 315, 280, ArcType.ROUND);
                }
                else if (p.getDirection() == 1){
                    gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 135, 280, ArcType.ROUND);
                }
                //gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 0, 315 , ArcType.ROUND);

            }
        }.start();
        //Show the window
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 500, 500);
        scene.setOnKeyPressed((KeyEvent event) -> { // Create a key event that execute when any key pressed from your keyboard
            if (event.getCode() == KeyCode.UP) { // If the key pressed is the up arrow
                p.setDirection(1);
            }
            else if (event.getCode() == KeyCode.DOWN) { // If the key pressed is the down arrow
                p.setDirection(0);
            }
            else if (event.getCode() == KeyCode.LEFT) { // If the key pressed is the left arrow
                p.setDirection(2);
            }
            else if (event.getCode() == KeyCode.RIGHT) { // If the key pressed is the right arrow
                p.setDirection(3);
            }
        });
        //Scene scene = new Scene(canvas, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}