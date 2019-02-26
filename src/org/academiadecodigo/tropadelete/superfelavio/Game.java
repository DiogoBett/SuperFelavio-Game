package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

public class Game {

    private Player felavio;
    private Cats[] cats;
    private Rectangle canvas;

    public Game(Player felavio, Cats[] cats) {
        this.felavio = felavio;
        this.cats = cats;
    }

    public void start() {

        this.canvas = new Rectangle(10, 10, 1500, 800);
        canvas.draw();
        Line ground = new Line(10,750,1510,750);
        ground.draw();
        felavio.objectDraw();
        new KeyboardListener(felavio);
        for (int i = 0 ; i < cats.length ; i++){
            //spawn
            cats[i].objectDraw();
        }
        run();
    }

    private void run(){
        while (true) {
            try {

                felavio.move();
                Thread.sleep(50);
            }catch (Exception e){
                System.out.println("sleep failed");
            }


            for (int i = 0; i < cats.length; i++) {

                cats[i].move();

            }
        }
    }
}
