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
        canvas.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    p.setDirection(0);
                    break;
                case DOWN:
                    p.setDirection(1);
                    break;
                case LEFT:
                    p.setDirection(2);
                    break;
                case RIGHT:
                    p.setDirection(3);
                    break;
            }
        });
        //canvas.getGraphicsContext2D().fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
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
                    p.setY(p.getY() + p.getSpeed());
                }
                else if (p.getDirection() == 1){
                    p.setY(p.getY() - p.getSpeed());
                }
                else if (p.getDirection() == 2){
                    p.setX(p.getX() - p.getSpeed());
                }
                else if (p.getDirection() == 3){
                    p.setX(p.getX() + p.getSpeed());
                }
                //p.setX(p.getX() + 2);
                //p.setY(p.getY() + 1);
                System.out.println("HERE");
                gc.fillArc(p.getX(), p.getY(), p.getSize(), p.getSize(), 0, 315 , ArcType.ROUND);

            }
        }.start();
        //Show the window
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 500, 500);
        //Scene scene = new Scene(canvas, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}